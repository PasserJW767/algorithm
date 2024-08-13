package replaceSpace;

public class LCR122 {
    /*
    * 假定一段路径记作字符串 path，其中以 "." 作为分隔符。现需将路径加密，加密方法为将 path 中的分隔符替换为空格 " "，请返回加密后的字符串。
    * 示例 1：
        输入：path = "a.aef.qerf.bb"
        输出："a aef qerf bb"
    *
    * */
    public static String pathEncryption(String path) {
        char[] charArray = path.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '.'){
                charArray[i] = ' ';
            }
        }
        return String.valueOf(charArray);
    }
    public static void main(String[] args) {
        System.out.println(pathEncryption("a.aef.qerf.bb"));
    }
}
