package jgroups;

import org.jgroups.JChannel;
import org.jgroups.Message;
import org.jgroups.Receiver;
import org.jgroups.View;
import org.jgroups.blocks.cs.ReceiverAdapter;

public abstract class AbstractInstance extends ReceiverAdapter implements Receiver{

	public JChannel jChannel;
	public InstanceInfo instanceInfo;
	public AbstractInstance(InstanceInfo instanceInfo) {
		this.instanceInfo = instanceInfo;
	}
	
	public void start() {
		try {
			System.out.println("My role: " + instanceInfo.getRole());
			jChannel = new JChannel("src/main/resources/udp.xml"); // use the default config, udp.xml
			jChannel.connect(instanceInfo.getClusterName()); 
			jChannel.setReceiver(this);
			//eventLoop();
			//jChannel.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public abstract void eventLoop();
	public abstract void startInstance();
	
	public void viewAccepted(View new_view) {

	    System.out.println("** view: " + new_view);

	}


	public void receive(Message msg) {

	    System.out.println(msg.getSrc() + ": " + msg.getObject());

	}
}
