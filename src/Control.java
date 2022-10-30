import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.animation.PathTransition; 
import javafx.scene.shape.MoveTo; 
import javafx.scene.shape.Path;
import javafx.scene.shape.HLineTo;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;  
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.VLineTo;
import javafx.scene.shape.LineTo;
import javafx.scene.layout.Pane;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.text.*;
import javafx.stage.Popup;

import classes.*;

public class Control implements Initializable{

        @FXML public TreeView<String> locationTreeView;
        @FXML public Pane Mpain;
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
        public CustomPane farm=CustomPane.getInstance();

        TreeItem<String> root = new TreeItem<String>("Root Node");
        composite rootDirectory = new composite();
        

        public String Choice1;
        public TreeItem Choice2 = root;
        public Srectangle Choice3;
        public composite globalComposite = rootDirectory;
        public leaf globalLeaf;
        double dronestartx = 25;
        double dronestarty = 25;
        double commandCenterx;
        double commandCentery;

        ArrayList<Srectangle> rectanglelist = new ArrayList<>();
        
        

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        farm.setLayoutX(260);
        farm.setLayoutY(102);
        farm.setPrefHeight(537);
        farm.setPrefWidth(446);
        Mpain.getChildren().addAll(farm);
        rootDirectory.setCompName("Root Node");

        //Drawing a Rectangle 
        Srectangle rectangle = new Srectangle();  
      
