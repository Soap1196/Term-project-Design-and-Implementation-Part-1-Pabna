import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import java.util.*;
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
    private double price; // private = restricted access

  // Getter
  public String getName() {
    return name;
  }

  // Setter
  public void setName(String newName) {
    this.name = newName;

    }

    // Getter
  public double getPrice() {
    return price;
  }

  // Setter
  public void setPrice(double newPrice) {
    this.price = newPrice;

    }

public void setisComposite(boolean b) {
}

public boolean getisComposite() {
    return false;
}
}

//Custom classes for item and containers
interface items{
    public void showItemDetails();
}

class component implements items{
    public static component component; 

    private List<items> itemslist = new ArrayList<items>();

    @Override
    public void showItemDetails()
    {
        for(items x:itemslist)
        {
            x.showItemDetails();
        }
    }

    public void additem(items x)
    {
        itemslist.add(x);
    }

    public void removeitems(items x)
    {
        itemslist.remove(x);
    }
    
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
        System.out.println(name);
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


        @FXML public TreeView<String> locationTreeView;
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
        public ImageView Corgicopter;
        @FXML private Pane farm;
        @FXML private Label purchasePrice;
        @FXML private Label currentMarketPrice;

        
        TreeItem<String> root = new TreeItem<String>("Root Node");
        component rootDirectory = new component();

        public String Choice1;
        public TreeItem Choice2 = root;
        public Srectangle Choice3;
        double dronestartx = 25;
        double dronestarty = 25;
        double commandCenterx;
        double commandCentery;


