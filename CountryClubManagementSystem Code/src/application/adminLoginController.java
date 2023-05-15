package application;

import java.io.IOException;

import businessLogic.*;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class adminLoginController {
	
	Controller contr = new Controller();
	
	@FXML
    private Button AdminLoginSubmit;

    @FXML
    private Button goBackButt;

    @FXML
    private Label invalidDetails;

    @FXML
    private PasswordField passowrdLoginAdmin;

    @FXML
    private TextField usernameAdmin;

    @FXML
    void AdminPage(ActionEvent event) throws IOException {
    	if(usernameAdmin.getText().isEmpty() || passowrdLoginAdmin.getText().isEmpty())
    	{
    		invalidDetails.setText("Invalid Details");
    	}
    	else {
    		
    		ArrayList<Admin> adminList = contr.getAdmins();
    		
    		for (Admin obj : adminList)
    		{
    			if (obj.getUserAccount().getUserName().equals(usernameAdmin.getText()) && obj.getUserAccount().getPassword().equals(passowrdLoginAdmin.getText()))
    			{
    				
    				contr.setCurrentAdmin(obj);
    				
    				
    				Main m = new Main();
    				m.changeScene("AdminPage.fxml");
    	    		break;
    			}
    		}
    		invalidDetails.setText("Invalid Details");
    	}
    	
    	
    	
    }

    @FXML
    void goBackAct(ActionEvent event) throws IOException {
    	Main m = new Main();
		m.changeScene("HomePage.fxml");
    }
}
