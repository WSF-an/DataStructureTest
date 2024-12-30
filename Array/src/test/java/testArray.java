import org.example.DoubleLinkedList;
import org.example.DoubleList;
import org.example.DynamicArray;
import org.example.SingleList;
import org.junit.jupiter.api.Test;
import org.springframework.util.StopWatch;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;


public class testArray {

    @Test
    public void test1(){
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(6);
        dynamicArray.addLast(5);
        dynamicArray.addLast(1);
        dynamicArray.addLast(9);
        dynamicArray.foreach((ele)->
        {System.out.println(ele);
        });

    }
    @Test
    public void test2(){
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(6);
        dynamicArray.addLast(5);
        dynamicArray.addLast(1);
        dynamicArray.addLast(9);
        for (Integer ele : dynamicArray) {
            System.out.println(ele);
        }
    }
    @Test
    public void test3(){
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(3);
        dynamicArray.addLast(3);
        dynamicArray.addLast(0);
        dynamicArray.addLast(6);
        dynamicArray.stream().forEach((ele)->
        {System.out.println(ele);
        });
    }
    @Test
    public void test4(){
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(3);
        dynamicArray.addLast(9);
        dynamicArray.addLast(0);
        dynamicArray.addLast(6);
        dynamicArray.addLast(5);
        dynamicArray.remove(2);
        dynamicArray.stream().forEach(ele->{System.out.println(ele);});
    }
    public void ij(int[][] a,int rows,int cols){
        int sum = 0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                sum+=a[i][j];
            }
        }
    }
    public void ji(int[][] a,int rows,int cols){
        int sum = 0;
        for(int j=0;j<cols;j++){
            for(int i=0;i<rows;i++){
                sum+=a[i][j];
            }
        }
        System.out.println(sum);
    }
    @Test
    public void test5(){
        int rows = 1000000;
        int cols = 16;
        int[][] a = new int[rows][cols];
        StopWatch sw = new StopWatch();
        sw.start("ij");
        ij(a,rows,cols);
        sw.stop();
        sw.start("ji");
        ji(a,rows,cols);
        sw.stop();
        System.out.println(sw.prettyPrint());
    }
    @Test
    public void test6(){
        SingleList list = new SingleList();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        //list.loop1();
        list.loop3();
        list.addFirst(6);
        list.addFirst(5);
        list.addLast(9);
        list.insert(2,8);
        int moved = list.removeFirst();
        for (Integer i : list) {
            System.out.println(i);
        }
        System.out.println("removefirst:"+moved);
        System.out.println("index 5 :"+list.get(5));
        list.loop2(ele->{
            System.out.println(ele);
        });
    }
    @Test
    public void test7(){
        DoubleList list = new DoubleList();
//        list.Insert(0,1);
//        list.Insert(1,2);
//        list.Insert(2,3);
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        assertIterableEquals(List.of(1,2,3), list);
    }
    @Test
    public void test8(){
        DoubleLinkedList list = new DoubleLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addFirst(6);
        list.addFirst(5);
        list.removeFirst();
        list.removeLast();
        list.each(ele->{
            System.out.println(ele);
        });
//        assertIterableEquals(List.of(6,1,2,3), list);
    }
}
