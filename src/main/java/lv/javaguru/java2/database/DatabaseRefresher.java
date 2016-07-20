package lv.javaguru.java2.database;

import lv.javaguru.java2.database.jdbc.DAOImpl;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class DatabaseRefresher extends DAOImpl {

    public void refreshDatabse() throws Exception {
        List<String> sqlStatements = getSetupStatements();
        this.setDbSchema("");
        Connection connection = getConnection();

        for (String sqlStatement : sqlStatements) {
            System.out.println("executing :" + sqlStatement);
            try {
                Statement statement = connection.createStatement();
                statement.execute(sqlStatement);
            }
            catch (Exception e){
                System.out.println("Exception while trying " + sqlStatement);
                throw new Exception(e);
            }
        }
        closeConnection(connection);
    }

    private List<String> getSetupStatements(){
        List<String> sqlStatements = new ArrayList<String>();
        sqlStatements.add("DROP SCHEMA IF EXISTS java2miskatest;");
        sqlStatements.add("CREATE SCHEMA IF NOT EXISTS java2miskatest;");

        sqlStatements.add("CREATE TABLE java2miskatest.users " +
                "( userid INT NOT NULL AUTO_INCREMENT, " +
                " firstName VARCHAR(45) NULL , " +
                " lastName VARCHAR(45) NULL , " +
                " PRIMARY KEY(userid))");

        sqlStatements.add("CREATE TABLE java2miskatest.category " +
                "( id INT NOT NULL AUTO_INCREMENT, " +
                " name VARCHAR(45) NULL , " +
                " father_id INT NOT NULL , " +
                " PRIMARY KEY(id) , " +
                " KEY(father_id))");
        return sqlStatements;
    }

    public static void main(String[] args) throws Exception{
        DatabaseRefresher refresher = new DatabaseRefresher();
        refresher.refreshDatabse();
    }
}
