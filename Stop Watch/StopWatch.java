package stopWatch;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

import javax.swing.*;

public class StopWatch implements ActionListener {
	
	JFrame frame = new JFrame();
	JButton startButton = new JButton("START");
	JButton resetButton = new JButton("RESET"); 
	JLabel timeLabel = new JLabel();
	int elasedTime = 0;
	int seconds = 0;
	int minutes = 0;
	int hours = 0;
	boolean started = false;
	String seconds_string = String.format("%02d", seconds);
	String minutes_string = String.format("%02d", minutes);
	String hours_string = String.format("%02d", hours);
	
	Timer timer = new Timer(1000,new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			elasedTime += 1000;
			hours = (elasedTime / 3600000);
			minutes = (elasedTime / 60000) % 60;
			seconds = (elasedTime / 1000) % 60;
			
			
			 seconds_string = String.format("%02d", seconds);
			 minutes_string = String.format("%02d", minutes);
			hours_string = String.format("%02d", hours);
			
			timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string);
			
		}
	});
	
	
	StopWatch(){
		
		
		timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string);
		timeLabel.setBounds(100,100,200,100);
		timeLabel.setFont(new Font("Verdana",Font.PLAIN,35));
		timeLabel.setBorder(BorderFactory.createBevelBorder(1));
		timeLabel.setBackground(Color.black);
		timeLabel.setForeground(Color.green);
		timeLabel.setOpaque(true);
		timeLabel.setHorizontalAlignment(JTextField.CENTER);
		
		startButton.setBounds(100,200,100,50);
		startButton.setFont(new Font("Ink Free",Font.PLAIN,20));
		startButton.setFocusable(false);
		startButton.setBackground(Color.black);
		startButton.setForeground(Color.green);
		startButton.setOpaque(true);
		startButton.addActionListener(this);
		
		
		resetButton.setBounds(200,200,100,50);
		resetButton.setFont(new Font("Ink Free",Font.PLAIN,20));
		resetButton.setFocusable(false);
		resetButton.setBackground(Color.black);
		resetButton.setForeground(Color.green);
		resetButton.setOpaque(true);
		resetButton.addActionListener(this);
		
		
		
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,420);
		frame.add(startButton);
		frame.add(resetButton);
		frame.add(timeLabel);
		frame.setLayout(null);
		frame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == startButton) {
			
			if(started == false) {
				started = true;
				startButton.setText("STOP");
				start();
			}else {
				started = false;
				startButton.setText("START");
				stop();
			}
		}
		
		if(e.getSource() == resetButton) {
			started = false;
			startButton.setText("START");
			reset();
		}
	}
	void start() {
		timer.start();
	}
	
	void reset() {
		timer.stop();
		elasedTime = 0;
		seconds = 0;
		minutes = 0;
		hours = 0;
		
		 seconds_string = String.format("%02d", seconds);
		 minutes_string = String.format("%02d", minutes);
		hours_string = String.format("%02d", hours);
		
		timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string);
	}
	
	void stop() {
		timer.stop();
	}

}
