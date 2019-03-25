package cn.p2p.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class loginTest {

	
	@RequestMapping("/index")
	public String test() {
		return "front/main";
	}
	
	/**
	 * 进入后台管理员页面
	 * 
	 * @return
	 */
	@RequestMapping("/main")
	public String main() {
		return "back/main";
	}
	
}