        //Setting the properties of the rectangle 
        rectangle.setName(rootDirectory.getCompName());
        rectanglelist.add(rectangle);
        rectangle.setComposite(rootDirectory);
        rectangle.setisComposite(true);

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
                        globalComposite = temp.getComposite();
                        System.out.println(Choice1);
                    }
                }
                
                
            }

        });
    }

    public void DroneScan(double x, double y){
        Path path = new Path();
        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.millis(10000));
        pathTransition.setNode(Corgicopter);
        pathTransition.setPath(path);
        path.getElements().add(new MoveTo(dronestartx,dronestarty)); //starts
        path.getElements().add(new LineTo(0, 0)); //ends
        path.getElements().add(new VLineTo(530));
        path.getElements().add(new HLineTo(80));
        path.getElements().add(new VLineTo(0));
        path.getElements().add(new HLineTo(160));
        path.getElements().add(new VLineTo(530));
        path.getElements().add(new HLineTo(240));
        path.getElements().add(new VLineTo(0));
        path.getElements().add(new HLineTo(320));
        path.getElements().add(new VLineTo(530));
        path.getElements().add(new HLineTo(400));
        path.getElements().add(new VLineTo(0));
        path.getElements().add(new HLineTo(446));
        path.getElements().add(new VLineTo(530));
        pathTransition.setCycleCount(1);
        pathTransition.setAutoReverse(false);
        pathTransition.play();
        Corgicopter.toFront();
        rootDirectory.showItemDetails(); //prints all component objects to the terminal located on the farm
    }

    public void commandCenterDrone() {
        Stage stage = new Stage();
        
        stage.setTitle("Create Command Center");
        TextField textFieldW = new TextField ("Width variable");
        TextField textFieldH = new TextField ("Height variable");
        TextField textFieldX = new TextField ("X variable");
        TextField textFieldY = new TextField ("Y variable");
        TextField textFieldP = new TextField ("Price");
        Button Submit = new Button("Submit");
        Submit.setOnAction(new EventHandler <ActionEvent>()
        {
            public void handle(ActionEvent event)
            {
                //Create composite object
                composite comp1 = new composite();

                comp1.setCompName("Command Center");
                comp1.setCompXcoordinate(Integer.parseInt(textFieldX.getText()));
                comp1.setCompYcoordinate(Integer.parseInt(textFieldY.getText()));
                comp1.setCompWidth(Integer.parseInt(textFieldW.getText()));
                comp1.setCompHeight(Integer.parseInt(textFieldH.getText()));
                comp1.setCompPrice(Long.parseLong(textFieldP.getText()));
                rootDirectory.additem(comp1);
                globalComposite=rootDirectory;

                //Drawing a Rectangle 
                Srectangle rectangle = new Srectangle();  
      
                //Setting the properties of the rectangle 
                rectangle.setName("Command Center");
                rectangle.setX(comp1.getCompXcoordinate()); 
                rectangle.setY(comp1.getCompYcoordinate()); 
                rectangle.setWidth(comp1.getCompWidth()); 
                rectangle.setHeight(comp1.getCompHeight());
                rectangle.setPrice(comp1.getCompPrice());
                rectangle.setisComposite(true);
                rectangle.setComposite(comp1);
                rectangle.setLeaf(null);
                rectangle.setFill(Color.AQUA);
                rectangle.setStroke(Color.BLACK);
                
                VBox infoVbox = new VBox();
                infoVbox.setPrefSize(250, 150);
                infoVbox.setStyle("-fx-background-color: grey;");
                Text textName = new Text ("NAME: " + rectangle.getName());
                Text textX = new Text ("X coordinate: " + rectangle.getX());
                Text textY = new Text ("Y coordinate: " + rectangle.getY());
                Text textW = new Text ("Width: " + rectangle.getWidth());
                Text textL = new Text ("Length: " + rectangle.getHeight());
                Text textP = new Text ("Price: " + rectangle.getPrice());
                infoVbox.getChildren().addAll(textName,textX,textY,textW,textL,textP);

                Popup infobox = new Popup();
                infobox.getContent().add(infoVbox);

                rectangle.hoverProperty().addListener((x, prev, NewV) -> {
                    if (NewV) {
                        infobox.show(rectangle, 300, 150);
                    } else {
                        infobox.hide();
                    }
                });
            
                farm.getChildren().add(rectangle);
                
                rectanglelist.add(rectangle);
                TreeItem Container = new TreeItem("Command Center");
                root.getChildren().add(Container);
                
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

        Pane Pane = new VBox(textFieldW,textFieldH,textFieldX,textFieldY,textFieldP,Submit);
  
        Scene sc = new Scene(Pane, 200, 200);
  
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
        if((Choice3.getisComposite()) == false){
            Stage stage = new Stage();
            stage.setTitle("");
            Text text = new Text("A new node cannot be added as a child to a leaf node");
            
            Pane Pane = new VBox(text);
            
            Scene sc = new Scene(Pane, 400, 100);
            
            stage.setScene(sc);
            stage.show();
        }
        else {
        Stage stage = new Stage();
        
        stage.setTitle("Item Container Creation");
        TextField textFieldName = new TextField ("Name variable");
        TextField textFieldW = new TextField ("Width variable");
        TextField textFieldH = new TextField ("Height variable");
        TextField textFieldX = new TextField ("X variable");
        TextField textFieldY = new TextField ("Y variable");
        TextField textFieldP = new TextField ("Price");
        Button Submit = new Button("Submit");
        Submit.setOnAction(new EventHandler <ActionEvent>()
        {
            public void handle(ActionEvent event)
            {
                //Create composite object
                composite comp1 = new composite();
                comp1.setCompName(textFieldName.getText());
                comp1.setCompXcoordinate(Integer.parseInt(textFieldX.getText()));
                comp1.setCompYcoordinate(Integer.parseInt(textFieldY.getText()));
                comp1.setCompLength(Integer.parseInt(textFieldW.getText()));
                comp1.setCompHeight(Integer.parseInt(textFieldH.getText()));
                comp1.setCompPrice(Long.parseLong(textFieldP.getText()));
                globalComposite.additem(comp1);

                //Drawing a Rectangle 
                Srectangle rectangle = new Srectangle();  
      
                //Setting the properties of the rectangle 
                rectangle.setName(comp1.getCompName());
                rectangle.setX(comp1.getCompXcoordinate()); 
                rectangle.setY(comp1.getCompYcoordinate()); 
                rectangle.setWidth(comp1.getCompLength()); 
                rectangle.setHeight(comp1.getCompHeight());
                rectangle.setPrice(comp1.getCompPrice());
                rectangle.setisComposite(true);
                rectangle.setComposite(comp1);
                rectangle.setLeaf(null);
                rectangle.setFill(Color.WHITE);
                rectangle.setStroke(Color.BLACK);

                VBox infoVbox = new VBox();
                infoVbox.setPrefSize(200, 150);
                infoVbox.setStyle("-fx-background-color: grey;");
                Text textName = new Text ("NAME: " + rectangle.getName());
                Text textX = new Text ("X coordinate: " + rectangle.getX());
                Text textY = new Text ("Y coordinate: " + rectangle.getY());
                Text textW = new Text ("Width: " + rectangle.getWidth());
                Text textL = new Text ("Length: " + rectangle.getHeight());
                Text textP = new Text ("Price: " + rectangle.getPrice());
                infoVbox.getChildren().addAll(textName,textX,textY,textW,textL,textP);

                Popup infobox = new Popup();
                infobox.getContent().add(infoVbox);

                rectangle.hoverProperty().addListener((x, prev, NewV) -> {
                    if (NewV) {
                        infobox.show(rectangle, 300, 150);
                    } else {
                        infobox.hide();
                    }
                });

                farm.getChildren().add(rectangle);
                
                rectanglelist.add(rectangle);
                TreeItem Container = new TreeItem(textFieldName.getText());
                Choice2.getChildren().add(Container);

            }
        });

        Pane Pane = new VBox(textFieldName,textFieldW,textFieldH,textFieldX,textFieldY,textFieldP,Submit);
  
        Scene sc = new Scene(Pane, 200, 200);
  
        stage.setScene(sc);
  
        stage.show();
    }
    }

    public void CreateItem() {
        if((Choice3.getisComposite()) == false){
            Stage stage = new Stage();
            stage.setTitle("");
            Text text = new Text("A new node cannot be added as a child to a leaf node");
            
            Pane Pane = new VBox(text);
            
            Scene sc = new Scene(Pane, 400, 100);
            
            stage.setScene(sc);
            stage.show();
        }
        else {
        Stage stage = new Stage();
        
        stage.setTitle("Item Creation");
        TextField textFieldName = new TextField ("Name variable");
        TextField textFieldW = new TextField ("Width variable");
        TextField textFieldH = new TextField ("Height variable");
        TextField textFieldX = new TextField ("X variable");
        TextField textFieldY = new TextField ("Y variable");
        TextField textFieldP = new TextField ("Price");
        Button Submit = new Button("Submit");
        Submit.setOnAction(new EventHandler <ActionEvent>()
        {
            public void handle(ActionEvent event)
            {
                //Create leaf object
                //composite comp1 = new composite();
                leaf leaf1 = new leaf();
                //Leaf Setup
                leaf1.setName(textFieldName.getText());
                leaf1.setXCoordinate(Long.parseLong(textFieldX.getText()));
                leaf1.setYCoordinate(Long.parseLong(textFieldY.getText()));
                leaf1.setWidth(Long.parseLong(textFieldW.getText()));
                leaf1.setHeight(Long.parseLong(textFieldH.getText()));
                leaf1.setPrice(Long.parseLong(textFieldP.getText()));
                globalComposite.additem(leaf1);
                
                //Drawing a Rectangle 
                Srectangle rectangle = new Srectangle();  
      
                //Setting the properties of the rectangle 
                rectangle.setName(leaf1.getName());
                rectangle.setX(leaf1.getXCoordinate()); 
                rectangle.setY(leaf1.getYCoordinate()); 
                rectangle.setWidth(leaf1.getWidth()); 
                rectangle.setHeight(leaf1.getHeight());
                rectangle.setPrice(leaf1.getPrice());
                rectangle.setisComposite(false);
                rectangle.setComposite(Choice3.getComposite());
                rectangle.setLeaf(leaf1);
                rectangle.setFill(Color.WHITE);
                rectangle.setStroke(Color.BLACK);

                VBox infoVbox = new VBox();
                infoVbox.setPrefSize(250, 150);
                infoVbox.setStyle("-fx-background-color: grey;");
                Text textName = new Text ("NAME: " + rectangle.getName());
                Text textX = new Text ("X coordinate: " + rectangle.getX());
                Text textY = new Text ("Y coordinate: " + rectangle.getY());
                Text textW = new Text ("Width: " + rectangle.getWidth());
                Text textL = new Text ("Length: " + rectangle.getHeight());
                Text textP = new Text ("Price: " + rectangle.getPrice());
                infoVbox.getChildren().addAll(textName,textX,textY,textW,textL,textP);

                Popup infobox = new Popup();
                infobox.getContent().add(infoVbox);

                rectangle.hoverProperty().addListener((x, prev, NewV) -> {
                    if (NewV) {
                        infobox.show(rectangle, 300, 200);
                    } else {
                        infobox.hide();
                    }
                });

                farm.getChildren().add(rectangle);
                rectanglelist.add(rectangle);
                rectangle.toFront();
                TreeItem Container = new TreeItem(textFieldName.getText());
                Choice2.getChildren().add(Container);

            }
        });
        Pane Pane = new VBox(textFieldName,textFieldW,textFieldH,textFieldX,textFieldY,textFieldP,Submit);
  
        Scene sc = new Scene(Pane, 200, 200);
  
        stage.setScene(sc);
  
        stage.show();
    }
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
                        if (rectanglelist.get(i).getLeaf() != null){
                            rectanglelist.get(i).getLeaf().setName(textFieldName.getText());
                        }
                        else{
                            rectanglelist.get(i).getComposite().setCompName(textFieldName.getText());
                        }
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
                        if (rectanglelist.get(i).getLeaf() != null){
                            rectanglelist.get(i).getLeaf().setXCoordinate(Integer.parseInt(textFieldX.getText()));
                            rectanglelist.get(i).getLeaf().setYCoordinate(Integer.parseInt(textFieldY.getText()));
                        }
                        else{
                            rectanglelist.get(i).getComposite().setCompXcoordinate(Integer.parseInt(textFieldX.getText()));
                            rectanglelist.get(i).getComposite().setCompYcoordinate(Integer.parseInt(textFieldY.getText()));
                        }
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
                        if (rectanglelist.get(i).getLeaf() != null){
                            rectanglelist.get(i).getLeaf().setPrice(Long.parseLong(textField.getText()));
                        }
                        else{
                            rectanglelist.get(i).getComposite().setCompPrice(Long.parseLong(textField.getText()));
                        }
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
                        if (rectanglelist.get(i).getLeaf() != null){
                            rectanglelist.get(i).getLeaf().setWidth(Long.parseLong(textFieldW.getText()));
                            rectanglelist.get(i).getLeaf().setHeight(Long.parseLong(textFieldH.getText()));
                        }
                        else{
                            rectanglelist.get(i).getComposite().setCompWidth(Long.parseLong(textFieldW.getText()));
                            rectanglelist.get(i).getComposite().setCompHeight(Long.parseLong(textFieldH.getText()));
                        }
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
                if (rectanglelist.get(i).getLeaf() != null){
                    rectanglelist.get(i).getComposite().removeitems(rectanglelist.get(i).getLeaf());
                }
                else{
                    rectanglelist.get(i).getComposite().removeitems(rectanglelist.get(i).getComposite());;
                }
                farm.getChildren().remove(rectanglelist.get(i));
                TreeItem t = (locationTreeView.getSelectionModel().getSelectedItem());
                t.getParent().getChildren().remove(t);
                rectanglelist.remove(i);
            }
            
        }
        System.out.println(rectanglelist);
    }

    public void scanFarm() {

        DroneScan(0,0);
        dronestartx=446;
        dronestarty=530;
        

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