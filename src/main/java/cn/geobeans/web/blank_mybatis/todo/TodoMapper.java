package cn.geobeans.web.blank_mybatis.todo;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ghx on 2016/12/13.
 */
@Mapper
@Repository
public interface TodoMapper {

    String TABLE = "TODO";
    String INSERT = "INSERT INTO " + TABLE + "(TEXT) VALUES(#{todo})";

    @Insert(INSERT)
    void insert(String todo);

    @Select("SELECT * from TODO")
    List<Todo> selectAll(PageBounds bounds);

    @SelectProvider(type = TodoSql.class,method = "selectWithIds")
    List<Todo> selectWithIds(@Param("ids") List<Integer> ids);

    /**
     * 成成动态SQL类
     */
    static class TodoSql{
        // 根据ID数组查询SQL
        public static String selectWithIds(@Param("ids") final List<Integer> ids){
            return new SQL(){{
                SELECT("*");
                FROM(TABLE);

                if(ids.size() > 0) {
                    StringBuilder sb = new StringBuilder("(");
                    for (Integer id : ids) {
                        sb.append(id + " ,");
                    }
                    String rs = sb.toString();
                    rs = rs.substring(0, rs.length() - 2) + ")";

                    WHERE("ID IN " + rs);
                }
            }}.toString();
        }
    }
}
