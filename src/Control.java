import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
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
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.collections.*;
import javafx.stage.Stage;
import javafx.scene.text.Text.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;

class itemList extends Stage{ 
        
    public static itemList itemObject; 
  
    
    public String s; 
  
    //Singleton
    private itemList() 
    { 
         
    } 

    public static itemList getInstance() 
    { 
        if (itemObject == null) {
            itemObject = new itemList(); 
        }
        return itemObject;
    } 
} 

//Custom classes for item and containers
interface items{
    public void showItemDetails();
}



class component implements items{
    public static component component; 

    public String[] obj = new String[30];
    public String name;
    public long price;
    public long xCoordinate;
    public long yCoordinate;
    public long length;
    public long width;
    public long height;

    public static component getInstance() 
    { 
        if (component == null) {
            component = new component(); 
        }
        return component;

    } 

    private component() 
    { 
         
    }
    
    public void showItemDetails()
    {
        System.out.println("Placeholder for component");
    }

}
    

class leaf implements items{
    public static leaf leaf;
    public String name;
    public long price;
    public long xCoordinate;
    public long yCoordinate;
    public long length;
    public long width;
    public long height;

    public static leaf getInstance() 
    { 
        if (leaf == null) {
            leaf = new leaf(); 
        }
        return leaf;

    } 

    @Override
    public void showItemDetails()
    {
        System.out.println("Placeholder fo component");
    }
}


public class Control implements Initializable{

        public static class UpdatedMoveTo extends MoveTo {
            public UpdatedMoveTo(Node drone) {
                super((drone.getLayoutBounds().getWidth() / 2), drone.getLayoutBounds().getHeight() / 2);
            }
            public UpdatedMoveTo(Node drone, double xAxis, double yAxis) {
                super((drone.getLayoutBounds().getWidth() / 2) + xAxis - drone.getLayoutX(),(drone.getLayoutBounds().getHeight() / 2) + yAxis - drone.getLayoutY());
            }
        }
        public static class UpdatedLineTo extends LineTo {
            public UpdatedLineTo(Node drone, double xAxis, double yAxis) {
                super((drone.getLayoutBounds().getWidth() / 2) + xAxis - drone.getLayoutX(),(drone.getLayoutBounds().getHeight() / 2) + yAxis - drone.getLayoutY());
            }
        }
        @FXML private TreeView<String> locationTreeView;
        //buttons
        Button addItemContainer;
        Button addItem;
        Button Delete;
        Button ChangeName;
        Button ChangePrices;
        Button ChangeLocation;
        Button ChangeLength;
        Button ChangeWidth;
        Button ChangeHeight;
        Button Rename;
        @FXML private Button createItemContainer;
        @FXML private ImageView Corgicopter;
        @FXML private Pane farm;

        
        TreeItem<String> root = new TreeItem<String>("Root Node");
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        root.setExpanded(true);
        locationTreeView.setRoot(root);
    }
    public void droneVisit() {
                Path path = new Path();
                PathTransition pathTransition = new PathTransition();
                pathTransition.setDuration(Duration.millis(1000));
                pathTransition.setNode(Corgicopter);
                pathTransition.setPath(path);
                path.getElements().add(new UpdatedMoveTo(Corgicopter));
                path.getElements().add(new UpdatedLineTo(Corgicopter, 100, 100));
                pathTransition.setCycleCount(1);
                pathTransition.setAutoReverse(false);
                pathTransition.play();
    }
    public void CIC() {
        Stage stage = new Stage();
        
        stage.setTitle("Item Container Creation");
        TextField textFieldName = new TextField ("Name variable");
        TextField textFieldW = new TextField ("Width variable");
        TextField textFieldH = new TextField ("Height variable");
        TextField textFieldX = new TextField ("X variable");
        TextField textFieldY = new TextField ("Y variable");
        Button Submit = new Button("Submit");
        Submit.setOnAction(new EventHandler <ActionEvent>()
        {
            public void handle(ActionEvent event)
            {
                //Drawing a Rectangle 
                Rectangle rectangle = new Rectangle();  
      
                //Setting the properties of the rectangle 
                rectangle.setX(Integer.parseInt(textFieldX.getText())); 
                rectangle.setY(Integer.parseInt(textFieldY.getText())); 
                rectangle.setWidth(Integer.parseInt(textFieldW.getText())); 
                rectangle.setHeight(Integer.parseInt(textFieldX.getText()));
                farm.getChildren().add(rectangle);
                TreeItem<String> Container = new TreeItem<>(textFieldName.getText());
                root.getChildren().add(Container);
            }
        });
  
        // create a tilepane
        Pane Pane = new VBox(textFieldName,textFieldW,textFieldH,textFieldX,textFieldY,Submit);
  
        // create a scene
        Scene sc = new Scene(Pane, 200, 200);
  
        // set the scene
        stage.setScene(sc);
  
        stage.show();
    }
}