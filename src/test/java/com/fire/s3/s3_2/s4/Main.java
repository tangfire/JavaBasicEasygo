package com.fire.s3.s3_2.s4;

import org.junit.jupiter.api.Test;

// Integer:
public class Main {
    public static void main(String[] args) {
        int i = 100;
        // 通过new操作符创建Integer实例(不推荐使用,会有编译警告):
        Integer n1 = new Integer(i);
        // 通过静态方法valueOf(int)创建Integer实例:
        Integer n2 = Integer.valueOf(i);
        // 通过静态方法valueOf(String)创建Integer实例:
        Integer n3 = Integer.valueOf("100");
        System.out.println(n3.intValue());
    }

    @Test
    public void test01() {
        // int和Integer可以互相转换：
        int i = 100;
        Integer n = Integer.valueOf(i);
        int x = n.intValue();

        /**
         * Auto Boxing
         * 这种直接把int变为Integer的赋值写法，称为自动装箱（Auto Boxing），反过来，把Integer变为int的赋值写法，称为自动拆箱（Auto Unboxing）。
         *
         */
        Integer y = 100;
        int z = y;
    }

    /**
     * NullPointerException
     * 装箱和拆箱会影响代码的执行效率，因为编译后的class代码是严格区分基本类型和引用类型的。并且，自动拆箱执行时可能会报NullPointerException：
     */
    @Test
    public void test02() {
        Integer n = null;
        int i = n;
    }

    /**
     * 所有的包装类型都是不变类。我们查看Integer的源码可知，它的核心代码如下：
     *
     * public final class Integer {
     *     private final int value;
     * }
     *
     * 因此，一旦创建了Integer对象，该对象就是不变的。
     *
     * 对两个Integer实例进行比较要特别注意：绝对不能用==比较，因为Integer是引用类型，必须使用equals()比较：
     *
     * 仔细观察结果的童鞋可以发现，==比较，较小的两个相同的Integer返回true，较大的两个相同的Integer返回false，这是因为Integer是不变类，编译器把Integer x = 127;自动变为Integer x = Integer.valueOf(127);，
     *
     * 为了节省内存，Integer.valueOf()对于较小的数，始终返回相同的实例，因此，==比较“恰好”为true，但我们绝不能因为Java标准库的Integer内部有缓存优化就用==比较，必须用equals()方法比较两个Integer。
     *
     * 因为Integer.valueOf()可能始终返回同一个Integer实例，因此，在我们自己创建Integer的时候，以下两种方法：
     *
     * 方法1：Integer n = new Integer(100);
     * 方法2：Integer n = Integer.valueOf(100);
     * 方法2更好，因为方法1总是创建新的Integer实例，方法2把内部优化留给Integer的实现者去做，即使在当前版本没有优化，也有可能在下一个版本进行优化。
     *
     * 我们把能创建“新”对象的静态方法称为静态工厂方法。Integer.valueOf()就是静态工厂方法，它尽可能地返回缓存的实例以节省内存。
     */
    @Test
    public void test03() {
        Integer x = 127;
        Integer y = 127;
        Integer m = 99999;
        Integer n = 99999;
        System.out.println("x == y: " + (x==y)); // true
        System.out.println("m == n: " + (m==n)); // false
        System.out.println("x.equals(y): " + x.equals(y)); // true
        System.out.println("m.equals(n): " + m.equals(n)); // true
    }

    /**
     * 进制转化
     * Integer类本身还提供了大量方法，例如，最常用的静态方法parseInt()可以把字符串解析成一个整数：
     *
     * Integer还可以把整数格式化为指定进制的字符串：
     */
    @Test
    public void test04() {
        int x1 = Integer.parseInt("100"); // 100
        int x2 = Integer.parseInt("100", 16); // 256,因为按16进制解析
        System.out.println(x1); // 100
        System.out.println(x2); // 256

        System.out.println(Integer.toString(100)); // "100",表示为10进制
        System.out.println(Integer.toString(100, 36)); // "2s",表示为36进制
        System.out.println(Integer.toHexString(100)); // "64",表示为16进制
        System.out.println(Integer.toOctalString(100)); // "144",表示为8进制
        System.out.println(Integer.toBinaryString(100)); // "1100100",表示为2进制
    }

    @Test
    public void test05() {
        // boolean只有两个值true/false，其包装类型只需要引用Boolean提供的静态字段:
        Boolean t = Boolean.TRUE;
        Boolean f = Boolean.FALSE;
        // int可表示的最大/最小值:
        int max = Integer.MAX_VALUE; // 2147483647
        int min = Integer.MIN_VALUE; // -2147483648
        // long类型占用的bit和byte数量:
        int sizeOfLong = Long.SIZE; // 64 (bits)
        int bytesOfLong = Long.BYTES; // 8 (bytes)

        // 向上转型为Number:
        Number num = new Integer(999);
        // 获取byte, int, long, float, double:
        byte b = num.byteValue();
        int n = num.intValue();
        long ln = num.longValue();
        float ff = num.floatValue();
        double d = num.doubleValue();

    }

    /**
     * 处理无符号整型
     * 在Java中，并没有无符号整型（Unsigned）的基本数据类型。byte、short、int和long都是带符号整型，最高位是符号位。而C语言则提供了CPU支持的全部数据类型，包括无符号整型。无符号整型和有符号整型的转换在Java中就需要借助包装类型的静态方法完成。
     *
     * 例如，byte是有符号整型，范围是-128~+127，但如果把byte看作无符号整型，它的范围就是0~255。我们把一个负的byte按无符号整型转换为int：
     *
     * 因为byte的-1的二进制表示是11111111，以无符号整型转换后的int就是255。
     *
     * 类似的，可以把一个short按unsigned转换为int，把一个int按unsigned转换为long。
     */
    @Test
    public void test06() {
        byte x = -1;
        byte y = 127;
        System.out.println(Byte.toUnsignedInt(x)); // 255
        System.out.println(Byte.toUnsignedInt(y)); // 127
    }
}