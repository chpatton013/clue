package com.outtatech.client;

import com.outtatech.common.ActionCard;
import com.outtatech.common.ActionCardType;
import com.outtatech.common.Card;
import com.outtatech.common.CardType;
import com.outtatech.common.DestinationCard;
import com.outtatech.common.DestinationID;
import com.outtatech.common.HintCard;
import com.outtatech.common.HintCardType;
import com.outtatech.common.PrivateTip;
import com.outtatech.common.PrivateTipType;
import com.outtatech.common.Suggestion;
import com.outtatech.common.SuggestionType;
import com.outtatech.common.SuperSleuth;
import com.outtatech.common.SuperSleuthType;
import com.outtatech.common.SuspectCard;
import com.outtatech.common.SuspectID;
import com.outtatech.common.VehicleCard;
import com.outtatech.common.VehicleID;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.util.Iterator;
import javax.swing.JOptionPane;

/**
 * Version-latenightpizzaparty
 *
 * @author Thomas
 */
public class MainGameScreen extends javax.swing.JFrame
{

    private ArrayList playerIds = new ArrayList();

    private Integer selectedPlayer = null;

    GUIController controller;
    
    CardTranslator translate;

    ActionCard[] actionCards =
    {
        null, null
    };

    /**
     * Version-latenightpizzaparty
     * Creates new form MainGameScreen
     */
    public MainGameScreen()
    {
        initComponents();
    }

    /**
     * Version-latenightpizzaparty
     * Alternate constructor to take a GUIController in
     *
     * @param ctrl method parameter
     */
    public MainGameScreen(GUIController ctrl)
    {
        //set controller to ctrl
        controller = ctrl;
        translate = new CardTranslator(ctrl);

        initComponents();

        locationImage1.setText("");
        locationImage2.setText("");
        locationImage3.setText("");
        locationImage4.setText("");
        locationImage5.setText("");
        locationImage6.setText("");
        locationImage7.setText("");
        locationImage8.setText("");
        locationImage9.setText("");

        updateLocation();

        actionImage1.setText("");
        actionImage2.setText("");

        hintImage1.setText("");
        hintImage2.setText("");
        hintImage3.setText("");
        hintImage4.setText("");
        hintImage5.setText("");
        hintImage6.setText("");

        endTurn();
    }

    /**
     * Version-latenightpizzaparty
     *
     */
    public void updateLocation()
    {
        String path = controller.getImagePath();
        locationImage1.setIcon(new ImageIcon(path + "Location-1.jpg"));
        locationImage2.setIcon(new ImageIcon(path + "Location-2.jpg"));
        locationImage3.setIcon(new ImageIcon(path + "Location-3.jpg"));
        locationImage4.setIcon(new ImageIcon(path + "Location-4.jpg"));
        locationImage5.setIcon(new ImageIcon(path + "Location-5.jpg"));
        locationImage6.setIcon(new ImageIcon(path + "Location-6.jpg"));
        locationImage7.setIcon(new ImageIcon(path + "Location-7.jpg"));
        locationImage8.setIcon(new ImageIcon(path + "Location-8.jpg"));
        locationImage9.setIcon(new ImageIcon(path + "Location-9.jpg"));
    }
    
    public void updateNotes()
    {
        suspectBox1.setText(translate.getName("suspect", 0));
        suspectBox2.setText(translate.getName("suspect", 1));
        suspectBox3.setText(translate.getName("suspect", 2));
        suspectBox4.setText(translate.getName("suspect", 3));
        suspectBox5.setText(translate.getName("suspect", 4));
        suspectBox6.setText(translate.getName("suspect", 5));
        
        vehicleBox1.setText(translate.getName("vehicle", 0));
        vehicleBox2.setText(translate.getName("vehicle", 1));
        vehicleBox3.setText(translate.getName("vehicle", 2));
        vehicleBox4.setText(translate.getName("vehicle", 3));
        vehicleBox5.setText(translate.getName("vehicle", 4));
        vehicleBox6.setText(translate.getName("vehicle", 5));
        
        locationBox1.setText(translate.getName("location", 0));
        locationBox2.setText(translate.getName("location", 1));
        locationBox3.setText(translate.getName("location", 2));
        locationBox4.setText(translate.getName("location", 3));
        locationBox5.setText(translate.getName("location", 4));
        locationBox6.setText(translate.getName("location", 5));
        locationBox7.setText(translate.getName("location", 6));
        locationBox8.setText(translate.getName("location", 7));
        locationBox9.setText(translate.getName("location", 8));
    }

