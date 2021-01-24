package IOStreamFile;

import java.io.*;
import java.util.Scanner;
import java.util.*;
/**
 * File类    java.io中代表磁盘文件本身对象
 *  File file = new File(文件路径+类型txt。。。.ect)   创建File的操作对象
 *  FileOutputStream,FileInputStream字节流
 *  FileReader FileWriter 字符流
 */

public class ReadWrite {
    public static void main(String[] args) throws Exception {
        File file = new File("D:\\javaTest\\test1.txt");
        file.createNewFile();
//                System.out.println("文件已经创建完成~");
////        File f=new File("D:\\javaTest");
////        System.out.println("D:\\javaTest路径下的文件有:");
////        String []ss=f.list(); //返回路径下的所有文件
////        for (String s:ss){
////            System.out.println(s);
////        }
//        if(file.exists()){  //如果文件存在
//            String name = file.getName();
//            System.out.println("文件名称是:"+name);
//        }else{
//            try{
//                file.createNewFile();
//                System.out.println("文件已经创建完成~");
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//        }
//        // FileOutputStream
//        try{
//            FileOutputStream out=new FileOutputStream(file);
//            byte s[]= "zhengxin,Male,5120181014,SoftWare05,SWUST".getBytes();
//            out.write(s);
//            out.close();
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        //  FileInputStream
//        try{
//            FileInputStream in = new FileInputStream(file);
//            byte byt[]= new byte[1024];
//            int len = in.read(byt);// 从输入流中读取一定数量的字节，并将其存储在缓冲区数组 b 中。返回实际读取的字节数
//            System.out.println("Info:"+new String(byt,0,len)); //args:内容数组 从第几个字节开始 读取到的字节长度
//            in.close();
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
            testBufferWriter();
            testBufferReader();

    }


    // FileReader方法   BufferedReader          throws Exception时不用try catch
    public static void testBufferReader() throws Exception{
        FileReader fr=new FileReader("D:\\javaTest\\test1.txt");

        BufferedReader buR= new BufferedReader(fr);
        char c[]=new char[100];

        int len=0;
        while((len=buR.read(c))!=-1){
            System.out.println(new String(c,0,len));
        }
        buR.close();
        fr.close();
    }

    // 缓冲写入文件FileWriter BufferedWriter
    public static void testBufferWriter() throws Exception{
        FileWriter fw=new FileWriter("D:\\javaTest\\test1.txt");
        BufferedWriter buW=new BufferedWriter(fw);

        buW.write("炉石传说\n真尼玛好玩");

        buW.flush();
        buW.close();
        fw.close();
    }
}
