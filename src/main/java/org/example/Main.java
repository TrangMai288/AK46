package org.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    /**
     * tim phan tu lon nhat trong 1 mang
     * [1, 4, 9, 0, 2, 8]
     * tim index phan tu lon nhat
     * Array vs List vs Set
     */
    public static void main(String[] args) {
        /*
        int[] arr = {1, 4, 9, 0, 2, 8};
        int max1 = Arrays.stream(arr).max().getAsInt();
        System.out.println("max = " + max1);

        int min1 = Arrays.stream(arr).min().getAsInt();
        System.out.println("min = " + min1);

        List<Integer> list = Arrays.stream(arr).boxed().toList();
        int maxIndex1 = list.indexOf(max1);
        System.out.println("max = " + maxIndex1);

         */

        /*
        if (arr.length == 0) throw new IllegalArgumentException("mang rong");
        int max = arr[0];
        int maxIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                maxIndex = i;
            }
        }
        System.out.println("Phan tu lon nhat trong mang la " + max);
        System.out.println("Vi tri cua phan tu lon nhat trong mang la " + maxIndex);
         */

        /**
            Tao 1 class Student voi cac thuoc tinh
            Name
            Id => random 1 chuoi prefix TVN-<number>
            Math: 0-10
            Physic: 0-10
            Chemistry: 0-10
            Constructor: new Student(String name)
         */
        /*
        Student studentA = new Student("Vy");
        studentA.info();
         */

        /**
         * Tao 1 danh sach 10 student
         * tim student co diem mon Toan cao nhat
         */
        List<Student> students = List.of(
                new Student("Trang1"),
                new Student("Trang2"),
                new Student("Trang3"),
                new Student("Trang4"),
                new Student("Trang5"),
                new Student("Trang6"),
                new Student("Trang7"),
                new Student("Trang8"),
                new Student("Trang9"),
                new Student("Trang10")
        );

        // todo: in ra danh sach cac student
//        for (Student student : students) {
//            student.info();
//        }

        // todo: get student has max math point
        Student studentMaxMathPoint = students
                .stream()
                .max(Comparator.comparing(Student::getMath))
                .get();
        //studentMaxMathPoint.info();

        // todo: get list of math point
        List<Integer> listOfMathPoint = students
                .stream()
                .map(Student::getMath)
                .toList();
        //listOfMathPoint.forEach(math -> System.out.println(math));

        // todo: sort theo name
        List<Student> studentSortByName = students
                .stream()
                .sorted(Comparator.comparing(Student::getName))
                .toList();
        //studentSortByName.forEach(student -> System.out.println(student.getName()));

        // todo: filter student physics > 5
        List<Student> studentFilterByPhysicPoint = students
                .stream()
                .filter(student -> student.getPhysic() > 5)
                .toList();
        //studentFilterByPhysicPoint.forEach(Student::info);

        // todo: sort theo diem tung mon
        List<Student> studentSortByMathPoint = students
                .stream()
                .sorted(Comparator.comparing(Student::getMath))
                .toList();
        studentSortByMathPoint.forEach(Student::info);

        // todo: sort theo tong diem 3 mon
        List<Student> studentSortByTotalPoint = students
                .stream()
                .sorted(Comparator.comparing(Student::totalPoints))
                .toList();
        studentSortByTotalPoint.forEach(Student::info);





    }
}