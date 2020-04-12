package nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ReadFileAsync {
    public static void main(String[] a) throws IOException, InterruptedException {
        readFile();

        // do some other work

        Thread.sleep(10000);
    }

    public static void readFile() throws IOException {

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        Path path = Paths.get("/Users/ayush/study/core-java-basic/src/main/resource/Text.txt");

        AsynchronousFileChannel asynchronousFileChannel
                = AsynchronousFileChannel.open(path, StandardOpenOption.READ);

        asynchronousFileChannel.read(buffer, 0, buffer,
                new CompletionHandler<Integer, ByteBuffer>() {
                    @Override
                    public void completed(Integer result, ByteBuffer attachment) {
                        System.out.println("result = " + result);

                        attachment.flip();
                        byte[] data = new byte[attachment.limit()];
                        attachment.get(data);
                        System.out.println(new String(data));
                        attachment.clear();
                    }

                    @Override
                    public void failed(Throwable exc, ByteBuffer attachment) {
                        System.out.println("File not found");
                    }
                });
    }
}
