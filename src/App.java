
import javax.naming.ldap.Control;
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

    TreeView<String> tree = new TreeView<String>();
    ImageView drone = new ImageView(new Image("Subject.png", 100, 80, false, false));

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

        component ItemContainer = component.getInstance();
        ItemContainer.name = "root";
        System.out.println(ItemContainer.name);
        MenuButton ItemComponent= new MenuButton();
        ItemComponent.setText(ItemContainer.name);
        TreeItem<String> rootItem = new TreeItem<String>("Root");
        rootItem.setExpanded(true);
        tree.setRoot(rootItem);
        
        tree.setStyle(
            //set width of tree
            "-fx-min-width: 50px; "
        );

        
        
        //drone
		

        //textbox
        Label Tname = new Label("Data:");
        TextField textField = new TextField ();
        HBox hb = new HBox();
        hb.getChildren().addAll(Tname, textField);
        hb.setSpacing(10);

        //intial box for all activity
		VBox root = new VBox(tree, drone, ItemComponent, addItemContainer,addItem,deleteItem,ChangeName,ChangePrice,
        ChangeLocationY,ChangeLocationX,ChangeLength,ChangeWidth,ChangeHeight,hb,MoveDrone);
		root.setSpacing(10);
		root.setPrefSize(1000, 800);
		root.setStyle("-fx-padding: 1;" +
				"-fx-border-style: solid inside;" +
				"-fx-border-width: 2;" +
				"-fx-border-insets: 5;" +
				"-fx-border-radius: 5;" +
				"-fx-border-color: transparent;");

        
        
        
          

        //action functions for buttons
        addItemContainer.setOnAction(new EventHandler <ActionEvent>()
        {
            public void handle(ActionEvent event)
            {
                TreeItem MI1 = new TreeItem(textField.getText());
                rootItem.getChildren().add(MI1);
                //add event handler here
                
                
            }
        });
        
        addItem.setOnAction(new EventHandler <ActionEvent>()
        {
            public void handle(ActionEvent event)
            {
                TreeItem MI2 = new TreeItem(textField.getText());
                
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

    }

    public void MouseClick(TreeItem treeitem){
        TreeItem<String> item = tree.getSelectionModel().getSelectedItem();
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
    };
    
}