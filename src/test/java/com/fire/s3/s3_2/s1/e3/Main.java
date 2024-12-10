package com.fire.s3.s3_2.s1.e3;

import org.junit.jupiter.api.Test;

public class Main {
    public static void main(String[] args) {

    }

    @Test
    public void test01(){
        // 是否包含子串:
        System.out.println("Hello".contains("ll")); // true
        System.out.println("Hello".indexOf("l")); // 2
        System.out.println("Hello".lastIndexOf("l"));
        System.out.println("Hello".startsWith("He"));
        System.out.println("Hello".endsWith("lo"));
        System.out.println("Hello".substring(2));
        System.out.println("Hello".substring(2, 4));
    }

    @Test
    public void test02(){
        /**
         * 使用trim()方法可以移除字符串首尾空白字符。空白字符包括空格，\t，\r，\n：
         *
         * 注意：trim()并没有改变字符串的内容，而是返回了一个新字符串。
         *
         * 另一个strip()方法也可以移除字符串首尾空白字符。它和trim()不同的是，类似中文的空格字符\u3000也会被移除：
         *
         * String还提供了isEmpty()和isBlank()来判断字符串是否为空和空白字符串：
         */
        System.out.println("  \tHello\r\n ".trim()); // "Hello";
        System.out.println("\u3000Hello\u3000".strip()); // "Hello"
        System.out.println(" Hello ".stripLeading()); // "Hello "
        System.out.println(" Hello ".stripTrailing()); // " Hello"

        System.out.println("".isEmpty());// true，因为字符串长度为0
        System.out.println("  ".isEmpty());// false，因为字符串长度不为0
        System.out.println("  \n".isBlank());// true，因为只包含空白字符
        System.out.println(" Hello ".isBlank());// false，因为包含非空白字符
    }

    @Test
    public void test03(){
        /**
         * 要在字符串中替换子串，有两种方法。一种是根据字符或字符串替换：
         *
         * 另一种是通过正则表达式替换：
         * String s = "A,,B;C ,D";
         * s.replaceAll("[\\,\\;\\s]+", ","); // "A,B,C,D"
         * 上面的代码通过正则表达式，把匹配的子串统一替换为","。关于正则表达式的用法我们会在后面详细讲解。
         */
        String s = "hello";
        s = s.replace('l', 'w'); // "hewwo"，所有字符'l'被替换为'w'
//        s.replace("ll", "~~"); // "he~~o"，所有子串"ll"被替换为"~~"

        System.out.println(s);
    }

    /**
     * 要分割字符串，使用split()方法，并且传入的也是正则表达式：
     */
    @Test
    public void test04(){

        String s = "A,B,C,D";
        String[] ss = s.split("\\,"); // {"A", "B", "C", "D"}
        for (String c : ss){
            System.out.println(c);
        }
        System.out.println(ss.length);
    }

    /**
     * 拼接字符串使用静态方法join()，它用指定的字符串连接字符串数组：
     */
    @Test
    public void test05(){
        String[] arr = {"A", "B", "C"};
        String s = String.join("***", arr); // "A***B***C"
        System.out.println(s);
    }


    /**
     * 字符串提供了formatted()方法和format()静态方法，可以传入其他参数，替换占位符，然后生成新的字符串：
     *
     * 有几个占位符，后面就传入几个参数。参数类型要和占位符一致。我们经常用这个方法来格式化信息。常用的占位符有：
     *
     * %s：显示字符串；
     * %d：显示整数；
     * %x：显示十六进制整数；
     * %f：显示浮点数。
     * 占位符还可以带格式，例如%.2f表示显示两位小数。如果你不确定用啥占位符，那就始终用%s，因为%s可以显示任何数据类型。
     *
     *
     */
    @Test
    public void test06(){
        String s = "Hi %s, your score is %d!";
        System.out.println(s.formatted("Alice", 80));
        System.out.println(String.format("Hi %s, your score is %.2f!", "Bob", 59.5));
    }

    @Test
    public void test07(){
        /**
         * 要把任意基本类型或引用类型转换为字符串，可以使用静态方法valueOf()。这是一个重载方法，编译器会根据参数自动选择合适的方法：
         */
        String.valueOf(123); // "123"
        String.valueOf(45.67); // "45.67"
        String.valueOf(true); // "true"
        String.valueOf(new Object()); // 类似java.lang.Object@636be97c

        /**
         * 要把字符串转换为其他类型，就需要根据情况。例如，把字符串转换为int类型：
         */
        int n1 = Integer.parseInt("123"); // 123
        int n2 = Integer.parseInt("ff", 16); // 按十六进制转换，255

        /**
         * 把字符串转换为boolean类型：
         */
        boolean b1 = Boolean.parseBoolean("true"); // true
        boolean b2 = Boolean.parseBoolean("FALSE"); // false

        /**
         * 要特别注意，Integer有个getInteger(String)方法，它不是将字符串转换为int，而是把该字符串对应的系统变量转换为Integer：
         */
        Integer.getInteger("java.version"); // 版本号，11


    }

    @Test
    public void test08(){
        /**
         * String和char[]类型可以互相转换，方法是：
         */
        char[] cs = "Hello".toCharArray(); // String -> char[]
        String s = new String(cs); // char[] -> String
        /**
         * 如果修改了char[]数组，String并不会改变：
         *
         * 这是因为通过new String(char[])创建新的String实例时，它并不会直接引用传入的char[]数组，而是会复制一份，所以，修改外部的char[]数组不会影响String实例内部的char[]数组，因为这是两个不同的数组。
         */
        cs[0] = 'x';
        System.out.println(s);
    }
}
