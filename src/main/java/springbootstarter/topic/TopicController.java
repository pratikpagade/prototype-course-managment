package springbootstarter.topic;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//Return a JSON payload from your REST API endpoint by returning objects from your Spring MVC
// everything gets converted to json since we are using restcontroller annotation 

@RestController
public class TopicController {

	@Autowired // how do I access the business service instance 
			   // ie how do I inject the dependency or tell spring to do it 
			   // @Autowired tells spring that it needs the instance of TopiCService to be injected here
	private TopicService topicService ; 
	
	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {
		
		return topicService.getAllTopics() ;	//calls TopicService singleton class method..so no need of 
												//creation of list all the time since its singleton
	}
	
	@RequestMapping("/topics/{id}")	// @RequestMapping("/topics/id") the id part here is variable and will depend upon incoming
									// request .. so to make it a variable we use {} brackets
									// so now spring knows its a variable portion ie. id 
									// now you need to tell spring to map the variable portion to the id passed into
									// the function getTopic( String id ) so we @annotate it by @PathVariable
									// this tells spring that it is a value that is mapped to the variable in the given path
	public Topic getTopic( @PathVariable String id ) {	
		
		return topicService.getTopic( id ) ;
	}
	
	//POST REST API work using Spring MVC
	
	@RequestMapping(method=RequestMethod.POST , value = "/topics") // tells spring to map post request having url as /topics
																   // also you can use
																   // @PostMapping(value = "/topics")
	public String addTopic( @RequestBody Topic topic ) {
		//@RequestBody tells spring mvc that your payload is going to contain a json representation of the Topic instance
		//so map it to the topic reference variable .
		
		return topicService.addTopic(topic); 
			
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/topics/{id}")
	public String updateTopic(@RequestBody Topic topic ,@PathVariable String id ) {
		
		return topicService.updateTopic(  topic ,  id ) ;
	}
	
	@DeleteMapping(value="/topics/{id}")
	public String deleteTopic( @PathVariable String id ) {
		
		return topicService.deleteTopic( id ) ;
		
	}
	
}
