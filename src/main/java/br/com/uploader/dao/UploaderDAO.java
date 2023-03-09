package br.com.uploader.dao;

import br.com.uploader.factory.ConnectionFactory;
import br.com.uploader.model.Uploader;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UploaderDAO {

    public void saveImage(Uploader uploader){
        String sql = "INSERT INTO savedimages (file,typeImg) VALUES (?,?)";

        Connection conn = null;
        PreparedStatement preparedStatement = null;

        try {
            //criar conexão com o banco de dados.
            conn = ConnectionFactory.createConnectionToMySQL();
            //criado a preparedStatement para criar uma Query
            preparedStatement = conn.prepareStatement(sql);
            //passar os valores que serão esperados na query sql
            preparedStatement.setString(1, uploader.getFile());
            preparedStatement.setString(2, uploader.getTypeImg());

            // executar a query
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                if(preparedStatement != null){
                    preparedStatement.close();
                }
                if(conn != null){
                    conn.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public List<Uploader> getImage(){
        String sql = "SELECT * from savedimages";

        List<Uploader> images = new ArrayList<Uploader>();

        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet rset = null;
        try{
            conn = ConnectionFactory.createConnectionToMySQL();
            preparedStatement = conn.prepareStatement(sql);

            rset = preparedStatement.executeQuery();

            while(rset.next()){
                Uploader uploader = new Uploader();

                uploader.setTypeImg(rset.getString("typeImg"));
                uploader.setFile(rset.getString("file"));
                images.add(uploader);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }finally {
          try{
              if(rset !=null){
                  rset.close();
              }
              if(preparedStatement != null){
                  preparedStatement.close();
              }
              if(conn != null){
                  conn.close();
              }
          }catch(Exception e){
              e.printStackTrace();
          }
        }
        return images;
    }
}
