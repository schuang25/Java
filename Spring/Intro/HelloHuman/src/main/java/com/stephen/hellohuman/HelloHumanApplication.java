package com.stephen.hellohuman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HelloHumanApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloHumanApplication.class, args);
	}

	@RequestMapping("/")
	public String index(@RequestParam(value="name", required=false) String name,
						@RequestParam(value="last_name", required=false) String last_name,
						@RequestParam(value="times", required=false) Integer times) {
		if (name == null)
			return "Hello Human";
		else if (times == null){
			if (last_name == null)
				return "Hello " + name;
			else
				return "Hello " + name + " " + last_name;
		} else {
			String base_str = "Hello " + name;
			String str = "";
			if (last_name != null)
				base_str += " " + last_name;
			for (int i = 0; i < times.intValue(); i++)
				str += " " + base_str;
			return str;
		}
	}
}
