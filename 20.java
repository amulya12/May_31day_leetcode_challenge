// Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

// Note:
// You may assume k is always valid, 1 = k = BST's total elements.

// Example 1:
// Input: root = [3,1,4,null,2], k = 1
// Output: 1
    
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
    List<Integer> l=new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        
        inorder(root);
        
        return l.get(k-1);
        
        
    }
    void inorder(TreeNode root)
    {
        if(root==null)
            return;
        inorder(root.left);
        l.add(root.val);
        inorder(root.right);
    }
}