package com.AMRB;

import javafx.fxml.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class Login {
    private Parent root;
    private @FXML Button btnex;
    private @FXML Button btnlog;
    private @FXML
    PasswordField txtpass;
    private @FXML
    TextField txtus;

    public void Login() throws  SQLException {
        String usuario=txtus.getText();
        String pass=txtpass.getText();
        ResultSet rs;
        String path = Login.class.getResource("Usuarios.db").toString();
        String url = "jdbc:sqlite:" + path;
        Statement st;
        Connection connection = DriverManager.getConnection(url);
        st=connection.createStatement();
        try {
            rs = st.executeQuery("SELECT * from Users WHERE Usuario='"+usuario+"'and Contra='"+pass+"';");
            String usV=rs.getString("Usuario");
            String pasV=rs.getString("Contra");
            if(usV.equals(usuario) && pasV.equals(pass)){
                FXMLLoader Com = new FXMLLoader(getClass().getResource("CitasHoy.fxml"));
                Parent root = Com.load();
                CitasHoy ad= Com.getController();
                Scene scene2 = new Scene(root);
                Stage stage2 = new Stage();
                stage2.setScene(scene2);
                stage2.setTitle("Citas de Hoy");
                stage2.setUserData(usuario);
                ad.initialize(stage2);
                stage2.show();
            }
        }
        catch (SQLException  e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Usuario o Contraseña Incorrectos");
            alert.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Exit() throws IOException {
        FXMLLoader C = new FXMLLoader(getClass().getResource("Login.fxml"));
        Parent root = C.load();
        Login ad= C.getController();
        Scene scene3 = new Scene(root);
        Stage stage3 = new Stage();
        stage3.setScene(scene3);
        stage3.close();
    }
}
