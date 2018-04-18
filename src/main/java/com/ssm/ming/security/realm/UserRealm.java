package com.ssm.ming.security.realm;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.ssm.ming.domain.Permission;
import com.ssm.ming.domain.Role;
import com.ssm.ming.domain.User;
import com.ssm.ming.service.UserService;
import com.ssm.ming.service.impl.UserServiceImpl;

/**
 * @author Wenming.Huang
 * @date 2018-02-12
 * @version 1.0
 */
public class UserRealm extends AuthorizingRealm {
    // 用户对应的角色信息与权限信息都保存在数据库中，通过UserService获取数据
    @Autowired
    private UserService userService;

    /**
     * 提供用户信息返回权限信息
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = (String) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
//        // 根据用户名查询当前用户拥有的角色
//        Set<Role> roles = userService.findRoles(username);
//        Set<String> roleNames = new HashSet<String>();
//        for (Role role : roles) {
//            roleNames.add(role.getRole());
//        }
//        // 将角色名称提供给info
//        authorizationInfo.setRoles(roleNames);
//        // 根据用户名查询当前用户权限
//        Set<Permission> permissions = userService.findPermissions(username);
//        Set<String> permissionNames = new HashSet<String>();
//        for (Permission permission : permissions) {
//            permissionNames.add(permission.getPermission());
//        }
//        // 将权限名称提供给info
//        authorizationInfo.setStringPermissions(permissionNames);

        return authorizationInfo;
    }

    /**
     * 提供账户信息返回认证信息
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String account = (String) token.getPrincipal();
        User user = userService.findByAccount(account);
        if (user == null) {
            // 用户名不存在抛出异常
            throw new UnknownAccountException();
        }
//        if (user.getLocked() == 0) {
//            // 用户被管理员锁定抛出异常
//            throw new LockedAccountException();
//        }
        ByteSource credentialsSalt = null;
        if(user.getSalt() != null) {
            credentialsSalt = ByteSource.Util.bytes(user.getSalt());
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user.getAccount(),
                user.getPassword(), credentialsSalt, getName());
        return authenticationInfo;
    }
}
