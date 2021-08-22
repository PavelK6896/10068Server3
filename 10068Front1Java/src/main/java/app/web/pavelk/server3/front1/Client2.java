package app.web.pavelk.server3.front1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client2 {
    public static void main(String[] args) throws IOException {
        try (Socket socket = new Socket("localhost", 8080)) {
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            String string = "GET / HTTP/1.1\r\n" +
                    "Connection: close\r\n" +
                    "Host: 8080\r\n\r\n";
            outputStream.write(string.getBytes());
            System.out.println(new String(inputStream.readAllBytes()));
        }
    }
}
