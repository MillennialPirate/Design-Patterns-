class Solution {
    public int maxAreaHist(int[] arr)
    {
        int n = arr.length; 

        Stack<Integer> st = new Stack<Integer>(); 

        int[] left = new int[n]; 
        int[] right = new int[n]; 

        for(int i = 0; i < n; i++)
        {
            while(!st.isEmpty() && arr[st.peek()] > arr[i])
            {
                right[st.peek()] = i; 
                st.pop(); 
            }
            st.push(i); 
        }
        while(!st.isEmpty())
        {
            right[st.peek()] = n; 
            st.pop(); 
        }

        for(int i = n-1; i >= 0; i--)
        { 
            while(!st.isEmpty() && arr[st.peek()] > arr[i])
            {
                left[st.peek()] = i; 
                st.pop(); 
            }
            st.push(i); 
        }
        while(!st.isEmpty())
        {
            left[st.peek()] = -1; 
            st.pop(); 
        }

        int res = Integer.MIN_VALUE; 
        for(int i = 0; i < n; i++)
        {
            //System.out.print(left[i] + " "); 
            res = Math.max(res, (right[i]-left[i]-1)*arr[i]); 
        }
        //System.out.println("");
        return res; 
    }
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length; 
        int[][] mat = new int[m][n]; 
        
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
                mat[i][j] = matrix[i][j] == '1' ? 1 : 0; 
        }
        int res = Integer.MIN_VALUE; 

        for(int i = 0; i < m; i++)
        {
            int[] height = new int[n]; 
            for(int j = 0; j < n; j++)
            {
                if(mat[i][j] == 0)
                    height[j] = 0; 
                else
                {
                    mat[i][j] = i == 0 ? 1 : mat[i-1][j] + 1; 
                    height[j] = mat[i][j]; 
                }
            }

            // for(int j = 0; j < n; j++)
            // {
            //     System.out.print(height[j] + " "); 
            // }
            // System.out.println("");
            res = Math.max(res, maxAreaHist(height)); 
        }
        return res; 
    }
}
