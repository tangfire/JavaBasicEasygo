package com.fire.s9.s9_3;

import org.junit.jupiter.api.Test;

import java.io.*;

public class Main {
    public static void main(String[] args) {

    }

    /**
     * FileOutputStream
     * 我们以FileOutputStream为例，演示如何将若干个字节写入文件流：
     * @throws IOException
     */
    @Test
    public void writeFile01() throws IOException {
        try (OutputStream output = new FileOutputStream("src/readme.txt")) {
            output.write("Hello".getBytes("UTF-8")); // Hello
        } // 编译器在此自动为我们写入finally并调用close()
    }


    /**
     * OutputStream实现类
     * 用FileOutputStream可以从文件获取输出流，这是OutputStream常用的一个实现类。
     * 此外，ByteArrayOutputStream可以在内存中模拟一个OutputStream：
     *
     * ByteArrayOutputStream实际上是把一个byte[]数组在内存中变成一个OutputStream，虽然实际应用不多，但测试的时候，可以用它来构造一个OutputStream。
     * @throws IOException
     */
    @Test
    public void writeFile02() throws IOException {
        byte[] data;
        try (ByteArrayOutputStream output = new ByteArrayOutputStream()) {
            output.write("Hello ".getBytes("UTF-8"));
            output.write("world!".getBytes("UTF-8"));
            data = output.toByteArray();
        }
        System.out.println(new String(data, "UTF-8"));
    }

    @Test
    public void writeFile03() throws IOException {
        // 读取input.txt，写入output.txt:
        try (InputStream input = new FileInputStream("src/input.txt");
             OutputStream output = new FileOutputStream("src/output.txt"))
        {
            input.transferTo(output); // transferTo的作用是?
            /**
             * input.transferTo(output) 的作用：
             *
             * transferTo 方法 是 InputStream 提供的一个便捷方法（自 Java 9 引入）。
             * 它会将当前输入流的所有数据直接写入目标输出流 output。
             * 其内部实际上是一个高效的循环读取和写入操作，可以使用底层机制（如 FileChannel）来提高性能。
             *
             * 示例
             * 假设 input.txt 文件内容如下：
             *
             * Hello, World!
             * This is a test file.
             * 运行代码后，会在同目录生成 output.txt 文件，内容与 input.txt 完全一致：
             *
             * Hello, World!
             * This is a test file.
             */
        }
    }
}
