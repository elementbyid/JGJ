package adminView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import adminChat.ServerBackground;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import serverChat.ServerBack2;
/**
 * 
 * @author ���߱�
 *	����â ȸ���޴� ��Ʈ�ѷ�
 *	LoginController.java���� primaryStage�� �Ѱܹ޾�
 *	�� ������������ �˾����� ȸ������â(Member.fxml)�� ��Ÿ��
 */
public class UseInfoViewController implements Initializable {
	@FXML private MenuItem 		menuItemUseInfo;
	@FXML private Button		btnSeat80, btnSeat1, btnSeat2, btnSeat3, btnSeat4, btnSeat5, btnSeat6, btnSeat7, btnSeat8, btnSeat9;
	@FXML private Button		btnSeat10, btnSeat11, btnSeat12, btnSeat13, btnSeat14, btnSeat15, btnSeat16, btnSeat17, btnSeat18, btnSeat19;
	@FXML private Button		btnSeat20, btnSeat21, btnSeat22, btnSeat23, btnSeat24, btnSeat25, btnSeat26, btnSeat27, btnSeat28, btnSeat29;
	@FXML private Button		btnSeat30, btnSeat31, btnSeat32, btnSeat33, btnSeat34, btnSeat35, btnSeat36, btnSeat37, btnSeat38, btnSeat39;
	@FXML private Button		btnSeat40, btnSeat41, btnSeat42, btnSeat43, btnSeat44, btnSeat45, btnSeat46, btnSeat47, btnSeat48, btnSeat49;
	@FXML private Button		btnSeat50, btnSeat51, btnSeat52, btnSeat53, btnSeat54, btnSeat55, btnSeat56, btnSeat57, btnSeat58, btnSeat59;
	@FXML private Button		btnSeat60, btnSeat61, btnSeat62, btnSeat63, btnSeat64, btnSeat65, btnSeat66, btnSeat67, btnSeat68, btnSeat69;
	@FXML private Button		btnSeat70, btnSeat71, btnSeat72, btnSeat73, btnSeat74, btnSeat75, btnSeat76, btnSeat77, btnSeat78, btnSeat79;
	@FXML private Button		btnReset;
	@FXML private Text			txtPcNum, txtName, txtPaymentPlan, txtStartTime, txtUseTime, txtMoney;
	@FXML private Label			lblRemainSeat;
	
	private static String[] 	astrReceive		= new String[81];
	private static String[]		astrStartTime	= new String[81];
	private static int[]		aiFlag			= new int[81];
	private static boolean[]	aisFlag			= new boolean[81];
	private static int			iRemainSeat		= 80;
	
	public void handleBtnUseInfoViewAction(ActionEvent action)
	{ 
		popup("useInfo", "useInfoPopUP");
	}

	public void handleBtnCalculateAction(ActionEvent action)
	{
		popup("adminCalculate", "Calculate");
	}
	
	public void handleBtnSalesAction(ActionEvent action)
	{
		popup("adminSales", "product");
	}
	
