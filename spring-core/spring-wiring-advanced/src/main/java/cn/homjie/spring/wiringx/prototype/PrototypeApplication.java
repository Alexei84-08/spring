package cn.homjie.spring.wiringx.prototype;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author jiehong.jh
 * @date 2018/5/3
 */
@Configuration
@ComponentScan
public class PrototypeApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(PrototypeApplication.class);

        Singleton singleton = ctx.getBean(Singleton.class);
        // 默认Prototype注入到Singleton的bean，是不变的
        System.out.println(singleton.getPrototype() == singleton.getPrototype()); // true
        // 通过ObjectProvider获取bean保证每次都不同
        System.out.println(singleton.getPrototypeByProvider() == singleton.getPrototypeByProvider()); // false
    }
}
