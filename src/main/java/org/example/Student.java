package org.example;

import java.util.Random;

/*
        Tao 1 class Student voi cac thuoc tinh
        Name
        Id => random 1 chuoi prefix TVN-<number>
        Math: 0-10
        Physic: 0-10
        Chemistry: 0-10
        Constructor: new Student(String name)
      */

public class Student {

    private String name;
    private String id;
    private int math;
    private int physic;
    private int chemistry;

    public Student(String name) {
        this.name = name;
        Random generator = new Random();
        this.id = "TVN-" + generator.nextInt(1000);
        this.math = generator.nextInt(10);
        this.physic = generator.nextInt(10);
        this.chemistry = generator.nextInt(10);
    }

    public void info() {
        System.out.printf("Student name is %s\n", this.name);
        System.out.printf("Student Id is %s\n", this.id);
        System.out.printf("math: %d\n", this.math);
        System.out.printf("physic: %d\n", this.physic);
        System.out.printf("chemistry: %d\n", this.chemistry);
        System.out.println("==============");
    }

    public int totalPoints() {
        return this.math + this.physic + this.chemistry;
    }

    public String getName() {
        return name;
    }

    public int getMath() {
        return math;
    }

    public String getId() {
        return id;
    }

    public int getPhysic() {
        return physic;
    }

    public int getChemistry() {
        return chemistry;
    }
}
