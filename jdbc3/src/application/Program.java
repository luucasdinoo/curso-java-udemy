package application;

import db.DB;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Program {
    public static void main(String[] args) {
        //#Inserir Dados

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Connection conn = null; //Conexão com banco pt1
        PreparedStatement st = null; //Consulta SQL

        try {
            conn = DB.getConnection();

            st = conn.prepareStatement(
                    "INSERT INTO seller "
                    + "(Name,Email,BirthDate,BaseSalary,DepartmentId)"
                    + "VALUES "
                    +"(?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);

            st.setString(1,"Carl Purple");
            st.setString(2,"carl@gmail.com");
            st.setDate(3, new java.sql.Date(sdf.parse("22/04/1985").getTime()));
            st.setDouble(4, 3000.0);
            st.setInt(5,4);


            /*
            st = conn.prepareStatement("insert into department (Name) values ('D2'),('D2')",
                    Statement.RETURN_GENERATED_KEYS); */

            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0){
                ResultSet rs = st.getGeneratedKeys();
                while (rs.next()){
                    int id = rs.getInt(1);
                    System.out.println("Pronto! Id = " + id);
                }
            }
            else {
                System.out.println("Nenhuma linha afetada");
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        finally {
            DB.closeStatment(st);
            DB.closeConnection();
        }
    }
}
