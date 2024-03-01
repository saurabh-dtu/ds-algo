import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    List<TreeNode> children;

    TreeNode(int val) {
        this.val = val;
        this.children = new ArrayList<>();
    }
}

public class LowestCommonAncestorNaryTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        List<TreeNode> matches = new ArrayList<>();
        for (TreeNode child : root.children) {
            TreeNode match = lowestCommonAncestor(child, p, q);
            if (match != null) {
                matches.add(match);
            }
        }

        if (matches.size() == 2) {
            return root;
        } else if (matches.size() == 1) {
            return matches.get(0);
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(0);
        TreeNode node6 = new TreeNode(8);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(4);

        root.children.add(node1);
        root.children.add(node2);
        root.children.add(node3);

        node1.children.add(node4);
        node1.children.add(node5);
        node2.children.add(node6);
        node2.children.add(node7);
        node2.children.add(node8);

        LowestCommonAncestorNaryTree solution = new LowestCommonAncestorNaryTree();
        TreeNode ancestor = solution.lowestCommonAncestor(root, node1, node2);
        System.out.println("Lowest Common Ancestor: " + ancestor.val);
    }
}
