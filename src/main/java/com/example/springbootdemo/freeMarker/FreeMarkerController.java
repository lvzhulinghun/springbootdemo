package com.example.springbootdemo.freeMarker;


import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class FreeMarkerController {

    @RequestMapping(name = "/helloFTL",method = RequestMethod.GET)
    public ModelAndView helloFTL(ModelMap map){
        ModelAndView modelAndView = new ModelAndView("indexFreeMarker");
        map.addAttribute("name","王老师");
        map.addAttribute("host", "http://blog.didispace.com");
        modelAndView.addObject("abc","崔春驰0");
        return modelAndView;
    }


}
