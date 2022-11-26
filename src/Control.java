import javafx.animation.PathTransition;
import javafx.util.Duration;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TreeView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.control.TreeItem;
import javafx.scene.image.ImageView;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.layout.VBox;
import javafx.scene.control.*;
import classes.*;

public class Control{

    @FXML
    private Button Delete;

    @FXML
    private Pane Mpain;

    @FXML
    private Button Rename;

    @FXML
    private Button Visit;

    @FXML
    private Button changeDimensions;

    @FXML
    private Button changeLocation;

    @FXML
    private Button changePrices;

    @FXML
    private Button createItem;

    @FXML
    private Button createItemContainer;

    @FXML
    private TreeView<String> locationTreeView;

    public ImageView Corgicopter;
    public CustomPane farm = CustomPane.getInstance();

    //Set Tree Root Directory
    TreeItem<String> root = new TreeItem<String>("Root");
    composite rootDirectory = new composite();

    public String Choice1;
    public TreeItem<String> Choice2 = root;
    public Srectangle Choice3;
    public composite globalComposite = rootDirectory;
    public leaf globalLeaf;
    private Double droneHomex = 400.0;
    private Double droneHomey = 50.0;
    
    ArrayList<Srectangle> rectangles = new ArrayList<Srectangle>();
    @FXML
     void initialize() {
        //Initialize Farm Pane
        farm.setLayoutX(250);
        farm.setLayoutY(5);
        farm.setPrefSize(800, 600);
        Mpain.getChildren().addAll(farm);
        rootDirectory.setCompName("Root");

        //Initialize Ractangle Object
        Srectangle rectangle = new Srectangle();

        //Set Rectangle Properties
        rectangle.setName(rootDirectory.getCompName());
        rectangles.add(rectangle);
        rectangle.setComposite(rootDirectory);
        rectangle.setisComposite(true);

        //Set Tree View Properties
        root.setExpanded(true);
        locationTreeView.setRoot(root);
        locationTreeView.setOnMouseClicked((event) -> {
            TreeItem<String> item = locationTreeView.getSelectionModel().getSelectedItem();
            for (int i = 0; i < rectangles.size(); i++){
                if (rectangles.get(i)!=null){
                    Srectangle temp = rectangles.get(i);
                    if (temp.getName().contains(item.getValue())){
                        Choice1 = item.getValue();
                        Choice2 = item;
                        Choice3 = temp;
                        System.out.println(Choice1);
                        if(Choice3.getisComposite()){
                            System.out.println(Choice3.getComposite().getCompPrice());
                            System.out.println(calculatePrice(Choice3.getComposite()));
                            PurchasePrice.setText("Purchase Price: $" + calculatePrice(Choice3.getComposite()));
                            MarketValue.setText("Market Value: $" + calculateMarketValue(Choice3.getComposite()));
                            
                        }
                        else{
                            PurchasePrice.setText("Purchase Price: $" + calculatePrice(Choice3.getLeaf()));
                            MarketValue.setText("Market Value: $" + calculateMarketValue(Choice3.getLeaf()));
                        }
                        
                    }
                }
                
                
            }
        });

        //Select root node as active when program starts
        Choice1 = rootDirectory.getCompName();
        Choice2 = root;
        Choice3 = rectangle;
        globalComposite = rootDirectory;

        composite composite = new composite();
        composite.setCompName("Command Center");
        composite.setCompWidth(Double.parseDouble("200"));
        composite.setCompHeight(Double.parseDouble("100"));
        composite.setCompXcoordinate(Double.parseDouble("300"));
        composite.setCompYcoordinate(Double.parseDouble("0"));
        composite.setCompPrice(Double.parseDouble("0"));
        globalComposite.additem(composite);

        //Create New Rectangle
        Srectangle rectangleCC = new Srectangle();

        //Set Rectangle Properties

        rectangleCC.setName(composite.getCompName());
        rectangleCC.setX(composite.getCompXcoordinate());
        rectangleCC.setY(composite.getCompYcoordinate());
        rectangleCC.setWidth(composite.getCompWidth());
        rectangleCC.setHeight(composite.getCompHeight());
        rectangleCC.setPrice(composite.getCompPrice());
        rectangleCC.setisComposite(true);
        rectangleCC.setComposite(composite);
        rectangleCC.setLeaf(null);
        rectangleCC.setFill(Color.WHITE);
        rectangleCC.setStroke(Color.BLACK);

        //Add ImageView Corgicopter to Center of Rectangle
        Corgicopter = new ImageView("Subject.png");
        Corgicopter.setFitHeight(50);
        Corgicopter.setFitWidth(50);
        Corgicopter.setX(375.0);
        Corgicopter.setY(25.0);




        //Add rectangle to Tree
        farm.getChildren().add(rectangleCC);
        farm.getChildren().add(Corgicopter);
        rectangles.add(rectangleCC);
        TreeItem<String> container = new TreeItem<String>(composite.getCompName());
        container.getChildren().add(new TreeItem<String>("Drone"));
        Choice2.getChildren().add(container);
        
    }


