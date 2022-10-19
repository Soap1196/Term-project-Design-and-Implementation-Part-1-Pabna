
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




class itemList extends Stage{ 
        
    public static itemList itemObject; 
  
    
    public String s; 
  
    
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
    public static void main(String[] args)
        {
            Application.launch(args);
        }

    @Override
	public void start(Stage stage) throws InterruptedException
	{
        itemList IL;
        IL= itemList.getInstance();

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


        component ItemContainer = component.getInstance();
        ItemContainer.name = "root";
        System.out.println(ItemContainer.name);
        SplitMenuButton ItemComponent= new SplitMenuButton();
        ItemComponent.setText(ItemContainer.name);

        

		ImageView drone = new ImageView(new Image("Subject.png", 100, 80, false, false));

		VBox root = new VBox(drone, ItemComponent, addItemContainer,addItem,deleteItem,ChangeName,ChangePrice,ChangeLocationY,ChangeLocationX,ChangeLength,ChangeWidth,ChangeHeight);
		root.setSpacing(10);
		root.setPrefSize(800, 600);
		root.setStyle("-fx-padding: 10;" +
				"-fx-border-style: solid inside;" +
				"-fx-border-width: 2;" +
				"-fx-border-insets: 5;" +
				"-fx-border-radius: 5;" +
				"-fx-border-color: transparent;");


		Scene scene = new Scene(root);
		IL.setScene(scene);
		IL.setTitle("Group Pabna");
  
      Path path = new Path(); 
       
      MoveTo moveTo = new MoveTo(100, 150); 
       
      CubicCurveTo cubicCurveTo = new CubicCurveTo(400, 40, 175, 250, 500, 150); 
       
      path.getElements().add(moveTo); 
      path.getElements().add(cubicCurveTo);        
       
      PathTransition pathTransition = new PathTransition(); 
       
      pathTransition.setDuration(Duration.millis(1000)); 
       
      pathTransition.setNode(drone); 
       
      pathTransition.setPath(path);  
      
      pathTransition.setCycleCount(1); 
      
      pathTransition.setAutoReverse(false); 

      pathTransition.play(); 

		IL.show();

		double sceneWidth = scene.getWidth();
		double sceneHeight = scene.getHeight();
		double droneWidth = drone.getLayoutBounds().getWidth();
        

        


        
    }

    
    
}