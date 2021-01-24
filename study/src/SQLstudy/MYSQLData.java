package SQLstudy;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MYSQLData {

    //登录名
    private static String username="root";
    //登录密码
    private static String password="123456";
    //连接数据库地址
    private static String url="jdbc:mysql://localhost:3306/test";
    private static String driver="com.mysql.jdbc.Driver";
    //参数
    private static Connection con=null;
    private static PreparedStatement ps=null;
    private static ResultSet rs=null;
    //存放数据库数据
    static List<BankUser> users= new ArrayList<BankUser>();

    public static void selectAll() throws ClassNotFoundException, SQLException {
        //在用list来获取

        //获取 jdbc.driver包-驱动类
        Class.forName(driver);
        //获取数据库表列名
        con= DriverManager.getConnection(url, username, password);
        Statement st=con.createStatement();
        //执行查询语句
        ResultSet rs=st.executeQuery("select * from bankuserinfo");
        //实例User类
        BankUser bankUser=null;
        //遍历
        while(rs.next()){
            bankUser=new BankUser();
            bankUser.setName(rs.getString("name"));
            bankUser.setPassword(rs.getString("password"));
            bankUser.setMoney(rs.getInt("money"));
            bankUser.setPhoneNo(rs.getString("Tel"));
            users.add(bankUser);
        }
        //遍历输出
        for (BankUser user : users) {
            System.out.println("用户名："+user.getName()+"  登录密码："+user.getPassword()
                    +"  余额："+user.getMoney()+"  手机号："+user.getPhoneNo());
        }
        rs.close();
        st.close();
        con.close();
    }

    public static void ChangeMoney(BankUser user) throws SQLException, ClassNotFoundException {
        selectAll();
        int i=0;
        for (BankUser bankUser:users){
            i++;
            if(user.getName().equals(bankUser.getName())){
                rs.updateInt(3,bankUser.getMoney());
                System.out.println(bankUser.getName()+",您好。您的账户余额为: "+bankUser.getMoney());
            }

        }
    }

//    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        selectAll();
//    }

}
