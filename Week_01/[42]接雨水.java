//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 0 <= n <= 3 * 104 
// 0 <= height[i] <= 105 
// 
// Related Topics 栈 数组 双指针 
// 👍 1914 👎 0


import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int result = trap(arr);
        System.out.println(result);
    }

    public static int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();

        int leftMaxTemp = 0;
        int little_sum = 0;
        int max_sum = 0;
        int all = 0;

        for (int i = 0; i < height.length; i++) {
            if (leftMaxTemp >= height[i]) {
                stack.push(height[i]);
            } else {
                if (stack.isEmpty()) {
                    leftMaxTemp = height[i];
                    continue;
                }
                max_sum = leftMaxTemp * stack.size();
                for (int j = 0; j < stack.size(); j++) {
                    little_sum += stack.pop();
                }
                all += (max_sum - little_sum);
                leftMaxTemp = height[i];
            }
        }
        return all;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
