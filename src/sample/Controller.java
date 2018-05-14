package sample;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Controller implements Initializable {

    @FXML
    private ImageView usuallyView;
    @FXML
    private ImageView clickView;
    @FXML
    private Label speakText;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    /**
     * 閉じるボタン
     */
    @FXML
    private void close(ActionEvent event) {

        Platform.exit(); // 終了
    }

    /**
     * 会話ボタン
     */
    @FXML
    private void speak(ActionEvent event) throws Exception {

        Task<Boolean> task   = new Task<Boolean>()
        {
            @Override
            protected Boolean call() throws Exception
            {
                // 5秒待つ
                Thread.sleep( 5000 );

                // ラベルの値を変更する
                // Platform.runLater関数により、
                // 変更はJavaFXアプリケーションスレッド上で処理される
                Platform.runLater( () -> speakText.setText( "" ) );
                clickView.setVisible(false);
                usuallyView.setVisible(true);

                return true;
            }
        };

// タスクを実行1
        Thread t = new Thread( task );
        t.setDaemon( true );
        t.start();
        clickView.setVisible(true);
        usuallyView.setVisible(false);
        SoundVoice sound = new SoundVoice();
        sound.soundVoice(new File("C:\\Windows\\Media\\Alarm01.wav"));
        speakText.setText("がんばります！！");
    }

}
