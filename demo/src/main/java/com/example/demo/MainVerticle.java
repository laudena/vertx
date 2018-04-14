package com.example.demo;


import java.sql.Time;
import java.util.Date;
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
        //String msg = "Some news! (" + count.Next() + ")" ;
        
        vertx.setPeriodic(6000, v -> {
        	//String msg = "Some news! (" + count.Next() + ")" ;
        	//eb.publish("news-feed", msg);
        	//System.out.println("sent: " + msg);
        	Date d = new Date();
        	//System.out.println("starting... " + d.getTime() + " ......");
            for (int i=0; i<10000; i++) {
            	String msg = "Some news! (" + count.Next() + ")" ;
            	eb.publish("news-feed", msg);
            }
            eb.publish("news-feed", "done");
            System.out.println("DONE!!!!!!!!!!!!!!!!!!! " + d.getTime()+ " ......");
        	
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

