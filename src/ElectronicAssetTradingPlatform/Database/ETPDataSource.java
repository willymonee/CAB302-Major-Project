package ElectronicAssetTradingPlatform.Database;
import java.sql.*;
import java.util.Set;
import java.util.TreeSet;
import java.sql.SQLException;

public class ETPDataSource {
    // DB Instance
    private Connection connection;
    // Create Table Queries
    private static final String marketplaceTable =
            "CREATE TABLE IF NOT EXISTS Marketplace ("
                    + "Offer_ID INTEGER PRIMARY KEY /*!40101 AUTO_INCREMENT */ NOT NULL UNIQUE,"
                    /*"Buy_or_Sell ENUM('buy', 'sell') NOT NULL," +*/
                    + "Unit_ID INTEGER NOT NULL,"
                    + "User_ID INTEGER NOT NULL,"
                    + "Asset_type_ID NOT NULL,"
                    + "Price_per_unit FLOAT NOT NULL"
                    + ");";

    private static final String marketplaceHistoryTable =
            "CREATE TABLE IF NOT EXISTS Marketplace_history ("
                    + "Trade_ID INTEGER /*!40101 AUTO_INCREMENT */ UNIQUE,"
                    + "Buyer_ID INTEGER NOT NULL,"
                    + "Seller_ID INTEGER NOT NULL,"
                    + "Asset_type_ID INTEGER NOT NULL,"
                    + "Price_per_unit REAL NOT NULL,"
                    + "Quantity INTEGER NOT NULL,"
                    + "Date_fulfilled TEXT NOT NULL"
                    + ");";

    private static final String userAccountsTable =
            "CREATE TABLE IF NOT EXISTS User_Accounts ("
                + "User_ID INTEGER /*!40101 AUTO_INCREMENT */ UNIQUE,"
                + "Username VARCHAR(60) UNIQUE NOT NULL,"
                + "Password_hash VARCHAR(80) NOT NULL,"
                + "User_Type VARCHAR(60) NOT NULL,"
                + "Unit_ID INTEGER"
                + ");";

    private static final String assetTypesTable =
            "CREATE TABLE IF NOT EXISTS Asset_Types ("
                + "Type_ID INTEGER /*!40101 AUTO_INCREMENT */ UNIQUE,"
                + "Name VARCHAR(80) UNIQUE NOT NULL"
                + ");";

    private static final String orgUnitsTable =
            "CREATE TABLE IF NOT EXISTS Organisational_Units ("
                + "Unit_ID INTEGER UNIQUE,"
                + "Name VARCHAR(80) UNIQUE NOT NULL,"
                + "Credits REAL"
                + ");";

    private static final String orgUnitAssetsTable =
            "CREATE TABLE IF NOT EXISTS Organisational_Unit_Assets ("
                + "Unit_ID INTEGER NOT NULL,"
                + "Asset_ID INTEGER NOT NULL,"
                + "Asset_Quantity INTEGER NOT NULL"
                + ");";


    public ETPDataSource() {
        connection = DBConnectivity.getInstance();
        try {
            Statement st = connection.createStatement();
            st.execute(marketplaceTable);
            st.execute(marketplaceHistoryTable);
            st.execute(userAccountsTable);
            st.execute(assetTypesTable);
            st.execute(orgUnitsTable);
            st.execute(orgUnitAssetsTable);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
