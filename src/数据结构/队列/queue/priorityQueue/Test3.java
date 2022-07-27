package 数据结构.队列.queue.priorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Test3 {

    static class  Student{
        private String name;
        private int age;

        public Student(String name,int age){
            this.name =name;
            this.age =age;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
    /**
     * 升序的比较器
     */
    static class StudentAsc implements Comparator<Student>{
        @Override
        public int compare(Student o1, Student o2) {
            return o1.getAge()-o2.getAge();
        }
    }
    /**
     * 降序的比较器
     */
    static class StudentDesc implements Comparator<Student>{
        @Override
        public int compare(Student o1, Student o2) {
            return o2.getAge()-o1.getAge();
        }
    }

    public static void main(String[] args) {
        Student s1 =new Student("胡歌",30);
        Student s2 =new Student("江江",24);
        Student s3 =new Student("浩存",20);
        Queue<Student> queue =new PriorityQueue<>(new StudentDesc());
        queue.offer(s1);
        queue.offer(s2);
        queue.offer(s3);
        while (!queue.isEmpty()){
            System.out.println(queue.poll());
        }
    }
}
