package com.yc.service.user.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.yc.common.constant.Constant;
import com.yc.common.exception.BaseException;
import com.yc.common.result.ResultCodeEnum;
import com.yc.common.utils.CommonUtils;
import com.yc.common.utils.NumUtil;
import com.yc.common.utils.PagerWrapper;
import com.yc.common.utils.validation.Assert;
import com.yc.common.utils.validation.SaveGroup;
import com.yc.common.utils.validation.ValidationUtils;
import com.yc.common.utils.validation.ViolationMessage;
import com.yc.dao.menu.BaseMenuDao;
import com.yc.dao.role.BaseRoleDao;
import com.yc.dao.user.BaseUserDao;
import com.yc.dao.user.BaseUserRoleDao;
import com.yc.dto.login.LoginInfo;
import com.yc.dto.menu.UserMenuDto;
import com.yc.dto.user.BaseUserDto;
import com.yc.dto.user.UserRolePermissionsDto;
import com.yc.entity.menu.BaseMenuPermissionEntity;
import com.yc.entity.role.BaseRoleEntity;
import com.yc.entity.user.BaseUserEntity;
import com.yc.entity.user.BaseUserRoleEntity;
import com.yc.service.user.BaseUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Description 用户信息serviceImpl
 * @Author 村子里最好的剑
 * @Date 2020-10-29 16:40
 */
@Service
public class BaseUserServiceImpl implements BaseUserService {

    @Autowired
    private BaseUserDao baseUserDao;

    @Autowired
    private BaseMenuDao baseMenuDao;

    @Autowired
    private BaseUserRoleDao baseUserRoleDao;

    @Autowired
    private BaseRoleDao baseRoleDao;

    /**
     * 查询登录信息
     * @param username 用户名
     * @Date 2020-08-24 17:23
     * @return
     */
    @Override
    public LoginInfo loginUser(String username) {
        return baseUserDao.loginUser(username);
    }

    /**
     * 查询用户列表
     * @param correctPage 起始页
     * @param correctSize 页大小
     * @param baseUserDto
     * @Date 2020-09-27 09:41
     * @return List<BaseUserDto>
     */
    @Override
    public List<BaseUserDto> listUsers(int correctPage, int correctSize, BaseUserDto baseUserDto) {
        Map params = new HashMap<>(CommonUtils.initialCapacity(Constant.NUM_5));
        params.put("correctStart", PagerWrapper.correctStart(correctPage, correctSize));
        params.put("correctSize", correctSize);
        if(StringUtils.isNotEmpty(baseUserDto.getUserNo())){
            params.put("userNo", baseUserDto.getUserNo());
        }
        if(StringUtils.isNotEmpty(baseUserDto.getUserName())){
            params.put("userName", baseUserDto.getUserName());
        }
        if(StringUtils.isNotEmpty(baseUserDto.getPhone())){
            params.put("phone", baseUserDto.getPhone());
        }

        List<BaseUserDto> listUsers = this.baseUserDao.listUsers(params);
        if(CollectionUtil.isNotEmpty(listUsers)){
            for (BaseUserDto user: listUsers) {
                List<BaseRoleEntity> lisUserRole = baseRoleDao.queryUserRoles(user.getUserNo());
                if(CollectionUtil.isNotEmpty(lisUserRole)){
                    user.setRoles(lisUserRole);
                }
            }
        }
        return listUsers;
    }

    /**
     * 查询用户的总条数
     * @param baseUserDto
     * @Date 2020-09-27 09:42
     * @return int
     */
    @Override
    public int countUsers(BaseUserDto baseUserDto) {
        Map params = new HashMap<>(CommonUtils.initialCapacity(Constant.NUM_3));
        if(StringUtils.isNotEmpty(baseUserDto.getUserNo())){
            params.put("userNo", baseUserDto.getUserNo());
        }
        if(StringUtils.isNotEmpty(baseUserDto.getUserName())){
            params.put("userName", baseUserDto.getUserName());
        }
        if(StringUtils.isNotEmpty(baseUserDto.getPhone())){
            params.put("phone", baseUserDto.getPhone());
        }
        return this.baseUserDao.countUsers(params);
    }

