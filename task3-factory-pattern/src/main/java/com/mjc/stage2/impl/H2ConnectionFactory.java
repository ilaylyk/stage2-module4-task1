package com.mjc.stage2.impl;

import com.mjc.stage2.ConnectionFactory;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class H2ConnectionFactory implements ConnectionFactory {
    @Override
    public Connection createConnection() {
        try {
            FileInputStream fis = new FileInputStream("h2database.properties");
            Properties p = new Properties();
            p.load(fis);
            return DriverManager.getConnection("jdbc:h2:~/test", p);
        } catch (Exception e) {
            return null;
        }
    }
}

