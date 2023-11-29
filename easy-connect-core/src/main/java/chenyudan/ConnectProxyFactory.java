package chenyudan;

import chenyudan.proxy.ConnectProxySpi;

/**
 * Description: TODO
 *
 * @author chenyu
 * @since 2021/4/24
 */
public class ConnectProxyFactory {

    public static <T> T getObject(Class<T> clazz) {
        for (ConnectProxySpi connectProxySpi : ConnectRegister.proxySpis) {
            if (connectProxySpi.match(clazz)) {
                return (T) connectProxySpi.newProxyInstance(clazz);
            }
        }
        throw new UnsupportedOperationException("未找到可用的代理");
    }
}