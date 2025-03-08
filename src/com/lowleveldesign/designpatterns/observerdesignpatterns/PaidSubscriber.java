package com.lowleveldesign.designpatterns.observerdesignpatterns;

public class PaidSubscriber implements Subscriber{

	@Override
	public void notifySubscriber(String contentTitle) {
		System.out.println("SocialApp has a new content - "+ contentTitle +" for you! Please click on the link to view it!");
	}

}
