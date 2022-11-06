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
import java.util.ArrayList;
import java.util.List;
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

class Srectangle extends Rectangle{
    private String name; // private = restricted access

  // Getter
  public String getName() {
    return name;
  }

  // Setter
  public void setName(String newName) {
    this.name = newName;

    }
}

//Custom classes for item and containers
interface items{
    
    public void showItemDetails();
}

class component implements items{
    public static component component; 

    private List<leaf> itemslist = new ArrayList<leaf>();
    
    public String name;
    public long price;
    public long xCoordinate;
    public long yCoordinate;
    public long length;
    public long width;
    public long height;

    // Getters
    // Setters

    public static component getInstance() 
    { 
        return component;
    } 

    public component() 
    { 
         
    }

    // Getters
    public String getCompName() {
        return name;
    }
    public long getCompPrice() {
        return price;
    }
    public long getCompXcoordinate() {
        return xCoordinate;
    }
    public long getCompYcoordinate() {
        return yCoordinate;
    }
    public long getCompLength() {
        return length;
    }
    public long getCompWidth() {
        return width;
    }
    public long getCompHeight() {
        return height;
    }

    // Setters
    public void setCompName(String name) {
        this.name = name;
    }
    public void setCompPrice(long price) {
        this.price = price;
    }
    public void setCompXcoordinate(long xCoordinate) {
        this.xCoordinate = xCoordinate;
    }
    public void setCompYcoordinate(long yCoordinate) {
        this.yCoordinate = yCoordinate;
    }
    public void setCompLength(long length) {
        this.length = length;
    }
    public void setCompWidth(long width) {
        this.width = width;
    }
    public void setCompHeight(long height) {
        this.height = height;
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
        return leaf;
    } 

    public leaf(){

    }

    public String getName()
    {
        return name;
    }

    public void setName(String newName)
    {
        this.name = newName;
    }

    public long getPrice()
    {
        return price;
    }

    public void setPrice(long newPrice)
    {
        this.price = newPrice;
    }

    public long getXCoordinate()
    {
        return xCoordinate;
    }

    public void setXCoordinate(long newXCoordinate)
    {
        this.xCoordinate = newXCoordinate;
    }

    public long getYCoordinate()
    {
        return yCoordinate;
    }

    public void setYCoordinate(long newYCoordinate)
    {
        this.yCoordinate = newYCoordinate;
    }

    public long getLength()
    {
        return length;
    }

    public void setLength(long newLength)
    {
        this.length = newLength;
    }

    public long getWidth()
    {
        return width;
    }

    public void setWidth(long newWidth)
    {
        this.width = newWidth;
    }

    public long getHeight()
    {
        return height;
    }

    public void setHeight(long newHeight)
    {
        this.height = newHeight;
    }

    @Override
    public void showItemDetails()
    {
        System.out.println("Placeholder for leaf");
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
        @FXML private Button addItemContainer;
        @FXML private Button addItem;
        @FXML private Button Delete;
        @FXML private Button ChangeName;
        @FXML private Button ChangePrices;
        @FXML private Button ChangeLocation;
        @FXML private Button ChangeLength;
        @FXML private Button ChangeWidth;
        @FXML private Button ChangeHeight;
        @FXML private Button Rename;
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
                path.getElements().add(new UpdatedLineTo(Corgicopter, 200, 200));
                path.getElements().add(new UpdatedLineTo(Corgicopter, 100, 100));
                pathTransition.setCycleCount(1);
                pathTransition.setAutoReverse(false);
                pathTransition.play();
    }
    public void CreateItemContainer() {
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
                //Create component object
                component comp1 = new component();


                //Drawing a Rectangle 
                Srectangle rectangle = new Srectangle();  
      
                //Setting the properties of the rectangle 
                rectangle.setName(textFieldName.getText());
                rectangle.setX(Integer.parseInt(textFieldX.getText())); 
                rectangle.setY(Integer.parseInt(textFieldY.getText())); 
                rectangle.setWidth(Integer.parseInt(textFieldW.getText())); 
                rectangle.setHeight(Integer.parseInt(textFieldH.getText()));
                farm.getChildren().add(rectangle);
                TreeItem<String> Container = new TreeItem<>(textFieldName.getText());
                root.getChildren().add(Container);
                System.out.println(rectangle.getName());
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

    public void CreateItemContainer2() {
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
                //Create leaf object
                //component comp1 = new component();
                leaf leaf1 = new leaf();
                
                
                //Drawing a Rectangle 
                Srectangle rectangle = new Srectangle();  
      
                //Setting the properties of the rectangle 
                rectangle.setName(textFieldName.getText());
                rectangle.setX(Integer.parseInt(textFieldX.getText())); 
                rectangle.setY(Integer.parseInt(textFieldY.getText())); 
                rectangle.setWidth(Integer.parseInt(textFieldW.getText())); 
                rectangle.setHeight(Integer.parseInt(textFieldH.getText()));
                farm.getChildren().add(rectangle);
                TreeItem<String> Container = new TreeItem<>(textFieldName.getText());
                root.getChildren().add(Container);

                //Leaf Setup
                leaf1.setName(textFieldName.getText());
                leaf1.setXCoordinate(Long.parseLong(textFieldX.getText()));
                leaf1.setYCoordinate(Long.parseLong(textFieldY.getText()));
                leaf1.setWidth(Long.parseLong(textFieldW.getText()));
                leaf1.setHeight(Long.parseLong(textFieldH.getText()));
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

    public void treeClick (MouseEvent event) {
        if (event.getClickCount()==2){
        TreeItem<String> item = locationTreeView.getSelectionModel().getSelectedItem();
        System.out.println(item.getValue());
        }
    }
}