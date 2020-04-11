package nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

/**
 * A Java NIO Pipe is a one-way data connection between two threads.
 * A Pipe has a source channel and a sink channel.
 * You write data to the sink channel.
 * This data can then be read from the source channel.
 */
public class PipeExample {
    public static void main(String a[]) throws IOException {

        Pipe pipe= Pipe.open();

        // writing
        Pipe.SinkChannel sinkChannel = pipe.sink();
        String newData = "New String to write to file..." + System.currentTimeMillis();

        ByteBuffer buf = ByteBuffer.allocate(48);
        buf.clear();
        buf.put(newData.getBytes());

        buf.flip();

        while(buf.hasRemaining()) {
            sinkChannel.write(buf);
        }

        // reading

        Pipe.SourceChannel sourceChannel = pipe.source();
        ByteBuffer bufRead = ByteBuffer.allocate(48);
        int bytesRead = sourceChannel.read(buf);

        byte[] data = new byte[bytesRead];
        bufRead= buf.get(data);
       System.out.println(data.toString());

    }
}
