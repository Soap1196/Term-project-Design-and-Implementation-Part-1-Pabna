package com.farm.farmdashboard;

import javax.naming.ldap.Control;
import javax.swing.ComboBoxModel;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
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
<<<<<<< HEAD:src/App.java
import javafx.scene.layout.Pane;


=======
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import java.util.ArrayList;
>>>>>>> calebBranch:src/com/farm/farmdashboard/App.java

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


<<<<<<< HEAD:src/App.java
//Custom classes for item and containers
interface items{
=======

interface Items{
>>>>>>> calebBranch:src/com/farm/farmdashboard/App.java
    public void showItemDetails();
}

class component implements Items{
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

class leaf implements Items{
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

public class App extends Application
{
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

    // change layout to current position, reset translate
    public void setPositionFixed( Node node) {
        double x = node.getLayoutX() + node.getTranslateX();
        double y = node.getLayoutY() + node.getTranslateY();
        node.relocate(x, y);
        node.setTranslateX(0);
        node.setTranslateY(0);
    }

    int itemNumber = 0;
    public static void main(String[] args)
        {
            Application.launch(args);
        }

    @Override
	public void start(Stage stage) throws InterruptedException
	{

        itemList IL;
        IL= itemList.getInstance();

        //buttons
        Button addItemContainer = new Button("addItemContainer");
        Button addItem = new Button("addItem");
        Button deleteItem = new Button("deleteItem");
        Button ChangeName = new Button("ChangeName");
        Button ChangePrice = new Button("ChangePrice");
        Button ChangeLocationY = new Button("ChangeLocationY");
        Button ChangeLocationX = new Button("ChangeLocationX");
        Button ChangeLength = new Button("ChangeLength");
        Button ChangeWidth = new Button("ChangeWidth");
        Button ChangeHeight = new Button("ChangeHeight");

        Button MoveDrone = new Button("MoveDrone");

        TreeView<String> tree = new TreeView<String>();
        TreeItem<String> rootItem = new TreeItem<String>("Root");
        rootItem.setExpanded(true);
        tree.setRoot(rootItem);
        tree.setStyle(
            //set width of tree
            "-fx-min-width: 200px; "
        );

<<<<<<< HEAD:src/App.java
        
        //drone
		ImageView drone = new ImageView(new Image("Subject.png", 100, 80, false, false));
=======
		ImageView drone = new ImageView(new Image("https://media.discordapp.net/attachments/942443536765309028/1033177962243178616/Subject.png", 100, 89, false, false));
>>>>>>> calebBranch:src/com/farm/farmdashboard/App.java

        //textbox
        Label Tname = new Label("Data:");
        TextField textField = new TextField ();
        HBox hb = new HBox();
        hb.getChildren().addAll(Tname, textField);
        hb.setSpacing(10);

<<<<<<< HEAD:src/App.java
        //intial box for all activity
		VBox root = new VBox(drone, ItemComponent, addItemContainer,addItem,deleteItem,ChangeName,ChangePrice,
=======
		VBox root = new VBox(drone, tree, addItemContainer,addItem,deleteItem,ChangeName,ChangePrice,
>>>>>>> calebBranch:src/com/farm/farmdashboard/App.java
        ChangeLocationY,ChangeLocationX,ChangeLength,ChangeWidth,ChangeHeight,hb,MoveDrone);
		root.setSpacing(10);
		root.setPrefSize(1000, 800);
		root.setStyle("-fx-padding: 1;" +
				"-fx-border-style: solid inside;" +
				"-fx-border-width: 2;" +
				"-fx-border-insets: 5;" +
				"-fx-border-radius: 5;" +
				"-fx-border-color: transparent;"
                );
        

<<<<<<< HEAD:src/App.java
        //action functions for buttons
=======
        
>>>>>>> calebBranch:src/com/farm/farmdashboard/App.java
        addItemContainer.setOnAction(new EventHandler <ActionEvent>()
        {
            public void handle(ActionEvent event)
            {
                //create new component and add to tree
            }
        });
        
        addItem.setOnAction(new EventHandler <ActionEvent>()
        {
            public void handle(ActionEvent event)
            {
                //Create new item and add to tree
            }
        });

        MoveDrone.setOnAction(new EventHandler <ActionEvent>()
        {
            public void handle(ActionEvent event)
            {
                Path path = new Path();
                PathTransition pathTransition = new PathTransition();
                pathTransition.setDuration(Duration.millis(1000));
                pathTransition.setNode(drone);
                pathTransition.setPath(path);
                path.getElements().add(new UpdatedMoveTo(drone));
                path.getElements().add(new UpdatedLineTo(drone, 300, 300));
                pathTransition.setCycleCount(1);
                pathTransition.setAutoReverse(false);
                pathTransition.play();
            }
        });

		Scene scene = new Scene(root);
		IL.setScene(scene);
		IL.setTitle("Group Pabna");
		IL.show();

		double sceneWidth = scene.getWidth();
		double sceneHeight = scene.getHeight();
		double droneWidth = drone.getLayoutBounds().getWidth();

        //Drone flight instructions
        Path path = new Path();
        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.millis(1000));
        pathTransition.setNode(drone);
        pathTransition.setPath(path);
        path.getElements().add(new UpdatedMoveTo(drone));
        path.getElements().add(new UpdatedLineTo(drone, 100, 100));
        pathTransition.setCycleCount(1);
        pathTransition.setAutoReverse(false);
        pathTransition.play();
        

        


        
    }

    
    
}