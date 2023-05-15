package application;

import java.io.IOException;

import java.util.ArrayList;

import businessLogic.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class managerLoginController {
	
	Controller contr = new Controller();
	
	@FXML
    private Button ManagerLoginSubmit;

    @FXML
    private Button goBackButt;

    @FXML
    private Label invalidDetails;

    @FXML
    private PasswordField passowrdLoginManager;

    @FXML
    private TextField usernameManager;

    @FXML
    void ManagerPage(ActionEvent event) throws IOException {
    	
    	if(usernameManager.getText().isEmpty() || passowrdLoginManager.getText().isEmpty())
    	{
    		invalidDetails.setText("Invalid Details");
    	}
    	else {
    		ArrayList<Manager> managerList = contr.getManagers();
    		
    		for (Manager obj : managerList)
    		{
    			if (obj.getUserAccount().getUserName().equals(usernameManager.getText()) && obj.getUserAccount().getPassword().equals(passowrdLoginManager.getText()))
    			{
    				contr.setCurrentManager(obj);
    				
    				
    				Main m = new Main();
    				m.changeScene("HomePage.fxml");
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
