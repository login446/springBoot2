package com.alex.springBoot2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class WebController {
    @RequestMapping("/hello")
    public String hello(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
        model.addAttribute("name", name);
        return "hello";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model){
        return "index";
    }

    @RequestMapping(value = "/parsing", method = RequestMethod.POST)
    public String words(@RequestParam("text") String text, Model model){
        ArrayList<Word> arrayList = ParsingString.parsing(text);
        String temp = "";
        for (Word word : arrayList)
            temp += word.getName() + " - " + word.getCount() + "\n";
        model.addAttribute("popularWords", temp);
        return "words";
    }
}
