package temp;

import org.apache.catalina.loader.WebappLoader;
import org.apache.catalina.startup.Tomcat;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.util.ClassUtils;

public class Test_tomcat {

    public static void main(String[] args) {
        TomcatEmbeddedContext_temp context = new TomcatEmbeddedContext_temp();
        context.setName("");
        context.setDisplayName("application");
        context.setPath("");
        context.setDocBase("/var/folders/3x/nbm_bt5s22g9vtydr426f6fc0000gn/T/tomcat-docbase.7176326940808050890.8080");
        context.addLifecycleListener(new Tomcat.FixContextListener());
        context.setParentClassLoader(ClassUtils.getDefaultClassLoader());
        context.setUseRelativeRedirects(false);
        try {
            context.setCreateUploadTargets(true);
        } catch (NoSuchMethodError var8) {
        }
        WebappLoader loader = new WebappLoader(context.getParentClassLoader());
        context.setLoader(loader);
        // context.addLifecycleListener(new TomcatServletWebServerFactory.StaticResourceConfigurer(context));
    }

}
