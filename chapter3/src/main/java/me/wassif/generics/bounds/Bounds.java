package me.wassif.generics.bounds;

import java.util.ArrayList;
import java.util.List;

class A {
}

class B extends A {
}

class C extends B {
}

class D extends C {
}

public class Bounds {
    public static void main(String[] args) {
        // when we work with upper bounds or unbounded wildcards
        // The list becomes logically immutable
        // Unbounded Wildcards
        @SuppressWarnings("unused")
        List<?> listc = new ArrayList<C>();
        // listc.add(new D()); // does not compile
        // Lower bounded list
        List<? extends A> listb = new ArrayList<B>();
        List<B> mlistb = new ArrayList<B>();
        mlistb.add(new B());
        mlistb.add(new C());
        mlistb.add(new D());
        listb = mlistb;
        // listb.add(new D()); // Does not compile
        listb.remove(0);
        System.out.println(listb);
        // Upper bounded
        List<? super C> lista = new ArrayList<A>();
        // lista.add(new B()); // Does not compile
        lista.add(new C());
        lista.add(new D());
    }

    public <T extends A> T identity(T t) {
        return t;
    }

    public void printList(List<? super C> list) {
    }

    // parameter type B hide the type B
    @SuppressWarnings("hiding")
    public <B> B func(List<? extends B> list) {
        return null;
    }
}
