package pt.forensics.carver;

import java.util.ArrayList;
import java.util.List;

public record FileSignature(String extension, byte[] header, byte[] footer) {
    public static List<FileSignature> defaultSignatures(){
        byte[] header = new byte[]  {(byte) 0xFF, (byte) 0xD8, (byte) 0xFF};
        byte[] footer = new byte[]  {(byte) 0xFF, (byte) 0xD9};
        return List.of(new FileSignature("jpg", header, footer));
    }
}
