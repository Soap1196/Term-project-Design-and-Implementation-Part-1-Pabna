import javafx.fxml.Initializable;
import java.net.URL;
import java.nio.file.Path;
import java.util.ResourceBundle;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import java.util.Random;
import javafx.scene.control.ChoiceBox;
import java.math.*;
import javafx.collections.FXCollections;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.PathTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.animation.PathTransition; 
import javafx.scene.Group; 
import javafx.scene.Scene; 
import javafx.scene.paint.Color; 

import javafx.scene.shape.Circle; 
import javafx.scene.shape.CubicCurveTo; 
import javafx.scene.shape.MoveTo; 

public class Control implements Initializable{

    public Image drone;


    // our control is the same as their main

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        
	}

    public void start (Stage stage) { 
    //Instantiating the path class  
      Path path = new Path(); 
      
      //Creating the MoveTo path element 
      MoveTo moveTo = new MoveTo(100, 150); 
      
      //Creating the Cubic curve path element 
      CubicCurveTo cubicCurveTo = new CubicCurveTo(400, 40, 175, 250, 500, 150); 
      
      //Adding the path elements to Observable list of the Path class 
      path.getElements().add(moveTo); 
      path.getElements().add(cubicCurveTo);        
      
      //Creating a path transition 
      PathTransition pathTransition = new PathTransition(); 
      
      //Setting the duration of the path transition 
      pathTransition.setDuration(Duration.millis(1000));

      //Setting the node for the transition 
      pathTransition.setNode(drone); 
      
      //Setting the path 
      pathTransition.setPath(path);  
      
      //Setting the orientation of the path 
      pathTransition.setOrientation(PathTransition.OrientationType.
      ORTHOGONAL_TO_TANGENT); 
      
      //Setting the cycle count for the transition 
      pathTransition.setCycleCount(50); 
      
      //Setting auto reverse value to false 
      pathTransition.setAutoReverse(false); 
    
      //Playing the animation 
      pathTransition.play(); 
         
      //Creating a Group object  
      Group root = new Group(drone); 
         
      //Creating a scene object 
      Scene scene = new Scene(root, 600, 300);   
      
      //Setting title to the Stage 
      stage.setTitle("Path transition for Drone"); 
         
      //Adding scene to the stage 
      stage.setScene(scene); 
         
      //Displaying the contents of the stage 
      stage.show(); 
    }














    // option 1:
    // @Override
    // public void startAnimation (Stage stage) throws Exception{
    //     StackPane root = new StackPane();
    //     Circle circle = new Circle(0,0,30, Color.BLUE);
    //     root.getChildren().add(circle);
    //     KeyValue start = new KeyValue (circle.radiusProperty(), 10);
    //     KeyValue end = new KeyValue ( circle.radiusProperty(), root.getHeight()/2.0);
    //     KeyFrame frame = new KeyFrame ( Duration.seconds (10) , start, end);
    //     Timeline timeline = new Timeline (frame);
    //     timeline.play();
    //     stage.setScene (new Scene ( root, 800, 600));
    //     stage.show()
    // }

    // option 2
    // final Rectangle rectPath = new Rectangle (0, 0, 40, 40);
    // rectPath.setArcHeight(10);
    // rectPath.setArcWidth(10);
    // rectPath.setFill(Color.ORANGE);
    // Path path = new Path();
    // path.getElements().add(new MoveTo(20,20));
    // path.getElements().add(new CubicCurveTo(380, 0, 380, 120, 200, 120));
    // path.getElements().add(new CubicCurveTo(0, 120, 0, 240, 380, 240));
    // PathTransition pathTransition = new PathTransition();
    // pathTransition.setDuration(Duration.millis(4000));
    // pathTransition.setPath(path);
    // pathTransition.setNode(rectPath);
    // pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
    // pathTransition.setCycleCount(Timeline.INDEFINITE);
    // pathTransition.setAutoReverse(true);
    // pathTransition.play();

}