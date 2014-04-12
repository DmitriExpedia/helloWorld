package com.expedia.hack;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Hashtable;
import java.util.Map;

import javax.management.JMException;
import javax.management.JMX;
import javax.management.MBeanServerConnection;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

import com.newtrade.polaris.statistics.hotel.jmx.PartnerMetricPublisher;
import com.newtrade.polaris.statistics.hotel.jmx.PartnerMetricPublisherMBean;

public class Dff {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NullPointerException 
	 * @throws JMException 
	 */
	public static void main(String[] args) throws IOException, NullPointerException, JMException {
		JMXServiceURL url =
	            new JMXServiceURL("service:jmx:rmi:///jndi/rmi://chelcondev004:8686/jmxrmi");//"jmx", "chelcondev004", 8686);
		Hashtable h = new Hashtable();
		String[] credentials = new String[] {"polarisJMXUser", "polarisJMXUser" }; 
		h.put("jmx.remote.credentials", credentials);
		JMXConnector jmxc = JMXConnectorFactory.connect(url, h);

		MBeanServerConnection mbsc = jmxc.getMBeanServerConnection();

	      System.out.println("Connected to DeploymentManager");
	      
	      
	      ObjectName mxbeanName =
	              new ObjectName("com.newtrade.polaris:type=hotel,name=EQC");
	      
	      PartnerMetricPublisherMBean p =
	              JMX.newMXBeanProxy(mbsc, mxbeanName, PartnerMetricPublisherMBean.class);
	      p.retrieveARICommMetrics(2L, new String[]{"RQOutNackedCount"});
	}

}
