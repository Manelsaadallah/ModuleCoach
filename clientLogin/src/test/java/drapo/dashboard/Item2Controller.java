package drapo.dashboard;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.Skill;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import services.RegisterRemote;

public class Item2Controller {
	@FXML
	private Button addskills;
	@FXML
	private Label labelskills;
	@FXML
	private TextField textskills;
	 @FXML
	 private DatePicker date;
	
	
	@FXML
	public void addskills(ActionEvent event)  throws NamingException {
	List<Skill> li=null;
	Skill e=new Skill();
	//java.sql.Date.valueOf(date.getValue())	;
	e.setLabel(textskills.getText());
	labelskills.setText(textskills.getText());

	
		String jndiName="spectrum-ear/spectrum-ejb/Register!services.RegisterRemote";
		Context context = null;
		try {
			context = new InitialContext();
			
			

			
			
		} catch (NamingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		RegisterRemote proxy=(RegisterRemote) context.lookup(jndiName);
		proxy.addskills(e);
		//setLi(proxy.findAll());
		 

		textskills.clear();
		
	//	System.out.println(java.sql.Date.valueOf(Dateprop_dp.getValue())+Timeprop_tf.getText()+type_cb.getItems().toString());
	}
}
