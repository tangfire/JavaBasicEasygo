package com.fire.s3.s3_2.s6.e2;

// enum

/**
 * 改变枚举常量定义的顺序就会导致ordinal()返回值发生变化。例如：
 *
 * public enum Weekday {
 *     SUN, MON, TUE, WED, THU, FRI, SAT;
 * }
 * 和
 *
 * public enum Weekday {
 *     MON, TUE, WED, THU, FRI, SAT, SUN;
 * }
 * 的ordinal就是不同的。如果在代码中编写了类似if(x.ordinal()==1)这样的语句，就要保证enum的枚举顺序不能变。新增的常量必须放在最后。
 *
 * 有些童鞋会想，Weekday的枚举常量如果要和int转换，使用ordinal()不是非常方便？比如这样写：
 *
 * String task = Weekday.MON.ordinal() + "/ppt";
 * saveToFile(task);
 * 但是，如果不小心修改了枚举的顺序，编译器是无法检查出这种逻辑错误的。要编写健壮的代码，就不要依靠ordinal()的返回值。
 *
 * 因为enum本身是class，所以我们可以定义private的构造方法，并且，给每个枚举常量添加字段：
 *
 * 这样就无需担心顺序的变化，新增枚举常量时，也需要指定一个int值。
 *
 * 注意:枚举类的字段也可以是非final类型，即可以在运行期修改，但是不推荐这样做！
 */

public class Main {
    public static void main(String[] args) {
        Weekday day = Weekday.SUN;
        if (day.dayValue == 6 || day.dayValue == 0) {
            System.out.println("Work at home!");
        } else {
            System.out.println("Work at office!");
        }
    }
}

enum Weekday {
    MON(1), TUE(2), WED(3), THU(4), FRI(5), SAT(6), SUN(0);

    public final int dayValue;

    private Weekday(int dayValue) {
        this.dayValue = dayValue;
    }
}