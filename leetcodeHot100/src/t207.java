import java.util.*;

public class t207 {
    static List<List<Integer>> edges;
    static int[] indeg;

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        // 建立图以后做搜索
        edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++){
            edges.add(new ArrayList<>());
        }
        indeg = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            edges.get(prerequisite[1]).add(prerequisite[0]);
            ++indeg[prerequisite[0]]; // 记录这个位置有几个子节点，便于后续做广度优先搜索 -> 但是真的有必要吗？edges[prerequisite[0]]的长度不行吗
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indeg[i] == 0){ // 找到入度为0的节点开始广度优先搜索
                queue.offer(i);
            }
        }

        int visited = 0;
        while (!queue.isEmpty()){
            ++visited;
            int u = queue.poll(); // 出队
            for (int v: edges.get(u)){ // 广度优先搜索，里面的内容入队
                --indeg[v];
                if (indeg[v] == 0){ // 直到这个节点不再被其他节点所指，才能入队继续遍历它下面的节点
                    queue.offer(v);
                }
            }
        }

        return visited == numCourses;
    }
    public static void main(String[] args) {
        int numCourses = 3;
//        int[][] prerequisites = new int[][]{{1,0}, {0,1}};
        int[][] prerequisites = new int[][]{{1,0}, {1,2}, {0,1}};
        System.out.println(canFinish(numCourses, prerequisites));
    }
}
