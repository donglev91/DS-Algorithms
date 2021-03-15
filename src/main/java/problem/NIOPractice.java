package problem;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;

public class NIOPractice {
    public static void fileChannel() throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("C:\\__Workspaces__\\temp\\sample.txt", "rw");
        FileChannel fileChannel = randomAccessFile.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(48);
        int byteRead = fileChannel.read(byteBuffer);
        while (byteRead != -1) {
            System.out.println("Read: " + byteRead);
            byteBuffer.flip();
            while (byteBuffer.hasRemaining()) {
                System.out.println((char)byteBuffer.get());
            }

            byteBuffer.clear();
            byteRead = fileChannel.read(byteBuffer);
        }
        randomAccessFile.close();
        new ArrayList<String>().clone();
        System.out.println(randomAccessFile instanceof RandomAccessFile);
    }

    public static void main(String[] args) throws IOException {
        fileChannel();
    }
}
