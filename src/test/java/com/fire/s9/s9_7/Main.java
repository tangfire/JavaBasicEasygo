package com.fire.s9.s9_7;

import java.io.*;
import java.util.Arrays;

/**
 * 序列化是指把一个Java对象变成二进制内容，本质上就是一个byte[]数组。
 *
 * 为什么要把Java对象序列化呢？因为序列化后可以把byte[]保存到文件中，或者把byte[]通过网络传输到远程，这样，就相当于把Java对象存储到文件或者通过网络传输出去了。
 *
 * 有序列化，就有反序列化，即把一个二进制内容（也就是byte[]数组）变回Java对象。有了反序列化，保存到文件中的byte[]数组又可以“变回”Java对象，或者从网络上读取byte[]并把它“变回”Java对象。
 *
 * 我们来看看如何把一个Java对象序列化。
 *
 * 一个Java对象要能序列化，必须实现一个特殊的java.io.Serializable接口，它的定义如下：
 *
 * public interface Serializable {
 * }
 * Serializable接口没有定义任何方法，它是一个空接口。我们把这样的空接口称为“标记接口”（Marker Interface），实现了标记接口的类仅仅是给自身贴了个“标记”，并没有增加任何方法。
 *
 * 序列化
 * 把一个Java对象变为byte[]数组，需要使用ObjectOutputStream。它负责把一个Java对象写入一个字节流：
 *
 * ObjectOutputStream既可以写入基本类型，如int，boolean，也可以写入String（以UTF-8编码），还可以写入实现了Serializable接口的Object。
 *
 * 因为写入Object时需要大量的类型信息，所以写入的内容很大。
 */
public class Main {
    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        try (ObjectOutputStream output = new ObjectOutputStream(buffer)) {
            // 写入int:
            output.writeInt(12345);
            // 写入String:
            output.writeUTF("Hello");
            // 写入Object:
            output.writeObject(Double.valueOf(123.456));
        }
        System.out.println(Arrays.toString(buffer.toByteArray()));
    }
}

