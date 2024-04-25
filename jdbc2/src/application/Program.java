package application;

import db.DB;
import db.DbException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program {
    public static void main(String[] args) {
        //#Recuperar Dados

        Connection conn = null; //Conexão com banco pt1
        Statement st = null; //Consulta SQL
        ResultSet rs = null; //Representa um objeto contendo o resultado da consulta SQL

        try {
            conn = DB.getConnection(); //Conexão com banco pt2

            st = conn.createStatement();

            rs = st.executeQuery("select * from department");

            while (rs.next()){
                System.out.println(rs.getInt("Id" ));

            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            DB.closeResultSet(rs);
            DB.closeStatment(st);
            DB.closeConnection();
        }
    }
}
