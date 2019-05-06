/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drapo.dashboard;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.jboss.sasl.util.UsernamePasswordHashUtil;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.NodeOrientation;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author oXCToo
 */
public class HomeController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private Label coachname;
   
      @FXML
    private VBox pnl_scroll;

      @FXML
      private JFXButton btninformation;
      @FXML
      private JFXButton btncontacts;
      @FXML
      private JFXButton btngroups;
      @FXML
      private JFXButton btnevents;
      @FXML
      private JFXButton btnactivity;
      @FXML
      private JFXButton settings;
      @FXML
      private JFXButton btncourse;
      @FXML
      private JFXButton btnoffer;
      
      @FXML
      private Pane pnlinfo;
      @FXML
      private Pane pnlcont;
      @FXML
      private Pane pnlgroup;
      @FXML
      private Pane pnlevent;
      @FXML
      private JFXButton logout;
      
      
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         refreshNodes();
    }    
    
    private void refreshNodes()
    {
        pnl_scroll.getChildren().clear();
        
        Node [] nodes = new  Node[15];
        
      // for(int i = 0; i<10; i++)
       // {
            try {
                nodes[0] = (Node)FXMLLoader.load(getClass().getResource("Item.fxml"));
               pnl_scroll.getChildren().add(nodes[0]);
               nodes[1] = (Node)FXMLLoader.load(getClass().getResource("Item2.fxml"));
               pnl_scroll.getChildren().add(nodes[1]);
               nodes[2] = (Node)FXMLLoader.load(getClass().getResource("Item3.fxml"));
               pnl_scroll.getChildren().add(nodes[2]);
               nodes[3] = (Node)FXMLLoader.load(getClass().getResource("Item4.fxml"));
               pnl_scroll.getChildren().add(nodes[3]);
               nodes[4] = (Node)FXMLLoader.load(getClass().getResource("Item5.fxml"));
               pnl_scroll.getChildren().add(nodes[4]);
               nodes[5] = (Node)FXMLLoader.load(getClass().getResource("Item6.fxml"));
               pnl_scroll.getChildren().add(nodes[5]);
               nodes[6] = (Node)FXMLLoader.load(getClass().getResource("Item7.fxml"));
               pnl_scroll.getChildren().add(nodes[6]);
            } catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
           
        //} 
           
    }
    
    

    public void handleClicks(ActionEvent actionEvent) throws IOException {
    	
    	 if (actionEvent.getSource() == btninformation) {
             refreshNodes();

         }
       if (actionEvent.getSource() == btncontacts) {
    	   pnl_scroll.getChildren().clear();
           
           Node [] nodes = new  Node[15];
           
          for(int i = 0; i<10; i++)
           {
               try {
                   nodes[0] = (Node)FXMLLoader.load(getClass().getResource("contacts1.fxml"));
                  pnl_scroll.getChildren().add(nodes[0]);
              
               } catch (IOException ex) {
                   Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
      }
      
       
       if (actionEvent.getSource() == btngroups) {
   pnl_scroll.getChildren().clear();
           
           Node [] nodes = new  Node[15];
           
          for(int i = 0; i<10; i++)
           {
               try {
                   nodes[0] = (Node)FXMLLoader.load(getClass().getResource("groups1.fxml"));
                  pnl_scroll.getChildren().add(nodes[0]);
              
               } catch (IOException ex) {
                   Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
       }
      
        if (actionEvent.getSource() == btnevents) {
        	pnl_scroll.getChildren().clear();
            
            Node [] nodes = new  Node[15];
        	 nodes[0] = (Node)FXMLLoader.load(getClass().getResource("events1.fxml"));
             pnl_scroll.getChildren().add(nodes[0]);
         
        }
        

        if (actionEvent.getSource() == btncourse) {
        	pnl_scroll.getChildren().clear();
            
            Node [] nodes = new  Node[15];
        	 nodes[0] = (Node)FXMLLoader.load(getClass().getResource("course1.fxml"));
             pnl_scroll.getChildren().add(nodes[0]);
         
        }
        if (actionEvent.getSource() == btnoffer) {
        	pnl_scroll.getChildren().clear();
            
            Node [] nodes = new  Node[15];
        	 nodes[0] = (Node)FXMLLoader.load(getClass().getResource("OffreCoaching1.fxml"));
             pnl_scroll.getChildren().add(nodes[0]);
         
        }
        /* 
        if(actionEvent.getSource()==btnevents)
        {
        	pnlevent.setStyle("-fx-background-color : #464F67");
        	pnlevent.toFront();
        }*/
    }
    
    
    
    
    @FXML
	public void logout(ActionEvent event)  throws Exception {
		///////
		 Node node = (Node) event.getSource();
         Stage stage = (Stage) node.getScene().getWindow();
         stage.setMaximized(true);

         stage.close();
         ////////
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/application/Login.fxml"));
			Stage primaryStage = new Stage();

			Scene scene = new Scene(root,1400,650);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		
	//	System.out.println(java.sql.Date.valueOf(Dateprop_dp.getValue())+Timeprop_tf.getText()+type_cb.getItems().toString());
	}
    @FXML
  	public void settings(ActionEvent event)  throws Exception {
  		///////
  		 Node node = (Node) event.getSource();
           Stage stage = (Stage) node.getScene().getWindow();
           stage.setMaximized(true);

           stage.close();
           ////////
  			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/drapo/dashboard/Settings.fxml"));
  			Stage primaryStage = new Stage();

  			Scene scene = new Scene(root,1400,650);
  			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
  			primaryStage.setScene(scene);
  			primaryStage.show();
  		
  	//	System.out.println(java.sql.Date.valueOf(Dateprop_dp.getValue())+Timeprop_tf.getText()+type_cb.getItems().toString());
  	}
    
    
    
    
    
    
    
    
    
}
