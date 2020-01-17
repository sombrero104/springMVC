//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package temp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Stream;
import javax.servlet.ServletException;
import org.apache.catalina.Container;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.Manager;
import org.apache.catalina.Wrapper;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.core.StandardWrapper;
import org.apache.catalina.session.ManagerBase;
import org.springframework.boot.web.server.WebServerException;
import org.springframework.util.ClassUtils;

class TomcatEmbeddedContext_temp extends StandardContext {
    private TomcatStarter_temp starter;

    TomcatEmbeddedContext_temp() {
    }

    public boolean loadOnStartup(Container[] children) {
        return true;
    }

    public void setManager(Manager manager) {
        if (manager instanceof ManagerBase) {
            ((ManagerBase)manager).setSessionIdGenerator(new LazySessionIdGenerator_temp());
        }

        super.setManager(manager);
    }

    public void deferredLoadOnStartup() throws LifecycleException {
        this.doWithThreadContextClassLoader(this.getLoader().getClassLoader(), () -> {
            this.getLoadOnStartupWrappers(this.findChildren()).forEach(this::load);
        });
    }

    private Stream<Wrapper> getLoadOnStartupWrappers(Container[] children) {
        Map<Integer, List<Wrapper>> grouped = new TreeMap();
        Container[] var3 = children;
        int var4 = children.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            Container child = var3[var5];
            Wrapper wrapper = (Wrapper)child;
            int order = wrapper.getLoadOnStartup();
            if (order >= 0) {
                grouped.computeIfAbsent(order, ArrayList::new);
                ((List)grouped.get(order)).add(wrapper);
            }
        }

        return grouped.values().stream().flatMap(Collection::stream);
    }

    private void load(Wrapper wrapper) {
        try {
            wrapper.load();
        } catch (ServletException var4) {
            String message = sm.getString("standardContext.loadOnStartup.loadException", new Object[]{this.getName(), wrapper.getName()});
            if (this.getComputedFailCtxIfServletStartFails()) {
                throw new WebServerException(message, var4);
            }

            this.getLogger().error(message, StandardWrapper.getRootCause(var4));
        }

    }

    private void doWithThreadContextClassLoader(ClassLoader classLoader, Runnable code) {
        ClassLoader existingLoader = classLoader != null ? ClassUtils.overrideThreadContextClassLoader(classLoader) : null;

        try {
            code.run();
        } finally {
            if (existingLoader != null) {
                ClassUtils.overrideThreadContextClassLoader(existingLoader);
            }

        }

    }

    public void setStarter(TomcatStarter_temp starter) {
        this.starter = starter;
    }

    public TomcatStarter_temp getStarter() {
        return this.starter;
    }
}
