class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length; 
        Map<Integer, Integer> mp = new HashMap<Integer, Integer>(); 

        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(matrix[i][j] == 1){
                    if(i == 0 || j == 0){
                        if(mp.containsKey(matrix[i][j]))
                            mp.put(matrix[i][j], mp.get(matrix[i][j]) + 1); 
                        else
                            mp.put(matrix[i][j], 1); 
                    }
                    else
                    {
                        matrix[i][j] = Math.min(matrix[i-1][j], Math.min(matrix[i-1][j-1], matrix[i][j-1])) + 1; 
                        if(mp.containsKey(matrix[i][j]))
                            mp.put(matrix[i][j], mp.get(matrix[i][j]) + 1); 
                        else
                            mp.put(matrix[i][j], 1); 
                    }
                }
            }
        }

        int res = 0; 
        for(int key : mp.keySet())
        {
            //System.out.println(key + " " + mp.get(key)); 
            res += key*mp.get(key); 
        }
        return res; 
    }
}
