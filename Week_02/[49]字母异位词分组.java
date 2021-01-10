//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。 
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串 
// 👍 624 👎 0


import javax.xml.transform.Result;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public static void main(String[] args){
        String[] arr = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = groupAnagrams(arr);
        System.out.println(result);

    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> judgeMap = new HashMap<String, List<String>>();

        for (String str : strs) {
            char[] chars = str.toCharArray();

            Arrays.sort(chars);

            String newString = chars.toString();

            List<String> list  = judgeMap.getOrDefault(newString, new ArrayList<String>());

            list.add(str);

            judgeMap.put(newString, list);
        }

        List<List<String>> result = new ArrayList<>();

        for (List<String> value : judgeMap.values()) {
            result.add(value);
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
