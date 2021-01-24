package daywork.daywork03;

public class shulie {
    public static void main(String[] args) {
        int x=2,y=1;
        float sum=0;
        int i=0;
        System.out.println("分数序列前20项为：");
        while(i++!=20){
            sum+=((float) x/(float)y);
            System.out.print(x+"/"+y+"  ");
            int temp=x;
            x+=y;
            y=temp;

        }
        System.out.println("\n它们的和为："+sum);

    }
}
