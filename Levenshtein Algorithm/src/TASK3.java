import java.util.*;
public class TASK3 {
    public static int EditDistance(String s1, String s2, int Ci, int Cd, int Cs) {
        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++)
            dp[i][0] = i * Cd;
        for (int j = 0; j <= n; j++)
            dp[0][j] = j * Ci;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == (s2.charAt(j - 1)))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.min(
                            dp[i - 1][j - 1] + Cs,
                            Math.min(
                                    dp[i - 1][j] + Cd,
                                    dp[i][j - 1] + Ci
                            )
                    );
            }
        }

        return dp[m][n];
    }

    public static List<String> getSuggestions(String input, String[] dictionary, int Ci, int Cd, int Cs) {
        List<String> suggestions = new ArrayList<>();
        int minDistance = Integer.MAX_VALUE;

        for (String word : dictionary) {
            int distance = EditDistance(input, word, Ci, Cd, Cs);
            if (distance < minDistance) {
                suggestions.clear();
                suggestions.add(word);
                minDistance = distance;
            } else if (distance == minDistance) {
                suggestions.add(word);
            }
        }

        return suggestions;
    }

    public static void main(String[] args) {
        String[] dictionary = {"cred", "bet", "shat", "that", "brad", "cart", "brat", "card"};
        List<String> suggestions = getSuggestions("dat", dictionary, 1, 1, 1);
        System.out.println(suggestions);
    }
}
