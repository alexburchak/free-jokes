package net.jokes.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collections;
import java.util.List;

@Controller
public class JokeController {
    @RequestMapping(value = "/jokes", method = RequestMethod.GET)
    @ResponseBody
    public List<?> getJokes() {
        return Collections.emptyList();
    }
}
