package cn.homjie.spring.view.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping("/")
public class HomeController {

	@Value("#{messageSource.getMessage('spitter.welcome', null, null)}")
	private String welcome;

	@RequestMapping(method = GET)
	public String home(Model model) {
		System.out.println(welcome);
		return "home";
	}

}
