package ua.com.nix.start;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ua.com.nix.controller.Controller;
import ua.com.nix.dao.*;
import ua.com.nix.dao.impl.*;
import ua.com.nix.properties.PropertyLoader;
import ua.com.nix.service.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class Starter {


    public void start(PropertyLoader propertyLoader, String[] args) {
        try (SessionFactory sessionFactory = new Configuration().configure()
                .setProperty("hibernate.connection.username", args[1])
                .setProperty("hibernate.connection.password", args[2]).buildSessionFactory();
             Session session = sessionFactory.openSession()) {


            Properties props = propertyLoader.loadProperties(args);
            String url = props.getProperty("url");

            try (Connection connection = DriverManager.getConnection(url, props)) {
                connection.setAutoCommit(false);

                OperationDao operationDao = new JPAOperationDaoImpl(session);
                OperationService operationService = new OperationService(operationDao);
                ReportDao reportDao = new JDBCReportDaoImpl(connection);
                ReportService reportService = new ReportService(reportDao);

                Controller controller = new Controller(args[0], operationService, reportService);
                controller.run();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
