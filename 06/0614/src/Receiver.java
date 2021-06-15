import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
// Sender보다 먼저 실행
public class Receiver {// p674 예제
    public static void main(String[] args) throws IOException {
        byte[] buf = new byte[256];

        DatagramSocket socket = new DatagramSocket(5000);
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        socket.receive(packet);
        System.out.println(new String(buf));
    }
}