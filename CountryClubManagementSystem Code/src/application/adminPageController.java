package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class adminPageController {
	@FXML
    private Button addMemberButton;

    @FXML
    private Button deleteMemberButton;

    @FXML
    private Button editMemberButton;

    @FXML
    private Label invalidDetails;

    @FXML
    private Button logoutButton;

    @FXML
    void AddMemberPage(ActionEvent event) throws IOException {
    	Main m = new Main();
		m.changeScene("AddMemberPage.fxml");
    }

    @FXML
    void EditMemberPage(ActionEvent event) throws IOException {
//    	Main m = new Main();
//		m.changeScene("EditMemberPage.fxml");
    }

    @FXML
    void RemoveMemberPage(ActionEvent event) throws IOException {
//    	Main m = new Main();
//		m.changeScene("DeleteMemberPage.fxml");
    }

    @FXML
    void goBacktoHome(ActionEvent event) throws IOException {
    	Main m = new Main();
		m.changeScene("HomePage.fxml");
    }
}
