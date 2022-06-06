import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {

	private static String serverIP="192.168.252.191";
	private static int serverPort=5555;

	public static void main(String[] args) {
		System.out.println("Client started");
        try {
            Socket socket = new Socket(serverIP,serverPort);
            System.out.println("Connected to server "+serverIP+":"+serverPort);
            OutputStream os = socket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);

            InputStream is = socket.getInputStream();
            DataInputStream dis = new DataInputStream(is);
            dos.writeUTF("Hello world");
            System.out.println("message sent");
            
            dos.writeUTF("give me that number");

            System.out.println(dis.readUTF());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
