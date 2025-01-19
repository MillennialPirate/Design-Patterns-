class Solution {
    public boolean helper(String s1, String s2, String s3, int i, int j, int[][] dp)
    {
        if(dp[i][j] != -1)
            return dp[i][j] == 1; 
        if(i == s1.length() && j == s2.length()){
            dp[i][j] = 1; 
            return true; 
        }

        int k = i + j; 
        if(i < s1.length() && j < s2.length() && s1.charAt(i) == s3.charAt(k) && s2.charAt(j) == s3.charAt(k)){
            boolean res = helper(s1, s2, s3, i, j+1, dp) | helper(s1, s2, s3, i+1, j, dp);
            dp[i][j] = res ? 1 : 0; 
            return res;
        } 
        else if(i < s1.length() && s1.charAt(i) == s3.charAt(k)){
            boolean res = helper(s1, s2, s3, i+1, j, dp); 
            dp[i][j] = res ? 1 : 0; 
            return res;
        }
        else if(j < s2.length() && s2.charAt(j) == s3.charAt(k)){
            boolean res = helper(s1, s2, s3, i, j+1, dp); 
            dp[i][j] = res ? 1 : 0; 
            return res;
        }
        dp[i][j] = 0; 
        return false; 
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length())
            return false; 
        int m = s1.length(), n = s2.length(); 
        int[][] dp = new int[m+1][n+1]; 
        for(int i = 0; i <= m; i++)
            Arrays.fill(dp[i], -1);

        return helper(s1, s2, s3, 0, 0, dp); 
    }
}
