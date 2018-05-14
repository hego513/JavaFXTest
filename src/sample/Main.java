package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    private double dragStartX;
    private double dragStartY;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("sample.fxml")));
        primaryStage.setTitle("Yukky Desktop");
        primaryStage.initStyle(StageStyle.TRANSPARENT);

//        primaryStage.getScene().getRoot().setStyle("-fx-background-color: transparent");
        scene.setFill(null);
        primaryStage.setScene(scene);
        primaryStage.show();
        // マウスのドラッグ操作でウィンドウを移動
        scene.setOnMousePressed(e -> {
            dragStartX = e.getSceneX();
            dragStartY = e.getSceneY();
        });
        scene.setOnMouseDragged(e -> {
            primaryStage.setX(e.getScreenX() - dragStartX);
            primaryStage.setY(e.getScreenY() - dragStartY);
        });

        System.out.print("test");

    }


    public static void main(String[] args) {
        launch(args);
    }
}
