package homework.week3;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/permutation-sequence/
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 * <p>
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 * <p>
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 * <p>
 * 说明：
 * <p>
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 * 示例 1:
 * <p>
 * 输入: n = 3, k = 3
 * 输出: "213"
 * 示例 2:
 * <p>
 * 输入: n = 4, k = 9
 * 输出: "2314"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
// todo ???
public class PermutationSequence {

    public String getPermutation(int n, int k) {
        List<String> res = new ArrayList<>();
        String path = "";
        boolean[] hasVisited = new boolean[n + 1];
        dfs(n, hasVisited, path, res);
        return res.get(k - 1);
    }

    private void dfs(int n, boolean[] hasVisited, String path, List<String> res) {
        if (n == path.length()) {
            res.add(path);
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (hasVisited[i]) continue;

            hasVisited[i] = true;
            dfs(n, hasVisited, path + i, res);
            hasVisited[i] = false;
        }
    }

    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        return Math.abs(height(root.left)-height(root.right))<=1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int height(TreeNode node){
        if(node==null) return 0;
        return Math.max(height(node.left),height(node.right))+1;
    }

    public static void main(String[] args) {
       new PermutationSequence().getPermutation(4,9);
    }
}
