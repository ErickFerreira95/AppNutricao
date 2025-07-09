package appnutricao.util.dao;

import appnutricao.model.Alimento;
import appnutricao.util.ConexaoBd;
import java.sql.Connection;
import java.sql.PreparedStatement;
import org.mindrot.jbcrypt.BCrypt;

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
}