    /**
     * Version-latenightpizzaparty
     *
     * @param cards method parameter
     */
    public void updateHand(List<Card> cards)
    {        
        actionCards[0] = null;
        actionCards[1] = null;
        
        loadActionCards(cards);
        loadHintCards(cards);
    }

    private void loadActionCards(List<Card> cards)
    {
        Card card;
        String path;
        boolean[] filled = 
        {
            false, false
        };
        actionImage1.setIcon(new ImageIcon());
        actionImage2.setIcon(new ImageIcon());
        actionImage1.setText("");
        actionImage2.setText("");

        for (int indx = 0; indx < cards.size(); indx++)
        {
            card = cards.get(indx);
            // Guard against this
            if (card.getCardType() == CardType.ACTION)
            {
                path = translate.getPath(card);
                if(!filled[0])
                {
                    filled[0] = true;
                    actionImage1.setIcon(new ImageIcon(path));
                    actionCards[0] = (ActionCard)card;
                    actionImage1.setText(
                            ((ActionCard)card).getActionType().toString());
                    actionImage1.setHorizontalTextPosition(JLabel.CENTER);
                    actionImage1.setVerticalTextPosition(JLabel.BOTTOM);
                }
                else if(!filled[1])
                {
                    filled[1] = true;
                    actionImage2.setIcon(new ImageIcon(path));
                    actionCards[1] = (ActionCard)card;
                    actionImage2.setText(
                            ((ActionCard)card).getActionType().toString());
                    actionImage2.setHorizontalTextPosition(JLabel.CENTER);
                    actionImage2.setVerticalTextPosition(JLabel.BOTTOM);
                }
            }
        }
    }
    
    private String getHintCardEnum(HintCard card)
    {
        if(card.getHintType() == HintCardType.DESTINATION)
        {
            return translate.translateName(((DestinationCard)card).getDestination().toString());
        }
        else if(card.getHintType() == HintCardType.SUSPECT)
        {
            return translate.translateName(((
                    SuspectCard)card).getSuspect().toString());
        }
        else if(card.getHintType() == HintCardType.VEHICLE)
        {
            return translate.translateName(((
                    VehicleCard)card).getVehicle().toString());
        }
        else
        {
            return "";
        }
    }
    
    public void loadHintCards(java.util.List<Card> cards)
    {
        String path;
        boolean[] filled =
        {
            false, false, false, false, false, false
        };
        hintImage1.setIcon(new ImageIcon());
        hintImage2.setIcon(new ImageIcon());
        hintImage3.setIcon(new ImageIcon());
        hintImage4.setIcon(new ImageIcon());
        hintImage5.setIcon(new ImageIcon());
        hintImage6.setIcon(new ImageIcon());
        
        
        hintImage1.setText("");
        hintImage2.setText("");
        hintImage3.setText("");
        hintImage4.setText("");
        hintImage5.setText("");
        hintImage6.setText("");
        
        // Iterate over this set
        for (int indx = 0; indx < cards.size(); indx++)
        {
            path = translate.getPath(cards.get(indx));
            if(!filled[0] && cards.get(indx).getCardType() == CardType.HINT)
            {
                filled[0] = true;
                hintImage1.setIcon(new ImageIcon(path));
                hintImage1.setText(getHintCardEnum((HintCard)cards.get(indx)));
                hintImage1.setHorizontalTextPosition(JLabel.CENTER);
                hintImage1.setVerticalTextPosition(JLabel.BOTTOM);
            }
            else if(!filled[1] && cards.get(indx).getCardType() == CardType.HINT)
            {
                filled[1] = true;
                hintImage2.setIcon(new ImageIcon(path));
                hintImage2.setText(getHintCardEnum((HintCard)cards.get(indx)));
                hintImage2.setHorizontalTextPosition(JLabel.CENTER);
                hintImage2.setVerticalTextPosition(JLabel.BOTTOM);
            }
            else if(!filled[2] && cards.get(indx).getCardType() == CardType.HINT)
            {
                filled[2] = true;
                hintImage3.setIcon(new ImageIcon(path));
                hintImage3.setText(getHintCardEnum((HintCard)cards.get(indx)));
                hintImage3.setHorizontalTextPosition(JLabel.CENTER);
                hintImage3.setVerticalTextPosition(JLabel.BOTTOM);
            }
            else if(!filled[3] && cards.get(indx).getCardType() == CardType.HINT)
            {
                filled[3] = true;
                hintImage4.setIcon(new ImageIcon(path));
                hintImage4.setText(getHintCardEnum((HintCard)cards.get(indx)));
                hintImage4.setHorizontalTextPosition(JLabel.CENTER);
                hintImage4.setVerticalTextPosition(JLabel.BOTTOM);
            }
            else if(!filled[4] && cards.get(indx).getCardType() == CardType.HINT)
            {
                filled[4] = true;
                hintImage5.setIcon(new ImageIcon(path));
                hintImage5.setText(getHintCardEnum((HintCard)cards.get(indx)));
                hintImage5.setHorizontalTextPosition(JLabel.CENTER);
                hintImage5.setVerticalTextPosition(JLabel.BOTTOM);
            }
            else if(!filled[5] && cards.get(indx).getCardType() == CardType.HINT)
            {
                filled[5] = true;
                hintImage6.setIcon(new ImageIcon(path));
                hintImage6.setText(getHintCardEnum((HintCard)cards.get(indx)));
                hintImage6.setHorizontalTextPosition(JLabel.CENTER);
                hintImage6.setVerticalTextPosition(JLabel.BOTTOM);
            }
        }
    }

