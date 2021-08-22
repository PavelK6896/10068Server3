package app.web.pavelk.server3.back3;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

public class Server2 {
    public void execute() throws Exception {
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            boolean running = true;
            while (running) {
                Socket socket = serverSocket.accept();
                CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> {
                    String string = "";
                    try (InputStream inputStream = socket.getInputStream();
                         OutputStream outputStream = socket.getOutputStream();
                    ) {
                        byte[] bytes = new byte[256];
                        int read = inputStream.read(bytes, 0, bytes.length);
                        System.out.println(Arrays.toString(bytes));
                        string = new String(bytes);
                        System.out.println(string);
                        outputStream.write("server 2 ok".getBytes());
                        if (!socket.getKeepAlive()) {
                            socket.close();
                        } else {
                            CompletableFuture.runAsync(() -> {
                                try {
                                    Thread.sleep(5000);
                                    socket.close();
                                } catch (IOException | InterruptedException e) {
                                    e.printStackTrace();
                                    Thread.currentThread().interrupt();
                                } finally {
                                    try {
                                        socket.close();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }, Executors.newCachedThreadPool());
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return string;
                });
                if (stringCompletableFuture.get().equals("end")) {
                    running = false;
                    continue;
                }
            }
        }
    }
}
