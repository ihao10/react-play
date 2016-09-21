package modules.bindings;

import com.google.inject.AbstractModule;

import javax.management.MBeanServerConnection;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import java.io.IOException;
import java.net.MalformedURLException;

public class JmxModule extends AbstractModule {

  @Override
  protected void configure() {
    // TODO 需要缓存所有服务器节点信息
    // 这边先搞一个测试下

    try {


      JMXServiceURL jmxUrl = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://:9999/jmxrmi");

      JMXConnector jmxc = JMXConnectorFactory.connect(jmxUrl, null);

      MBeanServerConnection mbsc = jmxc.getMBeanServerConnection();

      for (String domain : mbsc.getDomains()) {

        System.out.println(domain);

      }


    } catch (IOException e) {
      e.printStackTrace();
    }


  }
}
