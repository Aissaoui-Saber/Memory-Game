package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main extends Application {
    public static int rand(int minIncl,int maxIncl){
        return minIncl + (int)(Math.random() * ((maxIncl - minIncl) + 1));
    }
    @Override
    public void start(Stage primaryStage) {
        TilePane root = new TilePane();
        List<Carte> cartes = new ArrayList();
        List<Integer> cartesAjoute = new ArrayList();
        //Préparation-------------------------------------------------
        for (int i=0;i<16;i++){
            cartes.add(new Carte(0));
            cartes.get(i).setBoutonSize(80,80);
            root.getChildren().add(cartes.get(i).getBouton());
        }
        while (cartesAjoute.size()<16){
            int m = rand(0,15);
            if (cartesAjoute.indexOf(m) == -1){
                cartesAjoute.add(m);
                int v = rand(0,99);
                cartes.get(m).setValue(v);
                do{
                    m = rand(0,15);
                }while (cartesAjoute.indexOf(m) != -1);
                cartesAjoute.add(m);
                cartes.get(m).setValue(v);
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
