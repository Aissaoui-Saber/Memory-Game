package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;


import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

public class Carte{
    private int valeur;
    private Button bouton;
    private boolean valeur_visible;

    public Carte(int value){
        this.valeur = value;
        this.bouton = new Button();
        this.valeur_visible = false;
    }

    public int getValue() {
        return this.valeur;
    }

    public Button getBouton() {
        return this.bouton;
    }

    public void setValue(int value) {
        this.valeur = value;
    }
    public void showValue(){
        bouton.setText(String.valueOf(valeur));
        valeur_visible = true;
    }
    public void hideValue(){
        this.bouton.setText("");
        this.valeur_visible = false;
    }
    public void disableCard(){
        this.bouton.setDisable(true);
    }
    public void enableCard(){
        this.bouton.setDisable(false);
    }
    public boolean isDisabled(){
        return this.bouton.isDisabled();
    }
    public boolean isShown(){
        return valeur_visible;
    }
    public void setBoutonSize(int width,int height){
        this.bouton.setPrefWidth(width);
        this.bouton.setPrefHeight(height);
    }
}
