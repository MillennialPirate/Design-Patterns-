class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length(); 
        int[] prefix = new int[n+1]; 

        prefix[0] = 0; 

        for(int i = 0; i < shifts.length; i++)
        {
            int start = shifts[i][0], end = shifts[i][1], dir = shifts[i][2]; 

            if(dir == 0)
            {
                // backwards 
                prefix[end+1]--; 
                prefix[start]++; 
            }
            else
            {
                prefix[end+1]++; 
                prefix[start]--; 
            }
        }

        StringBuilder res = new StringBuilder(); 
        int sum = 0;

        for(int i = n; i > 0; i--)
        {
            sum += prefix[i]; 
            int currentPos = s.charAt(i-1) - 'a';
            int newPos = (currentPos + sum % 26 + 26) % 26;
            res.append((char)('a' + newPos));
        }
        return res.reverse().toString(); 
    }
}
