class Solution {
    public int countPalindromicSubsequence(String s) {
        Map<Character, Integer> first = new HashMap<Character, Integer>(); 
        Map<Character, Integer> last = new HashMap<Character, Integer>(); 
        Map<Character, Boolean> mp = new HashMap<Character, Boolean>(); 

        int n = s.length(); 
        int[] prefix = new int[n+1]; 
        prefix[0] = 0;
        int unique = 0;  
        for(int i = 0; i < n; i++)
        {
            if(!mp.containsKey(s.charAt(i)))
            {
                // first time occurrence
                unique++; 
                first.put(s.charAt(i), i); 
            }
            mp.put(s.charAt(i), true); 
            last.put(s.charAt(i), i); 
            prefix[i+1] = unique; 
        } 
        int res = 0; 
        for(char ch : mp.keySet())
        {
            int l = first.get(ch);
            int r = last.get(ch); 
            
            Set<Character> uniqueSet = new HashSet<Character>(); 
            for(int i = l+1; i < r; i++)
            {
                uniqueSet.add(s.charAt(i)); 
            }
            res += uniqueSet.size(); 
        }
        return res; 
    }
}
