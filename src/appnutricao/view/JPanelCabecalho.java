package appnutricao.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JPanel;

public class JPanelCabecalho extends JPanel {
    
    private final int arc;
    private final Color backgroundColor;
    
    public JPanelCabecalho(int arc, Color backgroundColor) {
        this.arc = arc;
        this.backgroundColor = backgroundColor;
        setOpaque(false); // Permite que a transparência funcione
    }
        @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Shape rounded = new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), arc, arc);
        g2.setColor(backgroundColor);
        g2.fill(rounded);

        g2.dispose();
    }
}
