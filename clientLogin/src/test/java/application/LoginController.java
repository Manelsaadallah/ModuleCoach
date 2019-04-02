package application;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import services.RegisterRemote;


public class LoginController implements Initializable {
	@FXML
	private TextField username;
	@FXML
	private PasswordField password;
	
	@FXML
	private Button log;
	@FXML
	private Button signup;
	
	
	@FXML
	private Label lblStatus;

	@FXML
	public void Login(ActionEvent event)  throws NamingException, IOException {
	User e= new User();
	
	 if (event.getSource() == log) {
         //login here
         if (logIn().equals("Success")) {
        	 try {

                 //add you loading or delays - ;-)
                 Node node = (Node) event.getSource();
                 Stage stage = (Stage) node.getScene().getWindow();
                 //stage.setMaximized(true);
                 stage.close();
                 Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/drapo/dashboard/Home.fxml")));
                 stage.setScene(scene);
                 stage.show();

             } catch (IOException ex) {
                 System.err.println(ex.getMessage());
             }
         }
     }

		String jndiName="spectrum-ear/spectrum-ejb/Register!services.RegisterRemote";
		Context context = null;
		try {
			context = new InitialContext();
			
			
		} catch (NamingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		RegisterRemote proxy=(RegisterRemote) context.lookup(jndiName);
		proxy.createCoach(e);
	
	//	System.out.println(java.sql.Date.valueOf(Dateprop_dp.getValue())+Timeprop_tf.getText()+type_cb.getItems().toString());
	}
	
	
	@FXML
	public void SignUP(ActionEvent event)  throws Exception {
		///////
		 Node node = (Node) event.getSource();
         Stage stage = (Stage) node.getScene().getWindow();
         stage.setMaximized(true);

         stage.close();
         ////////
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Register.fxml"));
			Stage primaryStage = new Stage();

			Scene scene = new Scene(root,1400,650);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		
	//	System.out.println(java.sql.Date.valueOf(Dateprop_dp.getValue())+Timeprop_tf.getText()+type_cb.getItems().toString());
	}
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	
    //we gonna use string to check for status
    private String logIn() {
    	User e= new User();

        String usernamee = username.getText();
        String passwordd = password.getText();

        //query
       // String sql = "SELECT * FROM User Where username = ? and password = ?";

        try {
           
            if (username.getText().equals(e.getUsername())&& password.getText().equals(e.getPassword())) {
            	
            	lblStatus.setTextFill(Color.GREEN);
            	lblStatus.setText("Login Successful..Redirecting..");
                System.out.println("Successfull Login");
                return "Success";
            	
            	
            } else {
            	lblStatus.setTextFill(Color.TOMATO);
            	lblStatus.setText("Enter Correct Username/Password");
                System.err.println("Wrong Logins --///");
                return "Error";
            }

        } catch ( Exception e1) {
            System.err.println(e1.getMessage());
            return "Exception";
        }

    }
}
