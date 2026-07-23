package Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HighschoolScenario {
    private frame2 ui;
    private Player player;
    private ScenarioTransition transition;
    private int eventCounter = 0;

    public HighschoolScenario(frame2 ui) {
        this.ui = ui;
        this.player = ui.getPlayer();
        this.transition = ui;
    }

    public void initializeScenario() {
        eventCounter = 0;
        nextEvent();
    }

    private void nextEvent() {
        switch (eventCounter) {
            case 0:
                ui.setStory1("It's your highschool days! \nYour teacher asked you if you are interested in joining her programming class\nRemember you will sacrifice your free evening time during highschool");
                ui.setButton1Story1("Join the class!");
                ui.setButton2Story1("Ignore your teacher and play football instead");
                ui.setButton3Story1("Refuse to learn with your teacher but learn it yourself");

                ui.addButton1ListenerStory1(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        player.increaseSkillLevel(1);
                        player.decreaseMotivation(1);
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
                        player.decreaseSkillLevel(1);
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
                        player.decreaseRelationLevel(1);
                        player.increaseMotivation(1);
                        ui.updatePlayerDetails();
                        eventCounter++;
                        nextEvent();
                    }
                });
                break;

            case 1:
                clearButtonListeners();
                ui.setStory1("During your last year in high school\nYour teacher asks you to join the Hackathon Competition\nWhat will you do?");
                ui.setButton1Story1("Join the competition with the teacher's guidance");
                ui.setButton2Story1("Join the competition but study alone");
                ui.setButton3Story1("Reject the opportunity");

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
                        player.decreaseRelationLevel(1);
                        player.increaseSkillLevel(1);
                        ui.updatePlayerDetails();
                        eventCounter++;
                        nextEvent();
                    }
                });

                ui.addButton3ListenerStory1(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        player.decreaseSkillLevel(1);
                        player.decreaseRelationLevel(1);
                        ui.updatePlayerDetails();
                        eventCounter++;
                        nextEvent();
                    }
                });
                break;

            // Add more cases for additional events if needed

            default:
                transition.transitionToGraduationScenario();
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
