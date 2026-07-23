package Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class GraduationUniversityScenario {
    private frame2 ui;
    private Player player;
    private int eventCounter = 0;

    public GraduationUniversityScenario(frame2 ui) {
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
    	ui.setStory1("Your university do not have enough money to cover for your batch graduation\nWhat would you do to help your university as Vice President?");

        ui.setButton1Story1("Setup a link and bank account so that everyone can donate");
        ui.setButton2Story1("Sponsor it yourself");
        ui.setButton3Story1("Ask from big companies for donation");


        ui.addButton1ListenerStory1(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	JOptionPane.showMessageDialog(ui, "Great effort but the result was flop", "OOpsss", JOptionPane.WARNING_MESSAGE);
                player.decreaseMotivation(1);
                player.decreaseRelationLevel(1);
                ui.updatePlayerDetails();
                eventCounter++;
                nextEvent();
            }
        });

        ui.addButton2ListenerStory1(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	JOptionPane.showMessageDialog(ui, "Everyone was shocked to see how rich u are and they were glad", "Rich Person", JOptionPane.INFORMATION_MESSAGE);
                player.decreaseMoney(100);
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
            	if(player.getRelationLevel() < 15)
            	{
            		JOptionPane.showMessageDialog(ui, "Its seem like you were not good enough for the big companies", "Nice try :(", JOptionPane.WARNING_MESSAGE);
            	}
            	else
            	{
            		JOptionPane.showMessageDialog(ui, "Everyone was shocked to see how rich u are and they were glad", "Rich Person", JOptionPane.INFORMATION_MESSAGE);
            		player.increaseRelationLevel(1);
                    player.increaseMotivation(1);
                   ui.updatePlayerDetails();
                   eventCounter++;
                   nextEvent();
            	}
            	
            }
        });
        break;

    case 1:
        clearButtonListeners();
        ui.setStory1("Its your final day in Universities!\nAs a vice president you need to give your speech to others\nwhat will you say?");
        ui.setButton1Story1("Thanks your parent,professors,friends and seniors");
        ui.setButton2Story1("Boast about your projects and skills");
        ui.setButton3Story1("Give motivation to your peers");

        ui.addButton1ListenerStory1(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
                player.decreaseRelationLevel(1);
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
                player.increaseRelationLevel(1);
                ui.updatePlayerDetails();
                eventCounter++;
                nextEvent();
            }
        });
        break;


    default:
    	ui.transitionToFindingJobsScenario();
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
