package Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class FirstYearScenario {
    private frame2 ui;
    private Player player;
    private int eventCounter = 0;



    
    public FirstYearScenario(frame2 ui) {
		// TODO Auto-generated constructor stub
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
    	ui.setStory1("Its already midterm in your first semester \nHow do you spend your time?");

        ui.setButton1Story1("Go to library to learn about coding");
        ui.setButton2Story1("Group study with friends before the exam");
        ui.setButton3Story1("Prepare for exam alone");


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
            	player.increaseSkillLevel(1);
                ui.updatePlayerDetails();
                eventCounter++;
                nextEvent();
            }
        });
        break;

    case 1:
        clearButtonListeners();
        ui.setStory1("Its your summer break \nHow will you spend your time during summer break?");
        ui.setButton1Story1("Work part time");
        ui.setButton2Story1("Spend your time with your family and friends");
        ui.setButton3Story1("Stay at dorm and study for next semester");

        ui.addButton1ListenerStory1(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.increaseMoney(50);
                player.increaseRelationLevel(1);
                ui.updatePlayerDetails();
                eventCounter++;
                nextEvent();
            	
            }
        });

        ui.addButton2ListenerStory1(new ActionListener() {
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
        
    case 2:
    	ui.setStory1("During the second semester period someone offered you to work part time as a cashier \n what will you respond?\n*If you accept it will affect your grades");

        ui.setButton1Story1("Accept it anyway");
        ui.setButton2Story1("Ignore him");
        ui.setButton3Story1("Politely decline");


        ui.addButton1ListenerStory1(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.increaseMoney(100);
                player.decreaseSkillLevel(1);
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
                ui.updatePlayerDetails();
                eventCounter++;
                nextEvent();
            }
        });

        ui.addButton3ListenerStory1(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ui.updatePlayerDetails();
                eventCounter++;
                nextEvent();
            }
        });
        break;


    default:
    	ui.transitionToSecondYearScenario();
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
