package com.fire.s9.s9_2;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) {

    }

    /**
     * 我们需要用try ... finally来保证InputStream在无论是否发生IO错误的时候都能够正确地关闭：
     * @throws IOException
     */
    @Test
    public void readFile01() throws IOException {
        InputStream input = null;
        try {
            input = new FileInputStream("src/readme.txt");
            int n;
            while ((n = input.read()) != -1) { // 利用while同时读取并判断
                System.out.println(n);
            }
        } finally {
            if (input != null) { input.close(); }
        }
    }

    /**
     * 用try ... finally来编写上述代码会感觉比较复杂，更好的写法是利用Java 7引入的新的try(resource)的语法，
     * 只需要编写try语句，让编译器自动为我们关闭资源。推荐的写法如下：
     *
     * 实际上，编译器并不会特别地为InputStream加上自动关闭。编译器只看try(resource = ...)中的对象是否实现了java.lang.AutoCloseable接口，如果实现了，就自动加上finally语句并调用close()方法。
     * InputStream和OutputStream都实现了这个接口，因此，都可以用在try(resource)中。
     * @throws IOException
     */
    @Test
    public void readFile02() throws IOException {
        try (InputStream input = new FileInputStream("src/readme.txt")) {
            int n;
            while ((n = input.read()) != -1) {
                System.out.println(n);
            }
        } // 编译器在此自动为我们写入finally并调用close()
    }


    /**
     * 缓冲
     * 在读取流的时候，一次读取一个字节并不是最高效的方法。很多流支持一次性读取多个字节到缓冲区，对于文件和网络流来说，利用缓冲区一次性读取多个字节效率往往要高很多。InputStream提供了两个重载方法来支持读取多个字节：
     *
     * int read(byte[] b)：读取若干字节并填充到byte[]数组，返回读取的字节数
     * int read(byte[] b, int off, int len)：指定byte[]数组的偏移量和最大填充数
     * 利用上述方法一次读取多个字节时，需要先定义一个byte[]数组作为缓冲区，read()方法会尽可能多地读取字节到缓冲区， 但不会超过缓冲区的大小。read()方法的返回值不再是字节的int值，而是返回实际读取了多少个字节。如果返回-1，表示没有更多的数据了。
     *
     * 利用缓冲区一次读取多个字节的代码如下：
     * @throws IOException
     */
    @Test
    public void readFile() throws IOException {
        try (InputStream input = new FileInputStream("src/readme.txt")) {
            // 定义1000个字节大小的缓冲区:
            byte[] buffer = new byte[1000];
            int n;
            while ((n = input.read(buffer)) != -1) { // 读取到缓冲区
                System.out.println("read " + n + " bytes.");
            }
        }
    }


    /**
     * InputStream实现类
     * 用FileInputStream可以从文件获取输入流，这是InputStream常用的一个实现类。
     * 此外，ByteArrayInputStream可以在内存中模拟一个InputStream：
     * @throws IOException
     */
    @Test
    public void readFile3() throws IOException {
        byte[] data = { 72, 101, 108, 108, 111, 33 };
        try (InputStream input = new ByteArrayInputStream(data)) {
            int n;
            while ((n = input.read()) != -1) {
                System.out.println((char)n);
            }
        }
    }
}
