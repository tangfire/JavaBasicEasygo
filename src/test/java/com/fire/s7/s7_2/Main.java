package com.fire.s7.s7_2;// sort
import java.util.Arrays;

/**
 * 泛型接口
 * 除了ArrayList<T>使用了泛型，还可以在接口中使用泛型。
 * 例如，Arrays.sort(Object[])可以对任意数组进行排序，但待排序的元素必须实现Comparable<T>这个泛型接口：
 *
 * 小结
 * 使用泛型时，把泛型参数<T>替换为需要的class类型，例如：ArrayList<String>，ArrayList<Number>等；
 *
 * 可以省略编译器能自动推断出的类型，例如：List<String> list = new ArrayList<>();；
 *
 * 不指定泛型参数类型时，编译器会给出警告，且只能将<T>视为Object类型；
 *
 * 可以在接口中定义泛型类型，实现此接口的类必须实现正确的泛型类型。
 */
public class Main {
    public static void main(String[] args) {
        Person[] ps = new Person[] {
            new Person("Bob", 61),
            new Person("Alice", 88),
            new Person("Lily", 75),
        };
        Arrays.sort(ps);
        System.out.println(Arrays.toString(ps));
    }
}

class Person implements Comparable<Person> {
    String name;
    int score;
    Person(String name, int score) {
        this.name = name;
        this.score = score;
    }
    public int compareTo(Person other) {
        return this.name.compareTo(other.name);
    }
    public String toString() {
        return this.name + "," + this.score;
    }
}