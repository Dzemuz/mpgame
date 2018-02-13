package com.mpgame.main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class Frame {

	public JFrame frame;
	public JTextField chatTextField;
	public JPanel gameView;
	public JTextArea chatTextArea;
	public JTextArea connectionTextArea;
	public JButton connectButton;


	/**
	 * Create the application.
	 */
	public Frame() {
		initialize();
		initEvents();
		initPlayerEvents();
	}
	
	private void initEvents() {
		connectButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent mouse) {
				//Game_Main.player.connection.connect();
				//Game_Main.player.connection.goOnline();
			}
		});
	
		chatTextField.addKeyListener(new KeyAdapter(){
			@Override
			public void keyPressed(KeyEvent key) {
				if(key.getKeyCode() == KeyEvent.VK_ENTER) {
					String message = chatTextField.getText();
					chatTextArea.append(Game_Main.player.username +": "+ message + "\n");
					//Game_Main.player.conncetion.echoChat(message);
					chatTextField.setText("");
				}
				
			}
		});
		gameView.addMouseListener(new MouseAdapter(){
					
			@Override
			public void mouseClicked(MouseEvent mouse){
				
				gameView.requestFocus();
				
			}
					
		});
		gameView.addFocusListener(new FocusListener(){

			@Override
			public void focusGained(FocusEvent arg0) {
				
				
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				
				Game_Main.player.stop();
				
			}
			
	});
	}
	private void initPlayerEvents() {
		gameView.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent key) {
				Game_Main.player.keyPressed(key);
			}
			@Override
			public void keyReleased(KeyEvent key) {
				Game_Main.player.keyReleased(key);
			}
		});
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 940, 760);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		gameView = new GameView();
		gameView.setBounds(10, 10, 700, 700);
		frame.getContentPane().add(gameView);
		
		chatTextField = new JTextField();
		chatTextField.setBounds(720, 678, 182, 20);
		frame.getContentPane().add(chatTextField);
		chatTextField.setColumns(10);
		
		chatTextArea = new JTextArea();
		JScrollPane chatScrollPane = new JScrollPane(chatTextArea);
		chatScrollPane.setBounds(720, 335, 182, 332);
		frame.getContentPane().add(chatScrollPane);
		
		connectionTextArea = new JTextArea();
		JScrollPane connectionScrollPane = new JScrollPane(connectionTextArea);
		connectionScrollPane.setBounds(720, 53, 182, 273);
		frame.getContentPane().add(connectionScrollPane);
		
		connectButton = new JButton("GO online!");
		connectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		connectButton.setBounds(720, 19, 182, 23);
		frame.getContentPane().add(connectButton);
	}
}
