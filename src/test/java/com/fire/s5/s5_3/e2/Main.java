package com.fire.s5.s5_3.e2;// reflection
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


/**
 * 调用方法
 * 当我们获取到一个Method对象时，就可以对它进行调用。我们以下面的代码为例：
 *
 * String s = "Hello world";
 * String r = s.substring(6); // "world"
 * 如果用反射来调用substring方法，需要以下代码：
 */
public class Main {
    public static void main(String[] args) throws Exception {
        // String对象:
        String s = "Hello world";
        // 获取String substring(int)方法，参数为int:
        Method m = String.class.getMethod("substring", int.class);
        // 在s对象上调用该方法并获取结果:
        String r = (String) m.invoke(s, 6);
        // 打印调用结果:
        System.out.println(r); // "world"
    }


    /**
     * 调用静态方法
     * 如果获取到的Method表示一个静态方法，调用静态方法时，由于无需指定实例对象，所以invoke方法传入的第一个参数永远为null。
     *
     * 我们以Integer.parseInt(String)为例：
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    @Test
    public void test01() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // 获取Integer.parseInt(String)方法，参数为String:
        Method m = Integer.class.getMethod("parseInt", String.class);
        // 调用该静态方法并获取结果:
        Integer n = (Integer) m.invoke(null, "12345");
        // 打印调用结果:
        System.out.println(n);
    }


    /**
     * 调用非public方法
     * 和Field类似，对于非public方法，我们虽然可以通过Class.getDeclaredMethod()获取该方法实例，但直接对其调用将得到一个IllegalAccessException。
     * 为了调用非public方法，我们通过Method.setAccessible(true)允许其调用：
     * 此外，setAccessible(true)可能会失败。如果JVM运行期存在SecurityManager，那么它会根据规则进行检查，有可能阻止setAccessible(true)。
     * 例如，某个SecurityManager可能不允许对java和javax开头的package的类调用setAccessible(true)，这样可以保证JVM核心库的安全。
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    @Test
    public void test02() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Person p = new Person();
        Method m = p.getClass().getDeclaredMethod("setName", String.class);
        m.setAccessible(true);
        m.invoke(p, "Bob");
        System.out.println(p.name);
    }

}

class Person{
    String name;
    private void setName(String name) {
        this.name = name;
    }
}