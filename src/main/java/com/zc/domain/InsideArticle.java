package com.zc.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class InsideArticle {

    @Id
    @GeneratedValue
    private Long id;

    private String articleTitle;

    private String articleAuthor;

    private Integer articleLikeCount;

    private Integer visitCount;

    @Column(columnDefinition = "LONGTEXT")
    private String articleContent;

    private String remark;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date updateTime;

    private Long articleTypeId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleAuthor() {
        return articleAuthor;
    }

    public void setArticleAuthor(String articleAuthor) {
        this.articleAuthor = articleAuthor;
    }

    public Integer getArticleLikeCount() {
        return articleLikeCount;
    }

    public void setArticleLikeCount(Integer articleLikeCount) {
        this.articleLikeCount = articleLikeCount;
    }

    public Integer getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(Integer visitCount) {
        this.visitCount = visitCount;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getArticleTypeId() {
        return articleTypeId;
    }

    public void setArticleTypeId(Long articleTypeId) {
        this.articleTypeId = articleTypeId;
    }

    @Override
    public String toString() {
        return "InsideArticle{" +
                "id=" + id +
                ", articleTitle='" + articleTitle + '\'' +
                ", articleAuthor='" + articleAuthor + '\'' +
                ", articleLikeCount=" + articleLikeCount +
                ", visitCount=" + visitCount +
                ", articleContent='" + articleContent + '\'' +
                ", remark='" + remark + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", articleTypeId=" + articleTypeId +
                '}';
    }
}
