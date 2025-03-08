package com.lowleveldesign.designpatterns.observerdesignpatterns;

public class App {

	public static void main(String[] args) {
		// Here Social App is the Subject/ observerable! All others are -> paid, nonpaid, anonymous, lambda, etc. are the one to many (list of dependents) observers
		SocialApp youtube = new SocialApp();
		youtube.subscribe(new PaidSubscriber());
		youtube.subscribe(new NonPaidSubscriber());
		youtube.uploadContent("A sample On Observer Pattern ! ");
		// Subscriber has only one method that is notifySubscribers. Therefore it can be implemented through Anonymous class as well.
		youtube.subscribe(new Subscriber() {
				@Override
				public void notifySubscriber(String contentTitle) {
					System.out.println("SocialApp has notification for the anonymous users - " + contentTitle);
				}
		});
		
		
		
		// Implement through lambda expression.
		youtube.subscribe((String contentTitle)->{
			System.out.println("SocialApp has notification for the Lambda users - " + contentTitle);
		});
		
		youtube.uploadContent("How to Focus on LLD !");
	}

}
