package com.pojo;

import java.util.List;

public class Page<T> {

    public static final Integer PAGE_SIZE = 4;

    private Integer pageNum;

    private Integer pageTotal;

    private Integer pageSize = PAGE_SIZE;

    private Integer pageTotalCount;

    private List<T> items;
    
    private String url;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        if (pageNum < 1) {
            pageNum = 1;
        }
        if (pageNum > pageTotal) {
            pageNum = pageTotal;
        }
        this.pageNum = pageNum;
    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {

        this.pageSize = pageSize;
    }

    public Integer getPageTotalCount() {
        return pageTotalCount;
    }

    public void setPageTotalCount(Integer pageTotalCount) {
        this.pageTotalCount = pageTotalCount;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

   

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Page [items=" + items + ", pageNum=" + pageNum + ", pageSize=" + pageSize + ", pageTotal=" + pageTotal
                + ", pageTotalCount=" + pageTotalCount + ", url=" + url + "]";
    }

    
}
