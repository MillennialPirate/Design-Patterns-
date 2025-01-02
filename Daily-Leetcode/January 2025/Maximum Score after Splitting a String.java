class Solution {
    public int maxScore(String s) {
        int n = s.length(); 
        int[] zeroes = new int[n+1]; 
        int[] ones = new int[n+1]; 

        zeroes[0] = 0; ones[0] = 0; 
        int cntr0 = 0, cntr1 = 0; 
        for(int i = 0; i < n; i++)
        {
            if(s.charAt(i) == '0')
            {
                cntr0++; 
            }
            else
            {
                cntr1++; 
            }
            zeroes[i+1] = cntr0; 
            ones[i+1] = cntr1; 
        }
        
        int maxScore = Integer.MIN_VALUE; 

        for(int i = 0; i < n-1; i++)
        {
            int z = zeroes[i+1] - zeroes[0]; 
            int o = ones[n] - ones[i+1]; 
            //System.out.println(i + " " + o + " " + z);
            maxScore = Math.max(maxScore, z + o); 
        }
        return maxScore; 
    }
}