    /**
     * Version-latenightpizzaparty
     * Adds a string to the game log
     *
     * @param updateString method parameter
     */
    public void updateGameLog(String updateString)
    {
        String newText = gameLog.getText();
        if (newText.equals(""))
        {
            newText = updateString;
        }
        else
        {
            newText += "\n" + updateString;
        }
        //set game log's text to the current text + updateString
        gameLog.setText(newText);
    }

    /**
     * Version-latenightpizzaparty
     * Clears the game log
     */
    public void clearGameLog()
    {
        //set game log's test to ""
        gameLog.setText("");
    }

    /**
     * Version-latenightpizzaparty
     * Adds a player to the player list
     *
     * @param playerName method parameter
     * @param playerId method parameter
     * @param isPlayer method parameter
     */
    public void addPlayer(String playerName, Integer playerId, boolean isPlayer)
    {
        //set player list to current text + playerName
        String name = playerName;
        // Guard against this
        if (isPlayer)
        {
            name = name + " (You)";
        }
        playerList.setValueAt(name, playerIds.size(), 0);

        //add player id to playerIds
        playerIds.add(playerId);
    }

    /**
     * Version-latenightpizzaparty
     * Removes a player from the player list
     *
     */
    public void clearPlayers()
    {
        //set player list to current text - playerName
        playerList.setValueAt("", 0, 0);
        playerList.setValueAt("", 1, 0);
        playerList.setValueAt("", 2, 0);
        playerList.setValueAt("", 3, 0);
        playerList.setValueAt("", 4, 0);

        //remove player id from playerIds
        playerIds.clear();
    }

    /**
     * Version-latenightpizzaparty
     * Changes a player's location
     *
     * @param locationId method parameter
     * @param playerId method parameter
     */
    public void setPlayerLocation(int locationId, int playerId)
    {
        //sets the background of the specified location panel to the color
        //of the corresponding player
    }
    
