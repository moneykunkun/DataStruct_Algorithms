package 数据结构.队列.queue.priorityQueue;

import java.util.*;
import java.util.PriorityQueue;

/**
 * JDK中优先级队列的最小堆实现
 */
public class PriorityQueueTest3 {

    static class Student implements Comparable<Student>{
        String name;
        int age;
        public Student(String name,int age) {
            this.name=name;
            this.age =age;
        }

        public int getAge() {
            return age;
        }

        @Override
        public boolean equals(Object o) {
            if (o==null){
                return false;
            }
            if (this==o){
                return true;
            }
            if (!(o instanceof Student)){
                return false;
            }
            //向下转型
            Student stu =(Student) o;
            return this.age ==stu.age && this.name.equals(stu.name);
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

        @Override
        public int compareTo(Student o) {
            return this.age-o.age;
        }
    }

    //升序的比较器
    static class StudentAsc implements Comparator<Student>{
        @Override
        public int compare(Student o1, Student o2) {
            return o1.getAge()-o2.getAge();
        }
    }

    //降序的比较器
    static class StudentDesc implements Comparator<Student>{
        @Override
        public int compare(Student o1, Student o2) {
            return o2.getAge()-o1.getAge();
        }
    }
    public static void main(String[] args) {
        Queue<Student> queue =new PriorityQueue<>();
        Student stu1 =new Student("胡歌",18);
        Student stu2 =new Student("江疏影",20);
        Student stu3 =new Student("刘浩存",19);
        Student[] students ={stu1,stu2,stu3};
        Arrays.sort(students, new StudentDesc());
        System.out.println(Arrays.toString(students));
        System.out.println(stu1.equals(stu1));
        System.out.println(stu1.compareTo(stu3));
    }
}
