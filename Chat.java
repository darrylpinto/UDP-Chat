import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Darryl Pinto on 10/10/2017.
 */
public class Chat {


    public static void main(String[] args) throws IOException, InterruptedException {


        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name of the receiver:");
        String receiverName = sc.next();
        System.out.println("Enter receiver port number:");
        int receiverRPort = sc.nextInt();
        System.out.println("Enter Your name:");
        String sendName = sc.next();
        System.out.println("Enter your sending port number");
        int senderSPort = sc.nextInt();
        System.out.println("Enter your receiving port number");
        int sendRPort = sc.nextInt();

        new Thread(new Receiver1(receiverName,receiverRPort)).start();

        new Thread(new Sender1(sendName, senderSPort, sendRPort)).start();

//        new Thread(new Receiver1("Naruto",1000 )).start();
//        new Thread(new Receiver1("Sasuke",2000 )).start();
//
//        Thread.sleep(1000);
//        new Thread(new Sender1("Naruto", 8000,2000, InetAddress.getLocalHost())).start();
//        new Thread(new Sender1("Sasuke", 9000,1000, InetAddress.getLocalHost())).start();





    }




}

