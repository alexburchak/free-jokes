package org.translations.free.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.translations.free.domain.User;
import org.translations.free.service.UserService;

@ContextConfiguration(locations = {"classpath:/test-applicationContext.xml"})
public class UserServiceTest extends AbstractTestNGSpringContextTests
{
    private User user;

    @Autowired
    private UserService userService;

    @BeforeMethod
    public void setUp()
    {
        user = new User();
        user.setEmail("lenny@kravitz.com");
        user.setPassword("password");
        userService.save(user);
    }

    @Test
    public void testValidation()
    {
        user.setPassword("");
        userService.save(user);
    }
}
