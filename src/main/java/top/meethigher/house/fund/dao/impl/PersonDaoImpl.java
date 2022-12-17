package top.meethigher.house.fund.dao.impl;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import top.meethigher.house.fund.dao.PersonDao;
import top.meethigher.house.fund.domain.Person;
import top.meethigher.house.fund.util.JDBCUtils;

import java.util.List;

/**
 * @author https://github.com/meethigher
 */
public class PersonDaoImpl implements PersonDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public int insert(Person person) {
        try {
            String sql = "insert into tb003(" +
                    "accnum," +
                    "accname," +
                    "papno," +
                    "unitaccnum," +
                    "opendate," +
                    "basenumber," +
                    "unitprop," +
                    "perprop," +
                    "unitmonpaysum," +
                    "permonpaysum," +
                    "op," +
                    "remark" +
                    ") values(?,?,?,?,?,?,?,?,?,?,?,?)";
            return template.update(sql,
                    person.getAccnum(),
                    person.getAccname(),
                    person.getPapno(),
                    person.getUnitaccnum(),
                    person.getOpendate(),
                    person.getBasenumber(),
                    person.getUnitprop(),
                    person.getPerprop(),
                    person.getUnitmonpaysum(),
                    person.getPermonpaysum(),
                    person.getOp(),
                    person.getRemark());
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int update(Person person) {
        try {
            String sql = "update tb003 set accname=?,papno=?,remark=? where accnum=?";
            return template.update(sql, person.getAccname(), person.getPapno(), person.getRemark(), person.getAccnum());
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public int close(String accnum) {
        try {
            String sql = "update tb003 set peraccstate=9 where accnum=?";
            return template.update(sql, accnum);
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public Person queryByAccNum(String accnum) {
        try {
            String sql = "select t1.*,t2.unitaccname from tb003 t1 join tb002 t2 where t1.peraccstate=0 and t1.unitaccnum=t2.unitaccnum and accnum=?";
            return template.queryForObject(sql, new BeanPropertyRowMapper<Person>(Person.class), accnum);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Person> findAll() {
        String sql = "select * from tb003";
        return template.query(sql, new BeanPropertyRowMapper<Person>(Person.class));
    }

    @Override
    public int findTotalCount() {
        String sql = "select count(*) totalcount from tb003";
        return template.queryForObject(sql, Integer.class);
    }

    @Override
    public List<Person> findByPage(int start, int rows) {
        String sql = "select * from tb003";
        StringBuilder stringBuilder = new StringBuilder(sql);
        stringBuilder.append(" limit ?,?");
        sql = stringBuilder.toString();
        return template.query(sql, new BeanPropertyRowMapper<Person>(Person.class), start, rows);
    }
}
