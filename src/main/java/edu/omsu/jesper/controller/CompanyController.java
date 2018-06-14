package edu.omsu.jesper.controller;

import edu.omsu.jesper.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import edu.omsu.jesper.service.CompanyService;

@Controller
@RequestMapping("/")
public class CompanyController {

    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService)
    {
        this.companyService = companyService;
    }
    @GetMapping("/companies")
    public String getAllCompanies(Model model) {
            model.addAttribute("companies", companyService.findAll());
        return "companies";
    }
    @GetMapping("/addCompany")
    public String authPage() {
        return "auth";
    }

    @PostMapping("/addCompany")
    public String addCompany(@ModelAttribute("company") Company company) throws Exception {
        companyService.save(company);
        return "redirect:/companies";
    }





}
