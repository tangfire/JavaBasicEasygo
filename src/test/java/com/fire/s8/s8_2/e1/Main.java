package com.fire.s8.s8_2.e1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

    }

    /**
     * List的特点
     * 使用List时，我们要关注List接口的规范。List接口允许我们添加重复的元素，即List内部的元素可以重复：
     */
    @Test
    public void test01() {
        List<String> list = new ArrayList<>();
        list.add("apple"); // size=1
        list.add("pear"); // size=2
        list.add("apple"); // 允许重复添加元素，size=3
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println(list.size());
    }

    /**
     * List还允许添加 null
     */
    @Test
    public void test02() {
        List<String> list = new ArrayList<>();
        list.add("apple"); // size=1
        list.add(null); // size=2
        list.add("pear"); // size=3
        String second = list.get(1); // null
        System.out.println(second);
    }


    /**
     * 创建List
     * 除了使用ArrayList和LinkedList，我们还可以通过List接口提供的of()方法，根据给定元素快速创建List：
     *
     * List<Integer> list = List.of(1, 2, 5);
     * 但是List.of()方法不接受null值，如果传入null，会抛出NullPointerException异常。
     *
     * 遍历List
     * 和数组类型类似，我们要遍历一个List，完全可以用for循环根据索引配合get(int)方法遍历：
     */
    @Test
    public void test03() {
        List<String> list = List.of("apple", "pear", "banana");

        /**
         * for
         */
        for (int i=0; i<list.size(); i++) {
            String s = list.get(i);
            System.out.println(s);
        }

        System.out.println("-------------------------------");

        /**
         * 但这种方式并不推荐，一是代码复杂，二是因为get(int)方法只有ArrayList的实现是高效的，换成LinkedList后，索引越大，访问速度越慢。
         *
         * 所以我们要始终坚持使用迭代器Iterator来访问List。Iterator本身也是一个对象，但它是由List的实例调用iterator()方法的时候创建的。Iterator对象知道如何遍历一个List，并且不同的List类型，返回的Iterator对象实现也是不同的，但总是具有最高的访问效率。
         *
         * Iterator对象有两个方法：boolean hasNext()判断是否有下一个元素，E next()返回下一个元素。因此，使用Iterator遍历List代码如下：
         */
        for (Iterator<String> it = list.iterator(); it.hasNext(); ) {
            String s = it.next();
            System.out.println(s);
        }

        System.out.println("----------------------------------");

        /**
         * 有童鞋可能觉得使用Iterator访问List的代码比使用索引更复杂。
         *
         * 但是，要记住，通过Iterator遍历List永远是最高效的方式。
         *
         * 并且，由于Iterator遍历是如此常用，所以，Java的for each循环本身就可以帮我们使用Iterator遍历。
         *
         * 把上面的代码再改写如下：
         */
        for (String s : list) {
            System.out.println(s);
        }

        /**
         * 上述代码就是我们编写遍历List的常见代码。
         *
         * 实际上，只要实现了Iterable接口的集合类都可以直接用for each循环来遍历，Java编译器本身并不知道如何遍历集合对象，但它会自动把for each循环变成Iterator的调用，原因就在于Iterable接口定义了一个Iterator<E> iterator()方法，强迫集合类必须返回一个Iterator实例。
         */
    }
}
