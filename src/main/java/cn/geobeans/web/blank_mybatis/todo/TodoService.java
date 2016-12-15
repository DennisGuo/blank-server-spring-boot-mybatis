package cn.geobeans.web.blank_mybatis.todo;

import com.github.miemiedev.mybatis.paginator.domain.Order;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ghx on 2016/12/13.
 */
@Service
public class TodoService {

    @Autowired
    TodoMapper mapper;

    public PageList<Todo> findALL(Integer page, Integer limit, String order) {
        page = page == null || page <= 0 ? 1:page;
        limit = limit ==null || limit <= 0 ? 5:limit;
        order = order == null ? "created.desc,id.desc" : order;
        PageBounds pageBounds = new PageBounds(page, limit , Order.formString(order));

        List list = mapper.selectAll(pageBounds);

        return (PageList<Todo>) list;
    }
}
