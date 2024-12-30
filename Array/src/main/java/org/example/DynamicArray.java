package org.example;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class DynamicArray implements Iterable<Integer> {
    private int size = 0;
    private int capacity = 8;
    private int[] array  = {};

    public int get(int index){
        return array[index];
    }
    public void addLast(int element){
//        array[size] = element;
//        size++;
        add(size, element);
    }
    //在index索引下插入元素
    public void add(int index, int element){
        //先检查容量，必要时进行扩容
        checkAndGrow();
        if(index >=0 && index<size){
            System.arraycopy(array, index, array, index+1, size - index);
        }
        array[index] = element;
        size++;
    }
    //使用的函数式接口
    //遍历方法1 consumer
    public void foreach(Consumer<Integer> consumer){
        for(int i = 0; i < size; i++){
            consumer.accept(array[i]);
        }
    }
    //继承Iterable接口实现迭代器循环
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int i=0;
            @Override
            public boolean hasNext() {
                //判断还有无元素
                return i<size;
            }

            @Override
            public Integer next() {
                return array[i++];
            }
        };
    }
    public IntStream stream(){
        //将数组变成流
        //需要传入数组的有效部分
        return IntStream.of(Arrays.copyOfRange(array, 0, size));
    }

    public int remove(int index){
        int removed = array[index];
        if(index<size&&index>=0){
            System.arraycopy(array, index+1, array, index, size-index-1);
        }
        size--;
        return removed;
    }

    private void checkAndGrow() {
        //扩容逻辑
        if(size==0){
            array =new int[capacity];
        }
        else if(size==capacity){
            capacity +=capacity>>1;
            int[] newArray = new int[capacity];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
    }
}
