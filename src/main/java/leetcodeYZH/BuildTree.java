package leetcodeYZH;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * <p>
 * 前序遍历 preorder =[3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *       3
 *      / \
 *     9  20
 *       /  \
 *      15   7
 *
 * @author SmallBai
 * date: 2021/5/19 22:13
 */
public class BuildTree {

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
    }

    public TreeNode Solution(int[] preorder, int[] inorder) {
        TreeNode tree = null;
        //确定root节点，为前序遍历的第一个
        tree = new TreeNode(preorder[0]);
        List<Integer> leftTree = new ArrayList();
        List<Integer> rightTree = new ArrayList();
        boolean flag = false;
        for (int i : inorder) {
            if(i == preorder[0]){
                flag = true;
            }
            if(flag){
                rightTree.add(i);
            }else{
                leftTree.add(i);
            }
        }
        int[] p1 = Arrays.copyOfRange(preorder,1,1+leftTree.size());
        int[] p2 = Arrays.copyOfRange(preorder,preorder.length-rightTree.size(),preorder.length);
        tree.left = Solution(p1,leftTree.stream().mapToInt(Integer::intValue).toArray());
        tree.right = Solution(p2,rightTree.stream().mapToInt(Integer::intValue).toArray());
        return tree;
    }
}
