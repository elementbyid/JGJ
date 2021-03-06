package adminLogin;


import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import adminView.UseInfoViewController;
import barogo.user.repository.UserMapper;
import db.MyBatisConnectionFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import jgj.util.barogo.BCryptPasswordEncoder;

/**
 * 
 * @author 지중구
 *  관리자 로그인창 버튼 컨트롤러
 *  id와 pw를 넘겨받아 db에 저장된 값과 비교
 *  맞으면 회원정보창(AdminMainView.fxml)을 실행
 *
 */
public class LoginController{

    @FXML private TextField id;
    @FXML private PasswordField pw;
    @FXML private Button btnLogin;
    
    SqlSessionFactory sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
    SqlSession sqlSession;
    UserMapper mapper;
    
    public LoginController(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
        this.mapper = sqlSession.getMapper(UserMapper.class);
    }
    
    public void handleBtnLoginAction(ActionEvent action) {
        
        try {
            if(!isLogin()) {
                id.setText("");
                pw.setText("");
                
                return;
            }
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../adminView/AdminMainView.fxml"));
            Object obj = new UseInfoViewController(sqlSession);
            loader.setController(obj);
            Parent mainView = loader.load();
    
            //Parent mainView = FXMLLoader.load(getClass().getResource("AdminMainView.fxml"));
            Scene scene = new Scene(mainView);
            scene.getStylesheets().add(getClass().getResource("../adminView/AdminMainView.css").toExternalForm());
            Stage primaryStage = (Stage)btnLogin.getScene().getWindow();
            
            primaryStage.setResizable(false); // 창 크기 조절 불가능
            primaryStage.setX(0);
            primaryStage.setY(0);
            primaryStage.setScene(scene);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    private boolean isLogin() {
        boolean isResult = true;
        
        String userId = id.getText();
        String password = pw.getText();
        
        String adminPassword  = mapper.findPasswordById(userId);
        
        BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();
        if (!bcryptPasswordEncoder.matches(password, adminPassword)) {
            isResult = false;
            System.out.println("비밀번호 아예 틀림");
        }

        return isResult;
    }
}