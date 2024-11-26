package com.example.files;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        GridPane root = new GridPane();
        stage.setTitle("Formularz");
        Label lbl1 = new Label("Nazwa pliku: ");
        TextField txt1 = new TextField();
        TextArea txt2 = new TextArea();
        Label mrg1 = new Label("       ");
        Label mrg2 = new Label("       ");
        Button btn1 = new Button("odczyt");
        Button btn2 = new Button("zapis");
        btn1.setOnAction(actionEvent -> {
            String filePath = "C:\\Users\\Uczen\\Documents\\3TPg1\\files\\target\\classes\\com\\example\\files\\"+txt1.getText();
            Path path = Paths.get(filePath);
            System.out.println(path);
            try {
                List<String> lines = Files.readAllLines(path);
                String content = String.join("\n", lines);
                txt2.setText(content);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        btn2.setOnAction(actionEvent -> {
            String filePath = "C:\\Users\\Uczen\\Documents\\3TPg1\\files\\target\\classes\\com\\example\\files\\"+txt1.getText();
            Path path = Paths.get(filePath);
            System.out.println(path);
            try {
                Files.writeString(path, txt2.getText());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        txt2.setPrefColumnCount(35);
        root.add(lbl1, 0, 0);
        root.add(txt1, 1, 0);
        root.add(mrg1, 2, 0);
        root.add(btn1, 1, 1);
        root.add(mrg2, 2, 1);
        root.add(txt2, 0, 2);
        root.add(btn2, 0, 3);
        Scene scene = new Scene(root, 600, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}

