package com.zc.utils;

/*
* 分页封装
* */
public class CommonPage {

    private Integer pageNum = 1;

    private Integer pageSize = 10;

    private Integer totalPage;

    private Integer total;

    private Integer limitPageNum;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPage() {

        return (this.total + this.pageSize - 1) / this.pageSize;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getLimitPageNum() {
        return (this.pageNum - 1) * this.pageSize;
    }

    @Override
    public String toString() {
        return "CommonPage{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", totalPage=" + totalPage +
                ", total=" + total +
                ", limitPageNum=" + limitPageNum +
                '}';
    }
}
