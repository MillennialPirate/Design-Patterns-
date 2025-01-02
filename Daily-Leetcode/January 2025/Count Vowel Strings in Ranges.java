class Solution {
    public boolean isVowel(char ch)
    {
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
            return true; 
        return false; 
    }

    public boolean isVowelString(String str)
    {
        int n = str.length(); 
        if(isVowel(str.charAt(0)) && isVowel(str.charAt(n-1)))
            return true; 
        return false; 
    }
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length; 
        int[] prefix = new int[n+1]; 

        prefix[0] = 0; 
        int cntr = 0; 
        for(int i = 0; i < n; i++)
        {
            if(isVowelString(words[i]))
                cntr++;
            prefix[i+1] = cntr; 
        }

        int len = queries.length; 
        int[] res = new int[len]; 

        for(int i = 0; i < len; i++)
        {
            int s = queries[i][0], e = queries[i][1]; 
            res[i] = prefix[e+1] - prefix[s]; 
        }
        return res; 
    }
}
