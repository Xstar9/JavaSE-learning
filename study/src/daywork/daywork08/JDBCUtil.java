package daywork.daywork08;

import SQLstudy.BankUser;

import java.sql.*;

/**
 * 数据库操作 jdbc连接
 */

public class JDBCUtil {
    static Connection conn;//jdbc连接数据库
    static PreparedStatement pstate;//预处理
    static Statement state;//向数据库发送命令
    static ResultSet res;//临时数据表
    static String driver="com.mysql.jdbc.Driver";
    static String url="jdbc:mysql://localhost:3306/test?characterEncoding=utf-8";
    static String user="root";
    static String password="123456";

    public static Connection getConnection(Connection conn){
        //建立JDBC 连接数据库

        try{
            Class.forName(driver);
            //System.out.println("数据库加载成功");
        }catch (ClassNotFoundException e){
            e.getStackTrace();
            System.out.println("数据库加载失败");
        }

        try{
            conn= DriverManager.getConnection(url,user,password);
            //System.out.println("数据库连接成功");
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("数据库连接失败");
        }
        return conn;
    }

    public static Connection closeConnection(Connection conn) throws SQLException {
        conn.close();
        return conn;
    }

}
