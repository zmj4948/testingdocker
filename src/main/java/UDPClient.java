import java.net.*;

public class UDPClient {
    public static void main(String args[]){
        DatagramSocket aSocket=null;
        try{
            aSocket=new DatagramSocket();
            byte[] m= args[0].getBytes();
            InetAddress aHost=InetAddress.getByName(args[1]);
            int serverPort=6789;
            DatagramPacket request=new DatagramPacket(m, m.length ,aHost,serverPort);
            aSocket.send(request);
            byte[] buffer=new byte[1000];
            DatagramPacket reply=new DatagramPacket(buffer,buffer.length);
            aSocket.receive(reply);
            System.out.println("Reply: "+new String(reply.getData()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
