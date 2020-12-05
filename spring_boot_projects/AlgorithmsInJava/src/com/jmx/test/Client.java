package com.jmx.test;


import java.beans.ConstructorProperties;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

import javax.management.AttributeChangeNotification;
import javax.management.JMX;
import javax.management.MBeanServerConnection;
import javax.management.Notification;
import javax.management.NotificationListener;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

public class Client {

  /**
   * Inner class that will handle the notifications.
   */
  public static class ClientListener implements NotificationListener {
    public void handleNotification(Notification notification, Object handback) {
      echo("\nReceived notification:");
      echo("\tClassName: " + notification.getClass().getName());
      echo("\tSource: " + notification.getSource());
      echo("\tType: " + notification.getType());
      echo("\tMessage: " + notification.getMessage());
      if (notification instanceof AttributeChangeNotification) {
        AttributeChangeNotification acn = (AttributeChangeNotification) notification;
        echo("\tAttributeName: " + acn.getAttributeName());
        echo("\tAttributeType: " + acn.getAttributeType());
        echo("\tNewValue: " + acn.getNewValue());
        echo("\tOldValue: " + acn.getOldValue());
      }
    }
  }

  /*
   * For simplicity, we declare "throws Exception". Real programs will usually
   * want finer-grained exception handling.
   */
  public static void main(String[] args) throws Exception {
    // Create an RMI connector client and
    // connect it to the RMI connector server
    //
    echo("\nCreate an RMI connector client and "
        + "connect it to the RMI connector server");
    /*JMXServiceURL url = new JMXServiceURL(
        "service:jmx:rmi:///jndi/rmi://:9999/jmxrmi");*/
    JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://127.0.0.1:4434/jmxrmi");    
    JMXConnector jmxc = JMXConnectorFactory.connect(url, null);

    // Create listener
    //
    ClientListener listener = new ClientListener();

    // Get an MBeanServerConnection
    //
    echo("\nGet an MBeanServerConnection");
    MBeanServerConnection mbsc = jmxc.getMBeanServerConnection();
    waitForEnterPressed();

    // Get domains from MBeanServer
    //
    echo("\nDomains:");
    String domains[] = mbsc.getDomains();
    Arrays.sort(domains);
    for (String domain : domains) {
      echo("\tDomain = " + domain);
    }
    waitForEnterPressed();

    // Get MBeanServer's default domain
    //
    echo("\nMBeanServer default domain = " + mbsc.getDefaultDomain());

    // Get MBean count
    //
    echo("\nMBean count = " + mbsc.getMBeanCount());

    // Query MBean names
    //
    echo("\nQuery MBeanServer MBeans:");
    Set<ObjectName> names = new TreeSet<ObjectName>(mbsc.queryNames(null, null));
    for (ObjectName name : names) {
      echo("\tObjectName = " + name);
    }
    waitForEnterPressed();

    // ----------------------
    // Manage the Hello MBean
    // ----------------------

    echo("\n>>> Perform operations on Hello MBean <<<");

    // Construct the ObjectName for the Hello MBean
    //
    //ObjectName mbeanName = new ObjectName("com.example:type=Hello");
   // ObjectName mbeanName = new ObjectName("com.jmx.test:type=HelloMBean");

    // Create a dedicated proxy for the MBean instead of
    // going directly through the MBean server connection
    //
   /* HelloMBean mbeanProxy = JMX.newMBeanProxy(mbsc, mbeanName,
        HelloMBean.class, true);*/

    // Add notification listener on Hello MBean
    //
    echo("\nAdd notification listener...");
  //  mbsc.addNotificationListener(mbeanName, listener, null, null);

    // Get CacheSize attribute in Hello MBean
    //
   // echo("\nCacheSize = " + mbeanProxy.getCacheSize());

    // Set CacheSize attribute in Hello MBean
    // Calling "reset" makes the Hello MBean emit a
    // notification that will be received by the registered
    // ClientListener.
    //
   // mbeanProxy.setCacheSize(150);

    // Sleep for 2 seconds to have time to receive the notification
    //
    echo("\nWaiting for notification...");
    sleep(2000);

    // Get CacheSize attribute in Hello MBean
    //
    //echo("\nCacheSize = " + mbeanProxy.getCacheSize());

    // Invoke "sayHello" in Hello MBean
    //
    echo("\nInvoke sayHello() in Hello MBean...");
    //mbeanProxy.sayHello();

    // Invoke "add" in Hello MBean
    //
    echo("\nInvoke add(2, 3) in Hello MBean...");
   // echo("\nadd(2, 3) = " + mbeanProxy.add(2, 3));

    waitForEnterPressed();

    // ------------------------------
    // Manage the QueueSampler MXBean
    // ------------------------------

    echo("\n>>> Perform operations on QueueSampler MXBean <<<");

    // Construct the ObjectName for the QueueSampler MXBean
    //
    //ObjectName mxbeanName = new ObjectName("com.example:type=QueueSampler");
    ObjectName mxbeanName = new ObjectName("com.jmx.test:type=QueueSamplerMXBean");

    // Create a dedicated proxy for the MXBean instead of
    // going directly through the MBean server connection
    //
    QueueSamplerMXBean mxbeanProxy = JMX.newMXBeanProxy(mbsc, mxbeanName,
        QueueSamplerMXBean.class);

    // Get QueueSample attribute in QueueSampler MXBean
    //
    QueueSample queue1 = mxbeanProxy.getQueueSample();
    echo("\nQueueSample.Date = " + queue1.getDate());
    echo("QueueSample.Head = " + queue1.getHead());
    echo("QueueSample.Size = " + queue1.getSize());

    // Invoke "clearQueue" in QueueSampler MXBean
    //
    echo("\nInvoke clearQueue() in QueueSampler MXBean...");
    mxbeanProxy.clearQueue();

    // Get QueueSample attribute in QueueSampler MXBean
    //
    QueueSample queue2 = mxbeanProxy.getQueueSample();
    echo("\nQueueSample.Date = " + queue2.getDate());
    echo("QueueSample.Head = " + queue2.getHead());
    echo("QueueSample.Size = " + queue2.getSize());

    waitForEnterPressed();

    // Close MBeanServer connection
    //
    echo("\nClose the connection to the server");
    jmxc.close();
    echo("\nBye! Bye!");
  }

