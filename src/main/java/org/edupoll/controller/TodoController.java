package org.edupoll.controller;

import java.util.List;

import org.edupoll.model.Quest;
import org.edupoll.model.Todo;
import org.edupoll.service.QuestService;
import org.edupoll.service.TodoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/todos")
public class TodoController {

	Logger logger = LoggerFactory.getLogger(TodoController.class);

	@Autowired
	TodoService todoService;
	@Autowired
	QuestService questService;

	@GetMapping
	public String gotoTodoList(@SessionAttribute String logonId, ModelMap model) {
		List<Todo> todos = todoService.getTodos(logonId);
		List<Quest> quests = questService.getQuests();

		model.put("quests", quests);
		model.put("todos", todos);
		return "todos/list";
	}

	@GetMapping("/create")
	public String gotoCreateTodoView() {
		return "todos/create";
	}

	@PostMapping("/create-task")
	public String handleCreateTodo(@Valid Todo todo, BindingResult result, @SessionAttribute String logonId,
			Model model) {
		logger.debug("injected Todo's {}, {}", todo.getDescription(), todo.getTargetDate());

		if (result.hasErrors()) {
			model.addAttribute("msg", "유효하지 않은 값들이 존재합니다.");
			return "todos/create";
		} else {
			boolean rst = todoService.addNewTodo(todo, logonId);
			if (rst) {
				return "redirect:/todos";
			} else {
				return "todos/create";
			}
		}
	}

	@GetMapping("/delete")
	public String deleteTodo(@RequestParam String todoId, @SessionAttribute String logonId) {
		boolean rst = todoService.removeTodo(todoId, logonId);
		if (rst) {
			return "redirect:/todos";
		} else {
			return "error";
		}
	}

	@GetMapping("/update")
	public String updateTodo(@RequestParam String todoId, Model model) {
		Todo todo = todoService.findByTodoId(todoId);
		model.addAttribute("todo", todo);
		model.addAttribute("todoId", todoId);
		return "todos/update";
	}

	@PostMapping("/update-task")
	public String handleUpdateTodo(@Valid Todo todo, BindingResult result, ModelMap model,
			@SessionAttribute String logonId) {
		if (result.hasErrors()) {
			model.addAttribute("todo", todo);
			model.addAttribute("error", "유효하지 않은 값들이 존재합니다.");
			return "todos/update";
		}
		boolean rst = todoService.updateTodo(todo, logonId);
		if (rst) {
			return "redirect:/todos";
		} else {
			model.addAttribute("todo", todo);
			model.addAttribute("error", "서비스 장애로 요청을 처리할 수 없습니다.");
			return "todos/update";
		}
	}

	@GetMapping("/join")
	public String handleJoinToMyTodoList(@RequestParam int id, RedirectAttributes attr, @SessionAttribute String logonId) {
		boolean rst = questService.update(id, logonId);
		if (rst) {
			return "redirect:/todos";
		} else {
			attr.addAttribute("error", "1");
			return "redirect:/todos";
		}
	}

}
