package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PainelFundoBarbearia extends JPanel {
    private Image imagemFundo;

   public PainelFundoBarbearia() {
    java.net.URL caminhoImagem = getClass().getResource("/imagem_fundo.png");

    if (caminhoImagem != null) {
        this.imagemFundo = new ImageIcon(caminhoImagem).getImage();
    } else {
        System.out.println("ERRO: Imagem não encontrada! Verifique se ela está em src/main/resources");
    }

    setLayout(null); 
    }

    public PainelFundoBarbearia(String imagem) {
    java.net.URL caminhoImagem = getClass().getResource(imagem);
    if (caminhoImagem != null) {
        this.imagemFundo = new ImageIcon(caminhoImagem).getImage();
    } else {
        System.out.println("ERRO: Imagem não encontrada! Verifique se ela está em src/main/resources");
    }
    setLayout(null);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        if (imagemFundo != null) {
            Graphics2D g2d = (Graphics2D) g;

            g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

            int larguraPainel = getWidth();
            int alturaPainel = getHeight();
            int larguraImg = imagemFundo.getWidth(this);
            int alturaImg = imagemFundo.getHeight(this);

            double escala = Math.max((double) larguraPainel / larguraImg, (double) alturaPainel / alturaImg);
            
            int larguraFinal = (int) (larguraImg * escala);
            int alturaFinal = (int) (alturaImg * escala);
            
            int x = (larguraPainel - larguraFinal) / 2;
            int y = (alturaPainel - alturaFinal) / 2;

            g2d.drawImage(imagemFundo, x, y, larguraFinal, alturaFinal, this);
        }
    }

}