package MapSetList;

import java.util.Arrays;   //数组基本操作的包


public class ArrayLearn {
    public static void main(String[] args) {
        int arr[]={1,2,1,3,8};
        int a[]=new int[arr.length];

        /**
         * 填充/替换数组中的元素(可用于初始化)  fill(数组，赋值)
         */
        Arrays.fill(a,1);
        for(int i:a){
            System.out.print(i+" ");
        }
        System.out.println();
        //fill(数组，替换的初位置（闭），替换的末位（开），替换值)
        Arrays.fill(a,2,4,2);
        for(int i:a){
            System.out.print(i+" ");
        }
        System.out.println("\n-------------------------------------------------------------------------------------");
        /**
         * //数组元素排序 Arrays.sort()升序    字母为字典序升序
         * sort  46,287 插入排序    287 快排  无数据结构-> 归并排序
         */
        System.out.println("sort前：");
        for(int i:arr){
            System.out.print(i+" ");
        }
        System.out.println();
        Arrays.sort(arr);
        System.out.println("sort后：");
        for(int i:arr){
            System.out.print(i+" ");
        }
        System.out.println("\n-------------------------------------------------------------------------------------");
        /**
         *查 询  binarySearch(数组，搜索内容)  存在则返回下标  不在返回-1或-
         */
        int index = Arrays.binarySearch(arr,8);
        System.out.println("查找的元素下标（索引）为："+index);
        int index1 = Arrays.binarySearch(arr,0,4,8); // 11238中，8的下标为4，不在[0,4)范围内，返回负数
        System.out.println("查找的元素下标（索引）为："+index1);
        System.out.println("\n-------------------------------------------------------------------------------------");
        // 行转列
        int [][]arrays = {{1,2,3},
                          {4,5,6},
                          {7,8,9}};
        System.out.println("原二维数组：");
        for(int i=0;i<arrays.length;i++){
            for(int j=0;j<arrays[i].length;j++){
                System.out.printf("%d ",arrays[i][j]);
            }
            System.out.println();
        }
        System.out.println("新二维数组：");
        int [][]newarrays = new int[arrays.length][arrays.length];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                newarrays[i][j]=arrays[j][i];
                System.out.printf("%d ",newarrays[i][j]);
            }
            System.out.println();
        }
        System.out.println("\n-------------------------------------------------------------------------------------");
        /**
         * 数组复制     copyOf(目标数组，复制长度)
         */
        int newarr[]=Arrays.copyOf(arr,arr.length-1);
        System.out.println("copyOf复制数组newarr为：");
        for(int i:newarr){
            System.out.print(i+" ");
        }
        System.out.println();

        /**
         * 重载：copyOfRange(目标数组，初位，末位)    复制
         */
        int newarr1[]=Arrays.copyOfRange(arr,2,5);
        System.out.println("copyOfRange复制数组newarr为：");
        for(int i:newarr1){
            System.out.print(i+" ");
        }
        System.out.println("\n-------------------------------------------------------------------------------------");
/**
 * arraycopy复制:参数(源数组，复制起始位置，目标数组，粘贴起始位置，复制长度)
 * Arrays.toString(数组)   Arrays类中的静态方法 直接通过类名Arrays调用
 * toString（） 将数组转换成列表字符串输出
 */
        int aa[]={1,2,3,4,5,6,7,8,9,0};
        int[] bb=new int[aa.length];
        System.arraycopy(aa,1,bb,0,6);
        System.out.println("arraycopy复制数组bb为："+Arrays.toString(bb));
        /**
         * 数组扩容/缩容 采用Arrays.copyOf
         */
        aa=Arrays.copyOf(aa,aa.length+2);
        System.out.println("aa扩容后："+Arrays.toString(aa));
        aa=Arrays.copyOf(aa,aa.length-4);
        System.out.println("aa缩容4位后（在扩容基础上）："+Arrays.toString(aa));

    }

}
