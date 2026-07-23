package Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class InternScenario {
    private frame2 ui;
    private Player player;
    private int eventCounter = 0;

    public InternScenario(frame2 ui) {
        this.ui = ui;
        this.player = ui.getPlayer();
    }

    
    public void initializeScenario() 
    {
        eventCounter = 0;
        nextEvent();
    }
    private void nextEvent() {
    switch (eventCounter) {
    case 0:
    	ui.setStory1("You are applying for intern \nWhich Company would you like to apply?");

        ui.setButton1Story1("New Startup Company");
        ui.setButton2Story1("Amazon");
        ui.setButton3Story1("Google");


        ui.addButton1ListenerStory1(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.increaseMotivation(1);
                player.decreaseRelationLevel(1);
                ui.updatePlayerDetails();
                eventCounter++;
                nextEvent();
            }
        });

        ui.addButton2ListenerStory1(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if(player.getSkillLevel() < 7 || player.getRelationLevel() < 7 || player.getMotivation() < 7)
            	{
            		JOptionPane.showMessageDialog(ui, "You were rejected because you are not good enough for this company", "Warning", JOptionPane.ERROR_MESSAGE);
            	}else
            	{
            		
            		player.increaseSkillLevel(1);
            		player.increaseMotivation(1);
            		player.increaseRelationLevel(1);
                    ui.updatePlayerDetails();
                    eventCounter++;
                    nextEvent();
            	}
            }
        });

        ui.addButton3ListenerStory1(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	if(player.getSkillLevel() < 11 || player.getRelationLevel() < 11 || player.getMotivation() < 11)
            	{
            		JOptionPane.showMessageDialog(ui, "You were rejected because you are not good enough for this company", "Warning", JOptionPane.ERROR_MESSAGE);
            	}else
            	{
            		JOptionPane.showMessageDialog(ui, "Congrats, You were selected as the special one\nU will earn all the +1 for all the stats and +2 for the relation level ", "Lucky News", JOptionPane.INFORMATION_MESSAGE);
            		player.increaseSkillLevel(1);
            		player.increaseMotivation(1);
            		player.increaseRelationLevel(2);
                    ui.updatePlayerDetails();
                    eventCounter++;
                    nextEvent();
            	}
            }
        });
        break;

    case 1:
        clearButtonListeners();
        ui.setStory1("During your intern you did a mistake \nWhat was the mistake that you made?");
        ui.setButton1Story1("You sent wrong code to your manager");
        ui.setButton2Story1("You took a wallet with full of cash that was left on a table");
        ui.setButton3Story1("You accidently ate someone else's sandwich in the pantry");

        ui.addButton1ListenerStory1(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.decreaseSkillLevel(2);
                player.decreaseRelationLevel(1);
                player.decreaseMotivation(eventCounter);
                ui.updatePlayerDetails();
                eventCounter++;
                nextEvent();
            	
            }
        });

        ui.addButton2ListenerStory1(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	JOptionPane.showMessageDialog(ui, "When you took the wallet and took the cash \nYou saw someone who was struggling to find his wallet and you approach him\nHe was thankful and you never thought that he is your ceo\n(Increase relation point +2)", "Blessing in disguise", JOptionPane.INFORMATION_MESSAGE);
            	
                player.increaseRelationLevel(2);
                ui.updatePlayerDetails();
                eventCounter++;
                nextEvent();
            }
        });

        ui.addButton3ListenerStory1(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	JOptionPane.showMessageDialog(ui, "You ate the director's favourite sandwich\n you were fired from the company and receive bad grade from internship\n Your hardworking life is gone forever","UMMMMMMM", JOptionPane.ERROR_MESSAGE);
            	int choice = JOptionPane.showOptionDialog(ui, "Would you like to start over or quit?", "Game Over",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Start Over", "Quit"}, JOptionPane.YES_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    ui.dispose();
                    Main.main(new String[0]);  // Restart the game
                } else {
                    System.exit(0);  // Quit the game
                }
            }
        });
        break;


    default:
    	ui.transitionToGraduationUniversityScenario();
        break;
}
}

private void clearButtonListeners() {
    for (ActionListener al : ui.getBtnChoice1().getActionListeners()) {
        ui.getBtnChoice1().removeActionListener(al);
    }
    for (ActionListener al : ui.getBtnChoice2().getActionListeners()) {
        ui.getBtnChoice2().removeActionListener(al);
    }
    for (ActionListener al : ui.getBtnChoice3().getActionListeners()) {
        ui.getBtnChoice3().removeActionListener(al);
    }
}
    
    
}
