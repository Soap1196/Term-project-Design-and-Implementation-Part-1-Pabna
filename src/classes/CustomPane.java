package classes;

import javafx.scene.layout.Pane;

public class CustomPane extends Pane{ 
        
    public static CustomPane paneObject; 
  
    
    public String s; 
  
    //Singleton
    public CustomPane() 
    { 
         
    } 

    public static CustomPane getInstance() 
    { 
        if (paneObject == null) {
            paneObject = new CustomPane(); 
        }
        return paneObject;
    } 
} 