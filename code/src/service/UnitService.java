package service;

import domain.Page;
import domain.Unit;

import java.text.ParseException;

/**
 * @author https://github.com/meethigher
 * <p>
 * 单位的业务接口
 */
public interface UnitService {
    /**
     * 单位开户
     *
     * @param unit
     * @return
     */
    int insert(Unit unit);


    /**
     * 单位信息修改
     *
     * @param unit
     * @return
     */
    int update(Unit unit);

    /**
     * 销户
     * 0-正常
     * 9-销户
     *
     * @param unitaccnum
     * @return
     */
    int close(String unitaccnum);

    /**
     * 查询分页的单位信息
     * 将当前的页数、总页数、数据总条数、每次读取条数，存储到Page的指定变量中
     * 将查询到的所有数据存入到List<Unit>中
     *
     * @param currentPage
     * @param rows
     * @return
     */
    Page<Unit> findUnitByPage(String currentPage, String rows);

    /**
     * 查询系统参数表中unitaccnum
     *
     * @return
     */
    int getUnitSeq();

    /**
     * 更新系统参数表中的accnum
     *
     * @param seq
     * @return
     */
    int updateUnitSeq(int seq);

    /**
     * 通过公积金行号查询单位信息
     *
     * @param unitaccnum
     * @return
     */
    Unit findByAccNum(String unitaccnum);

    /**
     * 获取格式化后的公积金账号
     *
     * @return
     */
    String getSeq();

    /**
     * 获取当前时间，用作开户日期
     *
     * @return
     * @throws ParseException
     */
    String getCurrentTime() throws ParseException;
}
