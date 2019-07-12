//Given a binary tree, return all root-to-leaf paths. 
//
// Note: A leaf is a node with no children. 
//
// Example: 
//
// 
//Input:
//
//   1
// /   \
//2     3
// \
//  5
//
//Output: ["1->2->5", "1->3"]
//
//Explanation: All root-to-leaf paths are: 1->2->5, 1->3
//

import java.util.Arrays;
import java.util.Stack;

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
    String delimiter = "->";

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> answer = new ArrayList();
        Stack<String> path = new Stack();
        if(root != null){
            getPath(root, path, answer);
        }
        return answer;
    }

    public void getPath(TreeNode root, Stack<String> path, List<String> answer){
        path.push(String.valueOf(root.val));
        if(root.left == null && root.right == null){
            answer.add(String.join(delimiter, path));
        } else {
            if(root.left != null){
                getPath(root.left, path, answer);
            }
            if(root.right != null){
                getPath(root.right, path, answer);
            }
        }
        path.pop();
    }
}