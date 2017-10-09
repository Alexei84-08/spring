package cn.homjie.spring.mvc.web;

import cn.homjie.spring.mvc.dao.SpittleRepository;
import cn.homjie.spring.mvc.entity.Spittle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/spittles")
public class SpittleController {

	private static final String MAX_LONG_AS_STRING = "9223372036854775807";

	private SpittleRepository spittleRepository;

	@Autowired
	public SpittleController(SpittleRepository spittleRepository) {
		this.spittleRepository = spittleRepository;
	}

	// 处理查询参数 Query Parameter
	@RequestMapping(method = RequestMethod.GET)
	public List<Spittle> spittles(
			@RequestParam(value = "max", defaultValue = MAX_LONG_AS_STRING) long max,
			@RequestParam(value = "count", defaultValue = "20") int count) {
		// 请求中没有参数的话，会使用默认值将会设置
		// 返回值会放到模型中，模型的 key 会根据其类型推断得出（也就是 spittleList）
		return spittleRepository.findSpittles(max, count);
	}

	// 处理路径变量 Path Variable
	@RequestMapping(value = "/{spittleId}", method = RequestMethod.GET)
	public String spittle(@PathVariable long spittleId, Model model) {
		// 方法的参数名碰巧与占位符的名称相同，因此我们可以去掉 @PathVariable 中的 value 属性
		// 模型的key将会是 spittle，这是根据传递到 addAttribute() 方法中的类型推断得到的
		model.addAttribute(spittleRepository.findOne(spittleId));
		return "spittle";
	}

	// 处理表单参数 Form Parameter
	@RequestMapping(method = RequestMethod.POST)
	public String saveSpittle(@Valid SpittleForm form, Model model) throws Exception {
		// 使用 Spring 对 Java 校验 API（Java Validation API，又称 JSR-303）的支持。
		// 从 Spring 3.0 开始，在 Spring MVC 中提供了对 Java 校验 API 的支持。
		// 在 Spring MVC 中要使用 Java 校验 API 的话，并不需要什么额外的配置。
		// 只要保证在类路径下包含这个 Java API 的实现即可，比如 Hibernate Validator。
		spittleRepository.save(new Spittle(null, form.getMessage(), new Date(),
				form.getLongitude(), form.getLatitude()));
		return "redirect:/spittles";
	}

}
