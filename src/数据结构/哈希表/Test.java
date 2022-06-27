package 数据结构.哈希表;

public class Test {
    public static void main(String[] args) {

        MyHashMap map =new MyHashMap(4);
        map.add(1,10);
        map.add(2,20);
        map.add(5,55);
        System.out.println(map.containsKey(1));
        System.out.println(map.containsKey(3));
        System.out.println(map.containsValue(20));
        System.out.println(map.containsValue(60));
    }

}
