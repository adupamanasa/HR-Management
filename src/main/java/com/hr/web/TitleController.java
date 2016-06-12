package com.hr.web;

import org.springframework.beans.factory.annotation.Autowired;
import com.hr.entity.Employee;
import com.hr.entity.Title;
import com.hr.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
//import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

//import java.util.Collection;


@Controller
@RequestMapping("/employees/{empNo}")
public class TitleController {

    private static final String VIEWS_PETS_CREATE_OR_UPDATE_FORM = "pets/createOrUpdatePetForm";
    private final EmployeeService employeeService;

    @Autowired
    public TitleController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @ModelAttribute("employee")
    public Employee findEmployee(@PathVariable("empNo") int empNo) {
        return this.employeeService.findEmployeeByEmpNo(empNo);
    }

    //@InitBinder("owner")
    //public void initOwnerBinder(WebDataBinder dataBinder) {
      //  dataBinder.setDisallowedFields("id");
   //}

    //@InitBinder("pet")
    //public void initPetBinder(WebDataBinder dataBinder) {
    //    dataBinder.setValidator(new PetValidator());
    //}

    @RequestMapping(value = "/titles/new", method = RequestMethod.GET)
    public String initCreationForm(Employee employee, ModelMap model) {
        Title title = new Title();
        employee.addTitle(title);
        model.put("title", title);
        return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
    }

    @RequestMapping(value = "/titles/new", method = RequestMethod.POST)
    public String processCreationForm(Employee employee, @Valid Title title, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            model.put("title", title);
            return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
        } else {
        	employee.addTitle(title);
            this.employeeService.saveTitle(title);
            return "redirect:/employees/{empNo}";
        }
    }

}
