# extends通配符的作用

如果我们考察Java标准库的java.util.List<T>接口，它实现的是一个类似“可变数组”的列表，主要功能包括：

```java
public interface List<T> {
    int size(); // 获取个数
    T get(int index); // 根据索引获取指定元素
    void add(T t); // 添加一个新元素
    void remove(T t); // 删除一个已有元素
}
```

现在，让我们定义一个方法来处理列表的每个元素：

```java
int sumOfList(List<? extends Integer> list) {
    int sum = 0;
    for (int i=0; i<list.size(); i++) {
        Integer n = list.get(i);
        sum = sum + n;
    }
    return sum;
}
```

为什么我们定义的方法参数类型是List<? extends Integer>而不是List<Integer>？从方法内部代码看，传入List<? extends Integer>或者List<Integer>是完全一样的，但是，注意到List<? extends Integer>的限制：

- 允许调用get()方法获取Integer的引用；
- 不允许调用set(? extends Integer)方法并传入任何Integer的引用（null除外）。

因此，方法参数类型List<? extends Integer>表明了该方法内部只会读取List的元素，不会修改List的元素（因为无法调用add(? extends Integer)、remove(? extends Integer)这些方法。换句话说，这是一个对参数List<? extends Integer>进行只读的方法（恶意调用set(null)除外）。


# 使用extends限定T类型

在定义泛型类型Pair<T>的时候，也可以使用extends通配符来限定T的类型：

```java
public class Pair<T extends Number> { ... }
```

现在，我们只能定义：

```java
Pair<Number> p1 = null;
Pair<Integer> p2 = new Pair<>(1, 2);
Pair<Double> p3 = null;
```

因为Number、Integer和Double都符合<T extends Number>。

非Number类型将无法通过编译：

```java
Pair<String> p1 = null; // compile error!
Pair<Object> p2 = null; // compile error!
```

因为String、Object都不符合<T extends Number>，因为它们不是Number类型或Number的子类。

## 小结

使用类似<? extends Number>通配符作为方法参数时表示：

- 方法内部可以调用获取Number引用的方法，例如：Number n = obj.getFirst();；
- 方法内部无法调用传入Number引用的方法（null除外），例如：obj.setFirst(Number n);。

即一句话总结：使用extends通配符表示可以读，不能写。

使用类似<T extends Number>定义泛型类时表示：

- 泛型类型限定为Number以及Number的子类。