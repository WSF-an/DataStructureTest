package org.example;

import java.util.Iterator;
import java.util.function.Consumer;

public class SingleList implements Iterable<Integer> {
    @Override
    public Iterator<Integer> iterator() {
        return NodeIterator();
    }

    private  Iterator<Integer> NodeIterator() {
        return new Iterator<Integer>() {
            Node p = head.next;
            @Override
            public boolean hasNext() {
                return p!=null;
            }

            @Override
            public Integer next() {
                int temp = p.value;
                p = p.next;
                return temp;
            }
        };
    }

    private static class Node{
        int value;
        Node next;
        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
    private Node head = new Node(0, null);
    public void addFirst(int value) {
        head.next = new Node(value, head.next);
    }
    public void loop1(){
        Node p = head.next;
        while(p!=null){
            System.out.println(p.value);
            p = p.next;
        }
    }
    public void loop2(Consumer<Integer> consumer){
        for(Node p = head.next;p!=null;p=p.next){
            consumer.accept(p.value);
        }
    }

    /**
     * 递归遍历
     *
     */
    public void loop3(){
        recursion(head.next);
    }

    /**
     *对每一个节点的遍历
     */
    public void recursion(Node curr){
        if(curr==null){
            return;
        }
        //对遍历到的每个节点的值操作
        System.out.println(curr.value);
        recursion(curr.next);
    }
    public Node findLast(){
        Node p=head.next;
        if(p==null){
            return null;
        }
        for(;p.next!=null;p=p.next){}
        return p;
    }
    public Node findNode(int index){
        int i=0;
        //这个时候i就是索引
        for(Node p = head.next;p!=null;p=p.next,i++){
            if(i==index){
                return p;
            }
        }
        return null;
    }
    public void addLast(int value) {
        //先找到tail节点
        Node p = findLast();
        p.next = new Node(value, null);
    }
    public int get(int index){
        Node p = findNode(index);
        if(p==null){
            throw  IllegalIndex(index);
        }
        return p.value;
    }
    public void insert(int index, int value) {
        Node prev = findNode(index-1);
        //当index=0时就是在开头添加
        if(index==0){
            addFirst(value);
        }

        if(prev==null){
            throw IllegalIndex(index);
        }
        Node p = new Node(value, prev.next);
        prev.next = p;
    }
    public int removeFirst(){
        Node p = head.next;
        if(p==null){
            throw  IllegalIndex(0);
        }
        int temp = p.value;
        head.next = p.next;
        return temp;
    }
    public int remove(int index){
        Node prev= findNode(index-1);
        if(index==0){
            return removeFirst();
        }
        if(prev==null){
            throw IllegalIndex(index);
        }
        Node moved = findNode(index);
        if(moved==null){
            throw  IllegalIndex(index);
        }
        prev.next = moved.next;
        return moved.value;
    }

    private static IllegalArgumentException IllegalIndex(int index) {
        return new IllegalArgumentException(String.format("index: %d 无效", index));
    }
}
