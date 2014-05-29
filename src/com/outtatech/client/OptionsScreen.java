package com.outtatech.client;

import javax.swing.ImageIcon;

/**
 * Version-latenightpizzaparty
 *
 * @author Thomas
 */
public class OptionsScreen extends javax.swing.JFrame
{

    GUIController controller;

    /**
     * Version-latenightpizzaparty
     * Creates new form OptionsScreen
     */
    public OptionsScreen()
    {
        initComponents();
    }

    /**
     * Version-latenightpizzaparty
     *
     * @param ctrl method parameter
     */
    public OptionsScreen(GUIController ctrl)
    {
        controller = ctrl;

        int indx = controller.getImageIndex();

        initComponents();

        cardImage1.setText("");
        cardImage2.setText("");
        cardImage3.setText("");

        updateCards(indx);
    }

    private void updateCards(int indx)
    {
        String path = controller.getImagePath(indx);
        cardImage1.setIcon(new ImageIcon(path + "Location-1.jpg"));
        cardImage2.setIcon(new ImageIcon(path + "MUSTARD.jpg"));
        cardImage3.setIcon(new ImageIcon(path + "AIRLINER.jpg"));
    }

    /**
     * Version-latenightpizzaparty
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        buttonGroup1 = new javax.swing.ButtonGroup();
        greeceButton = new javax.swing.JRadioButton();
        whiteHouseButton = new javax.swing.JRadioButton();
        pirateButton = new javax.swing.JRadioButton();
        applyButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cardImage1 = new javax.swing.JLabel();
        cardImage2 = new javax.swing.JLabel();
        cardImage3 = new javax.swing.JLabel();

        setTitle("Options");

        buttonGroup1.add(greeceButton);
        greeceButton.setLabel("Greece");
        greeceButton.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                greeceButtonMouseClicked(evt);
            }
        });
        greeceButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                greeceButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(whiteHouseButton);
        whiteHouseButton.setLabel("White House");
        whiteHouseButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                whiteHouseButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(pirateButton);
        pirateButton.setLabel("Pirate");
        pirateButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                pirateButtonActionPerformed(evt);
            }
        });

        applyButton.setLabel("Apply");
        applyButton.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                applyButtonMouseClicked(evt);
            }
        });

        closeButton.setLabel("Return");
        closeButton.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                closeButtonMouseClicked(evt);
            }
        });

        jLabel1.setText("Select Theme:");

        cardImage1.setText("1");

        cardImage2.setText("2");

        cardImage3.setText("3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cardImage1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cardImage2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cardImage3))
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(greeceButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(whiteHouseButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pirateButton)))
                .addContainerGap(185, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(applyButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(closeButton)
                .addGap(61, 61, 61))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(greeceButton)
                    .addComponent(whiteHouseButton)
                    .addComponent(pirateButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cardImage1)
                    .addComponent(cardImage2)
                    .addComponent(cardImage3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(applyButton)
                    .addComponent(closeButton))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void greeceButtonActionPerformed(java.awt.event.ActionEvent evt)
    {//GEN-FIRST:event_greeceButtonActionPerformed
        // Guard against this
        if (greeceButton.isSelected())
        {
            updateCards(0);
        }
    }//GEN-LAST:event_greeceButtonActionPerformed

    private void closeButtonMouseClicked(java.awt.event.MouseEvent evt)
    {//GEN-FIRST:event_closeButtonMouseClicked
        this.setVisible(false);
    }//GEN-LAST:event_closeButtonMouseClicked

    private void applyButtonMouseClicked(java.awt.event.MouseEvent evt)
    {//GEN-FIRST:event_applyButtonMouseClicked
        // Guard against this
        if (greeceButton.isSelected())
        {
            controller.setImageIndex(0);
        }
        // Otherwise...
        else if (whiteHouseButton.isSelected())
        {
            controller.setImageIndex(1);
        }
        // Otherwise...
        else
        {
            controller.setImageIndex(2);
        }

        this.setVisible(false);
    }//GEN-LAST:event_applyButtonMouseClicked

    private void whiteHouseButtonActionPerformed(java.awt.event.ActionEvent evt)
    {//GEN-FIRST:event_whiteHouseButtonActionPerformed
        // Guard against this
        if (whiteHouseButton.isSelected())
        {
            updateCards(1);
        }
    }//GEN-LAST:event_whiteHouseButtonActionPerformed

    private void pirateButtonActionPerformed(java.awt.event.ActionEvent evt)
    {//GEN-FIRST:event_pirateButtonActionPerformed
        // Guard against this
        if (pirateButton.isSelected())
        {
            updateCards(2);
        }
    }//GEN-LAST:event_pirateButtonActionPerformed

    private void greeceButtonMouseClicked(java.awt.event.MouseEvent evt)
    {//GEN-FIRST:event_greeceButtonMouseClicked

    }//GEN-LAST:event_greeceButtonMouseClicked

    /**
     * Version-latenightpizzaparty
     * @param args the command line arguments method parameter
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        // Just in case...
        try
        {
            // Iterate over this set
            for (javax.swing.UIManager.LookAndFeelInfo info
                    : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                // Guard against this
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(OptionsScreen.class.getName()).
                    log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(OptionsScreen.class.getName()).
                    log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(OptionsScreen.class.getName()).
                    log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(OptionsScreen.class.getName()).
                    log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new OptionsScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton applyButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel cardImage1;
    private javax.swing.JLabel cardImage2;
    private javax.swing.JLabel cardImage3;
    private javax.swing.JButton closeButton;
    private javax.swing.JRadioButton greeceButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton pirateButton;
    private javax.swing.JRadioButton whiteHouseButton;
    // End of variables declaration//GEN-END:variables
}
