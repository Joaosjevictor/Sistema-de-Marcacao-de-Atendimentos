package View;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PainelFundoBarbearia extends JPanel {
    private Image imagemFundo;

   public PainelFundoBarbearia() {
    // O "/" busca a partir da raiz da pasta de recursos (src/main/resources)
    java.net.URL caminhoImagem = getClass().getResource("/imagem_login.png");

    if (caminhoImagem != null) {
        this.imagemFundo = new ImageIcon(caminhoImagem).getImage();
    } else {
        // Isso vai aparecer no seu terminal se o Java ainda não achar o arquivo
        System.out.println("ERRO: Imagem não encontrada! Verifique se ela está em src/main/resources");
    }

    setLayout(null); 
}

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Desenha a imagem ocupando todo o painel
        g.drawImage(imagemFundo, 0, 0, getWidth(), getHeight(), this);
    }
}