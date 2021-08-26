package ood.VendingMachine2.test;

import static org.junit.Assert.*;

public class PairTest {

    @org.junit.Test
    public void getFirst() {
        Pair<String, Integer> b = new Pair<>("abc", 123);
        assertNotEquals("abd", b.getFirst());
    }

    @org.junit.Test
    public void getSecond() {

    }
}