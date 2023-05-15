package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import DB.DBHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import businessLogic.*;

public class facilityPageController implements Initializable{
	
	Controller contr = new Controller();
	
	@FXML
    private TableView<Facility> FacilitiesTable;

    @FXML
    private TableColumn<Facility, Integer> facilityCapacity;

    @FXML
    private TableColumn<Facility, Integer> facilityID;

    @FXML
    private TableColumn<Facility, String> facilityName;

    @FXML
    private TableColumn<Facility, Integer> facilityPrice;

    @FXML
    private Button returnToPortal;

    @FXML
    private Button selectFacilityButton;

    @FXML
    void facilitySelection(ActionEvent event) throws IOException {
    	
    	if (FacilitiesTable.getSelectionModel().getSelectedIndex() == -1)
    	{
    		Alert alertObj = new Alert(Alert.AlertType.WARNING);
    		alertObj.setHeaderText("There is no Facility selected");
    		alertObj.setTitle("Warning");
    		alertObj.setContentText("Please select a Facility before pressing the select button.");
    		alertObj.showAndWait();
    	}
    	else
    	{
    		Facility facilityObj = FacilitiesTable.getSelectionModel().getSelectedItem();
    		ArrayList<Reservation> reservations = new ArrayList<Reservation>();
    		DBHandler DBObj = new DBHandler();
    		reservations = DBObj.getReservations();
    		boolean flag = false;
    		for (Reservation res : reservations)
    		{
    			if (res.getFacilityId() == facilityObj.getFacilityId() && Controller.getMemberObj().getMemberId() == res.getMemberId())
    			{
    				flag = true;
    				break;
    			}
    		}
    		
    		
    		if (flag == false)
    		{
    			contr.selectFacility(facilityObj);
        		
        		Alert alertObj = new Alert(Alert.AlertType.INFORMATION);
        		alertObj.setHeaderText("SUCCESSFULL");
        		alertObj.setTitle("Successfull");
        		alertObj.setContentText("The selected Facility has been successfully reserved!");
        		alertObj.showAndWait();
        		
        		Main m = new Main();
        		m.changeScene("FacilityPage.fxml");
    		}
    		else
    		{
    			Alert alertObj = new Alert(Alert.AlertType.WARNING);
        		alertObj.setHeaderText("You already have this facility reserved");
        		alertObj.setTitle("Warning");
        		alertObj.setContentText("Please select a new Facility.");
        		alertObj.showAndWait();
    		}
    		
    	}
    }
    
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	ArrayList<Facility> facList = contr.displayFacilities();
	ArrayList<Facility> listToShow = new ArrayList<>();
	
	for (Facility obj : facList)
	{
		if (obj.getCapacity() != 0)
			listToShow.add(obj);
	}
	
	ObservableList<Facility> data = FXCollections.observableArrayList(listToShow);
	
	facilityID.setCellValueFactory(new PropertyValueFactory<Facility,Integer>("facilityId"));
	facilityName.setCellValueFactory(new PropertyValueFactory<Facility,String>("name"));
	facilityCapacity.setCellValueFactory(new PropertyValueFactory<Facility,Integer>("capacity"));
	facilityPrice.setCellValueFactory(new PropertyValueFactory<Facility,Integer>("price"));
	
	FacilitiesTable.setItems(data);

}

    @FXML
    void toMemberPage(ActionEvent event) throws IOException {
    	Main m = new Main();
		m.changeScene("MemberPage.fxml");
    }
}
