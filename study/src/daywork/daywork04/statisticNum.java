package daywork.daywork04;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class statisticNum {
    public static void main(String[] args) {
        int arrNum[]=new int[100+1];
        int n=0;
        int[] sum=new int[10];
        //随机生成数字 并计数
        while((n++)!=100){
            arrNum[n]=RandomNum();
            sum[arrNum[n]]++;
//            for (int i=0;i<=9;i++){
//                if (i==arrNum[n]){
//                    sum[i]++;
//                }
//            }
        }
        System.out.println("随机生成的数据为:"+Arrays.toString(arrNum));
        for(int j=0;j<sum.length;j++){
            System.out.println("数字 "+j+" 出现的次数为: "+sum[j]);
        }
    }

    public static int RandomNum(){
        Random ra=new Random();
        return ra.nextInt(9+1);
    }
}
