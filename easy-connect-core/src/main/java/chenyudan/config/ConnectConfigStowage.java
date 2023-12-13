package chenyudan.config;

import chenyudan.domain.ConnectConfig;
import chenyudan.process.ConnectProcessRouteSpi;
import chenyudan.process.ConnectProcessSpi;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;

/**
 * Description: TODO
 *
 * @author chenyu
 * @since 2023/12/13 19:57
 */
public class ConnectConfigStowage {

    public Map<Class, ConnectConfig> cacheConfigMap = new HashMap<>();

    public static final ServiceLoader<ConnectProcessSpi> processSpis;
    public static final ServiceLoader<ConnectProcessRouteSpi> processRouteSpis;


    static {
        processSpis = register(ConnectProcessSpi.class);
        processRouteSpis = register(ConnectProcessRouteSpi.class);
    }

    private static <T> ServiceLoader<T> register(Class<T> clazz) {
        return ServiceLoader.load(clazz);
    }

    public static ConnectConfig autoConfigStowage(Object proxy, Method method, Object[] args) {
        return new ConnectConfig(null, null);
    }
}
