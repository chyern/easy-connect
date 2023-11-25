package chenyudan.process;

import chenyudan.domain.ConnectProcessRoute;

import java.lang.reflect.Method;

/**
 * Description: TODO
 *
 * @author Chyern
 * @since 2023/11/25 17:54
 */
public interface ConnectProcessSpi {

    /**
     * 准备执行前操作
     */
    ConnectProcessRoute buildTargetRoute(Object proxy, Method method, Object[] args) throws Throwable;

    /**
     * 执行前置操作
     */
    void before(Object proxy, Method method, Object[] args) throws Throwable;

    /**
     * 执行操作
     */
    Object execute(Object proxy, Method method, Object[] args) throws Throwable;

    /**
     * 准备执行后操作
     */
    void prepareAfter(Object proxy, Method method, Object[] args, Object result) throws Throwable;

    /**
     * 执行后置操作
     */
    void after(Object proxy, Method method, Object[] args, Object result) throws Throwable;

    /**
     * 异常抛出前置操作
     */
    default Throwable throwsException(Object proxy, Method method, Object[] args, Throwable throwable) {
        return throwable;
    }
}
