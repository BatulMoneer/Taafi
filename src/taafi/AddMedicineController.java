/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taafi;

import java.awt.Color;
import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author albat
 */
public class AddMedicineController implements Initializable {
    
    @FXML
    private Button AccButt;

    @FXML
    private Button ChatButt;

    @FXML
    private Button HomeButt;

    @FXML
    private Button SearchButt;
    
    @FXML
    private Circle cir;
    
    @FXML
    private Rectangle[] rec = new Rectangle[100];
    
    @FXML 
    private VBox Box;
    
    @FXML
    private ScrollPane scrollPane = new ScrollPane();
    
    static int i = 0;

    @FXML
    void HoverOnAcc(MouseEvent event) {
        AccButt.setStyle("-fx-background-color: rgb(84, 170, 201);");
    }

    @FXML
    void HoverOnChat(MouseEvent event) {
        ChatButt.setStyle("-fx-background-color: rgb(84, 170, 201);");
    }

    @FXML
    void HoverOnHome(MouseEvent event) {
        HomeButt.setStyle("-fx-background-color: rgb(84, 170, 201);");
    }

    @FXML
    void HoverOnSearch(MouseEvent event) {
        SearchButt.setStyle("-fx-background-color: rgb(84, 170, 201);");
    }

    @FXML
    void HoverOutAcc(MouseEvent event) {
        AccButt.setStyle("-fx-background-color: rgb(255, 255, 255);");
    }

    @FXML
    void HoverOutChat(MouseEvent event) {
        ChatButt.setStyle("-fx-background-color: rgb(255, 255, 255);");
    }

    @FXML
    void HoverOutHome(MouseEvent event) {
        HomeButt.setStyle("-fx-background-color: rgb(255, 255, 255);");
    }

    @FXML
    void HoverOutSearch(MouseEvent event) {
        SearchButt.setStyle("-fx-background-color: rgb(255, 255, 255);");
    }
    
    @FXML
    void AddNewMedicine(MouseEvent event){
        AddMedicine();
    }
    
    
    void AddMedicine(){
        
        rec[i] = new Rectangle();
        rec[i].setFill(Paint.valueOf("rgb(255, 255, 255)"));
        rec[i].setHeight(90);
        rec[i].setWidth(280);
        rec[i].setArcWidth(20); // Set the horizontal corner radius
        rec[i].setArcHeight(20);
        Box.setPadding(new Insets(10,10,10,10));
        Box.setSpacing(10);
        Text text1 = new Text("Hey");
        Text text2 = new Text("Hey");
        Text text3 = new Text("Hey");
        VBox box0 = new VBox();
        box0.setAlignment(Pos.CENTER);
        box0.getChildren().addAll(text1, text2, text3);
        HBox box1 = new HBox();
        box1.setAlignment(Pos.CENTER_LEFT);
        box1.setPadding(new Insets(0,0,0,20));
        box1.setSpacing(20);
        Image im = new Image("https://i.pinimg.com/564x/e8/f4/cc/e8f4ccaea8fa524d08c45d80a8ba676b.jpg");
        ImageView imv = new ImageView(im);
        imv.setFitHeight(60);
        imv.setFitWidth(60);
        box1.getChildren().addAll(imv, box0);
        
        StackPane pane = new StackPane();
        //pane.setPadding(new Insets(20,20,20,20));
        pane.setAlignment(Pos.CENTER);
        pane.getChildren().addAll(rec[i], box1);
        Box.getChildren().addAll(pane);
        i++;
        
      
    }
    
    @FXML
    void HoverOnCir(MouseEvent event) {
        cir.setFill(Paint.valueOf("rgb(140, 170, 138)"));
    }

    @FXML
    void HoverOutCir(MouseEvent event) {
        cir.setFill(Paint.valueOf("rgb(52, 121, 185)"));
    }
    
    @FXML
    void Scroll(MouseEvent event) {
        scrollPane.setContent(Box);
         Box.setOnScroll(eve -> {
            double deltaY = eve.getDeltaY();
            double height = Box.getBoundsInLocal().getHeight();
            double vvalue = scrollPane.getVvalue();

            // Adjust the scrolling speed by changing the divisor (e.g., 1500)
            double scrollFactor = deltaY / height / 1500.0;

            // Update the vertical scroll position of the ScrollPane
            scrollPane.setVvalue(vvalue - scrollFactor);

            // Consume the event to prevent other scroll actions
            event.consume();
        });
    }
     @FXML
    void onScroll(ScrollEvent event) {
        // Handle the scroll event here
        double deltaY = event.getDeltaY();
        // Perform actions based on the scroll direction or amount
        if (deltaY > 0) {
            // Scrolling up
            System.out.println("Scrolling Up");
        } else {
            // Scrolling down
            System.out.println("Scrolling Down");
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        scrollPane.setFitToWidth(true);
    }
    
    

// ...

// Add a listener to the ScrollPane's vvalue property for smooth scrolling

}

