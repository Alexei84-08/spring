package cn.homjie.spring.mvc.dao;

import cn.homjie.spring.mvc.entity.Spittle;

import java.util.List;

public interface SpittleRepository {

	List<Spittle> findRecentSpittles();

	int countSpittles(long max);

	List<Spittle> findSpittles(long max, int count);

	Spittle findOne(long id);

	void save(Spittle spittle);

}
