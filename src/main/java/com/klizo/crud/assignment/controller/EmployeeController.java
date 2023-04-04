package com.klizo.crud.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.klizo.crud.assignment.model.Employee;
import com.klizo.crud.assignment.repository.EmployeeRepo;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeRepo employeeRepo;

    @GetMapping("/new")
    public String showNewForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "user/form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") @Validated Employee employee,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user/form";
        }
        employeeRepo.save(employee);
        return "redirect:user/index";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Employee employee = employeeRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid employee Id:" + id));
        model.addAttribute("employee", employee);
        return "user/form";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") Long id) {
        Employee employee = employeeRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid employee Id:" + id));
        employeeRepo.delete(employee);
        return "redirect:/user/index";
    }
}

