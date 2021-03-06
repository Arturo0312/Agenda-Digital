package com.AMRB;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.sql.*;
import java.time.LocalDate;

public class AsignarAgenda {

    private @FXML Button btnAg;
    private @FXML ComboBox<String> cmbhor;
    private @FXML
    ComboBox<String> cmbPac;
    private @FXML
    TextField txtdoc;
    private @FXML
    TextField txtpad;
    private @FXML
    DatePicker dtCalendario;
    private @FXML ComboBox<String> cmbdoc;

    public void initialize() throws SQLException {
        String path = AsignarAgenda.class.getResource("Pacientes.db").toString();
        String url = "jdbc:sqlite:" + path;
        System.out.println(path);
        ResultSet rs;
        Statement st;
        ObservableList<String> Pacientes= FXCollections.observableArrayList();
        String n,a;
        Connection connection = DriverManager.getConnection(url);
        st=connection.createStatement();
        try {
            rs = st.executeQuery("SELECT * from Paciente;");
            while (rs.next())
            {
                n=rs.getString("Nombre");
                a=rs.getString("Apellido");
                Pacientes.addAll(n+" "+a);
            }
            System.out.println(Pacientes);
            cmbPac.setItems(Pacientes);
        }
        catch (SQLException  e) {
            System.out.println("a");
        }
        ObservableList<String> h= FXCollections.observableArrayList();
        h.addAll("11:00","11:30","12:00","12:30","13:00","13:30","14:00","14:30","15:00","15:30","16:00","16:30","17:00","17:30","18:00");
        cmbhor.setItems(h);
        path=AsignarAgenda.class.getResource("Usuarios.db").toString();
        url = "jdbc:sqlite:" + path;
        ObservableList<String> Doctores= FXCollections.observableArrayList();
        String Doc;
        connection = DriverManager.getConnection(url);
        st=connection.createStatement();
        try {
            rs = st.executeQuery("SELECT * from Users;");
            while (rs.next())
            {
                Doc=rs.getString("Usuario");
                Doctores.addAll(Doc);
            }
            cmbdoc.setItems(Doctores);
        }
        catch (SQLException  e) {
            System.out.println("a");
        }
        }

    public void Agendar() throws SQLException {
        String P=cmbPac.getValue();
        String Doc=cmbdoc.getValue();
        String Pad=txtpad.getText();
        String hora=cmbhor.getValue();
        LocalDate dia=dtCalendario.getValue();
        LocalDate hoy=LocalDate.now();
        String d=dia.toString();
        if (!dia.isBefore(hoy)) {
            String path = AsignarAgenda.class.getResource("Citas.db").toString();
            String url = "jdbc:sqlite:" + path;
            String sql = "Insert into Citas values('" + P + "','" + Pad + "','" + hora + "','" + Doc + "','" + d + "');";
            Statement st;
            Connection connection = DriverManager.getConnection(url);
            st = connection.createStatement();
            try {
                st.execute(sql);
            } catch (SQLException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                if(e.toString().contains("PRIMARY KEY"))
                {
                    alert.setContentText("Esta fecha ya esta ocupada.");
                }
                else{
                    alert.setContentText("No ingreso correctamente los datos");
                }
                alert.showAndWait();
            }
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("La fecha ya paso");
            alert.showAndWait();
        }
    }
}