    @FXML
    void CreateItemContainer(ActionEvent event) { // Create Item and Item Container
        if(Choice3.getisComposite() == false || Choice1.equals("Command Center") || Choice1.equals("Drone")){ // if the selected item is a leaf or the command center
            leafError();
        } else{ // if the selected item is a composite
            Stage stage = new Stage();
            stage.setTitle("Create");
            TextField textFieldName = new TextField("Enter Name");
            TextField textFieldW = new TextField("Enter Width");
            TextField textFieldH = new TextField("Enter Height");
            TextField textFieldX = new TextField("Enter X Coordinate");
            TextField textFieldY = new TextField("Enter Y Coordinate");
            TextField textFieldPrice = new TextField("Enter Price");
            TextField textFieldMarketValue = new TextField("Enter Market Value");
            ToggleGroup group = new ToggleGroup();
            RadioButton item = new RadioButton("Item");
            RadioButton container = new RadioButton("Item Container");
            item.setToggleGroup(group);
            container.setToggleGroup(group);
            item.setSelected(true);
            Button button = new Button("Create");
            button.setOnAction(new EventHandler <ActionEvent>(){
                public void handle(ActionEvent event){
                    //If container is selected
                    if(container.isSelected()){
                        //Create composite object
                        composite composite = new composite();
                        composite.setCompName(textFieldName.getText());
                        composite.setCompWidth(Double.parseDouble(textFieldW.getText()));
                        composite.setCompHeight(Double.parseDouble(textFieldH.getText()));
                        //set composite x and y to be inside parent composite if it exists
                        if(Choice3.getisComposite() == true){
                            composite.setCompXcoordinate(Double.parseDouble(textFieldX.getText()) + Choice3.getComposite().getCompXcoordinate());
                            composite.setCompYcoordinate(Double.parseDouble(textFieldY.getText()) + Choice3.getComposite().getCompYcoordinate());
                        } else {
                            composite.setCompXcoordinate(Double.parseDouble(textFieldX.getText()));
                            composite.setCompYcoordinate(Double.parseDouble(textFieldY.getText()));
                        }
                        composite.setCompPrice(Double.parseDouble(textFieldPrice.getText()));
                        composite.setMarketValue(0.0);
                        Choice3.getComposite().additem(composite);
                        if(textFieldMarketValue.getText().equals("Enter Market Value") == false){
                            Alert alert = new Alert(AlertType.WARNING);
                            alert.setTitle("Market Value");
                            alert.setHeaderText("Market Value Warning!");
                            alert.setContentText("Market Value will be set to 0 for Item Containers");
                            alert.showAndWait();
                        }
                       

                        //Create New Rectangle
                        Srectangle rectangle = new Srectangle();

                        //Set Rectangle Properties

                        rectangle.setName(composite.getCompName());
                        rectangle.setX(composite.getCompXcoordinate());
                        rectangle.setY(composite.getCompYcoordinate());
                        rectangle.setWidth(composite.getCompWidth());
                        rectangle.setHeight(composite.getCompHeight());
                        rectangle.setPrice(composite.getCompPrice());
                        rectangle.setisComposite(true);
                        rectangle.setComposite(composite);
                        rectangle.setLeaf(null);
                        rectangle.setFill(Color.WHITE);
                        rectangle.setStroke(Color.BLACK);
                

                        //Add rectangle to Tree
                        farm.getChildren().add(rectangle);
                        rectangles.add(rectangle);
                        TreeItem<String> addition = new TreeItem<String>(textFieldName.getText());
                        Choice2.getChildren().add(addition);

                    } else if(item.isSelected()){
                        //Create leaf object
                        leaf leaf = new leaf();
                        leaf.setName(textFieldName.getText());
                        leaf.setWidth(Double.parseDouble(textFieldW.getText()));
                        leaf.setHeight(Double.parseDouble(textFieldH.getText()));
                        //set leaf x and y to be inside parent composite if it exists
                        if(Choice3.getisComposite() == true){
                            leaf.setXCoordinate(Double.parseDouble(textFieldX.getText()) + Choice3.getComposite().getCompXcoordinate());
                            leaf.setYCoordinate(Double.parseDouble(textFieldY.getText()) + Choice3.getComposite().getCompYcoordinate());
                        } else{
                            leaf.setXCoordinate(Double.parseDouble(textFieldX.getText()));
                            leaf.setYCoordinate(Double.parseDouble(textFieldY.getText()));
                        }
                        leaf.setPrice(Double.parseDouble(textFieldPrice.getText()));
                        leaf.setMarketValue(Double.parseDouble(textFieldMarketValue.getText()));
                        Choice3.getComposite().additem(leaf);
                        

                        //Create New Rectangle
                        Srectangle rectangle = new Srectangle();

                        //Set Rectangle Properties
                        rectangle.setName(leaf.getName());
                        rectangle.setX(leaf.getXCoordinate());
                        rectangle.setY(leaf.getYCoordinate());
                        rectangle.setWidth(leaf.getWidth());
                        rectangle.setHeight(leaf.getHeight());
                        rectangle.setPrice(leaf.getPrice());
                        rectangle.setisComposite(false);
                        rectangle.setComposite(Choice3.getComposite());
                        rectangle.setLeaf(leaf);
                        rectangle.setFill(Color.WHITE);
                        rectangle.setStroke(Color.BLACK);

                        //Add rectangle to Tree
                        farm.getChildren().add(rectangle);
                        rectangles.add(rectangle);
                        TreeItem<String> addition = new TreeItem<String>(textFieldName.getText());
                        Choice2.getChildren().add(addition);
                    }
                    //Close Stage
                    stage.close();
                }
            });
            
            Pane pane = new VBox(textFieldName, textFieldW, textFieldH, textFieldX, textFieldY, textFieldPrice, textFieldMarketValue, item, container, button);
            Scene sc = new Scene(pane, 200, 240);
            stage.setScene(sc);
            stage.show();
            
        }
    }

