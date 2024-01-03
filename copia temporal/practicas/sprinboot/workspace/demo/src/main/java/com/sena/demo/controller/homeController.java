package com.sena.demo.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
//@RestController
public class homeController {
	
	//web
		@GetMapping("/" )
		public String indext(Model model) {
			return  "index";
		}


}
