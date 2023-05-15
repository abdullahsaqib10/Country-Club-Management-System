package application;

import java.io.IOException;

import businessLogic.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class addMemberController {
	Controller contr = new Controller();
	
	@FXML
    private TextField MemberEmail;

    @FXML
    private TextField MemberName;

    @FXML
    private PasswordField MemberPassword;

    @FXML
    private TextField MemberPhNumber;

    @FXML
    private TextField MemberUsername;

    @FXML
    private Button SubmitButton;

    @FXML
    private Button goBackButt;

    @FXML
    private Label warning;

    @FXML
    void AdminPage(ActionEvent event) throws IOException {
    	if(MemberUsername.getText().isEmpty() || MemberEmail.getText().isEmpty() || MemberName.getText().isEmpty() || MemberPassword.getText().isEmpty() || MemberPhNumber.getText().isEmpty())
    	{
    		warning.setText("Invalid Details");
    	}
    	else
    	{
    		contr.addMember(MemberName.getText(), MemberPassword.getText(), MemberEmail.getText(), MemberUsername.getText(), MemberPassword.getText());
    		
    		Alert alertObj = new Alert(Alert.AlertType.INFORMATION);
    		alertObj.setHeaderText("SUCCESSFULL");
    		alertObj.setTitle("Successfull");
    		alertObj.setContentText("Member has been successfully added!");
    		alertObj.showAndWait();
    		
    		Main m = new Main();
    		m.changeScene("AdminPage.fxml");
    	}
    	
    }

    @FXML
    void goBackAct(ActionEvent event) throws IOException {
    	Main m = new Main();
		m.changeScene("AdminPage.fxml");
    }

}
