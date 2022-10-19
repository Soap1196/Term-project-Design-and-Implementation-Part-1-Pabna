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

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("App.fxml"));
        Scene App = new Scene(root);
        stage.setScene(App);
        stage.show();

        // Item buttons
        Button deleteItem = new Button("Delete Item");
		Button changeNameItem = new Button("Change Name of Item");
		Button changePriceItem = new Button("Change Price of Item");
        Button changeXITem = new Button("Change Location-x of Item");
        Button changeYITem = new Button("Change Location-y of Item");
        Button changeLengthItem = new Button("Change Length of Item");
        Button changeWidthItem = new Button("Change Width of Item");
        Button changeHeightItem = new Button("Change Height of Item");

        // variables for items
        String nameString = "Item name";
        long itemPrice = 50;
        int xCoord = 50;
        int yCoord = 50;
        int length = 50;
        int weight = 50;
        int height = 50;
        String[] itemCollection;


        // set on action functions: 
        deleteItem.setOnAction(new EventHandler <ActionEvent>()
		{
            public void handle(ActionEvent event)
            {
            	// sequence.playFromStart();
            	// status.setText("Current State: " + sequence.getStatus());

            }
        });

        changeNameItem.setOnAction(new EventHandler <ActionEvent>()
		{
            public void handle(ActionEvent event)
            {
            	// sequence.playFromStart();
            	// status.setText("Current State: " + sequence.getStatus());
            }
        });

        changePriceItem.setOnAction(new EventHandler <ActionEvent>()
		{
            public void handle(ActionEvent event)
            {
            	// sequence.playFromStart();
            	// status.setText("Current State: " + sequence.getStatus());
            }
        });

        changeXITem.setOnAction(new EventHandler <ActionEvent>()
		{
            public void handle(ActionEvent event)
            {
            	// sequence.playFromStart();
            	// status.setText("Current State: " + sequence.getStatus());
            }
        });

        changeYITem.setOnAction(new EventHandler <ActionEvent>()
		{
            public void handle(ActionEvent event)
            {
            	// sequence.playFromStart();
            	// status.setText("Current State: " + sequence.getStatus());
            }
        });

        changeLengthItem.setOnAction(new EventHandler <ActionEvent>()
		{
            public void handle(ActionEvent event)
            {
            	// sequence.playFromStart();
            	// status.setText("Current State: " + sequence.getStatus());
            }
        });

        changeWidthItem.setOnAction(new EventHandler <ActionEvent>()
		{
            public void handle(ActionEvent event)
            {
            	// sequence.playFromStart();
            	// status.setText("Current State: " + sequence.getStatus());
            }
        });

        changeHeightItem.setOnAction(new EventHandler <ActionEvent>()
		{
            public void handle(ActionEvent event)
            {
            	// sequence.playFromStart();
            	// status.setText("Current State: " + sequence.getStatus());
            }
        });

    
        // Item Container buttons
        Button addItemContainer = new Button("Add Item Container");
        Button addItem = new Button("Add Item");
        Button deleteItemContainer = new Button("Delete Item Container");
        Button deleteItem2 = new Button("Delete Item (Item Container)");
		Button changeName2 = new Button("Change Name of Item Container");
		Button changePrice2 = new Button("Change Price of Item (Container)");
        Button changeX2 = new Button("Change Location-x of Item Container");
        Button changeY2 = new Button("Change Location-y of Item Container");
        Button changeLength2 = new Button("Change Length of Item Container");
        Button changeWidth2 = new Button("Change Width of Item Container");
        Button changeHeight2 = new Button("Change Height of Item Container");

        addItemContainer.setOnAction(new EventHandler <ActionEvent>()
		{
            public void handle(ActionEvent event)
            {
            	// sequence.playFromStart();
            	// status.setText("Current State: " + sequence.getStatus());
            }
        });

        addItem.setOnAction(new EventHandler <ActionEvent>()
		{
            public void handle(ActionEvent event)
            {
            	// sequence.playFromStart();
            	// status.setText("Current State: " + sequence.getStatus());
            }
        });

        deleteItemContainer.setOnAction(new EventHandler <ActionEvent>()
		{
            public void handle(ActionEvent event)
            {
            	// sequence.playFromStart();
            	// status.setText("Current State: " + sequence.getStatus());
            }
        });

        deleteItem2.setOnAction(new EventHandler <ActionEvent>()
		{
            public void handle(ActionEvent event)
            {
            	// sequence.playFromStart();
            	// status.setText("Current State: " + sequence.getStatus());
            }
        });

        changeName2.setOnAction(new EventHandler <ActionEvent>()
		{
            public void handle(ActionEvent event)
            {
            	// sequence.playFromStart();
            	// status.setText("Current State: " + sequence.getStatus());
            }
        });

        changePrice2.setOnAction(new EventHandler <ActionEvent>()
		{
            public void handle(ActionEvent event)
            {
            	// sequence.playFromStart();
            	// status.setText("Current State: " + sequence.getStatus());
            }
        });

        changeX2.setOnAction(new EventHandler <ActionEvent>()
		{
            public void handle(ActionEvent event)
            {
            	// sequence.playFromStart();
            	// status.setText("Current State: " + sequence.getStatus());
            }
        });

        changeY2.setOnAction(new EventHandler <ActionEvent>()
		{
            public void handle(ActionEvent event)
            {
            	// sequence.playFromStart();
            	// status.setText("Current State: " + sequence.getStatus());
            }
        });

        changeLength2.setOnAction(new EventHandler <ActionEvent>()
		{
            public void handle(ActionEvent event)
            {
            	// sequence.playFromStart();
            	// status.setText("Current State: " + sequence.getStatus());
            }
        });

        changeWidth2.setOnAction(new EventHandler <ActionEvent>()
		{
            public void handle(ActionEvent event)
            {
            	// sequence.playFromStart();
            	// status.setText("Current State: " + sequence.getStatus());
            }
        });

        changeHeight2.setOnAction(new EventHandler <ActionEvent>()
		{
            public void handle(ActionEvent event)
            {
            	// sequence.playFromStart();
            	// status.setText("Current State: " + sequence.getStatus());
            }
        });

    }   

    public static void main(String[] args) {
        launch(args);
    }
}