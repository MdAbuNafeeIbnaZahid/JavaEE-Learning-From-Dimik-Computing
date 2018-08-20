package collection;

import java.util.Stack;

public class StackExample {
    public static void main(String[] args) {
        Stack<Integer> stak = new Stack<>();

        stak.add(0);
        stak.add(1);
        stak.add(2);
        stak.add(3);

        System.out.println( stak.search(0) );
    }
}
