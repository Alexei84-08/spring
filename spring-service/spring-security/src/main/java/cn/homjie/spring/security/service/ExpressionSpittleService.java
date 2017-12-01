package cn.homjie.spring.security.service;

import cn.homjie.spring.security.domain.Spittle;

import java.util.List;

public interface ExpressionSpittleService extends SpittleService {

	Spittle getSpittleById(long id);

	List<Spittle> getOffensiveSpittles();

	void deleteSpittles(List<Spittle> spittles);

	void deleteSpittles2(List<Spittle> spittles);
}
