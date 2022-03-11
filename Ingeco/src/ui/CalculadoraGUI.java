package ui;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import model.Calculadora;

public class CalculadoraGUI {


	private Stage mainStage;

	private Calculadora calculadora;

	@FXML
	private TextField tasaEntrada;
	@FXML
	private TextField nperEntrada;
	@FXML
	private TextField nperObj;


	@FXML
	private ComboBox<String> indicesPer1;

	@FXML
	private Label tasaSalida;

	@FXML
	private ComboBox<String> indicesPer2;


	@FXML
	private RadioButton rbAhorro;

	@FXML
	private ToggleGroup rbAlicuota;

	@FXML
	private RadioButton rbCredito;

	@FXML
	private TextField valorTextField;

	@FXML
	private TextField vaTextField;

	@FXML
	private TextField nPlazoTextField;

	@FXML
	private TextField iTextField;

	@FXML
	private Label labelValorObjetivo;



	public CalculadoraGUI() {
		calculadora= new Calculadora();
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
		mainStage.setTitle("Conversion de tasas");
		mainStage.show();
		showIndex();
	}

	public void showIndex() {
		ObservableList<String> items = FXCollections.observableArrayList();
		items.addAll("n.a","n.v","p.a","p.v","E.A");
		indicesPer1.getItems().addAll(items);
		indicesPer2.getItems().addAll(items);
	}

	@FXML
	public void valorAlicuota(ActionEvent event) throws IOException {
		FXMLLoader fxmlloader= new FXMLLoader(getClass().getResource("CalcularAlicuota.fxml"));
		fxmlloader.setController(this);
		Parent root= fxmlloader.load();
		Scene scene= new Scene (root);
		mainStage.setScene(scene);
		mainStage.setTitle("Valor de alicuota");
		mainStage.show();
	}

	@FXML
	public void vdt(ActionEvent event) {

	}

	public void mostrarLabelVA() {
		if(rbAhorro.isSelected()) {
			labelValorObjetivo.setText("VF");
		}
		else if(rbCredito.isSelected()) {
			labelValorObjetivo.setText("VP");
		}
	}

	@FXML
	public void calculoAlicuota(ActionEvent event) {
		Alert alert=new Alert(null); 
		mostrarLabelVA();
		String vo=valorTextField.getText();
		String va=vaTextField.getText();
		String tipo=labelValorObjetivo.getText();
		String tasa=iTextField.getText();
		String nplazo=nPlazoTextField.getText();
		if(vo.isEmpty()||va.isEmpty()||tipo.isEmpty()||tasa.isEmpty()||nplazo.isEmpty()) {
			alert.setAlertType(AlertType.WARNING);
			alert.setTitle("Warning Dialog");
			alert.setHeaderText("There are missing information");
			alert.setContentText("Please complete the information");
			alert.showAndWait();
		}
		else {
			
		}

	}


	@FXML
	public void convertirTasa(ActionEvent event) {
		//Alert alert=new Alert(null); 
		String[] indices1=indicesPer1.getValue().split("\\.");
		String[] indices2=indicesPer2.getValue().split("\\.");
		double tasaInicial=Double.parseDouble(tasaEntrada.getText());
		int nper0=Integer.parseInt(nperEntrada.getText());
		int nper1=Integer.parseInt(nperObj.getText());
		double tasaConvertida=calculadora.calcularTasa(indices1, indices2, tasaInicial/100, nper0, nper1)*100;
		tasaSalida.setText(tasaConvertida+"%");
	}
}
