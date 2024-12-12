package com.fire.s8.s8_2.e2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * List和Array转换
 *
 */
public class Main {
    public static void main(String[] args) {

    }

    /**
     * 把List变为Array有三种方法，第一种是调用toArray()方法直接返回一个Object[]数组：
     * 这种方法会丢失类型信息，所以实际应用很少。
     */
    @Test
    public void test01() {
        List<String> list = List.of("apple", "pear", "banana");
        Object[] array = list.toArray();
        for (Object s : array) {
            System.out.println(s);
        }
    }


    /**
     * 第二种方式是给toArray(T[])传入一个类型相同的Array，List内部自动把元素复制到传入的Array中：
     *
     */
    @Test
    public void test02() {
        List<Integer> list = List.of(12, 34, 56);
        Integer[] array = list.toArray(new Integer[3]);
        for (Integer n : array) {
            System.out.println(n);
        }
    }

    /**
     * 注意到这个toArray(T[])方法的泛型参数<T>并不是List接口定义的泛型参数<E>，所以，我们实际上可以传入其他类型的数组，例如我们传入Number类型的数组，返回的仍然是Number类型：
     */
    @Test
    public void test03() {
        List<Integer> list = List.of(12, 34, 56);
        Number[] array = list.toArray(new Number[3]);
        for (Number n : array) {
            System.out.println(n);
        }
    }

    /**
     * 最后一种更简洁的写法是通过List接口定义的T[] toArray(IntFunction<T[]> generator)方法：
     */
    @Test
    public void test04() {
        List<Integer> list = List.of(12, 34, 56);
        Integer[] array = list.toArray(Integer[]::new);
        for (Integer n : array) {
            System.out.println(n);
        }
    }

    /**
     * 反过来，把Array变为List就简单多了，通过List.of(T...)方法最简单：
     */
    @Test
    public void test05() {
        Integer[] array = { 1, 2, 3 };
        List<Integer> list = List.of(array);
        System.out.println(list);
    }

    /**
     * 对于JDK 11之前的版本，可以使用Arrays.asList(T...)方法把数组转换成List。
     */
    @Test
    public void test06() {
        Integer[] array = { 1, 2, 3 };
        List<Integer> list = Arrays.asList(array);
        System.out.println(list);
    }

    /**
     * 要注意的是，返回的List不一定就是ArrayList或者LinkedList，因为List只是一个接口，如果我们调用List.of()，它返回的是一个只读List：
     * 对只读List调用add()、remove()方法会抛出UnsupportedOperationException。
     */
    @Test
    public void test07() {
        List<Integer> list = List.of(12, 34, 56);
        list.add(999); // UnsupportedOperationException
    }
}
