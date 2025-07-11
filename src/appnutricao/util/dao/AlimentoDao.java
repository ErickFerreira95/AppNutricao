package appnutricao.util.dao;

import appnutricao.model.Alimento;
import appnutricao.util.ConexaoBd;
import java.sql.Connection;
import java.sql.PreparedStatement;
import org.mindrot.jbcrypt.BCrypt;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class AlimentoDao {

    private ConexaoBd conexaoBd;
    private Connection conn;

    public AlimentoDao() {
        this.conexaoBd = new ConexaoBd();
        this.conn = this.conexaoBd.getConexaoBd();
    }

    // Salvar usuário com senha criptografada
    public boolean salvarAlimento(Alimento alimento) {
        String sql = "INSERT INTO alimentos (nome, quantidade, proteina, carboidrato, gordura, kcal) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = conexaoBd.getConexaoBd(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, alimento.getNomeAlimento());
            stmt.setString(2, alimento.getQuantidade());
            stmt.setString(3, alimento.getProteina());
            stmt.setString(4, alimento.getCarboidrato());
            stmt.setString(5, alimento.getGordura());
            stmt.setString(6, alimento.getKcal());

            stmt.executeUpdate();
            System.out.println("Alimento salvo com sucesso.");
            return true;

        } catch (Exception e) {
            System.out.println("Erro ao salvar Alimento: " + e.getMessage());
            return false;
        }
    }

    public List<Alimento> carregarAlimentos() {
        List<Alimento> lista = new ArrayList<>();

        String sql = "SELECT id, nome, quantidade, proteina, carboidrato, gordura, kcal FROM alimentos";

        try (Connection conn = conexaoBd.getConexaoBd(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Alimento alimento = new Alimento();

                alimento.setId(rs.getInt("id"));
                alimento.setNomeAlimento(rs.getString("nome"));
                alimento.setQuantidade(rs.getString("quantidade"));
                alimento.setProteina(rs.getString("proteina"));
                alimento.setCarboidrato(rs.getString("carboidrato"));
                alimento.setGordura(rs.getString("gordura"));
                alimento.setKcal(rs.getString("kcal"));

                lista.add(alimento);
            }

        } catch (Exception e) {
            e.printStackTrace(); // ou log
        }
        return lista;
    }
    
    public boolean deletarAlimento(int id) {
        try (Connection conn = conexaoBd.getConexaoBd()) {
            String sql = "DELETE FROM alimentos WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            int linhasAfetadas = stmt.executeUpdate();
            return linhasAfetadas > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
