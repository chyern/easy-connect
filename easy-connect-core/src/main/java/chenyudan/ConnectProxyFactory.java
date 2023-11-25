package chenyudan;

import chenyudan.proxy.ProxyInstance;

import java.util.ServiceLoader;

/**
 * Description: TODO
 *
 * @author Chyern
 * @since 2021/4/24
 */
public class ConnectProxyFactory {

    public static <T> T getObject(Class<T> clazz) {
        ServiceLoader<ProxyInstance> connectProxyInstances = ServiceLoader.load(ProxyInstance.class);
        for (ProxyInstance proxyInstance : connectProxyInstances) {
            return (T) proxyInstance.newProxyInstance(clazz);
        }
        throw new UnsupportedOperationException("未找到可用的代理");
    }
}