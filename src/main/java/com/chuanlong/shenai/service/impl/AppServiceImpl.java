package com.chuanlong.shenai.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chuanlong.shenai.model.entity.App;
import com.chuanlong.shenai.model.entity.User;
import com.chuanlong.shenai.model.vo.AppVO;
import com.chuanlong.shenai.model.vo.UserVO;
import com.chuanlong.shenai.service.AppService;
import com.chuanlong.shenai.mapper.AppMapper;
import com.chuanlong.shenai.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
* @author echollk
* @description 针对表【app(应用)】的数据库操作Service实现
* @createDate 2026-01-21 01:18:29
*/
@Service
public class AppServiceImpl extends ServiceImpl<AppMapper, App>
    implements AppService{

    @Resource
    private UserService userService;

    @Override
    public AppVO getAppVO(App app) {
        if (app == null) {
            return null;
        }
        AppVO appVO = new AppVO();
        BeanUtil.copyProperties(app, appVO);
        // 关联查询用户信息
        Long userId = app.getUserId();
        if (userId != null) {
            User user = userService.getById(userId);
            UserVO userVO = userService.getUserVO(user);
            appVO.setUser(userVO);
        }
        return appVO;
    }
}




