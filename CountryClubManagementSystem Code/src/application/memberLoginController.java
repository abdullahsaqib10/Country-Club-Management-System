package application;

import java.io.IOException;
import java.util.ArrayList;

import businessLogic.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class memberLoginController {
	
	Controller contr = new Controller();
	
	@FXML
    private Button MemberLoginSubmit;

    @FXML
    private Button goBackButt;

    @FXML
    private Label invalidDetails;

    @FXML
    private PasswordField passowrdLoginMember;

    @FXML
    private TextField usernameMember;

    @FXML
    void MemberPage(ActionEvent event) throws IOException {
    	if(usernameMember.getText().isEmpty() || passowrdLoginMember.getText().isEmpty())
    	{
    		invalidDetails.setText("Invalid Details");
    	}
    	else {
    		ArrayList<Member> memberList = contr.getMembers();
    		
    		for (Member obj : memberList)
    		{
    			if (obj.getUserAccount().getUserName().equals(usernameMember.getText()) && obj.getUserAccount().getPassword().equals(passowrdLoginMember.getText()))
    			{
    				contr.setCurrentMember(obj);
//    				
//    				ArrayList<Order> orderList = contr.getAllOrders();
//    				ArrayList<Order> custOrderList = new ArrayList<Order>();
//    				
//    				for (Order obj2 : orderList)
//    				{
//    					if (obj2.getCustId() == obj.getCustId())
//    					{
//    						custOrderList.add(obj2);
//    					}
//    				}
//    				
//    				obj.setOrderList(custOrderList);
//    				contr.setCurrentCustomer(obj);
    				
    				
    				Main m = new Main();
    				m.changeScene("MemberPage.fxml");
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
