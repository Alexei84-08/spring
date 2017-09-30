package cn.homjie.spring.mvc.web;

import cn.homjie.spring.mvc.dao.SpitterRepository;
import cn.homjie.spring.mvc.entity.Spitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("/spitter")
public class SpitterController {

	private SpitterRepository spitterRepository;

	@Autowired
	public SpitterController(SpitterRepository spitterRepository) {
		this.spitterRepository = spitterRepository;
	}

	@RequestMapping(value = "/register", method = GET)
	public String showRegistrationForm() {
		return "registerForm";
	}

	@RequestMapping(value = "/register", method = POST)
	public String processRegistration(@Valid Spitter spitter, Errors errors) {
		// Spitter 参数添加了 @Valid 注解，这会告知 Spring，需要确保这个对象满足校验限制
		// Errors 参数要紧跟在带有 @Valid 注解的参数后面
		if (errors.hasErrors()) {
			return "registerForm";
		}

		spitterRepository.save(spitter);
		// redirect: 前缀将解析为重定向的规则，而不是视图的名称
		// forward: 前缀将会前往（forward）指定的 URL 路径，而不再是重定向
		return "redirect:/spitter/" + spitter.getUsername();
	}

	@RequestMapping(value = "/{username}", method = GET)
	public String showSpitterProfile(@PathVariable String username, Model model) {
		Spitter spitter = spitterRepository.findByUsername(username);
		model.addAttribute(spitter);
		return "profile";
	}

}
