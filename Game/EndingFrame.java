package Game;


import javax.swing.*;
import java.awt.Color;
import java.awt.Font;


public class EndingFrame extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Player player;
	private JPanel panel;
	private JLabel lblResult;
	private JTextArea textAreaResult;

    public EndingFrame(Player player) {
        this.player = player;
        initialize();
    }

    private void initialize() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 667, 531);
        getContentPane().setLayout(null);
        setTitle("Final Result");

        JLabel lblName = new JLabel("Player Name: "+ player.getName());
        lblName.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblName.setBounds(50, 30, 541, 20);
        getContentPane().add(lblName);

        JLabel lblMoney = new JLabel("Money: " + player.getMoney());
        lblMoney.setBounds(50, 60, 541, 20);
        lblMoney.setFont(new Font("Tahoma", Font.BOLD, 13));
        getContentPane().add(lblMoney);

        JLabel lblSkill = new JLabel("Skill Level: " + player.getSkillLevel());
        lblSkill.setBounds(50, 90, 541, 20);
        lblSkill.setFont(new Font("Tahoma", Font.BOLD, 13));
        getContentPane().add(lblSkill);

        JLabel lblMotivation = new JLabel("Motivation: " + player.getMotivation());
        lblMotivation.setBounds(50, 120, 541, 20);
        lblMotivation.setFont(new Font("Tahoma", Font.BOLD, 13));
        getContentPane().add(lblMotivation);

        JLabel lblRelation = new JLabel("Relationship Level: " + player.getRelationLevel());
        lblRelation.setBounds(50, 150, 541, 20);
        lblRelation.setFont(new Font("Tahoma", Font.BOLD, 13));
        getContentPane().add(lblRelation);
        
        panel = new JPanel();
        panel.setBackground(new Color(128, 128, 128));
        panel.setBounds(30, 30, 589, 146);
        getContentPane().add(panel);
        
        lblResult = new JLabel("Get Your Result");
        lblResult.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblResult.setHorizontalAlignment(SwingConstants.CENTER);
        lblResult.setBounds(30, 0, 589, 28);
        getContentPane().add(lblResult);
        
        textAreaResult = new JTextArea();
        textAreaResult.setBounds(60, 186, 541, 128);
        getContentPane().add(textAreaResult);
        
        if (player.getRelationLevel() < 5 && player.getMotivation() < 5 && player.getMoney() > 200 && player.getSkillLevel() < 5)
        {
        	textAreaResult.setText("You earned bad ending !! \n you had lots of money but lack of skills,motivation and relationship \n you tried to work but you can stay for a long time and you tried to do business on your own but you failed because no one is helping you!");
        }else if(player.getRelationLevel() < 5 && player.getMotivation() < 5 && player.getMoney() < 100 && player.getSkillLevel() < 5)
        {
        	textAreaResult.setText("You earned bad ending !! \n you got no money, lack of skills,motivation and relationship with others\n you tried to apply for work but every company rejected you\n you became useless and you just work as part time in a restaurant");
        }else if(player.getRelationLevel() >= 5 && player.getMotivation() < 5  && player.getMoney() < 100 && player.getSkillLevel() < 5)
        {
        	textAreaResult.setText("You earned just an okay ending !! \n you got no money, lack of skills and motivation but you got good relationship with others \nu barely managed to earn job from a new startup company");
        }else if(player.getRelationLevel() < 5 && player.getMotivation() < 5  && player.getMoney() < 100 && player.getSkillLevel() > 5)
        {
        	textAreaResult.setText("You earned barely an okay ending !! \n you got no money, motivation and no good relationship with others but you got the skills, \nU barely managed to earn a part time job by doing coding for the students");
        }else if(player.getRelationLevel() < 10 && player.getMotivation() > 5  && player.getMoney() > 100 && player.getSkillLevel() < 5)
        {
        	textAreaResult.setText("You earned barely an okay ending !! \n you got money, motivation and you got the skills but you dont have good relationship with others, \nU barely managed to earn a after a few tries applying for jobs");
        }else if(player.getRelationLevel() > 5 && player.getMotivation() > 5  && player.getMoney() > 100 && player.getSkillLevel() > 5)
        {
        	textAreaResult.setText("You earned A good ending !! \n you got  money, motivation,good relationship with others and you got the skills, \neveryone wanted you to work with you and you also became a successfull businessman");
        }
        
    }
}


