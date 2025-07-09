package appnutricao;

import appnutricao.util.dao.UsuarioDao;
import appnutricao.view.TelaCadastroUsuario;
import appnutricao.view.TelaLogin;
import appnutricao.view.TelaPrincipal;

public class AppNutricao {
    public static void main(String[] args) {
        
        TelaLogin login = new TelaLogin();
        login.setVisible(true);
        login.fazerLogin();
        login.cadastrarUsuario();
        
        TelaCadastroUsuario cadastro = new TelaCadastroUsuario();
        
        cadastro.salvarUsuario();
        cadastro.voltar();
        
        
        /*UsuarioDao dao = new UsuarioDao();
        String email = "erick@email.com";
        String senha = "picoricos2";

        if (dao.verificarLogin(email, senha)) {
            System.out.println("Login bem-sucedido!");
        } else {
            System.out.println("Email ou senha inválidos.");
        }*/
        
        /*TelaCadastroUsuario cadastroUsuario = new TelaCadastroUsuario();
        cadastroUsuario.telaCadastrar();*/
        
        /*UsuarioDao dao = new UsuarioDao();
        dao.salvarUsuario("Mariana", "mariana@email.com", "123456");
        boolean autenticado = dao.autenticarUsuario("mariana@email.com", "123456");
        System.out.println(autenticado ? "Login bem-sucedido" : "Email ou senha inválidos");*/
        
        //new TelaPrincipal().setVisible(true);
    }
}
