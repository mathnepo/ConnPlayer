/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connplayer;
import java.sql.*;

/**
 *
 * @author Orion
 */
public class Salvar {
    public Salvar(String nome, int ano, String midia, String artista, String genero, String album){
        String sql = "INSERT INTO MUSICA (NOME, ANO, MIDIA, ARTISTA, GENERO, ALBUM) VALUES "
                + "(?, ?, ?, ?, ?, ?)";
        try(Connection conn = Conexao.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, nome);
            pstmt.setInt(2, ano);
            pstmt.setString(3, midia);
            pstmt.setString(4, artista);
            pstmt.setString(5, genero);
            pstmt.setString(6, album);
            pstmt.executeUpdate();
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        //System.out.println("GG wp");
    }
}