/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.spellchecker;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.spellchecker.model.Dictionary;
import it.polito.tdp.spellchecker.model.RichWord;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class FXMLController {

	private Dictionary model;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> cmbLanguage;

    @FXML
    private Label txtComment;

    @FXML
    private TextArea txtInput;

    @FXML
    private TextArea txtOutput;

    @FXML
    private Label txtTime;

    @FXML
    void doClearText(ActionEvent event) {
    	txtComment.setText("");
    	txtInput.clear();
    	txtOutput.clear();
    	cmbLanguage.setValue(null);
    	txtTime.setText("");
    }

    @FXML
    void doSpellCheck(ActionEvent event) {
    	double inizio = System.nanoTime();
    	String percorso = "src/main/resources/"+cmbLanguage.getValue();
    	model.loadDictionary(percorso);
    	String input = txtInput.getText().toLowerCase().replaceAll("[.,\\/#!?$%\\^&\\*;:{}=\\-_`~()\\[\\]\"]", "");
    	String [] parole = input.split(" ");
    	List <String> listaParole = new ArrayList<String>();
    	for(String s : parole) 
    		listaParole.add(s);
    	List<RichWord> listaErrori = model.spellCheckText(listaParole);
    	txtComment.setText("Il testo contiene "+listaErrori.size()+" errori");
    	String s="";
    	for(RichWord rw : listaErrori) {
    		//txtOutput.appendText(rw.toString());
    		s+=rw.toString()+"\n";
    	}	
    	txtOutput.setText(s);
    	double fine = System.nanoTime();
    	txtTime.setText("Spell check completed in "+(fine-inizio)*0.000000001+" seconds");
    }
    
    public void setModel(Dictionary model) {
		this.model = model;
	}

    @FXML
    void initialize() {
        assert cmbLanguage != null : "fx:id=\"cmbLanguage\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtComment != null : "fx:id=\"txtComment\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtInput != null : "fx:id=\"txtInput\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtOutput != null : "fx:id=\"txtOutput\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTime != null : "fx:id=\"txtTime\" was not injected: check your FXML file 'Scene.fxml'.";
        
        cmbLanguage.getItems().clear();
		cmbLanguage.getItems().add("English");
		cmbLanguage.getItems().add("Italian");
    }

}
