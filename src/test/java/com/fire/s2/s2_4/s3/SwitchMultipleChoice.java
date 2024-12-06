package com.fire.s2.s2_4.s3;

import org.junit.jupiter.api.Test;

public class SwitchMultipleChoice {

    /**
     * switch
     *
     * 如果option的值没有匹配到任何case，例如option = 99，那么，switch语句不会执行任何语句。
     * 这时，可以给switch语句加一个default，当没有匹配到任何case时，执行default：
     */
    @Test
    public void test01(){
        int option = 1;
        switch (option) {
            case 1:
                System.out.println("Selected 1");
                break;
            case 2:
                System.out.println("Selected 2");
                break;
            case 3:
                System.out.println("Selected 3");
                break;
        }
    }

    @Test
    public void test02(){
        int option = 99;
        switch (option) {
            case 1:
                System.out.println("Selected 1");
                break;
            case 2:
                System.out.println("Selected 2");
                break;
            case 3:
                System.out.println("Selected 3");
                break;
            default:
                System.out.println("Selected other");
                break;
        }
    }


    /**
     * 使用switch时，注意case语句并没有花括号{}，而且，case语句具有“穿透性”，漏写break将导致意想不到的结果：
     */
    @Test
    public void test03(){
        int option = 2;
        switch (option) {
            case 1:
                System.out.println("Selected 1");
            case 2:
                System.out.println("Selected 2");
            case 3:
                System.out.println("Selected 3");
            default:
                System.out.println("Selected other");
        }
    }


    /**
     * 如果有几个case语句执行的是同一组语句块，可以这么写：
     */
    @Test
    public void test04(){
        int option = 2;
        switch (option) {
            case 1:
                System.out.println("Selected 1");
                break;
            case 2:
            case 3:
                System.out.println("Selected 2, 3");
                break;
            default:
                System.out.println("Selected other");
                break;
        }
    }


    /**
     * switch语句还可以匹配字符串。字符串匹配时，是比较“内容相等”。例如：
     */
    @Test
    public void test05(){
        String fruit = "apple";
        switch (fruit) {
            case "apple":
                System.out.println("Selected apple");
                break;
            case "pear":
                System.out.println("Selected pear");
                break;
            case "mango":
                System.out.println("Selected mango");
                break;
            default:
                System.out.println("No fruit selected");
                break;
        }

    }


    /**
     * 使用switch时，如果遗漏了break，就会造成严重的逻辑错误，而且不易在源代码中发现错误。从Java 12开始，switch语句升级为更简洁的表达式语法，使用类似模式匹配（Pattern Matching）的方法，保证只有一种路径会被执行，并且不需要break语句：
     *
     * 注意新语法使用->，如果有多条语句，需要用{}括起来。不要写break语句，因为新语法只会执行匹配的语句，没有穿透效应。
     */
    @Test
    public void test06(){
        String fruit = "apple";
        switch (fruit) {
            case "apple" -> System.out.println("Selected apple");
            case "pear" -> System.out.println("Selected pear");
            case "mango" -> {
                System.out.println("Selected mango");
                System.out.println("Good choice!");
            }
            default -> System.out.println("No fruit selected");
        }
    }


    /**
     * 很多时候，我们还可能用switch语句给某个变量赋值。例如：
     * 使用新的switch语法，不但不需要break，还可以直接返回值。把上面的代码改写如下：
     * 这样可以获得更简洁的代码。
     */
    @Test
    public void test07(){
//        int opt;
//        switch (fruit) {
//            case "apple":
//                opt = 1;
//                break;
//            case "pear":
//            case "mango":
//                opt = 2;
//                break;
//            default:
//                opt = 0;
//                break;
//        }

        String fruit = "apple";
        int opt = switch (fruit) {
            case "apple" -> 1;
            case "pear", "mango" -> 2;
            default -> 0;
        }; // 注意赋值语句要以;结束
        System.out.println("opt = " + opt);
    }


    /**
     * yield
     * 大多数时候，在switch表达式内部，我们会返回简单的值。
     *
     * 但是，如果需要复杂的语句，我们也可以写很多语句，放到{...}里，然后，用yield返回一个值作为switch语句的返回值：
     */
    @Test
    public void test08(){
        String fruit = "orange";
        int opt = switch (fruit) {
            case "apple" -> 1;
            case "pear", "mango" -> 2;
            default -> {
                int code = fruit.hashCode();
                yield code; // switch语句返回值
            }
        };
        System.out.println("opt = " + opt);
    }


}
