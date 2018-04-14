package com.example.demo;


import java.util.Random;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.eventbus.EventBus;

public class MainVerticle extends AbstractVerticle {

    @Override
    public void start() throws Exception {
        
        EventBus eb = vertx.eventBus();

        // Send a message every second

        Random rand = new Random();
        Counter count = new Counter(); 
        vertx.setPeriodic(1000, v -> {
        	String msg = "Some news! (" + count.Next() + ")" ;
        	eb.publish("news-feed", msg);
        	System.out.println("sent: " + msg);
        	});
    	
    	
//    	vertx.createHttpServer().requestHandler(req -> {
//              req.response()
//                .putHeader("content-type", "text/plain")
//                .end("Hello from Vert.x!");
//            }).listen(8880);
//        System.out.println("HTTP server started on port 8880");
    }
    public class Counter{
    	int counter = 0;
    	public Counter() {}
    	public int Next()
    	{
    		counter++;
    		return counter;
    	}
    }
    
}

