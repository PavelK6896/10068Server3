package app.web.pavelk.server3.back3;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;

public class Server1 {
    public void execute() throws Exception {
        try (DatagramSocket datagramSocket = new DatagramSocket(8080)) {
            boolean running = true;
            byte[] buf = new byte[256];
            while (running) {
                DatagramPacket datagramPacket1 = new DatagramPacket(buf, buf.length);
                datagramSocket.receive(datagramPacket1);
                System.out.println(new String(datagramPacket1.getData()));
                InetAddress address = datagramPacket1.getAddress();
                int port = datagramPacket1.getPort();
                DatagramPacket datagramPacket2 = new DatagramPacket(datagramPacket1.getData(), datagramPacket1.getData().length, address, port);
                String received = new String(datagramPacket2.getData(), 0, datagramPacket2.getLength());
                if (received.equals("end")) {
                    running = false;
                    continue;
                }
                datagramSocket.send(datagramPacket2);
                System.out.println(received);
                System.out.println(Arrays.toString(datagramPacket2.getData()));
            }
        }
    }
}
