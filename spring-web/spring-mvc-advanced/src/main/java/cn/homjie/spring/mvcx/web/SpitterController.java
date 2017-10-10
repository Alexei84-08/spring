package cn.homjie.spring.mvcx.web;

import cn.homjie.spring.mvcx.Spitter;
import cn.homjie.spring.mvcx.data.SpitterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;

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
	public String showRegistrationForm(Model model) {
		model.addAttribute(new Spitter());
		return "registerForm";
	}

//  @RequestMapping(value="/register", method=POST)
//  public String processRegistration(
//      @RequestPart(value="profilePictures", required=false) Part fileBytes,
//      RedirectAttributes redirectAttributes,
//      @Valid Spitter spitter,
//      Errors errors) throws IOException {
//    if (errors.hasErrors()) {
//      return "registerForm";
//    }
//    
//    spitterRepository.save(spitter);
//    redirectAttributes.addAttribute("username", spitter.getUsername());
//    redirectAttributes.addFlashAttribute(spitter);
//    return "redirect:/spitter/" + spitter.getUsername();
//  }

	@RequestMapping(value = "/register", method = POST)
	public String processRegistration(
			@Valid SpitterForm spitterForm,
			Errors errors,
			RedirectAttributes model) throws IllegalStateException, IOException {

		if (errors.hasErrors()) {
			return "registerForm";
		}
		Spitter spitter = spitterForm.toSpitter();
		spitterRepository.save(spitter);
		MultipartFile profilePicture = spitterForm.getProfilePicture();
		if (!profilePicture.isEmpty())
			profilePicture.transferTo(new File(spitter.getUsername() + ".jpg"));
		model.addAttribute("username", spitter.getUsername());
		model.addFlashAttribute(spitter);
		return "redirect:/spitter/{username}";
	}

	@RequestMapping(value = "/{username}", method = GET)
	public String showSpitterProfile(@PathVariable String username, Model model) {
		if (!model.containsAttribute("spitter")) {
			model.addAttribute(spitterRepository.findByUsername(username));
		} else {
			System.out.println("request by redirect");
		}
		return "profile";
	}

}
