package it.polito.tdp.noleggio;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.noleggio.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	private Model model;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnSimula;

    @FXML
    private TextField txtNC;

    @FXML
    private TextArea txtResult;

    @FXML
    void handleButtonSimula(ActionEvent event) {
        txtResult.clear();
    	String macchine = this.txtNC.getText();
    	try {
    		int nc = Integer.parseInt(macchine);
    		if(nc<=0) {
    			txtResult.setText("inserisci un numero maggiore di zero.");
    			return;
    		}
    		this.model.simula(nc);
    		txtResult.appendText(this.model.getTotClienti()+" totale clienti \n");
    		txtResult.appendText(this.model.getClientiInsoddisfatti()+" totale clienti insoddisfatti");
    		
    	}catch (NumberFormatException e) {
    		txtResult.setText("inserisci un numero maggiore di zero.");
    		e.printStackTrace();
    		return;
    	}
    }

    @FXML
    void initialize() {
        assert btnSimula != null : "fx:id=\"btnSimula\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtNC != null : "fx:id=\"txtNC\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";

    }

	public void setModel(Model model) {
		// TODO Auto-generated method stub
		this.model=model;
	}

}
