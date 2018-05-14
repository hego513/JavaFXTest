package sample;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.control.Label;

public class SpeakButtom extends Task {
    @Override
    protected Boolean call( ) throws Exception
    {
        // 5秒待つ
        Thread.sleep( 1000 );

        // ラベルの値を変更する
        // Platform.runLater関数により、
        // 変更はJavaFXアプリケーションスレッド上で処理される
//        cont.clearText();
        updateMessage("test");
        System.out.print("test");
    return true;
    }

}
