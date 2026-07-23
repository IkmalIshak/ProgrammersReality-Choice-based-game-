package Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class ThirdYearScenario {
    private frame2 ui;
    private Player player;
    private int eventCounter = 0;

    public ThirdYearScenario(frame2 ui) {
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
    	ui.setStory1("In your third year\nYour laptop suddenly explode \nWhat will you do in order to study?");

        ui.setButton1Story1("Spend money to buy new laptop (ONLY 200)");
        ui.setButton2Story1("Try to ask from peers to sponsor you new laptop");
        ui.setButton3Story1("Just use internet cafe or library laptop");


        ui.addButton1ListenerStory1(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if(player.getMoney() < 200)
            	{
            		JOptionPane.showMessageDialog(ui, "It seems like you lack of money. I dont think you can afford this laptop", "Warning", JOptionPane.ERROR_MESSAGE);
            	}else
            	{
            		player.decreaseMoney(200);
                    player.increaseSkillLevel(1);
                    player.increaseMotivation(1);
                    ui.updatePlayerDetails();
                    eventCounter++;
                    nextEvent();
            	}
            }
        });

        ui.addButton2ListenerStory1(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if(player.getRelationLevel() < 7)
            	{
            		JOptionPane.showMessageDialog(ui, "You are not close enough with people! \nBe nice to people next time!", "Warning", JOptionPane.ERROR_MESSAGE);
            	}else
            	{
            		JOptionPane.showMessageDialog(ui, "Congrats someone was willing to sponsor you", "Good News", JOptionPane.INFORMATION_MESSAGE);
            		player.increaseRelationLevel(1);
                    player.increaseMotivation(1);
                    player.increaseSkillLevel(1);
                    ui.updatePlayerDetails();
                    eventCounter++;
                    nextEvent();
            	}
            }
        });

        ui.addButton3ListenerStory1(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 player.decreaseMotivation(1);
                ui.updatePlayerDetails();
                eventCounter++;
                nextEvent();
            }
        });
        break;

    case 1:
        clearButtonListeners();
        ui.setStory1("Your professor gave you opportunity to become his Teaching Assistant\nDo you think you can accept your professor's offer?\n(Must have high motivation, high relation point and high skill)");
        ui.setButton1Story1("I will reconsider it, I want to study on my own first");
        ui.setButton2Story1("Yes! , Why not??");
        ui.setButton3Story1("No, I dont deserve this job yet");

        ui.addButton1ListenerStory1(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
                player.increaseSkillLevel(1);
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
            	if(player.getMotivation() < 5|| player.getRelationLevel() < 5 || player.getSkillLevel() < 5)
            	{
            		JOptionPane.showMessageDialog(ui, "You are not close enough to get this position! \nIncrease your stats next time!", "Warning", JOptionPane.ERROR_MESSAGE);
            	}else {
            		JOptionPane.showMessageDialog(ui, "Wow you deserve this job with all your stats!", "Good News", JOptionPane.INFORMATION_MESSAGE);
                player.increaseRelationLevel(1);
                player.increaseSkillLevel(1);
                player.increaseMotivation(1);
                player.increaseMoney(100);
                ui.updatePlayerDetails();
                eventCounter++;
                nextEvent();
            	}
            }
        });

        ui.addButton3ListenerStory1(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.decreaseRelationLevel(1);
                ui.updatePlayerDetails();
                eventCounter++;
                nextEvent();
            }
        });
        break;
        
    case 2:
        clearButtonListeners();
        ui.setStory1("Random encounter\n Someone want you to teach her in coding as a mentor\nWould you accept it?");
        ui.setButton1Story1("I will but she need to pay me");
        ui.setButton2Story1("No, I dont want to teach her");
        ui.setButton3Story1("Sure, I will teach her");

        ui.addButton1ListenerStory1(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
                player.increaseMoney(100);
                player.decreaseRelationLevel(1);
                ui.updatePlayerDetails();
                eventCounter++;
                nextEvent();
            	
            }
        });

        ui.addButton2ListenerStory1(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	JOptionPane.showMessageDialog(ui, "You just rejected the daughter of college's board director and now you are expelled and he made sure that you fail in your life\n TIPS == Remember always be kind to other", "Bad News", JOptionPane.ERROR_MESSAGE);
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
    	ui.transitionToLastYearScenario();
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
