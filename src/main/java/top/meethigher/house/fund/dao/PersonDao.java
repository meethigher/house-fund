package top.meethigher.house.fund.dao;

import top.meethigher.house.fund.domain.Person;

import java.util.List;

/**
 * @author https://github.com/meethigher
 */
public interface PersonDao {
    int insert(Person person);

    int update(Person person);

    int close(String accnum);

    Person queryByAccNum(String accnum);

    List<Person> findAll();

    int findTotalCount();

    List<Person> findByPage(int start, int rows);
}
