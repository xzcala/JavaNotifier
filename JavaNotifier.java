/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafnotifier;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Jon
 */
public class JavaNotifier extends Application {
    
    public String message;
    
    @Override
    public void start(Stage primaryStage) {
        
        primaryStage.setTitle("Notifier");
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER); 
        root.setHgap(10); 
        root.setVgap(10); 
 
        //
        
        TextField textField = new TextField();
        textField.setEditable(false);
        textField.setPrefWidth(350);
        root.add(textField,0,0); 
        
        Button notify = new Button();
        notify.setText("Notify");
        notify.setMaxWidth(Double.MAX_VALUE);
        
        Button clear = new Button();
        clear.setText("Clear");
        clear.setMaxWidth(Double.MAX_VALUE);
        
        Button print = new Button();
        print.setText("Print");
        print.setMaxWidth(Double.MAX_VALUE);
        
        Button alert = new Button();
        alert.setText("Alert");
        alert.setMaxWidth(Double.MAX_VALUE);
        
        //
        
        notify.setOnAction((ActionEvent event)->{
            textField.setText(invokeMe("jcbrzf"));
        });
        
        clear.setOnAction((ActionEvent event)->{
            textField.clear();
        });
        
        print.setOnAction((ActionEvent event)->{
            message = textField.getText();
            System.out.println(message);
        });
        
        alert.setOnAction((ActionEvent event)->{
            Alert box = new Alert(AlertType.INFORMATION);
            box.setTitle("Alert");
            box.setHeaderText(textField.getText());
            box.showAndWait();
        });
        
        //
        
        VBox buttons = new VBox();
        buttons.setAlignment(Pos.BOTTOM_CENTER);
        buttons.setSpacing(10);
        buttons.setPadding(new Insets(0,0,10,0));
        buttons.getChildren().addAll(notify,clear,print,alert);
        
        root.add(buttons,0,1);
       
        Scene scene = new Scene(root, 420, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public static String invokeMe(String string){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date=new Date();
        return("You have been notified by " + "\"" + string + "\"" + " on " + date);
    }
}
