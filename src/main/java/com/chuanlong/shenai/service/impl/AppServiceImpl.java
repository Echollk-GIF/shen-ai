package com.chuanlong.shenai.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chuanlong.shenai.exception.BusinessException;
import com.chuanlong.shenai.exception.ErrorCode;
import com.chuanlong.shenai.model.dto.app.AppQueryRequest;
import com.chuanlong.shenai.model.entity.App;
import com.chuanlong.shenai.model.entity.User;
import com.chuanlong.shenai.model.vo.AppVO;
import com.chuanlong.shenai.model.vo.UserVO;
import com.chuanlong.shenai.service.AppService;
import com.chuanlong.shenai.mapper.AppMapper;
import com.chuanlong.shenai.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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

    @Override
    public List<AppVO> getAppVOList(List<App> appList) {
        if (CollectionUtils.isEmpty(appList)) {
            return new ArrayList<>();
        }
        return appList.stream().map(this::getAppVO).collect(Collectors.toList());
    }


    @Override
    public QueryWrapper getQueryWrapper(AppQueryRequest appQueryRequest) {
        if (appQueryRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "请求参数为空");
        }
        Long id = appQueryRequest.getId();
        String appName = appQueryRequest.getAppName();
        String cover = appQueryRequest.getCover();
        String initPrompt = appQueryRequest.getInitPrompt();
        String codeGenType = appQueryRequest.getCodeGenType();
        String deployKey = appQueryRequest.getDeployKey();
        Integer priority = appQueryRequest.getPriority();
        Long userId = appQueryRequest.getUserId();
        String sortField = appQueryRequest.getSortField();
        String sortOrder = appQueryRequest.getSortOrder();
        QueryWrapper<App> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(Objects.nonNull(id), "id", id);
        queryWrapper.like(StrUtil.isNotBlank(appName), "appName", appName);
        queryWrapper.like(StrUtil.isNotBlank(cover), "cover", cover);
        queryWrapper.like(StrUtil.isNotBlank(initPrompt), "initPrompt", initPrompt);
        queryWrapper.eq(Objects.nonNull(codeGenType), "codeGenType", codeGenType);
        queryWrapper.eq(Objects.nonNull(deployKey), "deployKey", deployKey);
        queryWrapper.eq(Objects.nonNull(priority), "priority", priority);
        queryWrapper.eq(Objects.nonNull(userId), "userId", userId);
        queryWrapper.orderBy(StrUtil.isNotBlank(sortField), sortOrder.equals("ascend"), sortOrder);
        return queryWrapper;
    }

}




