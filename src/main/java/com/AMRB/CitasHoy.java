package com.AMRB;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;

public class CitasHoy {

    private @FXML Button btnCons;
    private ObservableList<Cita> Citas;
    @FXML private TableView<Cita> tblCitas;
    @FXML private TableColumn ColPac;
    @FXML private TableColumn ColPad;
    @FXML private TableColumn ColHor;


    public void initialize() throws SQLException {
        CitasTabla();
        ResultSet rs;
        LocalDate Hoy = LocalDate.now();
        System.out.println(Hoy);
        String path = CitasHoy.class.getResource("Citas.db").toString();
        String url = "jdbc:sqlite:" + path;
        Statement st;
        Connection connection = DriverManager.getConnection(url);
        st=connection.createStatement();
        try {
            rs = st.executeQuery("SELECT * from Citas WHERE Día='"+Hoy+"';");
            while (rs.next()) {
                String nom = rs.getString("Nombre");
                String pad = rs.getString("Padecimiento");
                String ho = rs.getString("Hora");
                Cita a= new Cita(nom,pad,ho);
                this.Citas.add(a);
                this.tblCitas.setItems(Citas);
            }
        }
        catch (SQLException  e) {

        }
    }
    public void CitasTabla(){
        Citas = FXCollections.observableArrayList();
        this.ColPac.setCellValueFactory(new PropertyValueFactory("Paciente"));
        this.ColPad.setCellValueFactory(new PropertyValueFactory("Padecimiento"));
        this.ColHor.setCellValueFactory(new PropertyValueFactory("Hora"));
    }
    public void Consultar() throws IOException {
        FXMLLoader Com = new FXMLLoader(getClass().getResource("AsignarAgenda.fxml"));
        Parent root = Com.load();
        AsignarAgenda ad= Com.getController();
        Scene scene2 = new Scene(root);
        Stage stage2 = new Stage();
        stage2.setScene(scene2);
        stage2.show();
    }
}
