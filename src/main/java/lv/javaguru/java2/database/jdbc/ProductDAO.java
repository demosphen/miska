package lv.javaguru.java2.database.jdbc;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.domain.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDAO extends DAOImpl {
    private final static String TABLE_NAME = "products";

    private final String GET_BY_ID_PHRASE = "select * from " + TABLE_NAME + " where id = ?";
    private final String INSERT_PHRASE = "INSERT INTO " + TABLE_NAME + "(`name`, `description`, `price`) VALUES(?, ?, ?)";
    private final String DELETE_BY_ID_PHRASE = "DELETE FROM " + TABLE_NAME + " WHERE id = ?";

    public ProductDAO() {
        super();
    }

    public Product getById(int id) throws DBException, SQLException {
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(GET_BY_ID_PHRASE);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String description = resultSet.getString("description");
            long price = resultSet.getLong("price");
            return new Product(id, name, description, price);
        } else {
            return null;
        }
    }

    public int save(Product product) throws SQLException, DBException {
        Connection connection = getConnection();

        PreparedStatement insertStatement = connection.prepareStatement(INSERT_PHRASE);
        insertStatement.setString(1, product.getName());
        insertStatement.setString(2, product.getDescription());
        insertStatement.setLong(3, product.getPrice());
        insertStatement.executeUpdate();

        PreparedStatement getIdStatement = connection.prepareStatement("SELECT LAST_INSERT_ID() as `id`;");
        ResultSet resultSet = getIdStatement.executeQuery();
        resultSet.next();
        return resultSet.getInt(1);
    }

    public void delete(int id) throws DBException, SQLException {
        Connection connection = getConnection();

        PreparedStatement insertStatement = connection.prepareStatement(DELETE_BY_ID_PHRASE);
        insertStatement.setInt(1, id);
        insertStatement.executeUpdate();
    }
}