package calculadora2;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.util.ResourceBundle;

import Operaciones.Operacion;
import Operaciones.OperacionSimple;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author Germán
 */
public class FXMLDocumentController implements Initializable {
    
    private Operacion operacion;
    private CalculatorParser parseador;

    @FXML
    private Label label;
    
    @FXML
    private TextField campoDeTexto;
    
    @FXML
    private void botonBorrar(ActionEvent event) {
        campoDeTexto.setText("0");
    }
    
    @FXML
    private void botonApretado(ActionEvent event){
        String texto = campoDeTexto.getText();
        String apretado = ((Button)event.getSource()).getText();
        
        if(!texto.equals("0")) campoDeTexto.setText(texto + apretado); 
        else campoDeTexto.setText(apretado);
        
        operacion = parseador.parsear(campoDeTexto.getText());
        System.out.println(operacion.evaluar());
    }
    
    @FXML
    private void botonIgual(ActionEvent event) {
        campoDeTexto.setText(Float.toString(operacion.evaluar()));
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        parseador = new CalculatorParser();
        operacion = new OperacionSimple(0);
    }    
    
}
