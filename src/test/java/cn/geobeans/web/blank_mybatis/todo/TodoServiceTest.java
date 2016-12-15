package cn.geobeans.web.blank_mybatis.todo;

import com.alibaba.fastjson.JSON;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ghx on 2016/12/14.
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class TodoServiceTest {

    @Autowired
    TodoMapper mapper;
    @Autowired
    TodoService service;

    @Test
    public void saveText(){
        mapper.insert("The first text.");
        List<Todo> rs = mapper.selectAll(null);
        System.out.println(JSON.toJSONString(rs));
    }

    @Test
    public void pagination(){
        PageList<Todo> rs = service.findALL(1,2,null);
        System.out.println(JSON.toJSONString(rs.getPaginator()));
    }

    @Test
    public void dynamic(){
        List<Integer> ids =  new ArrayList<>();
        ids.add(1);
        ids.add(2);
        ids.add(4);
        List<Todo> rs = mapper.selectWithIds(ids);
        System.out.println(JSON.toJSONString(rs));
    }
}
