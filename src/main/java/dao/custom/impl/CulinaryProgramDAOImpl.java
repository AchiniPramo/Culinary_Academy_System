package dao.custom.impl;

import dao.custom.CulinaryProgramDAO;
import db.FactoryConfiguration;
import entity.CulinaryPrograms;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class CulinaryProgramDAOImpl implements CulinaryProgramDAO {
    @Override
    public void saveCulinaryProgram(CulinaryPrograms culinaryPrograms) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(culinaryPrograms);

        transaction.commit();
        session.close();
    }

    @Override
    public void deleteCulinaryProgram(CulinaryPrograms culinaryPrograms) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.delete(culinaryPrograms);

        transaction.commit();
        session.close();
    }

    @Override
    public void updateCulinaryProgram(CulinaryPrograms culinaryPrograms) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.update(culinaryPrograms);

        transaction.commit();
        session.close();
    }

    @Override
    public List<CulinaryPrograms> getAllCulinaryProgram() {
        List<CulinaryPrograms> culinaryProgramsList;
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        culinaryProgramsList = session.createQuery("from CulinaryPrograms", CulinaryPrograms.class).list();

        transaction.commit();
        session.close();

        return culinaryProgramsList;
    }

    @Override
    public CulinaryPrograms getProgramsCheckName(String programName) {
        CulinaryPrograms culinaryPrograms = null;

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM CulinaryPrograms c WHERE c.programName = :programName";
        Query<CulinaryPrograms> query = session.createQuery(hql, CulinaryPrograms.class);
        query.setParameter("programName", programName);

        culinaryPrograms = query.uniqueResult();

        transaction.commit();
        session.close();

        return culinaryPrograms;
    }

    @Override
    public CulinaryPrograms getCulinaryProgram(String programId) {
        CulinaryPrograms culinaryProgram = null;
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        culinaryProgram = session.get(CulinaryPrograms.class, programId);

        transaction.commit();
        session.close();

        return culinaryProgram;
    }

    @Override
    public Long getCulinaryProgramCount() {
        Long count = 0L;
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "SELECT COUNT(c) FROM CulinaryPrograms c";
        Query<Long> query = session.createQuery(hql, Long.class);

        count = query.uniqueResult();

        transaction.commit();
        session.close();

        return count;
    }
}