    /**
     * 新增用户
     * @param baseUserDto
     * @Date 2020-09-27 09:58
     * @return void
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void addUser(BaseUserDto baseUserDto) {
        checkUser(baseUserDto);
        BaseUserEntity baseUserEntity = CommonUtils.transform(baseUserDto, BaseUserEntity.class);
        String userNo = NumUtil.trans(Constant.NUM_2020);
        baseUserEntity.setUserNo(userNo);
        baseUserEntity.setPassword("123456");
        baseUserEntity.setImgHead("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=323867538,4029617928&fm=26&gp=0.jpg");
        this.baseUserDao.insertSelective(baseUserEntity);
        //新增角色关系
        baseUserDto.getUserRoles().forEach(t ->{
            t.setUserNo(userNo);
        });
        baseUserRoleDao.insertList(baseUserDto.getUserRoles());
    }

    /**
     * 校验
     * @param baseUserDto
     */
    private void checkUser(BaseUserDto baseUserDto){
        if(StringUtils.isEmpty(baseUserDto.getUserName())){
            throw new BaseException(ResultCodeEnum.FAIL.code(), "", "用户名不能为空");
        }else{
            BaseUserEntity userEntity= baseUserDao.findUserName(baseUserDto.getUserNo(), baseUserDto.getUserName());
            if (userEntity != null){
                throw new BaseException(ResultCodeEnum.FAIL.code(), "", "用户名已经存在");
            }
        }
        if(StringUtils.isEmpty(baseUserDto.getPhone())){
            throw new BaseException(ResultCodeEnum.FAIL.code(), "", "手机号码不能为空");
        }else{
            BaseUserEntity userEntity= baseUserDao.findUserPhone(baseUserDto.getUserNo(), baseUserDto.getPhone());
            if (userEntity != null){
                throw new BaseException(ResultCodeEnum.FAIL.code(), "", "手机号码已经存在");
            }
        }
        if(CollectionUtil.isEmpty(baseUserDto.getUserRoles())){
            throw new BaseException(ResultCodeEnum.FAIL.code(), "", "请选择角色");
        }
    }

    /**
     * 修改用户
     * @param baseUserDto
     * @Date 2020-09-27 09:59
     * @return void
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void modifyUser(BaseUserDto baseUserDto) {
        checkUser(baseUserDto);
        BaseUserEntity userEntity = baseUserDao.selectByPrimaryKey(baseUserDto.getUserNo());
        if(null == userEntity){
            throw new BaseException(ResultCodeEnum.FAIL.code(), "", "该用户信息不存在，请核实");
        }
        userEntity.setUserName(baseUserDto.getUserName());
        userEntity.setPhone(baseUserDto.getPhone());
        userEntity.setBirthDate(baseUserDto.getBirthDate());
        //根据主键更新实体全部字段，null值会被更新
        this.baseUserDao.updateByPrimaryKey(userEntity);
        //删除角色关系
        this.baseUserRoleDao.delete(new BaseUserRoleEntity(userEntity.getUserNo()));
        //新增角色关系
        baseUserDto.getUserRoles().forEach(t ->{
            t.setUserNo(userEntity.getUserNo());
        });
        baseUserRoleDao.insertList(baseUserDto.getUserRoles());
    }

    /**
     * 用户详情
     * @param userNo 用户编码
     * @Date 2020-09-27 10:00
     * @return BaseUserDto
     */
    @Override
    public BaseUserDto getUser(String userNo) {
        BaseUserDto baseUserDto = baseUserDao.getUser(userNo);
        if(null != baseUserDto){
            List<BaseRoleEntity> lisUserRole = baseRoleDao.queryUserRoles(userNo);
            if(CollectionUtil.isNotEmpty(lisUserRole)){
                baseUserDto.setRoles(lisUserRole);
            }
        }
        return baseUserDto;
    }

