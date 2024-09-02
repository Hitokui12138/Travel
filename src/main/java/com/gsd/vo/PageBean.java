package com.gsd.vo;

import org.springframework.ui.Model;

import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName PageBean.java
 * @Description 分页类
 * @createTime 2023年09月11日 10:29:00
 */
public class PageBean {
    private List list;
    private int curPage;
    private int pages;


    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}
