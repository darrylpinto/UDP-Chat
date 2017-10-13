import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * Created by Darryl Pinto on 10/12/2017.
 */
public class Sender1 implements Runnable {

    private int mySenderPort, theirReceiverPort;
    private String name;

    Sender1(String name, int mySenderPort, int theirReceiverPort) {
        this.mySenderPort = mySenderPort;
        this.theirReceiverPort = theirReceiverPort;
        this.name = name;

    }

    public void send() {
        System.out.println("SENDER: " + this.name);

        while(true) {
            try {

                DatagramSocket socket = new DatagramSocket(mySenderPort);

                System.out.print("Enter message:");
                Scanner sc = new Scanner(System.in);
                String message = sc.next();

                byte[] sendData = message.getBytes();
                DatagramPacket packet = new DatagramPacket(sendData, sendData.length,
                        InetAddress.getByName("127.0.0.3"), theirReceiverPort);

                socket.send(packet);

                System.out.println("Message sent by " + name + ": " + message);
                socket.close();


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public void run() {

        this.send();

    }
}
