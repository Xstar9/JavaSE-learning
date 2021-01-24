package daywork.daywork02;

import java.util.Scanner;

/**
 * 4、用户从控制台随机输入10次数字，  通过程序分别统计出 >0  、 =0 、  <0  的数字出现次数  。
 */


public class judgeZero {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int greater=0,smaller=0,equal=0;
        int n=10;
        System.out.println("请输入10个数字:");
        while(n!=0){
            int num=input.nextInt();
            if(num>0){
                greater++;
            }
            else if(num<0){
                smaller++;
            }
            else{
                equal++;
            }
            n--;
        }
        System.out.println(">0的数字出现次数: "+greater);
        System.out.println("<0的数字出现次数: "+smaller);
        System.out.println("=0的数字出现次数: "+equal);
    }

}
