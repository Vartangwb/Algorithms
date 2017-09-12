package string;

import java.util.Random;
//https://my.oschina.net/xinxingegeya/blog/705409
/**
 * Created by twb on 2017/9/10.
 */
public class MinHeap<T extends Comparable<T>> {

    //最小堆内部存储的数组
    private Node<T>[] h;
    private int maxCapacity;
    private int capacity;
    private int index;

    public MinHeap(int capacity, int maxCapacity){
        this.capacity = capacity;
        this.maxCapacity = maxCapacity;
        h = new Node[maxCapacity];
    }

    static class Node<T extends Comparable<T>> implements Comparable<Node> {
        private T data;

        public Node(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }


        public int compareTo(Node o) {
            return this.data.compareTo((T) o.getData());
        }
    }

    void swap(int x, int y){
        Node<T> t;
        t = h[x];
        h[x] = h[y];
        h[y] = t;
    }

    void shiftDown(int i){
        int t , flag = 0;
        while(i * 2 <= capacity && flag == 0){
            if(h[i].compareTo(h[i*2]) > 0){
                t = i * 2;
            }else{
                t = i;
            }

            if(i * 2 + 1 <= capacity){
                if(h[t].compareTo(h[i * 2 + 1]) > 0){
                    t = i * 2 + 1;
                }
            }

            if(t != i){
                swap(t, i);
                i = t;
            }else{
                flag = 1;
            }
        }
    }

    void shiftUp(int i){
        int flag = 0;
        if(i == 1)
            return;
        while(i != 1 && flag == 0){
            if(h[i].compareTo(h[i / 2]) < 0){
                swap(i, i / 2);
            } else{
                flag = 1;
            }
            i = i / 2;
        }
    }

    void insert(T data){
        if(capacity < maxCapacity){
            Node<T> node = new Node<T>(data);
            h[++index] = node;
            shiftUp(index);
        }else{
            throw new RuntimeException("head is full");
        }
    }


    /**
     * 使用最小堆进行堆排序
     */
    Node deleteMin(){
        Node node;
        node = h[1];
        h[1] = h[capacity];
        capacity -- ;
        shiftDown(1);
        return node;
    }

    public static void main(String[] args) {
        int maxCapacity = 100;
        int capacity = 9;
        MinHeap<Integer> minHeap = new MinHeap<Integer>(capacity, maxCapacity);
        for(int i = 0; i < capacity; i++){
            Random random = new Random();
            int r = random.nextInt();
            Integer ii = new Integer(Math.abs(r) % 1000);
            minHeap.insert(ii);
        }


        for(int i = 1;i<=capacity;i++){
            System.out.println(minHeap.h[i].getData());
        }
        System.out.println("YEs");
        for (int i = 1; i <= capacity; i++) {
            System.out.println(((Integer) minHeap.deleteMin().getData()));
        }
    }
}
