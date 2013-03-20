package net.abbreviations.core.util;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.springframework.util.Assert;
import net.abbreviations.core.application.InfrastructureException;

public abstract class HashCodeUtils
{
    public static String hashCode(String s)
    {
        Assert.notNull(s, "String is null");

        try
        {
            MessageDigest m = MessageDigest.getInstance("MD5");

            byte[] buf = s.getBytes("UTF-8");
            m.update(buf, 0, buf.length);
            BigInteger value = new BigInteger(1, m.digest());
            return String.format("%1$032X", value).toLowerCase();
        }
        catch (NoSuchAlgorithmException e)
        {
            throw new InfrastructureException("Failed to get message digest instance", e);
        }
        catch (UnsupportedEncodingException e)
        {
            throw new InfrastructureException("Failed to get string bytes", e);
        }
    }
}
