package ood.VendingMachine2.src;

import java.util.Collection;
import java.util.List;

public class Pair<E1, E2> {
    public E1 first;
    public E2 second;

    public Pair(E1 first, E2 second) {
        this.first = first;
        this.second = second;
    }

    public E1 getFirst(){
        return first;
    }

    public E2 getSecond() {
        return second;
    }

}

