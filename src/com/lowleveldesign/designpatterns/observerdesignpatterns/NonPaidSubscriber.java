package com.lowleveldesign.designpatterns.observerdesignpatterns;

public class NonPaidSubscriber implements Subscriber{

	@Override
	public void notifySubscriber(String contentTitle) {
		System.out.println("Social App has a new content- "+ contentTitle + " for you! Please get a subscription to view all the videos of the user! ");
		
	}

}
