package com.chuanlong.shenai.ai;

import com.chuanlong.shenai.ai.model.HtmlCodeResult;
import com.chuanlong.shenai.ai.model.MultiFileCodeResult;
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
            HtmlCodeResult result = aiCodeGeneratorService.generateHtmlCode("做一个英雄联盟网游的新官网，不超过10行");
        } catch (InvalidRequestException e) {
            e.printStackTrace();
            throw e;
        } catch (TimeoutException e) {
            e.printStackTrace();
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Test
    void generateMultiFileCode() {
        try {
            MultiFileCodeResult result = aiCodeGeneratorService.generateMultiFileCode("做一个英雄联盟网游的新官网");
            Assertions.assertNotNull(result, "生成的结果不能为空");
        } catch (InvalidRequestException e) {
            e.printStackTrace();
            throw e;
        } catch (TimeoutException e) {
            e.printStackTrace();
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}