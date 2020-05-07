/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int depth(TreeNode root,int k){
        try{
            if(root.val == k || root == null){
                return 0;
            }
            int ld=depth(root.left,k);
            int rd=depth(root.right,k);
            if(ld>=rd){
                return ld+1;
            }
            else{
                return rd+1;
            }
        }
        catch(Exception e){
            return -1000;
        }
    }
    static int findParent(TreeNode node, int val, int parent) 
        { 
            if (node == null) 
                return 0; 
 
            if (node.val == val)  
            { 
                return parent; 
            } 
            else 
            { 
                int l=findParent(node.left, val, node.val); 
                int r=findParent(node.right, val, node.val); 
                if(l>=r){
                    return l;
                }
                else{
                    return r;
                }
            } 
        } 
    
    public boolean isCousins(TreeNode root, int x, int y) {
        int m=depth(root,x);
        int n=depth(root,y);
        int p1=findParent(root,x,-1);
        int p2=findParent(root,y,-1);
        
        if(m==n && p1!=p2){
            return true;
        }
        else{
            return false;
        }
    }
}