package com.app.server.configuration;

import org.hibernate.dialect.MySQL5Dialect;

public class CustomMySQLDialect extends MySQL5Dialect {
    @Override
    public boolean dropConstraints() {
        return false;
    }
    @Override
    public String getTableTypeString() {
        return " ENGINE=InnoDB CHARSET=utf8mb4";
    }
}
