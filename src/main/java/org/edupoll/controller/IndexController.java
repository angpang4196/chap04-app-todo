package org.edupoll.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class IndexController {
	Logger logger = LoggerFactory.getLogger(IndexController.class);

	@GetMapping("/")
	public String navigate(@SessionAttribute(required = false) String logonId) {
		logger.debug("logonId = {}", logonId);
		if (logonId == null) {
			return "redirect:/auth";
		} else {
			return "redirect:/todos";
		}
	}

}
