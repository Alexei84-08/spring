package cn.homjie.spring.security.service;

import cn.homjie.spring.security.domain.Spitter;
import cn.homjie.spring.security.domain.Spittle;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExpressionSecuredSpittleService implements ExpressionSpittleService {

	// 基于表达式的计算结果来限制方法的访问：@PreAuthorize 和 @PostAuthorize
	// @PreAuthorize 的表达式会在方法调用之前执行，如果表达式的计算结果不为 true 的话，将会阻止方法执行。
	// 与之相反，@PostAuthorize 的表达式直到方法返回才会执行，然后决定是否抛出安全性的异常。


	@Override
	// 表达式中的 #spittle 部分直接引用了方法中的同名参数
	@PreAuthorize("(hasRole('ROLE_SPITTER') and #spittle.text.length() le 140) or hasRole('ROLE_PREMIUM')")
	public void addSpittle(Spittle spittle) {
		System.out.println("Method was called successfully");
	}

	@Override
	// @PostAuthorize 在 SpEL 中提供了名为 returnObject 的变量，表示方法的返回对象
	@PostAuthorize("returnObject.spitter.username == principal.username")
	public Spittle getSpittleById(long id) {
		if (id == 1L)
			return habuma();
		if (id == 2L)
			return lemonguge();
		return null;
	}

	// 过滤方法的输入和输出：@PreFilter 和 @PostFilter
	// @PostFilter 会使用这个表达式计算该方法所返回集合的每个成员，将计算结果为 false 的成员移除掉。

	@Override
	@PreAuthorize("hasAnyRole({'ROLE_SPITTER', 'ROLE_ADMIN'})")
	// 其中表达式中的 filterObject 对象引用的是这个方法所返回 List 中的某一个元素
	@PostFilter("hasRole('ROLE_ADMIN') || filterObject.spitter.username == principal.username")
	public List<Spittle> getOffensiveSpittles() {
		List<Spittle> list = new ArrayList<>();
		list.add(habuma());
		list.add(lemonguge());
		return list;
	}

	private Spittle habuma() {
		Spitter spitter = new Spitter(1L, "habuma", null, "Craig Walls", "craig@habuma.com", true);
		return new Spittle(1L, spitter, "Hiya!", new Date());
	}

	private Spittle lemonguge() {
		Spitter spitter = new Spitter(2L, "lemonguge", null, "Hom Jie", "lemonguge@gmail.com", true);
		return new Spittle(2L, spitter, "Hello!", new Date());
	}

	// @PreFilter 预先过滤传入到方法中的值，不常用。推荐自定义的许可计算器

	@Override
	@PreAuthorize("hasAnyRole({'ROLE_SPITTER', 'ROLE_ADMIN'})")
	// 方法拥有多个集合类型的参数时，需要通过 @PreFilter 的 filterTarget 属性指定当前 @PreFilter 是针对哪个参数进行过滤的
	@PreFilter(filterTarget = "spittles", value = "hasRole('ROLE_ADMIN') || filterObject.spitter.username == principal.username")
	public void deleteSpittles(List<Spittle> spittles) {
		System.out.println("Detele ok [" + spittles.size() + "]");
	}

	@Override
	@PreAuthorize("hasAnyRole({'ROLE_SPITTER', 'ROLE_ADMIN'})")
	// Step3、使用 hasPermission() 函数，由许可计算器实现
	@PreFilter("hasPermission(filterObject, 'delete')")
	public void deleteSpittles2(List<Spittle> spittles) {
		System.out.println("Detele ok [" + spittles.size() + "]");
	}
}
