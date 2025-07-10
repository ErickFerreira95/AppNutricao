package appnutricao.view;

import appnutricao.util.dao.UsuarioDao;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class TelaLogin extends JFrame {

    private JButton botaoAcessar = new JButton("Acessar");
    private JButton botaoCadastrar = new JButton("Cadastre-se");
    private JTextField txtLogin = new JTextField(12);
    private JPasswordField txtSenha = new JPasswordField(12);

    public TelaLogin() {

        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1280, 720);
        setLocationRelativeTo(null);

        // Painel de fundo com imagem
        JPanel painelFundo = new JPanel() {
            private final Image imagemFundo = new ImageIcon("/C:/Users/Erick/OneDrive/Documentos/NetBeansProjects/1-Projetos/AppNutricao/build/classes/images/background.jpg").getImage();

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(imagemFundo, 0, 0, getWidth(), getHeight(), this);
            }
        };
        painelFundo.setLayout(new GridBagLayout());

        // Painel transparente com cantos arredondados
        JPanel painelCentral = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                Shape forma = new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), 30, 30);
                g2.setColor(new Color(255, 255, 255, 200));
                g2.fill(forma);
                g2.dispose();
                super.paintComponent(g);
            }
        };

        painelCentral.setOpaque(false);
        painelCentral.setPreferredSize(new Dimension(300, 400));
        painelCentral.setLayout(new GridBagLayout());

        // Posicionamento no topo absoluto
        GridBagConstraints posicaoPainelCentral = new GridBagConstraints();
        posicaoPainelCentral.gridx = 0;
        posicaoPainelCentral.gridy = 0;
        posicaoPainelCentral.weightx = 0;
        posicaoPainelCentral.weighty = 0; // ← isso força ele a ficar no topo
        posicaoPainelCentral.anchor = GridBagConstraints.CENTER;
        posicaoPainelCentral.fill = GridBagConstraints.NONE;
        posicaoPainelCentral.insets = new Insets(20, 0, 0, 0); // margem superior
        painelFundo.add(painelCentral, posicaoPainelCentral);

        JLabel lblLogin = new JLabel("Login:");
        lblLogin.setFont(new Font("Calibri", Font.BOLD, 20));
        painelCentral.add(lblLogin);

        txtLogin.setFont(new Font("Calibri", Font.PLAIN, 14));
        txtLogin.setToolTipText("Insira seu Email");
        txtLogin.setMargin(new Insets(3, 1, 1, 1));

        // Posicionamento no topo absoluto
        GridBagConstraints posicaoTxtLogin = new GridBagConstraints();
        posicaoTxtLogin.gridx = 0;
        posicaoTxtLogin.gridy = 1;
        posicaoTxtLogin.weightx = 0;
        posicaoTxtLogin.weighty = 0; // ← isso força ele a ficar no topo
        posicaoTxtLogin.anchor = GridBagConstraints.CENTER;
        posicaoTxtLogin.fill = GridBagConstraints.NONE;
        posicaoTxtLogin.insets = new Insets(0, 0, 5, 0); // margem superior
        painelCentral.add(txtLogin, posicaoTxtLogin);

        JLabel lblSenha = new JLabel("Senha:");
        lblSenha.setFont(new Font("Calibri", Font.BOLD, 20));

        // Posicionamento no topo absoluto
        GridBagConstraints posicaoLblSenha = new GridBagConstraints();
        posicaoLblSenha.gridx = 0;
        posicaoLblSenha.gridy = 2;
        posicaoLblSenha.weightx = 0;
        posicaoLblSenha.weighty = 0; // ← isso força ele a ficar no topo
        posicaoLblSenha.anchor = GridBagConstraints.CENTER;
        posicaoLblSenha.fill = GridBagConstraints.NONE;
        posicaoLblSenha.insets = new Insets(0, 0, 0, 0); // margem superior
        painelCentral.add(lblSenha, posicaoLblSenha);

        txtSenha.setFont(new Font("Calibri", Font.PLAIN, 14));
        txtSenha.setToolTipText("Insira sua Senha");
        txtSenha.setMargin(new Insets(3, 1, 1, 1));

        // Posicionamento no topo absoluto
        GridBagConstraints posicaoTxtSenha = new GridBagConstraints();
        posicaoTxtSenha.gridx = 0;
        posicaoTxtSenha.gridy = 3;
        posicaoTxtSenha.weightx = 0;
        posicaoTxtSenha.weighty = 0; // ← isso força ele a ficar no topo
        posicaoTxtSenha.anchor = GridBagConstraints.CENTER;
        posicaoTxtSenha.fill = GridBagConstraints.NONE;
        posicaoTxtSenha.insets = new Insets(0, 0, 5, 0); // margem superior
        painelCentral.add(txtSenha, posicaoTxtSenha);

        botaoAcessar.setToolTipText("Acessar");

        // Posicionamento no topo absoluto
        GridBagConstraints posicaoBotaoAcessar = new GridBagConstraints();
        posicaoBotaoAcessar.gridx = 0;
        posicaoBotaoAcessar.gridy = 4;
        posicaoBotaoAcessar.weightx = 0;
        posicaoBotaoAcessar.weighty = 0; // ← isso força ele a ficar no topo
        posicaoBotaoAcessar.anchor = GridBagConstraints.CENTER;
        posicaoBotaoAcessar.fill = GridBagConstraints.NONE;
        posicaoBotaoAcessar.insets = new Insets(5, 0, 0, 0); // margem superior
        painelCentral.add(botaoAcessar, posicaoBotaoAcessar);

        JLabel lblNaoTemConta = new JLabel("Não tem conta?");
        lblSenha.setFont(new Font("Calibri", Font.BOLD, 20));

        // Posicionamento no topo absoluto
        GridBagConstraints posicaolblNaoTemConta = new GridBagConstraints();
        posicaolblNaoTemConta.gridx = 0;
        posicaolblNaoTemConta.gridy = 5;
        posicaolblNaoTemConta.weightx = 0;
        posicaolblNaoTemConta.weighty = 0; // ← isso força ele a ficar no topo
        posicaolblNaoTemConta.anchor = GridBagConstraints.CENTER;
        posicaolblNaoTemConta.fill = GridBagConstraints.NONE;
        posicaolblNaoTemConta.insets = new Insets(10, 0, 0, 0); // margem superior
        painelCentral.add(lblNaoTemConta, posicaolblNaoTemConta);

        botaoCadastrar.setToolTipText("Cadastre-se");

        // Posicionamento no topo absoluto
        GridBagConstraints posicaoBotaoCadastrar = new GridBagConstraints();
        posicaoBotaoCadastrar.gridx = 0;
        posicaoBotaoCadastrar.gridy = 6;
        posicaoBotaoCadastrar.weightx = 0;
        posicaoBotaoCadastrar.weighty = 0; // ← isso força ele a ficar no topo
        posicaoBotaoCadastrar.anchor = GridBagConstraints.CENTER;
        posicaoBotaoCadastrar.fill = GridBagConstraints.NONE;
        posicaoBotaoCadastrar.insets = new Insets(5, 0, 0, 0); // margem superior
        painelCentral.add(botaoCadastrar, posicaoBotaoCadastrar);

        setContentPane(painelFundo);     
    }
    
    public void login() {
        setVisible(true);
        fazerLogin();
        cadastrarUsuario();
    }

    public void fazerLogin() {
        botaoAcessar.addActionListener(new ActionListener() {
            UsuarioDao dao = new UsuarioDao();
            TelaPrincipal principal = new TelaPrincipal();

            @Override
            public void actionPerformed(ActionEvent e) {
                if (dao.autenticarUsuario(txtLogin.getText(), txtSenha.getText())) {
                    principal.telaPrincipal();
                    dispose();
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
                dispose();
                new TelaCadastroUsuario().telaCadastrar();
                //cadastroUsuario.telaCadastrar();
            }
        });
    }
}
