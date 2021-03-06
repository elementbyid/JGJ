package useInfo;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import barogo.user.repository.UserMapper;
import db.MyBatisConnectionFactory;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import jgj.util.barogo.StringUtil;
import jgj.util.barogo.ViewerUtil;

public class UserSearchController implements Initializable {
    @FXML private TextField textSearch;
    @FXML private Button btnSearch;
    @FXML private TableView<SearchDTO> tables;
    @FXML private AnchorPane searchPane;
    
    SqlSessionFactory sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
    
    String userName;
    SqlSession sqlSession;
    UserMapper mapper;
    
    public UserSearchController(String userName, SqlSession sqlSession) {
        this.userName = userName;
        this.sqlSession = sqlSession;
        this.mapper = sqlSession.getMapper(UserMapper.class);
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            setTableColumn();
            
            // 테이블뷰의 행 클릭햇을때
            tables.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<SearchDTO>() {
                @Override
                public void changed(ObservableValue<? extends SearchDTO> observable, SearchDTO oldValue, SearchDTO newValue) {
                    System.out.println("테이블뷰의 행 클릭");
                }
            });
            
            // 테이블컬럼에 값 저장
            TableColumn names = tables.getColumns().get(0);
            names.setCellValueFactory(new PropertyValueFactory("strName"));
            names.setStyle("-fx-alignment: CENTER;");
            
            TableColumn ids = tables.getColumns().get(1);
            ids.setCellValueFactory(new PropertyValueFactory("strID"));
            ids.setStyle("-fx-alignment: CENTER;");
            
            TableColumn births = tables.getColumns().get(2);
            births.setCellValueFactory(new PropertyValueFactory("birth"));
            births.setStyle("-fx-alignment: CENTER;");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void handlebuttonAction(ActionEvent event) throws Exception {
        if (StringUtil.isEmpty(userName)) {
            popUpTimeAddPeople();
            
            return;
        }
        
        Button botton = (Button) event.getSource();
        int addTime = getAddTime(botton.getId());
        
        popUpTimeAdd(userName, addTime);
    }
    
    private int getAddTime(String buttonId) {
        int id = Integer.parseInt(buttonId);
        
        int result = 1;
        switch (id) {
            case 1:
                result = 1;
                break;
            case 2:
                result = 2;
                break;
            case 3:
                result = 3;
                break;
            case 4:
                result = 6;
                break;
            case 5:
                result = 9;
                break;
            case 6:
                result = 13;
                break;
        }
        
        return result;
    }
    
    // 서치버튼 클릭 핸들러
    // 클릭시 텍스트 필드의 값으로 검색된 내용이 tableview에 출력
    public void handleBtnUseSearchAction(ActionEvent event) {
        tables.getItems().clear();
        try {
            setTableColumn();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void setTableColumn() {
        if (StringUtil.isEmpty(this.userName)) {
            userName = textSearch.getText();
        }
        
        List<UserVO> userList = mapper.findByName(userName);
        for (UserVO user : userList) {
            
            SearchDTO userData = new SearchDTO();
            userData.setStrID(user.getUserId());
            userData.setStrName(user.getName());
            userData.setBirth(user.getDateOfBirth());
            
            tables.getItems().add(userData);
        }
    }
    
    public void handleBtnHomeAction(ActionEvent event) throws Exception {
        Object obj = new UserInfoPopUP(sqlSessionFactory.openSession());
        ViewerUtil.showStage(this, "../useInfo/useInfoPopUP.fxml", null, obj);
        
        Stage primaryStage = (Stage)searchPane.getScene().getWindow();
        primaryStage.close();
    }
    
    public void popUpTimeAddPeople() throws Exception {
        ViewerUtil.showStage(this, "../useInfo/TimeAddPeople.fxml", null, new TimeAddPeople());
    }
    
    public void popUpTimeAdd(String userName, int addTime) {
        try {
            Object timeadd1 = new TimeAdd1(userName, addTime);
            ViewerUtil.showStage(this, "../useInfo/TimeChk.fxml", null, timeadd1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}