	public void handleBtnStatsAction(ActionEvent action)
	{
		try{
			FXMLLoader another = new FXMLLoader( getClass().getResource( "../adminStats/MonthStats.fxml" ));
			try {
				TabPane anotherPage = (TabPane) another.load();
			   // �ٸ�â ���� �۾� .... 2
			   Scene anotherScene = new Scene(anotherPage);
			   Stage stage = new  Stage();
			   stage.setScene(anotherScene);
			   stage.show();
			   // �ٸ�â ���� �۾� .... 2 ��.
			} catch (IOException e) {
			   e.printStackTrace();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}

	}
	
	public void handleBtnInfoAction(ActionEvent action)
	{
		popup("adminView","Infomation");
	}
	
	public void handleBtnResetAction(ActionEvent action)
	{
		
		btnReset.setOnAction(event-> {
			handleBtnSeat1Action(event);
			handleBtnSeat2Action(event);
			handleBtnSeat3Action(event);
			handleBtnSeat4Action(event);
			handleBtnSeat5Action(event);
			handleBtnSeat6Action(event);
			handleBtnSeat7Action(event);
			handleBtnSeat8Action(event);
			handleBtnSeat9Action(event);
			handleBtnSeat10Action(event);
			txtPcNum.setText("");
			reset_btnText();
		});
	}
	
	public void handleMenuChatAction(ActionEvent action)
	{
		
	}
	
	public void handleMenuTimeAddAction(ActionEvent action)
	{
		
	}
	
	public void handleBtnSeat1Action(ActionEvent action)
	{
		if(astrReceive[1] == null || astrReceive[1].length() == 0)
		{
			btnSeat1.setText("");
			txtPcNum.setText(btnSeat1.getId());
			reset_btnText();
		} else {
			StringTokenizer strToken = new StringTokenizer(astrReceive[1], "\n");
			print_btnText(strToken, 1);
		}
	}
	
	public void handleBtnSeat2Action(ActionEvent action)
	{
		if(astrReceive[2] == null || astrReceive[2].length() == 0)
		{
			btnSeat2.setText("");
			txtPcNum.setText(btnSeat2.getId());
			reset_btnText();
		} else {
			StringTokenizer strToken = new StringTokenizer(astrReceive[2], "\n");
			print_btnText(strToken, 2);
		}
	}
	
	public void handleBtnSeat3Action(ActionEvent action)
	{
		if(astrReceive[3] == null || astrReceive[3].length() == 0)
		{
			btnSeat3.setText("");
			txtPcNum.setText(btnSeat3.getId());
			reset_btnText();
		} else {
			StringTokenizer strToken = new StringTokenizer(astrReceive[3], "\n");
			print_btnText(strToken, 3);
		}
	}
	
	public void handleBtnSeat4Action(ActionEvent action)
	{
		if(astrReceive[4] == null || astrReceive[4].length() == 0)
		{
			btnSeat4.setText("");
			txtPcNum.setText(btnSeat4.getId());
			reset_btnText();
		} else {
			StringTokenizer strToken = new StringTokenizer(astrReceive[4], "\n");
			print_btnText(strToken, 4);
		}
	}
	
	public void handleBtnSeat5Action(ActionEvent action)
	{
		if(astrReceive[5] == null || astrReceive[5].length() == 0)
		{
			btnSeat5.setText("");
			txtPcNum.setText(btnSeat5.getId());
			reset_btnText();
		} else {
			StringTokenizer strToken = new StringTokenizer(astrReceive[5], "\n");
			print_btnText(strToken, 5);
		}
	}
	
	public void handleBtnSeat6Action(ActionEvent action)
	{
		if(astrReceive[6] == null || astrReceive[6].length() == 0)
		{
			btnSeat6.setText("");
			txtPcNum.setText(btnSeat6.getId());
			reset_btnText();
		} else {
			StringTokenizer strToken = new StringTokenizer(astrReceive[6], "\n");
			print_btnText(strToken, 6);
		}
	}
	
	public void handleBtnSeat7Action(ActionEvent action)
	{
		if(astrReceive[7] == null || astrReceive[7].length() == 0)
		{
			btnSeat7.setText("");
			txtPcNum.setText(btnSeat7.getId());
			reset_btnText();
		} else {
			StringTokenizer strToken = new StringTokenizer(astrReceive[7], "\n");
			print_btnText(strToken, 7);
		}
	}
	
	public void handleBtnSeat8Action(ActionEvent action)
	{
		if(astrReceive[8] == null || astrReceive[8].length() == 0)
		{
			btnSeat8.setText("");
			txtPcNum.setText(btnSeat8.getId());
			reset_btnText();
		} else {
			StringTokenizer strToken = new StringTokenizer(astrReceive[8], "\n");
			print_btnText(strToken, 8);
		}
	}
	
	public void handleBtnSeat9Action(ActionEvent action)
	{
		if(astrReceive[9] == null || astrReceive[9].length() == 0)
		{
			btnSeat9.setText("");
			txtPcNum.setText(btnSeat9.getId());
			reset_btnText();
		} else {
			StringTokenizer strToken = new StringTokenizer(astrReceive[9], "\n");
			print_btnText(strToken, 9);
		}
	}
	
	public void handleBtnSeat10Action(ActionEvent action)
	{
		if(astrReceive[10] == null || astrReceive[10].length() == 0)
		{
			btnSeat10.setText("");
			txtPcNum.setText(btnSeat10.getId());
			reset_btnText();
		} else {
			StringTokenizer strToken = new StringTokenizer(astrReceive[10], "\n");
			print_btnText(strToken, 10);
		}
	}
	
	public void reset_btnText()
	{
		txtName.setText("");
		txtPaymentPlan.setText("");
		txtUseTime.setText("");
		txtStartTime.setText("");
		txtMoney.setText("");
	}
	
	
	// ��ư�� ������Ÿ���� @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	public void print_btnText(StringTokenizer a_strToken, int a_iPCNum)
	{
		String[] astrUse = new String[10];
		for(int i = 0;i < astrUse.length; i++)
		{
			astrUse[i] = "";
		}
		
		int i = 0;
		
		while(a_strToken.hasMoreElements())
		{
			astrUse[i] = a_strToken.nextToken();
			i++;
		}

		String strPrint = astrUse[2] + "\n" +astrUse[3] + "\n" +astrUse[4] + "\n" + astrUse[5];
		switch (a_iPCNum)
		{
		case 1:
			btnSeat1.setText(strPrint);
			txtPcNum.setText(btnSeat1.getId());
			// ó�� �����ߴ��� üũ
			if (astrUse[2] == null || astrUse[2].length() == 0)
			{
				aiFlag[a_iPCNum] = 0;
				if (aisFlag[a_iPCNum]) 
				{
					remain_seat_plus();
					aisFlag[a_iPCNum] = false;
					astrStartTime[a_iPCNum] = null;
				}
			}
			// ������ ���۽ð� ����
			if (aiFlag[a_iPCNum] == 1) 
			{
				if (!aisFlag[a_iPCNum]) 
				{
					remain_seat_sub();
					aisFlag[a_iPCNum] = true;
				}
				astrStartTime[1] = astrUse[1];
			}
			txtStartTime.setText(astrStartTime[1]);
			break;
			case 2:
				btnSeat2.setText(strPrint);
				txtPcNum.setText(btnSeat2.getId());
				if (astrUse[2] == null || astrUse[2].length() == 0) 
				{
					aiFlag[a_iPCNum] = 0;
					if (aisFlag[a_iPCNum])
					{
						remain_seat_plus();
						aisFlag[a_iPCNum] = false;
						astrStartTime[a_iPCNum] = null;
					}
					
				}
				if(aiFlag[a_iPCNum] == 1)
				{
					if (!aisFlag[a_iPCNum])
					{
						remain_seat_sub();
						aisFlag[a_iPCNum] = true;
					}
					astrStartTime[2] = astrUse[1];
				}
				txtStartTime.setText(astrStartTime[2]);
				
				break;
		case 3:
			btnSeat3.setText(strPrint);
			txtPcNum.setText(btnSeat3.getId());
			if (astrUse[2] == null || astrUse[2].length() == 0) 
			{
				aiFlag[a_iPCNum] = 0;
				if (aisFlag[a_iPCNum]) 
				{
					remain_seat_plus();
					aisFlag[a_iPCNum] = false;
					astrStartTime[a_iPCNum] = null;
				}
			}
			if (aiFlag[a_iPCNum] == 1) 
			{
				if (!aisFlag[a_iPCNum]) 
				{
					remain_seat_sub();
					aisFlag[a_iPCNum] = true;
				}
				astrStartTime[3] = astrUse[1];
			}
			txtStartTime.setText(astrStartTime[3]);

			break;
		case 4:
			btnSeat4.setText(strPrint);
			txtPcNum.setText(btnSeat4.getId());
			if (astrUse[2] == null || astrUse[2].length() == 0) 
			{
				aiFlag[a_iPCNum] = 0;
				if (aisFlag[a_iPCNum]) 
				{
					remain_seat_plus();
					aisFlag[a_iPCNum] = false;
					astrStartTime[a_iPCNum] = null;
				}
			}
			if (aiFlag[a_iPCNum] == 1) 
			{
				if (!aisFlag[a_iPCNum]) 
				{
					remain_seat_sub();
					aisFlag[a_iPCNum] = true;
				}
				astrStartTime[4] = astrUse[1];
			}
			txtStartTime.setText(astrStartTime[4]);

			break;
		case 5:
			btnSeat5.setText(strPrint);
			txtPcNum.setText(btnSeat5.getId());
			if (astrUse[2] == null || astrUse[2].length() == 0) 
			{
				aiFlag[a_iPCNum] = 0;
				if (aisFlag[a_iPCNum]) 
				{
					remain_seat_plus();
					aisFlag[a_iPCNum] = false;
					astrStartTime[a_iPCNum] = null;
				}
			}
			if (aiFlag[a_iPCNum] == 1) 
			{
				if (!aisFlag[a_iPCNum]) 
				{
					remain_seat_sub();
					aisFlag[a_iPCNum] = true;
				}
				astrStartTime[5] = astrUse[1];
			}
			txtStartTime.setText(astrStartTime[5]);

			break;
		case 6:
			btnSeat6.setText(strPrint);
			txtPcNum.setText(btnSeat6.getId());
			if (astrUse[2] == null || astrUse[2].length() == 0) 
			{
				aiFlag[a_iPCNum] = 0;
				if (aisFlag[a_iPCNum]) 
				{
					remain_seat_plus();
					aisFlag[a_iPCNum] = false;
					astrStartTime[a_iPCNum] = null;
				}
			}
			if (aiFlag[a_iPCNum] == 1) 
			{
				if (!aisFlag[a_iPCNum]) 
				{
					remain_seat_sub();
					aisFlag[a_iPCNum] = true;
				}
				astrStartTime[6] = astrUse[1];
			}
			txtStartTime.setText(astrStartTime[6]);

			break;
		case 7:
			btnSeat7.setText(strPrint);
			txtPcNum.setText(btnSeat7.getId());
			if (astrUse[2] == null || astrUse[2].length() == 0) 
			{
				aiFlag[a_iPCNum] = 0;
				if (aisFlag[a_iPCNum]) 
				{
					remain_seat_plus();
					aisFlag[a_iPCNum] = false;
					astrStartTime[a_iPCNum] = null;
				}
			}
			if (aiFlag[a_iPCNum] == 1) 
			{
				if (!aisFlag[a_iPCNum]) 
				{
					remain_seat_sub();
					aisFlag[a_iPCNum] = true;
				}
				astrStartTime[7] = astrUse[1];
			}
			txtStartTime.setText(astrStartTime[7]);

			break;
		case 8:
			btnSeat8.setText(strPrint);
			txtPcNum.setText(btnSeat8.getId());
			if (astrUse[2] == null || astrUse[2].length() == 0) 
			{
				aiFlag[a_iPCNum] = 0;
				if (aisFlag[a_iPCNum]) 
				{
					remain_seat_plus();
					aisFlag[a_iPCNum] = false;
					astrStartTime[a_iPCNum] = null;
				}
			}
			if (aiFlag[a_iPCNum] == 1) 
			{
				if (!aisFlag[a_iPCNum]) 
				{
					remain_seat_sub();
					aisFlag[a_iPCNum] = true;
				}
				astrStartTime[8] = astrUse[1];
			}
			txtStartTime.setText(astrStartTime[8]);

			break;
		case 9:
			btnSeat9.setText(strPrint);
			txtPcNum.setText(btnSeat9.getId());
			if (astrUse[2] == null || astrUse[2].length() == 0) 
			{
				aiFlag[a_iPCNum] = 0;
				if (aisFlag[a_iPCNum]) 
				{
					remain_seat_plus();
					aisFlag[a_iPCNum] = false;
					astrStartTime[a_iPCNum] = null;
				}
			}
			if (aiFlag[a_iPCNum] == 1) 
			{
				if (!aisFlag[a_iPCNum]) 
				{
					remain_seat_sub();
					aisFlag[a_iPCNum] = true;
				}
				astrStartTime[9] = astrUse[1];
			}
			txtStartTime.setText(astrStartTime[9]);

			break;
		case 10:
			btnSeat10.setText(strPrint);
			txtPcNum.setText(btnSeat10.getId());
			if (astrUse[2] == null || astrUse[2].length() == 0) 
			{
				aiFlag[a_iPCNum] = 0;
				if (aisFlag[a_iPCNum]) 
				{
					remain_seat_plus();
					aisFlag[a_iPCNum] = false;
					astrStartTime[a_iPCNum] = null;
				}
			}
			if (aiFlag[a_iPCNum] == 1) 
			{
				if (!aisFlag[a_iPCNum]) 
				{
					remain_seat_sub();
					aisFlag[a_iPCNum] = true;
				}
				astrStartTime[10] = astrUse[1];
			}
			txtStartTime.setText(astrStartTime[10]);

			break;
			
			// @@@@@@@@@@@@@@@@@@@@@ 10�������� �ÿ��Ҳ��� �� �ؿ��� �Ȱ�ħ~~~@@@@@@@@@@@@@@@@
			/*
			case 11:
				btnSeat11.setText(strPrint);
				txtPcNum.setText(btnSeat11.getId());
	
				if(astrUse[4].equals("0:0")) { astrStartTime[11] = astrUse[1]; }
				txtStartTime.setText(astrStartTime[11]);
				
				break;
			case 12:
				btnSeat12.setText(strPrint);
				txtPcNum.setText(btnSeat12.getId());
	
				if(astrUse[4].equals("0:0")) { astrStartTime[12] = astrUse[1]; }
				txtStartTime.setText(astrStartTime[12]);
				
				break;
			case 13:
				btnSeat13.setText(strPrint);
				txtPcNum.setText(btnSeat13.getId());
	
				if(astrUse[4].equals("0:0")) { astrStartTime[13] = astrUse[1]; }
				txtStartTime.setText(astrStartTime[13]);
				
				break;
			case 14:
				btnSeat14.setText(strPrint);
				txtPcNum.setText(btnSeat14.getId());
	
				if(astrUse[4].equals("0:0")) { astrStartTime[14] = astrUse[1]; }
				txtStartTime.setText(astrStartTime[14]);
				
				break;
			case 15:
				btnSeat15.setText(strPrint);
				txtPcNum.setText(btnSeat15.getId());
	
				if(astrUse[4].equals("0:0")) { astrStartTime[15] = astrUse[1]; }
				txtStartTime.setText(astrStartTime[15]);
				
				break;
			case 16:
				btnSeat16.setText(strPrint);
				txtPcNum.setText(btnSeat16.getId());
	
				if(astrUse[4].equals("0:0")) { astrStartTime[16] = astrUse[1]; }
				txtStartTime.setText(astrStartTime[16]);
				
				break;
			case 17:
				btnSeat17.setText(strPrint);
				txtPcNum.setText(btnSeat17.getId());
	
				if(astrUse[4].equals("0:0")) { astrStartTime[17] = astrUse[1]; }
				txtStartTime.setText(astrStartTime[17]);
				
				break;
			case 18:
				btnSeat18.setText(strPrint);
				txtPcNum.setText(btnSeat18.getId());
	
				if(astrUse[4].equals("0:0")) { astrStartTime[18] = astrUse[1]; }
				txtStartTime.setText(astrStartTime[18]);
				
				break;
			case 19:
				btnSeat19.setText(strPrint);
				txtPcNum.setText(btnSeat19.getId());
	
				if(astrUse[4].equals("0:0")) { astrStartTime[19] = astrUse[1]; }
				txtStartTime.setText(astrStartTime[19]);
				
				break;
			case 20:
				btnSeat20.setText(strPrint);
				txtPcNum.setText(btnSeat20.getId());
	
				if(astrUse[4].equals("0:0")) { astrStartTime[20] = astrUse[1]; }
				txtStartTime.setText(astrStartTime[20]);
				
				break;
			case 21:
				btnSeat21.setText(strPrint);
				txtPcNum.setText(btnSeat21.getId());
	
				if(astrUse[4].equals("0:0")) { astrStartTime[21] = astrUse[1]; }
				txtStartTime.setText(astrStartTime[21]);
				
				break;
			case 22:
				btnSeat22.setText(strPrint);
				txtPcNum.setText(btnSeat22.getId());
	
				if(astrUse[4].equals("0:0")) { astrStartTime[22] = astrUse[1]; }
				txtStartTime.setText(astrStartTime[22]);
				
				break;
			case 23:
				btnSeat23.setText(strPrint);
				txtPcNum.setText(btnSeat23.getId());
	
				if(astrUse[4].equals("0:0")) { astrStartTime[23] = astrUse[1]; }
				txtStartTime.setText(astrStartTime[23]);
				
				break;
			case 24:
				btnSeat24.setText(strPrint);
				txtPcNum.setText(btnSeat24.getId());
	
				if(astrUse[4].equals("0:0")) { astrStartTime[24] = astrUse[1]; }
				txtStartTime.setText(astrStartTime[24]);
				
				break;
			case 25:
				btnSeat25.setText(strPrint);
				txtPcNum.setText(btnSeat25.getId());
	
				if(astrUse[4].equals("0:0")) { astrStartTime[25] = astrUse[1]; }
				txtStartTime.setText(astrStartTime[25]);
				
				break;
			case 26:
				btnSeat26.setText(strPrint);
				txtPcNum.setText(btnSeat26.getId());
	
				if(astrUse[4].equals("0:0")) { astrStartTime[26] = astrUse[1]; }
				txtStartTime.setText(astrStartTime[26]);
				
				break;
			case 27:
				btnSeat27.setText(strPrint);
				txtPcNum.setText(btnSeat27.getId());
	
				if(astrUse[4].equals("0:0")) { astrStartTime[27] = astrUse[1]; }
				txtStartTime.setText(astrStartTime[27]);
				
				break;
			case 28:
				btnSeat28.setText(strPrint);
				txtPcNum.setText(btnSeat28.getId());
	
				if(astrUse[4].equals("0:0")) { astrStartTime[28] = astrUse[1]; }
				txtStartTime.setText(astrStartTime[28]);
				
				break;
			case 29:
				btnSeat29.setText(strPrint);
				txtPcNum.setText(btnSeat29.getId());
	
				if(astrUse[4].equals("0:0")) { astrStartTime[29] = astrUse[1]; }
				txtStartTime.setText(astrStartTime[29]);
				
				break;
			case 30:
				btnSeat30.setText(strPrint);
				txtPcNum.setText(btnSeat30.getId());
	
				if(astrUse[4].equals("0:0")) { astrStartTime[30] = astrUse[1]; }
				txtStartTime.setText(astrStartTime[30]);
				
				break;
			case 31:
				btnSeat31.setText(strPrint);
				txtPcNum.setText(btnSeat31.getId());
	
				if(astrUse[4].equals("0:0")) { astrStartTime[31] = astrUse[1]; }
				txtStartTime.setText(astrStartTime[31]);
				
				break;
			case 32:
				btnSeat32.setText(strPrint);
				txtPcNum.setText(btnSeat32.getId());
	
				if(astrUse[4].equals("0:0")) { astrStartTime[32] = astrUse[1]; }
				txtStartTime.setText(astrStartTime[32]);
				
				break;
			case 33:
				btnSeat33.setText(strPrint);
				txtPcNum.setText(btnSeat33.getId());
	
				if(astrUse[4].equals("0:0")) { astrStartTime[33] = astrUse[1]; }
				txtStartTime.setText(astrStartTime[33]);
				
				break;
			case 34:
				btnSeat34.setText(strPrint);
				txtPcNum.setText(btnSeat34.getId());
	
				if(astrUse[4].equals("0:0")) { astrStartTime[34] = astrUse[1]; }
				txtStartTime.setText(astrStartTime[34]);
				
				break;
			case 35:
				btnSeat35.setText(strPrint);
				txtPcNum.setText(btnSeat35.getId());
	
				if(astrUse[4].equals("0:0")) { astrStartTime[35] = astrUse[1]; }
				txtStartTime.setText(astrStartTime[35]);
				
				break;
			case 36:
				btnSeat36.setText(strPrint);
				txtPcNum.setText(btnSeat36.getId());
	
				if(astrUse[4].equals("0:0")) { astrStartTime[36] = astrUse[1]; }
				txtStartTime.setText(astrStartTime[36]);
				
				break;
			case 37:
				btnSeat37.setText(strPrint);
				txtPcNum.setText(btnSeat37.getId());
	
				if(astrUse[4].equals("0:0")) { astrStartTime[37] = astrUse[1]; }
				txtStartTime.setText(astrStartTime[37]);
				
				break;
			case 38:
				btnSeat38.setText(strPrint);
				txtPcNum.setText(btnSeat38.getId());
	
				if(astrUse[4].equals("0:0")) { astrStartTime[38] = astrUse[1]; }
				txtStartTime.setText(astrStartTime[38]);
				
				break;
			case 39:
				btnSeat39.setText(strPrint);
				txtPcNum.setText(btnSeat39.getId());
	
				if(astrUse[4].equals("0:0")) { astrStartTime[39] = astrUse[1]; }
				txtStartTime.setText(astrStartTime[39]);
				
				break;
			case 40:
				btnSeat40.setText(strPrint);
				txtPcNum.setText(btnSeat40.getId());
	
				if(astrUse[4].equals("0:0")) { astrStartTime[40] = astrUse[1]; }
				txtStartTime.setText(astrStartTime[40]);
				
				break;
			case 41:
				btnSeat41.setText(strPrint);
				txtPcNum.setText(btnSeat41.getId());
	
				if(astrUse[4].equals("0:0")) { astrStartTime[41] = astrUse[1]; }
				txtStartTime.setText(astrStartTime[41]);
				
				break;
			case 42:
				btnSeat42.setText(strPrint);
				txtPcNum.setText(btnSeat42.getId());
	
				if(astrUse[4].equals("0:0")) { astrStartTime[42] = astrUse[1]; }
				txtStartTime.setText(astrStartTime[42]);
				
				break;
			case 43:
				btnSeat43.setText(strPrint);
				txtPcNum.setText(btnSeat43.getId());
	
				if(astrUse[4].equals("0:0")) { astrStartTime[43] = astrUse[1]; }
				txtStartTime.setText(astrStartTime[43]);
				
				break;
			case 44:
				btnSeat44.setText(strPrint);
				txtPcNum.setText(btnSeat44.getId());
	
				if(astrUse[4].equals("0:0")) { astrStartTime[44] = astrUse[1]; }
				txtStartTime.setText(astrStartTime[44]);
				
				break;
			case 45:
				btnSeat45.setText(strPrint);
				txtPcNum.setText(btnSeat45.getId());
	
				if(astrUse[4].equals("0:0")) { astrStartTime[45] = astrUse[1]; }
				txtStartTime.setText(astrStartTime[45]);
				
				break;
			case 46:
				btnSeat46.setText(strPrint);
				txtPcNum.setText(btnSeat46.getId());
	
				if(astrUse[4].equals("0:0")) { astrStartTime[46] = astrUse[1]; }
				txtStartTime.setText(astrStartTime[46]);
				
				break;
			case 47:
				btnSeat47.setText(strPrint);
				txtPcNum.setText(btnSeat47.getId());
	
				if(astrUse[4].equals("0:0")) { astrStartTime[47] = astrUse[1]; }
				txtStartTime.setText(astrStartTime[47]);
				
				break;
			case 48:
				btnSeat48.setText(strPrint);
				txtPcNum.setText(btnSeat48.getId());
	
				if(astrUse[4].equals("0:0")) { astrStartTime[48] = astrUse[1]; }
				txtStartTime.setText(astrStartTime[48]);
				
				break;
			case 49:
				btnSeat49.setText(strPrint);
				txtPcNum.setText(btnSeat49.getId());
	
				if(astrUse[4].equals("0:0")) { astrStartTime[49] = astrUse[1]; }
				txtStartTime.setText(astrStartTime[49]);
				
				break;
			case 50:
				btnSeat50.setText(strPrint);
				txtPcNum.setText(btnSeat50.getId());
	
				if(astrUse[4].equals("0:0")) { astrStartTime[50] = astrUse[1]; }
				txtStartTime.setText(astrStartTime[50]);
				
				break;
			case 51:
				btnSeat51.setText(strPrint);
				txtPcNum.setText(btnSeat51.getId());
	
				if(astrUse[4].equals("0:0")) { astrStartTime[51] = astrUse[1]; }
				txtStartTime.setText(astrStartTime[51]);
				
				break;
			case 52:
				btnSeat52.setText(strPrint);
				txtPcNum.setText(btnSeat52.getId());
	
				if(astrUse[4].equals("0:0")) { astrStartTime[52] = astrUse[1]; }
				txtStartTime.setText(astrStartTime[52]);
				
				break;
			case 53:
				btnSeat53.setText(strPrint);
				txtPcNum.setText(btnSeat53.getId());
	
				if(astrUse[4].equals("0:0")) { astrStartTime[53] = astrUse[1]; }
				txtStartTime.setText(astrStartTime[53]);
				
				break;
			case 54:
				btnSeat54.setText(strPrint);
				txtPcNum.setText(btnSeat54.getId());
	
				if(astrUse[4].equals("0:0")) { astrStartTime[54] = astrUse[1]; }
				txtStartTime.setText(astrStartTime[54]);
				
				break;
			case 55:
				btnSeat55.setText(strPrint);
				txtPcNum.setText(btnSeat55.getId());
	
				if(astrUse[4].equals("0:0")) { astrStartTime[55] = astrUse[1]; }
				txtStartTime.setText(astrStartTime[55]);
				
				break;
			case 56:
				btnSeat56.setText(strPrint);
				txtPcNum.setText(btnSeat56.getId());
	
				if(astrUse[4].equals("0:0")) { astrStartTime[56] = astrUse[1]; }
				txtStartTime.setText(astrStartTime[56]);
				
				break;
			case 57:
				btnSeat57.setText(strPrint);
				txtPcNum.setText(btnSeat57.getId());
	
				if(astrUse[4].equals("0:0")) { astrStartTime[57] = astrUse[1]; }
				txtStartTime.setText(astrStartTime[57]);
				
				break;
			case 58:
				btnSeat58.setText(strPrint);
				txtPcNum.setText(btnSeat58.getId());
	
				if(astrUse[4].equals("0:0")) { astrStartTime[58] = astrUse[1]; }
				txtStartTime.setText(astrStartTime[58]);
				
				break;
			case 59:
				btnSeat59.setText(strPrint);
				txtPcNum.setText(btnSeat59.getId());
	
				if(astrUse[4].equals("0:0")) { astrStartTime[59] = astrUse[1]; }
				txtStartTime.setText(astrStartTime[59]);
				
				break;
			case 60:
				btnSeat60.setText(strPrint);
				txtPcNum.setText(btnSeat60.getId());
	
				if(astrUse[4].equals("0:0")) { astrStartTime[60] = astrUse[1]; }
				txtStartTime.setText(astrStartTime[60]);
				
				break;
			case 61:
				btnSeat61.setText(strPrint);
				txtPcNum.setText(btnSeat61.getId());
	
				if(astrUse[4].equals("0:0")) { astrStartTime[61] = astrUse[1]; }
				txtStartTime.setText(astrStartTime[61]);
				
				break;
			case 62:
				btnSeat62.setText(strPrint);
				txtPcNum.setText(btnSeat62.getId());
	
				if(astrUse[4].equals("0:0")) { astrStartTime[62] = astrUse[1]; }
				txtStartTime.setText(astrStartTime[62]);
				
				break;
			case 63:
				btnSeat63.setText(strPrint);
				txtPcNum.setText(btnSeat63.getId());
	
				if(astrUse[4].equals("0:0")) { astrStartTime[63] = astrUse[1]; }
				txtStartTime.setText(astrStartTime[63]);
				
				break;
			case 64:
				btnSeat64.setText(strPrint);
				txtPcNum.setText(btnSeat64.getId());
	
				if(astrUse[4].equals("0:0")) { astrStartTime[64] = astrUse[1]; }
				txtStartTime.setText(astrStartTime[64]);
				
				break;
			case 65:
				btnSeat65.setText(strPrint);
				txtPcNum.setText(btnSeat65.getId());
	
				if(astrUse[4].equals("0:0")) { astrStartTime[65] = astrUse[1]; }
				txtStartTime.setText(astrStartTime[65]);
				
				break;
			case 66:
				btnSeat66.setText(strPrint);
				txtPcNum.setText(btnSeat66.getId());
	
				if(astrUse[4].equals("0:0")) { astrStartTime[66] = astrUse[1]; }
				txtStartTime.setText(astrStartTime[66]);
				
				break;
			case 67:
				btnSeat67.setText(strPrint);
				txtPcNum.setText(btnSeat67.getId());
	
				if(astrUse[4].equals("0:0")) { astrStartTime[67] = astrUse[1]; }
				txtStartTime.setText(astrStartTime[67]);
				
				break;
			case 68:
				btnSeat68.setText(strPrint);
				txtPcNum.setText(btnSeat68.getId());
	
				if(astrUse[4].equals("0:0")) { astrStartTime[68] = astrUse[1]; }
				txtStartTime.setText(astrStartTime[68]);
				
				break;
			case 69:
				btnSeat69.setText(strPrint);
				txtPcNum.setText(btnSeat69.getId());
	
				if(astrUse[4].equals("0:0")) { astrStartTime[69] = astrUse[1]; }
				txtStartTime.setText(astrStartTime[69]);
				
				break;
			case 70:
				btnSeat70.setText(strPrint);
				txtPcNum.setText(btnSeat70.getId());
	
				if(astrUse[4].equals("0:0")) { astrStartTime[70] = astrUse[1]; }
				txtStartTime.setText(astrStartTime[70]);
				
				break;
			case 71:
				btnSeat71.setText(strPrint);
				txtPcNum.setText(btnSeat71.getId());
	
				if(astrUse[4].equals("0:0")) { astrStartTime[71] = astrUse[1]; }
				txtStartTime.setText(astrStartTime[71]);
				
				break;
			case 72:
				btnSeat72.setText(strPrint);
				txtPcNum.setText(btnSeat72.getId());
	
				if(astrUse[4].equals("0:0")) { astrStartTime[72] = astrUse[1]; }
				txtStartTime.setText(astrStartTime[72]);
				
				break;
			case 73:
				btnSeat73.setText(strPrint);
				txtPcNum.setText(btnSeat73.getId());
	
				if(astrUse[4].equals("0:0")) { astrStartTime[73] = astrUse[1]; }
				txtStartTime.setText(astrStartTime[73]);
				
				break;
			case 74:
				btnSeat74.setText(strPrint);
				txtPcNum.setText(btnSeat74.getId());
	
				if(astrUse[4].equals("0:0")) { astrStartTime[74] = astrUse[1]; }
				txtStartTime.setText(astrStartTime[74]);
				
				break;
			case 75:
				btnSeat75.setText(strPrint);
				txtPcNum.setText(btnSeat75.getId());
	
				if(astrUse[4].equals("0:0")) { astrStartTime[75] = astrUse[1]; }
				txtStartTime.setText(astrStartTime[75]);
				
				break;
			case 76:
				btnSeat76.setText(strPrint);
				txtPcNum.setText(btnSeat76.getId());
	
				if(astrUse[4].equals("0:0")) { astrStartTime[76] = astrUse[1]; }
				txtStartTime.setText(astrStartTime[76]);
				
				break;
			case 77:
				btnSeat77.setText(strPrint);
				txtPcNum.setText(btnSeat77.getId());
	
				if(astrUse[4].equals("0:0")) { astrStartTime[77] = astrUse[1]; }
				txtStartTime.setText(astrStartTime[77]);
				
				break;
			case 78:
				btnSeat78.setText(strPrint);
				txtPcNum.setText(btnSeat78.getId());
	
				if(astrUse[4].equals("0:0")) { astrStartTime[78] = astrUse[1]; }
				txtStartTime.setText(astrStartTime[78]);
				
				break;
			case 79:
				btnSeat79.setText(strPrint);
				txtPcNum.setText(btnSeat79.getId());
	
				if(astrUse[4].equals("0:0")) { astrStartTime[79] = astrUse[1]; }
				txtStartTime.setText(astrStartTime[79]);
				
				break;
			case 80:
				btnSeat80.setText(strPrint);
				txtPcNum.setText(btnSeat80.getId());
	
				if(astrUse[4].equals("0:0")) { astrStartTime[80] = astrUse[1]; }
				txtStartTime.setText(astrStartTime[80]);
				
				break;
				*/
		}
		
		txtName.setText(astrUse[3]);
		txtPaymentPlan.setText(astrUse[2]);
		txtUseTime.setText(astrUse[4]);
		txtMoney.setText(astrUse[5]);
	}

	public void popup(String a_strPackage, String a_strAction)
	{
		try{
			FXMLLoader another = new FXMLLoader( getClass().getResource( "../" + a_strPackage + "/" + a_strAction + ".fxml" ));
			try {
			   AnchorPane anotherPage = (AnchorPane) another.load();
			   // �ٸ�â ���� �۾� .... 2
			   Scene anotherScene = new Scene(anotherPage);
			   Stage stage = new  Stage();
			   stage.setScene(anotherScene);
			   stage.show();
			   // �ٸ�â ���� �۾� .... 2 ��.
			} catch (IOException e) {
			   e.printStackTrace();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void appendMsg(String msg)
	{
		
			System.out.println("########### appendMsg �ȿ��� msg ###########");
			System.out.println(msg);
			//btnSeat0.setText(msg);
			//tfTest.setText(msg);
		
		StringTokenizer strToken = new StringTokenizer(msg, "\n");
		String strSubMsg = null;
		
		if(strToken.hasMoreElements())
		{
			strSubMsg = strToken.nextToken();
		}
		
		switch (Integer.parseInt(strSubMsg)) {
			case 01: astrReceive[1] = msg; 	 aiFlag[1] += 1; break;
			case 02: astrReceive[2] = msg; 	 aiFlag[2] += 1; break;
			case 03: astrReceive[3] = msg; 	 aiFlag[3] += 1; break;
			case 04: astrReceive[4] = msg;   aiFlag[4] += 1; break;
			case 05: astrReceive[5] = msg; 	 aiFlag[5] += 1; break;
			case 06: astrReceive[6] = msg; 	 aiFlag[6] += 1; break;
			case 07: astrReceive[7] = msg; 	 aiFlag[7] += 1; break;
			case 0x08: astrReceive[8] = msg; aiFlag[8] += 1; break;
			case 0x09: astrReceive[9] = msg; aiFlag[9] += 1; break;
			case 10: astrReceive[10] = msg;	 aiFlag[10] += 1; break;
		}
	}
	
	public void remain_seat_sub()
	{
		iRemainSeat--;
		Platform.runLater(()->
		{
			System.out.println(" remainSeat M : " + iRemainSeat);
			lblRemainSeat.setText(String.valueOf(iRemainSeat));
		});
	}
	
	public void remain_seat_plus()
	{
		iRemainSeat++;
		Platform.runLater(()->
		{
			System.out.println(" remainSeat P : " + iRemainSeat);
			lblRemainSeat.setText(String.valueOf(iRemainSeat));
		});
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		// ����� ���� ������ ���󽺷���� ��� ��Ű�� ��û�� �ö��� Ȱ��ȭ��
		// ServerBack2Ŭ������ Runnable �������̽��� ���
		// ServerBackgorund�� ä�ÿ� ServerBack2�� ������ �޴� ��
		for(int i = 0; i < aiFlag.length; i++)
		{
			aiFlag[i] = 0;
			aisFlag[i] = false;
		}
		
		
		Thread th = new Thread(new ServerBack2());
		Thread th2 = new Thread(new ServerBackground());
		
		th.setDaemon(true);
		th2.setDaemon(true);
		
		th.start();
		th2.start();
	}
}