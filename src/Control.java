import javafx.fxml.Initializable;
import java.net.URL;
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
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

class itemList { 
        
    private static itemList itemObject = null; 
  
    
    public String s; 
  
    
    private itemList() 
    { 
         
    } 
  
    
    public static itemList getInstance() 
    { 
        if (itemObject == null) 
            itemObject = new itemList(); 
  
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



public class Control implements Initializable{

    itemList iL1=itemList.getInstance();

    public Image drone;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        
	}
}