package top.meethigher.house.fund.service;

import top.meethigher.house.fund.domain.Page;
import top.meethigher.house.fund.domain.Person;

import java.text.ParseException;

/**
 * @author https://github.com/meethigher
 * <p>
 * 个人的业务接口
 */
public interface PersonService {
    /**
     * 个人开户
     *
     * @param person
     * @return
     */
    int insert(Person person);

    /**
     * 通过公积金行号查询个人信息
     *
     * @param accnum
     * @return
     */
    Person queryByAccNum(String accnum);

    /**
     * 通过公积金账号更新用户的姓名、身份证号以及备注
     *
     * @param person
     * @return
     */
    int update(Person person);

    /**
     * 销户
     * 0-正常
     * 9-销户
     *
     * @param accnum
     * @return
     */
    int close(String accnum);

    /**
     * 查询分页的用户信息
     * 将当前的页数、总页数、数据总条数、每次读取条数，存储到Page的指定变量中
     * 将查询到的所有数据存入到List<Person>中
     *
     * @param currentPage
     * @param rows
     * @return
     */
    Page<Person> findPersonByPage(String currentPage, String rows);

    /**
     * 查询系统参数表中个人的peraccnum
     *
     * @return
     */
    int getPersonSeq();

    /**
     * 更新系统参数表中的peraccnum
     *
     * @param seq
     * @return
     */
    int updatePersonSeq(int seq);

    /**
     * 获取格式化后的个人公积金账号
     *
     * @return
     */
    String getSeq();

    /**
     * 获取当前的系统时间，用来作开户日期
     *
     * @return
     * @throws ParseException
     */
    String getCurrentTime() throws ParseException;
}
