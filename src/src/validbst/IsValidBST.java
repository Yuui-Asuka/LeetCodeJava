package validbst;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class IsValidBST {
    public static TreeNode InsertNode(Integer[] data, int i){
        if (i >= data.length || data[i] == -1 || data[i]==null)
            return null;
        TreeNode root = new TreeNode(data[i]);
        root.left = InsertNode(data, i*2+1);
        root.right = InsertNode(data, i*2+2);
        return root;
    }

    public static boolean isValid(TreeNode root) {
        return helper(root, null, null);

    }

    public static boolean helper(TreeNode node, Integer lower, Integer upper){
        if (node == null) return true;
        int val = node.val;
        if (lower != null && val <= lower) return false;
        if (upper != null && val >= upper) return false;

        if (! helper(node.right, val, upper)) return false;
        if (! helper(node.left, lower, val)) return false;
        return true;

    }

    public static void main(String[] args){
        Integer[] data = {5,1,4,6,null,null,4,8};
        TreeNode node = InsertNode(data, 0);
        boolean tag = isValid(node);
        System.out.println(tag);
    }


}
