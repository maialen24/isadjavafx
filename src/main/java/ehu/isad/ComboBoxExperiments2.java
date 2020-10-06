package ehu.isad;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ComboBoxExperiments2 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        ComboBox comboBilduma = new ComboBox();

        List<String> bildumak =
                List.of("abereak", "landareak", "frutak");
        ObservableList<String> bildumaList = FXCollections.observableArrayList(bildumak);
        comboBilduma.setItems(bildumaList);
        comboBilduma.setPromptText("abereak");

        /*VBox vbox = new VBox(comboBilduma);
        //vbox.setAlignment(Pos.BOTTOM_LEFT);
        //  vbox.setPadding(new Insets(10,0,0,0));
        Scene scene = new Scene(vbox, 200, 120);
        primaryStage.setScene(scene);
        primaryStage.show();*/
        Map<String, List<Argazki>> bildumaMap = new HashMap<>();

        bildumaMap.put("abereak", List.of(
                new Argazki("Elefantea", "elefantea.jpeg"),
                new Argazki("Txakurra", "txakurra.jpeg"),
                new Argazki("Untxia", "untxia.png")
        ));
        bildumaMap.put("landareak", List.of(
                new Argazki("Landare berdea", "landareberdea.jpeg"),
                new Argazki("Landare horia", "landarehoria.jpeg")

        ));
        bildumaMap.put("frutak", List.of(
                new Argazki("Fresa", "fresa.jpeg"),
                new Argazki("Sagarra", "sagarra.jpeg"),
                new Argazki("Sandia", "sandia.png")
        ));
// GAUZA BERA landareak eta frutarekin

        ObservableList<Argazki> argazkiList = FXCollections.observableArrayList();
        argazkiList.addAll(bildumaMap.get("abereak"));
       // argazkiList.addAll(bildumaMap.get("landareak"));
       // argazkiList.addAll(bildumaMap.get("frutak"));

        comboBilduma.setOnAction(e -> {

            if( comboBilduma.getValue()=="abereak"){
                argazkiList.removeAll(bildumaMap.get("abereak"));
                argazkiList.removeAll(bildumaMap.get("frutak"));
                argazkiList.removeAll(bildumaMap.get("landareak"));
                argazkiList.addAll(bildumaMap.get("abereak"));

            }else if(comboBilduma.getValue()=="landareak"){
                argazkiList.removeAll(bildumaMap.get("abereak"));
                argazkiList.removeAll(bildumaMap.get("frutak"));
                argazkiList.addAll(bildumaMap.get("landareak"));

            }else{
                argazkiList.removeAll(bildumaMap.get("abereak"));
                argazkiList.removeAll(bildumaMap.get("landareak"));
                argazkiList.addAll(bildumaMap.get("frutak"));

            }
        });


        ListView<Argazki> listViewOfArgazki = new ListView<>(argazkiList);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(comboBilduma,listViewOfArgazki);
        //vbox.setAlignment(Pos.BOTTOM_LEFT);
        //  vbox.setPadding(new Insets(10,0,0,0));
        Scene scene = new Scene(vBox, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
        listViewOfArgazki.getSelectionModel().selectedItemProperty().addListener(  (observable, oldValue, newValue) -> {
            if (observable.getValue() == null) return;

            String fitx = observable.getValue().getFitx();

            try {
                int i=-1;
                ImageView imageView = new ImageView();
                imageView.setImage(lortuIrudia(fitx));
                if(i==-1) {
                    vBox.getChildren().add(imageView);
                }else{
                    vBox.getChildren().add(i,imageView);
                }
                i=vBox.getChildren().indexOf(imageView);
               /* VBox v=new VBox(imageView);
                v.setAlignment(Pos.BOTTOM_LEFT);
                Scene scene1 = new Scene(v, 200, 120);
                primaryStage.setScene(scene1);
                primaryStage.show();*/

            } catch (IOException e) {
                e.printStackTrace();
            }

        });




    }

    private Image lortuIrudia(String location) throws IOException {

        InputStream is = getClass().getResourceAsStream("/" + location);
        BufferedImage reader = ImageIO.read(is);
        return SwingFXUtils.toFXImage(reader, null);

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
