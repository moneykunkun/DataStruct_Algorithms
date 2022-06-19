package 数据结构.队列.queue.priorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueTest1 {
    static class Student{
        String name;
        int age;
        public Student(String name,int age) {
            this.name=name;
            this.age =age;
        }

        public int getAge() {
            return age;
        }
        //升序的比较器
        static class StudentAsc implements Comparator<PriorityQueueTest3.Student> {
            @Override
            public int compare(PriorityQueueTest3.Student o1, PriorityQueueTest3.Student o2) {
                return o1.getAge()-o2.getAge();
            }
        }

        //降序的比较器
        static class StudentDesc implements Comparator<PriorityQueueTest3.Student>{
            @Override
            public int compare(PriorityQueueTest3.Student o1, PriorityQueueTest3.Student o2) {
                return o2.getAge()-o1.getAge();
            }
        }

        public static void main(String[] args) {
            Queue<PriorityQueueTest3.Student> queue =new PriorityQueue<>(new StudentDesc());
            PriorityQueueTest3.Student stu1 =new PriorityQueueTest3.Student("胡歌",18);
            PriorityQueueTest3.Student stu2 =new PriorityQueueTest3.Student("江疏影",20);
            PriorityQueueTest3.Student stu3 =new PriorityQueueTest3.Student("刘浩存",19);
            queue.offer(stu1);
            queue.offer(stu2);
            queue.offer(stu3);
            while (!queue.isEmpty()){
                System.out.println(queue.poll());
            }
        }
        }
}
