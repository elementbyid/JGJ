package adminChat;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * �����ڰ� �մԿ��� �ð��� �߰� ���ٶ� ���Ǵ� Ŭ����
 *  �߰� ���� �ð��� �Ķ���ͷ� �Ѿ��
 */
public class ServerClientTimeAddBg {
	
	private Socket socket;
	private DataOutputStream out;
	
	public void connet(int a_iAddTime) {
		try {
			socket = new Socket("127.0.0.1", 3553);
			System.out.println("���� �����.");
			
			out = new DataOutputStream(socket.getOutputStream());
			
			out.writeUTF(String.valueOf(a_iAddTime));
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