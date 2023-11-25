package chenyudan.proxy;

import chenyudan.process.ConnectProcess;

import java.lang.reflect.Proxy;

/**
 * Description: TODO
 *
 * @author Chyern
 * @since 2023/11/25 17:44
 */
public class JDKProxy implements ProxyInstance {

    @Override
    public Object newProxyInstance(Class clazz) {
        return Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, new ConnectProcess());
    }
}
