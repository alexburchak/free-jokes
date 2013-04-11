package org.jokes.web.controller;

import net.jokes.core.service.JokeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;

@Controller
public class JokeController {
    @Inject
    private JokeService jokeService;

    @RequestMapping(value = "/jokes", method = RequestMethod.GET)
    @ResponseBody
    public Object getJokes() {
        return jokeService.findAll();
    }
}