        ArrayList<Srectangle> rectanglelist = new ArrayList<>();
        
        

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        root.setExpanded(true);
        locationTreeView.setRoot(root);
        locationTreeView.setOnMouseClicked((event) -> {
            TreeItem<String> item = locationTreeView.getSelectionModel().getSelectedItem();
            for (int i = 0; i < rectanglelist.size(); i++){
                if (rectanglelist.get(i)!=null){
                    Srectangle temp = rectanglelist.get(i);
                    if (temp.getName().contains(item.getValue())){
                        Choice1 = item.getValue();
                        Choice2 = item;
                        Choice3 = temp;
                        System.out.println(Choice1);
                    }
                }
                
                
            }

        });
    }

    public void DroneScan(double x, double y){
        Path path = new Path();
        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.millis(1000));
        pathTransition.setNode(Corgicopter);
        pathTransition.setPath(path);
        path.getElements().add(new MoveTo(dronestartx,dronestarty)); //starts
        path.getElements().add(new LineTo(x, y)); //ends
        pathTransition.setCycleCount(1);
        pathTransition.setAutoReverse(false);
        pathTransition.play();
        dronestartx = x;
        dronestarty = y;
        Corgicopter.toFront();
    }

    public void commandCenterDrone() {
        Stage stage = new Stage();
        
        stage.setTitle("Create Command Center");
        TextField textFieldW = new TextField ("Width variable");
        TextField textFieldH = new TextField ("Height variable");
        TextField textFieldX = new TextField ("X variable");
        TextField textFieldY = new TextField ("Y variable");
        TextField textFieldP = new TextField ("Price");
        TextField textFieldM = new TextField ("Market Value");
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
                rectangle.setName("Command Center");
                rectangle.setX(Integer.parseInt(textFieldX.getText())); 
                rectangle.setY(Integer.parseInt(textFieldY.getText())); 
                rectangle.setWidth(Integer.parseInt(textFieldW.getText())); 
                rectangle.setHeight(Integer.parseInt(textFieldH.getText()));
                rectangle.setPrice(Long.parseLong(textFieldP.getText()));
                rectangle.setPrice(Long.parseLong(textFieldM.getText()));
                rectangle.setFill(Color.AQUA);
                rectangle.setStroke(Color.BLACK);
                farm.getChildren().add(rectangle);
                
                rectanglelist.add(rectangle);
                TreeItem Container = new TreeItem("Command Center");
                root.getChildren().add(Container);
                
                comp1.setCompName("Command Center");
                comp1.setCompXcoordinate(Integer.parseInt(textFieldX.getText()));
                comp1.setCompYcoordinate(Integer.parseInt(textFieldY.getText()));
                comp1.setCompLength(Integer.parseInt(textFieldW.getText()));
                comp1.setCompHeight(Integer.parseInt(textFieldH.getText()));
                comp1.setCompPrice(Long.parseLong(textFieldP.getText()));
                
                Corgicopter = new ImageView(new Image("Subject.png"));
                Corgicopter.setFitHeight(72.0);
                Corgicopter.setFitWidth(107.0);
                Corgicopter.setPickOnBounds(true);
                Corgicopter.setPreserveRatio(true);
                farm.getChildren().add(Corgicopter);
                Path path = new Path();
                PathTransition pathTransition = new PathTransition();
                pathTransition.setDuration(Duration.millis(1000));
                pathTransition.setNode(Corgicopter);
                pathTransition.setPath(path);
                path.getElements().add(new MoveTo(dronestartx,dronestarty)); //starts
                path.getElements().add(new LineTo(Integer.parseInt(textFieldX.getText()), Integer.parseInt(textFieldY.getText()))); //ends
                pathTransition.setCycleCount(1);
                pathTransition.setAutoReverse(false);
                pathTransition.play();
                dronestartx = Integer.parseInt(textFieldX.getText());
                dronestarty = Integer.parseInt(textFieldY.getText());
                commandCenterx = Integer.parseInt(textFieldX.getText());
                commandCentery = Integer.parseInt(textFieldY.getText());
                Corgicopter.toFront();
            }
        });

        // create a tilepane
        Pane Pane = new VBox(textFieldW,textFieldH,textFieldX,textFieldY,textFieldP, textFieldM, Submit);
  
        // create a scene
        Scene sc = new Scene(Pane, 200, 200);
  
        // set the scene
        stage.setScene(sc);
  
        stage.show();
    }
    
    
    public void droneVisit() {
        Path path = new Path();
        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.millis(1000));
        pathTransition.setNode(Corgicopter);
        pathTransition.setPath(path);
        path.getElements().add(new MoveTo(dronestartx,dronestarty)); //starts
        path.getElements().add(new LineTo(Choice3.getX(), Choice3.getY())); //ends
        pathTransition.setCycleCount(1);
        pathTransition.setAutoReverse(false);
        pathTransition.play();
        dronestartx = Choice3.getX();
        dronestarty = Choice3.getY();
        Corgicopter.toFront();
    }

    public void CreateItemContainer() {
        Stage stage = new Stage();
        
        stage.setTitle("Item Container Creation");
        TextField textFieldName = new TextField ("Name variable");
        TextField textFieldW = new TextField ("Width variable");
        TextField textFieldH = new TextField ("Height variable");
        TextField textFieldX = new TextField ("X variable");
        TextField textFieldY = new TextField ("Y variable");
        TextField textFieldP = new TextField ("Price");
        TextField textFieldM = new TextField ("Market Price");
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
                rectangle.setPrice(Long.parseLong(textFieldP.getText()));
                rectangle.setPrice(Long.parseLong(textFieldM.getText()));
                rectangle.setFill(Color.WHITE);
                rectangle.setStroke(Color.BLACK);
                rectangle.setisComposite(true); // Tanner
                farm.getChildren().add(rectangle);

                
                
                rectanglelist.add(rectangle);
                TreeItem Container = new TreeItem(textFieldName.getText());
                root.getChildren().add(Container);
                
                comp1.setCompName(textFieldName.getText());
                comp1.setCompXcoordinate(Integer.parseInt(textFieldX.getText()));
                comp1.setCompYcoordinate(Integer.parseInt(textFieldY.getText()));
                comp1.setCompLength(Integer.parseInt(textFieldW.getText()));
                comp1.setCompHeight(Integer.parseInt(textFieldH.getText()));
                comp1.setCompPrice(Long.parseLong(textFieldP.getText()));
                comp1.setCompPrice(Long.parseLong(textFieldM.getText()));

                /*
                 * Tanner - on click event initialize variable to walk through rectangles
                 * if composite then add value, if not add 0
                 * change price to total
                 */
                rectangle.setOnMouseClicked((eventThree) -> {
                
                Double total = 0.0;

                for(int i = 0; i<rectanglelist.size();i++){
                    if(rectanglelist.get(i).getisComposite() == true){
                        total = total + rectanglelist.get(i).getPrice();
                    }
                    if(rectanglelist.get(i).getisComposite() == false){
                        total += 0;
                    }
                }
                currentMarketPrice.setText("Current Marker Price: " + total);

                });
            }
        });

        // create a tilepane
        Pane Pane = new VBox(textFieldName,textFieldW,textFieldH,textFieldX,textFieldY,textFieldP, textFieldM, Submit);
  
        // create a scene
        Scene sc = new Scene(Pane, 200, 200);
  
        // set the scene
        stage.setScene(sc);
  
        stage.show();
    }

    public void CreateItem() {
        Stage stage = new Stage();
        
        stage.setTitle("Item Creation");
        TextField textFieldName = new TextField ("Name variable");
        TextField textFieldW = new TextField ("Width variable");
        TextField textFieldH = new TextField ("Height variable");
        TextField textFieldX = new TextField ("X variable");
        TextField textFieldY = new TextField ("Y variable");
        TextField textFieldP = new TextField ("Price");
        TextField textFieldM = new TextField ("Market Value");
        Button Submit = new Button("Submit");
        Submit.setOnAction(new EventHandler <ActionEvent>()
        {
            public void handle(ActionEvent event)
            {
                //Create leaf object
                //component comp1 = new component();
                leaf leaf1 = new leaf();
                //Leaf Setup
                leaf1.setName(textFieldName.getText());
                leaf1.setXCoordinate(Long.parseLong(textFieldX.getText()));
                leaf1.setYCoordinate(Long.parseLong(textFieldY.getText()));
                leaf1.setWidth(Long.parseLong(textFieldW.getText()));
                leaf1.setHeight(Long.parseLong(textFieldH.getText()));
                leaf1.setPrice(Long.parseLong(textFieldP.getText()));
                leaf1.setPrice(Long.parseLong(textFieldM.getText()));

                
                //Drawing a Rectangle 
                Srectangle rectangle = new Srectangle();  
      
                //Setting the properties of the rectangle 
                rectangle.setName(textFieldName.getText());
                rectangle.setX(Integer.parseInt(textFieldX.getText())); 
                rectangle.setY(Integer.parseInt(textFieldY.getText())); 
                rectangle.setWidth(Integer.parseInt(textFieldW.getText())); 
                rectangle.setHeight(Integer.parseInt(textFieldH.getText()));
                rectangle.setPrice(Long.parseLong(textFieldP.getText()));
                rectangle.setPrice(Long.parseLong(textFieldM.getText()));
                rectangle.setisComposite(false); // Tanner
                rectangle.setFill(Color.WHITE);
                rectangle.setStroke(Color.BLACK);
                farm.getChildren().add(rectangle);
                rectanglelist.add(rectangle);
                rectangle.toFront();
                TreeItem Container = new TreeItem(textFieldName.getText());
                Choice2.getChildren().add(Container);

                rectangle.setOnMouseClicked((eventTwo) -> {
                    purchasePrice.setText("Purchase Price: " + textFieldP.getText());
                });

                rectangle.setOnMouseClicked((eventThree) -> {
                    currentMarketPrice.setText("Current Marker Price: " + textFieldM.getText());
                });
            }
        });
        

  
        // create a tilepane
        Pane Pane = new VBox(textFieldName,textFieldW,textFieldH,textFieldX,textFieldY,textFieldP,textFieldM,Submit);
  
        // create a scene
        Scene sc = new Scene(Pane, 200, 200);
  
        // set the scene
        stage.setScene(sc);
  
        stage.show();
    }

    public void Rename() {
        
        Stage stage = new Stage();
        
        stage.setTitle("Rename");
        TextField textFieldName = new TextField ("New Name variable");
        Button Submit = new Button("Submit");
        Submit.setOnAction(new EventHandler <ActionEvent>()
        {
            public void handle(ActionEvent event)
            {
                
                for (int i = 0; i < rectanglelist.size(); i++){
                    if (rectanglelist.get(i).getName().contains((locationTreeView.getSelectionModel().getSelectedItem().getValue()))){
                        rectanglelist.get(i).setName(textFieldName.getText());
                    }
                    
                }
                locationTreeView.getSelectionModel().getSelectedItem().setValue(textFieldName.getText());
            }
        });
        

  
        // create a tilepane
        Pane Pane = new VBox(textFieldName,Submit);
  
        // create a scene
        Scene sc = new Scene(Pane, 200, 200);
  
        // set the scene
        stage.setScene(sc);
  
        stage.show();
    }
    

    public void changeLocation() {
        Stage stage = new Stage();
        
        stage.setTitle("Rename");
        TextField textFieldX = new TextField ("New X variable");
        TextField textFieldY = new TextField ("New Y variable");
        Button Submit = new Button("Submit");
        Submit.setOnAction(new EventHandler <ActionEvent>()
        {
            public void handle(ActionEvent event)
            {
                
                for (int i = 0; i < rectanglelist.size(); i++){
                    if (rectanglelist.get(i).getName().contains((locationTreeView.getSelectionModel().getSelectedItem().getValue()))){
                        rectanglelist.get(i).setX(Integer.parseInt(textFieldX.getText()));
                        rectanglelist.get(i).setY(Integer.parseInt(textFieldY.getText()));
                    }
                    
                }
                
            }
        });
        

  
        // create a tilepane
        Pane Pane = new VBox(textFieldX,textFieldY,Submit);
  
        // create a scene
        Scene sc = new Scene(Pane, 200, 200);
  
        // set the scene
        stage.setScene(sc);
  
        stage.show();
    }

    public void changePrice() {
        Stage stage = new Stage();
        
        stage.setTitle("Rename");
        TextField textField = new TextField ("New Price variable");
        Button Submit = new Button("Submit");
        Submit.setOnAction(new EventHandler <ActionEvent>()
        {
            public void handle(ActionEvent event)
            {
                
                for (int i = 0; i < rectanglelist.size(); i++){
                    if (rectanglelist.get(i).getName().contains((locationTreeView.getSelectionModel().getSelectedItem().getValue()))){
                        rectanglelist.get(i).setPrice(Long.parseLong(textField.getText()));
                    }
                    
                }
                
            }
        });
        

  
        // create a tilepane
        Pane Pane = new VBox(textField,Submit);
  
        // create a scene
        Scene sc = new Scene(Pane, 200, 200);
  
        // set the scene
        stage.setScene(sc);
  
        stage.show();

    }

    public void changeDimensions() {
        Stage stage = new Stage();
        
        stage.setTitle("Rename");
        TextField textFieldW = new TextField ("New Width variable");
        TextField textFieldH = new TextField ("New Height variable");
        Button Submit = new Button("Submit");
        Submit.setOnAction(new EventHandler <ActionEvent>()
        {
            public void handle(ActionEvent event)
            {
                
                for (int i = 0; i < rectanglelist.size(); i++){
                    if (rectanglelist.get(i).getName().contains((locationTreeView.getSelectionModel().getSelectedItem().getValue()))){
                        rectanglelist.get(i).setWidth(Integer.parseInt(textFieldW.getText()));
                        rectanglelist.get(i).setHeight(Integer.parseInt(textFieldH.getText()));
                    }
                    
                }
                
            }
        });
        

  
        // create a tilepane
        Pane Pane = new VBox(textFieldW,textFieldH,Submit);
  
        // create a scene
        Scene sc = new Scene(Pane, 200, 200);
  
        // set the scene
        stage.setScene(sc);
  
        stage.show();

    }

    public void Delete() {
        System.out.println(rectanglelist);
        for (int i = 0; i < rectanglelist.size(); i++){
            if (rectanglelist.get(i).getName().contains((locationTreeView.getSelectionModel().getSelectedItem().getValue()))){
                //needs to delete rectangle from farm pane 
                rectanglelist.remove(i);
            }
            
        }
        System.out.println(rectanglelist);
    }

    public void scanFarm() {
        int Xarray[] = {0,446,446,0,0}; 
        int Yarray[] = {0,537,0,537,0};
        
        for (int i = 0; i < Xarray.length; i++){
            DroneScan(Xarray[i], Yarray[i]);
            System.out.println("test " + i);
        }
        

    }

    public void goHome() {

        Path path = new Path();
        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.millis(1000));
        pathTransition.setNode(Corgicopter);
        pathTransition.setPath(path);
        path.getElements().add(new MoveTo(dronestartx,dronestarty)); //starts
        path.getElements().add(new LineTo(commandCenterx, commandCentery)); //ends
        pathTransition.setCycleCount(1);
        pathTransition.setAutoReverse(false);
        pathTransition.play();
        dronestartx = Choice3.getX();
        dronestarty = Choice3.getY();
        Corgicopter.toFront();

    }


}