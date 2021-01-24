package daywork.daywork08;

import java.sql.*;
import java.util.List;
import java.util.Scanner;

public class SystemTest {
    static Connection conn;//jdbc连接数据库
    static PreparedStatement pstate;//预处理
    static Statement state;//向数据库发送命令
    public static Teacher islogin=null;//标记当前登录的用户
    static Scanner input=new Scanner(System.in);

    public static void main(String[] args) throws SQLException {
        System.out.println("==========================成绩系统=============================");
        int choice;
        boolean flag=true;
        while(flag){
            System.out.println("1.教师登录  2.查看学生信息 3.修改学生成绩 4.修改用户密码 0.退出系统 ");
            choice=input.nextInt();
            switch (choice){
                case 1: login();break;
                case 2: showStudentInfo();break;
                case 3: QueryInfo();break;
                case 4: ModifyPwd();break;
                case 0: flag=false;
                        System.out.println("已退出系统~");
                        break;
                default:
                    System.out.println("输入有误，请重新输入");
            }
        }
        input.close();
    }

    public static void login() throws SQLException {
        teacherDAO dao=new teacherDAO();

        System.out.println("===========登录===========");
        while(true){
            System.out.print("请输入教师用户名: ");
            String name=input.next();
            System.out.print("请输入密码: ");
            String pwd=input.next();

            Teacher teacher = dao.findUserbyNameAndPwd(name,pwd);//验证：通过为找到的对象信息，不通过为null

            if(teacher!=null){
                System.out.println("登录成功");
                islogin=teacher;//标记登录状态
                break;
            }else {
                System.out.println("用户名或密码错误，请重新输入！");
            }
        }

    }
    public static void QueryInfo() throws SQLException {
        if(islogin==null){
            System.out.println("您还为登录系统，请先登录~");
            return;
        }
        System.out.println("请输入查询的学生姓名：");
        String name=input.next();
        studentDAO stuDAO=new studentDAO();
        List<Student> stus = stuDAO.SelectStudents(islogin);
        for (Student stu:stus) {
            if(stu.getStu_name().equals(name)){
                System.out.println("当前学生成绩为: "+stu.getScore());
                System.out.print("请输入修改的成绩: ");
                int newScore=input.nextInt();
                stu.setScore(newScore);
                stuDAO.updateScore(conn,pstate,stu);
            }
        }
    }

    public static void showStudentInfo() throws SQLException {
        if(islogin==null){
            System.out.println("您还为登录系统，请先登录~");
            return;
        }
        studentDAO stuDAO=new studentDAO();
        List<Student> stus = stuDAO.SelectStudents(islogin);
        System.out.println("您的班级学生信息如下：");
        for(Student stu:stus){
            System.out.println(stu.toString());
        }
    }

    public static void ModifyPwd() throws SQLException {
        if(islogin==null){
            System.out.println("您还为登录系统，请先登录~");
            return;
        }
        teacherDAO dao=new teacherDAO();
        while(true){
            System.out.println("请输入原密码: ");
            String oldPwd= input.next();
            if (oldPwd.equals(islogin.getPassword())){
                break;
            }else {
                System.out.println("密码错误，请重新输入");
            }
        }
        System.out.println("请输入新密码: ");
        String newPwd= input.next();
        islogin.setPassword(newPwd);
        dao.updateTeacherPassword(islogin);
        System.out.println("修改成功");
    }
}
