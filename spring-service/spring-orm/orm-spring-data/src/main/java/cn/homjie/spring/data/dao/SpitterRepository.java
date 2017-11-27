package cn.homjie.spring.data.dao;

import cn.homjie.spring.data.domain.Spitter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repository interface with operations for {@link Spitter} persistence.
 *
 * @author habuma
 */
public interface SpitterRepository extends JpaRepository<Spitter, Long>, SpitterSweeper {

	Spitter findByUsername(String username);

	List<Spitter> findByUsernameOrFullNameLike(String username, String fullName);

}
