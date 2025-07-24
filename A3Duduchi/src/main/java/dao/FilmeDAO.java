/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import beans.Filme;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Vitor
 */
public class FilmeDAO {
    private Conexao conexao;
    private Connection conn;
    
    //Criar o construtor da classe. Ele é executado automaticamente
    //sempre que um novo objeto é criado.
    public FilmeDAO(){
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }
    
    public void inserir(Filme filme) {
    String sql = "INSERT INTO Filmes(titulo, diretor, anoLancamento, genero, duracao, idioma, paisOrigem, assistido, avaliacao) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    try (PreparedStatement stmt = this.conn.prepareStatement(sql)) {
        stmt.setString(1, filme.getTitulo());
        stmt.setString(2, filme.getDiretor());
        stmt.setInt(3, filme.getAnoLancamento());
        stmt.setString(4, filme.getGenero());
        stmt.setDouble(5, filme.getDuracao());
        stmt.setString(6, filme.getIdioma());
        stmt.setString(7, filme.getPaisOrigem());
        stmt.setString(8, filme.getAssistido());
        stmt.setDouble(9, filme.getAvaliacao());

        // Execute a inserção no banco de dados
        int rowsAffected = stmt.executeUpdate();
        System.out.println("Inserção concluída. Linhas afetadas: " + rowsAffected);
    } catch (Exception e) {
        System.out.println("Erro ao inserir filme: " + e.getMessage());
    }
    }
    
    public void editar(Filme filme){
        String sql = "UPDATE filmes SET titulo=?, diretor=?, anoLancamento=?, genero=?, duracao=?, idioma=?, paisOrigem=?, assistido=?, avaliacao=? WHERE id=?";
        try{
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1,filme.getTitulo());
            stmt.setString(2,filme.getDiretor());
            stmt.setInt(3,filme.getAnoLancamento());
            stmt.setString(4,filme.getGenero());
            stmt.setDouble(5,filme.getDuracao());
            stmt.setString(6,filme.getIdioma());
            stmt.setString(7,filme.getPaisOrigem());
            stmt.setString(8,filme.getAssistido());
            stmt.setDouble(9,filme.getAvaliacao());
            stmt.setInt(10,filme.getId());
            stmt.execute();
        } catch (Exception e){
            System.out.println("Erro ao digitar curso:" + e.getMessage());
        }
    }
    
    public void excluir(int id)
    {
            String sql = "DELETE FROM filmes WHERE id = ?";
            try{
                PreparedStatement stmt = this.conn.prepareStatement(sql);
                stmt.setInt(1, id);
                stmt.execute();
            } catch (Exception e){
                System.out.println("Erro ao excluir curso:" + e.getMessage());
            }
    }
    
    public Filme getFilme(int id)
    {
        String sql = "SELECT * FROM filmes WHERE id =?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            Filme filme = new Filme();
            rs.first();
            filme.setId(rs.getInt("id"));
            filme.setTitulo(rs.getString("titulo"));
            filme.setDiretor(rs.getString("diretor"));
            filme.setAnoLancamento(rs.getInt("anoLancamento"));
            filme.setGenero(rs.getString("genero"));
            filme.setDuracao(rs.getInt("duracao"));
            filme.setIdioma(rs.getString("idioma"));
            filme.setPaisOrigem(rs.getString("paisOrigem"));
            filme.setAssistido(rs.getString("assistido"));
            filme.setAvaliacao(rs.getInt("avaliacao"));
            return filme;
        }catch (Exception e) {
            return null;
        }
    }
    
}
        
        
        
    
    


