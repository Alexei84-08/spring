package cn.homjie.spring.mvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HomeController {

	// @Controller 声明为一个控制器

	// 处理器方法上的 @RequestMapping 注解会对类级别上的 @RequestMapping 的声明进行补充

	// 处理对 "/" 的 GET 请求
	@RequestMapping(method = RequestMethod.GET)
	public String home() {
		System.out.println("Home Receive");
		// 视图名为 home，鉴于我们配置 InternalResourceViewResolver 的方式，视图将会解析为“/WEB-INF/views/home.jsp”路径的 JSP
		return "home";
	}
}
