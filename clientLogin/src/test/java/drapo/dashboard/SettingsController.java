package drapo.dashboard;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import entities.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import services.RegisterRemote;

public class SettingsController {
	 @FXML
     private JFXButton updatepara;
	    @FXML
		private JFXPasswordField current_password;
		@FXML
		private JFXPasswordField new_password;
		@FXML
		private JFXTextField current_email;
		@FXML
		private JFXTextField new_email;
		@FXML
		private JFXTextField current_username;
		@FXML
		private JFXTextField new_username;
		@FXML
		private Button exittohome;
	 
	 public void updatepara(ActionEvent event)  throws NamingException {
			User e= new User();
			e.setUsername(new_username.getText());
			e.setEmail(new_email.getText());
			e.setPassword(new_password.getText());
			

				String jndiName="spectrum-ear/spectrum-ejb/Register!services.RegisterRemote";
				Context context = null;
				try {
					context = new InitialContext();
				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				RegisterRemote proxy=(RegisterRemote) context.lookup(jndiName);
				proxy.updatepara(e);
				
			//	System.out.println(java.sql.Date.valueOf(Dateprop_dp.getValue())+Timeprop_tf.getText()+type_cb.getItems().toString());
			}
	 @FXML
		public void exittohome(ActionEvent event)  throws Exception {
			///////
			 Node node = (Node) event.getSource();
	         Stage stage = (Stage) node.getScene().getWindow();
	         stage.setMaximized(true);

	         stage.close();
	         ////////
				AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Home.fxml"));
				Stage primaryStage = new Stage();

				Scene scene = new Scene(root,1400,650);
			//	scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.show();
			
		//	System.out.println(java.sql.Date.valueOf(Dateprop_dp.getValue())+Timeprop_tf.getText()+type_cb.getItems().toString());
		}
	 
}
