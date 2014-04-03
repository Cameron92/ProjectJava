import javax.swing.*;

import java.awt.event.KeyListener;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.TitledBorder;
public class finalLibrary extends JFrame {
	public finalLibrary() {
		getContentPane().setLayout(null);
		
		txtTitle = new JTextField();
		txtTitle.setBounds(46, 29, 146, 20);
		getContentPane().add(txtTitle);
		txtTitle.setColumns(10);
		
		JLabel lblTitle = new JLabel("Book Title");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTitle.setBounds(36, 11, 72, 14);
		getContentPane().add(lblTitle);
		
		JLabel lblaName = new JLabel("Author Name");
		lblaName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblaName.setBounds(36, 60, 89, 14);
		getContentPane().add(lblaName);
		
		txtaName = new JTextField();
		txtaName.setBounds(46, 85, 146, 20);
		getContentPane().add(txtaName);
		txtaName.setColumns(10);
		
		JLabel lblIsbnNumber = new JLabel("ISBN Number");
		lblIsbnNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIsbnNumber.setBounds(36, 116, 86, 14);
		getContentPane().add(lblIsbnNumber);
		
		txtISBN = new JTextField();
		txtISBN .setBounds(46, 143, 146, 20);
		getContentPane().add(txtISBN );
		txtISBN .setColumns(10);
		
		JLabel lblDate = new JLabel("Date Added yyyy/mm/dd");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDate.setBounds(36, 174, 177, 20);
		getContentPane().add(lblDate);
		
		txtDate = new JTextField();
		txtDate.setBounds(46, 199, 146, 20);
		getContentPane().add(txtDate);
		txtDate.setColumns(10);
		
		JPanel genreP = new JPanel();
		genreP.setBounds(239, 29, 158, 194);
		genreP.setBorder(new TitledBorder(null, "Genre's", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(genreP);
		genreP.setLayout(null);
		
		JCheckBox chkSci = new JCheckBox("Sci - Fi");
		chkSci.setBounds(23, 22, 97, 23);
		genreP.add(chkSci);
		
		JCheckBox chkFant = new JCheckBox("Fantasy");
		chkFant.setBounds(23, 48, 97, 23);
		genreP.add(chkFant);
		
		JCheckBox chkRomance = new JCheckBox("Romance");
		chkRomance.setBounds(23, 74, 97, 23);
		genreP.add(chkRomance);
		
		JCheckBox chkAction = new JCheckBox("Action");
		chkAction.setBounds(23, 100, 97, 23);
		genreP.add(chkAction);
		
		JCheckBox chkThriller = new JCheckBox("Thriller");
		chkThriller.setBounds(23, 126, 97, 23);
		genreP.add(chkThriller);
		
		JCheckBox chkHorror = new JCheckBox("Horror");
		chkHorror.setBounds(23, 152, 97, 23);
		genreP.add(chkHorror);
		
		JSlider sRating = new JSlider();
		sRating.setBounds(118, 280, 200, 26);
		getContentPane().add(sRating);
		
		JLabel lbl1 = new JLabel("1");
		lbl1.setBounds(118, 257, 7, 14);
		getContentPane().add(lbl1);
		
		JLabel lbl10 = new JLabel("10");
		lbl10.setBounds(301, 257, 17, 14);
		getContentPane().add(lbl10);
		
		JLabel lbl5 = new JLabel("5");
		lbl5.setBounds(214, 257, 7, 14);
		getContentPane().add(lbl5);
		
		JButton btnSave = new JButton("Save Book");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSave.setBounds(164, 317, 110, 23);
		getContentPane().add(btnSave);
		
		JLabel lblRating = new JLabel("Rate the book");
		lblRating.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRating.setBounds(118, 226, 95, 20);
		getContentPane().add(lblRating);
	}
	Container c;
	JLabel lblTitle, lblaName, lblISBN, lblDate,lbl1,lbl5,lbl10;
	JTextField txtTitle, txtaName, txtISBN, txtDate;
	JButton btnSave;
	JSlider sRating;
	JCheckBox chkSci, chkFant, chkRomance, chkAction, chkThriller, chkHorror;
	
	public static void main(String[] args) {
		finalLibrary app = new finalLibrary();
		app.setSize(450,400);
		app.setVisible(true);
		app.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		

	}
}
