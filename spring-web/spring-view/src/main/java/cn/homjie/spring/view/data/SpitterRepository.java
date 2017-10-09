package cn.homjie.spring.view.data;

import cn.homjie.spring.view.Spitter;

public interface SpitterRepository {

	Spitter save(Spitter spitter);

	Spitter findByUsername(String username);

}
