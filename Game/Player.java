package Game;

import java.io.Serializable;

public class Player implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private String gender; // "Male" or "Female"
    private int money;
    private int skillLevel;
    private int motivation;
    private int relationLevel;
    private String currentScenario; // New field to store the current scenario

    public Player() {
        this.money = 0;
        this.skillLevel = 0;
        this.motivation = 0;
        this.relationLevel = 0;
        this.currentScenario = "Highschool"; // Default scenario
    }

    // Getters and setters for the new field
    public String getCurrentScenario() {
        return currentScenario;
    }

    public void setCurrentScenario(String currentScenario) {
        this.currentScenario = currentScenario;
    }

    // Existing getters and setters...



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getMoney() {
        return money;
    }

    public void increaseMoney(int amount) {
        money += amount;
    }

    public void decreaseMoney(int amount) {
        money -= amount;
    }

    public int getSkillLevel() {
        return skillLevel;
    }

    public void increaseSkillLevel(int amount) {
        skillLevel += amount;
    }

    public void decreaseSkillLevel(int amount) {
        skillLevel -= amount;
        if (skillLevel < 0) {
            skillLevel = 0;
        }
    }

    public int getMotivation() {
        return motivation;
    }

    public void increaseMotivation(int amount) {
        motivation += amount;
    }

    public void decreaseMotivation(int amount) {
        motivation -= amount;
        if (motivation < 0) {
            motivation = 0;
        }
    }

    public int getRelationLevel() {
        return relationLevel;
    }

    public void increaseRelationLevel(int amount) {
        relationLevel += amount;
    }

    public void decreaseRelationLevel(int amount) {
        relationLevel -= amount;
        if (relationLevel < 0) {
            relationLevel = 0;
        }
    }
}
