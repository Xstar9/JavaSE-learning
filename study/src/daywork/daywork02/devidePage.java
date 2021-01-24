package daywork.daywork02;

import java.util.*;

/**
 * 3、写一个自动计算某宝 商品页面的分页功能的程序：
 * 用户从控制台输入搜索到的商品总数量totalNum，  以及每页现显示的商品数量pageSize，
 * 程序根据这两个数据自动输出需要用多少页来显示这些数据。
 */

public class devidePage {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入您搜索到的商品总数量:");
        int totalNum=input.nextInt();
        System.out.println("请输入您需要的每页现显示的商品数量:");
        int pageSize=input.nextInt();
        int page;
        if(totalNum % pageSize==0){
            page = totalNum/pageSize;
        }
        else{
            page = (totalNum/pageSize)+1;
        }
        System.out.println("您需要用 "+page+" 页来显示这些数据");

    }

}
