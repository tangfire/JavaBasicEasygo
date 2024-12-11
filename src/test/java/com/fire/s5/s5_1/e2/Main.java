package com.fire.s5.s5_1.e2;

// reflection

import org.junit.jupiter.api.Test;

/**
 * 因为反射的目的是为了获得某个实例的信息。因此，当我们拿到某个Object实例时，我们可以通过反射获取该Object的class信息：
 *
 * void printObjectInfo(Object obj) {
 *     Class cls = obj.getClass();
 * }
 * 要从Class实例获取获取的基本信息，参考下面的代码：
 *
 * 注意到数组（例如String[]）也是一种类，而且不同于String.class，它的类名是[Ljava.lang.String;。
 *
 * 此外，JVM为每一种基本类型如int也创建了Class实例，通过int.class访问。
 */
public class Main {
    public static void main(String[] args) {
        printClassInfo("".getClass());
        printClassInfo(Runnable.class);
        printClassInfo(java.time.Month.class);
        printClassInfo(String[].class);
        printClassInfo(int.class);
    }

    static void printClassInfo(Class cls) {
        System.out.println("Class name: " + cls.getName());
        System.out.println("Simple name: " + cls.getSimpleName());
        if (cls.getPackage() != null) {
            System.out.println("Package name: " + cls.getPackage().getName());
        }
        System.out.println("is interface: " + cls.isInterface());
        System.out.println("is enum: " + cls.isEnum());
        System.out.println("is array: " + cls.isArray());
        System.out.println("is primitive: " + cls.isPrimitive());
    }

    /**
     * 如果获取到了一个Class实例，我们就可以通过该Class实例来创建对应类型的实例：
     *
     * 代码相当于new String()。通过Class.newInstance()可以创建类实例，它的局限是：只能调用public的无参数构造方法。带参数的构造方法，或者非public的构造方法都无法通过Class.newInstance()被调用。
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    @Test
    public void test01() throws InstantiationException, IllegalAccessException {
        // 获取String的Class实例:
        Class cls = String.class;
        // 创建一个String实例:
        String s = (String) cls.newInstance();
    }
}