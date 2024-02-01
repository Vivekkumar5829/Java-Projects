package Clock;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.*;

public class MyFrame extends JFrame {
//	Calendar calender;
	SimpleDateFormat timeformat;
	JLabel timeLabel;
	String time;
	
	JLabel dayLabel;
	String day;
	SimpleDateFormat dayformat;
	
	JLabel dateLabel;
	String date;
	SimpleDateFormat dateformat;
	
	MyFrame(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("CLOCK");
		this.setSize(new Dimension(350,200));
		this.setLayout(new FlowLayout());
//		this.setResizable(false);
		timeformat = new SimpleDateFormat("hh:mm:ss a");
		timeLabel = new JLabel();
		timeLabel.setFont(new Font("Vendana", Font.PLAIN,50));
		timeLabel.setForeground(Color.green);
		timeLabel.setBackground(Color.black);
		timeLabel.setOpaque(true);
//		time = timeformat.format(Calendar.getInstance().getTime());
		
		dayformat = new SimpleDateFormat("EEEE");
		dayLabel = new JLabel();
		dayLabel.setFont(new Font("Ink Free", Font.PLAIN,35));
//		timeLabel.setText(time);
		
		dateformat = new SimpleDateFormat("MMMMM dd, yyyy");
		dateLabel = new JLabel();
		dateLabel.setFont(new Font("Ink Free", Font.PLAIN,35));
//		dateLabel.setText(date);
		
		
		
		this.add(timeLabel);
		this.add(dayLabel);
		this.add(dateLabel);
		this.setVisible(true);
		setTime();
		
	}
	
	public void setTime() {
		while(true) {
		time = timeformat.format(Calendar.getInstance().getTime());
		timeLabel.setText(time);
		
		day = dayformat.format(Calendar.getInstance().getTime());
		dayLabel.setText(day);
		
		date = dateformat.format(Calendar.getInstance().getTime());
		dateLabel.setText(date);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}
	
}
