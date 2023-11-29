package chenyudan.proxy;

import chenyudan.process.ConnectProcess;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Description: TODO
 *
 * @author chenyu
 * @since 2023/11/25 17:44
 */
public class JdkProxy implements ConnectProxySpi {

    @Override
    public Object newProxyInstance(Class clazz) {
        return Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, new JdkInvocationHandler());
    }

    @Override
    public boolean match(Class clazz) {
        return clazz.isInterface();
    }

    static class JdkInvocationHandler implements InvocationHandler {

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            ConnectProcess connectProcess = new ConnectProcess();
            return connectProcess.invoke(proxy, method, args);
        }
    }
}
