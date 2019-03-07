package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class Main extends Application{
    private static List<Carte> cartes = new ArrayList();
    private static int firstClickedBtn;
    public static void waitSec(int sec){
        long now = (System.currentTimeMillis()/1000);
        while (((System.currentTimeMillis()/1000)- now) <= sec){

        }
    }
    public static int rand(int minIncl,int maxIncl){
        return minIncl + (int)(Math.random() * ((maxIncl - minIncl) + 1));
    }
    public static int indexOf(ActionEvent e){
        int k=0;
        while (k < cartes.size()){
            if (e.getSource() == cartes.get(k).getBouton()){
                return k;
            }
            k++;
        }
        return -1;
    }
    public static int clickedBtn(){
        int count=0;
        for (int i=0;i<cartes.size();i++){
            if (cartes.get(i).isShown()){
                if (!cartes.get(i).isDisabled()){
                    count++;
                }
            }
        }
        return count;
    }
    public static boolean equalBtn(int btn1,int btn2){
        if (cartes.get(btn1).getValue() == cartes.get(btn2).getValue()){
            return true;
        }else {
            return false;
        }
    }
    @Override
    public void start(Stage primaryStage) {
        TilePane root = new TilePane();

        List<Integer> cartesAjoute = new ArrayList();
        //Préparation-------------------------------------------------
        firstClickedBtn = -1;
        for (int i=0;i<16;i++){
            cartes.add(new Carte(0));
            cartes.get(i).setBoutonSize(80,80);
            root.getChildren().add(cartes.get(i).getBouton());
            cartes.get(i).getBouton().setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    int carteIndex = indexOf(event);
                    if (carteIndex >= 0 && carteIndex < cartes.size()){
                        if(!cartes.get(carteIndex).isShown()){
                            cartes.get(carteIndex).showValue();
                            if (firstClickedBtn == -1){
                                firstClickedBtn = carteIndex;
                            }else {
                                if (carteIndex != firstClickedBtn){
                                    if (equalBtn(carteIndex,firstClickedBtn)){
                                        cartes.get(firstClickedBtn).disableCard();
                                        cartes.get(carteIndex).disableCard();
                                    }else {
                                        cartes.get(firstClickedBtn).hideValue();
                                        cartes.get(carteIndex).hideValue();
                                    }
                                }
                                firstClickedBtn = -1;
                            }
                        }
                    }
                }
            });
        }
        while (cartesAjoute.size()<16){
            int m = rand(0,15);//choisir une carte
            if (cartesAjoute.indexOf(m) == -1){//vérifier si la carte n'est pas ajouté
                cartesAjoute.add(m);//ajouter la carte
                int v = rand(0,99);//valeur aléatoire
                cartes.get(m).setValue(v);//affecter la valeur aléatoire a la carte choisi
                do{
                    m = rand(0,15);
                }while (cartesAjoute.indexOf(m) != -1);//rechercher une paire
                cartesAjoute.add(m);//ajouter la paire
                cartes.get(m).setValue(v);//affecter la valeur aléatoire a la carte paire choisi
            }
        }
        //------------------------------------------------------------
        Scene scene = new Scene(root, 320, 320);

        primaryStage.setTitle("Memory Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
