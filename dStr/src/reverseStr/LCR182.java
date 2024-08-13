package reverseStr;

public class LCR182 {
    /*
    * 某公司门禁密码使用动态口令技术。初始密码为字符串 password，密码更新均遵循以下步骤：
        设定一个正整数目标值 target
        将 password 前 target 个字符按原顺序移动至字符串末尾
        请返回更新后的密码字符串。
    * 示例 1：
        输入: password = "s3cur1tyC0d3", target = 4
        输出: "r1tyC0d3s3cu"
        示例 2：
        输入: password = "lrloseumgh", target = 6
        输出: "umghlrlose"
    *
    *
    *
    * */
    public static String dynamicPassword(String password, int target) {
        // 最简单的思路：根据target截取password的前target个字符放入到新数组里
        // 将password.length - target的字符，以双指针的形式移动到原数组中
        // 将新数组中的内容接着放到原数组后边就行

        // 上述思路没有实现，因为Carl说这样做没啥挑战，所以升级一下，尝试在同一个串上做操作，即空间复杂度O(1)
        return password.substring(target, password.length()) + password.substring(0, target);
    }
    public static void main(String[] args) {
        System.out.println(dynamicPassword("s3cur1tyC0d3", 4));
        System.out.println(dynamicPassword("lrloseumgh", 6));
    }
}
