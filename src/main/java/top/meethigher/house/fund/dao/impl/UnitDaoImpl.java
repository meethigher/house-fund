package top.meethigher.house.fund.dao.impl;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import top.meethigher.house.fund.dao.UnitDao;
import top.meethigher.house.fund.domain.Unit;
import top.meethigher.house.fund.util.JDBCUtils;

import java.util.List;

/**
 * @author https://github.com/meethigher
 */
public class UnitDaoImpl implements UnitDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public int insert(Unit unit) {
        try {
            String sql = "insert into tb002(" +
                    "unitaccnum," +
                    "unitaccname," +
                    "unitaddr," +
                    "orgcode," +
                    "unitchar," +
                    "unitkind," +
                    "salarydate," +
                    "unitphone," +
                    "unitlinkman," +
                    "unitagentpapno," +
                    "unitprop," +
                    "perprop," +
                    "op," +
                    "createdate," +
                    "remark" +
                    ") values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            int update = template.update(sql,
                    unit.getUnitaccnum(),
                    unit.getUnitaccname(),
                    unit.getUnitaddr(),
                    unit.getOrgcode(),
                    unit.getUnitchar(),
                    unit.getUnitkind(),
                    unit.getSalarydate(),
                    unit.getUnitphone(),
                    unit.getUnitlinkman(),
                    unit.getUnitagentpapno(),
                    unit.getUnitprop(),
                    unit.getPerprop(),
                    unit.getOp(),
                    unit.getCreatedate(),
                    unit.getRemark());
            return update;
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public int update(Unit unit) {
        try {
            String sql = "update tb002 set " +
                    "unitaccname=?," +
                    "unitaddr=?," +
                    "orgcode=?," +
                    "unitchar=?," +
                    "unitkind=?," +
                    "salarydate=?," +
                    "unitphone=?," +
                    "unitlinkman=?," +
                    "unitagentpapno=?," +
                    "remark=?" +
                    " where unitaccnum=?";
            int update = template.update(sql,
                    unit.getUnitaccname(),
                    unit.getUnitaddr(),
                    unit.getOrgcode(),
                    unit.getUnitchar(),
                    unit.getUnitkind(),
                    unit.getSalarydate(),
                    unit.getUnitphone(),
                    unit.getUnitlinkman(),
                    unit.getUnitagentpapno(),
                    unit.getRemark(),
                    unit.getUnitaccnum());
            return update;
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public int close(String unitaccnum) {
        try {
            String sql = "select persnum from tb002 where unitaccnum=?";
            Integer persnum = template.queryForObject(sql, Integer.class, unitaccnum);
            if (persnum > 0) {
                return -1;
            } else {
                String sql1 = "update tb002 set accstate=9 where unitaccnum=?";
                return template.update(sql1, unitaccnum);
            }
        } catch (Exception e) {
            return 0;
        }
    }


    @Override
    public Unit findByAccNum(String unitaccnum) {
        try {
            String sql = "select * from tb002 where accstate=0 and unitaccnum = ?";
            Unit unit = template.queryForObject(sql, new BeanPropertyRowMapper<Unit>(Unit.class), unitaccnum);
            return unit;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public int findTotalCount() {
        String sql = "select count(*) totalcount from tb002";
        return template.queryForObject(sql, Integer.class);
    }

    @Override
    public List<Unit> findByPage(int start, int rows) {
        String sql = "select * from tb002";
        StringBuilder stringBuilder = new StringBuilder(sql);
        stringBuilder.append(" limit ?,?");
        sql = stringBuilder.toString();
        return template.query(sql, new BeanPropertyRowMapper<Unit>(Unit.class), start, rows);
    }

}
