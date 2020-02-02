package binarytree;
import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int x){
        this.val = x;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}

public class Insert {

    public static TreeNode InsertNode(int[] data, int i){
        if (i >= data.length || data[i] == -1)
            return null;
        TreeNode root = new TreeNode(data[i]);
        root.left = InsertNode(data, i*2+1);
        root.right = InsertNode(data, i*2+2);
        return root;
        }

    public static void levelOrder(TreeNode temp) {
        if (temp == null)
            return;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(temp);
        while (!queue.isEmpty()) {
            temp = queue.poll();
            System.out.print(temp.val + " ");
            if (temp.left != null)
                queue.offer(temp.left);
            if (temp.right != null)
                queue.offer(temp.right);
        }

    }

    List<List<Integer>> levels = new ArrayList<List<Integer>>();

    public void helper(TreeNode node, int level) {
        // start the current level
        if (levels.size() == level)
            levels.add(new ArrayList<Integer>());

        // fulfil the current level
        levels.get(level).add(node.val);

        // process child nodes for the next level
        if (node.left != null)
            helper(node.left, level + 1);
        if (node.right != null)
            helper(node.right, level + 1);
    }

    public void levelOrder3(TreeNode root) {
        if (root == null) return;
        helper(root, 0);
    }


    public static void main(String[] args){
        int[] data = {1,2,3,4,5,6,7,8,9,10,11,12,13};
        TreeNode node = InsertNode(data, 0);
        levelOrder(node);
        System.out.println(node);
        new Insert().levelOrder3(node);
    }

}
