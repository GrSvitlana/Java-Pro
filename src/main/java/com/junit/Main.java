package com.junit;

public class Main {
    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql";
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
