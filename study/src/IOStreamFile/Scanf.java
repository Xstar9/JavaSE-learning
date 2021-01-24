package IOStreamFile;

import java.util.Scanner;

/**
 * * Scanner输入： 生成Scanner对象 new Scanner(System.in)
 *  * 定义变量，值为等待输入的控制台变量
 *  * eg: int a=nextInt()   float f=nextFloat()   String str=next()
 */
public class Scanf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入一个int型数据：");
        int a=scanner.nextInt();
        System.out.println(a);
        System.out.println("输入一个float型数据：");
        float b=scanner.nextFloat();
        System.out.println(b);
        System.out.println("输入内容（字符串）：");
        String str=scanner.next();// 读到空格停止
        System.out.println(str);


//        System.out.println("输入一行内容：");
//        String strline = scanner.nextLine();
//        System.out.println(strline);

    }
}
