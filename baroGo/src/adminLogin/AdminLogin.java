package adminLogin;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


/**
 * 
 * @author ���߱�
 *	������ �α���â
 *	
 */
public class AdminLogin extends Application {

    public void start(Stage primaryStage) {
		try {
			AnchorPane root = (AnchorPane)FXMLLoader
					.load(getClass()
					.getResource("Slogin.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("Style2.css").toExternalForm());

			primaryStage.setTitle("�ٷ�go ī����");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
