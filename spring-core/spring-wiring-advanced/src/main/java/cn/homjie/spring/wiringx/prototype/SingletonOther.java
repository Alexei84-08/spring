package cn.homjie.spring.wiringx.prototype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author jiehong.jh
 * @date 2018/5/3
 */
@Component
public class SingletonOther {
    @Autowired
    private Prototype prototype;

    public Prototype getPrototype() {
        return prototype;
    }
}
