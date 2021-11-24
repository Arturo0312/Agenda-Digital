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
import java.util.Objects;

public class CitasHoy {

    private @FXML Button btnCons;
    private @FXML Button btnexp;
    private ObservableList<Cita> Citas;
    private @FXML TableView<Cita> tblCitas;
    private @FXML TableColumn ColPac;
    @FXML private TableColumn ColPad;
    @FXML private TableColumn ColHor;
    private @FXML Label lbldia;
    private LocalDate Hoy=LocalDate.now();
    private @FXML Button btnnext;
    private @FXML Button btnprev;

    public CitasHoy() {
    }

    public void initialize() throws SQLException {
        LimpiarT();
        CitasTabla();
        ResultSet rs;
        lbldia.setText(String.valueOf(this.Hoy));
        String path = Objects.requireNonNull(CitasHoy.class.getResource("Citas.db")).toString();
        String url = "jdbc:sqlite:" + path;
        Statement st;
        Connection connection = DriverManager.getConnection(url);
        try (connection) {
            st = connection.createStatement();
            rs = st.executeQuery("SELECT * from Citas WHERE Día='" + Hoy + "' order by Hora;");
            while (rs.next()) {
                String nom = rs.getString("Nombre");
                String pad = rs.getString("Padecimiento");
                String ho = rs.getString("Hora");
                Cita a = new Cita(nom, pad, ho);
                this.Citas.add(a);
                this.tblCitas.setItems(Citas);
            }
        } catch (SQLException e) {
            System.out.println("No hay citas");
        }
    }

    public void LimpiarT(){
        CitasTabla();
        Cita a = new Cita("","","");
        this.Citas.add(a);
        this.tblCitas.setItems(Citas);
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
    public void Registrar() throws IOException {
        FXMLLoader Com = new FXMLLoader(getClass().getResource("RegistrarPaciente.fxml"));
        Parent root = Com.load();
        RegistrarPaciente ad= Com.getController();
        Scene scene3 = new Scene(root);
        Stage stage3 = new Stage();
        stage3.setScene(scene3);
        stage3.show();
    }

    public void Expediente() throws IOException {
        FXMLLoader Com = new FXMLLoader(getClass().getResource("Calendario.fxml"));
        Parent root = Com.load();
        Calendario ad= Com.getController();
        Scene scene4 = new Scene(root);
        Stage stage4 = new Stage();
        stage4.setScene(scene4);
        stage4.show();
    }
    public void Next() throws SQLException {
        this.Hoy=Hoy.plusDays(1);
        LimpiarT();
        initialize();
    }

    public void Prev() throws SQLException {
        this.Hoy=Hoy.minusDays(1);
        LimpiarT();
        initialize();
    }
}
