package com.fire.s3.s3_2.s7.e1;

// Record

/**
 * 使用String、Integer等类型的时候，这些类型都是不变类，一个不变类具有以下特点：
 *
 * 定义class时使用final，无法派生子类；
 * 每个字段使用final，保证创建实例后无法修改任何字段。
 *
 * 使用record关键字，可以一行写出一个不变类。
 *
 * 和enum类似，我们自己不能直接从Record派生，只能通过record关键字由编译器实现继承。
 */
public class Main {
    public static void main(String[] args) {
        Point p = new Point(123, 456);
        System.out.println(p.x());
        System.out.println(p.y());
        System.out.println(p);

        var z = Point.of();
        var l = Point.of(123,456);
        System.out.println(z);
        System.out.println(l);
    }
}

//record Point(int x, int y) {}





