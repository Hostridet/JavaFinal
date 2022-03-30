package com.company;
import java.io.IOException;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws IOException, SQLException {
        joke jokes = new joke();
        bd base = new bd();
        base.connection();
        base.add(jokes.getJoke());
        base.show();
        base.close();
    }
}
