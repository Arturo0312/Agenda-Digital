package com.AMRB;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.sql.*;

public class AsignarAgenda {

    private @FXML Button btnAg;
    private @FXML
    ComboBox<String> cmbPac;

    public void initialize() throws SQLException {
        String path = AsignarAgenda.class.getResource("Pacientes.db").toString();
        String url = "jdbc:sqlite:" + path;
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
                Pacientes.addAll(n+" - "+a);
            }
            System.out.println(Pacientes);
            cmbPac=new ComboBox<>(Pacientes);
        }
        catch (SQLException  e) {
            System.out.println("a");
        }
        }

    public void Agendar() throws SQLException {

    }
}
