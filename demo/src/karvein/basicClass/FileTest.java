package karvein.basicClass;

import java.io.File;

public class FileTest {
    public static void main(String[] args) throws Exception{
        // 创建file对象
        File file1 = new File("D:\\test");
        // 判断file类型
        System.out.println(file1.isFile());
        System.out.println(file1.isDirectory());
        // 创建文件
        File file2 = new File("test.txt");
        file2.createNewFile();
        System.out.println(file2.isFile());
        // 查看文件路径
        System.out.println(file2.getPath());
        System.out.println(file2.getAbsolutePath());


    }
}
