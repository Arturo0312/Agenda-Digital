package com.AMRB;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

public class Calendario {
    private @FXML Button btnmesant;
    private @FXML Button btnmessig;
    private @FXML Button btnd1;
    private @FXML Button btnd2;
    private @FXML Button btnd3;
    private @FXML Button btnd4;
    private @FXML Button btnd5;
    private @FXML Button btnl1;
    private @FXML Button btnl2;
    private @FXML Button btnl3;
    private @FXML Button btnl4;
    private @FXML Button btnl5;
    private @FXML Button btnm1;
    private @FXML Button btnm2;
    private @FXML Button btnm3;
    private @FXML Button btnm4;
    private @FXML Button btnm5;
    private @FXML Button btnmi1;
    private @FXML Button btnmi2;
    private @FXML Button btnmi3;
    private @FXML Button btnmi4;
    private @FXML Button btnmi5;
    private @FXML Button btnj1;
    private @FXML Button btnj2;
    private @FXML Button btnj3;
    private @FXML Button btnj4;
    private @FXML Button btnj5;
    private @FXML Button btnv1;
    private @FXML Button btnv2;
    private @FXML Button btnv3;
    private @FXML Button btnv4;
    private @FXML Button btnv5;
    private @FXML Button btns1;
    private @FXML Button btns2;
    private @FXML Button btns3;
    private @FXML Button btns4;
    private @FXML Button btns5;
    private int dia;
    private @FXML Label lblmes;
    private Month mes= LocalDate.now().getMonth();
    private int año=LocalDate.now().getYear();

    private String a;
    public void initialize(){
        this.lblmes.setText(String.valueOf(mes)+"-"+año);
        int d=mes.minLength();
        LocalDate dia1=LocalDate.of(this.año,this.mes,d);
        System.out.println(dia1);
        DayOfWeek f=dia1.getDayOfWeek();
        System.out.println(f);
        switch (f){
            case SUNDAY:
                btnd5.setText(String.valueOf(d));
                btnd5.setVisible(true);
                btnl5.setVisible(false);
                btnm5.setVisible(false);
                btnmi5.setVisible(false);
                btnj5.setVisible(false);
                btnv5.setVisible(false);
                btns5.setVisible(false);
                btns4.setText(String.valueOf(d-1));
                this.a=(btnd5.getText());
                break;
            case MONDAY:
                btnl5.setText(String.valueOf(d));
                btnl5.setVisible(true);
                btnd5.setText(String.valueOf(d-1));
                btnd5.setVisible(true);
                btnm5.setVisible(false);
                btnmi5.setVisible(false);
                btnj5.setVisible(false);
                btnv5.setVisible(false);
                btns5.setVisible(false);
                this.a=(btnl5.getText());
                break;
            case TUESDAY:
                btnm5.setText(String.valueOf(d));
                btnm5.setVisible(true);
                btnl5.setText(String.valueOf(d-1));
                btnl5.setVisible(true);
                btnd5.setText(String.valueOf(Integer.parseInt(btnl5.getText())-1));
                btnd5.setVisible(true);
                btnmi5.setVisible(false);
                btnj5.setVisible(false);
                btnv5.setVisible(false);
                btns5.setVisible(false);
                this.a=(btnm5.getText());
                break;
            case WEDNESDAY:
                btnmi5.setText(String.valueOf(d));
                btnmi5.setVisible(true);
                btnm5.setText(String.valueOf(d-1));
                btnm5.setVisible(true);
                btnl5.setText(String.valueOf(Integer.parseInt(btnm5.getText())-1));
                btnl5.setVisible(true);
                btnd5.setText(String.valueOf(Integer.parseInt(btnl5.getText())-1));
                btnd5.setVisible(true);
                btnj5.setVisible(false);
                btnv5.setVisible(false);
                btns5.setVisible(false);
                this.a=(btnmi5.getText());
                break;
            case THURSDAY:
                btnj5.setText(String.valueOf(d));
                btnj5.setVisible(true);
                btnmi5.setText(String.valueOf(Integer.parseInt(btnj5.getText())-1));
                btnmi5.setVisible(true);
                btnm5.setText(String.valueOf(Integer.parseInt(btnmi5.getText())-1));
                btnm5.setVisible(true);
                btnl5.setText(String.valueOf(Integer.parseInt(btnm5.getText())-1));
                btnl5.setVisible(true);
                btnd5.setText(String.valueOf(Integer.parseInt(btnl5.getText())-1));
                btnd5.setVisible(true);
                btnv5.setVisible(false);
                btns5.setVisible(false);
                this.a=(btnj5.getText());
                break;
            case FRIDAY:
                btnv5.setText(String.valueOf(d));
                btnv5.setVisible(true);
                btnj5.setText(String.valueOf(d-1));
                btnj5.setVisible(true);
                btnmi5.setText(String.valueOf(Integer.parseInt(btnj5.getText())-1));
                btnmi5.setVisible(true);
                btnm5.setText(String.valueOf(Integer.parseInt(btnmi5.getText())-1));
                btnm5.setVisible(true);
                btnl5.setText(String.valueOf(Integer.parseInt(btnm5.getText())-1));
                btnl5.setVisible(true);
                btnd5.setText(String.valueOf(Integer.parseInt(btnl5.getText())-1));
                btnd5.setVisible(true);
                btns5.setVisible(false);
                this.a=(btnv5.getText());
                break;
            case SATURDAY:
                btns5.setText(String.valueOf(d));
                btns5.setVisible(true);
                btnv5.setText(String.valueOf(d-1));
                btnv5.setVisible(true);
                btnj5.setText(String.valueOf(d-2));
                btnj5.setVisible(true);
                btnmi5.setText(String.valueOf(d-3));
                btnmi5.setVisible(true);
                btnm5.setText(String.valueOf(d-4));
                btnm5.setVisible(true);
                btnl5.setText(String.valueOf(d-5));
                btnl5.setVisible(true);
                btnd5.setText(String.valueOf(Integer.parseInt(btnl5.getText())-1));
                btnd5.setVisible(true);
                this.a=(btns5.getText());
                break;
        }
        Actualizar(1);
    }

