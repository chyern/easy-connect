package chenyudan.process;

import chenyudan.config.ConnectConfigStowage;
import chenyudan.domain.ConnectConfig;
import chenyudan.domain.ConnectProcessRoute;

import java.lang.reflect.Method;

/**
 * Description: TODO
 *
 * @author chenyu
 * @since 2023/11/25 17:51
 */
public class ConnectProcess {

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        ConnectConfig connectConfig = ConnectConfigStowage.autoConfigStowage(proxy, method, args);

        //目标路由
        ConnectProcessRoute processRoute = connectConfig.getConnectProcessRouteSpi().buildConnectProcessRoute(proxy, method, args);

        //具体处理类
        ConnectProcessSpi connectProcessSpi = connectConfig.getConnectProcessSpi();
        try {
            connectProcessSpi.before(proxy, method, args);
            Object result = connectProcessSpi.execute(proxy, method, args);
            connectProcessSpi.after(proxy, method, args, result);
            return result;
        } catch (Throwable e) {
            throw connectProcessSpi.throwsException(proxy, method, args, e);
        }
    }
}
