package jgroups;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.jgroups.Message;
import org.jgroups.View;

public class Master extends AbstractInstance {

	
	public Master(InstanceInfo instanceInfo) {
		super(instanceInfo);
	}


	
	@Override
	public void viewAccepted(View new_view) {

	    System.out.println("** view: " + new_view);

	}
	
	@Override
	public void receive(Message msg) {

	    System.out.println(msg.getSrc() + ": " + msg.getObject());

	}


	@Override
	public void eventLoop() {
		
	    BufferedReader in=new BufferedReader(new InputStreamReader(System.in));

	    while(true) {

	        try {

	            System.out.print("> "); System.out.flush();

	            String line=in.readLine().toLowerCase();

	            if(line.startsWith("quit") || line.startsWith("exit"))

	                break;

	            line="[" + instanceInfo.getName() + "] " + line;

	            Message msg=new Message(null, line);

	            jChannel.send(msg);

	        }

	        catch(Exception e) {

	        }

	    }
		
	}



	@Override
	public void startInstance() {
		
		start();
		if(jChannel.isConnected()){
			System.out.println(instanceInfo.getRole() + " is connected, starting evetLoop");
			eventLoop();
			jChannel.close();
		}
	}
}
