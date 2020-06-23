package springbootstarter.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//create a new REST endpoint by creating a brand new Spring MVC controller.

//Controller will only work if it is the part of main class.
//Example : if main class is in 'package1' and controller is in 'package2', then it won't work.. 
//so controller must be in 'package1.anyname'

// https://docs.spring.io/spring-boot/docs/current/reference/html/using-spring-boot.html#using-boot-using-springbootapplication-annotation
//***READ ABOVE LINK**

@RestController //a spring mvc annotation - for creating a rest controller
				//rest controller means you can have methods in the class that are mapped to url requests
public class HelloController {
 
	@RequestMapping("/hello") // another spring mvc annotation 
	// the @Request Mapping maps only to the GET method by default. To map to other HTTP methods, you will have to specify 
	// it in the annotation 
	public String saysHi(){
		
		return "Hi" ;
		
	}
	
}
