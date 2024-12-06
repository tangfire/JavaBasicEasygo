package com.fire.s3.s3_1.s1.e3.e3_2;

public class Main {
    public static void main(String[] args) {
        Group group = new Group();
        group.setNames(new String[] { "A", "B", "C" });
        group.setNames(null);
    }
}

class Group {
    private String[] names;

    public void setNames(String[] names) {
        this.names = names;
    }
}
