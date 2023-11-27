package chenyudan.proxy;

/**
 * Description: TODO
 *
 * @author Chyern
 * @since 2023/11/25 17:35
 */
public interface ProxyInstance {

    Object newProxyInstance(Class clazz);

    boolean match(Class clazz);
}
