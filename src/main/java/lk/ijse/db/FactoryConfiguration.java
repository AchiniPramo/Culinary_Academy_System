package lk.ijse.db;

import lk.ijse.entity.CulinaryProgram;
import lk.ijse.entity.Enrollment;
import lk.ijse.entity.Student;
import lk.ijse.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryConfiguration {
    private static FactoryConfiguration factoryConfiguration;
    private SessionFactory sessionFactory;

    private FactoryConfiguration() {
            Configuration configuration = new Configuration().configure()
=                   .addAnnotatedClass(User.class)
                    .addAnnotatedClass(CulinaryProgram.class)
                    .addAnnotatedClass(Enrollment.class)
                    .addAnnotatedClass(Student.class);
            sessionFactory = configuration.buildSessionFactory();

    }

    public Session getSession() {
        return sessionFactory.openSession();
    }

    public static FactoryConfiguration getInstance() {
        if (factoryConfiguration == null) {
            factoryConfiguration = new FactoryConfiguration();
        }
        return factoryConfiguration;
    }
}

