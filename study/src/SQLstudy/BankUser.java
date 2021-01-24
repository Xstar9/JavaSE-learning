package SQLstudy;

public class BankUser {
    private String name;
    private String password;
    private int money;
    private String phoneNo;
    public int isLogin=0;

    //有参构造，构建对象时同时赋初值
    public BankUser(String name,String password,int money,String phoneNo){
        this.name=name;
        this.password=password;
        this.money=money;
        this.phoneNo=phoneNo;
    }

    public BankUser(){
    }

    public void setIsLogin(int isLogin){
        this.isLogin=isLogin;
    }

    public int getIsLogin() {
        return isLogin;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getPhoneNo() {
        return phoneNo;
    }
}
