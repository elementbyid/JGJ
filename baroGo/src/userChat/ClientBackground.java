package userChat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * @author ���߱�
 *		�մԼ����� �����ڿ��� ä���� �ɱ� ���� bg Ŭ����
 */
public class ClientBackground {
	
	private Socket socket;
	private DataInputStream in;
	private DataOutputStream out;
	private ClientChatGui gui;
	private String msg;
	private String strPCNum;
	
	public final void setGui(ClientChatGui a_gui)
	{
		this.gui = a_gui;
	}
	
	public void connet() {
		try {
			socket = new Socket("127.0.0.1", 5959);
			System.out.println("���� �����.");
			
			out = new DataOutputStream(socket.getOutputStream());
			
			out.writeUTF(strPCNum);
			out.flush();
			
			// ������ ���ϴ� �����ϴ°Ŷ� ��� ��� ��������? ���� ������� ����
			Thread th = new Thread(new ClientReceiver(socket));
			th.setDaemon(true);
			th.start();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setNickname(String a_strPCNum) {
		this.strPCNum = a_strPCNum;
	}
	
	public void sendMessage(String msg2) {
		try {
			out.writeUTF(msg2);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	class ClientReceiver implements Runnable
	{
		private Socket socket;
		private DataInputStream in;
		
		ClientReceiver(Socket a_socket)
		{
			this.socket = a_socket;
			try{
				in = new DataInputStream(socket.getInputStream());				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(in!=null)
			{
				try {
					msg = in.readUTF();
					gui.appendMsg(msg);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					try {
						socket.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
		}
		
	}
}
