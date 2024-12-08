# 区分继承和组合

在使用继承时，我们要注意逻辑一致性。

考察下面的Book类：

```java
class Book {
    protected String name;
    public String getName() {...}
    public void setName(String name) {...}
}

```

这个Book类也有name字段，那么，我们能不能让Student继承自Book呢？

```java
class Student extends Book {
    protected int score;
}

```

显然，从逻辑上讲，这是不合理的，Student不应该从Book继承，而应该从Person继承。

究其原因，是因为Student是Person的一种，它们是is关系，而Student并不是Book。实际上Student和Book的关系是has关系。

具有has关系不应该使用继承，而是使用组合，即Student可以持有一个Book实例：

```java
class Student extends Person {
    protected Book book;
    protected int score;
}
```

因此，继承是is关系，组合是has关系。

