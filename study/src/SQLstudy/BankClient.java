package SQLstudy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankClient {
    //  JDBC变量
    static Connection conn;
    static PreparedStatement state;
    static ResultSet res;

    static List<BankUser> userslist=new ArrayList<BankUser>();//存放遍历数据库数据
    static int item;//记录登录的用户在userlist的下标
    static operationMYSQL opera=new operationMYSQL();//数据库操作对象实例化

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Scanner input=new Scanner(System.in);
        boolean flag=true;
        int choice;//用户选择

        opera.selectDB(userslist);//刷新获取数据表

        System.out.println("----------------欢迎使用鑫の银行系统----------------");
          System.out.print("            ——————————————————————————       \n" +
                           "           |      请按对应选择输入      |     \n" +
                           "           |                          |       \n" +
                           "           |        1.用户注册         |        \n" +
                           "           |        2.用户登录         |        \n" +
                           "           |        3.用户存款         |       \n" +
                           "           |        4.用户取款         |       \n" +
                           "           |        5.查询余额         |       \n" +
                           "           |        6.退出登录         |       \n" +
                           "           |        0.退出系统         |      \n" +
                           "           |                          |       \n" +
                           "            ——————————————————————————       \n");
        while(flag){
            System.out.print("请输入: ");
            choice=input.nextInt();
            switch (choice){
                case 1:
                    addUser();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    deposit(userslist.get(item));
                    break;
                case 4:
                    drawMoney(userslist.get(item));
                    break;
                case 5:
                    showBalance(userslist.get(item));
                    break;
                case 6:
                    exitLogin(userslist.get(item));
                    break;
                case 0:
                    userslist.get(item).setIsLogin(0);//登录状态下线
                    opera.updateLogin(conn,state,userslist.get(item));
                    System.out.println("已退出系统欢迎下次使用~");
                    flag=false;
                    break;
                default:
                    System.out.println("输入有误，请重新输入");
            }
        }
    }
    //注册功能
    public static void addUser() throws SQLException, ClassNotFoundException {
        Scanner input=new Scanner(System.in);
        String name=null,password=null,phoneNo=null;
        boolean flag=true;

        BankUser user=new BankUser();
        user=null;
        System.out.println("------------注册------------");
        while(flag){
            System.out.println("请输入您的姓名: ");
            name=input.next();
            System.out.println("请输入设置的密码: ");
            password=input.next();
            System.out.println("请输入预设手机号: ");
            phoneNo=input.next();
            for(int i=0;i<userslist.size();i++){
                if(name.equals(userslist.get(i).getName())){
                    System.out.println("该用户名已存在，请重新输入用户名!");
                    flag=true;
                    break;
                }else {
                    flag=false;
                    break;
                }
            }
        }
        //UserNum++;
        opera.addDatas(conn,name,password,0,phoneNo,0);
        opera.selectDB(userslist);
        System.out.println("注册成功！");
    }
    //登录功能
    public static void login(){
        boolean flag=true;
        System.out.println("------------登录------------");
        Scanner input=new Scanner(System.in);
        while(flag){
            System.out.print("用户名: ");
            String name=input.next();
            System.out.print("密码: ");
            String pwd=input.next();
            for(int i=0;i<userslist.size();i++){
                if(name.equals(userslist.get(i).getName())&&pwd.equals(userslist.get(i).getPassword())){
                    userslist.get(i).setIsLogin(1);
                    opera.updateLogin(conn,state,userslist.get(i));
                    item=i;
                    System.out.println("登录成功！");
                    flag=false;
                    break;
                }else{
                    System.out.println("用户名或密码错误，请重新输入");
                }
            }
        }

    }
    //存款功能
    public static void deposit(BankUser bankUser) throws SQLException, ClassNotFoundException {
        boolean flag=true;
        Scanner input=new Scanner(System.in);

        if(bankUser.getIsLogin()==0){
            System.out.println("您还未登录系统，请先登录!");
        }else {
            while(flag){
                System.out.println("请输入存款金额: ");
                int money=input.nextInt();
                if(money<0){
                    System.out.println("存款金额不能小于0！");
                }else{
                    bankUser.setMoney(bankUser.getMoney()+money);
                    System.out.println("已存入账户！");
                    System.out.println("当前账户余额: "+bankUser.getMoney());
                    //opera.selectAll();
                    opera.updateMoney(conn,state,bankUser);
                    opera.selectDB(userslist);
                    flag=false;
                }
            }
        }
    }
    //取现功能
    public static void drawMoney(BankUser bankUser) throws SQLException, ClassNotFoundException {
        Scanner input=new Scanner(System.in);
        boolean flag=true;
        if(bankUser.getIsLogin()==0){
            System.out.println("您还未登录系统，请先登录!");
        }else{
            while(true){
                int yuer=bankUser.getMoney();
                System.out.println("请输入取款金额: ");
                int money=input.nextInt();
                if(money > bankUser.getMoney()){
                    System.out.println("您的可用余额不足！");
                }else{
                    System.out.println("您的取款金额为: "+money);
                    bankUser.setMoney(yuer-money);
                    System.out.println("取款成功！当前可用余额为: "+bankUser.getMoney());
                    flag=true;
                    opera.updateMoney(conn,state,bankUser);
                    opera.selectDB(userslist);
                    break;
                }
            }
        }
    }
    //显示余额
    public static void showBalance(BankUser bankUser){
        System.out.println(bankUser.getName()+",您好.");
        System.out.println("您当前账户可用余额金额: "+bankUser.getMoney());
    }
    //退出登录
    public static void exitLogin(BankUser bankUser){
        bankUser.setIsLogin(0);
        opera.updateLogin(conn,state,bankUser);
        System.out.println("已退出登录");
    }


}
