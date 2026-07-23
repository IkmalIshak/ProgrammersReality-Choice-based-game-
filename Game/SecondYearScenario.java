package Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class SecondYearScenario {
    private frame2 ui;
    private Player player;
    private int eventCounter = 0;

    public SecondYearScenario(frame2 ui) {
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
    	ui.setStory1("Its your second year!!! ( Wow u managed to survive )\n During your second semester u feel stress with all your assignments \nHow will you react");

        ui.setButton1Story1("Procrastinate and just go to sleep!");
        ui.setButton2Story1("Never give up!!! Remember your future!!");
        ui.setButton3Story1("Give up and drop the course!");


        ui.addButton1ListenerStory1(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.increaseMotivation(1);
                player.decreaseSkillLevel(1);
                ui.updatePlayerDetails();
                eventCounter++;
                nextEvent();
            }
        });

        ui.addButton2ListenerStory1(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.increaseSkillLevel(1);
                ui.updatePlayerDetails();
                eventCounter++;
                nextEvent();
            }
        });

        ui.addButton3ListenerStory1(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	 JOptionPane.showMessageDialog(ui, "You lack of experience and money made you fail your life after you drop out.", "Bad News", JOptionPane.ERROR_MESSAGE);
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

    case 1:
        clearButtonListeners();
        ui.setStory1("During your second semester in second year your professor called you to his office! \nSomeone reported that you cheated during exam\nHow will you respond?");
        ui.setButton1Story1("Blame the one who reported you and explain that you have been accused");
        ui.setButton2Story1("Confront the lecturer and provide evidences that you are innocent");
        ui.setButton3Story1("Take the blame and retake the subject");

        ui.addButton1ListenerStory1(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.decreaseRelationLevel(1);
                player.decreaseMotivation(1);
                ui.updatePlayerDetails();
                eventCounter++;
                nextEvent();
            	
            }
        });

        ui.addButton2ListenerStory1(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	player.increaseMotivation(1);
            	player.increaseRelationLevel(1);
                ui.updatePlayerDetails();
                eventCounter++;
                nextEvent();
            }
        });

        ui.addButton3ListenerStory1(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	player.decreaseMotivation(1);
            	player.increaseSkillLevel(1);
                ui.updatePlayerDetails();
                eventCounter++;
                nextEvent();
            }
        });
        break;


    default:
    	ui.transitionToThirdYearScenario();
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
