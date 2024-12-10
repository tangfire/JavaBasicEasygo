package com.fire.s3.s3_2.s7.e1;

/**
 * 编译器默认按照record声明的变量顺序自动创建一个构造方法，并在方法内给字段赋值。那么问题来了，如果我们要检查参数，应该怎么办？
 *
 * 假设Point类的x、y不允许负数，我们就得给Point的构造方法加上检查逻辑：
 *
 * 注意到方法public Point {...}被称为Compact Constructor，它的目的是让我们编写检查逻辑，编译器最终生成的构造方法如下：
 *
 * public final class Point extends Record {
 *     public Point(int x, int y) {
 *         // 这是我们编写的Compact Constructor:
 *         if (x < 0 || y < 0) {
 *             throw new IllegalArgumentException();
 *         }
 *         // 这是编译器继续生成的赋值代码:
 *         this.x = x;
 *         this.y = y;
 *     }
 *     ...
 * }
 *
 *
 * @param x
 * @param y
 */
public record Point(int x,int y) {
    public Point {
        if(x < 0 || y < 0){
            throw new IllegalArgumentException("x and y are negative");
        }
    }

    /**
     * 作为record的Point仍然可以添加静态方法。一种常用的静态方法是of()方法，用来创建Point：
     * @return
     */
    public static Point of() {
        return new Point(0, 0);
    }
    public static Point of(int x, int y) {
        return new Point(x, y);
    }
}
