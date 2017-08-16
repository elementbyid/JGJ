package serverChat;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import adminView.UseInfoViewController;

public class ServerBack2 implements Runnable{

	private ServerSocket serverSocket;
	private Socket socket;
	private UseInfoViewController gui = new UseInfoViewController();
	private String msg;
	private DataInputStream in;
	
	public void setting() throws IOException 
	{
		serverSocket = new ServerSocket(3939);
		while (true) 
		{
			System.out.println("���� �����...");
			socket = serverSocket.accept();
			System.out.println(socket.getInetAddress() + "���� �����߽��ϴ�.");
			
			// ���⼭ ���ο� ����� ������ Ŭ���� �����ؼ� �������� ����
			Receiver receiver = new Receiver(socket);
			receiver.start();
		}
	}

	// -----------------------------------------------------------------------------
	class Receiver extends Thread {

		/** XXX 2. ���ù��� ������ �ڱ� ȥ�ڼ� ��Ʈ��ũ ó�� ���..���.. ó�����ִ� ��. */
		public Receiver(Socket socket) throws IOException 
		{
			in = new DataInputStream(socket.getInputStream());
		}

		public void run() {
			try 
			{	// ��� ���
				while (in != null) 
				{
					System.out.println("ServerBack");
					msg = in.readUTF();
					System.out.println("@@@@@@@ ServerBack2 run()���� msg @@@@@@@ ");
					System.out.println(msg);
					gui.appendMsg(msg);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try
		{
			setting();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}