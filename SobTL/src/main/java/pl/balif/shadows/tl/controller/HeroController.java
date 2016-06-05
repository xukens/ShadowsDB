package pl.balif.shadows.tl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.balif.shadows.core.dto.form.HeroForm;
import pl.balif.shadows.core.service.HeroService;

import java.util.List;

/**
 * Created by RudyKot on 2016-05-26.
 */
@Controller
@RequestMapping("/hero")
public class HeroController {

    private final HeroService heroService;

    @Autowired
    public HeroController(HeroService heroService) {
        this.heroService = heroService;
    }

    @RequestMapping("/list")
    public String getHeroesList(Model model){
        List<HeroForm> list = heroService.getHeroes();
        model.addAttribute("heroes", list);
        return "hero/list";
    }

    @RequestMapping(value = "/{id}")
    public String getHero(@PathVariable Long id, Model model){
        HeroForm hero = heroService.getHero(id);
        model.addAttribute("hero", hero);
        return "hero/view";
    }
}
