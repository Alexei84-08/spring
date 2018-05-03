package cn.homjie.spring.wiringx.prototype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author jiehong.jh
 * @date 2018/5/3
 */
@Component
public class SingletonBoth {
    @Autowired
    private Prototype prototype1;
    @Autowired
    private Prototype prototype2;

    public Prototype getPrototype1() {
        return prototype1;
    }

    public Prototype getPrototype2() {
        return prototype2;
    }
}
