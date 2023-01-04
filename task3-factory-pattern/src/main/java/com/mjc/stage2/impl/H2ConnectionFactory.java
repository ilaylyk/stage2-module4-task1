package com.mjc.stage2.impl;

import com.mjc.stage2.ConnectionFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class H2ConnectionFactory implements ConnectionFactory {
    @Override
    public Connection createConnection() {
        Connection connection = null;
        try (InputStream fis = H2ConnectionFactory.class.getClassLoader().getResourceAsStream("h2database.properties")) {
            Properties p = new Properties ();
            p.load (fis);
            connection = DriverManager.getConnection("jdbc:h2:~/test", p);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}

