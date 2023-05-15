package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class memberPageController {
	@FXML
    private Button bookRoomButton;

    @FXML
    private Label invalidDetails;

    @FXML
    private Button logoutButton;

    @FXML
    private Button makePaymentButton;

    @FXML
    private Button reserveFacilityButton;

    @FXML
    private Button reserveHallButton;

    @FXML
    private Button reserveRestaurantTableButton;

    @FXML
    private Button viewReservationbutton;

    @FXML
    void FacilityPage(ActionEvent event) throws IOException {
    	Main m = new Main();
		m.changeScene("FacilityPage.fxml");
    }

    @FXML
    void HallPage(ActionEvent event) throws IOException {
//    	Main m = new Main();
//		m.changeScene("HallPage.fxml");
    }

    @FXML
    void RoomBookingPage(ActionEvent event) throws IOException {
//    	Main m = new Main();
//		m.changeScene("RoomBookingPage.fxml");
    }

    @FXML
    void goBacktoHome(ActionEvent event) throws IOException {
    	Main m = new Main();
		m.changeScene("HomePage.fxml");
    }

    @FXML
    void paymentPage(ActionEvent event) throws IOException {
//    	Main m = new Main();
//		m.changeScene("PaymentPage.fxml");
    }

    @FXML
    void reservationPage(ActionEvent event) throws IOException {
//    	Main m = new Main();
//		m.changeScene("ReservationPage.fxml");
    }

    @FXML
    void reserveTablePage(ActionEvent event) throws IOException {
//    	Main m = new Main();
//		m.changeScene("ReserveTablePage.fxml");
    }
}
