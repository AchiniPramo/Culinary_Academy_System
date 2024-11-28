package lk.ijse.dao.custom.impl;

import lk.ijse.dao.custom.CulinaryProgramDAO;
import lk.ijse.db.FactoryConfiguration;
import lk.ijse.entity.CulinaryProgram;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class CulinaryProgramDAOImpl implements CulinaryProgramDAO {

    @Override
    public void saveCulinaryProgram(CulinaryProgram culinaryProgram) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(culinaryProgram);

        transaction.commit();
        session.close();
    }

    @Override
    public void deleteCulinaryProgram(CulinaryProgram culinaryProgram) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.delete(culinaryProgram);

        transaction.commit();
        session.close();
    }

    @Override
    public void updateCulinaryProgram(CulinaryProgram culinaryProgram) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.update(culinaryProgram);

        transaction.commit();
        session.close();
    }

    @Override
    public List<CulinaryProgram> getAllCulinaryProgram() {
        List<CulinaryProgram> culinaryPrograms;
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        culinaryPrograms = session.createQuery("from CulinaryProgram", CulinaryProgram.class).list();

        transaction.commit();
        session.close();

        return culinaryPrograms;
    }

    @Override
    public CulinaryProgram getProgramsCheckName(String programName){
        CulinaryProgram culinaryPrograms = null;

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM CulinaryProgram c WHERE c.programName = :programName";
        Query<CulinaryProgram> query = session.createQuery(hql, CulinaryProgram.class);
        query.setParameter("programName", programName);

        culinaryPrograms = query.uniqueResult();

        transaction.commit();
        session.close();

        return culinaryPrograms;
    }

    @Override
    public CulinaryProgram getCulinaryProgram(String programId){
        CulinaryProgram culinaryProgram = null;
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        culinaryProgram = session.get(CulinaryProgram.class, programId);

        transaction.commit();
        session.close();

        return culinaryProgram;
    }

    @Override
    public Long getCulinaryProgramCount(){
        Long count = 0L;
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "SELECT COUNT(c) FROM CulinaryProgram c";
        Query<Long> query = session.createQuery(hql, Long.class);

        count = query.uniqueResult();

        transaction.commit();
        session.close();

        return count;
    }
}
