//Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment. 
//
// Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure. 
//
// Example: 
//
// 
//You may serialize the following tree:
//
//    1
//   / \
//  2   3
//     / \
//    4   5
//
//as "[1,2,3,null,null,4,5]"
// 
//
// Clarification: The above format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself. 
//
// Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless. 
//

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder path = new StringBuilder();
        addNodeToList(path, root);
        path.setLength(path.length() - 1);
        return path.toString();
    }

    public void addNodeToList(StringBuilder path, TreeNode root){
        path.append(root != null? root.val: null);
        path.append(',');
        if(root != null){
            addNodeToList(path, root.left);
            addNodeToList(path, root.right);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> queue = new LinkedList();
        queue.addAll(Arrays.asList(data.split(",")));
        TreeNode root = addNode(queue);
        return root;
    }

    public TreeNode addNode(Deque<String> queue){
        String val = queue.remove();
        if(val.equals("null")){
            return null;
        } else {
            TreeNode node = new TreeNode(Integer.parseInt(val));
            node.left = addNode(queue);
            node.right = addNode(queue);
            return node;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));