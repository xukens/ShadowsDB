package pl.balif.shadows.tl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.balif.shadows.core.dto.form.HeroForm;
import pl.balif.shadows.core.dto.form.ItemForm;
import pl.balif.shadows.core.service.HeroService;

import java.util.List;
import pl.balif.shadows.core.service.ItemService;

/**
 * Created by RudyKot on 2016-05-26.
 */
@Controller
@RequestMapping("/hero")
public class HeroController {

    private final HeroService heroService;
    private final ItemService itemService;

    @Autowired
    public HeroController(HeroService heroService, ItemService itemService) {
        this.heroService = heroService;
        this.itemService = itemService;
    }

    @RequestMapping("/list")
    public String getHeroesList(Model model) {
        List<HeroForm> list = heroService.getHeroes();
        model.addAttribute("heroes", list);
        return "hero/list";
    }

    @RequestMapping(value = "/{id}")
    public String getHero(@PathVariable Long id, Model model) {
        HeroForm hero = heroService.getHero(id);
        model.addAttribute("hero", hero);
        return "hero/view";
    }

    @RequestMapping(value = "/{id}/item")
    public String choosItemToAdd(@PathVariable Long id, Model model) {
        model.addAttribute("itemFormList", itemService.getItemsList());
        model.addAttribute("itemForm", new ItemForm());
        return "hero/actions/addItem";
    }

    @RequestMapping(value = "/{id}/item", method = RequestMethod.POST)
    public String addItem(@PathVariable Long id, ItemForm itemForm) {
        heroService.addItem(id, itemForm.getId());
        return "redirect:/hero/"+id;
    }
}
