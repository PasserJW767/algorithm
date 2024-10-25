public class t647 {
    public static boolean checkHuiWen(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j){
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
    public static int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length() + 1;j++){
                if (s.substring(i,j).length() != 0 && checkHuiWen(s.substring(i,j))){
                    count++;
                }
            }
        }
        return count;
    }
    public static int countSubstrings2(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            // 中心拓展法
            int cur_count = 0;
            // 向两边拓展
            // 如果像下面这种写法，就只是以i作为中心了，事实上并不止这一种情况，还有l=i，r=i+1作为回文中心（即回文子串长度为偶数的情况）
            int l = i;
            int r = i;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                cur_count++;
                l--;
                r++;
            }
            l = i;
            r = i + 1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                cur_count++;
                l--;
                r++;
            }
            count += cur_count;
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(countSubstrings2("abc"));
        System.out.println(countSubstrings2("aaa"));
    }
}
