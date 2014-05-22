/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package guicontroller;

/**
 *
 * @author Thomas
 */
public class LobbyScreen extends javax.swing.JFrame {
    
    private int numPlayers = 1, selectedRow = -1;
    
    private int[] playerIds = {-1, -1, -1, -1, -1};
    
    GUIController controller;

    /**
     * Creates new form LobbyScreen
     */
    public LobbyScreen() {
        initComponents();
    }
    
    /**
     *Alternate constructor to take a GUIController in
     * @param ctrl
     */
    public LobbyScreen(GUIController ctrl) {
        //set controller to ctrl
        
        initComponents();
    }
    
    /**
     *Adds a player to the lobby
     * @param playerName
     * @param playerId
     */
    public void addPlayer(String playerName, int playerId) {
        //set player list text to current text + playerName + "waiting..."
        
        //set playerIds[numPlayers] to the player's id
        
        //increment numPlayers
        
        //if numPlayers is >= 4 make the start game button active
    }
    
    /**
     *Clears all players from the lobby
     */
    public void clearPlayers() {
        //set the player list text to ""
        
        //set numPlayers to 0
        
        //set playerIds to -1 at all indicies
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        playerListBox = new javax.swing.JTextArea();
        gameStartButton = new javax.swing.JButton();
        createAIButton = new javax.swing.JButton();
        kickPlayerButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Players:");

        playerListBox.setColumns(20);
        playerListBox.setRows(5);
        playerListBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                playerListBoxMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(playerListBox);

        gameStartButton.setText("START!");
        gameStartButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gameStartButtonMouseClicked(evt);
            }
        });

        createAIButton.setText("Create AI");
        createAIButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                createAIButtonMouseClicked(evt);
            }
        });

        kickPlayerButton.setText("Kick Player");
        kickPlayerButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kickPlayerButtonMouseClicked(evt);
            }
        });

        exitButton.setText("Exit");
        exitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(kickPlayerButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(exitButton))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(gameStartButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(createAIButton))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gameStartButton)
                    .addComponent(createAIButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kickPlayerButton)
                    .addComponent(exitButton))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void playerListBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playerListBoxMouseClicked
        //highlight row and set selectedRow to the row number selected
        
        //make kick player button active if not already
    }//GEN-LAST:event_playerListBoxMouseClicked

    private void gameStartButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gameStartButtonMouseClicked
        //call controller's startGame method
    }//GEN-LAST:event_gameStartButtonMouseClicked

    private void createAIButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createAIButtonMouseClicked
        //call controller's createAI method
    }//GEN-LAST:event_createAIButtonMouseClicked

    private void kickPlayerButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kickPlayerButtonMouseClicked
        //call controller's kickPlayer method with the selected player's id
    }//GEN-LAST:event_kickPlayerButtonMouseClicked

    private void exitButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitButtonMouseClicked
        //call controller's exitWindow method
    }//GEN-LAST:event_exitButtonMouseClicked

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
            java.util.logging.Logger.getLogger(LobbyScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LobbyScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LobbyScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LobbyScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LobbyScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createAIButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JButton gameStartButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton kickPlayerButton;
    private javax.swing.JTextArea playerListBox;
    // End of variables declaration//GEN-END:variables
}
