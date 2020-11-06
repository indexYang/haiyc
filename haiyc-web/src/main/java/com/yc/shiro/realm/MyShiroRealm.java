package com.yc.shiro.realm;

import com.yc.dto.login.LoginInfo;
import com.yc.entity.menu.BaseMenuPermissionEntity;
import com.yc.entity.user.BaseUserEntity;
import com.yc.service.menu.BaseMenuService;
import com.yc.service.user.BaseUserService;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    private BaseUserService baseUserService;

    @Autowired
    private BaseMenuService baseMenuService;

    @SneakyThrows
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        BaseUserEntity userInfo = new BaseUserEntity();
        PropertyUtils.copyProperties(userInfo, principals.getPrimaryPrincipal());
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        if (userInfo instanceof BaseUserEntity) {
            if (userInfo != null) {
                //查询该用户的所有按钮权限
                List<BaseMenuPermissionEntity> listPermissions = baseMenuService.listPermission(userInfo.getUserNo());
                if (CollectionUtils.isNotEmpty(listPermissions)) {
                    for (BaseMenuPermissionEntity menu : listPermissions) {
                        if (StringUtils.isNoneBlank(menu.getPermissionCode())) {
                            info.addStringPermission(menu.getPermissionCode());
                        }
                    }
                }
            }
        }
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //1.将token转换成UserNamePasswordToken
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        //2.获取用户名
        String username = (String) upToken.getPrincipal();
        String password = new String((char[]) upToken.getCredentials());
        //3.根据用户名查询
        LoginInfo userEntity = this.baseUserService.loginUser(username);
        if (userEntity == null) {
            throw new UnknownAccountException();
        }
        if (!password.equals(userEntity.getPassword())) {
            throw new IncorrectCredentialsException();
        }
        if (userEntity.getStatus() == 2) {
            throw new LockedAccountException();
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(userEntity, userEntity.getPassword(), getName());
        return info;
    }
}