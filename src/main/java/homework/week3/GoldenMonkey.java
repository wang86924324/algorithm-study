package homework.week3;

/**
 * 60. 第k个排列
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 * <p>
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 * <p>
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 * <p>
 * 说明：
 * <p>
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 * 示例 1:
 * <p>
 * 输入: n = 3, k = 3
 * 输出: "213"
 * 示例 2:
 * <p>
 * 输入: n = 4, k = 9
 * 输出: "2314"
 */

/**
 * 解题思路
 * 1.递归剪枝
 * 剪枝要点：
 * 1.深度偶现遍历节点，并计算节点数目，剪掉前k-1个元素，第一个n层节点的元素就是第k个元素
 * 2.双链表
 */
public class GoldenMonkey {
    public String getPermutation(int n, int k) {
        int[] factorial = new int[n + 1];
        factorial[0] = 0;
        for (int i = 1; i <= n; i++) factorial[i] = i * (i == 1 ? 1 : factorial[i - 1]);

        String path = "";
        return dfs(n, k, path, factorial);
    }

    private String dfs(int n, int k, String path, int[] factorial) {
        // 剪掉k-1个节点后，第一个到达叶子节点的就是第k个元素
        if (path.length() == n) {
            return path;
        }

        int cur = factorial[n - path.length() - 1];
        for (int i = 1; i <= n; i++) {
            // 去除重复元素剪枝
            if (path.contains(String.valueOf(i))) continue;
            // 剪枝
            if (cur > 0 && cur < k) {
                k -= cur;
                continue;
            }
            // Current logic
            return dfs(n, k, path + i, factorial);
        }
        return null;
    }

    public static void main(String[] args) {
        new GoldenMonkey().getPermutation(3, 3);
    }

    


}
