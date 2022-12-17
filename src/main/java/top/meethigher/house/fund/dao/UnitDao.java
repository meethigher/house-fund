package top.meethigher.house.fund.dao;

import top.meethigher.house.fund.domain.Unit;

import java.util.List;

/**
 * @author https://github.com/meethigher
 */
public interface UnitDao {
    int insert(Unit unit);

    int update(Unit unit);

    int close(String unitaccnum);

    Unit findByAccNum(String unitaccnum);

    int findTotalCount();

    List<Unit> findByPage(int start, int rows);
}
