package fuckingStructure;

import org.junit.Test;

public class Roshan {
    @Test
    public void test() {
        LeftistHeap<Integer> left = new LeftistHeap<>();
        left.build(3, 10, 8, 21, 14, 17, null, null, null, 23, null, 26);
        LeftistHeap<Integer> right = new LeftistHeap<>();
        right.build(6,12,7,18,24,37,18,null,null,33);
        left.merge(right);
        System.out.println(left);
    }
}
