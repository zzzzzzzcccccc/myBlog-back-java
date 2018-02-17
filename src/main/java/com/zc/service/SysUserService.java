package com.zc.service;

import com.zc.domain.SysModule;
import com.zc.domain.SysRole;
import com.zc.domain.SysUser;
import com.zc.enums.CommonEnums;
import com.zc.mapper.SysModuleMapper;
import com.zc.mapper.SysRoleMapper;
import com.zc.mapper.SysUserMapper;
import com.zc.utils.Common;
import com.zc.utils.CommonLogger;
import com.zc.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Autowired
    private SysModuleMapper sysModuleMapper;

    /*
    * 登录
    * @params sysUser
    * */
    public CommonResult accountLogin(SysUser sysUser) {
        if (sysUser.getUsername() == null || sysUser.getPassword() == null) {
            return CommonResult.paramsError("");
        } else if (sysUserMapper.checkLogin(sysUser) != 1) { // 验证账号密码
            return CommonResult.error(CommonEnums.LOGIN_ERROR.getCode(), CommonEnums.LOGIN_ERROR.getMsg());
        } else if (!sysUserMapper.findByUsername(sysUser).getVisible()) { // 验证是否可以启用
            return CommonResult.error(CommonEnums.LOGIN_VISIBLE.getCode(), CommonEnums.LOGIN_VISIBLE.getMsg());
        } else {
            Map<String, Object> map = new HashMap<String, Object>();

            Long roleId = sysUserMapper.findByUsername(sysUser).getRoleId();
            SysRole sysRole = sysRoleMapper.findById(roleId);
            List<SysModule> sysModules = sysModuleMapper.findByIds(Common.getSplitToArray(sysRole.getAuthorityList(), ","));

            map.put("sysRole", sysRole);
            map.put("sysModules", sysModules);

            return CommonResult.success(map);
        }
    }

    /*
    * 新增一个账号
    * */
    @Transactional
    public CommonResult addOne(SysUser sysUser) {
        if (sysUser.getUsername() == null || sysUser.getPassword() == null || sysUser.getRoleId() == null || sysUser.getVisible() == null) {
            return CommonResult.paramsError("");
        } else if (sysUserMapper.checkAddOne(sysUser.getUsername()) != 0) {
            return CommonResult.error(CommonEnums.USER_NAME_INFO.getCode(), CommonEnums.USER_NAME_INFO.getMsg());
        } else {
            sysUser.setCreateTime(new Date());
            sysUserMapper.addOne(sysUser);

            return CommonResult.success(sysUser);
        }
    }
}
