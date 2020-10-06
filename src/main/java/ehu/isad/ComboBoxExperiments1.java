package ehu.isad;

import com.google.gson.Gson;
import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class ComboBoxExperiments1 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {


        ComboBox comboBox = new ComboBox();

        comboBox.getItems().add("BTC");
        comboBox.getItems().add("LTC");
        comboBox.getItems().add("ETH");

        Label label =new Label();
        VBox vbox = new VBox();
        vbox.getChildren().addAll(label,comboBox);
        Scene scene = new Scene(vbox, 200, 120);
        primaryStage.setScene(scene);
        primaryStage.show();

        comboBox.setEditable(false);

        comboBox.setOnAction(e -> {
            System.out.println( comboBox.getValue());
            Txanpona t= new Txanpona();
            try {

               t=readFromUrl((String) comboBox.getValue());
               label.setText("1 "+comboBox.getValue()+" ="+t.price+" €");
               vbox.getChildren().add(label);
                System.out.println(t.price);


            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });


    }
    public Txanpona readFromUrl(String txanpon) throws IOException {
        String inputline = "";
        URL coinmarket;
        Txanpona t= new Txanpona();
        try {
            coinmarket = new URL("https://api.gdax.com/products/" + txanpon + "-eur/ticker");
            URLConnection yc = coinmarket.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
            inputline = in.readLine();

            Gson gson = new Gson();
            t=gson.fromJson(inputline, Txanpona.class);
           // System.out.println(inputline);
            in.close();
            return t;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            ;
        }

        return t;

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
