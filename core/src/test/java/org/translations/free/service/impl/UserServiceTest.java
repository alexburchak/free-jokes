package org.translations.free.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.translations.free.domain.User;
import org.translations.free.service.UserService;

@ContextConfiguration(locations = {"classpath:/test-applicationContext.xml"})
public class UserServiceTest extends AbstractTestNGSpringContextTests
{
    private long userId;

    @Autowired
    private UserService userService;

    @BeforeMethod
    public void setUp()
    {
        User user = new User();
        user.setEmail("lenny+" + System.currentTimeMillis() + "@kravitz.com");
        user.setPassword("password");
        userService.save(user);
        userId = user.getId();
    }

    @Transactional
    @Test
    public void testValidation()
    {
        User user = userService.findById(userId);
        user.setPassword("");
        userService.save(user);
    }
}
