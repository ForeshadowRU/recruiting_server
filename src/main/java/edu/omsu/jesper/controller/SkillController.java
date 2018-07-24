package edu.omsu.jesper.controller;

import edu.omsu.jesper.dao.interfaces.SkillRequirementDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/skills")
public class SkillController {


    private final SkillRequirementDao dao;

    @Autowired
    public SkillController(SkillRequirementDao dao) {
        this.dao = dao;
    }

    @GetMapping("/")
    public List<String> getAll() {
        return dao.getAllSkills();
    }
}
