package appnutricao.view;

import appnutricao.model.Alimento;
import appnutricao.util.dao.AlimentoDao;
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
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class TelaCadastroAlimento extends JFrame {

    private JTextField txtNomeAlimento = new JTextField(12);
    private JTextField txtQuantidade = new JTextField(12);
    private JTextField txtProteina = new JTextField(12);
    private JTextField txtCarboidrato = new JTextField(12);
    private JTextField txtGordura = new JTextField(12);
    private JButton botaoCadastrar = new JButton("Cadastrar");
    private JButton botaoVoltar = new JButton("Voltar");

    public TelaCadastroAlimento() {
        setTitle("Cadastro Alimento");
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
        painelCentral.setPreferredSize(new Dimension(300, 450));
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

        JLabel lblNomeAlimento = new JLabel("Nome alimento:");
        lblNomeAlimento.setFont(new Font("Calibri", Font.BOLD, 20));
        painelCentral.add(lblNomeAlimento);

        txtNomeAlimento.setFont(new Font("Calibri", Font.PLAIN, 14));
        txtNomeAlimento.setToolTipText("Insira o nome do alimento");
        txtNomeAlimento.setMargin(new Insets(3, 1, 1, 1));

        GridBagConstraints posicaoTxtNomeAlimento = new GridBagConstraints();
        posicaoTxtNomeAlimento.gridx = 0;
        posicaoTxtNomeAlimento.gridy = 1;
        posicaoTxtNomeAlimento.weightx = 0;
        posicaoTxtNomeAlimento.weighty = 0; // ← isso força ele a ficar no topo
        posicaoTxtNomeAlimento.anchor = GridBagConstraints.CENTER;
        posicaoTxtNomeAlimento.fill = GridBagConstraints.NONE;
        posicaoTxtNomeAlimento.insets = new Insets(0, 0, 10, 0); // margem superior
        painelCentral.add(txtNomeAlimento, posicaoTxtNomeAlimento);

        JLabel lblQuantidade = new JLabel("Quantidade(g)");
        lblQuantidade.setFont(new Font("Calibri", Font.BOLD, 20));
        painelCentral.add(lblQuantidade);

        GridBagConstraints posicaoLblQuantidade = new GridBagConstraints();
        posicaoLblQuantidade.gridx = 0;
        posicaoLblQuantidade.gridy = 2;
        posicaoLblQuantidade.weightx = 0;
        posicaoLblQuantidade.weighty = 0; // ← isso força ele a ficar no topo
        posicaoLblQuantidade.anchor = GridBagConstraints.CENTER;
        posicaoLblQuantidade.fill = GridBagConstraints.NONE;
        posicaoLblQuantidade.insets = new Insets(0, 0, 0, 0); // margem superior
        painelCentral.add(lblQuantidade, posicaoLblQuantidade);

        txtQuantidade.setFont(new Font("Calibri", Font.PLAIN, 14));
        txtQuantidade.setToolTipText("Insira a quantidade em gramas");
        txtQuantidade.setMargin(new Insets(3, 1, 1, 1));

        GridBagConstraints posicaoTxtQuantidade = new GridBagConstraints();
        posicaoTxtQuantidade.gridx = 0;
        posicaoTxtQuantidade.gridy = 3;
        posicaoTxtQuantidade.weightx = 0;
        posicaoTxtQuantidade.weighty = 0; // ← isso força ele a ficar no topo
        posicaoTxtQuantidade.anchor = GridBagConstraints.CENTER;
        posicaoTxtQuantidade.fill = GridBagConstraints.NONE;
        posicaoTxtQuantidade.insets = new Insets(0, 0, 10, 0); // margem superior
        painelCentral.add(txtQuantidade, posicaoTxtQuantidade);

        JLabel lblProteina = new JLabel("Proteína(g)");
        lblProteina.setFont(new Font("Calibri", Font.BOLD, 20));
        painelCentral.add(lblProteina);

        GridBagConstraints posicaoLblProteina = new GridBagConstraints();
        posicaoLblProteina.gridx = 0;
        posicaoLblProteina.gridy = 4;
        posicaoLblProteina.weightx = 0;
        posicaoLblProteina.weighty = 0; // ← isso força ele a ficar no topo
        posicaoLblProteina.anchor = GridBagConstraints.CENTER;
        posicaoLblProteina.fill = GridBagConstraints.NONE;
        posicaoLblProteina.insets = new Insets(0, 0, 0, 0); // margem superior
        painelCentral.add(lblProteina, posicaoLblProteina);

        txtProteina.setFont(new Font("Calibri", Font.PLAIN, 14));
        txtProteina.setToolTipText("Insira a quantidade de proteína");
        txtProteina.setMargin(new Insets(3, 1, 1, 1));

        GridBagConstraints posicaoTxtProteina = new GridBagConstraints();
        posicaoTxtProteina.gridx = 0;
        posicaoTxtProteina.gridy = 5;
        posicaoTxtProteina.weightx = 0;
        posicaoTxtProteina.weighty = 0; // ← isso força ele a ficar no topo
        posicaoTxtProteina.anchor = GridBagConstraints.CENTER;
        posicaoTxtProteina.fill = GridBagConstraints.NONE;
        posicaoTxtProteina.insets = new Insets(0, 0, 10, 0); // margem superior
        painelCentral.add(txtProteina, posicaoTxtProteina);

        JLabel lblCarboidrato = new JLabel("Carboidrato(g)");
        lblCarboidrato.setFont(new Font("Calibri", Font.BOLD, 20));
        painelCentral.add(lblCarboidrato);

        GridBagConstraints posicaoLblCarboidrato = new GridBagConstraints();
        posicaoLblCarboidrato.gridx = 0;
        posicaoLblCarboidrato.gridy = 6;
        posicaoLblCarboidrato.weightx = 0;
        posicaoLblCarboidrato.weighty = 0; // ← isso força ele a ficar no topo
        posicaoLblCarboidrato.anchor = GridBagConstraints.CENTER;
        posicaoLblCarboidrato.fill = GridBagConstraints.NONE;
        posicaoLblCarboidrato.insets = new Insets(0, 0, 0, 0); // margem superior
        painelCentral.add(lblCarboidrato, posicaoLblCarboidrato);

        txtCarboidrato.setFont(new Font("Calibri", Font.PLAIN, 14));
        txtCarboidrato.setToolTipText("Insira a quantidade de carboidrato");
        txtCarboidrato.setMargin(new Insets(3, 1, 1, 1));

        GridBagConstraints posicaoTxtCarboidrato = new GridBagConstraints();
        posicaoTxtCarboidrato.gridx = 0;
        posicaoTxtCarboidrato.gridy = 7;
        posicaoTxtCarboidrato.weightx = 0;
        posicaoTxtCarboidrato.weighty = 0; // ← isso força ele a ficar no topo
        posicaoTxtCarboidrato.anchor = GridBagConstraints.CENTER;
        posicaoTxtCarboidrato.fill = GridBagConstraints.NONE;
        posicaoTxtCarboidrato.insets = new Insets(0, 0, 10, 0); // margem superior
        painelCentral.add(txtCarboidrato, posicaoTxtCarboidrato);

        JLabel lblGordura = new JLabel("Gordura(g)");
        lblGordura.setFont(new Font("Calibri", Font.BOLD, 20));
        painelCentral.add(lblGordura);

        GridBagConstraints posicaoLblGordura = new GridBagConstraints();
        posicaoLblGordura.gridx = 0;
        posicaoLblGordura.gridy = 8;
        posicaoLblGordura.weightx = 0;
        posicaoLblGordura.weighty = 0; // ← isso força ele a ficar no topo
        posicaoLblGordura.anchor = GridBagConstraints.CENTER;
        posicaoLblGordura.fill = GridBagConstraints.NONE;
        posicaoLblGordura.insets = new Insets(0, 0, 0, 0); // margem superior
        painelCentral.add(lblGordura, posicaoLblGordura);

        txtGordura.setFont(new Font("Calibri", Font.PLAIN, 14));
        txtGordura.setToolTipText("Insira a quantidade de gordura");
        txtGordura.setMargin(new Insets(3, 1, 1, 1));

        GridBagConstraints posicaoTxtGordura = new GridBagConstraints();
        posicaoTxtGordura.gridx = 0;
        posicaoTxtGordura.gridy = 9;
        posicaoTxtGordura.weightx = 0;
        posicaoTxtGordura.weighty = 0; // ← isso força ele a ficar no topo
        posicaoTxtGordura.anchor = GridBagConstraints.CENTER;
        posicaoTxtGordura.fill = GridBagConstraints.NONE;
        posicaoTxtGordura.insets = new Insets(0, 0, 10, 0); // margem superior
        painelCentral.add(txtGordura, posicaoTxtGordura);

        botaoCadastrar.setToolTipText("Cadastrar");

        GridBagConstraints posicaoBotaoCadastrar = new GridBagConstraints();
        posicaoBotaoCadastrar.gridx = 0;
        posicaoBotaoCadastrar.gridy = 10;
        posicaoBotaoCadastrar.weightx = 0;
        posicaoBotaoCadastrar.weighty = 0; // ← isso força ele a ficar no topo
        posicaoBotaoCadastrar.anchor = GridBagConstraints.CENTER;
        posicaoBotaoCadastrar.fill = GridBagConstraints.NONE;
        posicaoBotaoCadastrar.insets = new Insets(0, 0, 10, 0); // margem superior
        painelCentral.add(botaoCadastrar, posicaoBotaoCadastrar);

        botaoVoltar.setToolTipText("Voltar");

        GridBagConstraints posicaoBotaoVoltar = new GridBagConstraints();
        posicaoBotaoVoltar.gridx = 0;
        posicaoBotaoVoltar.gridy = 11;
        posicaoBotaoVoltar.weightx = 0;
        posicaoBotaoVoltar.weighty = 0; // ← isso força ele a ficar no topo
        posicaoBotaoVoltar.anchor = GridBagConstraints.CENTER;
        posicaoBotaoVoltar.fill = GridBagConstraints.NONE;
        posicaoBotaoVoltar.insets = new Insets(20, 0, 10, 0); // margem superior
        painelCentral.add(botaoVoltar, posicaoBotaoVoltar);

        setContentPane(painelFundo);
    }

    public void telaCadastrarAlimento() {
        System.out.println("Tela CadastroAlimento");
        setVisible(true);
        salvarAlimento();
        voltar();
    }

    public void voltar() {
        botaoVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new TelaPrincipal().telaPrincipal();
            }
        });
    }

    public void salvarAlimento() {
        botaoCadastrar.addActionListener(new ActionListener() {
            AlimentoDao dao = new AlimentoDao();
            Alimento alimento = new Alimento();

            @Override
            public void actionPerformed(ActionEvent e) {

                alimento.setNomeAlimento(txtNomeAlimento.getText());
                alimento.setQuantidade(txtQuantidade.getText());
                alimento.setProteina(txtProteina.getText());
                alimento.setCarboidrato(txtCarboidrato.getText());
                alimento.setGordura(txtGordura.getText());

                dao.salvarAlimento(alimento);
                dispose();
                new TelaCadastroAlimento().telaCadastrarAlimento();
            }
        });
    }
}
