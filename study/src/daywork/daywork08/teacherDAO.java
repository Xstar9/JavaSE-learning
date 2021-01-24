package daywork.daywork08;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static daywork.daywork08.JDBCUtil.getConnection;

/**
 * 教师数据关联操作
 */

public class teacherDAO {
    //三件套
    static Connection con;
    static PreparedStatement pstate;
    static ResultSet res;
    public Teacher findUserbyNameAndPwd(String name,String pwd) throws SQLException {
        Teacher teacher=null;
        String sql="SELECT * FROM t_teacher WHERE teacher_name=? AND password=?";
        //JDBC连接数据库
        pstate= getConnection(con).prepareStatement(sql);
        pstate.setString(1,name);
        pstate.setString(2,pwd);
        //执行预处理语句，查询信息，将信息形成临时数据表
        res=pstate.executeQuery();

        //遍历数据表，如果找到则创建对象，找不到依然为null
        while(res.next()){
            teacher=new Teacher();
            teacher.setTeacher_id(res.getInt("teacher_id"));
            teacher.setTeacher_name(res.getString("teacher_name"));
            teacher.setPassword(res.getString("password"));
        }

        return teacher;
    }

    public void updateTeacherPassword(Teacher teacher) throws SQLException {
        String sql="update t_teacher set password=? where teacher_name=?";
        pstate= getConnection(con).prepareStatement(sql);
        pstate.setString(1,teacher.getPassword());
        pstate.setString(2,teacher.getTeacher_name());
        pstate.executeUpdate();

    }
}
