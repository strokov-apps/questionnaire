package questionnaire.client.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

	@RequestMapping("/greeting")
	@ResponseBody
	public String greeting() {
		return "hello";
	}
}
