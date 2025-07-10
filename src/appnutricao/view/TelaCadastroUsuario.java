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

public class TelaCadastroUsuario extends JFrame {

    private JTextField txtNome = new JTextField(12);
    private JTextField txtEmail = new JTextField(12);
    private JPasswordField txtSenha = new JPasswordField(12);
    private JButton botaoCadastrar = new JButton("Cadastrar");
    private JButton botaoVoltar = new JButton("Voltar");

    public TelaCadastroUsuario() {

        setTitle("Cadastro Usuário");
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

        // Posicionamento no Centro da tela
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;
        gbc.insets = new Insets(20, 0, 0, 0);
        painelFundo.add(painelCentral, gbc);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setFont(new Font("Calibri", Font.BOLD, 20));
        painelCentral.add(lblNome);

        txtNome.setFont(new Font("Calibri", Font.PLAIN, 14));
        txtNome.setToolTipText("Insira seu Nome");
        txtNome.setMargin(new Insets(3, 1, 1, 1));

        GridBagConstraints posicaoTxtNome = new GridBagConstraints();
        posicaoTxtNome.gridx = 0;
        posicaoTxtNome.gridy = 1;
        posicaoTxtNome.weightx = 0;
        posicaoTxtNome.weighty = 0; // ← isso força ele a ficar no topo
        posicaoTxtNome.anchor = GridBagConstraints.CENTER;
        posicaoTxtNome.fill = GridBagConstraints.NONE;
        posicaoTxtNome.insets = new Insets(0, 0, 5, 0); // margem superior
        painelCentral.add(txtNome, posicaoTxtNome);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setFont(new Font("Calibri", Font.BOLD, 20));

        GridBagConstraints posicaoLblEmail = new GridBagConstraints();
        posicaoLblEmail.gridx = 0;
        posicaoLblEmail.gridy = 2;
        posicaoLblEmail.weightx = 0;
        posicaoLblEmail.weighty = 0; // ← isso força ele a ficar no topo
        posicaoLblEmail.anchor = GridBagConstraints.CENTER;
        posicaoLblEmail.fill = GridBagConstraints.NONE;
        posicaoLblEmail.insets = new Insets(0, 0, 0, 0); // margem superior
        painelCentral.add(lblEmail, posicaoLblEmail);

        txtEmail.setFont(new Font("Calibri", Font.PLAIN, 14));
        txtEmail.setToolTipText("Insira seu Email");
        txtEmail.setMargin(new Insets(3, 1, 1, 1));

        GridBagConstraints posicaoTxtEmail = new GridBagConstraints();
        posicaoTxtEmail.gridx = 0;
        posicaoTxtEmail.gridy = 3;
        posicaoTxtEmail.weightx = 0;
        posicaoTxtEmail.weighty = 0; // ← isso força ele a ficar no topo
        posicaoTxtEmail.anchor = GridBagConstraints.CENTER;
        posicaoTxtEmail.fill = GridBagConstraints.NONE;
        posicaoTxtEmail.insets = new Insets(0, 0, 5, 0); // margem superior
        painelCentral.add(txtEmail, posicaoTxtEmail);

        JLabel lblSenha = new JLabel("Senha:");
        lblSenha.setFont(new Font("Calibri", Font.BOLD, 20));

        GridBagConstraints posicaoLblSenha = new GridBagConstraints();
        posicaoLblSenha.gridx = 0;
        posicaoLblSenha.gridy = 4;
        posicaoLblSenha.weightx = 0;
        posicaoLblSenha.weighty = 0; // ← isso força ele a ficar no topo
        posicaoLblSenha.anchor = GridBagConstraints.CENTER;
        posicaoLblSenha.fill = GridBagConstraints.NONE;
        posicaoLblSenha.insets = new Insets(0, 0, 0, 0); // margem superior
        painelCentral.add(lblSenha, posicaoLblSenha);

        txtSenha.setFont(new Font("Calibri", Font.PLAIN, 14));
        txtSenha.setToolTipText("Insira sua Senha");
        txtSenha.setMargin(new Insets(3, 1, 1, 1));

        GridBagConstraints posicaoTxtSenha = new GridBagConstraints();
        posicaoTxtSenha.gridx = 0;
        posicaoTxtSenha.gridy = 5;
        posicaoTxtSenha.weightx = 0;
        posicaoTxtSenha.weighty = 0; // ← isso força ele a ficar no topo
        posicaoTxtSenha.anchor = GridBagConstraints.CENTER;
        posicaoTxtSenha.fill = GridBagConstraints.NONE;
        posicaoTxtSenha.insets = new Insets(0, 0, 5, 0); // margem superior
        painelCentral.add(txtSenha, posicaoTxtSenha);

        botaoCadastrar.setToolTipText("Cadastre-se");

        GridBagConstraints posicaoBotaoCadastrar = new GridBagConstraints();
        posicaoBotaoCadastrar.gridx = 0;
        posicaoBotaoCadastrar.gridy = 6;
        posicaoBotaoCadastrar.weightx = 0;
        posicaoBotaoCadastrar.weighty = 0; // ← isso força ele a ficar no topo
        posicaoBotaoCadastrar.anchor = GridBagConstraints.CENTER;
        posicaoBotaoCadastrar.fill = GridBagConstraints.NONE;
        posicaoBotaoCadastrar.insets = new Insets(5, 0, 0, 0); // margem superior
        painelCentral.add(botaoCadastrar, posicaoBotaoCadastrar);

        botaoVoltar.setToolTipText("Voltar");

        GridBagConstraints posicaoBotaoVoltar = new GridBagConstraints();
        posicaoBotaoVoltar.gridx = 0;
        posicaoBotaoVoltar.gridy = 7;
        posicaoBotaoVoltar.weightx = 0;
        posicaoBotaoVoltar.weighty = 0; // ← isso força ele a ficar no topo
        posicaoBotaoVoltar.anchor = GridBagConstraints.CENTER;
        posicaoBotaoVoltar.fill = GridBagConstraints.NONE;
        posicaoBotaoVoltar.insets = new Insets(20, 0, 0, 0); // margem superior
        painelCentral.add(botaoVoltar, posicaoBotaoVoltar);

        setContentPane(painelFundo);
    }

    public void telaCadastrar() {
        setVisible(true);
        salvarUsuario();
        voltar();
    }

    public void salvarUsuario() {

        botaoCadastrar.addActionListener(new ActionListener() {
            UsuarioDao dao = new UsuarioDao();

            @Override
            public void actionPerformed(ActionEvent e) {
                dao.salvarUsuario(txtNome.getText(), txtEmail.getText(), txtSenha.getText());
                dispose();
                new TelaLogin().login();
            }
        });
    }

    public void voltar() {

        botaoVoltar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new TelaLogin().login();
            }
        });
    }
}
