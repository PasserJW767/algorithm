import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Integer int_var1 = 1;
        Integer int_var2 = 2;
        map.put(int_var1, int_var2);
        int_var1 = 2;
        System.out.println(map.get(1));
    }
}