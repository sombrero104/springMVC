package temp;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.LifecycleState;
import org.apache.catalina.util.StandardSessionIdGenerator;

class LazySessionIdGenerator_temp extends StandardSessionIdGenerator {
    LazySessionIdGenerator_temp() {
    }

    protected void startInternal() throws LifecycleException {
        this.setState(LifecycleState.STARTING);
    }
}
