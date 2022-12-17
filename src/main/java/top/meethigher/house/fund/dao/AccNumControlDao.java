package top.meethigher.house.fund.dao;

import java.text.ParseException;

/**
 * @author https://github.com/meethigher
 */
public interface AccNumControlDao {
    int findSeqByUnit();

    int findSeqByPerson();

    int updateUnitSeq(int seq);

    int updatePersonSeq(int seq);

    String getCurrentTime() throws ParseException;
}
