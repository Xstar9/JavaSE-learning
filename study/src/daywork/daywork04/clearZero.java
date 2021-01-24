package daywork.daywork04;

import java.util.Arrays;

public class clearZero {
    public static void main(String[] args) {
        int integer[]={1,2,0,3,4,5,6,0,7};
        System.out.println("源数组: "+Arrays.toString(integer));
        ClearZero(integer);
    }

    //清除后数据升序排列
    public static void ClearZero(int num[]){
        Arrays.sort(num);
        int count=0;
        for(int i:num){
            if(i==0){
                count++;
            }
        }
        /**
         * copyOfRange 从count开始到数组长度(开区间)结束
         */
        num=Arrays.copyOfRange(num,count,num.length);
        System.out.println("去除0以后: "+Arrays.toString(num));
    }
}
