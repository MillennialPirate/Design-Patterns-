class Solution {
    public int waysToSplitArray(int[] nums) {
        int n = nums.length; 
        long sum = 0; 
        for(int i = 0; i < n; i++)
            sum += (long)nums[i]; 
        
        int cntr = 0;
        long res = 0; 
        for(int i = 0; i < n-1; i++)
        {
            res += (long)nums[i]; 
            if(res >= sum-res)
                cntr++; 
        }
        return cntr; 
    }
}
