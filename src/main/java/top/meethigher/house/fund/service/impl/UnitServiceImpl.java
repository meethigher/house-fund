package top.meethigher.house.fund.service.impl;

import top.meethigher.house.fund.dao.impl.AccNumControlDaoImpl;
import top.meethigher.house.fund.dao.impl.UnitDaoImpl;
import top.meethigher.house.fund.domain.Page;
import top.meethigher.house.fund.domain.Unit;
import top.meethigher.house.fund.service.UnitService;

import java.text.ParseException;
import java.util.List;

/**
 * @author https://github.com/meethigher
 */
public class UnitServiceImpl implements UnitService {
    private UnitDaoImpl unitDao = new UnitDaoImpl();
    private AccNumControlDaoImpl anControl = new AccNumControlDaoImpl();

    @Override
    public int insert(Unit unit) {
        return unitDao.insert(unit);
    }

    @Override
    public int update(Unit unit) {
        return unitDao.update(unit);
    }

    @Override
    public int close(String unitaccnum) {
        return unitDao.close(unitaccnum);
    }

    @Override
    public Page<Unit> findUnitByPage(String _currentPage, String _rows) {
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);
        int totalCount = unitDao.findTotalCount();
        int totalPage = (totalCount % rows) == 0 ? totalCount / rows : (totalCount / rows) + 1;
        if (currentPage < 0) {
            currentPage = 1;
        }
        if (currentPage > totalPage) {
            currentPage = totalPage;
        }
        Page<Unit> unitPage = new Page<>();
        unitPage.setCurrentPage(currentPage);
        unitPage.setRows(rows);


        unitPage.setTotalCount(totalCount);

        int start = (currentPage - 1) * rows;

        List<Unit> byPage = unitDao.findByPage(start, rows);
        unitPage.setList(byPage);


        unitPage.setTotalPage(totalPage);

        return unitPage;
    }


    @Override
    public int getUnitSeq() {
        return anControl.findSeqByUnit();
    }

    @Override
    public int updateUnitSeq(int seq) {
        return anControl.updateUnitSeq(seq);
    }

    @Override
    public Unit findByAccNum(String unitaccnum) {
        return unitDao.findByAccNum(unitaccnum);
    }


    /**
     * String format中
     * %0 表示补0
     * 12 表示位数长度
     * d 表示整型
     *
     * @return 获取格式化后的序号
     */
    @Override
    public String getSeq() {
        int seq = getUnitSeq();
        if (seq > 0) {
            String accnum = String.format("%0" + 12 + "d", seq);
            return accnum;
        } else {
            return null;
        }
    }

    @Override
    public String getCurrentTime() throws ParseException {
        return anControl.getCurrentTime();
    }
}
