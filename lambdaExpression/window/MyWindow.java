package corejava.lambdaExpression.window;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MyWindow {
	public static void main(String[] args) {

		JFrame jframe = new JFrame("My Window"); // JFrame Pre-Defined Class of javax.swing Package

		jframe.setSize(450, 450);
		jframe.setLayout(new FlowLayout());

		JButton jbutton = new JButton("Click Here !");
		jframe.add(jbutton);

//			/* Without Lambda Expression */
//		ActionListener - Interface  >>> java.awt Package  
//		jbutton.addActionListener(new ActionListener() // Here We Use Anonymous Class
//		{
//			@Override
//			public void actionPerformed(ActionEvent e) // ActionEvent is Pre-defined Class Of java.awt Package
//			{
//				System.out.println("Button Clicked");
//				JOptionPane.showMessageDialog(null, "Hey, You Clicked Button");
//			}
//			
//		});
		
			/* With Lambda Expression */
		jbutton.addActionListener(e -> {

			System.out.println("Button Clicked");
			JOptionPane.showMessageDialog(null, "Hey, You Clicked Button");

		});
		
		// Here, MouseMotionListener is not Functional Interface ThereFore, Lambda Expression not Support ... 
		//  We Have To Create Anonymous Class 
		jbutton.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseDragged(MouseEvent e) {
				
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				
			}
			
		});
		
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // it is Use For Default Close
		jframe.setVisible(true);
	}
}
