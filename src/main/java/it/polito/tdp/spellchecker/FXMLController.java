/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.spellchecker;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.spellchecker.model.Dizionario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class FXMLController {
	
	private Dizionario model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnCLTxt;

    @FXML
    private Button btnSpCheck;

    @FXML
    private ComboBox<String> cmbLanguage;

    @FXML
    private Label stringErrori;

    @FXML
    private Label tempoCompletamento;

    @FXML
    private TextArea txtInserimentoUtente;

    @FXML
    private TextArea txtParoleErrate;

    @FXML
    void doClearText(ActionEvent event) {
    	txtInserimentoUtente.setText("");
    	txtParoleErrate.setText("");
    	stringErrori.setText("");
    	tempoCompletamento.setText("");
    }

    @FXML
    void doSpellCheck(ActionEvent event) {
    	long t1= System.currentTimeMillis();
    	String lingua= cmbLanguage.getValue();
    	List<String> risultato= model.ricercaContains(txtInserimentoUtente.getText(), lingua);
    	
    	for(String s: risultato) 
    		txtParoleErrate.appendText(s);
    	
    	stringErrori.setText("The text contains "+risultato.size()+" errors");
    	long t2= System.currentTimeMillis();
    	tempoCompletamento.setText("Spell check complited in "+(t2-t1));
    }

    @FXML
    void initialize() {
        assert btnCLTxt != null : "fx:id=\"btnCLTxt\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnSpCheck != null : "fx:id=\"btnSpCheck\" was not injected: check your FXML file 'Scene.fxml'.";
        assert cmbLanguage != null : "fx:id=\"cmbLanguage\" was not injected: check your FXML file 'Scene.fxml'.";
        assert stringErrori != null : "fx:id=\"stringErrori\" was not injected: check your FXML file 'Scene.fxml'.";
        assert tempoCompletamento != null : "fx:id=\"tempoCompletamento\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtInserimentoUtente != null : "fx:id=\"txtInserimentoUtente\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtParoleErrate != null : "fx:id=\"txtParoleErrate\" was not injected: check your FXML file 'Scene.fxml'.";
        
        cmbLanguage.getItems().add("Italian");
        cmbLanguage.getItems().add("English");
        

    }

	public void setModel(Dizionario model) {
		this.model=model;
	}

}
