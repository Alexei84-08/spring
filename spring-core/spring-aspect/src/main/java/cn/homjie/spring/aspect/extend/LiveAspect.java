package cn.homjie.spring.aspect.extend;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LiveAspect {

	// 1、value 属性指定了哪种类型的 bean 要引入该接口。（标记符后面的加号表示是所有子类型，而不是本身）
	// 2、defaultImpl 属性指定了为引入功能提供实现的类
	// 3、@DeclareParents 注解所标注的属性指明了要引入了接口

	@DeclareParents(value = "cn.homjie.spring.aspect.entity.Performance+", defaultImpl = TvLive.class)
	public static Live live;
}
