package com.fire.s7.s7_5.e1;

/**
 * 使用Pair<? extends Number>使得方法接收所有泛型类型为Number或Number子类的Pair类型。
 *
 * 这样一来，给方法传入Pair<Integer>类型时，它符合参数Pair<? extends Number>类型。这种使用<? extends Number>的泛型定义称之为上界通配符（Upper Bounds Wildcards），即把泛型类型T的上界限定在Number了。
 *
 * 除了可以传入Pair<Integer>类型，我们还可以传入Pair<Double>类型，Pair<BigDecimal>类型等等，因为Double和BigDecimal都是Number的子类。
 */
public class Main {
    public static void main(String[] args) {
        Pair<Integer> p = new Pair<>(123, 456);
        int n = add(p);
        System.out.println(n);
    }

    static int add(Pair<? extends Number> p) {
        Number first = p.getFirst();
        Number last = p.getLast();
        return first.intValue() + last.intValue();
    }
}

class Pair<T> {
    private T first;
    private T last;
    public Pair(T first, T last) {
        this.first = first;
        this.last = last;
    }
    public T getFirst() {
        return first;
    }
    public T getLast() {
        return last;
    }
}