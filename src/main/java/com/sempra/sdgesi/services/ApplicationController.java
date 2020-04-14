package com.sempra.sdgesi.services;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ApplicationController {

    @Value("${git.commit.id.full:NA}")
    String commitId;

    @Value("${git.commit.id.abbrev:NA}")
    String commitIdAbbrev;

    @Value("${spring.application.name:sdgesi-spring-boot-fuse}")
    String appName;


    private final ApplicationProperties props;

    public ApplicationController(ApplicationProperties props) {
        this.props = props;
    }

    @GetMapping()
    public String index(Model model) {

        model.addAttribute("app", props.getApp());
        model.addAttribute("environment", props.getEnvironment());
        model.addAttribute("app", props.getApp());
        model.addAttribute("color", props.getColor());
        model.addAttribute("commit", commitId);
        model.addAttribute("abbrev", commitIdAbbrev);
        return "application";
    }
}

