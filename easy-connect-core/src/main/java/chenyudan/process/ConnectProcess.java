package chenyudan.process;

import chenyudan.ConnectRegister;
import chenyudan.domain.ConnectProcessRoute;
import chenyudan.proxy.ConnectProxySpi;

import java.lang.reflect.Method;
import java.util.ServiceLoader;

/**
 * Description: TODO
 *
 * @author chenyu
 * @since 2023/11/25 17:51
 */
public class ConnectProcess {

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //目标路由
        ConnectProcessRoute processRoute = null;
        for (ConnectProcessRouteSpi processRouteSpi : ConnectRegister.processRouteSpis) {
            processRoute = processRouteSpi.buildConnectProcessRoute(proxy, method, args);
            break;
        }


        for (ConnectProcessSpi connectProcessSpi : ConnectRegister.processSpis) {
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
