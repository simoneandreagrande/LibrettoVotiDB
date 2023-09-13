package it.polito.tdp.libretto;


import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import it.polito.tdp.libretto.model.Libretto;
import it.polito.tdp.libretto.model.Voto;

public class Controller { // controller non deve mai fare la new del modello, la new la fa il main e il controller riceve le informazioni

	// controller non deve fare mai la new del modello
	private Libretto model;

	public void setModel(Libretto model) {
		this.model = model;
		txtResult.setText(this.model.toString());
	}
	
	
	@FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="cmbPunti"
    private ComboBox<Integer> cmbPunti; // Value injected by FXMLLoader

    @FXML // fx:id="selData"
    private DatePicker selData; // Value injected by FXMLLoader

    @FXML // fx:id="txtCorso"
    private TextField txtCorso; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader

	

    @FXML
    void handleInserisci(ActionEvent event) {
    	String corso = txtCorso.getText();
    	Integer punti = cmbPunti.getValue();
    	LocalDate data = selData.getValue();
    	
    	Voto v = new Voto (corso, punti, data);
    	this.model.add(v);
    	
    	txtResult.setText(this.model.toString());
    }
    

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
	    assert cmbPunti != null : "fx:id=\"cmbPunti\" was not injected: check your FXML file 'main.fxml'.";
	    assert selData != null : "fx:id=\"selData\" was not injected: check your FXML file 'main.fxml'.";
	    assert txtCorso != null : "fx:id=\"txtCorso\" was not injected: check your FXML file 'main.fxml'.";
	    assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'main.fxml'.";

	    for(int p=18;p<=30; p++) {
	    	cmbPunti.getItems().add(p);
	    }
	    
    }
}
