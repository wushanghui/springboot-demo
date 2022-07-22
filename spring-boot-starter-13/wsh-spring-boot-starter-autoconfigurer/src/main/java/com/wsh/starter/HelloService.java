package com.wushanghui.starter;

/**
 * @author jue
 * @date 2019/2/25 22:36
 * @describe
 */
public class HelloService {

    HelloProperties helloProperties;

    public String seyHello(String name) {
        return helloProperties.getPrefix()+"-"+name + "-"+helloProperties.getSuffix();
    }

    public HelloProperties getHelloProperties() {
        return helloProperties;
    }

    public void setHelloProperties(HelloProperties helloProperties) {
        this.helloProperties = helloProperties;
    }
}
