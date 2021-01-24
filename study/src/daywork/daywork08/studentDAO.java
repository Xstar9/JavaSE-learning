package daywork.daywork08;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static daywork.daywork08.JDBCUtil.getConnection;

/**
 * 学生数据库关联操作
 */

public class hstudentDAO {
    Connection con;
    PreparedStatement pstate;
    ResultSet res;
    public List<Student> SelectStudents(Teacher teacher) throws SQLException {
        List<Student> students=new ArrayList<Student>();
        String sql="SELECT * FROM t_student,t_teacher WHERE teacher_id=? AND teacher_id=teacher_no ";
        pstate=JDBCUtil.getConnection(con).prepareStatement(sql);
        pstate.setInt(1,teacher.getTeacher_id());
        res=pstate.executeQuery();
        while(res.next()){
            Student stu=new Student();
            stu.setId(res.getInt("id"));
            stu.setStu_name(res.getString("stu_name"));
            stu.setStu_no(res.getString("stu_no"));
            stu.setTeacher_no(res.getInt("teacher_no"));
            stu.setScore(res.getInt("score"));
            students.add(stu);
        }

        return students;
    }
    public  void updateScore(Connection conn, PreparedStatement state, Student student){
        // Scanner input=new Scanner(System.in);
        // 修改操作
        try {
            state = getConnection(conn).prepareStatement("update t_student " +
                    "set score=? where stu_name=?");
            state.setInt(1, student.getScore());
            state.setString(2,student.getStu_name());

            state.executeUpdate();
            System.out.println("分数更新成功");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("分数更新失败");
        }
    }
}
