package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CalculadoraGUI {
	
	
	private Stage mainStage;
	
	@FXML
    private TextField tasaEntrada;

    @FXML
    private ComboBox<String> indicesPer1;

    @FXML
    private Label tasaSalida;

    @FXML
    private ComboBox<String> indicesPer2;

	
	public CalculadoraGUI() {
		
	}
    
	public Stage getStage() {
		return mainStage;
	}
	
	public void setMainStage(Stage newStage) {
		mainStage=newStage;
	}
	
    @FXML
    public void conversionTasa(ActionEvent event) throws IOException {
    	FXMLLoader fxmlloader= new FXMLLoader(getClass().getResource("conversionTasas.fxml"));
    	fxmlloader.setController(this);
    	Parent root= fxmlloader.load();
    	Scene scene= new Scene (root);
		mainStage.setScene(scene);
    	mainStage.setTitle("window2");
		mainStage.show();
    }

    @FXML
    public void valorAlicuota(ActionEvent event) {

    }

    @FXML
    public void vdt(ActionEvent event) {

    }
    

    @FXML
    public void convertirTasa(ActionEvent event) {

    }
}
