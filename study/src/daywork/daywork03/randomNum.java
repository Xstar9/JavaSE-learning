package daywork.daywork03;

import java.util.Random;
import java.util.Scanner;

public class randomNum {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        boolean flag=true;
        int guess,num,ans;
        System.out.println("这是一个猜数游戏~");
        while (flag){
            System.out.print("请输入您想要猜取的数字范围(提示:输入100，即范围在(0-100))： ");
            num=input.nextInt();
            ans=GenerateRandom(num);

            while(true){
                System.out.println("\n请输入您猜取的数字： ");
                guess=input.nextInt();
                if(guess!=ans){
                    System.out.print("猜错了~再试一次");
                    continue;
                }
                else{
                    break;
                }
            }
            System.out.println("恭喜您~猜对了！这个数就是："+ans);
            System.out.println("请按任意数字键继续   退出请输入：0");
            int choice=input.nextInt();
            if(choice==0){
                flag=false;
                System.out.println("已退出游戏~");
            }

        }
    }

    public static int GenerateRandom(int num){
        Random random=new Random();
        return random.nextInt(num)+1;
    }

}
