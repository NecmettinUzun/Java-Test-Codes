package jgroups;

public class Starter {

	public static void main(String[] args) {
		
		//int id = Integer.parseInt(args[0]);

		int id = 1;
		if(id == 1){
			InstanceInfo instanceInfo = new InstanceInfo();
			instanceInfo.setRole("MASTER");
			instanceInfo.setName("MASTER_S1");
			instanceInfo.setClusterName("TestCluster");
			AbstractInstance master = new Master(instanceInfo);
			master.startInstance();
		} else if (id == 2){
			InstanceInfo instanceInfo = new InstanceInfo();
			instanceInfo.setRole("SLAVE");
			instanceInfo.setName("SLAVE_S1");
			instanceInfo.setClusterName("TestCluster");
			Slave slave = new Slave(instanceInfo);
			slave.startInstance();
		}
	}

}
