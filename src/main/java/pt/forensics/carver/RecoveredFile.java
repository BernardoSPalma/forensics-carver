package pt.forensics.carver;

import pt.forensics.io.DiskImage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public record RecoveredFile(String extension, long startOffset, long endOffset) {
    public long size(){
        return endOffset - startOffset;
    }

    public void saveTo(DiskImage disk, Path outputFile) throws IOException{
        byte[] bytes = disk.readBytes(this.startOffset, (int) size());
        Files.write(outputFile, bytes);
    }
}
