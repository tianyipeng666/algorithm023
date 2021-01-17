//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法 
// 👍 467 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> res = new ArrayList<>();

        //terminator
        if (n < k || k == 0) {
            return res;
        }

        //不选择第n个，从前面n-1个数字中选择k-1个构成一个集合
        res = combine(n - 1, k - 1);

        //如果res是空，添加一个空的集合
        if (res.isEmpty()) {
            res.add(new ArrayList<>());
        }

        //然后在前面选择的集合res中的每个子集合的后面添加一个数字n
        for (List<Integer> list : res) {
            list.add(n);
        }

        //res中不光要包含选择第n个数字的集合，也要包含不选择第n个数字的集合
        res.addAll(combine(n - 1, k));

        return res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
