package chenyudan;

import chenyudan.process.ConnectProcess;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Description: TODO
 *
 * @author chenyu
 * @since 2021/4/24
 */
public class ConnectProxyFactory {

    public static <T> T getObject(Class<T> clazz) {
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, new ConnectInvocationHandler());
    }

    static class ConnectInvocationHandler implements InvocationHandler {

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            ConnectProcess connectProcess = new ConnectProcess();
            return connectProcess.invoke(proxy, method, args);
        }
    }
}