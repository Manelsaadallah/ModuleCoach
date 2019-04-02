package application;

import java.net.URL;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import entities.Sexe;
import entities.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import services.RegisterRemote;


public class RegisterController implements Initializable{
	@FXML
	private JFXTextField firstname;
	@FXML
	private JFXTextField lastname;
	@FXML
	private JFXTextField email;
	@FXML
    private JFXTextField sexe;
	@FXML
	private JFXTextField phonenumber;
	@FXML
	private JFXPasswordField password;
	@FXML
	private JFXPasswordField confpassword;
	@FXML
	private JFXComboBox<String>  country;
	@FXML
	private JFXComboBox<String>  state;
	@FXML
	private JFXComboBox<String>  city;
	
	@FXML
	private JFXButton register;
	@FXML
	private JFXButton exit;
	@FXML
	private Label verifpass;
	 @FXML
	 private RadioButton rbMale;
	 @FXML
	 private RadioButton rbFemale;
	 @FXML
	 private DatePicker dob;
	@FXML
     private ComboBox<String> cbRole;


	// Event Listener on Button[#addDateprop].onAction
	@FXML
	public void register(ActionEvent event)  throws NamingException {
	User e= new User();
	e.setName(lastname.getText()+" "+firstname.getText());
	e.setUsername(firstname.getText());
    // e.setSexe(sexe.get());
	e.setEmail(email.getText());
	e.setPhone(phonenumber.getText());
	e.setPassword(password.getText());
	e.setPassword(confpassword.getText());
	e.setBirth(java.sql.Date.valueOf(dob.getValue()));
	//e.setRole(cbRole.getItems().toString());
	e.setAddress((country.getItems().toString())+" "+(state.getItems().toString())+" "+(city.getItems().toString()));
		String jndiName="spectrum-ear/spectrum-ejb/Register!services.RegisterRemote";
		Context context = null;
		try {
			context = new InitialContext();
		} catch (NamingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		verifpass.setText("");
		RegisterRemote proxy=(RegisterRemote) context.lookup(jndiName);
		if(!validation_Password(password.getText())){
			verifpass.setText("\r\n" + 
					"Error! password must contain at least 8 characters,lowercase, uppercase one digit,special character and no space.");
		
			 return ;

		}
		
		lastname.clear();
		firstname.clear();
		email.clear();
		password.clear();
		confpassword.clear();
		phonenumber.clear();

		dob.getEditor().clear();
		country.getSelectionModel().clearSelection();
		state.getSelectionModel().clearSelection();
		city.getSelectionModel().clearSelection();
		cbRole.getSelectionModel().clearSelection();

		
		rbFemale.setSelected(false);
		rbMale.setSelected(false);

		proxy.createCoach(e);
	
	//	System.out.println(java.sql.Date.valueOf(Dateprop_dp.getValue())+Timeprop_tf.getText()+type_cb.getItems().toString());
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		cbRole.getItems().setAll("Candidate","Coach", "Entreprise ");
		country.getItems().setAll("Tunisia","France", "Algeria ");
		state.getItems().setAll("Tunis","Sfax", "Sousse ");
		city.getItems().setAll("Ghazela","Lac", "Manzah ");

	}
	
	@FXML
	public void exit(ActionEvent event)  throws Exception {
		///////
		 Node node = (Node) event.getSource();
         Stage stage = (Stage) node.getScene().getWindow();
         stage.setMaximized(true);

         stage.close();
         ////////
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Login.fxml"));
			Stage primaryStage = new Stage();

			Scene scene = new Scene(root,1400,650);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		
	//	System.out.println(java.sql.Date.valueOf(Dateprop_dp.getValue())+Timeprop_tf.getText()+type_cb.getItems().toString());
	}
	private static boolean validation_Password(final String PASSWORD_Arg)    {
	    boolean result = false;
	    try {
	        if (PASSWORD_Arg!=null) {
	            //_________________________
	            //Parameteres
	            final String MIN_LENGHT="8";
	            final String MAX_LENGHT="20";
	            final boolean SPECIAL_CHAR_NEEDED=true;

	            //_________________________
	            //Modules
	            final String ONE_DIGIT = "(?=.*[0-9])";  //(?=.*[0-9]) a digit must occur at least once
	            final String LOWER_CASE = "(?=.*[a-z])";  //(?=.*[a-z]) a lower case letter must occur at least once
	            final String UPPER_CASE = "(?=.*[A-Z])";  //(?=.*[A-Z]) an upper case letter must occur at least once
	            final String NO_SPACE = "(?=\\S+$)";  //(?=\\S+$) no whitespace allowed in the entire string
	            //final String MIN_CHAR = ".{" + MIN_LENGHT + ",}";  //.{8,} at least 8 characters
	            final String MIN_MAX_CHAR = ".{" + MIN_LENGHT + "," + MAX_LENGHT + "}";  //.{5,10} represents minimum of 5 characters and maximum of 10 characters

	            final String SPECIAL_CHAR;
	            if (SPECIAL_CHAR_NEEDED==true) SPECIAL_CHAR= "(?=.*[@#$%^&+=])"; //(?=.*[@#$%^&+=]) a special character must occur at least once
	            else SPECIAL_CHAR="";
	            //_________________________
	            //Pattern
	            //String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
	            final String PATTERN = ONE_DIGIT + LOWER_CASE + UPPER_CASE + SPECIAL_CHAR + NO_SPACE + MIN_MAX_CHAR;
	            //_________________________
	            result = PASSWORD_Arg.matches(PATTERN);
	            //_________________________
	        }    

	    } catch (Exception ex) {
	        result=false;
	    }

	    return result;
	}  
	
	
	
	
	
}
