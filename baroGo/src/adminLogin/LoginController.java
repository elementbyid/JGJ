package adminLogin;


import DB.DBManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
/**
 * 
 * @author ���߱�
 * 	������ �α���â ��ư ��Ʈ�ѷ�
 * 	id�� pw�� �Ѱܹ޾� db�� ����� ���� ��
 *  ������ ȸ������â(AdminMainView.fxml)�� ����
 *
 */
public class LoginController{

	// Slogin.fxml�� TExtField�� fx:id �� �� ���� ����
	@FXML private TextField 		id;
	@FXML private PasswordField		pw;
	@FXML private Button 			btnLogin;

	private DBManager db = new DBManager();
	private boolean result;

	public void handleBtnLoginAction(ActionEvent action)
	{
		String strID = id.getText();
		String strPW = pw.getText();
		
		result = db.login_query(strID, strPW, true);
		
		if(!result)
		{
			id.setText("");
			pw.setText("");
		} else  {
			try{
				
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../adminView/AdminMainView.fxml"));
			Parent mainView = loader.load();

			//Parent mainView = FXMLLoader.load(getClass().getResource("AdminMainView.fxml"));
			Scene scene = new Scene(mainView);
			scene.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
			Stage primaryStage = (Stage)btnLogin.getScene().getWindow();
			primaryStage.setScene(scene);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}