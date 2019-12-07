package com.bext;

public class IoC {

    public static void main(String[] args) {
        IoC container = new IoC();
        User user = container.new User();
        user.add( "Info to persist");
    }

    public class User {
        MySqlDatabase database;

        public User() {
            this.database = new MySqlDatabase();
        }

        void add( String data) {
            database.persist( data);
        }
    }

    public class MySqlDatabase {
        public void persist(String data) {
            System.out.println("MySqlDatabase persisted [" + data + "]");
        }
    }

}
