package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class managerPageController {
	@FXML
    private Button ManageEmployeeButton;

    @FXML
    private Button ManageFacilitiesButton;

    @FXML
    private Label invalidDetails;

    @FXML
    private Button logoutButton;

    @FXML
    void ManageEmployeePage(ActionEvent event) {

    }

    @FXML
    void ManageFacilitiesPage(ActionEvent event) {

    }

    @FXML
    void goBacktoHome(ActionEvent event) throws IOException {
    	Main m = new Main();
		m.changeScene("HomePage.fxml");
    }

}