    public void Actualizar(int intento){
       int dia= Integer.parseInt(a);
            try {
                btns4.setText(String.valueOf(Integer.parseInt(btnd5.getText()) - 1));
                btnv4.setText(String.valueOf(Integer.parseInt(btns4.getText()) - 1));
                btnj4.setText(String.valueOf(Integer.parseInt(btnv4.getText()) - 1));
                btnmi4.setText(String.valueOf(Integer.parseInt(btnj4.getText()) - 1));
                btnm4.setText(String.valueOf(Integer.parseInt(btnmi4.getText()) - 1));
                btnl4.setText(String.valueOf(Integer.parseInt(btnm4.getText()) - 1));
                btnd4.setText(String.valueOf(Integer.parseInt(btnl4.getText()) - 1));
                btns3.setText(String.valueOf(Integer.parseInt(btnd4.getText()) - 1));
                btnv3.setText(String.valueOf(Integer.parseInt(btns3.getText()) - 1));
                btnj3.setText(String.valueOf(Integer.parseInt(btnv3.getText()) - 1));
                btnmi3.setText(String.valueOf(Integer.parseInt(btnj3.getText()) - 1));
                btnm3.setText(String.valueOf(Integer.parseInt(btnmi3.getText()) - 1));
                btnl3.setText(String.valueOf(Integer.parseInt(btnm3.getText()) - 1));
                btnd3.setText(String.valueOf(Integer.parseInt(btnl3.getText()) - 1));
                btns2.setText(String.valueOf(Integer.parseInt(btnd3.getText()) - 1));
                btnv2.setText(String.valueOf(Integer.parseInt(btns2.getText()) - 1));
                btnj2.setText(String.valueOf(Integer.parseInt(btnv2.getText()) - 1));
                btnmi2.setText(String.valueOf(Integer.parseInt(btnj2.getText()) - 1));
                btnm2.setText(String.valueOf(Integer.parseInt(btnmi2.getText()) - 1));
                btnl2.setText(String.valueOf(Integer.parseInt(btnm2.getText()) - 1));
                btnd2.setText(String.valueOf(Integer.parseInt(btnl2.getText()) - 1));
                btns1.setText(String.valueOf(Integer.parseInt(btnd2.getText()) - 1));
                if(!(btns1.getText()).equals("")&&!btns1.getText().equals("1")){
                    btnv1.setVisible(true);
                    btnv1.setText(String.valueOf(Integer.parseInt(btns1.getText()) - 1));
                }
                else{
                    btnv1.setText("");
                    btnv1.setVisible(false);}
                if(!(btnv1.getText()).equals("")&&!btnv1.getText().equals("1")){
                    btnj1.setVisible(true);
                    btnj1.setText(String.valueOf(Integer.parseInt(btnv1.getText()) - 1));
                }
                else{
                    btnj1.setText("");
                    btnj1.setVisible(false);}
                if(!(btnj1.getText()).equals("")&&!btnj1.getText().equals("1")){
                    btnmi1.setVisible(true);
                    btnmi1.setText(String.valueOf(Integer.parseInt(btnj1.getText()) - 1));
                }
                else{
                    btnmi1.setText("");
                    btnmi1.setVisible(false);}
                if(!(btnmi1.getText()).equals("")&&!btnmi1.getText().equals("1")){
                    btnm1.setVisible(true);
                    btnm1.setText(String.valueOf(Integer.parseInt(btnmi1.getText()) - 1));
                }
                else{
                    btnm1.setText("");
                    btnm1.setVisible(false);}
                if(!(btnm1.getText()).equals("")&&!btnm1.getText().equals("1")){
                    btnl1.setVisible(true);
                    btnl1.setText(String.valueOf(Integer.parseInt(btnm1.getText()) - 1));
                }
                else{
                    btnl1.setText("");
                    btnl1.setVisible(false);}
                if(!(btnl1.getText()).equals("")&&!btnl1.getText().equals("1")){
                    btnd1.setVisible(true);
                    btnd1.setText(String.valueOf(Integer.parseInt(btnl1.getText()) - 1));
                }
                else{
                    btnd1.setText("");
                    btnd1.setVisible(false);}
            }
            catch (Exception e)
            {
                System.out.println(e);
            }
    }


    public void mesant(){
        this.mes=mes.minus(1);
        if(mes.equals(Month.DECEMBER))
        {
            this.año=año-1;
        }
        initialize();
    }

    public void messig(){
        this.mes=mes.plus(1);
        if(mes.equals(Month.JANUARY))
        {
            this.año=año+1;
        }
        initialize();
    }
}
