package com.zc.service;

import com.zc.domain.GlobalNav;
import com.zc.mapper.GlobalNavMapper;
import com.zc.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
public class GlobalNavService {

    @Autowired
    private GlobalNavMapper globalNavMapper;

    /*
    * 查询所有的首页导航栏列表
    * */
    public List<GlobalNav> getGlobalNavList() {

        return globalNavMapper.findAll();
    }

    /*
    * 新增
    * @params globalNav
    * */
    @Transactional
    public CommonResult addOne(GlobalNav globalNav) {
        if (globalNav.getName() == null || globalNav.getEnName() == null || globalNav.getHref() == null) {
            return CommonResult.paramsError("");
        } else {
            globalNav.setVisible(true);
            globalNav.setCreateTime(new Date());

            globalNavMapper.addOne(globalNav);

            return CommonResult.success(globalNav);
        }
    }

     /*
    * 编辑
    * @params id
    * @params name
    * @params enName
    * @params href
    * @params iconClassName
    * */
     @Transactional
    public CommonResult updateOne(String id, String name, String enName, String href, String iconClassName) {
         if (id == null || name == null || enName == null || href == null) {
             return CommonResult.paramsError("");
         } else {
             globalNavMapper.updateOne(id, name, enName, href, iconClassName);

             return CommonResult.success(globalNavMapper.findById(id));
         }
     }

    /*
    * 删除
    * */
    @Transactional
    public CommonResult deleteOne(GlobalNav globalNav) {
        if (globalNav.getId() == null) {
            return CommonResult.success("");
        } else {
            globalNavMapper.deleteOne(globalNav);

            return CommonResult.success("");
        }
    }
}
