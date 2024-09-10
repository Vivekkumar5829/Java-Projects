package digital_Clock;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.*;

public class Digital_Clock extends JFrame {

	private JLabel timeLabel;
	private JLabel dateLabel;
	
	public Digital_Clock() {
		
	
		
		JFrame frame = new JFrame("Digital Clock");
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		
		
		timeLabel = new JLabel();
		timeLabel.setSize(50,50);
		timeLabel.setFont(new Font("Arial", Font.PLAIN, 80));
		timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		timeLabel.setVerticalAlignment(SwingConstants.CENTER);
		timeLabel.setForeground(Color.RED);
//		timeLabel.setText("Time");
		
		dateLabel = new JLabel();
		dateLabel.setSize(50,50);
		dateLabel.setFont(new Font("Arial", Font.PLAIN,30));
		dateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dateLabel.setVerticalAlignment(SwingConstants.CENTER);
		dateLabel.setForeground(Color.red);
//		dateLabel.setText("Date");
		
		
		
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.black);
		panel.setBounds(0,180,500,100);
		panel.setLayout(new BorderLayout());
		panel.add(timeLabel, BorderLayout.CENTER);
		panel.add(dateLabel, BorderLayout.SOUTH);
		
		
		
		
		
		
		frame.add(panel);
		frame.setVisible(true);
		
		Timer timer = new Timer(1000, new ActionListener(){
			
		

			@Override
			public void actionPerformed(ActionEvent e) {
				
				update();
				
			}
			
		});
		
		timer.start();
		
	}

	private void update() {
		Calendar calendar = Calendar.getInstance();
		
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
		SimpleDateFormat dateFormat = new SimpleDateFormat("EEE,dd MMM, yyyy");
		
		String time = timeFormat.format(calendar.getTime());
		String date = dateFormat.format(calendar.getTime());
		
		
		timeLabel.setText(time);
		dateLabel.setText(date);
		
	}

	
	
	
}
