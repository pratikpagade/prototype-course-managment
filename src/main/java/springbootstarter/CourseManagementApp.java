package springbootstarter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CourseManagementApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// why we are having a main method 
		//spring boot creates a stand alone spring application, by avoiding need of servlet container or 
		//does not need to be deployed on the server 
		
		//main method used to create and start the servlet container and then host that application 
		
		//how do we tell spring framework that it is a spring application using @annotations ? - @SpringBootApplication
		//this annotation tells that this is the starting point .
		
		// so springapplication STATIC class has method run() that takes in 2 arguments 
		//source - the class which is @annotated with springbootapplication - ie. here CourseManagementApp 
		
		SpringApplication.run(CourseManagementApp.class,args) ;
		//this creates our basic spring boot application.  
		
		//so what does SpringApplication.run() method exactly does
		 // - setup default configuration -( convention over configuration )
		 // - starts spring application context - ( context contains all business , controller services ,data services of the application)
		 // - performs class path scan - (depending on annotations of classes it identifies)
		 // - starts tomcat server- 
		
		
	}

}
