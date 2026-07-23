package Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class GraduationScenario {
    private frame2 ui;
    private Player player;
    private int eventCounter = 0;

    public GraduationScenario(frame2 ui) {
        this.ui = ui;
        this.player = ui.getPlayer();
    }

    
    public void initializeScenarios() 
    { 
        eventCounter = 0;
        nextEvent();
    }
    private void nextEvent() {
    switch (eventCounter) {
    case 0:
    	ui.setStory1("Congratulations on graduating high school! \n You got a computer science major in your university \n what will you do before joining university?");

        ui.setButton1Story1("Join programming classes.");
        ui.setButton2Story1("Enjoy your life.");
        ui.setButton3Story1("Start working part time.");


        ui.addButton1ListenerStory1(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.increaseSkillLevel(1);
                player.increaseMotivation(1);
                ui.updatePlayerDetails();
                eventCounter++;
                nextEvent();
            }
        });

        ui.addButton2ListenerStory1(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.decreaseSkillLevel(1);
                ui.updatePlayerDetails();
                eventCounter++;
                nextEvent();
            }
        });

        ui.addButton3ListenerStory1(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.increaseMoney(100);
                player.increaseRelationLevel(1);
                ui.updatePlayerDetails();
                eventCounter++;
                nextEvent();
            }
        });
        break;

    case 1:
        clearButtonListeners();
        ui.setStory1("One week before you joined your orientation!\nYou broke your mouse\nwhat will you do?");
        ui.setButton1Story1("Buy a new mouse! (Only 60)");
        ui.setButton2Story1("Just survive using your touch pad");
        ui.setButton3Story1("Dont buy mouse but invest the money (Only 50) !");

        ui.addButton1ListenerStory1(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if (player.getMoney() < 10 )
            	{
            		JOptionPane.showMessageDialog(ui, "Not enough money! \nplease earn some money!", "Warning", JOptionPane.ERROR_MESSAGE);
            		
            	}else {
                player.increaseMotivation(1);
                player.increaseSkillLevel(1);
                player.decreaseMoney(60);
                ui.updatePlayerDetails();
                eventCounter++;
                nextEvent();
            	}
            }
        });

        ui.addButton2ListenerStory1(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.decreaseMotivation(1);
                player.decreaseSkillLevel(1);
                ui.updatePlayerDetails();
                eventCounter++;
                nextEvent();
            }
        });

        ui.addButton3ListenerStory1(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if (player.getMoney() < 50 )
            	{
            		JOptionPane.showMessageDialog(ui, "Not enough money! \nplease earn some money!", "Warning", JOptionPane.ERROR_MESSAGE);
            		
            	}else {
                player.increaseMoney(50);
                player.increaseMotivation(1);
                ui.updatePlayerDetails();
                eventCounter++;
                nextEvent();
            	}
            }
        });
        break;

    // Add more cases for additional events if needed

    default:
        ui.transitionToOrientationScenario();
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
