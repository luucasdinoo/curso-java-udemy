package application;

import db.DB;
import db.DbIntegrityException;

import java.sql.*;
public class Program {
    public static void main(String[] args) {
        //#Deletar dados

        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = DB.getConnection();

            st = conn.prepareStatement(
                    "DELETE FROM department "
                    + "WHERE "
                    + "Id = ?");

            st.setInt(1,5);

            int rowsAffected = st.executeUpdate();
            System.out.println("Pronto! Linhas afetadas: " + rowsAffected);

        }
        catch (SQLException e){
            throw new DbIntegrityException(e.getMessage());
        }
        finally {
            DB.closeStatment(st);
            DB.closeConnection();
        }
    }
}
