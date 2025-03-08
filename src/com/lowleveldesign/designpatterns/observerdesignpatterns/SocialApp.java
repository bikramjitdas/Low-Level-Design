package com.lowleveldesign.designpatterns.observerdesignpatterns;

import java.util.ArrayList;
import java.util.List;

// Observable --> will have a list of subscribers
// Who are subscribers, who have implemented the subscribe class
public class SocialApp {
	List<Subscriber> subscribers;
	
	// step 1: SocialApp should get initialized with the list of subscribers first
	SocialApp(){
		this.subscribers = new ArrayList<>();
	}
	
	// Step 2: How will the subscribers get added? When they hit the subscribe button!
	public void subscribe(Subscriber subscriber) {
		subscribers.add(subscriber);
	}
	
	// Step 3: This class should have a uploadContent method which will always notify all the subscribers whenever there is an upload from the user. So there should be a notify method for the both paid and non paid subscribers. 
	public void uploadContent(String contentTitle){
		subscribers.stream().forEach(subscriber-> subscriber.notifySubscriber(contentTitle));
	}
	
}
