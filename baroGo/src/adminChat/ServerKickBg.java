package adminChat;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * 
 * @author ���߱�
 * 		�����ڿ��� �մ��� ���� �����ų �� ���Ǵ� Ŭ����
 * 		�Ķ���ͷ� ������� �մ��ڸ��� ������ �Ѿ (btnSeat.getText)
 *
 */
public class ServerKickBg {
	
	private Socket socket;
	private DataOutputStream out;
	
	public void connet(String a_strType) {
		try {
			socket = new Socket("127.0.0.1", 8426);
			System.out.println("���� �����.");
			
			out = new DataOutputStream(socket.getOutputStream());
			
			out.writeUTF(a_strType);
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