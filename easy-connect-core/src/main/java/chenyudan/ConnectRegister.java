package chenyudan;

import chenyudan.process.ConnectProcessRouteSpi;
import chenyudan.process.ConnectProcessSpi;
import chenyudan.proxy.ConnectProxySpi;

import java.util.ServiceLoader;

/**
 * Description: TODO
 *
 * @author chenyu
 * @since 2023/11/27 16:33
 */
public class ConnectRegister {

    public static final ServiceLoader<ConnectProxySpi> proxySpis;
    public static final ServiceLoader<ConnectProcessSpi> processSpis;
    public static final ServiceLoader<ConnectProcessRouteSpi> processRouteSpis;


    static {
        proxySpis = register(ConnectProxySpi.class);
        processSpis = register(ConnectProcessSpi.class);
        processRouteSpis = register(ConnectProcessRouteSpi.class);
    }

    private static <T> ServiceLoader<T> register(Class<T> clazz) {
        return ServiceLoader.load(clazz);
    }


}
