package daywork.daywork06;

import SQLstudy.BankUser;

import java.util.ArrayList;

public class Test_ArraylistbyBankUser {
    public static void main(String[] args) {
        ArrayList<BankUser> userList=new ArrayList<BankUser>();
        BankUser user1=new BankUser("zhengxin","123456", 100,"1314");
        BankUser user2=new BankUser("zx","1234567",666,"520");
        userList.add(user1);
        userList.add(user2);
        System.out.println("下标为1的元素详细信息如下:");
        System.out.println("姓名:"+userList.get(1).getName()+" "+"密码:"+userList.get(1).getPassword()+" "+
                "余额:"+userList.get(1).getMoney()+" "+"手机号:"+userList.get(1).getPhoneNo());
    }
}


