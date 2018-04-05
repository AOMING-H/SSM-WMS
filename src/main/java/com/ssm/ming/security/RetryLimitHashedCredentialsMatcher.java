package com.ssm.ming.security;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.ehcache.EhCacheManager;

/**
 * @author Wenming.Huang
 * @date 2018-02-12
 * @version 1.0
 */
public class RetryLimitHashedCredentialsMatcher extends HashedCredentialsMatcher {
    // 声明一个缓存接口，这个接口是Shiro缓存管理的一部分，它的具体实现可以通过外部容器注入
    private Cache<String, AtomicInteger> passwordRetryCache;

    public RetryLimitHashedCredentialsMatcher(EhCacheManager cacheManager) {
        passwordRetryCache = cacheManager.getCache("passwordRetryCache");
    }

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        String account = (String) token.getPrincipal();
        AtomicInteger retryCount = passwordRetryCache.get(account);
        if (retryCount == null) {
            retryCount = new AtomicInteger(0);
            passwordRetryCache.put(account, retryCount);
        }
        // 自定义一个验证过程：当用户连续输入密码错误5次以上禁止用户登录一段时间
        if (retryCount.incrementAndGet() > 5) {
            throw new ExcessiveAttemptsException();
        }
        byte[] tokenBytes = toBytes(token.getCredentials());
        byte[] accountBytes = toBytes(info.getCredentials());
        boolean match = Arrays.equals(tokenBytes, accountBytes);
//        boolean match = super.doCredentialsMatch(token, info);
        if (match) {
            passwordRetryCache.remove(account);
        }
        return match;
    }
}
