package com.chuanlong.shenai.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chuanlong.shenai.model.dto.chathistory.ChatHistoryQueryRequest;
import com.chuanlong.shenai.model.entity.ChatHistory;
import com.baomidou.mybatisplus.extension.service.IService;
import com.chuanlong.shenai.model.entity.User;

import java.time.LocalDateTime;

/**
 * @author echollk
 * @description 针对表【chat_history(对话历史)】的数据库操作Service
 * @createDate 2026-01-22 23:10:46
 */
public interface ChatHistoryService extends IService<ChatHistory> {

    /**
     * 添加对话历史
     *
     * @param appId       应用 id
     * @param message     消息
     * @param messageType 消息类型
     * @param userId      用户 id
     * @return 是否成功
     */
    boolean addChatMessage(Long appId, String message, String messageType, Long userId);

    /**
     * 根据应用 id 删除对话历史
     *
     * @param appId
     * @return
     */
    boolean deleteByAppId(Long appId);


    Page<ChatHistory> listAppChatHistoryByPage(Long appId, int pageSize,
                                               LocalDateTime lastCreateTime,
                                               User loginUser);

    QueryWrapper getQueryWrapper(ChatHistoryQueryRequest chatHistoryQueryRequest);
}
