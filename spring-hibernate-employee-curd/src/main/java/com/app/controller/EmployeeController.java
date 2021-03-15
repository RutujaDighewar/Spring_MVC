package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.entity.Employee;
import com.app.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@ModelAttribute("employees")
	public List<Employee> listOfEmployee() {
		return employeeService.getEmployees();
	}

	@GetMapping(value = { "index", "modify" })
	public String viewHome(Model model, @RequestParam(value = "id", required = false) Integer id) {
		Employee employee = new Employee();

		if (id != null)
			employee = employeeService.getId(id);
		
		model.addAttribute("employeeForm", employee); // binding result nor plain target object
		return "registration";
	}

	@PostMapping(value = "save")
	public String saveOrUpdate(Model model, @ModelAttribute Employee employee, RedirectAttributes redirectAttribute) {

		Boolean result = employeeService.saveOrUpdate(employee);
		if (result) {
			redirectAttribute.addFlashAttribute("success", "Employee saved");
		} else {
			redirectAttribute.addFlashAttribute("error", "Employee not saved");
		}
		return "redirect:/index";
	}

	@GetMapping(value = "delete")
	public String deleteEmployee(@RequestParam("id") Integer id, RedirectAttributes redirectAttribute) {
		Boolean result = employeeService.deleteEmployee(id);
		if (result) {
			redirectAttribute.addFlashAttribute("success", "Employee deleted successfully");
		} else {
			redirectAttribute.addFlashAttribute("error", "Employee not delete...try agian");
		}
		return "redirect:/index";
	}
}
