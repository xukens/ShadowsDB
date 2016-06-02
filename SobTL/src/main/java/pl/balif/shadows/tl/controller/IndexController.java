package pl.balif.shadows.tl.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by RudyKot on 2016-05-26.
 */
@Controller
public class IndexController {

//    @RequestMapping("/*")
//    @ResponseStatus(HttpStatus.MOVED_PERMANENTLY)
//    public String redirectToIndex(){
//        return "redirect:/index";
//    }

    @RequestMapping("/index")
    public String mainPage(){
        return "index";
    }
}
