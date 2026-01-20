package com.chuanlong.shenai.service;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chuanlong.shenai.model.dto.app.AppQueryRequest;
import com.chuanlong.shenai.model.dto.user.UserQueryRequest;
import com.chuanlong.shenai.model.entity.App;
import com.baomidou.mybatisplus.extension.service.IService;
import com.chuanlong.shenai.model.entity.User;
import com.chuanlong.shenai.model.vo.AppVO;
import com.chuanlong.shenai.model.vo.UserVO;

import java.util.List;

/**
* @author echollk
* @description 针对表【app(应用)】的数据库操作Service
* @createDate 2026-01-21 01:18:29
*/
public interface AppService extends IService<App> {
    AppVO getAppVO(App app);

    /**
     * 获取应用封装类列表
     *
     * @param appList
     * @return
     */
    List<AppVO> getAppVOList(List<App> appList);

    /**
     * 获取查询条件
     *
     * @param appQueryRequest 查询条件
     * @return 查询条件
     */
    QueryWrapper<App> getQueryWrapper(AppQueryRequest appQueryRequest);
}
