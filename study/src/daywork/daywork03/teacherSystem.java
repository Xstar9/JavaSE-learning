package daywork.daywork03;

import java.util.Arrays;
import java.util.Scanner;

public class teacherSystem {
    static int score[]={ 98,97,67,88,67,88,99,77,88,99,100,78 };

    public static void main(String[] args) {
        System.out.println("欢迎教务系统-教师功能端~");
        ShowSystem();
        SystemChioce();
    }

    public static void ShowSystem(){
        System.out.println("1.登录系统");
        System.out.println("2.显示全部学生的成绩");
        System.out.println("3.按学生编号修改成绩");
        System.out.println("4.按学生编号查询成绩");
        System.out.println("0.退出系统");
    }

    public static void SystemChioce(){
        Scanner input=new Scanner(System.in);
        boolean flag=true;//循环条件
        String  name,pwd;
        int item=0;//标记登录状态
        int choice;//用户选择


        while(flag){
            //登录部分
            System.out.print("请输入数字进行操作选择: ");
            choice=input.nextInt();
            if(choice==1&&item==0){
                while(true){
                    System.out.println("请输入您的用户名:");
                    name=input.next();
                    System.out.println("请输入您的密码:");
                    pwd=input.next();
                    if(judge(name,pwd)){
                        System.out.println("登录成功！");
                        item=1;//标记为1
                        break;
                    }else{
                        System.out.println("输入的用户名或密码有误！请重新输入");
                    }
                }
            }else{
                System.out.println("对不起，您还未登录，请登录后重试");
            }

            while(item==1){
                //登录后的选择操作
                System.out.print("请输入数字进行操作选择: ");
                choice=input.nextInt();
                switch (choice){
                    case 1:
                        System.out.println("您已登录，无需重复登录.");
                        break;

                    case 2:
                        int i=0;
                        System.out.println("全部学生成绩如下：(共有"+score.length+"名学生）");
                        for (int a: score) {
                            System.out.println(i+". "+a);
                            i++;
                        }
                        break;

                    case 3:
                        System.out.print("请输入要修改的学生成绩编号: ");
                        int num=input.nextInt();
                        System.out.print("请输入将修改的分数: ");
                        int newscore=input.nextInt();
                        //Arrays.fill(score,num,num+1,newscore);
                        try{
                            score[num]=newscore;
                            System.out.println("修改成功！");
                        }catch (Exception e){
                            e.printStackTrace();
                            System.out.println("输入的编号有误！成绩不存在");
                        }
                        break;

                    case 4:
                        System.out.print("请输入要查询的学生成绩编号: ");
                        int numb=input.nextInt();
                        try{
                            System.out.println("编号为"+numb+"的学生成绩为: "+score[numb]);
                        }catch (Exception e){
                            e.printStackTrace();
                            System.out.println("输入的编号有误！成绩不存在");
                        }
                        break;

                    case 0:
                        flag=false;//退出系统标记
                        item=0;//退出登录标记
                        System.out.println("退出系统成功！欢迎下次使用");
                        break;

                    default:
                        break;
                }
            }
        }

    }
    // 判断输入正误
    public static boolean judge(String name, String pwd){
        String UserName="zhengxin";
        String password="12345678";
        if(name.equals(UserName)&&pwd.equals(password)){
            return true;
        }
        return false;
    }
}
