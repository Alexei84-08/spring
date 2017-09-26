package cn.homjie.spring.mvc.dao;

import cn.homjie.spring.mvc.entity.Spitter;

public interface SpitterRepository {

	Spitter save(Spitter spitter);

	Spitter findByUsername(String username);

}
