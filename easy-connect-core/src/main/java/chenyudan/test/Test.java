package chenyudan.test;

import chenyudan.ConnectProxyFactory;

/**
 * Description: TODO
 *
 * @author Chyern
 * @since 2023/11/27 16:03
 */
public class Test {

    public static void main(String[] args) {
        ProxyInterface proxyInterface = ConnectProxyFactory.getObject(ProxyInterface.class);
        //proxyInterface.test();

        ProxyClass proxyClass = ConnectProxyFactory.getObject(ProxyClass.class);
        proxyClass.test();


        System.out.println(1);
    }
}
