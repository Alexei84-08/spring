package cn.homjie.spring.data.dao;

import cn.homjie.spring.data.domain.Spittle;

import java.util.List;

public interface SpittleRepositoryCustom {

	List<Spittle> findRecent();

	List<Spittle> findRecent(int count);

}