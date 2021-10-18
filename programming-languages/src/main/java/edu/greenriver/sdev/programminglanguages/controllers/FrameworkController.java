package edu.greenriver.sdev.programminglanguages.controllers;

import edu.greenriver.sdev.programminglanguages.model.Framework;
import edu.greenriver.sdev.programminglanguages.services.FrameworkService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FrameworkController
{
    //access the service layer using dependency injection
    private FrameworkService service;

    public FrameworkController(FrameworkService service)
    {
        this.service = service;
    }

    //we can save view-template variables to the Model object
    //so we can use them in our pages
    @RequestMapping("frameworks/random")
    public String random(Model model)
    {
        Framework randFrame = service.random();
        model.addAttribute("frame", randFrame);
        model.addAttribute("title", "A Random Framework");
        model.addAttribute("header", "View a Random Framework");

        return "single-framework";
    }

    @RequestMapping("frameworks/favorite")
    public String favorite(Model model)
    {
        model.addAttribute("frame", service.favorite());
        model.addAttribute("title", "The Favorite Framework");
        model.addAttribute("header", "View the Favorite Framework");

        return "single-framework";
    }

    @RequestMapping("frameworks/rank/{rank}")
    public String byRank(Model model, @PathVariable int rank)
    {
        model.addAttribute("frame", service.frameworkByRank(rank));
        model.addAttribute("title", "A Framework By Rank");
        model.addAttribute("header", "View a Framework");

        return "single-framework";
    }

    @RequestMapping("frameworks/all")
    public String all(Model model)
    {
        //store all frameworks to the model
        model.addAttribute("frames", service.allFrameworks());
        return "all-frameworks";
    }

    @RequestMapping("frameworks/top3")
    public String top(Model model)
    {
        model.addAttribute("frames", service.topThree());
        return "all-frameworks";
    }

}
