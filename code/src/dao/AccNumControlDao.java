package dao;

import java.text.ParseException;
import java.util.Date;

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
