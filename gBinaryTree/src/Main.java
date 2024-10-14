import java.util.*;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(6, 1);
        map.put(3, 1);
        map.put(4, 1);
        map.put(null,null);
        System.out.println(map.get(null));

    }
}
