package com.AMRB;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

public class RegistrarPaciente {
    private @FXML
    ComboBox<String>cmbsex;
    private @FXML TextField txtnom;
    private @FXML TextField txtap;
    private @FXML TextField txtcorr;
    private @FXML TextField txttip;
    private @FXML TextField txtnum;
    private @FXML TextArea txfal;


    public void initialize(){
        ObservableList<String> s= FXCollections.observableArrayList();
        s.addAll("M","F");
        cmbsex.setItems(s);
    }

    public void Registrar() throws SQLException {
        String Nombre=txtnom.getText();
        String Apellido=txtap.getText();
        String Correo=txtcorr.getText();
        String num= (txtnum.getText());
        String tipo=txttip.getText();
        String sex=cmbsex.getValue();
        String Alergia=txfal.getText();
        String path = Objects.requireNonNull(RegistrarPaciente.class.getResource("Pacientes.db")).toString();
        String url = "jdbc:sqlite:" + path;
        String sql= "Insert into Paciente values('" + Nombre + "','" + Apellido + "','" + Correo + "','" + tipo + "','" + Alergia + "','" + num + "','" + sex +"');";
        Statement st;
        Connection connection = DriverManager.getConnection(url);
        st=connection.createStatement();
        try {
            st.execute(sql);
            this.txtnom.setText("");
            this.txtap.setText("");
            this.txtcorr.setText("");
            this.txttip.setText("");
            this.txfal.setText("");
            this.txtnum.setText("");
        }
        catch (SQLException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("No ingreso correctamente los datos");
            alert.showAndWait();
        }
    }
}
