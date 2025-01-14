class Solution {
    public int helper(int[] cuts, int l,  int r, int[][] dp)
    {
        if(l > r){
            dp[l][r] = 0; 
            return 0; 
        }
        if(dp[l][r] != -1)
            return dp[l][r]; 
        
        int minCost = Integer.MAX_VALUE; 
        for(int i = l; i <= r; i++)
        {
            int cost = (cuts[r+1] - cuts[l-1]) + helper(cuts, l, i-1, dp) + helper(cuts, i+1, r, dp); 
            minCost = Math.min(minCost, cost); 
        }
        dp[l][r] = minCost; 
        return minCost; 
    }
    public int minCost(int n, int[] cuts) {
        int len = cuts.length; 
        int[] res = new int[len+2]; 
        res[0] = 0; res[len+1] = n; 
        int[][] dp = new int[len+2][len+2]; 

        for(int i = 0; i < len+2; i++)
            Arrays.fill(dp[i], -1); 
        
        Arrays.sort(cuts); 
        for(int i = 0; i < len; i++)
        {
            res[i+1] = cuts[i]; 
        }
        return helper(res, 1, len, dp); 
    }
}
