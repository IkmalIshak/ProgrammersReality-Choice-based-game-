package Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class LastYearScenario {
    private frame2 ui;
    private Player player;
    private int eventCounter = 0;

    public LastYearScenario(frame2 ui) {
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
    	ui.setStory1("ITS YOUR FINAL YEAR WUHUUUU!! \nYou were selected as the vice president for your department\nWhat would be your first action?");

        ui.setButton1Story1("Participate in orientation as a facilitator");
        ui.setButton2Story1("Hold a career based event for your department");
        ui.setButton3Story1("Go all out asking for donation for your department");


        ui.addButton1ListenerStory1(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.increaseRelationLevel(1);
                ui.updatePlayerDetails();
                eventCounter++;
                nextEvent();
            }
        });

        ui.addButton2ListenerStory1(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	player.increaseRelationLevel(1);
            	player.increaseMotivation(1);
            	player.increaseSkillLevel(1);
                ui.updatePlayerDetails();
                eventCounter++;
                nextEvent();
            }
        });

        ui.addButton3ListenerStory1(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	player.increaseSkillLevel(1);
                 player.decreaseMotivation(1);
                ui.updatePlayerDetails();
                eventCounter++;
                nextEvent();
            }
        });
        break;

    case 1:
        clearButtonListeners();
        ui.setStory1("You have a final year project \nyour professor gave you choices that you can made for your final year project");
        ui.setButton1Story1("Present with your friends and discuss together");
        ui.setButton2Story1("Solo present but make it bombastic");
        ui.setButton3Story1("Pair up with the quiet kid in your class");

        ui.addButton1ListenerStory1(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.increaseSkillLevel(1);
                player.increaseMotivation(1);
                player.increaseRelationLevel(1);
                ui.updatePlayerDetails();
                eventCounter++;
                nextEvent();
            	
            }
        });

        ui.addButton2ListenerStory1(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.increaseSkillLevel(1);
                player.increaseMotivation(1);
                ui.updatePlayerDetails();
                eventCounter++;
                nextEvent();
            }
        });

        ui.addButton3ListenerStory1(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            
            	JOptionPane.showMessageDialog(ui, "Wow no one know that the quiet kid is the son of the Ministry of Education\nBecause of you willingly to partner with him\n U receive +2 stats and 100 money", "Lucky News", JOptionPane.INFORMATION_MESSAGE);
                player.increaseMoney(100);
                player.increaseRelationLevel(2);
                player.increaseSkillLevel(2);
                player.increaseMotivation(2);
                ui.updatePlayerDetails();
                eventCounter++;
                nextEvent();
            }
        });
        break;


    default:
    	ui.transitionToInternScenario();
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
