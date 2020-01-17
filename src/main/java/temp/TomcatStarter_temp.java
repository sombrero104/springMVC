//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package temp;

import java.util.Set;
import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.web.servlet.ServletContextInitializer;

class TomcatStarter_temp implements ServletContainerInitializer {
    private static final Log logger = LogFactory.getLog(TomcatStarter_temp.class);
    private final ServletContextInitializer[] initializers;
    private volatile Exception startUpException;

    TomcatStarter_temp(ServletContextInitializer[] initializers) {
        this.initializers = initializers;
    }

    public void onStartup(Set<Class<?>> classes, ServletContext servletContext) throws ServletException {
        try {
            ServletContextInitializer[] var3 = this.initializers;
            int var4 = var3.length;

            for(int var5 = 0; var5 < var4; ++var5) {
                ServletContextInitializer initializer = var3[var5];
                initializer.onStartup(servletContext);
            }
        } catch (Exception var7) {
            this.startUpException = var7;
            if (logger.isErrorEnabled()) {
                logger.error("Error starting Tomcat context. Exception: " + var7.getClass().getName() + ". Message: " + var7.getMessage());
            }
        }

    }

    public Exception getStartUpException() {
        return this.startUpException;
    }
}
