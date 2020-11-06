package com.yc.dto.user;

import cn.hutool.core.collection.CollectionUtil;
import com.yc.entity.role.BaseRoleEntity;
import com.yc.entity.user.BaseUserEntity;
import com.yc.entity.user.BaseUserRoleEntity;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description 用户信息dto
 * @Author 村子里最好的剑
 * @Date 2020-10-29 16:23
 */
public class BaseUserDto extends BaseUserEntity {

    //创建人
    private String creatorName;

    //修改人
    private String modifierName;

    //角色关系集
    private List<BaseUserRoleEntity> userRoles;

    //角色集
    private List<BaseRoleEntity> roles;

    //角色名称
    private String roleNames;

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public String getModifierName() {
        return modifierName;
    }

    public void setModifierName(String modifierName) {
        this.modifierName = modifierName;
    }

    public List<BaseUserRoleEntity> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<BaseUserRoleEntity> userRoles) {
        this.userRoles = userRoles;
    }

    public List<BaseRoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(List<BaseRoleEntity> roles) {
        this.roles = roles;
    }

    public String getRoleNames() {
        if(CollectionUtil.isNotEmpty(this.roles)){
            roleNames = roles.stream().map(BaseRoleEntity::getRoleName).collect(Collectors.joining(","));
        }
        return roleNames;
    }

    public void setRoleNames(String roleNames) {
        this.roleNames = roleNames;
    }
}
