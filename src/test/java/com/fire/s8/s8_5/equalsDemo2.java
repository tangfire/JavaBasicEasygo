package com.fire.s8.s8_5;
import java.util.*;

/**
 * p1和p2都是Person类的对象，虽然地址值不一样，但是内容相同
 *
 * 所以map.get()获取的value值是相同的
 */
public class equalsDemo2 {
    public static void main(String[] args) {
        Person p1 = new Person("zhang",12);
        Map<Person,Integer> map = new HashMap<>();
        map.put(p1,123);
        Person p2 = new Person("zhang",12);
        System.out.println(p1==p2);
        System.out.println(p1.equals(p2));
        System.out.println(map.get(p1));
        System.out.println(map.get(p2));
    }
}

class Person{
    public String name;
    public int age;
    public Person(){}
    public Person(String n,int a){
        name = n;
        age = a;
    }

    @Override    public boolean equals(Object obj) {
        if(obj instanceof Person){
            Person p = (Person) obj;
            return Objects.equals(this.name,p.name) && this.age == p.age;
        }
        return false;
    }

    public int hashCode(){
        return Objects.hash(name,age);
    }
}