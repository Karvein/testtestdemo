package karvein.basicClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIODemoTest {
    public static void main(String[] args) throws IOException {
        // 输入流获取管道
        FileInputStream fileInputStream = new FileInputStream(new File("C:\\Users\\Leo\\Desktop\\this.txt"));
        FileChannel channel = fileInputStream.getChannel();

        // 输出流获取管道
        FileOutputStream fileOutputStream = new FileOutputStream(new File("C:\\Users\\Leo\\Desktop\\this.txt"));
        FileChannel outChannel = fileOutputStream.getChannel();

        // 缓冲区
        ByteBuffer allocate = ByteBuffer.allocate(8);

        while (true) {
            // 清除标记位置
            allocate.clear();
            // 将输入流通道里数据 读取到缓冲区
            int read = channel.read(allocate);
            // 数据读取完 跳出
            if (read<= -1){
                break;
            }
            // 转换读写模式
            allocate.flip();
            // 写到输出通道中
            outChannel.write(allocate);
        }

        // 关闭流操作
        fileInputStream.close();
        fileOutputStream.close();
    }
}
