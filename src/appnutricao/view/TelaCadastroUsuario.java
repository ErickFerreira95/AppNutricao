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

public class TelaCadastroUsuario {

    private JFrame frame = new JFrame("Cadastrar Usuario");
    private JLabel lblNome = new JLabel("Nome:");
    private JLabel lblEmail = new JLabel("Email:");
    private JLabel lblSenha = new JLabel("Senha:");
    private JTextField textFieldNome = new JTextField(12);
    private JTextField textFieldEmail = new JTextField(12);
    private JPasswordField textFieldSenha = new JPasswordField(12);
    private JButton botaoCadastrar = new JButton("Cadastrar");
    private JButton botaoVoltar = new JButton("Voltar");

    public TelaCadastroUsuario() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280, 720);
        frame.setLocationRelativeTo(null);

        lblNome.setFont(new Font("Calibri", Font.BOLD, 20));
        lblEmail.setFont(new Font("Calibri", Font.BOLD, 20));
        lblSenha.setFont(new Font("Calibri", Font.BOLD, 20));
        textFieldNome.setFont(new Font("Calibri", Font.PLAIN, 14));
        textFieldNome.setToolTipText("Insira seu nome");
        textFieldNome.setMargin(new Insets(3, 1, 1, 1));
        textFieldEmail.setFont(new Font("Calibri", Font.PLAIN, 14));
        textFieldEmail.setToolTipText("Insira seu Email");
        textFieldEmail.setMargin(new Insets(3, 1, 1, 1));
        textFieldSenha.setMargin(new Insets(3, 1, 1, 1));
        textFieldSenha.setToolTipText("Insira sua Senha");
        botaoCadastrar.setToolTipText("Cadastrar");
        botaoVoltar.setToolTipText("Voltar");

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

        GridBagConstraints posicaoLblNome = new GridBagConstraints();
        posicaoLblNome.gridx = 0;
        posicaoLblNome.gridy = 0;
        posicaoLblNome.anchor = GridBagConstraints.CENTER;
        painelCentral.add(lblNome, posicaoLblNome);

        GridBagConstraints posicaoTextFieldNome = new GridBagConstraints();
        posicaoTextFieldNome.gridx = 0;
        posicaoTextFieldNome.gridy = 1;
        posicaoTextFieldNome.anchor = GridBagConstraints.CENTER;
        posicaoTextFieldNome.insets = new Insets(0, 0, 5, 0);
        painelCentral.add(textFieldNome, posicaoTextFieldNome);

        GridBagConstraints posicaoLblEmail = new GridBagConstraints();
        posicaoLblEmail.gridx = 0;
        posicaoLblEmail.gridy = 2;
        posicaoLblEmail.anchor = GridBagConstraints.CENTER;
        painelCentral.add(lblEmail, posicaoLblEmail);

        GridBagConstraints posicaoTextFieldEmail = new GridBagConstraints();
        posicaoTextFieldEmail.gridx = 0;
        posicaoTextFieldEmail.gridy = 3;
        posicaoTextFieldEmail.anchor = GridBagConstraints.CENTER;
        posicaoTextFieldEmail.insets = new Insets(0, 0, 5, 0);
        painelCentral.add(textFieldEmail, posicaoTextFieldEmail);

        GridBagConstraints posicaoLblSenha = new GridBagConstraints();
        posicaoLblSenha.gridx = 0;
        posicaoLblSenha.gridy = 4;
        posicaoLblSenha.anchor = GridBagConstraints.CENTER;
        painelCentral.add(lblSenha, posicaoLblSenha);

        GridBagConstraints posicaoTextFieldSenha = new GridBagConstraints();
        posicaoTextFieldSenha.gridx = 0;
        posicaoTextFieldSenha.gridy = 5;
        posicaoTextFieldSenha.anchor = GridBagConstraints.CENTER;
        posicaoTextFieldSenha.insets = new Insets(0, 0, 5, 0);
        painelCentral.add(textFieldSenha, posicaoTextFieldSenha);

        GridBagConstraints posicaoBotaoCadastrar = new GridBagConstraints();
        posicaoBotaoCadastrar.gridx = 0;
        posicaoBotaoCadastrar.gridy = 6;
        posicaoBotaoCadastrar.anchor = GridBagConstraints.CENTER;
        posicaoBotaoCadastrar.insets = new Insets(5, 0, 5, 0);
        painelCentral.add(botaoCadastrar, posicaoBotaoCadastrar);

        GridBagConstraints posicaoBotaoVoltar = new GridBagConstraints();
        posicaoBotaoVoltar.gridx = 0;
        posicaoBotaoVoltar.gridy = 7;
        posicaoBotaoVoltar.anchor = GridBagConstraints.CENTER;
        posicaoBotaoVoltar.insets = new Insets(10, 0, 0, 0);
        painelCentral.add(botaoVoltar, posicaoBotaoVoltar);

        frame.setContentPane(painelFundo);
    }

    public void telaCadastrar() {
        frame.setVisible(true);
        salvarUsuario();
        voltar();
    }

    public void salvarUsuario() {

        botaoCadastrar.addActionListener(new ActionListener() {
            UsuarioDao dao = new UsuarioDao();

            @Override
            public void actionPerformed(ActionEvent e) {
                dao.salvarUsuario(textFieldNome.getText(), textFieldEmail.getText(), textFieldSenha.getText());
                frame.dispose();
            }
        });
    }

    public void voltar() {

        botaoVoltar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
    }
}
