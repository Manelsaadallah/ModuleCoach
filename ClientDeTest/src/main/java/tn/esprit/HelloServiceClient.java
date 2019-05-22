package tn.esprit;
 
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.Course;
import entities.User;
import services.Register;
import services.RegisterRemote;
  
public class HelloServiceClient { 
 
	public static void main(String[] args) throws NamingException {
		String jndiName="spectrum-ear/spectrum-ejb/Register!services.RegisterRemote";

		try
		{
		Context context = new InitialContext();  
		RegisterRemote proxy=(RegisterRemote) context.lookup(jndiName);
		User e= new User();
		Course c= new Course();
		boolean b;
		System.out.println(proxy.usernamebase("aa"));
		
		/*e=proxy.getUserDetails(4);
		e.setEmail("kkkk");
		e.setUsername("kkkk"); 
		e.setPassword("kkkk"); 
*/
		//proxy.createCoach(e);
		//proxy.updateparameter("nnnnn",4);
         // proxy.login("coach" , "coach");
		
  		//List<Course> detailsList = proxy.findAll();
  		//System.out.println(detailsList);
		
		//c.setDescription("ooooo");

		//proxy.deletecourse(1);
		//proxy.updateUserDetails(e);

		}
	catch(NamingException e )
	{
		e.printStackTrace();
	}
	}
} 
 