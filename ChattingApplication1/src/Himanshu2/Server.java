package Himanshu2;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.text.*;
import java.net.*;
import java.io.*;
public class Server implements ActionListener {
	
	JButton send;
	JTextField text;
	JPanel a1;
	 static Box vertical= Box.createVerticalBox();
	 static JFrame f=new JFrame();
	 static DataOutputStream dout;
	 JComboBox ab;
	
	Server(){
		
		
		
		f.setLayout(null);
		
		JPanel p1=new JPanel();
		p1.setBackground(new Color(7,94,84));
		p1.setBounds(0,0,450,70);
		p1.setLayout(null);
		f.add(p1);
		
		ImageIcon i1=new ImageIcon(("Images/3.png"));
		Image i2=i1.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel back=new JLabel(i3);
		back.setBounds(5,20,25,25);
		p1.add(back);
		back.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent ae) {
				System.exit(0);
			}
		});
		
		ImageIcon i4=new ImageIcon(("Images/1.png"));
		Image i5=i4.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
		ImageIcon i6=new ImageIcon(i5);
		JLabel next=new JLabel(i6);
		next.setBounds(50,10,50,50);
		p1.add(next);
		
		ImageIcon i7=new ImageIcon(("Images/video.png"));
		Image i8=i7.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
		ImageIcon i9=new ImageIcon(i8);
		JLabel next1=new JLabel(i9);
		next1.setBounds(300,15,30,30);
		p1.add(next1);
		
		ImageIcon i10=new ImageIcon(("Images/phone.png"));
		Image i11=i10.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
		ImageIcon i12=new ImageIcon(i11);
		JLabel next2=new JLabel(i12);
		next2.setBounds(360,15,30,30);
		p1.add(next2);
		
		ImageIcon i13=new ImageIcon(("Images/3icon.png"));
		Image i14=i13.getImage().getScaledInstance(15, 30, Image.SCALE_DEFAULT);
		ImageIcon i15=new ImageIcon(i14);
		JLabel next3=new JLabel(i15);
		next3.setBounds(410,15,15,30);
		p1.add(next3);
		next3.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent ae) {
				
				new Other().setVisible(true);
			}
			
		});
		
		JLabel name=new JLabel("Himanshu");
		name.setFont(new Font("Serif",Font.BOLD,20));
		name.setBounds(115,15,100,18);
		name.setForeground(Color.WHITE);
		p1.add(name);
		
		JLabel name1=new JLabel("Active Now");
		name1.setFont(new Font("Serif",Font.BOLD,12));
		name1.setBounds(115,35,100,18);
		name1.setForeground(Color.WHITE);
		p1.add(name1);
		
	    text =new JTextField();
		text.setBounds(5,610,320,40);
		text.setFont(new Font("Serif",Font.BOLD,14));
		f.add(text);
		
		 send =new JButton("Send");
		send.setBackground(new Color(7,94,84));
		send.setFont(new Font("Serif",Font.BOLD,14));
		send.setForeground(Color.WHITE);
		send.setBounds(330,610,100,40);
		send.addActionListener(this);
		f.add(send);
		
		
		 a1=new JPanel();
		a1.setBounds(5,75,425,530);
		f.add(a1);
		
		
		f.setSize(450,700);
		f.setLocation(300,0);
//		setUndecorated(true);
		f.getContentPane().setBackground(Color.white);
		f.setVisible(true);
		
		
	}
	public void actionPerformed(ActionEvent ae) {
		
		try {
			String out =text.getText();
			a1.setLayout(new BorderLayout());
			
			
			JPanel p2=formatLabel(out);
			
			JPanel right= new JPanel(new BorderLayout());
			right.add(p2,BorderLayout.LINE_END);
			vertical.add(right);
			vertical.add(Box.createVerticalStrut(15));
			a1.add(vertical,BorderLayout.PAGE_START);
			dout.writeUTF(out);
			text.setText("");
			
			
			f.repaint();
			f.invalidate();
			f.validate();
		}catch(Exception e) {
			System.out.println(e);
		}
		 
		 
	}
	public static JPanel formatLabel(String out) {
		
		JPanel panel=new JPanel();
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		
		JLabel output=new JLabel(out);
		output.setFont(new Font("Tahoma",Font.PLAIN,16));
		output.setBackground(new Color(37,211,102));
		output.setOpaque(true);
		output.setBorder(new EmptyBorder(15,15,15,50));
		
		panel.add(output);
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat sdf=new SimpleDateFormat("HH:mm");
		
		JLabel time =new JLabel();
		time.setText(sdf.format(cal.getTime()));
		panel.add(time);
		
		return panel;
	}
	

	public static void main(String[] args) {
		new Server();
		
		try {
			
			ServerSocket skt=new ServerSocket(6001);
			while(true) {
				 Socket s =skt.accept();
				 DataInputStream din =new  DataInputStream(s.getInputStream()) ;
				 dout =new DataOutputStream(s.getOutputStream());
				 
				 while(true) {
					 String msg =din.readUTF();
					 JPanel panel =formatLabel(msg);
					 JPanel left =new JPanel(new BorderLayout());
					 left.add(panel,BorderLayout.LINE_START);
					 vertical.add(left);
					 f.validate();
				 }
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}

	}

}
