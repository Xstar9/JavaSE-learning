package SQLstudy;



/**
 * SQL :Structure Query Language    结构化查询语言
 */

import java.sql.*;

/*
 * 数据库连接
 */
public class ConnectSQL {
    public static void main(String[] args) throws SQLException {
        Connection con ;
        Statement state;
        ResultSet res;
        //jdbc驱动
        String driver="com.mysql.jdbc.Driver";
        String url="jdbc:mysql://localhost:3306/test";
        String user="root";
        String password="123456";
        try {
            //注册JDBC驱动程序
            Class.forName(driver);
            //建立连接
            con = DriverManager.getConnection(url, user, password);
            if (!con.isClosed()) {
                System.out.println("数据库连接成功");
            }
            state=con.createStatement();
            res=state.executeQuery("select id,name,age from userinfo");
            while (res.next()){
                int id=res.getInt("id");
                String name=res.getString("name");
                int age=res.getInt("age");
                System.out.println(id+"  "+name+"  "+age);
            }
            con.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("数据库驱动没有安装");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据库连接失败");
        }


    }
}
