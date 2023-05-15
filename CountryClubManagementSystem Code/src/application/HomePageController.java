package application;

import java.awt.Menu;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class HomePageController {
	@FXML
    private Button ManagerHomeButton;

    @FXML
    private Button MemberHomeButton;

    @FXML
    private Button adminHomeButton;

    @FXML
    void ManagerLoginPage(ActionEvent event) throws IOException {
    	Main m = new Main();
    	m.changeScene("ManagerLogin.fxml");
    }

    @FXML
    void MemberLoginPage(ActionEvent event) throws IOException {
    	Main m = new Main();
    	m.changeScene("MemberLogin.fxml");
    }

    @FXML
    void adminLoginPage(ActionEvent event) throws IOException {
    	Main m = new Main();
    	m.changeScene("AdminLogin.fxml");
    }
}
