package appnutricao.view;

import appnutricao.model.Alimento;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class TelaPrincipal extends JFrame {

    private JButton botaoAdicionar = new JButton("Adicionar Alimento");
    private JButton botaoIMC = new JButton("Calcular IMC");
    private JButton botaoTmb = new JButton("Calcular TMB");

    /*private JFrame frame = new JFrame("Tabela Alimentos");
    private JTable table = new JTable();
    private JPanel panelCabecalho = new JPanel();

    public TelaPrincipal() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280, 720);
        frame.setLocationRelativeTo(null);

        JPanel painelFundo = new JPanelFundo("/C:/Users/Erick/OneDrive/Documentos/NetBeansProjects/1-Projetos/AppNutricao/build/classes/images/background.jpg");
        painelFundo.setLayout(new GridBagLayout());
        
        JPanel panelCabecalho = new JPanelCabecalho(30, new Color(255, 255, 255, 180));
        panelCabecalho.setPreferredSize(new Dimension(300, 400));
        panelCabecalho.setBackground(new Color(255, 255, 255, 200)); // cor com transparência3
        panelCabecalho.setLayout(new GridBagLayout());
        
        GridBagConstraints posicaoPanel = new GridBagConstraints();
        posicaoPanel.gridx = 0;
        posicaoPanel.gridy = 0;
        posicaoPanel.anchor = GridBagConstraints.NORTH;
        posicaoPanel.fill = GridBagConstraints.NONE;
        posicaoPanel.weightx = 1;
        posicaoPanel.weighty = 0;
        painelFundo.add(panelCabecalho, posicaoPanel);
        
        frame.setContentPane(painelFundo);
    }*/
    public TelaPrincipal() {
        setTitle("Tabela Alimentos");
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza a janela

        // Painel de fundo com imagem
        JPanel painelFundo = new JPanel() {
            private final Image imagemFundo = new ImageIcon("src/images/background.jpg").getImage();

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(imagemFundo, 0, 0, getWidth(), getHeight(), this);
            }
        };
        painelFundo.setLayout(new GridBagLayout());

        // Painel transparente com cantos arredondados
        JPanel painelTopo = new JPanel() {
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

        painelTopo.setOpaque(false);
        painelTopo.setPreferredSize(new Dimension(1000, 80));
        painelTopo.setLayout(new GridBagLayout());

        // Posicionamento no topo absoluto
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 0; // ← isso força ele a ficar no topo
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.fill = GridBagConstraints.NONE;
        gbc.insets = new Insets(20, 0, 0, 0); // margem superior
        painelFundo.add(painelTopo, gbc);

        GridBagConstraints posicaoBotaoAdicionar = new GridBagConstraints();
        posicaoBotaoAdicionar.gridx = 0;
        posicaoBotaoAdicionar.gridy = 0;
        posicaoBotaoAdicionar.weightx = 0;
        posicaoBotaoAdicionar.weighty = 0; // ← isso força ele a ficar no topo
        posicaoBotaoAdicionar.anchor = GridBagConstraints.CENTER;
        posicaoBotaoAdicionar.fill = GridBagConstraints.NONE;
        posicaoBotaoAdicionar.insets = new Insets(0, 0, 0, 20); // margem superior
        painelTopo.add(botaoAdicionar, posicaoBotaoAdicionar);

        GridBagConstraints posicaoBotaoImc = new GridBagConstraints();
        posicaoBotaoImc.gridx = 1;
        posicaoBotaoImc.gridy = 0;
        posicaoBotaoImc.weightx = 0;
        posicaoBotaoImc.weighty = 0; // ← isso força ele a ficar no topo
        posicaoBotaoImc.anchor = GridBagConstraints.CENTER;
        posicaoBotaoImc.fill = GridBagConstraints.NONE;
        posicaoBotaoImc.insets = new Insets(0, 0, 0, 0); // margem superior
        painelTopo.add(botaoIMC, posicaoBotaoImc);

        GridBagConstraints posicaoBotaoTmb = new GridBagConstraints();
        posicaoBotaoTmb.gridx = 2;
        posicaoBotaoTmb.gridy = 0;
        posicaoBotaoTmb.weightx = 0;
        posicaoBotaoTmb.weighty = 0; // ← isso força ele a ficar no topo
        posicaoBotaoTmb.anchor = GridBagConstraints.CENTER;
        posicaoBotaoTmb.fill = GridBagConstraints.NONE;
        posicaoBotaoTmb.insets = new Insets(0, 20, 0, 0); // margem superior
        painelTopo.add(botaoTmb, posicaoBotaoTmb);

        // Adiciona um espaço expansivo abaixo (para empurrar o conteúdo pra cima)
        GridBagConstraints gbcEspaco = new GridBagConstraints();
        gbcEspaco.gridx = 0;
        gbcEspaco.gridy = 1;
        gbcEspaco.weighty = 1; // ocupa o resto do espaço
        gbcEspaco.fill = GridBagConstraints.BOTH;
        painelFundo.add(Box.createVerticalGlue(), gbcEspaco);

        String[] colunas = {"ID", "Nome", "Quantidade", "Proteína", "Carboidrato", "Gordura", "Kcal"};

        DefaultTableModel tableModel = new DefaultTableModel(colunas, 1);

        List<Alimento> lista = new ArrayList<>();

        JTable table = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(table);

        GridBagConstraints posicaoTable = new GridBagConstraints();
        posicaoTable.gridx = 0;
        posicaoTable.gridy = 1;
        posicaoTable.weightx = 0;
        posicaoTable.weighty = 0; // ← isso força ele a ficar no topo
        posicaoTable.anchor = GridBagConstraints.CENTER;
        posicaoTable.fill = GridBagConstraints.NONE;
        posicaoTable.insets = new Insets(0, 0, 0, 0); // margem superior
        painelFundo.add(table, posicaoTable);

        setContentPane(painelFundo);
    }
}
