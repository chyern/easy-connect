package chenyudan;

import chenyudan.proxy.ProxyInstance;

/**
 * Description: TODO
 *
 * @author chenyu
 * @since 2021/4/24
 */
public class ConnectProxyFactory {

    public static <T> T getObject(Class<T> clazz) {
        for (ProxyInstance proxyInstance : ConnectRegister.proxyInstances) {
            if (proxyInstance.match(clazz)) {
                return (T) proxyInstance.newProxyInstance(clazz);
            }
        }
        throw new UnsupportedOperationException("未找到可用的代理");
    }
}