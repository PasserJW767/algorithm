public class t11 {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1, res = 0;
        while (i < j) {
            res = height[i] < height[j] ?
                    Math.max(res, (j - i) * height[i++]) : // i是短板
                    Math.max(res, (j - i) * height[j--]); // j是短板
            // 面积=(底部宽度)*短板高度
            // 求完面积移短板(蕴藏在i++和j--)里了
        }
        return res;
    }
    public static void main(String[] args) {

    }
}
