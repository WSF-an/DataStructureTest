package org.example;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;

public class Recursion {

    static LinkedList<Integer> a = new LinkedList();
    static LinkedList<Integer> b = new LinkedList();
    static LinkedList<Integer> c = new LinkedList();
    /**
     * 用递归反向打印字符串
     */
    private static void ReversePrint(int n,String str){
        if(n==str.length())
            return;

        ReversePrint(n+1,str);
        System.out.println(str.charAt(n));
    }

    /**
     *递归实现冒泡排序
     */
    private static void bubble(int[] a,int j){
        if(j==0)
            return;
        //flag标记每次冒泡的最后一次交换
        int flag = 0;
        for(int i=0;i<j;i++){
            if(a[i]>a[i+1]){
                int temp = a[i];
                a[i] = a[i+1];
                a[i+1] = temp;
                flag = i;
            }
        }
        bubble(a,flag);
    }

    /**
     *递归进行插入排序
     * low记录未排序的下界
     */
    private static void insert(int[] a,int low){
         if(low==a.length)
             return;
         int temp = a[low];
         //index为已排序的位置最右端
         int index = low-1;
         while(index>=0&&a[index]>temp){
             a[index+1]=a[index];
             index--;
         }
         //退出循环时即为找到了插入位置
        a[index+1] =temp;
         insert(a,low+1);
    }
    //汉诺塔实验
    static void init(int n){
        for(int i=n;i>=1;i--){
            a.addLast(i);
        }
    }

    /**
     *
     * @param n 表示圆盘个数
     * @param a 源
     * @param b 中间借助
     * @param c 目标地
     */
    public static void move(int n,
                            LinkedList<Integer> a,
                            LinkedList<Integer> b,
                            LinkedList<Integer> c){
        if(n==0){
            return;
        }
        move(n-1,a,c,b);
        c.addLast(a.removeLast());
        pprint();
        move(n-1,b,a,c);
    }

    public static void main(String[] args) {
        String s = "hello world!";
        ReversePrint(0,s);

        int[] array = {6,8,9,2,4,3,7};
        int n = array.length;
        //bubble(a,n-1);
        insert(array,1);
        System.out.println(Arrays.toString(array));
        init(5);
        pprint();
        move(5,a,b,c);

    }

    private static void pprint() {
        System.out.println("-------------------");
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }

}
