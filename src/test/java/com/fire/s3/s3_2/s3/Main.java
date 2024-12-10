package com.fire.s3.s3_2.s3;

import org.junit.jupiter.api.Test;

import java.util.StringJoiner;

/**
 * 要高效拼接字符串，应该使用StringBuilder。
 *
 * 很多时候，我们拼接的字符串像这样：
 *
 * // 输出: Hello Bob, Alice, Grace!
 * public class Main {
 *     public static void main(String[] args) {
 *         String[] names = {"Bob", "Alice", "Grace"};
 *         var sb = new StringBuilder();
 *         sb.append("Hello ");
 *         for (String name : names) {
 *             sb.append(name).append(", ");
 *         }
 *         // 注意去掉最后的", ":
 *         sb.delete(sb.length() - 2, sb.length());
 *         sb.append("!");
 *         System.out.println(sb.toString());
 *     }
 * }
 *
 * 类似用分隔符拼接数组的需求很常见，所以Java标准库还提供了一个StringJoiner来干这个事：
 */
public class Main {
    public static void main(String[] args) {

    }

    @Test
    public void test01() {
        String[] names = {"Bob", "Alice", "Grace"};
        var sj = new StringJoiner(", ");
        for (String name : names) {
            sj.add(name);
        }
        System.out.println(sj.toString());
    }


    @Test
    public void test02() {
        String[] names = {"Bob", "Alice", "Grace"};
        var sj = new StringJoiner(", ", "Hello ", "!");
        for (String name : names) {
            sj.add(name);
        }
        System.out.println(sj.toString());
    }

    /**
     * String还提供了一个静态方法join()，这个方法在内部使用了StringJoiner来拼接字符串，在不需要指定“开头”和“结尾”的时候，用String.join()更方便：
     */
    @Test
    public void test03() {
        String[] names = {"Bob", "Alice", "Grace"};
        var s = String.join(", ", names);
        System.out.println(s);
    }
}