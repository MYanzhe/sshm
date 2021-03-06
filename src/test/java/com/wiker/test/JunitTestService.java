package com.wiker.test;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.q.app.entity.TestEntity;
import com.q.app.service.TestService;

/**
 * Created by wiker on 2016-06-22.
 */
public class JunitTestService extends BaseProductionProfiles {

    @Autowired
    private TestService testService;

    @Test
    public void testDao(){
        TestEntity test = new TestEntity();
        test.setContent("测试的内容");
        //插入数据
        testService.add(test);
        
        //查询数据
        List<TestEntity> list = (List<TestEntity>) testService.getAll();
        for(TestEntity t:list){
        	System.out.println("Content:"+t.getContent());
        }
        
    }
}
