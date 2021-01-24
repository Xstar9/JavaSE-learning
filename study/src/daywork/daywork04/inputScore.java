package daywork.daywork04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class inputScore {
    public static void main(String[] args) {
        //List<Integer> scores=new ArrayList<Integer>();
        Scanner input=new Scanner(System.in);
        int stuScore[]={};
        ImportScore(stuScore);
    }

    public static void ImportScore(int scores[]){
        Scanner input=new Scanner(System.in);
        int flag=1;

        System.out.println("---欢迎使用学生成绩导入系统---");
        while(flag==1){
            System.out.println("请输入需要导入的学生成绩(输入 -1 结束导入): ");
            while(true){
                int score[]=new int[1];// 存储每次输入的成绩

                score[0]=input.nextInt();
                if(score[0]==-1){
//                System.out.println(Arrays.toString(scores));
                    break;
                }else{
                    // 先copyOf扩充长度，在将存储的成绩复制arraycopy，从scores.length-1开始粘贴
                    scores=Arrays.copyOf(scores,scores.length+1);
                    System.arraycopy(score,0,scores,scores.length-1,1);
                }
            }

            System.out.println("已导入的"+scores.length+"名学生成绩如下:");
            for(int i:scores){
                System.out.println(i);
            }
            System.out.println("继续导入请输入: 1   退出系统输入: 0");
            flag=input.nextInt();
        }
        System.out.println("欢迎下次使用~");
    }

}
