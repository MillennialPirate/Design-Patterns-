/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<TreeNode> helper(int l, int r, Map<String, List<TreeNode>> mp)
    {
        List<TreeNode> res = new ArrayList<TreeNode>(); 
        String key = Integer.toString(l) + "," + Integer.toString(r); 

        if(mp.containsKey(key))
            return mp.get(key); 
        if(l > r){
            res.add(null);
            mp.put(key, res); 
            return res;
        } 
        else if(l == r){
            res.add(new TreeNode(l)); 
            mp.put(key, res); 
            return res; 
        }
        
        
        for(int i = l; i <= r; i++)
        {
            List<TreeNode> leftNodes = helper(l, i-1, mp); 
            List<TreeNode> rightNodes = helper(i+1, r, mp); 
            


            for(TreeNode left : leftNodes)
            {
                for(TreeNode right : rightNodes)
                {
                    TreeNode root = new TreeNode(i); 
                    root.left = left; 
                    root.right = right; 
                    res.add(root);
                }
            }
        }
        mp.put(key, res); 
        return res; 
    }
    public List<TreeNode> generateTrees(int n) {
        Map<String, List<TreeNode>> mp = new HashMap<String, List<TreeNode>>(); 
        return helper(1, n, mp); 
    }
}