    /**
     * 用户删除
     * @param baseUserEntity
     * @Date 2020-09-27 10:03
     * @return void
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delUser(BaseUserEntity baseUserEntity) {
        //根据主键更新属性不为null的值
        baseUserDao.updateByPrimaryKeySelective(baseUserEntity);
    }

    /**
     * 修改密码
     * @param oldPwd 旧密码
     * @param newPwd 新密码
     * @param confirmPwd 确认密码
     * @param userNo 用户编码
     * @Date 2020-10-10 13:28
     * @return void
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void doUpdatePwd(String oldPwd, String newPwd, String confirmPwd, String userNo) {
        if(StringUtils.isAnyBlank(oldPwd, newPwd, confirmPwd, userNo)){
            throw new BaseException(ResultCodeEnum.FAIL.code(), "", "参数不全");
        }
        if(!newPwd.equals(confirmPwd)){
            throw new BaseException(ResultCodeEnum.FAIL.code(), "", "密码不一致");
        }
        BaseUserEntity userEntity = baseUserDao.selectByPrimaryKey(userNo);
        if(null != userEntity){
            if(oldPwd.equals(userEntity.getPassword())){
                userEntity.setPassword(newPwd);
                userEntity.setModifyDate(new Date());
                this.baseUserDao.updateByPrimaryKey(userEntity);
            }else{
                throw new BaseException(ResultCodeEnum.FAIL.code(), "", "原密码错误");
            }
        }
    }

    /**
     * 重置密码
     * @param userNo 用户编码
     * @param loginUserNo 登录人的用户编码
     * @Date 2020-10-10 13:46
     * @return void
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void doResetPwd(String userNo, String loginUserNo) {
        if(StringUtils.isBlank(userNo)){
            throw new BaseException(ResultCodeEnum.FAIL.code(), "", "参数不全");
        }
        BaseUserEntity userEntity = baseUserDao.selectByPrimaryKey(userNo);
        if(null != userEntity){
            userEntity.setPassword("123456");
            userEntity.setModifyDate(new Date());
            userEntity.setModifierId(loginUserNo);
            this.baseUserDao.updateByPrimaryKey(userEntity);
        }
    }

    /**
     * 查询用户的菜单权限与按钮权限
     * @param userNo 用户编号
     * @Author yangch
     * @Date 2020-08-26 16:18
     * @return
     */
    @Override
    public UserRolePermissionsDto userRolePermission(String userNo) {
        UserRolePermissionsDto dto = new UserRolePermissionsDto();
        //查询该用户的所有菜单权限
        List<UserMenuDto> listUserMenu = listUserMenu(userNo);
        dto.setListMenus(listUserMenu);
        //查询该用户的所有按钮权限
        List<BaseMenuPermissionEntity> listPermissions = this.baseMenuDao.listPermission(userNo);
        dto.setListPermissions(listPermissions);
        return dto;
    }

    /**
     * 组装用户的菜单权限信
     * @param userNo 用户编号
     * @return
     */
    private List<UserMenuDto> listUserMenu(String userNo){
        //查询该用户的所有菜单权限
        List<UserMenuDto> listUserMenu = this.baseMenuDao.listUserMenu(userNo);
        //筛选出所有一级菜单
        List<UserMenuDto> firstUserMenus = listUserMenu.stream().filter(s->s.getParentMenuId().equals(0L)).collect(Collectors.toList());
        listUserMenu.removeAll(firstUserMenus);
        for (UserMenuDto userMenuDto : firstUserMenus){
            //获取父菜单下所有子菜单调用getChildList
            List<UserMenuDto> childList = getChildList(userMenuDto.getId(),listUserMenu);
            userMenuDto.setChild(childList);
        }
        return firstUserMenus;
    }

    private List<UserMenuDto> getChildList(Long id, List<UserMenuDto> listUserMenu) {
        //构建子菜单
        List<UserMenuDto> childList = new ArrayList<UserMenuDto>();
        //遍历传入的list
        for (int i = 0; i < listUserMenu.size(); i++) {
            UserMenuDto userMenuDto = listUserMenu.get(i);
            //所有菜单的父id与传入的根节点id比较，若相等则为该级菜单的子菜单
            if (userMenuDto.getParentMenuId().equals(id)){
                childList.add(userMenuDto);
                listUserMenu.remove(i);
                i--;
            }
        }
        for (UserMenuDto m : childList) {
            //递归
            m.setChild(getChildList(m.getId(),listUserMenu));
        }
        if (childList.size() == 0){
            return null;
        }
        return childList;
    }
}
