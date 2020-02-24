package guestLogin;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class GuestLogin extends Application {
	@FXML private Label labelpwch;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass()
					.getResource("Glogin.fxml"));
			Scene scene = new Scene(root); // ��� ����

			//primaryStage.initStyle(StageStyle.TRANSPARENT);	// �׵θ� ����
			primaryStage.setTitle("ȸ������"); // ������ â ����
			primaryStage.setScene(scene); // ������â�� ��� ����
			primaryStage.show(); // ������ �����ֱ�
		} catch (Exception e) {
			throw e;
		}
	}

	public static void main(String[] args) {
		launch(args);	//main ��ü ���� �� ���� ������ ����
	}
}
