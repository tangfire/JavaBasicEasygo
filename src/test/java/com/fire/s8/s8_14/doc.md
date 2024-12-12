# 使用Iterator

Java的集合类都可以使用for each循环，List、Set和Queue会迭代每个元素，Map会迭代每个key。以List为例：

```java
List<String> list = List.of("Apple", "Orange", "Pear");
for (String s : list) {
    System.out.println(s);
}
```
实际上，Java编译器并不知道如何遍历List。上述代码能够编译通过，只是因为编译器把for each循环通过Iterator改写为了普通的for循环：

```java
for (Iterator<String> it = list.iterator(); it.hasNext(); ) {
     String s = it.next();
     System.out.println(s);
}
```
我们把这种通过Iterator对象遍历集合的模式称为迭代器。

使用迭代器的好处在于，调用方总是以统一的方式遍历各种集合类型，而不必关心它们内部的存储结构。

例如，我们虽然知道ArrayList在内部是以数组形式存储元素，并且，它还提供了get(int)方法。虽然我们可以用for循环遍历：

```java
for (int i=0; i<list.size(); i++) {
    Object value = list.get(i);
}
```
但是这样一来，调用方就必须知道集合的内部存储结构。并且，如果把ArrayList换成LinkedList，get(int)方法耗时会随着index的增加而增加。如果把ArrayList换成Set，上述代码就无法编译，因为Set内部没有索引。

用Iterator遍历就没有上述问题，因为Iterator对象是集合对象自己在内部创建的，它自己知道如何高效遍历内部的数据集合，调用方则获得了统一的代码，编译器才能把标准的for each循环自动转换为Iterator遍历。

如果我们自己编写了一个集合类，想要使用for each循环，只需满足以下条件：

- 集合类实现Iterable接口，该接口要求返回一个Iterator对象；
- 用Iterator对象迭代集合内部数据。

这里的关键在于，集合类通过调用iterator()方法，返回一个Iterator对象，这个对象必须自己知道如何遍历该集合。