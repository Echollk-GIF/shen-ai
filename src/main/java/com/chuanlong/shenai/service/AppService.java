package com.chuanlong.shenai.service;

import cn.hutool.core.bean.BeanUtil;
import com.chuanlong.shenai.model.entity.App;
import com.baomidou.mybatisplus.extension.service.IService;
import com.chuanlong.shenai.model.entity.User;
import com.chuanlong.shenai.model.vo.AppVO;
import com.chuanlong.shenai.model.vo.UserVO;

/**
* @author echollk
* @description 针对表【app(应用)】的数据库操作Service
* @createDate 2026-01-21 01:18:29
*/
public interface AppService extends IService<App> {
    AppVO getAppVO(App app);
}
