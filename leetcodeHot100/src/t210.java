import java.util.*;

public class t210 {
    static List<List<Integer>> edges;
    static int[] indeg;
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        // 建立依赖
        edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }

        indeg = new int[numCourses];
        for (int[] prerequisite : prerequisites) { // (ai,bi) -> 学习ai前要学习bi
            edges.get(prerequisite[1]).add(prerequisite[0]); // 学习bi后能够解锁的课程放入列表
            indeg[prerequisite[0]]++; // 学习bi后能够解锁的课程数量
        }

        // BFS先遍历入度为0的节点
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < indeg.length; i++) {
            if (indeg[i] == 0){
                deque.addLast(i);
            }
        }

        // 执行BFS
        int visited = 0;
        List<Integer> results = new ArrayList<>();
        while (!deque.isEmpty()){
            visited++;
            Integer i = deque.removeFirst(); // 能够学习的课程
            results.add(i);
            // 学习完这门课程后可以解锁的课程
            List<Integer> integers = edges.get(i);
            for (Integer integer : integers) {
                // 这些课程又减少了一个依赖
                indeg[integer]--;
                if (indeg[integer] == 0){ // 有课程的所有前置课程都已经学完了，可以学这门课程了，将这门课入队
                    deque.addLast(integer);
                }
            }
        }

        return visited == numCourses? results.stream().mapToInt(Integer::intValue).toArray() : new int[]{};
    }
    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = new int[][]{{1,0}};
        System.out.println(Arrays.toString(findOrder(numCourses, prerequisites)));
    }
}
