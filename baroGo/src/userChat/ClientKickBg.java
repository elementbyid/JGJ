package userChat;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import userInfoView.UserInfoController;

/**
 * @author ���߱�
 *		�����ڿ��� �մԼ� pc�� ������ ���� ��Ű�� ���� ������ ����ϴ� bg Ŭ����
 */
public class ClientKickBg implements Runnable {
	private ServerSocket serverSocket;
	private static Socket socket;
	private DataInputStream in;
	private String strType;
	
	public void setting() throws IOException {
			serverSocket = new ServerSocket(8426);
			while (true) {
				System.out.println("���� �����...");
				socket = serverSocket.accept(); // ���� ������ ������ ��� �ݺ��ؼ� ����ڸ� �޴´�.
				in = new DataInputStream(socket.getInputStream());
				strType = in.readUTF();
				
				UserInfoController useinfo = new UserInfoController();
				try {
					useinfo.pc_exit(strType);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}

	// -----------------------------------------------------------------------------

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
