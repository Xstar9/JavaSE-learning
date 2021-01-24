package daywork.daywork03;

import java.util.Scanner;

public class calculator {
    public static void main(String[] args) {
        int choice;
        boolean flag=true;
        Scanner input=new Scanner(System.in);
        while(flag){
            double a,b;
            System.out.println("请选择计算器的运算功能: 1.加法 2.减法 3.乘法 4.除法 0.退出 ");
            choice=input.nextInt();
            switch (choice){
                case 1:
                    System.out.print("请输入被加数和加数(空格隔开)：");
                    a=input.nextDouble();
                    b=input.nextDouble();
                    System.out.println(a+"+"+b+"= "+plus(a,b));
                    break;
                case 2:
                    System.out.print("请输入被减数和减数(空格隔开)：");
                    a=input.nextDouble();
                    b=input.nextDouble();
                    System.out.println(a+"-"+b+"= "+minor(a,b));
                    break;
                case 3:
                    System.out.print("请输入被乘数和乘数(空格隔开)：");
                    a=input.nextDouble();
                    b=input.nextDouble();
                    System.out.println(a+"×"+b+"= "+multiply(a,b));
                    break;
                case 4:
                    System.out.print("请输入被除数和除数(空格隔开)：");
                    a=input.nextDouble();
                    b=input.nextDouble();
                    System.out.println(a+"÷"+b+"= "+divide(a,b));
                    break;
                case 0:
                    System.out.println("已关闭计算器.欢迎下次使用~");
                    flag=false;
                    break;
                default:
                    System.out.println("选择有误！请重新选择");
                    break;
            }

        }
    }


    public static double plus(double x,double y){
        return (double)x+(double)y;
    }
    public static double minor(double x,double y){
        return (double)x-(double)y;
    }
    public static double multiply(double x,double y){
        return (double)x*(double)y;
    }
    public static double divide(double x,double y){
        return (double)x/(double)y;
    }

}
