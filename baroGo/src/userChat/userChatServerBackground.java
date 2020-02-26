package userChat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author ���߱�
 *		�����ڿ��� ä���� �� �� ������ ��ٸ��� bg Ŭ����
 */
public class userChatServerBackground implements Runnable {
	private ServerSocket serverSocket;
	private static Socket socket;
	private String msg;
	private static ClientChatGui gui;
	private DataOutputStream out;
	private DataInputStream in;
	

	public void setting() throws IOException {
			serverSocket = new ServerSocket(5959);
			while (true) {
				System.out.println("���� �����...");
				socket = serverSocket.accept(); // ���� ������ ������ ��� �ݺ��ؼ� ����ڸ� �޴´�.
				System.out.println(socket.getInetAddress() + "���� �����߽��ϴ�.");
				gui = new ClientChatGui();
				try {
					gui.start(null);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// ���⼭ ���ο� ����� ������ Ŭ���� �����ؼ� �������� ����
				Receiver receiver = new Receiver(socket);
				receiver.start();
			}
	}

	public void addClient(String nick, DataOutputStream out) throws IOException {
		System.out.println("addClinet ");
		sendMessage(nick + "������ �����ϼ̽��ϴ�.\n");
	}

	public void removeClient(String nick) {
		sendMessage(nick + "������ �����̽��ϴ�.");
	}

	// �޽��� ���� ����
	public void sendMessage(String msg) {
		try {
			out = new DataOutputStream(socket.getOutputStream());
			out.writeUTF(msg);
			out.flush();
			gui.appendMsg(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	// -----------------------------------------------------------------------------
	class Receiver extends Thread {
		private String nick;

		/** XXX 2. ���ù��� ������ �ڱ� ȥ�ڼ� ��Ʈ��ũ ó�� ���..���.. ó�����ִ� ��. */
		public Receiver(Socket socket) throws IOException {
			out = new DataOutputStream(socket.getOutputStream());
			in = new DataInputStream(socket.getInputStream());
			nick = in.readUTF();
			addClient(nick, out);
		}

		public void run() {
			try {// ��� ���
				while (in != null) 
				{
					msg = in.readUTF();
					sendMessage(msg);
				}
			} catch (IOException e) {
				removeClient(nick);
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