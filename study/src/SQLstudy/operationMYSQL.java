package SQLstudy;

import java.sql.*;
import java.util.List;
import java.util.Scanner;

public class operationMYSQL {
    //类成员变量
    static Connection conn;//jdbc连接数据库
    static PreparedStatement state;//预处理
    static Statement st;//向数据库发送命令
    static ResultSet res;//临时数据表
    static String driver="com.mysql.jdbc.Driver";
    static String url="jdbc:mysql://localhost:3306/test?characterEncoding=utf-8";
    static String user="root";
    static String password="123456";

    //返回连接数据库的状态
    public Connection getConnection(Connection conn){
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
    //遍历存储数据库的数据
    public  void selectDB(List<BankUser> users) throws ClassNotFoundException, SQLException {
        //在用list来获取
        users.clear();
        //获取 jdbc.driver包-驱动类
        Class.forName(driver);
        //获取数据库表列名
        conn= DriverManager.getConnection(url, user, password);
        st=conn.createStatement();
        //执行查询语句
        res=st.executeQuery("select * from bankuserinfo");
        //实例User类
        BankUser bankUser=null;
        //遍历
        while(res.next()){
            bankUser=new BankUser();
            bankUser.setName(res.getString("name"));
            bankUser.setPassword(res.getString("password"));
            bankUser.setMoney(res.getInt("money"));
            bankUser.setPhoneNo(res.getString("Tel"));
            bankUser.setIsLogin(res.getInt("isLogin"));
            users.add(bankUser);
        }
        //遍历输出
//        for (BankUser user : users) {
//            System.out.println("用户名："+user.getName()+"  登录密码："+user.getPassword()
//                    +"  余额："+user.getMoney()+"  手机号："+user.getPhoneNo());
//        }
        res.close();
        st.close();
        conn.close();
    }
    //学生系统
    public static void queryData(PreparedStatement state,ResultSet res) {
        Scanner input=new Scanner(System.in);
        //查数据库操作
        try {
            String sql = "select * from userinfo";
            state = conn.prepareStatement(sql);
            res = state.executeQuery(sql);
            while (res.next()) {//如果当前语句不是最后一条，则进入循环
                String name = res.getString("name");
                int id = res.getInt("id");
                String grade=res.getString("grade");
                int age = res.getInt("age");
                System.out.println("id：" + id + "  " + "姓名：" + name + "  " +"班级："+grade+ "年龄：" + age);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public  void addData(Connection conn,String name,long id,String grade,int age){
        try {
            state = getConnection(conn).prepareStatement("insert into userinfo(name,id,grade,age) values(?,?,?,?)");
            state.setString(1, name);
            state.setLong(2, id);
            state.setString(3,grade);
            state.setInt(4,age);
            state.executeUpdate();
            System.out.println("添加至数据库成功~");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("添加至数据库失败！");
        }
    }
    public  void updateData(Connection conn,PreparedStatement state,int id,String newname){
       // Scanner input=new Scanner(System.in);
        // 修改操作
        try {
            state = getConnection(conn).prepareStatement("update db_user set name = ? where id = ?");
            state.setString(2, newname);
            state.executeUpdate();
            System.out.println("修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("修改失败");
        }
    }
    public static void deleteData4Id(Connection conn,int id){
        //删除操作
        //Scanner input=new Scanner(System.in);
        try {
            PreparedStatement state = conn.prepareStatement("delete from db_user where id=?");//创建Statement对象
            state.executeUpdate();
            System.out.println("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("删除失败，数据不存在！");
        }
    }
    //银行系统
    public  void addDatas(Connection conn,String name,String pwd,int money,String phoneNo,int isLogin){
        try {
            state = getConnection(conn).prepareStatement("insert into " +
                    "bankuserinfo(name,password,money,Tel,isLogin) " +
                    "values(?,?,?,?,?)");
            state.setString(1, name);
            state.setString(2, pwd);
            state.setInt(3,money);
            state.setString(4,phoneNo);
            state.setInt(5,isLogin);
            state.executeUpdate();
            System.out.println("添加至数据库成功~");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("添加至数据库失败！");
        }
    }
    public  void updateMoney(Connection conn, PreparedStatement state, BankUser bankUser){
        // Scanner input=new Scanner(System.in);
        // 修改操作
        try {
            int a;
            state = getConnection(conn).prepareStatement("update bankuserinfo " +
                    "set money=? where name=?");
            state.setInt(1, bankUser.getMoney());
            state.setString(2,bankUser.getName());

            state.executeUpdate();
            System.out.println("余额更新成功");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("余额更新失败");
        }
    }
    public  void updateLogin(Connection conn, PreparedStatement state, BankUser bankUser){
        // Scanner input=new Scanner(System.in);
        // 修改操作
        try {
            int a;
            state = getConnection(conn).prepareStatement("update bankuserinfo " +
                    "set isLogin=? where name=?");
            state.setInt(1, bankUser.getIsLogin());
            state.setString(2,bankUser.getName());
            state.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
