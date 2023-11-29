package chenyudan.proxy;

import chenyudan.process.ConnectProcess;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Description: TODO
 *
 * @author chenyu
 * @since 2023/11/25 17:44
 */
public class CglibProxy implements ProxyInstance {

    @Override
    public Object newProxyInstance(Class clazz) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(new CglibInterceptor());
        return enhancer.create();
    }

    @Override
    public boolean match(Class clazz) {
        return !clazz.isInterface();
    }

    static class CglibInterceptor implements MethodInterceptor {

        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            ConnectProcess connectProcess = new ConnectProcess();
            return connectProcess.invoke(o, method, objects);
        }
    }
}
