package userChat;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import userInfoView.UserInfoController;

/**
 * @author ���߱�
 *		�����ڿ��� �մԿ��� �ð��� �߰��� �� ������ ����ϴ� bg Ŭ����
 */
public class ClientServerTimeAddBg implements Runnable {
	private ServerSocket serverSocket;
	private static Socket socket;
	private DataInputStream in;
	private String strTime;
	UserInfoController user = new UserInfoController();
	
	public void setting() throws IOException {
			serverSocket = new ServerSocket(3553);
			while (true) {
				System.out.println("���� �����...");
				socket = serverSocket.accept(); // ���� ������ ������ ��� �ݺ��ؼ� ����ڸ� �޴´�.
				in = new DataInputStream(socket.getInputStream());
				strTime = in.readUTF();
				System.out.println(strTime);
				user.add_hour_time(strTime);
				// ���⼭ ���ο� ����� ������ Ŭ���� �����ؼ� �������� ����
				Receiver receiver = new Receiver(socket);
				receiver.start();
			}
	}

	// -----------------------------------------------------------------------------
	class Receiver extends Thread {

		/** XXX 2. ���ù��� ������ �ڱ� ȥ�ڼ� ��Ʈ��ũ ó�� ���..���.. ó�����ִ� ��. */
		public Receiver(Socket socket) throws IOException {
			in = new DataInputStream(socket.getInputStream());
		}

		public void run() {
			try {// ��� ���
				while (in != null) 
				{
					strTime = in.readUTF();
					user.add_hour_time(strTime);
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
