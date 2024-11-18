import java.util.*;

public class t406 {
    public static int[][] reconstructQueue(int[][] people) {
        // 第一个元素降序，第二个元素升序
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]){
                    // 第一个元素不相等，降序排列
                    return o2[0] - o1[0];
                } else {
                    // 第二个元素升序排列
                    return o1[1] - o2[1];
                }
            }
        });
        // 排序过后，往结果里放
        List<int[]> list = new LinkedList<>();
        for (int i = 0; i < people.length; i++) {
            if (list.size() < people[i][1]){
                list.add(people[i]);
            } else {
                list.add(people[i][1], people[i]);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
    public static void main(String[] args) {
        int[][] result = reconstructQueue(new int[][]{{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}});
        for (int i = 0; i < result.length; i++) {
            System.out.print(Arrays.toString(result[i]) + " ");
        }
    }
}
