package daywork.daywork02;

import java.util.Scanner;

/**
 * 2、从控制台输入3个整数，判断是否能够组成三角形
 */

public class isTriangle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a,b,c;
        System.out.println("请输入构造三角形的3条边长:");
        System.out.println("a=");
        a=input.nextInt();
        System.out.println("b=");
        b=input.nextInt();
        System.out.println("c=");
        c=input.nextInt();

        boolean judge=(a+b>c)&&(a+c>b)&&(b+c)>a;
        if(judge){
            System.out.println("a,b,c能 构成三角形~");
        }else{
            System.out.println("a,b,c不能 构成三角形~");
        }

    }

}
