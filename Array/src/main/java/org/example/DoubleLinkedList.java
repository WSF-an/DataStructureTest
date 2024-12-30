package org.example;
import java.util.Iterator;
import java.util.function.Consumer;


public class DoubleLinkedList implements Iterable<Integer>{
    public DoubleLinkedList() {
        Sentinel.next=Sentinel;
        Sentinel.pre=Sentinel;
    }
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node p=Sentinel.next;
            @Override
            public boolean hasNext() {
                return p!=Sentinel;
            }

            @Override
            public Integer next() {
                int v = p.value;
                p=p.next;
                return v;
            }
        };
    }
    /**
     * 双向环形链表
     */
    private static class Node{
        Node pre;
        int value;
        Node next;
        public Node(Node pre, int value, Node next){
            this.pre = pre;
            this.value = value;
            this.next = next;
        }
    }
    private Node Sentinel=new Node(null,0,null);
    /**
     * 添加addFirst
     */
    public void addFirst(int value) {
        Node a = Sentinel;
        Node b = Sentinel.next;
        Node add = new Node(a, value, b);
        a.next = add;
        b.pre=add;
    }
    /**
     *
     */
    public void addLast(int value) {
        Node a = Sentinel.pre;
        Node b = Sentinel;
        Node add = new Node(a, value, b);
        a.next = add;
        b.pre=add;
    }
    /**
     *
     */
    public void removeFirst() {
        Node removed = Sentinel.next;
        if(removed==Sentinel){
            throw new IllegalArgumentException(String.format("列表为空了"));
        }
        Node next = removed.next;
        Sentinel.next=next;
        next.pre=Sentinel;
    }
    public void removeLast() {
        Node removed = Sentinel.pre;
        if(removed==Sentinel){
            throw new IllegalArgumentException(String.format("列表为空了"));
        }
        Node pre = removed.pre;
        pre.next = Sentinel;
        Sentinel.pre=pre;
    }
    public void each(Consumer<Integer> consumer){
        for(Node p =Sentinel.next;p!=Sentinel;p=p.next){
            consumer.accept(p.value);
        }

    }
}
