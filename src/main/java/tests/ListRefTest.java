package tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListRefTest {
    public static void main(String[] args) {
        List<Test> list_o = getList();
        System.out.println("-----------LIST O-----------");
        for (Test val :
                list_o) {
            System.out.println(val);
        }

        List<Test> clone1 = list_o;
        System.out.println("-----------clone list -1-----------");
        for (Test val :
                clone1) {
            System.out.println(val);
        }

//        Pair pair = new Pair<List<tests.Test>, Integer>(clone1, 1);


//        pair.first
        System.out.println("-----------LIST O-----------");
        for (Test val :
                list_o) {
            System.out.println(val);
        }
    }

    static List<Test> getList(){
        List<Test> list = new ArrayList<>();
        list.add(new Test());
        list.add(new Test());
        list.add(new Test());
        list.add(new Test());
        list.add(new Test());
        return list;
    }

    static class Test{
        int v1 = 1;
        int v2 = 2;
        int v3 = 3;
        int v4 = 4;

        @Override
        public String toString() {
            return "tests.Test{" +
                    "v1=" + v1 +
                    ", v2=" + v2 +
                    ", v3=" + v3 +
                    ", v4=" + v4 +
                    '}';
        }
    }
}
