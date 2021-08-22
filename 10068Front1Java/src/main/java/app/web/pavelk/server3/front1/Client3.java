package app.web.pavelk.server3.front1;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Client3 {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://localhost:8080/");
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("GET");
        InputStream inputStream = httpURLConnection.getInputStream();
        System.out.println(new String(inputStream.readAllBytes()));
    }
}
