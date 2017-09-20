package cn.homjie.spring.travel;

import cn.homjie.spring.travel.entity.TxManager;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IocApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(IocConfig.class);
		TxManager txManager = context.getBean(TxManager.class);
		txManager.begin();
		context.close();
	}
}
