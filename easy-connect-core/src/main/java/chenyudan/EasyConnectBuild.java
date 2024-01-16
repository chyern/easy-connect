package chenyudan;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Description: TODO
 *
 * @author chenyu
 * @since 2021/4/24
 */
public class EasyConnectBuild {

    public static <T> T create(Class<T> clazz) {
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, new ConnectInvocationHandler());
    }

    private static class ConnectInvocationHandler implements InvocationHandler {

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            return null;
        }
    }
}