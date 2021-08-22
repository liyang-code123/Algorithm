import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        List<Integer> b = new ArrayList<>();
        b.add(3);
        b.add(4);
        list.add(a);
        list.add(b);

//        for(List<Integer> c : list) {
//            System.out.println(c.toString());
//        }
        System.out.println(a.toString());
    }
    // test test test
}
