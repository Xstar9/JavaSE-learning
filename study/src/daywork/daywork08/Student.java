package daywork.daywork08;

/**
 * 学生属性类
 */

public class Student {
    public int id;
    public String stu_name;
    public String stu_no;
    public int teacher_no;
    public int score;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStu_name() {
        return stu_name;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }

    public String getStu_no() {
        return stu_no;
    }

    public void setStu_no(String stu_no) {
        this.stu_no = stu_no;
    }

    public int getTeacher_no() {
        return teacher_no;
    }

    public void setTeacher_no(int teacher_no) {
        this.teacher_no = teacher_no;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", stu_name='" + stu_name + '\'' +
                ", stu_no='" + stu_no + '\'' +
                ", teacher_no=" + teacher_no +
                ", score=" + score +
                '}';
    }
}
