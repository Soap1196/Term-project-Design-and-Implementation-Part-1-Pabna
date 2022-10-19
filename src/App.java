
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
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
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

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

interface items {
    public void showItemDetails();
}

class component implements items {
    public String[] obj = new String[30];
    public String name;
    public long price;
    public long xCoordinate;
    public long yCoordinate;
    public long length;
    public long width;
    public long height;

    @Override
    public void showItemDetails()
    {
        System.out.println("Placeholder for component");
    }

}

class Leaf implements items{
    public String name;
    public long price;
    public long xCoordinate;
    public long yCoordinate;
    public long length;
    public long width;
    public long height;

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
        // Create the VBox
		VBox root = new VBox();
		// Set Spacing to 10 pixels
		root.setSpacing(10);
		// Set the Size of the VBox
		root.setPrefSize(800, 600);
		// Set the Style-properties of the VBox
		root.setStyle("-fx-padding: 10;" +
				"-fx-border-style: solid inside;" +
				"-fx-border-width: 2;" +
				"-fx-border-insets: 5;" +
				"-fx-border-radius: 5;" +
				"-fx-border-color: transparent;");

		// Create the Scene
		Scene scene = new Scene(root);
		// Add the Scene to the Stage
		IL.setScene(scene);
		// Set the Title of the Stage
		IL.setTitle("A JavaFX Animation Example With Button");
		// Display the Stage
		IL.show();
        
    }

    
    
}