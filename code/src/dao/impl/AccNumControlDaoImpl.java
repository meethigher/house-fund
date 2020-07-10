package dao.impl;

import dao.AccNumControlDao;
import domain.AccNumControl;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author https://github.com/meethigher
 */
public class AccNumControlDaoImpl implements AccNumControlDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public int findSeqByUnit() {
        try {
            String sql = "select * from tb001 where seqname='unitaccnum'";
            AccNumControl anc = template.queryForObject(sql, new BeanPropertyRowMapper<AccNumControl>(AccNumControl.class));
            int maxseq = anc.getMaxseq();
            int seq = anc.getSeq();
            if (seq >= maxseq) {
                return -1;
            } else {
                return seq;
            }
        } catch (Exception e) {
            return -1;
        }
    }

    @Override
    public int findSeqByPerson() {
        try {
            String sql = "select * from tb001 where seqname='peraccnum'";
            AccNumControl anc = template.queryForObject(sql, new BeanPropertyRowMapper<AccNumControl>(AccNumControl.class));
            int maxseq = anc.getMaxseq();
            int seq = anc.getSeq();
            if (seq >= maxseq) {
                return -1;
            } else {
                return seq;
            }
        } catch (Exception e) {
            return -1;
        }
    }

    @Override
    public int updateUnitSeq(int seq) {
        if (seq > 0) {
            String sql = "update tb001 set seq=? where seqname='unitaccnum'";
            int new_seq = ++seq;
            return template.update(sql, new_seq);
        }
        return 0;
    }

    @Override
    public int updatePersonSeq(int seq) {
        if (seq > 0) {
            String sql = "update tb001 set seq=? where seqname='peraccnum'";
            int new_seq = ++seq;
            return template.update(sql, new_seq);
        }
        return 0;
    }


    @Override
    public String getCurrentTime() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        return simpleDateFormat.format(date);
    }
}
