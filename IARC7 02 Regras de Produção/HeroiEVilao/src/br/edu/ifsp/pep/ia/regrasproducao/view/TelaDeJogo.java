package br.edu.ifsp.pep.ia.regrasproducao.view;

import br.edu.ifsp.pep.ia.regrasproducao.controller.RegrasProducao;
import br.edu.ifsp.pep.ia.regrasproducao.model.Bonus;
import br.edu.ifsp.pep.ia.regrasproducao.model.Heroi;
import br.edu.ifsp.pep.ia.regrasproducao.model.Vilao;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;

public class TelaDeJogo extends javax.swing.JFrame implements ActionListener {

    private Heroi heroi;
    private Vilao vilao;
    private Bonus bonus;
    private RegrasProducao regraProd;

    private JButton[][] buttons;
    private int linha, coluna;

    private JPanel infoPanel = new JPanel();
    private JPanel jogoPanel;
    private JLabel vidaVilaoLabel = new JLabel();
    private JLabel jogadasHeroiLabel = new JLabel();
    private int jogadasHeroi = 0;

    private Timer timer;

    /**
     * Creates new form TelaDeJogo
     * @param linhas  quantidade de linhas presentes no cenário do jogo
     * @param colunas quantidade de colunas presentes no cenário do jogo
     */
    public TelaDeJogo(int linhas, int colunas) {
        this.heroi = new Heroi(linhas, colunas);
        this.vilao = new Vilao(linhas, colunas, 3);
        this.bonus = new Bonus(linhas, colunas);
        this.buttons = new JButton[linhas][colunas];

        this.linha = linhas;
        this.coluna = colunas;

        // Configurando o comportamento do JFrame
        setTitle("A Grande Aventura Heroica do Herói");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Configurando o painel superior
        this.infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        this.configurarLabel(this.vidaVilaoLabel, "Vidas restante do Vilão: ", this.vilao.getVidasRestantes(), Color.red);
        this.configurarLabel(this.jogadasHeroiLabel, "Jogadas do Herói: ", this.jogadasHeroi, Color.blue);
        this.infoPanel.add(this.vidaVilaoLabel);
        this.infoPanel.add(this.jogadasHeroiLabel);

        // Configurando o painel inferior, o do jogo
        this.jogoPanel = new JPanel(new GridLayout(this.linha, this.coluna));

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                JButton button = new JButton("                 ");
                button.setEnabled(false);
                buttons[i][j] = button;
                this.jogoPanel.add(button);
            }
        }

        add(this.infoPanel, BorderLayout.NORTH);
        add(this.jogoPanel, BorderLayout.CENTER);

        atualizarPosicoes();

        pack();
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);

        // Timer de 0,5 segundos, para gerar as ações automáticas
        this.timer = new Timer(500, this);
        this.timer.start();
    }

    /**
     *  Atualiza a posição de cada personagem a cada iteração
     */
    private void atualizarPosicoes() {
        for (int i = 0; i < this.linha; i++) {
            for (int j = 0; j < this.coluna; j++) {
                if ((i == heroi.getEixoX() && j == heroi.getEixoY())
                        && (i == this.vilao.getEixoX() && j == this.vilao.getEixoY())) {
                    buttons[i][j].setText(" HERÓI --> VILÃO ");
                    buttons[i][j].setForeground(Color.BLACK);
                    buttons[i][j].setFont(new Font("Arial", Font.BOLD, 12));
                } else if (i == heroi.getEixoX() && j == heroi.getEixoY()) {
                    buttons[i][j].setText("      HERÓI      ");
                    buttons[i][j].setForeground(Color.BLUE);
                    buttons[i][j].setFont(new Font("Arial", Font.BOLD, 12));
                } else if (i == this.vilao.getEixoX() && j == this.vilao.getEixoY()
                        && this.vilao.getVidasRestantes() != 0) {
                    buttons[i][j].setText("      VILÃO      ");
                    buttons[i][j].setForeground(Color.RED);
                    buttons[i][j].setFont(new Font("Arial", Font.BOLD, 12));
                } else if (i == this.bonus.getEixoX() && j == bonus.getEixoY()) {
                    buttons[i][j].setText("      BÔNUS      ");
                    buttons[i][j].setForeground(Color.GREEN);
                    buttons[i][j].setFont(new Font("Arial", Font.BOLD, 12));
                    if (this.bonus.isUtilizado())
                        buttons[i][j].setForeground(Color.GRAY);

                } else
                    buttons[i][j].setText("                 "); // Outras posições
            }
        }
    }

    public void regrasDeProducao() {
        int comando;
        this.regraProd = new RegrasProducao(this.heroi, this.vilao, this.bonus);
        this.jogadasHeroi++;

        if (this.vilao.getVidasRestantes() > 0) {
            System.out.println("");    

            comando = this.regraProd.obterProximaJogada();
            switch (comando) {
                case 1:
                    this.heroi.moverBaixo();
                    break;

                case 2:
                    this.heroi.moverCima();
                    break;

                case 3:
                    this.heroi.moverDireita();
                    break;

                case 4:
                    this.heroi.moverEsquerda();
                    break;

                case 5:
                    this.vilao.receberDano(false);
                    break;
                case 6:
                    this.vilao.receberDano(true);
                    this.heroi.setBonus2x(false);
                    break;

                case 7:
                    this.heroi.setBonus2x(true);
                    this.bonus.setUtilizado();
                    break;
                    
                default:
                    System.out.println("Comando inválido");
            }
            this.vidaVilaoLabel.setText("Vidas restantes do Vilão: " + this.vilao.getVidasRestantes());
            this.jogadasHeroiLabel.setText("Jogadas do Herói: " + this.jogadasHeroi);
            this.atualizarPosicoes();
        }
    }

    /**
     * Responsável por editar um JLabel, seguindo uma configuração padrão
     * @param label o JLabel a ser configurado
     * @param texto o texto a ser apresentado
     * @param valor o valor numérico a ser apresentado após o texto
     * @param cor a cor do texto apresentado
     */
    private void configurarLabel(JLabel label, String texto, int valor, Color cor) {
        Border bordasLabel = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        label.setText(texto + valor);
        label.setForeground(cor);
        label.setFont(new Font("Garamond", Font.BOLD, 24));
        label.setBorder(bordasLabel);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.regrasDeProducao();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
     * content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaDeJogo.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaDeJogo.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaDeJogo.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaDeJogo.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new TelaDeJogo().setVisible(true);

                SwingUtilities.invokeLater(() -> {
                    new TelaDeJogo(10,10);

                });

            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
