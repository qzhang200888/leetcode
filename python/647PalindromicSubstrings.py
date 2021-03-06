class Solution:
    def countSubstrings(self, s: str) -> int:
        count = 0
        dp = [[0  for _ in range(len(s))] for _ in range(len(s))]
        for i in range(len(s)):
            dp[i][i] = 1
            
        count = len(s)
        for i in range(len(s) - 2, -1, -1):                
            for j in range(i + 1, len(s)):
                if s[i] == s[j]:
                    if j - i < 3:
                        dp[i][j] = 1
                        count += 1
                    else:
                        dp[i][j] = dp[i + 1][j - 1]
                        if dp[i][j] == 1:
                            count += 1

        return count
