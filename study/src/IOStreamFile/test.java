package IOStreamFile;

import java.io.*;
import java.util.*;

/**
 * 带缓冲的I/O流：BufferedInputStream和BufferedOutputStream
 * 两者均需在FileInputStream和FileOutputStream创建后才能生成
 *
 * 带缓冲的I/O流：BufferedWriter和BufferedReader
 *  两者均需在FileWriter和FileReader创建后才能生成
 */


public class test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        File file=new File("D:\\javaTest\\Info.txt");

        Set NameandPwd=new HashSet();
        List<String> Info= new ArrayList<String>();
        boolean flag=true;

        System.out.println("请输入需要写入的信息：");
        while(flag){
            String s=input.nextLine();
            if(s.equals("done")){
                flag = false;
            }else{
                Info.add(s);
//                String ss[]=s.split(" ");
//                for(String a:ss){
//                    System.out.println(a);
//                }
//                NameandPwd.add(ss[0]+"  "+ss[1]);
//                Info.addAll(NameandPwd);
            }
        }

        if(file.exists()){
            try{
                String name = file.getName();
                System.out.println("当前文件名称:"+name);
                FileWriter in=new FileWriter(file);
                BufferedWriter bufin= new BufferedWriter(in);
                bufin.write("Name"+"    "+"Price");
                bufin.newLine();
                for(String str:Info){
                    bufin.write(str+"\t");
                    bufin.newLine();// 起新的一行（换行）
                }
                bufin.close();
                in.close();
            }catch (Exception e){
                    e.printStackTrace();
            }

        }else{
            try{
                file.createNewFile();
                System.out.println("文件已经创建完成~");
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        System.out.println("------------------------------------------------------------");
        System.out.println("文件中的信息内容如下:");
        try{
            FileReader out=new FileReader(file);
            BufferedReader bufout=new BufferedReader(out);
            String str=null;
            int i=0;
            while((str=bufout.readLine())!=null){
                i++;
                System.out.println(i+". "+str);
            }
            bufout.close();
            out.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
