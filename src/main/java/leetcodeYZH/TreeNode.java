package leetcodeYZH;

/**
 * 这是一个二叉树的公共实体类
 *
 * @author SmallBai
 * date: 2021/5/19 22:14
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
