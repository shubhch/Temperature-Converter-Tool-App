package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class MyMain extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void init() throws Exception {
        System.out.println("init");
        super.init();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println("start");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("app_layout.fxml"));
        VBox rootNode = loader.load();
        MenuBar menuBar = createMenu();
        rootNode.getChildren().add(0, menuBar);
        Scene scene = new Scene(rootNode);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Temperature Converter Tool ");
        primaryStage.show();

    }

    private MenuBar createMenu() {
        Menu fileMenu = new Menu("File");
        SeparatorMenuItem smi = new SeparatorMenuItem();
        MenuItem quitMenuItem = new MenuItem("quit");
        quitMenuItem.setOnAction(event -> {

            Platform.exit();
            System.exit(0);
        });
        fileMenu.getItems().addAll(quitMenuItem);

        Menu helpMenu = new Menu("Help");
        MenuItem aboutApp = new MenuItem("About");

        aboutApp.setOnAction(event -> aboutApp());

        helpMenu.getItems().addAll(aboutApp);
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu, helpMenu);
        return menuBar;

    }

    private void aboutApp() {
        Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);
        alertDialog.setTitle(" About ");
        alertDialog.setHeaderText("About App");
        alertDialog.setContentText(" This App Helps You To Convert Temperature From Degree To Farhenhiet And Fahrenheit To Degree.\n" +  "Developer Name : SHUBHAM CAHURASIYA");

        alertDialog.show();

    }
}

