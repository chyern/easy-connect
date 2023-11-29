package chenyudan;

import chenyudan.process.ConnectProcessRouteSpi;
import chenyudan.proxy.ProxyInstance;

import java.util.ServiceLoader;

/**
 * Description: TODO
 *
 * @author chenyu
 * @since 2023/11/27 16:33
 */
public class ConnectRegister {

    public static final ServiceLoader<ProxyInstance> proxyInstances;

    public static final ServiceLoader<ConnectProcessRouteSpi> processRouteSpis;

    static {
        proxyInstances = register(ProxyInstance.class);
        processRouteSpis = register(ConnectProcessRouteSpi.class);
    }

    private static <T> ServiceLoader<T> register(Class<T> clazz) {
        return ServiceLoader.load(clazz);
    }


}
