package test;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class Test_Tomcat {

    public static void main(String[] args) throws LifecycleException {
        // String protocol = "org.apache.coyote.http11.Http11NioProtocol";
        Tomcat tomcat = new Tomcat();
        tomcat.start();
    }

}
