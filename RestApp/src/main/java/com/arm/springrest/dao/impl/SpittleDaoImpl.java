package com.arm.springrest.dao.impl;

import com.arm.springrest.dao.BaseDao;
import com.arm.springrest.dao.SpittleDao;
import com.arm.springrest.model.Spittle;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Repository(value="spittleDao")
public class SpittleDaoImpl extends BaseDao<Spittle,Long> implements SpittleDao {

    private static Logger logger = LoggerFactory.getLogger(SpittleDaoImpl.class);

    @Override
    public List<Spittle> findLatest(int maxperiod) {

        logger.info("maxperiod: "+maxperiod);
        //convert negative max period to find recent splittes: es. sysdate -20
        maxperiod *= -1;
        logger.info("maxperiod after conversion: "+maxperiod);


        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DATE, maxperiod);
        DateFormat df = new SimpleDateFormat("dd-MM-YYYY");

        Query query = getSession().createQuery(
                "from com.arm.springrest.model.Spittle s "
                        + "where s.insert_date BETWEEN TO_DATE('"+df.format(cal.getTime())+"', 'dd-MM-YYYY')"
                        + "AND TO_DATE('"+df.format(new Date())+"', 'dd-MM-YYYY' )"
                        + "order by s.insert_date desc"
        );


        return (List<Spittle>) query.getResultList();
    }
}
