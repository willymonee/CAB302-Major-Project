package ElectronicAssetTradingPlatform.Database;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UnitDataSource {
    private static final String GET_UNIT_NAME = "SELECT Name FROM Organisational_Units WHERE Unit_ID = ?";
    private static final String GET_UNIT_ID = "SELECT Unit_ID FROM Organisational_Units WHERE Name = ?";
    private static final String GET_USER_ID = "SELECT USER_ID FROM User_Accounts WHERE Username = ?";

    PreparedStatement getUnitNameQuery;
    PreparedStatement getUnitIDQuery;
    PreparedStatement getUserIDQuery;

    private Connection connection;

    public UnitDataSource() {
        connection = DBConnectivity.getInstance();
        try {
            getUnitNameQuery = connection.prepareStatement(GET_UNIT_NAME);
            getUnitIDQuery = connection.prepareStatement(GET_UNIT_ID);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public String executeGetUnitName(String unitID) throws SQLException {
        // Prepare
        getUnitNameQuery.setString(1, unitID);

        // Result
        ResultSet rs = null;
        rs = getUnitNameQuery.executeQuery();

        // Return
        return rs.getString("Name");
    }

    public String executeGetUnitID(String unitName) throws SQLException {
        // Prepare
        getUnitIDQuery.setString(1, unitName);

        // Result
        ResultSet rs = null;
        rs = getUnitIDQuery.executeQuery();

        // Return
        return rs.getString("Unit_ID");
    }

    public String executeGetUserID(String username) throws SQLException{
        getUserIDQuery.setString(2, username);
        ResultSet rs = null;
        rs = getUserIDQuery.executeQuery();

        return rs.getString("User_ID");

        
    }
}
