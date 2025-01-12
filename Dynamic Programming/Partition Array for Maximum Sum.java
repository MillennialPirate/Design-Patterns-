class Solution {
    public int helper(int[] arr, int l, int k, int[] dp)
    {
        if(l == arr.length)
            return 0; 
        if(dp[l] != -1)
            return dp[l]; 
        int maxEle = Integer.MIN_VALUE, res = Integer.MIN_VALUE; 

        for(int i = l; i < arr.length && i < l+k; i++)
        {
            maxEle = Math.max(maxEle, arr[i]); 
            int val = maxEle*(i-l+1) + helper(arr, i+1, k, dp); 
            res = Math.max(res, val); 
        }
        dp[l] = res; 
        return res; 
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length]; 
        Arrays.fill(dp, -1); 

        return helper(arr, 0, k, dp); 
    }
}
