package 顺序表;

public class Test {
    public static void main(String[] args) {
        MyArray myArray =new MyArray(3);
        myArray.addLast(1);
        myArray.addLast(3);
        myArray.addLast(5);
        myArray.addLast(7);
        System.out.println(myArray);

        myArray.addFirst(10);
        myArray.addFirst(11);
        myArray.addFirst(12);
        System.out.println(myArray);
    }
}
