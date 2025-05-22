public class TASK1 {
    public static int EditDistance(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m + 1][n + 1];

        // Base cases: converting to/from empty string
        for (int i = 0; i <= m; i++)
            dp[i][0] = i;
        for (int j = 0; j <= n; j++)
            dp[0][j] = j;

        // Fill DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = 1 + Math.min(
                            dp[i - 1][j - 1], // substitution
                            Math.min(
                                    dp[i - 1][j], // deletion
                                    dp[i][j - 1]  // insertion
                            )
                    );
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(EditDistance("kitten", "sitting"));  // 3
        System.out.println(EditDistance("flaw", "lawn"));      // 2
        System.out.println(EditDistance("algorithm", "logarithm")); // 3
    }
}
