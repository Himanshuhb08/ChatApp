package Himanshu2;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
public class Other extends JFrame {
	Other(){
		
		
		setLayout(null);
		JLabel label = new JLabel("Delete");
		label.setBounds(40,30,100,30);
		label.setFont(new Font( "Serif",Font.BOLD,16));
		label.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent ae) {
				System.exit(0);
			}
		});
		add(label);
		JLabel label1 = new JLabel("Search");
		label1.setBounds(40,60,100,30);
		label1.setFont(new Font( "Serif",Font.BOLD,16));
		add(label1);
		JLabel label2 = new JLabel("Mute");
		label2.setBounds(40,90,100,30);
		label2.setFont(new Font( "Serif",Font.BOLD,16));
		add(label2);
		JLabel label3 = new JLabel("Setting");
		label3.setBounds(40,120,100,30);
		label3.setFont(new Font( "Serif",Font.BOLD,16));
		add(label3);
		setSize(100,200);
		setLocation(680,80);
		setUndecorated(true);
//		getContentPane().setBackground(Color.white);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		new Other();
	}

}
