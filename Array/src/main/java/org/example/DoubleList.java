package org.example;

import java.util.Iterator;

public class DoubleList implements Iterable<Integer>{
    /**
     * 双向链表带哨兵
     */
    private Node head;
    private Node tail;
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node p = head.next;
            @Override
            public boolean hasNext() {
                return p!= tail;
            }

            @Override
            public Integer next() {
                int v = p.value;
                p = p.next;
                return v;
            }
        };
    }

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

    public DoubleList(){
        head = new Node(null,0,null);
        tail = new Node(null,0,null);
        head.next = tail;
        tail.pre = head;
    }
    public void addLast(int value){
        Node pre = tail.pre;
        Node added = new Node(pre, value,tail);
        pre.next = added;
        tail.pre = added;
    }
    public Node findNode(int index){
        int i = -1;
        for(Node p = head; p!=tail; p=p.next, i++){
            if(i==index){
                return p;
            }

        }
        return null;
    }
    public void addFirst(int value){
        Node behind = head.next;
        Node added = new Node(head, value,behind);
        head.next = added;
        behind.pre = added;
    }
    public void Insert(int index,int value){
        Node pre = findNode(index-1);
        if(pre==null){
            throw new IllegalArgumentException(String.format("不合法参数"+index));
        }
        //只要pre节点找到且不为null,那么pre.next就不会为null，因为设置了尾哨兵tail
        Node next = pre.next;
        Node inserted = new Node(pre, value, next);
        pre.next = inserted;
        next.pre = inserted;
    }
    public void Remove(int index){
        Node pre = findNode(index-1);
        if(pre==null){
            throw new IllegalArgumentException(String.format("不合法参数"+index));
        }
        Node removed = pre.next;
        Node behind = removed.next;
        if(removed==tail){
            throw new IllegalArgumentException(String.format("不合法参数"+index));
        }
        pre.next = behind;
        behind.pre = pre;
    }
    public void RemoveFirst(){
        Remove(0);
    }
    public void RemoveLast(){
        Node removed = tail.pre;
        Node pre = removed.pre;
        pre.next = tail;
        tail.pre = pre;
    }
}
