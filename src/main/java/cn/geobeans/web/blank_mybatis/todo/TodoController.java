package cn.geobeans.web.blank_mybatis.todo;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ghx on 2016/12/13.
 */
@RestController
@RequestMapping("/api/todo")
@Api(value = "/api/todo",description = "待办事项")
public class TodoController {

    @Autowired
    TodoService service;

    public static final String GET_LIST = "";


    /**
     * 分页获取代办事项
     * @param page  页码
     * @param limit 每页数量
     * @param order 顺序：id.desc,created.desc
     * @return 分页列表
     */
    @ApiOperation(value = "分页获取待办事项",notes = "分页获取待办事项")
    @RequestMapping(path = GET_LIST,method = {RequestMethod.GET,RequestMethod.POST})
    public PageList<Todo> findAll(@RequestParam(value = "page",required = false) Integer page,
                                  @RequestParam(value = "limit",required = false) Integer limit,
                                  @RequestParam(value = "order",required = false) String order){
        return service.findALL(page,limit,order);
    }
}
