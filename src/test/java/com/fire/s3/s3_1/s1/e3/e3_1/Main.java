package com.fire.s3.s3_1.s1.e3.e3_1;

/**
 * 可变参数
 *
 * 可变参数用类型...定义，可变参数相当于数组类型：
 *
 * 可变参数可以保证无法传入null，因为传入0个参数时，接收到的实际值是一个空数组而不是null。
 *
 * 如果把可变参数改写为String[]类型，可以传入null
 */
public class Main {
   public static void main(String[] args) {
       Group g = new Group();
       g.setNames("Xiao Ming", "Xiao Hong", "Xiao Jun"); // 传入3个String
       g.setNames("Xiao Ming", "Xiao Hong"); // 传入2个String
       g.setNames("Xiao Ming"); // 传入1个String
       g.setNames(); // 传入0个String
   }
}

class Group {
    private String[] names;

    public void setNames(String... names) {
        this.names = names;
    }
}
