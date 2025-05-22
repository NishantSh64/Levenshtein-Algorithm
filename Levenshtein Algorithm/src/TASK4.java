import java.util.*;

public class TASK4 {

    // Space-optimized Edit Distance function
    public static int EditDistance(String s1, String s2, int Ci, int Cd, int Cs) {
        int m = s1.length();
        int n = s2.length();

        // Ensure s1 is always the longer string to save space
        if (m < n) {
            String temp = s1;
            s1 = s2;
            s2 = temp;
            int t = m;
            m = n;
            n = t;
        }

        int[] prev = new int[n + 1];
        int[] curr = new int[n + 1];

        // Initialize first row
        for (int j = 0; j <= n; j++)
            prev[j] = j * Ci;

        // Fill DP table row by row
        for (int i = 1; i <= m; i++) {
            curr[0] = i * Cd;

            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    curr[j] = prev[j - 1];
                else
                    curr[j] = Math.min(
                            prev[j - 1] + Cs,
                            Math.min(
                                    prev[j] + Cd,
                                    curr[j - 1] + Ci
                            )
                    );
            }

            // Swap prev and curr arrays for next iteration
            int[] temp = prev;
            prev = curr;
            curr = temp;
        }

        return prev[n];
    }

    // Suggest closest words from dictionary based on minimum edit distance
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

    // Driver method to test the spell checker
    public static void main(String[] args) {
        String[] dictionary = {"cred", "bet", "shat", "that", "brad", "cart", "brat", "card"};
        List<String> suggestions = getSuggestions("dat", dictionary, 1, 1, 1);
        System.out.println("Suggestions: " + suggestions);
    }
}