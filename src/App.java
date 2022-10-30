import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;


public class App extends Application {

    @Override
    public void start(Stage scene) throws Exception {
        Parent Parent = FXMLLoader.load(getClass().getResource("App.fxml"));
        Scene App = new Scene(Parent);
        scene.setScene(App);
        scene.show();
    }
    public static void main(String[] arg1) {
        launch(arg1);
    }
}