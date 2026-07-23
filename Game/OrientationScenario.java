package Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class OrientationScenario {
    private frame2 ui;
    private Player player;
    private int eventCounter = 0;

    public OrientationScenario(frame2 ui) {
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
    	ui.setStory1("Its your orientation week! \nWhat are you going to do on your first week?");

        ui.setButton1Story1("Sleep in your doom");
        ui.setButton2Story1("Skip your orientation and enjoy with your highschool friends");
        ui.setButton3Story1("Join the orientation progress");


        ui.addButton1ListenerStory1(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.decreaseMotivation(1);
                ui.updatePlayerDetails();
                eventCounter++;
                nextEvent();
            }
        });

        ui.addButton2ListenerStory1(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if(player.getMoney()<30)
            	{
            		JOptionPane.showMessageDialog(ui, "Not enough money! \nplease earn some money before u enjoy!", "Warning", JOptionPane.ERROR_MESSAGE);
            	}else
            	{
            		player.decreaseMoney(30);
                    ui.updatePlayerDetails();
                    eventCounter++;
                    nextEvent();
                }
            	}
                
        });

        ui.addButton3ListenerStory1(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	 player.increaseRelationLevel(1);
                 player.increaseMotivation(1);
                ui.updatePlayerDetails();
                eventCounter++;
                nextEvent();
            }
        });
        break;

    case 1:
        clearButtonListeners();
        ui.setStory1("Its your final day for orientation! \nwhat will you do next?");
        ui.setButton1Story1("Stay at the dorm and study programming ahead of class");
        ui.setButton2Story1("Get closer with your course's senior");
        ui.setButton3Story1("Go eat with your new friends");

        ui.addButton1ListenerStory1(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.increaseSkillLevel(1);
                player.decreaseRelationLevel(1);
                ui.updatePlayerDetails();
                eventCounter++;
                nextEvent();
            	
            }
        });

        ui.addButton2ListenerStory1(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.increaseRelationLevel(1);
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
            	if (player.getMoney() < 20 )
            	{
            		JOptionPane.showMessageDialog(ui, "Not enough money! \nplease earn some money!", "Warning", JOptionPane.ERROR_MESSAGE);
            		
            	}else {
                player.decreaseMoney(20);
                player.increaseRelationLevel(1);
                ui.updatePlayerDetails();
                eventCounter++;
                nextEvent();
            	}
            }
        });
        break;


    default:
    	ui.transitionToFirstYearScenario();
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
