package cn.homjie.spring.wiringx.prototype;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author jiehong.jh
 * @date 2018/5/3
 */
@Component
public class Singleton {

    @Autowired
    private Prototype prototype;
    @Autowired
    private ObjectProvider<Prototype> prototypeProvider;

    public Prototype getPrototype() {
        return prototype;
    }

    public Prototype getPrototypeByProvider() {
        return prototypeProvider.getIfAvailable();
    }
}
