package daywork.daywork08;

import java.util.Scanner;

/**
 * 教师信息类
 */

public class Teacher {
    public int teacher_id;
    public String teacher_name;
    private String password;


    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
    }

    public int getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
