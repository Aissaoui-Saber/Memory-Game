package sample;

import javafx.scene.control.Button;

public class Carte {
    private int valeur;
    private Button bouton;

    public Carte(int value){
        this.valeur = value;
        bouton = new Button();
    }

    public Button getBouton() {
        return this.bouton;
    }

    public int getValeur() {
        return this.valeur;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }
}
