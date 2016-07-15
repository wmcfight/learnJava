package test;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;

import javax.xml.bind.DatatypeConverter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Base64;

/**
 * Created by mingchuw on 16/6/29.
 */
public class TestAudioFile {

    public static void main(String[] args) throws IOException {
//        URL url = Resources.getResource("test_8k.pcm");
//        String text = Resources.toString(url, Charsets.UTF_8);
        //System.out.println(text);
//        System.out.println(text.getBytes().length);
//        System.out.println(text.getBytes());
//        System.out.println(Base64.getEncoder().encode(text.getBytes()));
//        byte[] data = Base64.getEncoder().encode(text.getBytes());
//        System.out.println(Base64.getDecoder().decode(data));
        //System.out.println(data.getBytes().length);
       // System.out.println(data);

        String testFileName = "iflytek02_8k.wav";
        File pcmFile = new File(testFileName);

        byte[] data = loadFile(pcmFile);
        System.out.println(data);
        System.out.println(data.toString());

        System.out.println(pcmFile.length());
        System.out.println(DatatypeConverter.printBase64Binary(loadFile(pcmFile)));
    }

    private static byte[] loadFile(File file) throws IOException {
        InputStream is = new FileInputStream(file);

        long length = file.length();
        byte[] bytes = new byte[(int) length];

        int offset = 0;
        int numRead = 0;
        while (offset < bytes.length
                && (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
            offset += numRead;
        }

        if (offset < bytes.length) {
            is.close();
            throw new IOException("Could not completely read file " + file.getName());
        }

        is.close();
        return bytes;
    }
}