    @FXML
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
                    //if tree children is not empty delete all rectangles in tree that match children names
                    DeleteChildren(Choice2);
                    globalComposite.removeitems(Choice3.getComposite());
                    
                    //Remove composite from Tree
                    Choice2.getParent().getChildren().remove(Choice2);
                    //Remove composite from rectangles
                    rectangles.remove(Choice3);
                    //Remove composite from farm
                    farm.getChildren().remove(Choice3);
                } else{
                    //Remove leaf from global composite
                    globalComposite.removeitems(Choice3.getLeaf());
                    //Remove leaf from Tree
                    Choice2.getParent().getChildren().remove(Choice2);
                    //Remove leaf from rectangles
                    rectangles.remove(Choice3);
                    //Remove leaf from farm
                    farm.getChildren().remove(Choice3);
                }
                //scan rectangles to find rectangle equal to the parent of the deleted node
                for(int i = 0; i < rectangles.size(); i++){
                    if(temp.getValue().equals(rectangles.get(i).getName())){
                        //set Choice3 to temp
                        rectangles.get(i).getComposite().removeitems(Choice3.getComposite());
                        Choice3 = rectangles.get(i);
                    }
                        
                }
                //set the selected node to the parent of the deleted node
                Choice1 = Choice2.getValue();
                Choice2 = temp;
                
            }
        }
    }

    void DeleteChildren(TreeItem<String> node){
        Srectangle rectangle = Choice3;
        //find the rectangle for this node
        for(int i = 0; i < rectangles.size(); i++){
            if(node.getValue().equals(rectangles.get(i).getName())){
                rectangle = rectangles.get(i);
            }
        }
        //If node has children
        if(node.getChildren().size() != 0){
            //For each child
            for(int i = 0; i < node.getChildren().size(); i++){
                //Remove child from rectangles and farm
                for(int j = 0; j < rectangles.size(); j++){
                    if(node.getChildren().get(i).getValue().equals(rectangles.get(j).getName())){
                        
                        if(rectangles.get(j).getisComposite() == true){
                            globalComposite.removeitems(rectangles.get(j).getComposite());
                            rectangle.getComposite().removeitems(rectangles.get(j).getComposite());
                            rectangles.remove(j);
                            farm.getChildren().remove(j);
                            //If child has children
                            if(node.getChildren().get(i).getChildren().size() != 0){
                                //Delete all children of child
                                DeleteChildren(node.getChildren().get(i));
                            }
                        } else{
                            globalComposite.removeitems(rectangles.get(j).getLeaf());
                            rectangles.remove(j);
                        }
                    }
                }
            }
        }
    }

    @FXML
    void Rename(ActionEvent event) {
        //If the selected item is Root or the Command Center do not edit
        if(Choice1.equals("Root") || Choice1.equals("Command Center") || Choice1.equals("Drone")){
            editError();
        } else {
            //Create Stage
            Stage stage = new Stage();
            stage.setTitle("Rename" + Choice1);
            TextField textField = new TextField("Enter New Name");
            Button button = new Button("Rename");
            button.setOnAction(new EventHandler <ActionEvent>(){
                public void handle(ActionEvent event){
                    //Rename Rectangle
                    Choice3.setName(textField.getText());
                    //Rename Composite
                    if(Choice3.getisComposite() == true){
                        Choice3.getComposite().setCompName(textField.getText());
                    } else{
                        //Rename Leaf
                        Choice3.getLeaf().setName(textField.getText());
                    }
                    //Rename Tree Item
                    Choice2.setValue(textField.getText());
                    //Close Stage
                    stage.close();
                }
            });
            Pane pane = new VBox(textField, button);
            Scene sc = new Scene(pane, 200, 100);
            stage.setScene(sc);
            stage.show();
        }
    }

    @FXML
    void changeDimensions(ActionEvent event) {
        //Do not edit the Root or Command Center
        if(Choice1.equals("Root") || Choice1.equals("Command Center")){
            editError();
        } else {
            //Create Stage
            Stage stage = new Stage();
            stage.setTitle("Edit" + Choice1);
            TextField textFieldW = new TextField("Enter New Width");
            TextField textFieldH = new TextField("Enter New Height");
            Button button = new Button("Edit");
            button.setOnAction(new EventHandler <ActionEvent>(){
                public void handle(ActionEvent event){
                    //Edit composite
                    Choice3.getComposite().setCompWidth(Double.parseDouble(textFieldW.getText()));
                    Choice3.getComposite().setCompHeight(Double.parseDouble(textFieldH.getText()));

                    //Edit Rectangle
                    Choice3.setWidth(Double.parseDouble(textFieldW.getText()));
                    Choice3.setHeight(Double.parseDouble(textFieldH.getText()));
                    //Close Stage
                    stage.close();
                }
            });
            Pane pane = new VBox(textFieldW, textFieldH, button);
            Scene sc = new Scene(pane, 200, 100);
            stage.setScene(sc);
            stage.show();
        }

    }

    @FXML
    void changeLocation(ActionEvent event) {
        //Do not edit the Root or Command Center
        if(Choice1.equals("Root") || Choice1.equals("Command Center")){
            editError();
        } else {
            //Create Stage
            Stage stage = new Stage();
            stage.setTitle("Edit" + Choice1);
            TextField textFieldX = new TextField("Enter New X Coordinate");
            TextField textFieldY = new TextField("Enter New Y Coordinate");
            Button button = new Button("Edit");
            button.setOnAction(new EventHandler <ActionEvent>(){
                public void handle(ActionEvent event){
                    //Edit composite
                    Choice3.getComposite().setCompXcoordinate(Double.parseDouble(textFieldX.getText()));
                    Choice3.getComposite().setCompYcoordinate(Double.parseDouble(textFieldY.getText()));
                    //Edit Rectangle
                    Choice3.setX(Double.parseDouble(textFieldX.getText()));
                    Choice3.setY(Double.parseDouble(textFieldY.getText()));
                    
                    //Close Stage
                    stage.close();
                }
            });
            Pane pane = new VBox(textFieldX, textFieldY, button);
            Scene sc = new Scene(pane, 200, 100);
            stage.setScene(sc);
            stage.show();
        }

    }

    @FXML
    void changePrice(ActionEvent event) {
        //Do not edit the Root or Command Center
        if(Choice1.equals("Root") || Choice1.equals("Command Center")){
            editError();
        } else {
            //Create Stage
            Stage stage = new Stage();
            stage.setTitle("Edit" + Choice1);
            TextField textFieldPrice = new TextField("Enter New Price");
            Button button = new Button("Edit");
            button.setOnAction(new EventHandler <ActionEvent>(){
                public void handle(ActionEvent event){
                    //Edit composite
                    if(Choice3.getisComposite()){
                        Choice3.getComposite().setCompPrice(Double.parseDouble(textFieldPrice.getText()));
                    } else{
                        //Edit Leaf
                        Choice3.getLeaf().setPrice(Double.parseDouble(textFieldPrice.getText()));
                    }
                    //Close Stage
                    stage.close();
                }
            });
            Pane pane = new VBox(textFieldPrice, button);
            Scene sc = new Scene(pane, 200, 100);
            stage.setScene(sc);
            stage.show();
        }

    }

    @FXML
    void droneVisit(ActionEvent event) throws IOException, InterruptedException {
        if(SimMode){

            //get the x and y coordinates of the destination
            double x = getMiddleX(Choice3);
            double y = getMiddleY(Choice3);

            //Move the Corgicopter to the middle of the selected rectangle from the selected node in the tree
            repositionDrone(x, y);
        } else {

            TelloDroneAdapter drone = new TelloDroneAdapter();
            //get selected TreeView item and search through the globalcomposite for it
            //then send the drone to that location
            for(int i = 0; i < globalComposite.getItems().size(); i++){
                double x = getMiddleX(Choice3);
                double y = getMiddleY(Choice3);
                if (globalComposite.getItems().get(i) instanceof composite){
                    composite temp = (composite) globalComposite.getItems().get(i);
                    if(temp.getCompName().equals(Choice1)){

                        drone.goToItem(x, y);
                    }
                } else{
                    leaf temp = (leaf) globalComposite.getItems().get(i);
                    if(temp.getName().equals(Choice1)){
                        drone.goToItem(x, y);
                    }
                }
            }
        }
    }

    @FXML
    void goHome(ActionEvent event) {
        if(Corgicopter.getX() != droneHomex && Corgicopter.getY() != droneHomey){
            //Move the Corgicopter to the Command Center
            repositionDrone(droneHomex, droneHomey);
        }

    }

    @FXML
    void scanFarm(ActionEvent event) throws IOException, InterruptedException {
        if(SimMode){

            Path path = new Path();
            PathTransition pathTransition = new PathTransition();
            pathTransition.setDuration(Duration.millis(10000));
            pathTransition.setNode(Corgicopter);
            pathTransition.setPath(path);
            path.getElements().add(new MoveTo(Corgicopter.getX(), Corgicopter.getY()));
            path.getElements().add(new LineTo(25, 25));
            for(int i = 1; i < 10; i+=2){
                path.getElements().add(new LineTo(i*80, 600));
                path.getElements().add(new LineTo((i+1)*80, 25));
            }
            path.getElements().add(new LineTo(droneHomex, droneHomey));
            pathTransition.setCycleCount(1);
            pathTransition.setAutoReverse(false);
            pathTransition.play();
            Corgicopter.setX(droneHomex);
            Corgicopter.setY(droneHomey);
            Corgicopter.toFront();
        } else {
            TelloDroneAdapter drone = new TelloDroneAdapter();
            drone.scan();
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

    //Error Message for Adding a New Item to a Leaf
    void leafError(){
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Cannot Add to " + Choice1 + "!");
        alert.setContentText("You cannot add a new item to a leaf!");
        alert.showAndWait();
    }

    //Get middle x of rectangle
    double getMiddleX(Srectangle r){
        return r.getX() + r.getWidth()/2;
    }
    
    //Get middle y of rectangle
    double getMiddleY(Srectangle r){
        return r.getY() + r.getHeight()/2;
    }

    //Reposition the drone to the middle of the selected rectangle smoothly with an animation
    void repositionDrone(double x, double y){
        //move corgicopter image from behind the drone to in front of the drone
        Corgicopter.toFront();
        //create the animation
        PathTransition path = new PathTransition();
        path.setDuration(Duration.millis(2000));
        path.setNode(Corgicopter);
        path.setPath(new Line(Corgicopter.getX(), Corgicopter.getY(), x, y));
        path.play();
        //set Corgicopter x and y
        Corgicopter.setX(x);
        Corgicopter.setY(y);
    }

    private double calculatePrice(items r){
        double price = 0;
        CurrentItemVisitor visitor = new CurrentItemVisitorImpl();
        if(r instanceof composite){
            price += visitor.visit((composite) r);
            for(items i : ((composite) r).getItems()){
                price += calculatePrice(i);
            }
            
            
        } else {
            price += visitor.visit((leaf) r);
        }
        return price;
    }

    private double calculateMarketValue(items r){
        double marketValue = 0;
        CurrentMarketVisitor visitor = new CurrentMarketVisitorImpl();
        if(r instanceof composite){
            marketValue += visitor.visit((composite) r);
            for(items i : ((composite) r).getItems()){
                marketValue += calculateMarketValue(i);
            }
            
            
        } else {
            marketValue += visitor.visit((leaf) r);
        }
        return marketValue;
    }

    public boolean SimMode = true;
    public boolean LaunchMode = false;

    @FXML
    void Simulation(){
        //Set boolean value for Simulation mode to true. Set boolean value for launch mode to false
        SimMode = true;
        LaunchMode = false;
        //print mode to the screen
        System.out.println("Simulation Mode!");
        //Change Sim button to green
        Sim.setStyle("-fx-background-color: #00ff00");
        //Change Sim Text to black
        Sim.setTextFill(Color.BLACK);
        //Change Launch button to red
        Launch.setStyle("-fx-background-color: #ff0000");
        //Change Launch button text to white
        Launch.setTextFill(Color.WHITE);

    }

    @FXML
    void LaunchDrone(){
        //Set boolean value for Simulation mode to false. Set boolean value for launch mode to true
        SimMode = false;
        LaunchMode = true;
        //print mode to the screen
        System.out.println("Launch Mode!");
        //Change Launch button to green
        Launch.setStyle("-fx-background-color: #00ff00");
        //Change Launch text to black
        Launch.setTextFill(Color.BLACK);
        //Change Sim button to red
        Sim.setStyle("-fx-background-color: #ff0000");
        //chang sim button text to white
        Sim.setTextFill(Color.WHITE);
    }
                    
    


    @FXML
    private Label PurchasePrice;

    @FXML
    private Label MarketValue;

    @FXML
    private Button Sim;

    @FXML
    private Button Launch;
}
