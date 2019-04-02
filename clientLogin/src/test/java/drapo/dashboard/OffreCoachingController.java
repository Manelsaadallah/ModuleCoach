package drapo.dashboard;

import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.Coaching;
import entities.Course;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
//import javafx.scene.control.cell.PropertyValueFactory;
import services.RegisterRemote;

public class OffreCoachingController {
	@FXML
	private Button ajoutcoaching;
	@FXML
	private Button editcoaching;
	
	@FXML
	private DatePicker date;
	@FXML
	private DatePicker date1;
	@FXML
	private TextField title;
	@FXML
	private TextField idcoach;
	@FXML
    private List li;
	
	private ObservableList obs;
	
	@FXML
	private TableView<Coaching> tablecoaching;

	@FXML
	private TableColumn<Coaching,Integer> colcode;

	@FXML
	private TableColumn<Coaching,String> coltitle;

	@FXML
	private TableColumn<Coaching,Date> colstart;

	@FXML
	private TableColumn<Coaching,Date> colend;
	@FXML
	private Button viewcoaching;
	
	@FXML
	public void ajoutcoaching(ActionEvent event)  throws NamingException {
	Coaching e= new Coaching();
	e.setStart(java.sql.Date.valueOf(date.getValue()));
	e.setEnd(java.sql.Date.valueOf(date1.getValue()));

	e.setTitle(title.getText());
	
	title.clear();
	date.getEditor().clear();
	date1.getEditor().clear();
	idcoach.clear();


		String jndiName="spectrum-ear/spectrum-ejb/Register!services.RegisterRemote";
		Context context = null;
		try {
			context = new InitialContext();
		} catch (NamingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		RegisterRemote proxy=(RegisterRemote) context.lookup(jndiName);
		proxy.addoffCoaching(e);
	
	//	System.out.println(java.sql.Date.valueOf(Dateprop_dp.getValue())+Timeprop_tf.getText()+type_cb.getItems().toString());
	}
	
	
	

	@FXML
	public void viewcoaching(ActionEvent event)  throws NamingException {
		String jndiName="spectrum-ear/spectrum-ejb/Register!services.RegisterRemote";
		Context context;
		try {
			context = new InitialContext();
		
			RegisterRemote proxy=(RegisterRemote) context.lookup(jndiName);
	

		  
		 ObservableList<Coaching>obs = FXCollections.observableArrayList();
		// userTable.setItems(obs);
		 for (Coaching coaching : proxy.findAllcoaching()) {
			obs.add(coaching);
		}
		 coltitle.setCellValueFactory(new PropertyValueFactory<>("title"));
		 colstart.setCellValueFactory(new PropertyValueFactory<>("start"));
		 colend.setCellValueFactory(new PropertyValueFactory<>("end"));
		colcode.setCellValueFactory(new PropertyValueFactory<>("id"));

		tablecoaching.setItems(obs);

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	
	@FXML
	public void deletecoaching(ActionEvent event)  throws NamingException {
	//	Course e=new Course();
		Coaching e =(Coaching) tablecoaching.getSelectionModel().getSelectedItem();

	//Course e= (Course)userTable.getSelectionModel().getSelectedItem();;
	//e.setAdded_at(java.sql.Date.valueOf(date.getValue()));
	//e.setDescription(desc.getText());


	
		String jndiName="spectrum-ear/spectrum-ejb/Register!services.RegisterRemote";
		Context context = null;
		try {
			context = new InitialContext();
			
		
			
		} catch (NamingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		RegisterRemote proxy=(RegisterRemote) context.lookup(jndiName);
		 ObservableList<Coaching>obs = FXCollections.observableArrayList();
			// userTable.setItems(obs);
			proxy.deletecoaching(e);
			 for (Coaching coaching : proxy.findAllcoaching()) {
					obs.add(coaching);
				}
			
			 coltitle.setCellValueFactory(new PropertyValueFactory<>("title"));
			 colstart.setCellValueFactory(new PropertyValueFactory<>("start"));
			 colend.setCellValueFactory(new PropertyValueFactory<>("end"));
			colcode.setCellValueFactory(new PropertyValueFactory<>("id"));

			tablecoaching.setItems(obs);
			title.clear();
			date.getEditor().clear();
			date1.getEditor().clear();
			idcoach.clear();
	}
	
	
	@FXML
	public void editcoaching(ActionEvent event)  throws NamingException {
		//Course e=new Course();
	Coaching e =(Coaching) tablecoaching.getSelectionModel().getSelectedItem();

	e.setStart(java.sql.Date.valueOf(date.getValue()));
	e.setEnd(java.sql.Date.valueOf(date1.getValue()));

	e.setTitle(title.getText());


	
		String jndiName="spectrum-ear/spectrum-ejb/Register!services.RegisterRemote";
		Context context = null;
		try {
			context = new InitialContext();
			
		
			
		} catch (NamingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		RegisterRemote proxy=(RegisterRemote) context.lookup(jndiName);
		 ObservableList<Coaching>obs = FXCollections.observableArrayList();
			// userTable.setItems(obs);
			proxy.updatecoaching(e);

			 for (Coaching coaching : proxy.findAllcoaching()) {
				obs.add(coaching);
			}
			 coltitle.setCellValueFactory(new PropertyValueFactory<>("title"));
			 colstart.setCellValueFactory(new PropertyValueFactory<>("start"));
			 colend.setCellValueFactory(new PropertyValueFactory<>("end"));
			//colcode.setCellValueFactory(new PropertyValueFactory<>("id"));

			tablecoaching.setItems(obs);
	}
	
	public void tablecoaching(MouseEvent event)  throws NamingException {
		Coaching e =(Coaching) tablecoaching.getSelectionModel().getSelectedItem();
		
  		title.setText(e.getTitle());
  		idcoach.setText(Integer.toString(e.getId()));
		
	}
	
	
	
}
