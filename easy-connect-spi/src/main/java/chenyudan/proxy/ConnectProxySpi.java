package chenyudan.proxy;

/**
 * Description: TODO
 *
 * @author chenyu
 * @since 2023/11/25 17:35
 */
public interface ConnectProxySpi {

    Object newProxyInstance(Class clazz);

    boolean match(Class clazz);
}
