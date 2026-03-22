package View;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PainelFundoBarbearia extends JPanel {
    private Image imagemFundo;

    public PainelFundoBarbearia() {
        // Carrega a imagem que você criou (ex: fundo.jpg)
        imagemFundo = new ImageIcon("src/img/fundo.jpg").getImage();
        
        // Usaremos layout nulo para posicionar os campos exatamente onde queremos
        setLayout(null); 
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Desenha a imagem ocupando todo o painel
        g.drawImage(imagemFundo, 0, 0, getWidth(), getHeight(), this);
    }
}