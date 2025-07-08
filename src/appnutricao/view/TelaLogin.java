package appnutricao.view;

import appnutricao.util.dao.UsuarioDao;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class TelaLogin {

    private JFrame frame = new JFrame("Login");
    private JLabel lblLogin = new JLabel("Login:");
    private JTextField textFieldLogin = new JTextField(12);
    private JLabel lblSenha = new JLabel("Senha:");
    private JPasswordField textFieldSenha = new JPasswordField(12);
    private JButton botaoEntrar = new JButton("Entrar");
    private JLabel lblNaoTemConta = new JLabel("Não tem uma conta? ");
    private JButton botaoCadastrar = new JButton("Cadastrar");

    public TelaLogin() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280, 720);
        frame.setLocationRelativeTo(null);

        lblLogin.setFont(new Font("Calibri", Font.BOLD, 20));
        textFieldLogin.setFont(new Font("Calibri", Font.PLAIN, 14));
        textFieldLogin.setToolTipText("Insira seu Email");
        textFieldLogin.setMargin(new Insets(3, 1, 1, 1));
        textFieldSenha.setMargin(new Insets(3, 1, 1, 1));
        lblSenha.setFont(new Font("Calibri", Font.BOLD, 20));
        textFieldSenha.setToolTipText("Insira sua senha");
        textFieldSenha.setMargin(new Insets(2, 2, 2, 2));
        botaoEntrar.setToolTipText("Entrar");
        lblNaoTemConta.setFont(new Font("Calibri", Font.BOLD, 14));
        botaoCadastrar.setToolTipText("Cadastrar");

        // Usa recurso interno (imagem na pasta src/images)
        JPanel painelFundo = new JPanelFundo("/C:/Users/Erick/OneDrive/Documentos/NetBeansProjects/1-Projetos/AppNutricao/build/classes/images/background.jpg");
        painelFundo.setLayout(new GridBagLayout());

        JPanel painelCentral = new JPanelCentral(30, new Color(255, 255, 255, 180));
        painelCentral.setPreferredSize(new Dimension(300, 400));
        painelCentral.setBackground(new Color(255, 255, 255, 200)); // cor com transparência3
        painelCentral.setLayout(new GridBagLayout());

        GridBagConstraints posicaoPanel = new GridBagConstraints();
        posicaoPanel.gridx = 0;
        posicaoPanel.gridy = 0;
        posicaoPanel.anchor = GridBagConstraints.CENTER;
        painelFundo.add(painelCentral, posicaoPanel);

        GridBagConstraints posicaoLblLogin = new GridBagConstraints();
        posicaoLblLogin.gridx = 0;
        posicaoLblLogin.gridy = 0;
        posicaoLblLogin.anchor = GridBagConstraints.CENTER;
        painelCentral.add(lblLogin, posicaoLblLogin);

        GridBagConstraints posicaoTextFieldLogin = new GridBagConstraints();
        posicaoTextFieldLogin.gridx = 0;
        posicaoTextFieldLogin.gridy = 1;
        posicaoTextFieldLogin.anchor = GridBagConstraints.CENTER;
        posicaoTextFieldLogin.insets = new Insets(0, 0, 5, 0);
        painelCentral.add(textFieldLogin, posicaoTextFieldLogin);

        GridBagConstraints posicaoLblSenha = new GridBagConstraints();
        posicaoLblSenha.gridx = 0;
        posicaoLblSenha.gridy = 2;
        posicaoLblSenha.anchor = GridBagConstraints.CENTER;
        painelCentral.add(lblSenha, posicaoLblSenha);

        GridBagConstraints posicaoTextFieldSenha = new GridBagConstraints();
        posicaoTextFieldSenha.gridx = 0;
        posicaoTextFieldSenha.gridy = 3;
        posicaoTextFieldSenha.anchor = GridBagConstraints.CENTER;
        posicaoTextFieldSenha.insets = new Insets(0, 0, 5, 0);
        painelCentral.add(textFieldSenha, posicaoTextFieldSenha);

        GridBagConstraints posicaoButton = new GridBagConstraints();
        posicaoButton.gridx = 0;
        posicaoButton.gridy = 4;
        posicaoButton.anchor = GridBagConstraints.CENTER;
        posicaoButton.insets = new Insets(5, 0, 15, 0);
        painelCentral.add(botaoEntrar, posicaoButton);

        GridBagConstraints posicaoLblNaoTemConta = new GridBagConstraints();
        posicaoLblNaoTemConta.gridx = 0;
        posicaoLblNaoTemConta.gridy = 5;
        posicaoLblNaoTemConta.anchor = GridBagConstraints.CENTER;
        posicaoLblNaoTemConta.insets = new Insets(0, 0, 0, 0);
        painelCentral.add(lblNaoTemConta, posicaoLblNaoTemConta);

        GridBagConstraints posicaoBotaoCadastrar = new GridBagConstraints();
        posicaoBotaoCadastrar.gridx = 0;
        posicaoBotaoCadastrar.gridy = 6;
        posicaoBotaoCadastrar.anchor = GridBagConstraints.CENTER;
        posicaoBotaoCadastrar.insets = new Insets(0, 0, 5, 0);
        painelCentral.add(botaoCadastrar, posicaoBotaoCadastrar);

        frame.setContentPane(painelFundo);
    }

    public void fazerLogin() {
        botaoEntrar.addActionListener(new ActionListener() {
            UsuarioDao dao = new UsuarioDao();

            @Override
            public void actionPerformed(ActionEvent e) {
                if (dao.autenticarUsuario(textFieldLogin.getText(), textFieldSenha.getText())) {
                    System.out.println("Login bem sucedido!");
                } else {
                    System.out.println("Email ou senha inválidos.");
                }
            }
        });
    }

    public void cadastrarUsuario() {
        botaoCadastrar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                TelaCadastroUsuario cadastroUsuario = new TelaCadastroUsuario();
                cadastroUsuario.telaCadastrar();
            }
        });
    }

    public void show() {
        frame.setVisible(true);
        fazerLogin();
        cadastrarUsuario();
    }
}
