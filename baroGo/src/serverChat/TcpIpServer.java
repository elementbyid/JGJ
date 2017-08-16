package serverChat;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
 
public class TcpIpServer implements Runnable {
    ServerSocket serverSocket;
    Thread[] threadArr;
 
    public static void main(String[] args) {
        // 5���� �����带 �����ϴ� ������ �����Ѵ�.
        TcpIpServer server = new TcpIpServer(5);
        server.start();
    }
 
    public TcpIpServer(int num) {
        try {
            // ���� ������ �����Ͽ� 7777�� ��Ʈ�� ���ε�.
            serverSocket = new ServerSocket(7777);
            System.out.println(getTime() + " ������ �غ�Ǿ����ϴ�.");
 
            threadArr = new Thread[num];
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 
    public void start() {
        for (int i = 0; i < threadArr.length; i++) {
            threadArr[i] = new Thread(this);
            threadArr[i].start();
        }
    }
 
    @Override
    public void run() {
        while (true) {
            try {
                System.out.println(getTime() + " �� ���� ��û�� ��ٸ��ϴ�.");
 
                Socket socket = serverSocket.accept();
                System.out.println(getTime() + " " + socket.getInetAddress()
                        + "�κ��� �����û�� ���Խ��ϴ�.");
 

                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                
                System.out.println(dis.readUTF() + " �޾ҽ��ϴ�.");
                dos.writeUTF("[Notice] Test Message1 from Server");
                System.out.println(getTime() + " �����͸� �����Ͽ����ϴ�.");
 
                dos.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
 
    static String getTime() {
        String name = Thread.currentThread().getName();
        SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");
        return f.format(new Date()) + name;
    }
}