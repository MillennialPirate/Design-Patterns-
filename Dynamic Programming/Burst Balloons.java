class Solution {
    public int helper(int[] nums, int l, int r, int[][] dp)
    {
        if(l > r){
            dp[l][r] = 0; 
            return 0; 
        }
        if(dp[l][r] != -1)
            return dp[l][r]; 
        int maxCost = Integer.MIN_VALUE; 

        for(int i = l; i <= r; i++)
        {
            int cost = nums[i]*nums[l-1]*nums[r+1] + helper(nums, l, i-1, dp) + helper(nums, i+1, r, dp); 
            maxCost = Math.max(maxCost, cost); 
        }
        dp[l][r] = maxCost; 
        return maxCost; 
    }
    public int maxCoins(int[] nums) {
        int n = nums.length; 
        int[] res = new int[n+2];
        int[][] dp = new int[n+2][n+2]; 
        for(int i = 0; i < n+2; i++)
            Arrays.fill(dp[i], -1);
        res[0] = 1; res[n+1] = 1; 
        for(int i = 0; i < n; i++)
            res[i+1] = nums[i]; 

        return helper(res, 1, n, dp);  
    }
}
