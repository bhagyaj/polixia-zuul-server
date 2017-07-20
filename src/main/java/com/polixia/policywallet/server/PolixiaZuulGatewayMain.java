package com.polixia.policywallet.server;

import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * Created by brupasinghe on 7/19/2017.
 */
@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
public class PolixiaZuulGatewayMain {
    static Logger log = LoggerFactory.getLogger(PolixiaZuulGatewayMain.class);
    public static void main(String[] args) {
        SpringApplication.run(PolixiaZuulGatewayMain.class, args);
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        if(request!=null)
        log.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));
    }
}
