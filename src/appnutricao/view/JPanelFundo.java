package appnutricao.view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class JPanelFundo extends JPanel {
    
    private BufferedImage imagem;

    public JPanelFundo(String caminhoImagem) {
        try {
            imagem = ImageIO.read(new File(caminhoImagem));
        } catch (IOException e) {
            System.out.println("Erro ao carregar imagem: " + e.getMessage());
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (imagem != null) {
            g.drawImage(imagem, 0, 0, getWidth(), getHeight(), this); // redimensiona a imagem ao tamanho do painel
        }
    }
}
