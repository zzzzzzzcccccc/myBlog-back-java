package com.zc.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class OutsideArticle {

    @Id
    @GeneratedValue
    private Long id;

    private String articleTitle;

    private String articleImageUrl;

    private String articleHref;

    private String articleAuthor;

    private String articleSource;

    private Integer visitCount;

    private Integer articleLikeCount;

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

    public String getArticleImageUrl() {
        return articleImageUrl;
    }

    public void setArticleImageUrl(String articleImageUrl) {
        this.articleImageUrl = articleImageUrl;
    }

    public String getArticleHref() {
        return articleHref;
    }

    public void setArticleHref(String articleHref) {
        this.articleHref = articleHref;
    }

    public String getArticleAuthor() {
        return articleAuthor;
    }

    public void setArticleAuthor(String articleAuthor) {
        this.articleAuthor = articleAuthor;
    }

    public String getArticleSource() {
        return articleSource;
    }

    public void setArticleSource(String articleSource) {
        this.articleSource = articleSource;
    }

    public Integer getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(Integer visitCount) {
        this.visitCount = visitCount;
    }

    public Integer getArticleLikeCount() {
        return articleLikeCount;
    }

    public void setArticleLikeCount(Integer articleLikeCount) {
        this.articleLikeCount = articleLikeCount;
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
        return "OutsideArticle{" +
                "id=" + id +
                ", articleTitle='" + articleTitle + '\'' +
                ", articleImageUrl='" + articleImageUrl + '\'' +
                ", articleHref='" + articleHref + '\'' +
                ", articleAuthor='" + articleAuthor + '\'' +
                ", articleSource='" + articleSource + '\'' +
                ", visitCount=" + visitCount +
                ", articleLikeCount=" + articleLikeCount +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", articleTypeId=" + articleTypeId +
                '}';
    }
}
