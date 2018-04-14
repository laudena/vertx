package com.example.server1;


import java.util.Date;

import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue.Consumer;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.AsyncResult;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.core.eventbus.EventBus;

/*
 * @author <a href="http://tfox.org">Tim Fox</a>
 */
public class ListenerVerticle extends AbstractVerticle {

  // Convenience method so you can run it in your IDE
  public static void main(String[] args) {
    
  }


  @Override
  public void start() throws Exception {

	  String verticleID = "listener1";

//	    	  VertxOptions  options = new VertxOptions().setClustered(true);
//	    	  Consumer<Vertx> runner = vertx -> {
//	    	      try {
//	    	          vertx.deployVerticle(verticleID);
//	    	      } catch (Throwable t) {
//	    	        t.printStackTrace();
//	    	      }
//	    	    };
//	    	    if (options.isClustered()) {
//	    	      Vertx.clusteredVertx(options, res -> {
//	    	        if (res.succeeded()) {
//	    	          Vertx vertx = res.result();
//	    	          runner.accept(vertx);
//	    	        } else {
//	    	          res.cause().printStackTrace();
//	    	        }
//	    	      });
//	    	    }
	    	  
	          
    EventBus eb = vertx.eventBus();
    Boolean firstTime = true;
    
    eb.consumer("news-feed", message -> {
//    	if (firstTime)
//    		{
//    			System.out.println("Starting... " + d.getTime() + " ......");
//    			firstTime=false;
//    		}
    	Date d = new Date();
    	if (((String)message.body()).compareTo("done") == 0)
    		System.out.println("Received final msg on " + d.getTime());
    	
    });
    
    //eb.consumer("news-feed", message -> System.out.println("Received news on consumer 2: " + message.body()));
    
    //eb.consumer("news-feed", message -> System.out.println("Received news on consumer 3: " + message.body()));
    
    System.out.println("Ready!");
  }
  
}