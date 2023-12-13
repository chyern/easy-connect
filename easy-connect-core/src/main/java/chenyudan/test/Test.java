package chenyudan.test;

import chenyudan.ConnectProxyFactory;

/**
 * Description: TODO
 *
 * @author chenyu
 * @since 2023/11/27 16:03
 */
public class Test {

    public static void main(String[] args) {
        ProxyInterface proxyInterface = ConnectProxyFactory.getObject(ProxyInterface.class);
        proxyInterface.test();

        System.out.println(1);
    }
}
