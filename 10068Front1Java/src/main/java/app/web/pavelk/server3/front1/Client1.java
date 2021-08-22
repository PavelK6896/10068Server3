package app.web.pavelk.server3.front1;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;

public class Client1 {
    public static void main(String[] args) throws Exception {
        try (DatagramSocket datagramSocket = new DatagramSocket()) {
            InetAddress inetAddress = InetAddress.getByName("localhost");
            System.out.println(inetAddress);
            byte[] buf = "msg".getBytes();
            DatagramPacket datagramPacket1 = new DatagramPacket(buf, buf.length, inetAddress, 8080);
            System.out.println(Arrays.toString(buf));
            datagramSocket.send(datagramPacket1);
            System.out.println(new String(datagramPacket1.getData()));

            byte[] buf2 = new byte[5];
            DatagramPacket datagramPacket2 = new DatagramPacket(buf2, buf2.length);
            datagramSocket.receive(datagramPacket2);
            System.out.println(Arrays.toString(buf2));
            String received = new String(datagramPacket2.getData(), 0, datagramPacket2.getLength());
            System.out.println(received);
        }

    }

}
