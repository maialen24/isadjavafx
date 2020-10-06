package ehu.isad;

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.InputStream;


public class ComboBoxExperiments extends Application  {

    @Override
    public void start(Stage primaryStage) throws Exception {

        InputStream is = getClass().getResourceAsStream("/cactus.png");
        BufferedImage reader = ImageIO.read(is);
        Image image = SwingFXUtils.toFXImage(reader,null);
        ImageView imageView = new ImageView(image);
        primaryStage.setTitle("ComboBox Experiment ");

        VBox vbox = new VBox(imageView);
        vbox.setAlignment(Pos.BASELINE_CENTER);
        vbox.setPadding(new Insets(10,0,0,0));
        Scene scene = new Scene(vbox, 200, 120);
        primaryStage.setScene(scene);
        primaryStage.show();


    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}