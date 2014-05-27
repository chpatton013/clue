package com.outtatech.client;

/**
 *
 * @author Thomas
 */
public class AccusationScreen extends javax.swing.JFrame
{

    GUIController controller;

    /**
     * Creates new form AccusationScreen
     */
    public AccusationScreen()
    {
        initComponents();
    }

    /**
     * Alternate constructor to take a GUIController in
     *
     * @param ctrl
     */
    public AccusationScreen(GUIController ctrl)
    {
        //set controller = ctrl
        controller = ctrl;

        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cardImage1 = new javax.swing.JPanel();
        cardImage2 = new javax.swing.JPanel();
        cardImage3 = new javax.swing.JPanel();
        cardDropDown1 = new javax.swing.JComboBox();
        cardDropDown2 = new javax.swing.JComboBox();
        cardDropDown3 = new javax.swing.JComboBox();
        accuseButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        cardImage1.setPreferredSize(new java.awt.Dimension(70, 100));

        javax.swing.GroupLayout cardImage1Layout = new javax.swing.GroupLayout(cardImage1);
        cardImage1.setLayout(cardImage1Layout);
        cardImage1Layout.setHorizontalGroup(
            cardImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );
        cardImage1Layout.setVerticalGroup(
            cardImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        cardImage2.setPreferredSize(new java.awt.Dimension(70, 100));

        javax.swing.GroupLayout cardImage2Layout = new javax.swing.GroupLayout(cardImage2);
        cardImage2.setLayout(cardImage2Layout);
        cardImage2Layout.setHorizontalGroup(
            cardImage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );
        cardImage2Layout.setVerticalGroup(
            cardImage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        cardImage3.setPreferredSize(new java.awt.Dimension(70, 100));

        javax.swing.GroupLayout cardImage3Layout = new javax.swing.GroupLayout(cardImage3);
        cardImage3.setLayout(cardImage3Layout);
        cardImage3Layout.setHorizontalGroup(
            cardImage3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );
        cardImage3Layout.setVerticalGroup(
            cardImage3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        cardDropDown1.setMaximumRowCount(9);
        cardDropDown1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cardDropDown1.setPreferredSize(new java.awt.Dimension(70, 20));
        cardDropDown1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cardDropDown1ActionPerformed(evt);
            }
        });

        cardDropDown2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cardDropDown2.setPreferredSize(new java.awt.Dimension(70, 20));
        cardDropDown2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cardDropDown2ActionPerformed(evt);
            }
        });

        cardDropDown3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cardDropDown3.setPreferredSize(new java.awt.Dimension(70, 20));
        cardDropDown3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cardDropDown3ActionPerformed(evt);
            }
        });

        accuseButton.setText("ACCUSE!");
        accuseButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accuseButtonMouseClicked(evt);
            }
        });

        closeButton.setText("Close");
        closeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeButtonMouseClicked(evt);
            }
        });

        jLabel1.setText("Make an accusation:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(78, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(accuseButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(closeButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cardDropDown1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cardImage1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cardImage2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cardDropDown2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cardImage3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cardDropDown3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(76, 76, 76))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cardImage3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cardImage2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cardImage1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cardDropDown1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cardDropDown2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cardDropDown3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(accuseButton)
                    .addComponent(closeButton))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeButtonMouseClicked
        //close the window
        this.setVisible(false);
    }//GEN-LAST:event_closeButtonMouseClicked

    private void accuseButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accuseButtonMouseClicked
        //call controller's makeAccusation method with the card types of
        //the three selected cards
    }//GEN-LAST:event_accuseButtonMouseClicked

    private void cardDropDown1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cardDropDown1ActionPerformed
        //set cardImage1 to image of selected card
    }//GEN-LAST:event_cardDropDown1ActionPerformed

    private void cardDropDown2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cardDropDown2ActionPerformed
        //set cardImage2 to image of selected card
    }//GEN-LAST:event_cardDropDown2ActionPerformed

    private void cardDropDown3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cardDropDown3ActionPerformed
        //set cardImage3 to image of selected card
    }//GEN-LAST:event_cardDropDown3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info
                    : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(AccusationScreen.class.getName()).
                    log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(AccusationScreen.class.getName()).
                    log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(AccusationScreen.class.getName()).
                    log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(AccusationScreen.class.getName()).
                    log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new AccusationScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton accuseButton;
    private javax.swing.JComboBox cardDropDown1;
    private javax.swing.JComboBox cardDropDown2;
    private javax.swing.JComboBox cardDropDown3;
    private javax.swing.JPanel cardImage1;
    private javax.swing.JPanel cardImage2;
    private javax.swing.JPanel cardImage3;
    private javax.swing.JButton closeButton;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
