package daywork.daywork02;

import java.util.Scanner;
import java.util.*;

/**
 * 1、程序实现：  用户从控制台随机输入3个数字，程序自动判断求出最大值
 */
public class max {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int a,b,c;
        int max=0;
        System.out.println("请输入3个不同的数字:");
        System.out.println("a=");
        a=input.nextInt();
        System.out.println("b=");
        b=input.nextInt();
        System.out.println("c=");
        c=input.nextInt();
        if(a>b&&a>c){
            max =a;
        }
        else if(b>a&&b>c){
            max =b;
        }
        else{
            max =c;
        }
        System.out.println("3个数字中最大的是: "+max);
//      System.out.println("（函数解）3个数字中最大的是: "+max(a,b,c));
    }

    public static int max(int x,int y,int z){
        int max=0;
        if(x>y&&x>z){
            max =x;
        }
        else if(y>x&&y>z){
            max =y;
        }
        else{
            max =z;
        }
        return max;
    }

}
