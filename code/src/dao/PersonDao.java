package dao;

import domain.Page;
import domain.Person;

import java.util.List;
import java.util.Map;

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
