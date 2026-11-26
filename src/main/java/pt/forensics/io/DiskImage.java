package pt.forensics.io;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class DiskImage implements AutoCloseable{

    private final FileChannel fileChannel;

    public DiskImage(Path imagePath) throws IOException{
        // open file channel in read mode
        fileChannel = FileChannel.open(imagePath, StandardOpenOption.READ);
    }

    public long size() throws IOException{
        return fileChannel.size();
    }

    public byte[] readBytes(long offset, int length) throws IOException{
        ByteBuffer buffer = ByteBuffer.allocate(length);
        fileChannel.read(buffer, offset);
        return buffer.array();
    }

    @Override
    public void close() throws IOException {
        fileChannel.close();
    }
}
