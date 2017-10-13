import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * Created by Darryl Pinto on 10/12/2017.
 */
public class Receiver1 implements Runnable{


    private int myReceiverPort;
    private String name;

    Receiver1(String name, int myReceiverPort) {
        this.name = name;
        this.myReceiverPort = myReceiverPort;
    }

    private void receive() {
        System.out.println("RECEIVER:" + name);

        while(true) {
            try {

                DatagramSocket receiver = new DatagramSocket(myReceiverPort);
                byte[] receiveData = new byte[2048];

                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
//                System.out.println("Waiting for message:  " + name);
                receiver.receive(receivePacket);
//                System.out.println("Message arrived for" + name);

                String message = new String(receivePacket.getData());

                System.out.println("MESSAGE RECEIVED by "+name+":" + message);

                receiver.close();
                System.out.println("-----------------------------------------");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void run() {
        this.receive();
    }
}

