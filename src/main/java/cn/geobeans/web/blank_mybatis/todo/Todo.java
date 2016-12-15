package cn.geobeans.web.blank_mybatis.todo;

import java.util.Date;

/**
 * 待办事项实体
 * Created by ghx on 2016/12/13.
 */
public class Todo {

    private Integer id;
    private String text;
    private boolean finish = false;
    private Date created = new Date();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isFinish() {
        return finish;
    }

    public void setFinish(boolean finish) {
        this.finish = finish;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
