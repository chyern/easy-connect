package chenyudan.process;

import chenyudan.domain.ConnectProcessRoute;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ServiceLoader;

/**
 * Description: TODO
 *
 * @author Chyern
 * @since 2023/11/25 17:51
 */
public class ConnectProcess implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //目标路由
        ConnectProcessRoute processRoute = null;
        ServiceLoader<ConnectProcessRouteSpi> routeSpis = ServiceLoader.load(ConnectProcessRouteSpi.class);
        for (ConnectProcessRouteSpi routeSpi : routeSpis) {
            processRoute = routeSpi.buildConnectProcessRoute(proxy, method, args);
            break;
        }






        ServiceLoader<ConnectProcessSpi> connectProcessSpis = ServiceLoader.load(ConnectProcessSpi.class);
        for (ConnectProcessSpi connectProcessSpi : connectProcessSpis) {
            try {
                connectProcessSpi.buildTargetRoute(proxy, method, args);
                connectProcessSpi.before(proxy, method, args);
                Object result = connectProcessSpi.execute(proxy, method, args);
                connectProcessSpi.prepareAfter(proxy, method, args, result);
                connectProcessSpi.after(proxy, method, args, result);
                return result;
            } catch (Throwable e) {
                throw connectProcessSpi.throwsException(proxy, method, args, e);
            }
        }
        throw new UnsupportedOperationException("未找到具体处理类");
    }
}
