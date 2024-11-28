package lk.ijse.db;

import lk.ijse.entity.CulinaryProgram;
import lk.ijse.entity.Enrollment;
import lk.ijse.entity.Student;
import lk.ijse.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.util.Properties;

public class FactoryConfiguration {
    private static FactoryConfiguration factoryConfiguration;
    private SessionFactory sessionFactory;

    private FactoryConfiguration() {
        try {
            Properties properties = new Properties();
            FileInputStream input = new FileInputStream("src/main/resources/hibernate.properties");
            properties.load(input);
            Configuration configuration = new Configuration();
            configuration.setProperties(properties)
                    .addAnnotatedClass(User.class)
                    .addAnnotatedClass(CulinaryProgram.class)
                    .addAnnotatedClass(Enrollment.class)
                    .addAnnotatedClass(Student.class);
            sessionFactory = configuration.buildSessionFactory();
        } catch (Exception e){

        }
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

