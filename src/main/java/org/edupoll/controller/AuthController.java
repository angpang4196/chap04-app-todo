package org.edupoll.controller;

import org.edupoll.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class AuthController {

	@Autowired
	AuthService authService;

	@GetMapping("/auth")
	public String gotoLoginView() {
		return "auth";
	}

	@PostMapping("/auth-task")
	public String handleLogin(@RequestParam String id, @RequestParam String pass, HttpSession session) {
		boolean result = authService.isValidate(id, pass);
		if (result) {
			session.setAttribute("logonId", id);
			return "redirect:/todos";
		} else {
			return "auth";
		}
	}

}
