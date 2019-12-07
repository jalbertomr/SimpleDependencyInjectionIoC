package com.bext;

public class IoC {

    public static void main(String[] args) {
        IoC container = new IoC();
        User user = container.new User( container.new OracleDatabase());
        user.add( "Info to persist");
    }

    public class User {
        Database database;

        public User( Database database) {
            this.database = database;
        }

        void add( String data) {
            database.persist( data);
        }
    }

    interface Database {
        public void persist(String data);
    }

    public class MySqlDatabase implements Database {
        public void persist(String data) {
            System.out.println("MySqlDatabase persisted [" + data + "]");
        }
    }

    public class OracleDatabase implements Database {
        public void persist(String data) {
            System.out.println("OracleDatabase persisted [" + data + "]");
        }
    }
}