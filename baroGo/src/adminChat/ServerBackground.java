package adminChat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerBackground implements Runnable {
	private ServerSocket serverSocket;
	private static Socket socket;
	private String msg;
	private static ServerChatGui gui;
	private DataOutputStream out;
	private DataInputStream in;
	
	
	/** ������ ��� ���� */

	public void setting() throws IOException {
			serverSocket = new ServerSocket(5959);
			while (true) {
				System.out.println("���� �����...");
				socket = serverSocket.accept(); // ���� ������ ������ ��� �ݺ��ؼ� ����ڸ� �޴´�.
				System.out.println(socket.getInetAddress() + "���� �����߽��ϴ�.");
				gui = new ServerChatGui();
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
			System.out.println("���ù����� add�ϱ� ���� : " + nick);
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
	
	/*
	class AppendMsg extends Thread {
		String strMsg = null;
		
		AppendMsg(String a_strMsg) 
		{
			this.strMsg = a_strMsg;
		}
		public void run() {
			try {
				gui = new ServerChatGui();
				gui.appendMsg(strMsg);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	*/
}
