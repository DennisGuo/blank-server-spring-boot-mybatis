package cn.geobeans.web.blank_mybatis.todo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by ghx on 2016/12/15.
 */
@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringJUnit4ClassRunner.class)
public class TodoControllerTest {
    private long before = 0;

    @Autowired
    WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
        before = System.currentTimeMillis();
    }

    @After
    public void after(){
        long after = System.currentTimeMillis();
        System.out.println("耗时："+(after - before)+" 毫秒");
    }

    @Test
    public void get() throws Exception {
        String rsp = mockMvc
                .perform(MockMvcRequestBuilders.get("/api/todo"))
                .andReturn()
                .getResponse()
                .getContentAsString();

        System.out.println(rsp);
    }

}
