public class TASK2 {

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
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
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

    public static void main(String[] args) {
        System.out.println(EditDistance("kitten", "sitting", 1, 2, 3));  // 7
        System.out.println(EditDistance("flaw", "lawn", 2, 2, 1));       // 4
        System.out.println(EditDistance("algorithm", "logarithm", 1, 3, 2)); // 6
    }
}
