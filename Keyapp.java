import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JSlider;

//hello
public class Keyapp extends JFrame implements KeyListener{
	Container c;
	JTextField txt;
	
	public Keyapp(){
		super ("Key Listener Example");
		c = getContentPane();
		getContentPane().setLayout(null);
		
		JSlider slider = new JSlider();
		slider.setBounds(114, 193, 200, 26);
		getContentPane().add(slider);
		
		txt = new JTextField(12);
		txt.setBounds(59, 11, 314, 20);
		
		c.add(txt);		
		txt.addKeyListener(this);
		
	}
	public static void main(String[] args) {
		Keyapp app = new Keyapp();
		app.setSize(300, 200);
		app.setVisible(true);
		app.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	@Override
	public void keyPressed(KeyEvent e) {
		JOptionPane.showMessageDialog(this, e.getKeyCode());
	}
	@Override
	public void keyReleased(KeyEvent e) {
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

}