    /**
     * Sets the players locations
     * @param dP
     * @param playerMap 
     */
    public void setLocationLabels(Map<DestinationID, Integer> dP, 
            Map<Integer, String> playerMap)
    {
        cleanLocationLabelsText();
        
        ArrayList<DestinationID> enums 
                = new ArrayList<DestinationID>(Arrays.asList(
                DestinationID.CONEY_ISLAND, DestinationID.GOLDEN_GATE_BRIDGE,
                DestinationID.HOOVER_DAM, DestinationID.LINCOLN_MEMORIAL,
                DestinationID.MIAMI_BEACH, DestinationID.MT_RUSHMORE,
                DestinationID.NIAGRA_FALLS,
                DestinationID.OLD_FAITHFUL, DestinationID.THE_ALAMO));
        
        int index = 0;
        for (DestinationID did : enums)
        {
            
            String playerName = "";
            
            if (dP.get(did) != null) 
            {
                playerName = "<b>" + playerMap.get(dP.get(did)) + "</b>";
            }
            
            switch(index)
            {
                case 0:
                    locationImage1.setText("<html>" + 
                            translate.translateName(did.toString())
                            + "<br>" + playerName +"</html>");
                    locationImage1.setHorizontalTextPosition(JLabel.CENTER);
                    locationImage1.setVerticalTextPosition(JLabel.BOTTOM);
                    break;
                case 1:
                    locationImage2.setText("<html>" + 
                            translate.translateName(did.toString()) 
                            + "<br>" + playerName +"</html>");
                    locationImage2.setHorizontalTextPosition(JLabel.CENTER);
                    locationImage2.setVerticalTextPosition(JLabel.BOTTOM);
                    break;
                case 2:
                    locationImage3.setText("<html>" + 
                            translate.translateName(did.toString()) 
                            + "<br>" + playerName +"</html>");
                    locationImage3.setHorizontalTextPosition(JLabel.CENTER);
                    locationImage3.setVerticalTextPosition(JLabel.BOTTOM);
                    break;
                case 3:
                    locationImage4.setText("<html>" + 
                            translate.translateName(did.toString()) 
                            + "<br>" + playerName +"</html>");
                    locationImage4.setHorizontalTextPosition(JLabel.CENTER);
                    locationImage4.setVerticalTextPosition(JLabel.BOTTOM);
                    break;
                case 4:
                    locationImage5.setText("<html>" + 
                            translate.translateName(did.toString()) 
                            + "<br>" + playerName +"</html>");
                    locationImage5.setHorizontalTextPosition(JLabel.CENTER);
                    locationImage5.setVerticalTextPosition(JLabel.BOTTOM);
                    break;
                case 5:
                    locationImage6.setText("<html>" + 
                            translate.translateName(did.toString()) 
                            + "<br>" + playerName +"</html>");
                    locationImage6.setHorizontalTextPosition(JLabel.CENTER);
                    locationImage6.setVerticalTextPosition(JLabel.BOTTOM);
                    break;
                case 6:
                    locationImage7.setText("<html>" + 
                            translate.translateName(did.toString()) 
                            + "<br>" + playerName +"</html>");
                    locationImage7.setHorizontalTextPosition(JLabel.CENTER);
                    locationImage7.setVerticalTextPosition(JLabel.BOTTOM);
                    break;
                case 7:
                    locationImage8.setText("<html>" + 
                            translate.translateName(did.toString()) 
                            + "<br>" + playerName +"</html>");
                    locationImage8.setHorizontalTextPosition(JLabel.CENTER);
                    locationImage8.setVerticalTextPosition(JLabel.BOTTOM);
                    break;
                case 8:
                    locationImage9.setText("<html>" + 
                            translate.translateName(did.toString()) 
                            + "<br>" + playerName +"</html>");
                    locationImage9.setHorizontalTextPosition(JLabel.CENTER);
                    locationImage9.setVerticalTextPosition(JLabel.BOTTOM);
                    break;
            }
            index++;
        }
    }
    
    private void cleanLocationLabelsText()
    {
        locationImage1.setText("");
        locationImage2.setText("");
        locationImage3.setText("");
        locationImage4.setText("");
        locationImage5.setText("");
        locationImage6.setText("");
        locationImage7.setText("");
        locationImage8.setText("");
        locationImage9.setText("");
    }

    /**
     * Version-latenightpizzaparty
     * Makes the window in play mode
     */
    public void startTurn()
    {
        //sets the endTurnButton and accuseButton to active
        endTurnButton.setEnabled(true);
        accuseButton.setEnabled(true);
    }

    /**
     * Version-latenightpizzaparty
     * Makes the window in watch mode
     */
    public void endTurn()
    {
        //sets the endTurnButton and accuseButton to inactive
        endTurnButton.setEnabled(false);
        accuseButton.setEnabled(false);

    }

