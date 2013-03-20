package net.abbreviations.core.service.impl;

import javax.validation.ConstraintViolationException;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.transaction.annotation.Transactional;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import net.abbreviations.core.domain.User;
import net.abbreviations.core.service.UserService;

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

    /**
     * Tests whether persistence and transactions work
     */
    @Test
    @Transactional
    public void testPersistence()
    {
        User user = userService.findById(userId);
        user.setPassword("");
        userService.save(user);
    }

    /**
     * Tests javax.validation applied to domain objects. Requires hibernate v3.5 or above
     */
    @Test
    public void testValidation()
    {
        try
        {
            updateUserPasswordHash(StringUtils.EMPTY);
            Assert.fail();
        } catch (Exception e)
        {
            for (Throwable t = e; ; t = t.getCause())
            {
                if (t instanceof ConstraintViolationException)
                    break;
                if (t == null || t.getCause() == t)
                    Assert.fail(ConstraintViolationException.class.getName() + " not found in the stack trace", e);
            }
        }
    }

    /**
     * A separate transaction which updates user password (hash)
     */
    @Transactional
    private void updateUserPasswordHash(String passwordHash)
    {
        User user = userService.findById(userId);
        user.setPasswordHash(passwordHash);
        userService.save(user);
    }
}
