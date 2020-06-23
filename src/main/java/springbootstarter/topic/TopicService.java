package springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

//business service - they are basically singletons i.e when the application starts up 
//spring creates an instance of this service and keeps that in its memory
//it registers that instance ..and when other classes need it then spring inserts this dependency into them


@Service //marks class a business service 
public class TopicService {

	List<Topic> topics = new ArrayList<>( Arrays.asList(new Topic("1","topic1","desc1"),
			new Topic("2","topic2","desc2"),
			new Topic("3","topic3","desc3")
			));		
	
	public List<Topic> getAllTopics(){
		return topics ;
	}
	
	public Topic getTopic( String id ) {
		
		// here using a lambda function to iterate over the list of topics and
		// compare each topic's id to the passed in id and if a match return that topic object 
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get() ;
								
	}
	
	public String addTopic( Topic topic ) {
		
		topics.add( topic ) ;
		return "topic added" ;
	}
	
	public String updateTopic( Topic topic , String id ) {
		
		for( int i = 0 ; i < topics.size() ; i++ ) {
			
			Topic t = topics.get(i) ;
			
			if( t.getId().equals(id)) {
				topics.set(i, topic );
				break;
			}
			
			
		}
		
		return "topic is updated ";
		
	}

	public String deleteTopic(String id) {
		// TODO Auto-generated method stub
		
		topics.removeIf( t-> t.getId().equals(id) ) ;
		
		return "topic is deleted";
	}
}