  private static void echo(String msg) {
    System.out.println(msg);
  }

  private static void sleep(int millis) {
    try {
      Thread.sleep(millis);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  private static void waitForEnterPressed() {
    try {
      echo("\nPress <Enter> to continue...");
      System.in.read();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

/*
 * HelloMBean.java - MBean interface describing the management operations and
 * attributes for the Hello World MBean. In this case there are two operations,
 * "sayHello" and "add", and two attributes, "Name" and "CacheSize".
 */

interface HelloMBean1 {
  // -----------
  // operations
  // -----------

  public void sayHello();

  public int add(int x, int y);

  // -----------
  // attributes
  // -----------

  // a read-only attribute called Name of type String
  public String getName();

  // a read-write attribute called CacheSize of type int
  public int getCacheSize();

  public void setCacheSize(int size);
}

/*
 * QueueSample.java - Java type representing a snapshot of a given queue. It
 * bundles together the instant time the snapshot was taken, the queue size and
 * the queue head.
 */

interface QueueSamplerMXBean1 {
  public QueueSample getQueueSample();

  public void clearQueue();
}

class QueueSample1 {

  private final Date date;
  private final int size;
  private final String head;
  
  
  
  @ConstructorProperties( { "date", "size", "head" })
  public QueueSample1(Date date, int size, String head) {
    this.date = date;
    this.size = size;
    this.head = head;
  }
  
  public Date getDate() {	 
    return date;
  }

  public int getSize() {
    return size;
  }

  public String getHead() {
    return head;
  }
  /**
  private static  String head1;
 private static  class QueueSamplerMXBean12 {
	  public QueueSample getQueueSample(){return null;};
	  
	  public void clearQueue(){
		  head1 = "10"; 
	  }; 	  
	}  **/
}