package Game;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JPanel;

public class Main {

	private JFrame frame;
	private JLabel lblTitle;
	private JLabel lblSlogan;
	private JButton btnStart;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Programmers Reality");
		frame.setBounds(100, 100, 919, 780);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblSlogan = new JLabel("A short adventure text game.");
		lblSlogan.setHorizontalAlignment(SwingConstants.CENTER);
		lblSlogan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSlogan.setBounds(373, 190, 351, 25);
		frame.getContentPane().add(lblSlogan);
		
		btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame2 frame2 = new frame2();
				frame2.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnStart.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnStart.setBounds(341, 366, 242, 86);
		frame.getContentPane().add(btnStart);
		
		panel = new JPanel();
		panel.setBackground(new Color(0, 255, 0));
		panel.setBounds(107, 67, 655, 180);
		frame.getContentPane().add(panel);
				panel.setLayout(null);
				lblTitle = new JLabel("Programmers Reality");
				lblTitle.setBounds(29, 68, 599, 72);
				panel.add(lblTitle);
				lblTitle.setBackground(new Color(0, 255, 0));
				lblTitle.setFont(new Font("High Tower Text", Font.PLAIN, 61));
				lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
	}
}
