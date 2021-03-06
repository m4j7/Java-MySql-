package Dao;

import Model.Produto;
import ConnectionFactory.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoProduto {

    private Connection connection;

    public DaoProduto() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void criaTabela(){

        String sql = "CREATE TABLE IF NOT EXISTS produtos ("+
                "nome VARCHAR(50) NOT NULL," +
                "quantidade INT" +
                ");";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.execute();
            stmt.close();

            System.out.println("Tabela Produto criada com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void gravaNoBanco(Produto produto){

        String sql = "INSERT INTO produtos" +
                " (nome, quantidade) " +
                "VALUES (?,?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getQuantidade());

            stmt.execute();

            ResultSet resultSet = stmt.getGeneratedKeys();

            while (resultSet.next()) {
                produto.setIdProduto(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

   public List<Produto> mostraLista(){

       String sql = "SELECT * FROM produtos";

       try {
           PreparedStatement stmt = connection.prepareStatement(sql);
           ResultSet resultSet = stmt.executeQuery();

           List<Produto> produtos = new ArrayList<>();
           Produto produto;

           while (resultSet.next()) {
               produto = new Produto();
               produto.setNome(resultSet.getString("nome"));
               produto.setQuantidade(resultSet.getInt("quantidade"));
               produto.setIdProduto(resultSet.getInt("idProduto"));
               produtos.add(produto);
           }

           return produtos;
       } catch (SQLException e) {
           throw new RuntimeException(e);
       } }


    public Produto SelecionaId (int id){

        String sql = "SELECT * FROM produtos WHERE idProduto = ?";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()){
                Produto produto = new Produto();
                produto.setIdProduto(resultSet.getInt("idProduto"));
                produto.setNome(resultSet.getString("nome"));
                produto.setQuantidade(resultSet.getInt("quantidade"));

                return produto;
            }

        } catch (SQLException e){
            throw new RuntimeException(e);
        }

        return null;
    }

    public void editarProdutoDoBanco(Produto produto){
        String sql = "UPDATE produtos SET nome = ?, quantidade = ? WHERE idProduto = ?";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, produto.getNome());
            stmt.setInt(2, produto.getQuantidade());
            stmt.setInt(3, produto.getIdProduto());

            stmt.execute();

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void removeProdutoDoBanco(Produto produto){
        String sql = "DELETE FROM produtos WHERE idProduto = ?";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, produto.getIdProduto());
            stmt.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

}
}



