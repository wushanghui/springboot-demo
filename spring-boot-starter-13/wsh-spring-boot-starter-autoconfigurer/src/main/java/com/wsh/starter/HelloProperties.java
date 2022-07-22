package com.wushanghui.starter;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author jue
 * @date 2019/2/25 22:37
 * @describe
 */
@ConfigurationProperties(prefix = "wsh.hello")
public class HelloProperties {

    private String prefix;
    private String suffix;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}
