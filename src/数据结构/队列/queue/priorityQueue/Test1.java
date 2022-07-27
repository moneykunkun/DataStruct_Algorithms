package 数据结构.队列.queue.priorityQueue;

import java.util.Arrays;

public class Test1 {

    static class  Student implements Comparable<Student>{
        private String name;
        private int age;

        public Student(String name,int age){
            this.name =name;
            this.age =age;
        }
        @Override
        public int compareTo(Student o) {
            return o.age -this.age;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    public static void main(String[] args) {
        Student s1 =new Student("胡歌",30);
        Student s2 =new Student("江江",24);
        Student s3 =new Student("浩存",20);
        Student[] students =new Student[]{s1,s2,s3};
        Arrays.sort(students);
        System.out.println(Arrays.toString(students));
    }
}
