package adminChat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import adminChat.ServerBackground.Receiver;
import adminSales.ReceiverProduct;

/**
 * 
 * @author ���߱�
 * 		����ڰ� ��ǰ�� �ֹ��� �� ���� ����ϰ� �ִ� Ŭ����
 *
 */
public class ServerReceiverProduct implements Runnable {
	private ServerSocket serverSocket;
	private static Socket socket;
	private DataInputStream in;
	private String strMsg = null;
	
	public void setting() throws IOException {
			serverSocket = new ServerSocket(9292);
			while (true) {
				System.out.println("���� �����...");
				socket = serverSocket.accept(); // ���� ������ ������ ��� �ݺ��ؼ� ����ڸ� �޴´�.
				in = new DataInputStream(socket.getInputStream());
				strMsg = in.readUTF();
				ReceiverProduct send = new ReceiverProduct(strMsg);
				try {
					send.start(null);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Receiver receiver = new Receiver(socket);
				receiver.start();
			}
	}

	// -----------------------------------------------------------------------------
	class Receiver extends Thread {
		private String nick;

		/** XXX 2. ���ù��� ������ �ڱ� ȥ�ڼ� ��Ʈ��ũ ó�� ���..���.. ó�����ִ� ��. */
		public Receiver(Socket socket) throws IOException {
			in = new DataInputStream(socket.getInputStream());
		}

		public void run() {
			try {// ��� ���
				while (in != null) 
				{
					strMsg = in.readUTF();
					ReceiverProduct send = new ReceiverProduct(strMsg);
					try {
						send.start(null);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} catch (IOException e) {
			}
		}
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			setting();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
