package cn.homjie.spring.data.dao;

import cn.homjie.spring.data.domain.Spittle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repository interface with operations for {@link Spittle} persistence.
 *
 * @author habuma
 */
public interface SpittleRepository extends JpaRepository<Spittle, Long>, SpittleRepositoryCustom {

	List<Spittle> findBySpitterId(long spitterId);

}
