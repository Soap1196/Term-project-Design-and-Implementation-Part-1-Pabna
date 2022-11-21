import javafx.fxml.Initializable;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.SocketException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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
import javafx.scene.control.Alert.AlertType;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javafx.scene.text.*;
import javafx.scene.transform.Rotate;
import javafx.stage.Popup;

import classes.*;
import flightClasses.*;

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
        @FXML private Button LaunchDrone;
        
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

        TelloDroneAdapter tello;
        boolean telloDroneActive = false;

        ArrayList<Srectangle> rectanglelist = new ArrayList<>();
        Constants constant;
        
        

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        farm.setLayoutX(260);
        farm.setLayoutY(102);
        farm.setPrefHeight(Constants.MODELHEIGHT*30);
        farm.setPrefWidth(Constants.MODELWIDTH*30);
        Mpain.getChildren().addAll(farm);
        rootDirectory.setCompName("Root Node");
        LaunchDrone.setStyle("-fx-background-color: grey");

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
                        globalLeaf = temp.getLeaf();
                        System.out.println(Choice1);
                        
                    }
                }
                
                
            }

        });
    }

    public void scanFarm() throws IOException, InterruptedException{
        if (telloDroneActive == false)
        {
        double tempStartx;
        double tempStarty;
        Path path = new Path();
        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.millis(10000));
        pathTransition.setNode(Corgicopter);
        pathTransition.setPath(path);
        path.getElements().add(new MoveTo(dronestartx,dronestarty)); //starts
        path.getElements().add(new LineTo(0, 0));
            for(int i = 0; i < 10; i+=2){
                path.getElements().add(new LineTo(i*80, 600));
                path.getElements().add(new LineTo((i+1)*80, 600));
                path.getElements().add(new LineTo((i+1)*80, 25));
                path.getElements().add(new LineTo((i+2)*80, 25));
            }
        path.getElements().add(new LineTo(commandCenterx, commandCentery));

        pathTransition.setCycleCount(1);
        pathTransition.setAutoReverse(false);
        pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pathTransition.play();
        dronestartx = commandCenterx;
        dronestarty = commandCentery;
        Corgicopter.toFront();
        }
        if (telloDroneActive){
            tello.scanFarm();
        }

        //globalLeaf.showItemDetails(); //prints all component objects to the terminal located on the farm
        
    }

    public void calculateMarketValue() {
        Stage stage = new Stage();
        
        ShoppingCartVisitor visitor = new ShoppingCartVisitorImpl();
        double sum = 0;
        if(globalComposite != null){
            sum = 0;
            for (items x:globalComposite.itemslist){
                sum = sum + x.accept(visitor, false);
            }
        }
            if(globalLeaf != null){
                sum = globalLeaf.getMarketValue();
            }
        Text textName = new Text ("Market Value");
        TextField textfieldPP = new TextField (String.valueOf(sum));

        Pane Pane = new VBox(textName,textfieldPP);
  
        Scene sc = new Scene(Pane, 200, 200);
  
        stage.setScene(sc);
  
        stage.show();
    }

    public void calculatePurchasePrice() {
        Stage stage = new Stage();
        Text textName = new Text ("Purchase Price");
        
        ShoppingCartVisitor visitor = new ShoppingCartVisitorImpl();
        double sum = 0;
        if(globalComposite != null){
        sum = globalComposite.getCompPrice();
        for (items x:globalComposite.itemslist){
            sum = sum + x.accept(visitor, true);
        }
    }
        if(globalLeaf != null){
            sum = globalLeaf.getPrice();
        }
        
        TextField textfieldPP = new TextField (String.valueOf(sum));

        Pane Pane = new VBox(textName,textfieldPP);
  
        Scene sc = new Scene(Pane, 200, 200);
  
        stage.setScene(sc);
  
        stage.show();
    }

    public void commandCenterDrone() {
        Stage stage = new Stage();
        
        stage.setTitle("Create Command Center");
        TextField textFieldW = new TextField ("Width variable");
        TextField textFieldH = new TextField ("Length variable");
        TextField textFieldL = new TextField ("Height variable");
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
                
                Corgicopter = new ImageView(new Image("drone.png"));
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

        Pane Pane = new VBox(textFieldW,textFieldH,textFieldL,textFieldX,textFieldY,textFieldP,Submit);
  
        Scene sc = new Scene(Pane, 200, 200);
  
        stage.setScene(sc);
  
        stage.show();
    }
    
    
    public void droneVisit() throws IOException, InterruptedException {
        if (telloDroneActive == false) 
        {
            Path path = new Path();
            PathTransition pathTransition = new PathTransition();
            pathTransition.setDuration(Duration.millis(1000));
            pathTransition.setNode(Corgicopter);
            pathTransition.setPath(path);
            path.getElements().add(new MoveTo(dronestartx,dronestarty)); //starts
            path.getElements().add(new LineTo(Choice3.getX(), Choice3.getY())); //visits
            path.getElements().add(new LineTo(dronestartx, dronestartx)); //ends
            pathTransition.setCycleCount(1);
            pathTransition.setAutoReverse(false);
            pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
            pathTransition.play();
            Corgicopter.toFront();
        }
        if (telloDroneActive == true)
        {
            tello.moveDrone(dronestartx, dronestarty, Choice3.getX(), Choice3.getY());
        }
        
        

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
        TextField textFieldH = new TextField ("Length variable");
        TextField textFieldL = new TextField ("Height variable");
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
                
                

                Popup infobox = new Popup();
                infobox.getContent().add(infoVbox);

                rectangle.hoverProperty().addListener((x, prev, NewV) -> {
                    if (NewV) {
                        Text textName = new Text ("NAME: " + rectangle.getName());
                        Text textX = new Text ("X coordinate: " + rectangle.getX());
                        Text textY = new Text ("Y coordinate: " + rectangle.getY());
                        Text textW = new Text ("Width: " + rectangle.getWidth());
                        Text textL = new Text ("Length: " + rectangle.getHeight());
                        Text textP = new Text ("Price: " + rectangle.getPrice());
                        infoVbox.getChildren().addAll(textName,textX,textY,textW,textL,textP);
                        infobox.show(rectangle, 300, 150);
                    } else {
                        infobox.hide();
                        infoVbox.getChildren().clear();
                    }
                });

                farm.getChildren().add(rectangle);
                
                rectanglelist.add(rectangle);
                TreeItem Container = new TreeItem(textFieldName.getText());
                Choice2.getChildren().add(Container);

            }
        });

        Pane Pane = new VBox(textFieldName,textFieldW,textFieldH,textFieldL,textFieldX,textFieldY,textFieldP,Submit);
  
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
        TextField textFieldH = new TextField ("Length variable");
        TextField textFieldL = new TextField ("Height variable");
        TextField textFieldX = new TextField ("X variable");
        TextField textFieldY = new TextField ("Y variable");
        TextField textFieldP = new TextField ("Price");
        TextField textFieldMV = new TextField ("Market Value");
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
                leaf1.setMarketValue(Long.parseLong(textFieldMV.getText()));
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
                rectangle.setMarketValue(leaf1.getMarketValue());
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
                Text textH = new Text ("Y coordinate: " + rectangle.getY());
                Text textW = new Text ("Width: " + rectangle.getWidth());
                Text textL = new Text ("Length: " + rectangle.getHeight());
                Text textP = new Text ("Price: " + rectangle.getPrice());
                Text textMV = new Text ("Market: " + rectangle.getMarketValue());
                infoVbox.getChildren().addAll(textName,textX,textY,textW,textL,textP,textMV);

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
        Pane Pane = new VBox(textFieldName,textFieldW,textFieldH,textFieldL,textFieldX,textFieldY,textFieldP,textFieldMV,Submit);
  
        Scene sc = new Scene(Pane, 200, 300);
  
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
        
        stage.setTitle("Change Location");
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
        
        stage.setTitle("Change Price");
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

        public void changeMarketValue() {
            Stage stage = new Stage();
            
            stage.setTitle("Change Market Value");
            TextField textField = new TextField ("New Market Value variable");
            Button Submit = new Button("Submit");
            Submit.setOnAction(new EventHandler <ActionEvent>()
            {
                public void handle(ActionEvent event)
                {
                    
                    for (int i = 0; i < rectanglelist.size(); i++){
                        if (rectanglelist.get(i).getName().contains((locationTreeView.getSelectionModel().getSelectedItem().getValue()))){
                            if (rectanglelist.get(i).getLeaf() != null){
                                rectanglelist.get(i).getLeaf().setMarketValue(Long.parseLong(textField.getText()));
                                rectanglelist.get(i).setMarketValue(Long.parseLong(textField.getText()));
                            }
                            else{
                                Alert alert = new Alert(AlertType.WARNING);
                                alert.setTitle("Market Value");
                                alert.setHeaderText("Market Value Warning!");
                                alert.setContentText("Market Value will be set to 0 for Item Containers");
                                alert.showAndWait();
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
        TextField textFieldH = new TextField ("New Length variable");
        TextField textFieldL = new TextField ("New Height variable");
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
        Pane Pane = new VBox(textFieldW,textFieldH,textFieldL,Submit);
  
        // create a scene
        Scene sc = new Scene(Pane, 200, 200);
  
        // set the scene
        stage.setScene(sc);
  
        stage.show();

    }

    void DeleteChildren(TreeItem<String> node){
        //If node has children
        if(node.getChildren().size() != 0){
            //For each child
            for(int i = 0; i < node.getChildren().size(); i++){
                //Remove child from rectanglelist and farm
                for(int j = 0; j < rectanglelist.size(); j++){
                    if(node.getChildren().get(i).getValue().equals(rectanglelist.get(j).getName())){
                        farm.getChildren().remove(j);
                        if(rectanglelist.get(j).getisComposite() == true){
                            globalComposite.removeitems(rectanglelist.get(j).getComposite());
                            rectanglelist.remove(j);
                            //If child has children
                            if(node.getChildren().get(i).getChildren().size() != 0){
                                //Delete all children of child
                                DeleteChildren(node.getChildren().get(i));
                            }
                        } else{
                            globalComposite.removeitems(rectanglelist.get(j).getLeaf());
                            rectanglelist.remove(j);
                        }
                    }
                }
            }
        }
    }

    public void Delete() {
        //If selected node is Root or Command Center
        if(Choice1.equals("Root") || Choice1.equals("Command Center")){
            editError();
        } else{
            //Warn user of deletion
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Delete");
            alert.setHeaderText("Are you sure you want to delete " + Choice1 + "?");
            alert.setContentText("This action cannot be undone.");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                //Assign a temp variable to the nodes parent
                TreeItem<String> temp = Choice2.getParent();
                //If selected node is a composite
                if(Choice3.getisComposite() == true){
                    //if tree children is not empty delete all rectanglelist in tree that match children names
                    if(Choice2.getChildren().size() != 0){
                        for(int i = 0; i < Choice2.getChildren().size(); i++){
                            for(int j = 0; j < rectanglelist.size(); j++){
                                if(((TreeItem<String>) Choice2.getChildren().get(i)).getValue().equals(rectanglelist.get(j).getName())){
                                    farm.getChildren().remove(rectanglelist.get(j));
                                    rectanglelist.remove(j);
                                    Choice3.getComposite().removeitems(rectanglelist.get(j).getComposite());
                                    
                                }
                            }
                        }
                    }
                    if (Choice2.getParent().getValue().equals("Root")){
                        globalComposite.removeitems(Choice3.getComposite());
                    }
                    DeleteChildren(Choice2);
                    globalComposite.removeitems(Choice3.getComposite());
                    //Remove composite from Tree
                    Choice2.getParent().getChildren().remove(Choice2);
                    //Remove composite from rectanglelist
                    rectanglelist.remove(Choice3);
                    //Remove composite from farm
                    farm.getChildren().remove(Choice3);
                } else{
                    //Remove leaf from global composite
                    globalComposite.removeitems(Choice3.getLeaf());
                    //Remove leaf from Tree
                    Choice2.getParent().getChildren().remove(Choice2);
                    //Remove leaf from rectanglelist
                    rectanglelist.remove(Choice3);
                    //Remove leaf from farm
                    farm.getChildren().remove(Choice3);
                }
                //scan rectanglelist to find rectangle equal to the parent of the deleted node
                for(int i = 0; i < rectanglelist.size(); i++){
                    if(temp.getValue().equals(rectanglelist.get(i).getName())){
                        //set Choice3 to temp
                        Choice3 = rectanglelist.get(i);
                    }
                }
                //set the selected node to the parent of the deleted node
                Choice1 = (String) Choice2.getValue();
                Choice2 = temp;
                globalComposite = Choice3.getComposite();
                
            } else {
                //Do nothing
            }
        }
    }

    //Error Message for Editing Root or Command Center
    void editError(){
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Cannot Edit " + Choice1 + "!");
        alert.setContentText("You cannot edit this item!");
        alert.showAndWait();
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
        dronestartx = commandCenterx;
        dronestarty = commandCentery;
        Corgicopter.toFront();

    }

    public void launchDrone() throws IOException, InterruptedException {
        if(telloDroneActive == false){
            telloDroneActive = true;
            LaunchDrone.setStyle("-fx-background-color: red");
            tello = new TelloDroneAdapter();
            tello.activateDrone();
            System.out.println("Tello Drone is Active");

        }
    }
    public void landDrone() throws IOException, InterruptedException {
        if(telloDroneActive == true){
        telloDroneActive=false;
            LaunchDrone.setStyle("-fx-background-color: grey");
            tello.landDrone();
            System.out.println("Tello Drone is NOT Active");
            
        }
    }

    
}