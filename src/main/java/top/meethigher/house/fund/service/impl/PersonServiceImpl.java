package top.meethigher.house.fund.service.impl;

import top.meethigher.house.fund.dao.impl.AccNumControlDaoImpl;
import top.meethigher.house.fund.dao.impl.PersonDaoImpl;
import top.meethigher.house.fund.domain.Page;
import top.meethigher.house.fund.domain.Person;
import top.meethigher.house.fund.service.PersonService;

import java.text.ParseException;
import java.util.List;

/**
 * @author https://github.com/meethigher
 */
public class PersonServiceImpl implements PersonService {
    private AccNumControlDaoImpl anControl = new AccNumControlDaoImpl();
    private PersonDaoImpl personDao = new PersonDaoImpl();

    @Override
    public int insert(Person person) {
        return personDao.insert(person);
    }

    @Override
    public Person queryByAccNum(String accnum) {
        return personDao.queryByAccNum(accnum);
    }

    @Override
    public int update(Person person) {
        return personDao.update(person);
    }

    @Override
    public int close(String accnum) {
        return personDao.close(accnum);
    }


    @Override
    public int getPersonSeq() {
        return anControl.findSeqByPerson();
    }

    @Override
    public int updatePersonSeq(int seq) {
        return anControl.updatePersonSeq(seq);
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
        int seq = getPersonSeq();
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

    @Override
    public Page<Person> findPersonByPage(String _currentPage, String _rows) {
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);
        int totalCount = personDao.findTotalCount();
        int totalPage = (totalCount % rows) == 0 ? totalCount / rows : (totalCount / rows) + 1;
        if (currentPage < 0) {
            currentPage = 1;
        }
        if (currentPage > totalPage) {
            currentPage = totalPage;
        }
        Page<Person> personPage = new Page<>();
        personPage.setCurrentPage(currentPage);
        personPage.setRows(rows);


        personPage.setTotalCount(totalCount);

        int start = (currentPage - 1) * rows;

        List<Person> byPage = personDao.findByPage(start, rows);
        personPage.setList(byPage);


        personPage.setTotalPage(totalPage);

        return personPage;
    }
}
