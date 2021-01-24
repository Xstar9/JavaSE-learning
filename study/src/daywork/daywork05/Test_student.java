package daywork.daywork05;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.Scanner;
import SQLstudy.operationMYSQL;

public class Test_student {
    static Student stus[]={};
    static Connection conn;
    static PreparedStatement state;
    static ResultSet res;
    static int i=0;// 统计学生数量

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int choice;
        boolean flag=true;
        operationMYSQL opera=new operationMYSQL();
        //opera.getConnection(conn);
        while (flag){
            System.out.println("请输入操作：1.录入学生信息 2.查看目前全部学生信息 3.查询学生信息 0.退出");
            choice=input.nextInt();
            switch (choice){
                case 1:
                    while(true){
                        try{
                            System.out.print("请输入姓名：");
                            String name=input.next();
                            System.out.print("请输入班级：");
                            String grade=input.next();
                            System.out.print("请输入学号：");
                            long id=input.nextLong();
                            System.out.print("请输入年龄：");
                            int age=input.nextInt();
                            Student student=new Student();
                            stus= Arrays.copyOf(stus,stus.length+1);
                            student.addStudent(name,id,grade,age);
                            stus[i++]=student;
                            System.out.println("录入成功！");
                            opera.addData(conn,name,id,grade,age);
                            break;
                        }catch (Exception e){
                            //e.printStackTrace();
                            System.out.println("输入有误,请重新操作！");
                        }
                    }
                    break;
                case 2:
                    System.out.println("目前录入的全部学生信息如下：");
                    Student.showStudents(stus);
                    break;
                case 3:
                    System.out.println("请输入查询的学生姓名：");
                    while(true){
                        try{
                            String queryName=input.next();
                            new Student().getStudentByStudentname(queryName,stus);
                            break;
                        }catch (Exception e){
                            //e.printStackTrace();
                            System.out.println("输入有误,请重新操作！");
                        }
                    }
                    break;
                case 0:
                    flag=false;
                    System.out.println("已退出系统，欢迎下次使用~");
                    break;
            }

        }

    }
}
