class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length; 

        int[][] dp = new int[m+1][n+1]; 
        for(int i = 0; i <= n; i++)
            dp[m][i] = Integer.MAX_VALUE; 
        
        for(int i = 0; i <= m; i++)
            dp[i][n] = Integer.MAX_VALUE; 

        for(int i = m-1; i >= 0; i--)
        {
            for(int j = n-1; j >= 0; j--)
            {
                if(i == m-1 && j == n-1)
                {
                    dp[i][j] = dungeon[i][j] < 0 ? 1-dungeon[i][j] : 1;
                }
                else
                {
                    int right = dp[i][j+1], down = dp[i+1][j]; 
                    int need = Math.min(right, down) - dungeon[i][j]; 
                    dp[i][j] = need <= 0 ? 1 : need; 
                }
            }
        }

        return dp[0][0]; 
    }
}
