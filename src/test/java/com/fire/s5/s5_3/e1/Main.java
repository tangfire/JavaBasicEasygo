package com.fire.s5.s5_3.e1;

// reflection

/**
 * 我们已经能通过Class实例获取所有Field对象，同样的，可以通过Class实例获取所有Method信息。Class类提供了以下几个方法来获取Method：
 *
 * Method getMethod(name, Class...)：获取某个public的Method（包括父类）
 * Method getDeclaredMethod(name, Class...)：获取当前类的某个Method（不包括父类）
 * Method[] getMethods()：获取所有public的Method（包括父类）
 * Method[] getDeclaredMethods()：获取当前类的所有Method（不包括父类）
 * 我们来看一下示例代码：
 *
 * 上述代码首先获取Student的Class实例，然后，分别获取public方法、继承的public方法以及private方法，打印出的Method类似：
 *
 * public int Student.getScore(java.lang.String)
 * public java.lang.String Person.getName()
 * private int Student.getGrade(int)
 * 一个Method对象包含一个方法的所有信息：
 *
 * getName()：返回方法名称，例如："getScore"；
 * getReturnType()：返回方法返回值类型，也是一个Class实例，例如：String.class；
 * getParameterTypes()：返回方法的参数类型，是一个Class数组，例如：{String.class, int.class}；
 * getModifiers()：返回方法的修饰符，它是一个int，不同的bit表示不同的含义。
 *
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Class stdClass = Student.class;
        // 获取public方法getScore，参数为String:
        System.out.println(stdClass.getMethod("getScore", String.class));
        // 获取继承的public方法getName，无参数:
        System.out.println(stdClass.getMethod("getName"));
        // 获取private方法getGrade，参数为int:
        System.out.println(stdClass.getDeclaredMethod("getGrade", int.class));
    }
}

class Student extends Person {
    public int getScore(String type) {
        return 99;
    }
    private int getGrade(int year) {
        return 1;
    }
}

class Person {
    public String getName() {
        return "Person";
    }
}