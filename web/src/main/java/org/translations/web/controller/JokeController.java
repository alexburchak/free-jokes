package org.translations.web.controller;

import net.jokes.core.service.JokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import javax.inject.Inject;

@Controller
public class JokeController {
    @Inject
    private JokeService jokeService;

    @RequestMapping(value = "/jokes", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView showContent() {
        return new ModelAndView(new MappingJacksonJsonView());
    }
}
