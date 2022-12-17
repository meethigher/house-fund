package top.meethigher.house.fund.domain;

import java.util.List;

/**
 * 分页对象
 *
 * @author https://github.com/meethigher
 */
public class Page<T> {
    private int totalCount;
    private int totalPage;
    private int currentPage;
    private int rows;//每页显示记录数
    private List<T> list;//每页的数据

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
