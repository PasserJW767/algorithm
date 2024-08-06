package minLengthSubArray;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class t76 {
    /*
     * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
     * - 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
     * - 如果 s 中存在这样的子串，我们保证它是唯一的答案。
     *
     * 示例 1：
        输入：s = "ADOBECODEBANC", t = "ABC"
        输出："BANC"
        解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
     *
     * 示例 2：
        输入：s = "a", t = "a"
        输出："a"
        解释：整个字符串 s 是最小覆盖子串。
     *
     * 示例 3:
        输入: s = "a", t = "aa"
        输出: ""
        解释: t 中两个字符 'a' 均应包含在 s 的子串中，
        因此没有符合条件的子字符串，返回空字符串。
     *
     */
    public static String minWindow(String s, String t) {
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();

        return charHelper(ss, tt);
    }
    public static String charHelper(char[] arr, char[] target){
        // 放置target的信息，便于后续判断最小子串
        Map<Character, Integer> targetMap = new HashMap<>();
        for (int i = 0; i < target.length; i++){
            targetMap.put(target[i], targetMap.getOrDefault(target[i], 0) + 1);
        }

        int left = 0;
        int ans_len = Integer.MAX_VALUE;
        String ans = "";
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int right = 0; right < arr.length; right++){
            map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);
            // 如果targetMap的所有key都在map里面(包含关系)，且value个数是>=的关系，可以缩小slow
            boolean un_break_flag = false;
            boolean border_flag = false;

            while (true){
                // 遍历查看targetmap所有的key是否都在map中,value是否符合要求
                for (Character key : targetMap.keySet()){
                    if (!map.containsKey(key)){
                        un_break_flag = true;
                        break;
                    }
                    if (map.get(key) < targetMap.get(key)){
                        un_break_flag = true;
                        break;
                    }
                }
                if (un_break_flag) break;
                if (left + 1 >= arr.length || left < 0){
                    border_flag = true;
                    break;
                }
                map.put(arr[left], map.getOrDefault(arr[left], 0) - 1);
                if (map.get(arr[left]) <= 0) map.remove(arr[left]);
                left++;
            }
            // 判断此时此刻，是否targetMap的key都在map中
            if (left - 1 >= 0 || border_flag){
                if (!border_flag){
                    left--;
                    map.put(arr[left], map.getOrDefault(arr[left], 0) + 1);
                }
                un_break_flag = false;
                // 为false说明都在map中
                for (Character key : targetMap.keySet()){
                    if (!map.containsKey(key)){
                        un_break_flag = true;
                        break;
                    }
                    if (map.get(key) < targetMap.get(key)){
                        un_break_flag = true;
                        break;
                    }
                }
                // ans_len求和所有value的长度并赋值，ans赋值
                if (!un_break_flag && ans_len > (right - left + 1)){
                    ans_len = right - left + 1;
                    ans = new String(arr).substring(left, right + 1);
                }

            }
        }
        return ans;
    }
    // 官方题解
    static Map<Character, Integer> ori = new HashMap<Character, Integer>();
    static Map<Character, Integer> cnt = new HashMap<Character, Integer>();
    public static String minWindow2(String s, String t){
        int tLen = t.length();
        // 和我的思路一样，先把目标放到一个Map中
        for (int i = 0; i < tLen; i++){
            char c = t.charAt(i);
            ori.put(c, ori.getOrDefault(c, 0) + 1);
        }

        int l = 0, r = -1;
        int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;
        int sLen = s.length();
        // 我用的是for循环，这里是while
        while (r < sLen){
            // 类似于for循环+1，这里从0开始，和我的一样
            ++r;
            // 如果r在边界范围内，且目标结果里面有这个字符，就放到cnt中
            if (r < sLen && ori.containsKey(s.charAt(r))){
                cnt.put(s.charAt(r), cnt.getOrDefault(s.charAt(r), 0) + 1);
            }
            while (check() && l <= r){
                // 满足条件记录答案
                if (r - l + 1 < len){
                    len = r - l + 1;
                    ansL = l;
                    ansR = l + len;
                }

                // 因为l要++了，如果l的值在ori里面的话，就减去数量
                if (ori.containsKey(s.charAt(l))){
                    cnt.put(s.charAt(l), cnt.getOrDefault(s.charAt(l), 0) - 1);
                }
                ++l;
            }
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR);
    }
    // 自己用for 循环再实现了一次题解
    public static String minWindow3(String s, String t){
        int tLen = t.length();
        // 和我的思路一样，先把目标放到一个Map中
        for (int i = 0; i < tLen; i++){
            char c = t.charAt(i);
            ori.put(c, ori.getOrDefault(c, 0) + 1);
        }

        int l = 0, r = 0;
        int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;
        int sLen = s.length();
        for (; r < sLen; r++){
            // 只有target里面有的数据，才需要放到集合中，要不然可以不用放，因为那些都是多余的数据
            // 我们判断只需要判断在cnt中有没有出现和ori一样对应的关键字（关键字少才有影响，多没有影响的，所以不用放多的）
            if (ori.containsKey(s.charAt(r))){
                cnt.put(s.charAt(r), cnt.getOrDefault(s.charAt(r), 0) + 1);
            }
            // 满足条件了，对l进行更新，缩小窗口找最优解
            while (check() && l <= r){
                // 记录结果
                if (r - l + 1 < len){
                    len = r - l + 1;
                    ansL = l;
                    ansR = l + len;
                }
                // 如果cnt中，l的值存在就去掉l，然后移动l
                if (cnt.containsKey(s.charAt(l))){
                    cnt.put(s.charAt(l), cnt.getOrDefault(s.charAt(l), 0) - 1);
                }
                l++;
            }
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR);
    }
    // 这个函数也是检查ori的内容在不在cnt里面，且value是不是满足小于的条件，和我的思路一样
    public static boolean check(){
        Iterator iter = ori.entrySet().iterator();
        while (iter.hasNext()){
            Map.Entry entry = (Map.Entry) iter.next();
            Character key = (Character) entry.getKey();
            Integer val = (Integer) entry.getValue();
            if (cnt.getOrDefault(key, 0) < val){
                return false;
            }
        }
        return true;
    }



    public static void main(String[] args) {
//        System.out.println(minWindow("ADOBECODEBANC", "ABC")); // BANC
//        System.out.println(minWindow("a", "a")); // a
//        System.out.println(minWindow("a", "aa")); //
//        System.out.println(minWindow("ab", "a")); // a
//        System.out.println(minWindow("ab", "b")); // b
//        System.out.println(minWindow("ba", "ab")); // ba

//        System.out.println(minWindow2("ADOBECODEBANC", "ABC")); // BANC
//        ori = new HashMap<Character, Integer>();
//        cnt = new HashMap<Character, Integer>();
//        System.out.println(minWindow2("a", "a")); // a
//        ori = new HashMap<Character, Integer>();
//        cnt = new HashMap<Character, Integer>();
//        System.out.println(minWindow2("a", "aa")); //
//        ori = new HashMap<Character, Integer>();
//        cnt = new HashMap<Character, Integer>();
//        System.out.println(minWindow2("ab", "a")); // a
//        ori = new HashMap<Character, Integer>();
//        cnt = new HashMap<Character, Integer>();
//        System.out.println(minWindow2("ab", "b")); // b
//        ori = new HashMap<Character, Integer>();
//        cnt = new HashMap<Character, Integer>();
//        System.out.println(minWindow2("ba", "ab")); // ba
//
//        System.out.println();

        ori = new HashMap<Character, Integer>();
        cnt = new HashMap<Character, Integer>();
        System.out.println(minWindow3("ADOBECODEBANC", "ABC")); // BANC
        ori = new HashMap<Character, Integer>();
        cnt = new HashMap<Character, Integer>();
        System.out.println(minWindow3("a", "a")); // a
        ori = new HashMap<Character, Integer>();
        cnt = new HashMap<Character, Integer>();
        System.out.println(minWindow3("a", "aa")); //
        ori = new HashMap<Character, Integer>();
        cnt = new HashMap<Character, Integer>();
        System.out.println(minWindow3("ab", "a")); // a
        ori = new HashMap<Character, Integer>();
        cnt = new HashMap<Character, Integer>();
        System.out.println(minWindow3("ab", "b")); // b
        ori = new HashMap<Character, Integer>();
        cnt = new HashMap<Character, Integer>();
        System.out.println(minWindow3("ba", "ab")); // ba
    }
}