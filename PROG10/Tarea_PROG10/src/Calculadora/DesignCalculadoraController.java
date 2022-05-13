
package Calculadora;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author jorma
 */
public class DesignCalculadoraController implements Initializable {

private int resul = 0;
    private String numero;
    private int num1;
    private int num2;
    private char tecla;
    private String registro;
    @FXML
    private TextField tfNumero1;

    @FXML
    private TextField tfResultado;

    @FXML
    private TextField tfRegistro;

/*
    @FXML
    private void button0 (ActionEvent event){
    numero += 0;
    tfNumero1.setText(numero);
    }
 */   
    
    @FXML
    private void buttonSumarHandler(ActionEvent event) {
        num2 = resul;
        num1 = Integer.parseInt(tfNumero1.getText());

        //Ya hemos recogido el valor de los operados de los campos de texto de la interfaz. Realizamos la suma.
        resul += num1;

        if (registro == null) {
            registro = String.valueOf(num1);
        } else {
            registro = registro + " + " + num1;
        }

        tfRegistro.setText(registro);

        tfResultado.setText(String.valueOf(resul));
        tfNumero1.setText("");
    }

    @FXML
    private void buttonRestarHandler(ActionEvent event) {
        num2 = resul;
        num1 = Integer.parseInt(tfNumero1.getText());

        //Ya hemos recogido el valor de los operados de los campos de texto de la interfaz. Realizamos la resta.
        resul -= num1;

        if (registro == null) {
            registro = String.valueOf(num1);
        } else {
            registro = registro + " - " + num1;
        }

        tfRegistro.setText(registro);

        tfResultado.setText(String.valueOf(resul));
        tfNumero1.setText("");
    }

    @FXML
    private void buttonMultiplicarHandler(ActionEvent event) {
        num2 = resul;
        num1 = Integer.parseInt(tfNumero1.getText());

        if (registro == null) {
            resul = num1;
            registro = String.valueOf(num1);

        } else {
            registro = registro + " * " + num1;
            resul *= num1;
        }

        tfRegistro.setText(registro);

        tfResultado.setText(String.valueOf(resul));
        tfNumero1.setText("");
    }

    @FXML
    private void buttonDividirHandler(ActionEvent event) {
        num2 = resul;
        num1 = Integer.parseInt(tfNumero1.getText());

        if (num1 == 0) {
            JOptionPane.showMessageDialog(null, "No se puede dividir entre 0");
        } else {
            if (resul == 0) {
                resul = num1;
            } else {
                resul /= num1;
            }

            if (registro == null) {
                registro = String.valueOf(num1);
            } else {
                registro = registro + " / " + num1;
            }

            tfRegistro.setText(registro);

            tfResultado.setText(String.valueOf(resul));
            tfNumero1.setText("");
        }

    }

    @FXML
    private void buttonBorrarHandler(ActionEvent event) {
        num1 = 0;
        resul = 0;
        registro = null;

        tfResultado.setText("");
        tfNumero1.setText("");
        tfRegistro.setText("");
    }

    @FXML
    private void buttonSalirHandler(ActionEvent event) {
        System.exit(0);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //TODO
    }

}
