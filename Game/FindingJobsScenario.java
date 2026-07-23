package Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class FindingJobsScenario {
    private frame2 ui;
    private Player player;
    private int eventCounter = 0;

    public FindingJobsScenario(frame2 ui) {
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
    	ui.setStory1("You finished your college and you wanted to find job\nWhat will you do first before you start applying?");

        ui.setButton1Story1("Complete your cv");
        ui.setButton2Story1("Practise your vocal for interview");
        ui.setButton3Story1("Do a lot of mockup programming interview questions");


        ui.addButton1ListenerStory1(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.increaseMotivation(1);
                ui.updatePlayerDetails();
                eventCounter++;
                nextEvent();
            }
        });

        ui.addButton2ListenerStory1(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.increaseMotivation(1);
                ui.updatePlayerDetails();
                eventCounter++;
                nextEvent();
            }
        });

        ui.addButton3ListenerStory1(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	 player.increaseSkillLevel(1);
                 player.increaseMotivation(1);
                ui.updatePlayerDetails();
                eventCounter++;
                nextEvent();
            }
        });
        break;

    case 1:
        clearButtonListeners();
        ui.setStory1("Last choice to determine your future\nPlease make your choice");
        ui.setButton1Story1("Apply for scholarship to study master program");
        ui.setButton2Story1("Start working with software companies");
        ui.setButton3Story1("Give up on programming and work as businessman");

        ui.addButton1ListenerStory1(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if(player.getRelationLevel() < 16 || player.getSkillLevel() < 13 || player.getMotivation() < 14)
            	{
            		JOptionPane.showMessageDialog(ui, "Its seem like you were no one wanted to sponsor you", "Nice try :(", JOptionPane.WARNING_MESSAGE);
            	}
            	else
            	{
            		JOptionPane.showMessageDialog(ui, "Congrats you are fully supported to continue your studies", "The shining gem", JOptionPane.INFORMATION_MESSAGE);
            		JOptionPane.showMessageDialog(ui, "after u finished your studies you work in a high end company and became the ceo in two years","Secret ending!", JOptionPane.INFORMATION_MESSAGE);
                	int choice = JOptionPane.showOptionDialog(ui, "Would you like to start over or quit?", "You finished the game",
                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Start Over", "Quit"}, JOptionPane.YES_OPTION);
                    if (choice == JOptionPane.YES_OPTION) {
                        ui.dispose();
                        Main.main(new String[0]);  // Restart the game
                    } else {
                        System.exit(0);  // Quit the game
                    }
                   
            	}
            	
            }
        });

        ui.addButton2ListenerStory1(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.increaseRelationLevel(1);
                player.increaseSkillLevel(1);
                player.decreaseMotivation(1);
                ui.updatePlayerDetails();
                eventCounter++;
                nextEvent();
            }
        });

        ui.addButton3ListenerStory1(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	JOptionPane.showMessageDialog(ui, "Why did you choose to quit at the last part of your choice\nBut it is okay you can play again thou!","WHYYYY!", JOptionPane.ERROR_MESSAGE);
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
    	showEndingFrame();
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

private void showEndingFrame() {
    EndingFrame endingFrame = new EndingFrame(player);
    endingFrame.setVisible(true);

    ui.dispose();
}
    
    
}
