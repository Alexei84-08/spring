package cn.homjie.spring.cache.dao;

import cn.homjie.spring.cache.domain.Spittle;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * Repository interface with operations for {@link Spittle} persistence.
 *
 * @author habuma
 */
public interface SpittleRepository {

	long count();

	@Cacheable("spittleCache")
	List<Spittle> findRecent();

	List<Spittle> findRecent(int count);

	@Cacheable(value = "spittleCache", unless = "#result.message.contains('NoCache')", condition = "#id >= 10")
	Spittle findOne(long id);

	@CachePut(value = "spittleCache", key = "#result.id")
	Spittle save(Spittle spittle);

	@Cacheable("spittleCache")
	List<Spittle> findBySpitterId(long spitterId);

	@CacheEvict(value = "spittleCache")
	void delete(long id);

	// Cache 的 condition 属性：如果计算的值为 false，将禁用缓存

	// @Cacheable 和 @CachePut 注解的 unless 属性计算的结果为 true，将阻止将返回值放入缓存中

	// @CacheEvict 注解的 allEntries 属性如果为 true，特定缓存的所有条目都会被移除；beforeInvocation 属性如果为 false，方法调用成功后移除条目

	// Key 缓存规则的 SpEL 扩展：默认的缓存 key 要基于方法的参数来确定
	// 1、#root.args：传递给缓存方法的参数，形式为数组
	// 2、#root.caches：该方法执行时所对应的缓存，形式为数组
	// 3、#root.target：目标对象
	// 4、#root.targetClass：目标对象的类，是#root.target.class的简写形式
	// 5、#root.method：缓存方法
	// 6、#root.methodName：缓存方法的名字，是#root.method.name的简写形式
	// 7、#result：方法调用的返回值（不能用在@Cacheable注解上）
	// 8、#Argument：任意的方法参数名（如#argName）或参数索引（如#a0或#p0）

}
