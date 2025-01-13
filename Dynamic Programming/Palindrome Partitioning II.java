class Solution {
    public boolean isPalindrome(String sub)
    {
        int l = 0, r = sub.length()-1; 
        while(r >= l)
        {
            if(sub.charAt(l) != sub.charAt(r))
                return false; 
            r--; 
            l++; 
        }
        return true; 
    }
    public int helper(String s, int l, int r, int[][] dp)
    {
        if(l > r)
            return Integer.MAX_VALUE;
        if(dp[l][r] != -1)
            return dp[l][r]; 
        if(l == r || isPalindrome(s.substring(l, r+1))){
            dp[l][r] = 0; 
            return 0; 
        }
        int res = Integer.MAX_VALUE; 

        for(int i = l; i <= r; i++)
        {
            String sub = s.substring(l, i+1); 
            if(isPalindrome(sub))
            {
                int cuts = 0; 
                if(helper(s, i+1, r, dp) == Integer.MAX_VALUE)
                    cuts = Integer.MAX_VALUE; 
                else
                    cuts = 1 + helper(s, i+1, r, dp); 
                res = Math.min(res, cuts); 
            }
        }
        dp[l][r] = res; 
        return res; 
    }
    public int minCut(String s) {
        int n = s.length(); 
        int[][] dp = new int[n+1][n+1];

        for(int i = 0; i < n; i++)
            Arrays.fill(dp[i], -1); 
         
        int res = helper(s, 0, n-1, dp); 
        return res == Integer.MAX_VALUE ? 0 : res; 
    }
}
