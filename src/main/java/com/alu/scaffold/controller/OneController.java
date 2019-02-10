package com.alu.scaffold.controller;

import com.alu.scaffold.dto.OneDO;
import com.alu.scaffold.service.OneService;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author jairy
 */
@Api(description ="demo接口")
@RestController
@RequestMapping("/api")
public class OneController {

    private final Logger logger = LoggerFactory.getLogger(OneController.class);

    @Resource
    private OneService oneService;
    @Autowired
    private RedisTemplate redisTemplate;

    @ApiOperation("mysqlTest")
    @GetMapping("/mysqlTest")
    public List<OneDO> mysqlTest(){
        return oneService.selectAll();
    }

    @ApiOperation("mysqlTest")
    @GetMapping(value = "/redisTest")
    public String redisTest() {
        try {
            // 缓存有效期2秒
            redisTemplate.opsForValue().set("test-key", "redis测试内容", 2, TimeUnit.SECONDS);
            logger.info("从Redis中读取数据：" + String.valueOf(redisTemplate.opsForValue().get("test-key")));

            TimeUnit.SECONDS.sleep(3);
            logger.info("等待3秒后尝试读取过期的数据：" + redisTemplate.opsForValue().get("test-key"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "OK";
    }


    /**
     * ThreadLocal
     */
    public void test() {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("demo-pool-%d").build();
        ExecutorService singleThreadPool = new ThreadPoolExecutor(1, 1,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

        singleThreadPool.execute(()-> System.out.println(Thread.currentThread().getName()));
        singleThreadPool.shutdown();

        Thread t = new Thread() {
            ThreadLocal<String> mStringThreadLocal = new ThreadLocal<>();

            @Override
            public void run() {
                super.run();
                mStringThreadLocal.set("droidyue.com");
                mStringThreadLocal.get();
            }
        };
        t.start();
    }

    public static void main(String[] args) {
        String a01 = "aa01";
        String a02 = "aa02";

        String a = a01+a02;

        System.out.print(a);

    }

}
