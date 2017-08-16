package serverChat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ServerBack {

	private ServerSocket serverSocket;
	private Socket socket;
	private ServerGui gui;
	private String msg;
	private DataOutputStream out;
	private DataInputStream in;
	
	/** ������ ��� ���� */
	private Map<String, DataOutputStream> clientsMap = new HashMap<String, DataOutputStream>();

	public final void setGui(ServerGui gui) {
		this.gui = gui;
	}

	public void setting() throws IOException {
			Collections.synchronizedMap(clientsMap);
			serverSocket = new ServerSocket(3939);
			while (true) {
				System.out.println("���� �����...");
				socket = serverSocket.accept(); // ���� ������ ������ ��� �ݺ��ؼ� ����ڸ� �޴´�.
				System.out.println(socket.getInetAddress() + "���� �����߽��ϴ�.");
				// ���⼭ ���ο� ����� ������ Ŭ���� �����ؼ� �������� ����
				Receiver receiver = new Receiver(socket);
				receiver.start();
			}
	}

	public static void main(String[] args) throws IOException {
		ServerBack serverBackground = new ServerBack();
		serverBackground.setting();
	}


	public void addClient(String nick, DataOutputStream out) throws IOException {
		sendMessage(nick + "���� �����ϼ̽��ϴ�.");
		clientsMap.put(nick, out);
	}

	public void removeClient(String nick) {
		sendMessage(nick + "���� �����̽��ϴ�.");
		clientsMap.remove(nick);
	}

	// �޽��� ���� ����
	public void sendMessage(String msg) {
		Iterator<String> it = clientsMap.keySet().iterator();
		String key = "";
		while (it.hasNext()) {
			key = it.next();
			try {
				clientsMap.get(key).writeUTF(msg);
			} catch (IOException e) {
				e.printStackTrace();
			}
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
			System.out.println("���Դ� �̰� : " + nick);
			addClient(nick, out);
		}

		public void run() {
			try {// ��� ���
				while (in != null) {
					msg = in.readUTF();
					sendMessage(msg);
					gui.appendMsg(msg);
				}
			} catch (IOException e) {
				removeClient(nick);
			}
		}
	}
}
