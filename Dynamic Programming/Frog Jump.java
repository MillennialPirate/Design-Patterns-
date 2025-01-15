class Solution {
    public boolean helper(int[] stones, int ind, int k, Map<Integer, Integer> mp, Map<String, Boolean> dp)
    {
        String key = Integer.toString(ind) + "." + Integer.toString(k); 
        if(dp.containsKey(key))
            return dp.get(key);
        if(ind == stones.length-1){
            dp.put(key, true);
            return true; 
        }
        if(k == 0 || ind >= stones.length){
            dp.put(key, false); 
            return false; 
        }

        int ind1 = stones[ind] + k; 
        int ind2 = stones[ind] + k-1; 
        int ind3 = stones[ind] + k+1; 

        boolean res = false; 
        if(mp.containsKey(ind1))
            res |= helper(stones, mp.get(ind1), k, mp, dp); 
        if(mp.containsKey(ind2))
            res |= helper(stones, mp.get(ind2), k-1, mp, dp);
        if(mp.containsKey(ind3))
            res |= helper(stones, mp.get(ind3), k+1, mp, dp);
        dp.put(key, res); 
        return res; 
        
    }
    public boolean canCross(int[] stones) {
        
        Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
        Map<String, Boolean> dp = new HashMap<String, Boolean>(); 

        if(stones.length == 0)
            return true; 
        int k = 0, dif = stones[1] - stones[0];
        if(dif > 1)
            return false; 
        for(int i = 0; i < stones.length; i++)
            mp.put(stones[i], i); 
        
        return helper(stones, 1, 1, mp, dp);
    }
}
