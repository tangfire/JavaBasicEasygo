package com.fire.s7.s7_5.e2;


/**
 * 不出意外，我们会得到一个编译错误：
 *
 * incompatible types: Integer cannot be converted to CAP#1
 * where CAP#1 is a fresh type-variable:
 *     CAP#1 extends Number from capture of ? extends Number
 * 编译错误发生在p.setFirst()传入的参数是Integer类型。有些童鞋会问了，既然p的定义是Pair<? extends Number>，那么setFirst(? extends Number)为什么不能传入Integer？
 *
 * 原因还在于擦拭法。如果我们传入的p是Pair<Double>，显然它满足参数定义Pair<? extends Number>，然而，Pair<Double>的setFirst()显然无法接受Integer类型。
 *
 * 这就是<? extends Number>通配符的一个重要限制：方法参数签名setFirst(? extends Number)无法传递任何Number的子类型给setFirst(? extends Number)。
 *
 * 这里唯一的例外是可以给方法参数传入null：
 *
 * p.setFirst(null); // ok, 但是后面会抛出NullPointerException
 * p.getFirst().intValue(); // NullPointerException
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
//        p.setFirst(new Integer(first.intValue() + 100));
//        p.setLast(new Integer(last.intValue() + 100));
        return p.getFirst().intValue() + p.getLast().intValue();
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
    public void setFirst(T first) {
        this.first = first;
    }
    public void setLast(T last) {
        this.last = last;
    }
}