Levenshtein Distance
  Task 1: Implement the Levenshtein Algorithm
    Implement the Algorithm
    You are given two strings, s1 and s2. Your task is to implement a function EditDistance(s1, s2) that computes the
    minimum cost to transform s1 into s2. The minimum cost is the smallest total cost of a sequence of operations
    (insertions, deletions, and substitutions) required to convert s1 into s2, where each operation has a cost of 1.
    Function Signature:
    int EditDistance (string s1, string s2);
    Constraints:
    • m, n ≤ 1000 (The lengths of s1 and s2 are at most 1000 characters).
    Your code should be written in the programming language of your choice.
    Upload Snapshots of Output After Testing the Code
    Apply your function to the following test cases:
    • Input: "kitten", "sitting"
    Expected Output: 3
    • Input: "flaw", "lawn"
    Expected Output: 2
    • Input: "algorithm", "logarithm"
    Expected Output: 3
    Please upload snapshots of the expected output for each of the above test cases.
    Once the output snapshots are confirmed, submit the code for further review.
    ![TASK1 output](https://github.com/user-attachments/assets/d7152623-99ea-4c7e-a20c-301ca8df1dc9)

  Task 2: Minimum Weighted Edit Distance Calculation
    Implement the Cost-Constrained Algorithm
    You are given two strings, s1 and s2, and the respective costs for three types of operations: insertion, deletion,
    and substitution. Your task is to compute the minimum weighted edit distance between these two strings.
    The minimum weighted edit distance is the smallest total cost required to transform s1 into s2, considering the
    following operation costs:
    • Insertion: The cost of inserting a character into s1 to match a character in s2 is denoted as Ci.
    • Deletion: The cost of deleting a character from s1 to match s2 is denoted as Cd.
    • Substitution: The cost of replacing a character in s1 with one from s2 is denoted as Cs.
    Function Signature:
    int EditDistance(string s1, string s2, int Ci, int Cd, int Cs);
    Constraints:
    • m, n ≤ 1000 (The lengths of s1 and s2 are at most 1000 characters).
    • 1 ≤ Ci, Cd, Cs ≤ 1000 (Cost values for operations).

    Test Cases
    Apply your function to the following test cases:
    • Input: "kitten", "sitting", Ci=1, Cd=2, Cs=3
    Expected Output: 7
    • Input: "flaw", "lawn", Ci=2, Cd=2, Cs=1
    Expected Output: 4
    • Input: "algorithm", "logarithm", Ci=1, Cd=3, Cs=2
    Expected Output: 6
    Please upload snapshots of the expected output for each of the above test cases.
    Once the output snapshots are confirmed, submit the code for further review.
    ![TASK2 Output](https://github.com/user-attachments/assets/1b211fa0-3bf8-4dc9-8fb3-a8ecf1547047)

  Task 3: Apply It to a Real Problem
    Let's say you are required to build a spell-checker for a text editor. Using the levenshteinDistance function, write
    a program that suggests the closest word from a dictionary for a given input.
    Example:
    • Dictionary: ["cred", "bet", "shat", "that", "brad", "cart", "brat", "card"]
    • Ci=1, Cd=1, Cs=1
    • Input: "dat"
    • Expected Output: "bet", "shat", "that", "cart", "brat"
    Please submit the code in the programming language of your choice.
    ![TASK3 Output](https://github.com/user-attachments/assets/52667bbd-1613-4a3c-9d17-7ca2bc7b18da)

  Task 4: Optimization Task (Bonus)
    The Levenshtein algorithm typically uses a dynamic programming (DP) table of size n×m, where n and m are the
    lengths of the two strings. This requires:
    • Time complexity: O(n×m) for filling up the DP table.
    • Space complexity: O(n×m) for storing the table.
    For very large strings, this approach may:
    • Use too much memory to store the DP table.
    • Take too long to compute the result.
    ![TASK4 Output](https://github.com/user-attachments/assets/dcdbe4cd-2943-482c-aff2-9a63effeeda7)
    Explaination of this Optimization
     Problem:
        The Levenshtein Distance DP solution uses:
        
        Time Complexity: O(n×m)
        
        Space Complexity: O(n×m) — because we maintain a 2D dp table.
        
        For large strings, the space becomes a problem.
        
        Insight:
        If you notice carefully —
        To compute dp[i][j], you only need:
        
        dp[i-1][j-1]
        
        dp[i-1][j]
        
        dp[i][j-1]
        
        Meaning — only the current row and the previous row are needed at any time.
        So instead of a full n × m table, we can optimize to use just two 1D arrays.
        
        Optimized Space Approach
        Space Complexity: O(min(n, m))
        (based on whichever string is shorter — since rows can be swapped)
        
        Idea:
        Maintain two arrays:
        
        prev[] → to represent dp[i-1][*]
        
        curr[] → to represent dp[i][*]
        
        Update them as you iterate.





