package com.zdj.web.model;

import java.util.List;

public class GoodCommentModel {
    private Integer avg;
    private List<CommentsModel> comments;

    public Integer getAvg() {
        return avg;
    }

    public void setAvg(Integer avg) {
        this.avg = avg;
    }

    public List<CommentsModel> getComments() {
        return comments;
    }

    public void setComments(List<CommentsModel> comments) {
        this.comments = comments;
    }
}
