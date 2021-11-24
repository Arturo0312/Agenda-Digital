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
                btnl5.setText("");
                btnm5.setText("");
                btnmi5.setText("");
                btnj5.setText("");
                btnv5.setText("");
                btns5.setText("");
                btns4.setText(String.valueOf(d-1));
                this.a=(btnd5.getText());
                break;
            case MONDAY:
                btnl5.setText(String.valueOf(d));
                btnd5.setText(String.valueOf(d-1));
                btnm5.setText("");
                btnmi5.setText("");
                btnj5.setText("");
                btnv5.setText("");
                btns5.setText("");
                this.a=(btnl5.getText());
                break;
            case TUESDAY:
                btnm5.setText(String.valueOf(d));
                btnl5.setText(String.valueOf(d-1));
                btnd5.setText(String.valueOf(Integer.parseInt(btnl5.getText())-1));
                btnmi5.setText("");
                btnj5.setText("");
                btnv5.setText("");
                btns5.setText("");
                this.a=(btnm5.getText());
                break;
            case WEDNESDAY:
                btnmi5.setText(String.valueOf(d));
                btnm5.setText(String.valueOf(d-1));
                btnl5.setText(String.valueOf(Integer.parseInt(btnm5.getText())-1));
                btnd5.setText(String.valueOf(Integer.parseInt(btnl5.getText())-1));
                btnj5.setText("");
                btnv5.setText("");
                btns5.setText("");
                this.a=(btnmi5.getText());
                break;
            case THURSDAY:
                btnj5.setText(String.valueOf(d));
                btnmi5.setText(String.valueOf(Integer.parseInt(btnj5.getText())-1));
                btnm5.setText(String.valueOf(Integer.parseInt(btnmi5.getText())-1));
                System.out.println(btnmi5.getText());
                btnl5.setText(String.valueOf(Integer.parseInt(btnm5.getText())-1));
                btnd5.setText(String.valueOf(Integer.parseInt(btnl5.getText())-1));
                btnv5.setText("");
                btns5.setText("");
                this.a=(btnj5.getText());
                break;
            case FRIDAY:
                btnv5.setText(String.valueOf(d));
                btnj5.setText(String.valueOf(d-1));
                btnmi5.setText(String.valueOf(Integer.parseInt(btnj5.getText())-1));
                btnm5.setText(String.valueOf(Integer.parseInt(btnmi5.getText())-1));
                btnl5.setText(String.valueOf(Integer.parseInt(btnm5.getText())-1));
                btnd5.setText(String.valueOf(Integer.parseInt(btnl5.getText())-1));
                btns5.setText("");
                this.a=(btnv5.getText());
                break;
            case SATURDAY:
                btns5.setText(String.valueOf(d));
                btnv5.setText(String.valueOf(d-1));
                btnj5.setText(String.valueOf(d-2));
                btnmi5.setText(String.valueOf(d-3));
                btnm5.setText(String.valueOf(d-4));
                btnl5.setText(String.valueOf(d-5));
                btnd5.setText(String.valueOf(Integer.parseInt(btnl5.getText())-1));
                this.a=(btns5.getText());
                break;
        }
        Actualizar(1);
    }

    public void Actualizar(int intento){
       int dia= Integer.parseInt(a);
        if (dia>0)
        {
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
                btnv1.setText(String.valueOf(Integer.parseInt(btns1.getText()) - 1));
                btnj1.setText(String.valueOf(Integer.parseInt(btnv1.getText()) - 1));
                btnmi1.setText(String.valueOf(Integer.parseInt(btnj1.getText()) - 1));
                btnm1.setText(String.valueOf(Integer.parseInt(btnmi1.getText()) - 1));
                btnl1.setText(String.valueOf(Integer.parseInt(btnm1.getText()) - 1));
                btnd1.setText(String.valueOf(Integer.parseInt(btnl1.getText()) - 1));
            }
            catch (Exception e)
            {
                System.out.println("a");
            }
        }

    }

    public void mesant(){
        this.mes=mes.minus(1);
        if(mes.equals(Month.JANUARY))
        {
            this.año=año-1;
        }
        initialize();
    }

    public void messig(){
        this.mes=mes.plus(1);
        if(mes.equals(Month.DECEMBER))
        {
            this.año=año+1;
        }
        initialize();
    }
}
