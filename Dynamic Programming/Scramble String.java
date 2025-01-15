class Solution {
    public boolean helper(String s1, String s2, Map<String, Boolean> mp)
    {
        
        String key = s1 + "." + s2;
        if(mp.containsKey(key))
            return mp.get(key); 
        if(s1.length() != s2.length()){
            mp.put(key, false); 
            return false; 
        }
        if(s1.equals(s2)){
            mp.put(key, true); 
            return true; 
        }

        if(s1.length() <= 1){
            mp.put(key, false); 
            return false;  
        }
        
        // Anagram check optimization
        int[] freq = new int[26];
        for (char c : s1.toCharArray()) freq[c - 'a']++;
        for (char c : s2.toCharArray()) freq[c - 'a']--;
        for (int count : freq) {
            if (count != 0) {
                mp.put(key, false);
                return false; // If they aren't anagrams, return early
            }
        }

        int n = s1.length(); 
        for(int i = 0; i < n-1; i++)
        {
            String x1 = s1.substring(0, i+1); 
            String y1 = s1.substring(i+1); 
            String x2 = s2.substring(0, i+1); 
            String y2 = s2.substring(i+1); 

            boolean res1 = (helper(x1, x2, mp) & helper(y1, y2, mp)); 

            x2 = s2.substring(0, n-1-i); 
            y2 = s2.substring(n-1-i); 
            boolean res2 = (helper(x1, y2, mp) & helper(y1, x2, mp)); 
            if(res1 | res2){
                mp.put(key, true); 
                return true; 
            }

        }
        mp.put(key, false);
        return false; 
    }
    public boolean isScramble(String s1, String s2) {
        Map<String, Boolean> mp = new HashMap<String, Boolean>(); 
        return helper(s1, s2, mp); 
    }
}
