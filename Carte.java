package sample;

import javafx.scene.control.Button;

import java.util.concurrent.TimeUnit;

public class Carte {
    private int valeur;
    private Button bouton;
    private int time;//MELISECOND
    private boolean valeur_visible;

    public Carte(int value){
        this.valeur = value;
        this.bouton = new Button();
        this.valeur_visible = false;
        this.time = 1000;
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
    public boolean isDisabled(){
        return this.bouton.isDisabled();
    }
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
}
