package Game;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class frame2 extends JFrame implements ScenarioTransition {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel lblName;
    private JLabel lblSkillSymbol;
    private JLabel lblMotivationSymbol;
    private JPanel panel;
    private JLabel lblNameSymbol_4;
    private JLabel lblCharacter;
    private JLabel lblMoneySymbol;
    private JLabel lblMoney;
    private JLabel lblSkill;
    private JLabel lblMotivation;
    private JLabel lblRelationship;
    private JButton btnChoice1;
    private JButton btnChoice2;
    private JButton btnChoice3;
    private JLabel lblPicture;
    private JPanel panel_1;
    private JTextArea lbTheText;
    private Player player;
    private JMenuBar menuBar;
    private JMenu mntmFile;
    private JMenuItem mntmLoad;
    private JMenuItem mntmSave;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                frame2 frame = new frame2();
                frame.setVisible(true);
                frame.setTitle("Programmers Reality");
               
             
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public frame2() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 706, 816);
        
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        mntmFile = new JMenu("File");
        menuBar.add(mntmFile);
        
        mntmLoad = new JMenuItem("Load");
        mntmFile.add(mntmLoad);
        
        mntmSave = new JMenuItem("Save");
        mntmFile.add(mntmSave);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        panel = new JPanel();
        panel.setBounds(10, 20, 289, 118);
        panel.setBackground(new Color(192, 192, 192));
        contentPane.add(panel);
        panel.setLayout(null);
        panel.setVisible(false);

        lblSkillSymbol = new JLabel("Skill ");
        lblSkillSymbol.setBounds(7, 41, 34, 19);
        panel.add(lblSkillSymbol);
        lblSkillSymbol.setFont(new Font("Tahoma", Font.BOLD, 13));

        lblMotivationSymbol = new JLabel("Motivation ");
        lblMotivationSymbol.setBounds(7, 71, 78, 19);
        panel.add(lblMotivationSymbol);
        lblMotivationSymbol.setFont(new Font("Tahoma", Font.BOLD, 13));

        lblNameSymbol_4 = new JLabel("Relationship");
        lblNameSymbol_4.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNameSymbol_4.setBounds(7, 97, 92, 19);
        panel.add(lblNameSymbol_4);

        lblMoneySymbol = new JLabel("Money ");
        lblMoneySymbol.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblMoneySymbol.setBounds(7, 11, 52, 19);
        panel.add(lblMoneySymbol);

        lblMoney = new JLabel("0");
        lblMoney.setHorizontalAlignment(SwingConstants.CENTER);
        lblMoney.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblMoney.setBounds(198, 14, 69, 19);
        panel.add(lblMoney);

        lblSkill = new JLabel("0");
        lblSkill.setHorizontalAlignment(SwingConstants.CENTER);
        lblSkill.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblSkill.setBounds(198, 44, 69, 19);
        panel.add(lblSkill);

        lblMotivation = new JLabel("0");
        lblMotivation.setHorizontalAlignment(SwingConstants.CENTER);
        lblMotivation.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblMotivation.setBounds(198, 71, 69, 19);
        panel.add(lblMotivation);

        lblRelationship = new JLabel("0");
        lblRelationship.setHorizontalAlignment(SwingConstants.CENTER);
        lblRelationship.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblRelationship.setBounds(198, 100, 69, 19);
        panel.add(lblRelationship);

        lblCharacter = new JLabel("");
        lblCharacter.setBounds(567, 11, 111, 110);
        contentPane.add(lblCharacter);
        lblCharacter.setVisible(false);

        lblName = new JLabel("");
        lblName.setHorizontalAlignment(SwingConstants.CENTER);
        lblName.setBounds(567, 118, 111, 19);
        contentPane.add(lblName);
        lblName.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblName.setVisible(false);

        btnChoice1 = new JButton("New button");
        btnChoice1.setBounds(10, 570, 668, 36);
        contentPane.add(btnChoice1);
        btnChoice1.setVisible(false);

        btnChoice2 = new JButton("New button");
        btnChoice2.setBounds(10, 614, 668, 36);
        contentPane.add(btnChoice2);
        btnChoice2.setVisible(false);

        btnChoice3 = new JButton("New button");
        btnChoice3.setBounds(10, 661, 668, 36);
        contentPane.add(btnChoice3);
        btnChoice3.setVisible(false);

        lblPicture = new JLabel("");
        lblPicture.setBounds(10, 149, 670, 289);
        contentPane.add(lblPicture);
        lblPicture.setVisible(false);

        panel_1 = new JPanel();
        panel_1.setBackground(new Color(192, 192, 192));
        panel_1.setBounds(10, 449, 670, 110);
        contentPane.add(panel_1);
        panel_1.setVisible(false);
        panel_1.setLayout(null);

        lbTheText = new JTextArea("");
        lbTheText.setEditable(false);
        lbTheText.setBounds(10, 5, 650, 94);
        panel_1.add(lbTheText);

        showUserInputDialog();
        lblPicture.setIcon(new ImageIcon(frame2.class.getResource("/assets/Hibbing_High_School_2014 (1).jpg")));
        transitionToHighschoolScenario();
        mntmLoad.addActionListener(e -> loadGameState());
        mntmSave.addActionListener(e -> saveGameState());
        
        
    }

    private void showUserInputDialog() {
        JOptionPane.showMessageDialog(this, "This game is a multiple choice game where you choose the choices and each choice has consequences that lead to changes in your future.", "Disclaimer", JOptionPane.PLAIN_MESSAGE);
        try
        {
        	String name = JOptionPane.showInputDialog(this, "Enter your name:");
            if (name == null || name.trim().isEmpty()) {
            	throw new invalidInput();
   
            }else
            {
            	Object[] options = {"Male", "Female"};
                int gender = JOptionPane.showOptionDialog(this, "Select your gender:", "Gender", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

                if (gender == JOptionPane.CLOSED_OPTION) {
                    System.exit(0);  // Exit if no gender is selected
                }

                player = new Player();
                lblName.setText(name);
                player.setName(name);
                if (gender == 0) {
                    lblCharacter.setIcon(new ImageIcon(frame2.class.getResource("/assets/ezgif-5-79ebdb8fef.jpg")));
                    player.setGender("Male");
                } else {
                    lblCharacter.setIcon(new ImageIcon(frame2.class.getResource("/assets/ezgif-5-64b6fb10cf.jpg")));
                    player.setGender("Female");
                }
                updatePlayerDetails();
                showGameComponents();
            }
        }catch(invalidInput exception)
        {
        	JOptionPane.showMessageDialog(this, "Please enter a valid input!", "Error :(", JOptionPane.WARNING_MESSAGE);
        	showUserInputDialog();
        }
    }

    public Player getPlayer() {
        return player;
    }

    public void updatePlayerDetails() {
        lblMoney.setText(String.valueOf(player.getMoney()));
        lblSkill.setText(String.valueOf(player.getSkillLevel()));
        lblMotivation.setText(String.valueOf(player.getMotivation()));
        lblRelationship.setText(String.valueOf(player.getRelationLevel()));
        lblName.setText(player.getName());
        if ("Male".equals(player.getGender())) {
            lblCharacter.setIcon(new ImageIcon(frame2.class.getResource("/assets/ezgif-5-79ebdb8fef.jpg")));
        } else {
            lblCharacter.setIcon(new ImageIcon(frame2.class.getResource("/assets/ezgif-5-64b6fb10cf.jpg")));
        }
    }

    void showGameComponents() {
        panel.setVisible(true);
        lblCharacter.setVisible(true);
        lblName.setVisible(true);
        lblPicture.setVisible(true);
        btnChoice1.setVisible(true);
        btnChoice2.setVisible(true);
        btnChoice3.setVisible(true);
        panel_1.setVisible(true);
    }

    public void setStory1(String text) {
        lbTheText.setText(text);
        lbTheText.setFont(new Font("Tahoma", Font.BOLD, 13));
        
    }

    public void setButton1Story1(String text) {
        btnChoice1.setText(text);
    }

    public void setButton2Story1(String text) {
        btnChoice2.setText(text);
    }

    public void setButton3Story1(String text) {
        btnChoice3.setText(text);
    }

    public void addButton1ListenerStory1(ActionListener listener) {
        for (ActionListener al : btnChoice1.getActionListeners()) {
            btnChoice1.removeActionListener(al);
        }
        btnChoice1.addActionListener(listener);
    }

    public void addButton2ListenerStory1(ActionListener listener) {
        for (ActionListener al : btnChoice2.getActionListeners()) {
            btnChoice2.removeActionListener(al);
        }
        btnChoice2.addActionListener(listener);
    }

    public void addButton3ListenerStory1(ActionListener listener) {
        for (ActionListener al : btnChoice3.getActionListeners()) {
            btnChoice3.removeActionListener(al);
        }
        btnChoice3.addActionListener(listener);
    }

    public void transitionToHighschoolScenario() {
        HighschoolScenario highschool = new HighschoolScenario(this);
        player.setCurrentScenario("Highschool");
        highschool.initializeScenario();
    }

    public void transitionToGraduationScenario() {
    	player.setCurrentScenario("Graduation");
        clearContent();
        lblPicture.setIcon(new ImageIcon(frame2.class.getResource("/assets/ezgif-1-818ed15b7e.png")));
        GraduationScenario graduation = new GraduationScenario(this);
        graduation.initializeScenarios();
    }

    public void transitionToOrientationScenario() {
    	player.setCurrentScenario("Orientation");
        clearContent();
        lblPicture.setIcon(new ImageIcon(frame2.class.getResource("/assets/Orientation (1).png")));
        OrientationScenario orientation = new OrientationScenario(this);
        orientation.initializeScenario();
    }

    public void transitionToFirstYearScenario() {
    	player.setCurrentScenario("FirstYear");
        clearContent();
        lblPicture.setIcon(new ImageIcon(frame2.class.getResource("/assets/firstyear (1).jpeg")));
        FirstYearScenario first = new FirstYearScenario(this);
        first.initializeScenario();
    }

    public void transitionToSecondYearScenario() {
    	player.setCurrentScenario("SecondYear");
        clearContent();
        lblPicture.setIcon(new ImageIcon(frame2.class.getResource("/assets/secondyear (1).jpg")));
        SecondYearScenario second = new SecondYearScenario(this);
        second.initializeScenario();
    }

    public void transitionToThirdYearScenario() {
    	player.setCurrentScenario("ThirdYear");
        clearContent();
        lblPicture.setIcon(new ImageIcon(frame2.class.getResource("/assets/thirdyear (1).jpeg")));
        ThirdYearScenario third = new ThirdYearScenario(this);
        third.initializeScenario();
    }

    public void transitionToLastYearScenario() {
    	player.setCurrentScenario("LastYear");
        clearContent();
        lblPicture.setIcon(new ImageIcon(frame2.class.getResource("/assets/lastyear (1).jpg")));
        LastYearScenario last = new LastYearScenario(this);
        last.initializeScenario();
    }

    public void transitionToInternScenario() {
    	player.setCurrentScenario("Intern");
        clearContent();
        lblPicture.setIcon(new ImageIcon(frame2.class.getResource("/assets/intern (1).jpg")));
        InternScenario intern = new InternScenario(this);
        intern.initializeScenario();
    }

    public void transitionToGraduationUniversityScenario() {
    	player.setCurrentScenario("GraduationUniversity");
        clearContent();
        lblPicture.setIcon(new ImageIcon(frame2.class.getResource("/assets/graduni (1).jpg")));
        GraduationUniversityScenario graduationUni = new GraduationUniversityScenario(this);
        graduationUni.initializeScenario();
    }

    public void transitionToFindingJobsScenario() {
    	player.setCurrentScenario("FindingJobs");
        clearContent();
        lblPicture.setIcon(new ImageIcon(frame2.class.getResource("/assets/findjob (1).jpg")));
        FindingJobsScenario findingJobs = new FindingJobsScenario(this);
        findingJobs.initializeScenario();
    }

    private void clearContent() {
        lbTheText.setText("");
        lblPicture.setIcon(null);
        for (ActionListener al : btnChoice1.getActionListeners()) {
            btnChoice1.removeActionListener(al);
        }
        for (ActionListener al : btnChoice2.getActionListeners()) {
            btnChoice2.removeActionListener(al);
        }
        for (ActionListener al : btnChoice3.getActionListeners()) {
            btnChoice3.removeActionListener(al);
        }
    }

    public AbstractButton getBtnChoice1() {
        return btnChoice1;
    }

    public AbstractButton getBtnChoice2() {
        return btnChoice2;
    }

    public AbstractButton getBtnChoice3() {
        return btnChoice3;
    }
    private void saveGameState() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Save Game State");

        // Set file filter (optional)
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Saved Game Files (*.sav)", "sav");
        fileChooser.setFileFilter(filter);

        int userSelection = fileChooser.showSaveDialog(this);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            String savePath = fileToSave.getAbsolutePath();

            // Ensure the file ends with .sav extension
            if (!savePath.toLowerCase().endsWith(".sav")) {
                savePath += ".sav";
            }

            try {
                GameFileHandler.saveGame(player, savePath);
                JOptionPane.showMessageDialog(this, "Game saved successfully.", "Save", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error saving game: " + e.getMessage(), "Save Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }




    private void loadGameState() {
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try {
                player = GameFileHandler.loadGame(selectedFile.getAbsolutePath());
                updatePlayerDetails();
                JOptionPane.showMessageDialog(this, "Game loaded successfully.", "Load", JOptionPane.INFORMATION_MESSAGE);
                
                // Resume the saved scenario
                switch (player.getCurrentScenario()) {
                    case "Highschool":
                        transitionToHighschoolScenario();
                        break;
                    case "Graduation":
                        transitionToGraduationScenario();
                        break;
                    case "Orientation":
                        transitionToOrientationScenario();
                        break;
                    case "FirstYear":
                        transitionToFirstYearScenario();
                        break;
                    case "SecondYear":
                        transitionToSecondYearScenario();
                        break;
                    case "ThirdYear":
                        transitionToThirdYearScenario();
                        break;
                    case "LastYear":
                        transitionToLastYearScenario();
                        break;
                    case "Intern":
                        transitionToInternScenario();
                        break;
                    case "FindingJobs":
                        transitionToFindingJobsScenario();
                        break;
                    default:
                        JOptionPane.showMessageDialog(this, "Unknown scenario. Starting from Highschool.", "Load Error", JOptionPane.WARNING_MESSAGE);
                        transitionToHighschoolScenario();
                        break;
                }
            } catch (IOException | ClassNotFoundException e) {
                JOptionPane.showMessageDialog(this, "Error loading game: " + e.getMessage(), "Load Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

}
