package chenyudan.process;

import chenyudan.domain.ConnectProcessRoute;

import java.lang.reflect.Method;

/**
 * Description: TODO
 *
 * @author Chyern
 * @since 2023/11/25 18:28
 */
public interface ConnectProcessRouteSpi {

    /**
     * 构建目标路由
     */
    ConnectProcessRoute buildConnectProcessRoute(Object proxy, Method method, Object[] args) throws Throwable;
}
