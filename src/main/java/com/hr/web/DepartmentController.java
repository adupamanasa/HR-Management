package com.hr.web;


import java.util.Collection;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import com.hr.entity.Department;
import com.hr.service.EmployeeService;

import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.ui.ModelMap;
//import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DepartmentController {

	private static final String VIEWS_DEPARTMENT_CREATE_FORM = "departments/createForm";
	private final EmployeeService employeeService;


    @Autowired
    public DepartmentController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(value = "/departments", method = RequestMethod.GET)
    public String showDepartmentList(Department department, BindingResult result, Map<String, Object> model) {
        Collection<Department> results = this.employeeService.findDepartments();
        model.put("departments", results);
        return "redirect:/departments";
    }

    @RequestMapping("/departments/{deptNo}")
    public ModelAndView showDepartment(@PathVariable("deptNo") String deptNo) {
        ModelAndView mav = new ModelAndView("departments/departmentDetails");
        mav.addObject(this.employeeService.findDepartmentByDeptNo(deptNo));
        return mav;
    }
   
    @RequestMapping(value = "/departments/new", method = RequestMethod.GET)
     public String initCreationForm(Map<String, Object> model) {
        Department department = new Department();
        model.put("department", department);
        return VIEWS_DEPARTMENT_CREATE_FORM;
     }

     @RequestMapping(value = "/departments/new", method = RequestMethod.POST)
     public String processCreationForm(@Valid Department department, BindingResult result) {
         if (result.hasErrors()) {
         return VIEWS_DEPARTMENT_CREATE_FORM;
         } else {
         this.employeeService.saveDepartment(department);
         return "redirect:/departments";
         }
    }
   

}

