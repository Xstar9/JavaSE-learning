package daywork.daywork05;

public class Student {
    public String name;
    public long id;
    private String grade;
    private int age;
    public void addStudent(String name,long id,String grade,int age){
        this.name=name;
        this.id=id;
        this.age=age;
        this.grade=grade;
    }
    public static void showStudents(Student stu[]){
        for(int i=0;i<stu.length;i++){
            System.out.println("编号: "+(i+1));
            System.out.println("Name: "+stu[i].name);
            System.out.println("Id: "+stu[i].id);
            System.out.println("Age: "+stu[i].age);
            System.out.println("Grage: "+stu[i].grade);
        }
    }

    public void getStudentByStudentname(String queryName,Student stu[]){
        for(int i=0;i<stu.length;i++){
            if(stu[i].name.equals(queryName)){
                System.out.println("Name: "+stu[i].name);
                System.out.println("Id: "+stu[i].id);
                System.out.println("Age: "+stu[i].age);
                System.out.println("Grage: "+stu[i].grade);
            }else if(i==stu.length-1){
                System.out.println("Not found this student ");
            }
        }

    }
}
