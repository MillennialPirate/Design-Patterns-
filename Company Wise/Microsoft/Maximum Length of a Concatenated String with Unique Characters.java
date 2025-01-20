class Solution {
    public boolean canBeIncluded(int[] freq, String str)
    {
        // if the string itself has duplicate characters dont include 
        Map<Character, Boolean> mp = new HashMap<Character, Boolean>(); 
        for(int i = 0; i < str.length(); i++)
        {
            if(mp.containsKey(str.charAt(i)))
                return false;
            mp.put(str.charAt(i), true);
        }
        for(int i = 0; i < str.length(); i++)
        {
            if(freq[str.charAt(i)] != 0)
                return false; 
        }
        return true; 
    }
    public int helper(List<String> arr, int ind, int[] freq)
    {
        if(ind >= arr.size())
            return 0; 
        int n = arr.size(); 

        int exc = helper(arr, ind+1, freq), inc = 0; 
        if(canBeIncluded(freq, arr.get(ind)))
        {
            for(int i = 0; i < arr.get(ind).length(); i++)
            {
                freq[arr.get(ind).charAt(i)]++;
            }
            inc = helper(arr, ind+1, freq) + arr.get(ind).length(); 
            for(int i = 0; i < arr.get(ind).length(); i++)
            {
                freq[arr.get(ind).charAt(i)]--; 
            }
        }
        return Math.max(inc, exc);
    }
    public int maxLength(List<String> arr) {
        int[] freq = new int[128]; 
        return helper(arr, 0, freq);
    }
}
