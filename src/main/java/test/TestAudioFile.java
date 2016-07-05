package test;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;

import java.io.IOException;
import java.net.URL;
import java.util.Base64;

/**
 * Created by mingchuw on 16/6/29.
 */
public class TestAudioFile {

    public static void main(String[] args) throws IOException {
        URL url = Resources.getResource("16k_test.pcm");
        String text = Resources.toString(url, Charsets.UTF_8);
        //System.out.println(text);
        System.out.println(text.getBytes().length);
        String data = Base64.getEncoder().encodeToString(text.getBytes());
        //System.out.println(data.getBytes().length);
        System.out.println(data);
    }
}
