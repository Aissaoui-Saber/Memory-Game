package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;


import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

public class Carte extends Button implements EventHandler<ActionEvent> {
    private int valeur;
    private Button bouton;
    private int time;//MELISECOND
    private boolean valeur_visible;
    private Carte paire;

    public Carte(int value){
        this.valeur = value;
        this.bouton = new Button();
        this.bouton.setOnAction(this);
        this.valeur_visible = false;
        this.time = 1000;
        this.paire = null;
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
        this.bouton.setText(String.valueOf(this.valeur));
        this.valeur_visible = true;
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
    /*public boolean isDisabled(){
        return this.bouton.isDisabled();
    }*/
    public boolean isShown(){
        return valeur_visible;
    }
    public void setTime(int t){
        this.time = t;
    }

    public int getTime() {
        return this.time;
    }
    public void setBoutonSize(int width,int height){
        this.bouton.setPrefWidth(width);
        this.bouton.setPrefHeight(height);
    }

    @Override
    public void handle(ActionEvent event) {
        if(this.valeur_visible){
            this.hideValue();
        }else {
            this.showValue();
        }
    }

    public void setPaire(Carte paire) {
        this.paire = paire;
    }
}
