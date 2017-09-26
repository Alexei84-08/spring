package cn.homjie.spring.mvc.web;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;


public class HomeControllerTest {

	@Test
	public void home() throws Exception {
		HomeController controller = new HomeController();
		// 搭建 MockMvc
		MockMvc mockMvc = standaloneSetup(controller).build();
		// 执行 "/" GET 请求，预期得到 home 视图
		mockMvc.perform(get("/")).andExpect(view().name("home"));
	}

}