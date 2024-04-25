package application;

import db.DB;

import java.sql.*;
public class Program {
    public static void main(String[] args) {
        //#Atualizar dados

        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = DB.getConnection();

            st = conn.prepareStatement(
                    "UPDATE seller "
                    + "SET BaseSalary = BaseSalary + ? "
                    + "WHERE "
                    + "(DepartmentId = ?)");

            st.setDouble(1,200);
            st.setInt(2,2);

            int rowsAffected = st.executeUpdate();
            System.out.println("Pronto! Linhas afetadas: " + rowsAffected);

        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            DB.closeStatment(st);
            DB.closeConnection();
        }

    }
}
