package com.oracleoaec.entity;

import java.util.Date;

/**
 * Created by Administrator on 2016/3/2.
 */
public class BookChapter
{
    private int id;
    private String name;
    private int chapterid;
    private int book_id;

    public BookChapter() {
    }

    public BookChapter(int id, String name, int chapterid, int book_id) {
        this.id = id;
        this.name = name;
        this.chapterid = chapterid;
        this.book_id = book_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getChapterid() {
        return chapterid;
    }

    public void setChapterid(int chapterid) {
        this.chapterid = chapterid;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    @Override
    public String toString() {
        return "BookChapter{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", chapterid=" + chapterid +
                ", book_id=" + book_id +
                '}';
    }
}
