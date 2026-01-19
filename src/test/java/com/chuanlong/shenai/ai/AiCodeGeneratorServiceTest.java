package com.chuanlong.shenai.ai;

import dev.langchain4j.exception.InvalidRequestException;
import dev.langchain4j.exception.TimeoutException;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AiCodeGeneratorServiceTest {

    @Resource
    private AiCodeGeneratorService aiCodeGeneratorService;

    @Test
    void generateHtmlCode() {
        try {
            System.out.println("========================================");
            System.out.println("开始生成 HTML 代码...");
            System.out.println("用户输入: 做一个英雄联盟网游的新官网");
            System.out.println("========================================");
            
            String result = aiCodeGeneratorService.generateHtmlCode("做一个英雄联盟网游的新官网，不超过10行");
            
            System.out.println("========================================");
            System.out.println("✅ 生成成功！");
            System.out.println("结果长度: " + (result != null ? result.length() : 0) + " 字符");
            System.out.println("========================================");
            System.out.println("生成的代码内容:");
            System.out.println("----------------------------------------");
            System.out.println(result);
            System.out.println("----------------------------------------");
            
            Assertions.assertNotNull(result, "生成的结果不能为空");
            Assertions.assertFalse(result.trim().isEmpty(), "生成的结果不能为空字符串");
        } catch (InvalidRequestException e) {
            System.err.println("========================================");
            System.err.println("❌ API 请求错误");
            System.err.println("错误类型: InvalidRequestException");
            System.err.println("错误信息: " + e.getMessage());
            if (e.getMessage() != null && e.getMessage().contains("402")) {
                System.err.println("⚠️  原因: API 余额不足，请充值后重试");
            } else if (e.getMessage() != null && e.getMessage().contains("401")) {
                System.err.println("⚠️  原因: API Key 无效或已过期");
            }
            System.err.println("========================================");
            e.printStackTrace();
            throw e;
        } catch (TimeoutException e) {
            System.err.println("========================================");
            System.err.println("❌ 请求超时错误");
            System.err.println("错误类型: TimeoutException");
            System.err.println("错误信息: " + e.getMessage());
            System.err.println("⚠️  原因: API 响应超时，可能是网络问题或 API 服务响应慢");
            System.err.println("建议: 检查网络连接或增加超时配置");
            System.err.println("========================================");
            e.printStackTrace();
            throw e;
        } catch (Exception e) {
            System.err.println("========================================");
            System.err.println("❌ 生成代码时发生未知错误");
            System.err.println("错误类型: " + e.getClass().getName());
            System.err.println("错误信息: " + e.getMessage());
            System.err.println("========================================");
            e.printStackTrace();
            throw e;
        }
    }

    @Test
    void generateMultiFileCode() {
        try {
            System.out.println("========================================");
            System.out.println("开始生成多文件代码...");
            System.out.println("用户输入: 做一个英雄联盟网游的新官网");
            System.out.println("========================================");
            
            String result = aiCodeGeneratorService.generateMultiFileCode("做一个英雄联盟网游的新官网");
            
            System.out.println("========================================");
            System.out.println("✅ 生成成功！");
            System.out.println("结果长度: " + (result != null ? result.length() : 0) + " 字符");
            System.out.println("========================================");
            System.out.println("生成的代码内容:");
            System.out.println("----------------------------------------");
            System.out.println(result);
            System.out.println("----------------------------------------");
            
            Assertions.assertNotNull(result, "生成的结果不能为空");
            Assertions.assertFalse(result.trim().isEmpty(), "生成的结果不能为空字符串");
        } catch (InvalidRequestException e) {
            System.err.println("========================================");
            System.err.println("❌ API 请求错误");
            System.err.println("错误类型: InvalidRequestException");
            System.err.println("错误信息: " + e.getMessage());
            if (e.getMessage() != null && e.getMessage().contains("402")) {
                System.err.println("⚠️  原因: API 余额不足，请充值后重试");
            } else if (e.getMessage() != null && e.getMessage().contains("401")) {
                System.err.println("⚠️  原因: API Key 无效或已过期");
            }
            System.err.println("========================================");
            e.printStackTrace();
            throw e;
        } catch (TimeoutException e) {
            System.err.println("========================================");
            System.err.println("❌ 请求超时错误");
            System.err.println("错误类型: TimeoutException");
            System.err.println("错误信息: " + e.getMessage());
            System.err.println("⚠️  原因: API 响应超时，可能是网络问题或 API 服务响应慢");
            System.err.println("建议: 检查网络连接或增加超时配置");
            System.err.println("========================================");
            e.printStackTrace();
            throw e;
        } catch (Exception e) {
            System.err.println("========================================");
            System.err.println("❌ 生成代码时发生未知错误");
            System.err.println("错误类型: " + e.getClass().getName());
            System.err.println("错误信息: " + e.getMessage());
            System.err.println("========================================");
            e.printStackTrace();
            throw e;
        }
    }
}