package userChat;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * 
 * @author ���߱�
 * 		�մԼ����� ��ǰ �ֹ��� �� ���Ǵ� Ŭ����
 *
 */
public class ClientSendProductBg {
	
	private Socket socket;
	private DataOutputStream out;
	
	public void connet(String strSendMsg) {
		try {
			socket = new Socket("127.0.0.1", 9292);
			System.out.println("���� �����.");
			
			out = new DataOutputStream(socket.getOutputStream());
			out.writeUTF(strSendMsg);
			out.flush();
			socket.close();
		} catch (IOException e) {
			try {
				socket.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
}