    /**
     * Version-latenightpizzaparty
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        gameLog = new javax.swing.JTextArea();
        optionsButton = new javax.swing.JButton();
        instructionsButton = new javax.swing.JButton();
        accuseButton = new javax.swing.JButton();
        endTurnButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        playerList = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        suspectBox1 = new javax.swing.JCheckBox();
        suspectBox2 = new javax.swing.JCheckBox();
        suspectBox3 = new javax.swing.JCheckBox();
        suspectBox4 = new javax.swing.JCheckBox();
        suspectBox5 = new javax.swing.JCheckBox();
        suspectBox6 = new javax.swing.JCheckBox();
        vehicleBox1 = new javax.swing.JCheckBox();
        vehicleBox2 = new javax.swing.JCheckBox();
        vehicleBox3 = new javax.swing.JCheckBox();
        vehicleBox4 = new javax.swing.JCheckBox();
        vehicleBox5 = new javax.swing.JCheckBox();
        vehicleBox6 = new javax.swing.JCheckBox();
        locationBox1 = new javax.swing.JCheckBox();
        locationBox2 = new javax.swing.JCheckBox();
        locationBox3 = new javax.swing.JCheckBox();
        locationBox4 = new javax.swing.JCheckBox();
        locationBox5 = new javax.swing.JCheckBox();
        locationBox6 = new javax.swing.JCheckBox();
        locationBox7 = new javax.swing.JCheckBox();
        locationBox8 = new javax.swing.JCheckBox();
        locationBox9 = new javax.swing.JCheckBox();
        leaveGameButton = new javax.swing.JButton();
        locationImage1 = new javax.swing.JLabel();
        locationImage2 = new javax.swing.JLabel();
        locationImage3 = new javax.swing.JLabel();
        locationImage4 = new javax.swing.JLabel();
        locationImage5 = new javax.swing.JLabel();
        locationImage6 = new javax.swing.JLabel();
        locationImage7 = new javax.swing.JLabel();
        locationImage8 = new javax.swing.JLabel();
        locationImage9 = new javax.swing.JLabel();
        actionImage1 = new javax.swing.JLabel();
        actionImage2 = new javax.swing.JLabel();
        hintImage1 = new javax.swing.JLabel();
        hintImage2 = new javax.swing.JLabel();
        hintImage3 = new javax.swing.JLabel();
        hintImage4 = new javax.swing.JLabel();
        hintImage5 = new javax.swing.JLabel();
        hintImage6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Game Log:");

        gameLog.setEditable(false);
        gameLog.setColumns(20);
        gameLog.setRows(5);
        jScrollPane1.setViewportView(gameLog);

        optionsButton.setText("Options");
        optionsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                optionsButtonMouseClicked(evt);
            }
        });

        instructionsButton.setText("Instructions");
        instructionsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                instructionsButtonMouseClicked(evt);
            }
        });

        accuseButton.setText("Accuse!");
        accuseButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accuseButtonMouseClicked(evt);
            }
        });

        endTurnButton.setText("End Turn");
        endTurnButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                endTurnButtonMouseClicked(evt);
            }
        });

        jLabel3.setText("Your Hand:");

        playerList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Players:"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        playerList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        playerList.setShowHorizontalLines(false);
        playerList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                playerListMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(playerList);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        suspectBox1.setText("Suspect1");

        suspectBox2.setText("Suspect2");

        suspectBox3.setText("Suspect3");

        suspectBox4.setText("Suspect4");

        suspectBox5.setText("Suspect5");

        suspectBox6.setText("Suspect6");

        vehicleBox1.setText("Vehicle1");

        vehicleBox2.setText("Vehicle2");

        vehicleBox3.setText("Vehicle3");

        vehicleBox4.setText("Vehicle4");

        vehicleBox5.setText("Vehicle5");

        vehicleBox6.setText("Vehicle6");

        locationBox1.setText("Location1");

        locationBox2.setText("Location2");

        locationBox3.setText("Location3");

        locationBox4.setText("Location4");

        locationBox5.setText("Location5");

        locationBox6.setText("Location6");

        locationBox7.setText("Location7");

        locationBox8.setText("Location8");

        locationBox9.setText("Location9");
        locationBox9.setToolTipText("");

        leaveGameButton.setText("Leave Game");
        leaveGameButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                leaveGameButtonMouseClicked(evt);
            }
        });

        locationImage1.setText("L1");

        locationImage2.setText("L2");

        locationImage3.setText("L3");

        locationImage4.setText("L4");

        locationImage5.setText("L5");

        locationImage6.setText("L6");

        locationImage7.setText("L7");

        locationImage8.setText("L8");

        locationImage9.setText("L9");

        actionImage1.setText("AC1");
        actionImage1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                actionImage1MouseClicked(evt);
            }
        });

        actionImage2.setText("AC2");
        actionImage2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                actionImage2MouseClicked(evt);
            }
        });

        hintImage1.setText("HC1");

        hintImage2.setText("HC2");

        hintImage3.setText("HC3");

        hintImage4.setText("HC4");

        hintImage5.setText("HC5");

        hintImage6.setText("HC6");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(leaveGameButton, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(suspectBox1)
                                                .addComponent(suspectBox2)
                                                .addComponent(suspectBox3)
                                                .addComponent(suspectBox4)
                                                .addComponent(suspectBox5)
                                                .addComponent(suspectBox6)
                                                .addComponent(vehicleBox1)
                                                .addComponent(vehicleBox2)
                                                .addComponent(vehicleBox3)
                                                .addComponent(vehicleBox4)
                                                .addComponent(vehicleBox5)
                                                .addComponent(vehicleBox6))
                                            .addGap(83, 83, 83)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(locationBox9)
                                                .addComponent(locationBox8)
                                                .addComponent(locationBox6)
                                                .addComponent(locationBox5)
                                                .addComponent(locationBox4)
                                                .addComponent(locationBox3)
                                                .addComponent(locationBox2)
                                                .addComponent(locationBox1)
                                                .addComponent(locationBox7)))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(actionImage1)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(actionImage2)))
                                    .addGap(8, 8, 8)
                                    .addComponent(hintImage1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(hintImage2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(hintImage3)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(hintImage4)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(hintImage5)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(hintImage6))
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(locationImage1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(locationImage2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(locationImage3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(locationImage4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(locationImage5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(locationImage6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(locationImage7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(locationImage8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(locationImage9)))
                .addContainerGap(285, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(optionsButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(instructionsButton))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(endTurnButton)
                                    .addComponent(accuseButton))))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(optionsButton)
                            .addComponent(instructionsButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(accuseButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(endTurnButton)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(locationImage1)
                    .addComponent(locationImage2)
                    .addComponent(locationImage3)
                    .addComponent(locationImage4)
                    .addComponent(locationImage5)
                    .addComponent(locationImage6)
                    .addComponent(locationImage7)
                    .addComponent(locationImage8)
                    .addComponent(locationImage9))
                .addGap(32, 32, 32)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(actionImage1)
                    .addComponent(actionImage2)
                    .addComponent(hintImage1)
                    .addComponent(hintImage2)
                    .addComponent(hintImage3)
                    .addComponent(hintImage4)
                    .addComponent(hintImage5)
                    .addComponent(hintImage6))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(suspectBox1)
                            .addComponent(locationBox1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(suspectBox2)
                            .addComponent(locationBox2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(suspectBox3)
                            .addComponent(locationBox3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(suspectBox4)
                            .addComponent(locationBox4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(suspectBox5)
                            .addComponent(locationBox5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(suspectBox6)
                            .addComponent(locationBox6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(locationBox7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(vehicleBox1)
                            .addComponent(locationBox8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(vehicleBox2)
                            .addComponent(locationBox9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(vehicleBox3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(vehicleBox4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(vehicleBox5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(vehicleBox6))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(leaveGameButton)
                .addContainerGap(275, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void instructionsButtonMouseClicked(java.awt.event.MouseEvent evt)
    {//GEN-FIRST:event_instructionsButtonMouseClicked
        //call controller's showInstructions method
        controller.showInstructions();
    }//GEN-LAST:event_instructionsButtonMouseClicked

    private void optionsButtonMouseClicked(java.awt.event.MouseEvent evt)
    {//GEN-FIRST:event_optionsButtonMouseClicked
        //call controller's showOptions method
        controller.showOptions();
    }//GEN-LAST:event_optionsButtonMouseClicked

    private void accuseButtonMouseClicked(java.awt.event.MouseEvent evt)
    {//GEN-FIRST:event_accuseButtonMouseClicked
        //call controller's accuse method
        // Guard against this
        if (accuseButton.isEnabled())
        {
            controller.accuse();
        }
    }//GEN-LAST:event_accuseButtonMouseClicked
    
    public void disableEndTurnBtn()
    {
        if(endTurnButton.isEnabled())
        {
            endTurnButton.setEnabled(false);
        }
    }
    
    public void disableAccuseBtn()
    {
        if(accuseButton.isEnabled())
        {
            accuseButton.setEnabled(false);
        }
    }
    
    private void endTurnButtonMouseClicked(java.awt.event.MouseEvent evt)
    {//GEN-FIRST:event_endTurnButtonMouseClicked
        // Guard against this
        if (endTurnButton.isEnabled())
        {
            //call controller's endTurn method
            endTurn();
            
            //call this's endTurn method
            controller.endTurn();
        }
    }//GEN-LAST:event_endTurnButtonMouseClicked

    private void playerListMouseClicked(java.awt.event.MouseEvent evt)
    {//GEN-FIRST:event_playerListMouseClicked
        //set selectedPlayer to selected player's id
        selectedPlayer = (Integer)playerIds.get(playerList.getSelectedRow());
        
    }//GEN-LAST:event_playerListMouseClicked

    private void leaveGameButtonMouseClicked(java.awt.event.MouseEvent evt)
    {//GEN-FIRST:event_leaveGameButtonMouseClicked
        //call controller's exitWindow method
        controller.exitWindow();
    }//GEN-LAST:event_leaveGameButtonMouseClicked

    private void actionImage1MouseClicked(java.awt.event.MouseEvent evt)
    {//GEN-FIRST:event_actionImage1MouseClicked
        // Guard against this
        if (actionCards[0] != null)
        {
            controller.playCard(actionCards[0], selectedPlayer);
        }
    }//GEN-LAST:event_actionImage1MouseClicked

    private void actionImage2MouseClicked(java.awt.event.MouseEvent evt)
    {//GEN-FIRST:event_actionImage2MouseClicked
        // Guard against this
        if (actionCards[1] != null)
        {
            controller.playCard(actionCards[1], selectedPlayer);
        }
    }//GEN-LAST:event_actionImage2MouseClicked

    public void notifyUser(String msg)
    {
        JOptionPane.showMessageDialog(null, msg, " Play Error"
                , JOptionPane.INFORMATION_MESSAGE);
    }
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
            java.util.logging.Logger.getLogger(MainGameScreen.class.getName()).
                    log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(MainGameScreen.class.getName()).
                    log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(MainGameScreen.class.getName()).
                    log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(MainGameScreen.class.getName()).
                    log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new MainGameScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton accuseButton;
    private javax.swing.JLabel actionImage1;
    private javax.swing.JLabel actionImage2;
    private javax.swing.JButton endTurnButton;
    private javax.swing.JTextArea gameLog;
    private javax.swing.JLabel hintImage1;
    private javax.swing.JLabel hintImage2;
    private javax.swing.JLabel hintImage3;
    private javax.swing.JLabel hintImage4;
    private javax.swing.JLabel hintImage5;
    private javax.swing.JLabel hintImage6;
    private javax.swing.JButton instructionsButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton leaveGameButton;
    private javax.swing.JCheckBox locationBox1;
    private javax.swing.JCheckBox locationBox2;
    private javax.swing.JCheckBox locationBox3;
    private javax.swing.JCheckBox locationBox4;
    private javax.swing.JCheckBox locationBox5;
    private javax.swing.JCheckBox locationBox6;
    private javax.swing.JCheckBox locationBox7;
    private javax.swing.JCheckBox locationBox8;
    private javax.swing.JCheckBox locationBox9;
    private javax.swing.JLabel locationImage1;
    private javax.swing.JLabel locationImage2;
    private javax.swing.JLabel locationImage3;
    private javax.swing.JLabel locationImage4;
    private javax.swing.JLabel locationImage5;
    private javax.swing.JLabel locationImage6;
    private javax.swing.JLabel locationImage7;
    private javax.swing.JLabel locationImage8;
    private javax.swing.JLabel locationImage9;
    private javax.swing.JButton optionsButton;
    private javax.swing.JTable playerList;
    private javax.swing.JCheckBox suspectBox1;
    private javax.swing.JCheckBox suspectBox2;
    private javax.swing.JCheckBox suspectBox3;
    private javax.swing.JCheckBox suspectBox4;
    private javax.swing.JCheckBox suspectBox5;
    private javax.swing.JCheckBox suspectBox6;
    private javax.swing.JCheckBox vehicleBox1;
    private javax.swing.JCheckBox vehicleBox2;
    private javax.swing.JCheckBox vehicleBox3;
    private javax.swing.JCheckBox vehicleBox4;
    private javax.swing.JCheckBox vehicleBox5;
    private javax.swing.JCheckBox vehicleBox6;
    // End of variables declaration//GEN-END:variables
}
