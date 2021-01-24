package daywork.daywork03;

public class thickness {
    public static void main(String[] args) {
        double thick=0.0001;
        int times=0;
        while(thick<=8848){
            thick*=2;
            times++;
        }
        System.out.println("需要对折"+times+"次厚度能够超过珠峰高度8848米");


    }

}
