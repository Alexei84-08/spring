package cn.homjie.spring.mvcx.data;

import cn.homjie.spring.mvcx.Spitter;

public interface SpitterRepository {

	Spitter save(Spitter spitter);

	Spitter findByUsername(String username);

}
