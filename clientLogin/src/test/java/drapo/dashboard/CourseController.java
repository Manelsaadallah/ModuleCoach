package drapo.dashboard;

import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.jfoenix.controls.JFXTextField;

import entities.Course;
import entities.User;
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
import services.RegisterRemote;

public class CourseController {
	@FXML
	private Button ajoutcours;
	@FXML
	private Button viewcourse;
	@FXML
	private Button deletecourse;
	
	@FXML
	private Button editcourse;
	@FXML
	private Button btnsearch;
	
	@FXML
	private DatePicker date;
	@FXML
	private TextField desc;
	@FXML
	private TextField id;
	@FXML
	private TextField search_field;
	
	@FXML
	private TableView<Course> userTable;

	@FXML
	private TableColumn<Course,String> colcoursedesc;
	@FXML
	private TableColumn<Course,Integer> Id_course;
	@FXML
	private TableColumn<Course,Date> colcoursedate;
	@FXML
    private List li;
	
	private ObservableList<Course> obs;

	
	

	@FXML
	public void ajoutcours(ActionEvent event)  throws NamingException {
	List<Course> li=null;
		Course e=new Course();
		//Course e =(Course) userTable.getSelectionModel().getSelectedItem();

	//Course e= (Course)userTable.getSelectionModel().getSelectedItem();;
	e.setAdded_at(java.sql.Date.valueOf(date.getValue()));
	e.setDescription(desc.getText());


	
		String jndiName="spectrum-ear/spectrum-ejb/Register!services.RegisterRemote";
		Context context = null;
		try {
			context = new InitialContext();
			
			

			
			
		} catch (NamingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		RegisterRemote proxy=(RegisterRemote) context.lookup(jndiName);
		proxy.addCourse(e);
		//setLi(proxy.findAll());
		 

		desc.clear();
		date.getEditor().clear();
		id.clear();

	//	System.out.println(java.sql.Date.valueOf(Dateprop_dp.getValue())+Timeprop_tf.getText()+type_cb.getItems().toString());
	}

	@FXML
	public void viewcourse(ActionEvent event)  throws NamingException {
		String jndiName="spectrum-ear/spectrum-ejb/Register!services.RegisterRemote";
		Context context;
		try {
			context = new InitialContext();
		
			RegisterRemote proxy=(RegisterRemote) context.lookup(jndiName);
	

		  
		 ObservableList<Course>obs = FXCollections.observableArrayList();
		// userTable.setItems(obs);
		 for (Course course : proxy.findAll()) {
			obs.add(course);
		}
		 colcoursedesc.setCellValueFactory(new PropertyValueFactory<>("description"));
		colcoursedate.setCellValueFactory(new PropertyValueFactory<>("added_at"));
		Id_course.setCellValueFactory(new PropertyValueFactory<>("id"));
		 userTable.setItems(obs);

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void insert(MouseEvent event)  throws NamingException {
		Course e =(Course) userTable.getSelectionModel().getSelectedItem();
		
		//e.setAdded_at(java.sql.Date.valueOf(date.getValue()));

		//date.setText(e.getAdded_at());
  		desc.setText(e.getDescription());
  		Id_course.setText(Integer.toString(e.getId()));
		
	}


	@FXML
	public void deletecourse(ActionEvent event)  throws NamingException {
	//	Course e=new Course();
		Course e =(Course) userTable.getSelectionModel().getSelectedItem();

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
		 ObservableList<Course>obs = FXCollections.observableArrayList();
			// userTable.setItems(obs);
			proxy.deletecourse(e);

			 for (Course course : proxy.findAll()) {
				obs.add(course);
			}
			 colcoursedesc.setCellValueFactory(new PropertyValueFactory<>("description"));
			colcoursedate.setCellValueFactory(new PropertyValueFactory<>("added_at"));
			Id_course.setCellValueFactory(new PropertyValueFactory<>("id"));
			 userTable.setItems(obs);
		//setLi(proxy.findAll());
		 

		//desc.clear();
		//date.getEditor().clear();
		//id.clear();

	//	System.out.println(java.sql.Date.valueOf(Dateprop_dp.getValue())+Timeprop_tf.getText()+type_cb.getItems().toString());
	}
	
	@FXML
	public void editcourse(ActionEvent event)  throws NamingException {
		//Course e=new Course();
	Course e =(Course) userTable.getSelectionModel().getSelectedItem();

	//Course e= (Course)userTable.getSelectionModel().getSelectedItem();;
	//e.setAdded_at(java.sql.Date.valueOf(date.getValue()));
	//e.setDescription(desc.getText());
	e.setAdded_at(java.sql.Date.valueOf(date.getValue()));
	e.setDescription(desc.getText());


	
		String jndiName="spectrum-ear/spectrum-ejb/Register!services.RegisterRemote";
		Context context = null;
		try {
			context = new InitialContext();
			
		
			
		} catch (NamingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		RegisterRemote proxy=(RegisterRemote) context.lookup(jndiName);
		 ObservableList<Course>obs = FXCollections.observableArrayList();
			// userTable.setItems(obs);
			proxy.updatecourse(e);

			 for (Course course : proxy.findAll()) {
				obs.add(course);
			}
			 colcoursedesc.setCellValueFactory(new PropertyValueFactory<>("description"));
			colcoursedate.setCellValueFactory(new PropertyValueFactory<>("added_at"));
			//Id_course.setCellValueFactory(new PropertyValueFactory<>("id"));
			 userTable.setItems(obs);
		//setLi(proxy.findAll());
		 

		//desc.clear();
		//date.getEditor().clear();
		//id.clear();

	//	System.out.println(java.sql.Date.valueOf(Dateprop_dp.getValue())+Timeprop_tf.getText()+type_cb.getItems().toString());
	}
	
	
	
	
	@FXML
	public void btnsearch(ActionEvent event)  throws NamingException {
		String jndiName="spectrum-ear/spectrum-ejb/Register!services.RegisterRemote";
		Context context;
		String fil=search_field.getText();
		try {
			context = new InitialContext();
		
			RegisterRemote proxy=(RegisterRemote) context.lookup(jndiName);
	

			//Course o=proxy.findBydesc(fil);
			
		
			
		 ObservableList<Course>obs = FXCollections.observableArrayList();
		// userTable.setItems(obs);
		 
		 for (Course course : proxy.findAll()) {

			obs.add(course);
		}
		 colcoursedesc.setCellValueFactory(new PropertyValueFactory<>("description"));
		colcoursedate.setCellValueFactory(new PropertyValueFactory<>("added_at"));
		Id_course.setCellValueFactory(new PropertyValueFactory<>("id"));
		 userTable.setItems(obs);

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
}
