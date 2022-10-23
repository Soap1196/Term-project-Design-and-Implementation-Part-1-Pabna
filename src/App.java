import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;
//import javax.naming.ldap.Control;
import javax.swing.ComboBoxModel;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.animation.PathTransition; 
import javafx.scene.shape.MoveTo; 
import javafx.scene.shape.Path;
import javafx.util.Duration;  
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.MenuItem; 
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;  
import javafx.scene.shape.Rectangle;  
import javafx.scene.shape.LineTo;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import java.util.ArrayList;
import java.awt.event.MouseEvent;

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