import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.util.*;
import java.util.List;
import java.util.regex.PatternSyntaxException;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class LibraryDatabase extends JFrame implements ActionListener{
	JTextField txtSearchBy;
	JLabel lblSearchBy;
	JComboBox<String> comboSearchBy, searchResults;
	JButton btnAddBook, btnModifyBook, btnListAll;
	JTextArea textAreaList;
	public LibraryDatabase() {
		setTitle("Library Database");
		getContentPane().setLayout(null);
		
		JLabel lblSearchBy = new JLabel("Search By: ");
		lblSearchBy.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSearchBy.setBounds(10, 11, 89, 14);
		getContentPane().add(lblSearchBy);
		
		JComboBox comboSearchBy = new JComboBox();
		comboSearchBy.setBounds(124, 10, 150, 20);
		getContentPane().add(comboSearchBy);
		comboSearchBy.addItem("Title");
		comboSearchBy.addItem("Author");
		comboSearchBy.addItem("ISBN");
		comboSearchBy.addItem("Date (In yyyy/mm/dd format");
		comboSearchBy.addItem("Rating Greater than");
		comboSearchBy.addItem("Rating Less than");
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(10, 67, 264, 23);
		getContentPane().add(btnSearch);
		
		final JTextField txtSearchBy = new JTextField();
		txtSearchBy.setText("Enter Search Value Here:");
		txtSearchBy.setBounds(10, 36, 264, 20);
		getContentPane().add(txtSearchBy);
		txtSearchBy.setColumns(10);
		
		JComboBox searchResults = new JComboBox();
		searchResults.setBounds(0, 101, 284, 20);
		getContentPane().add(searchResults);
		
		JButton btnAddBook = new JButton("Add Book");
		btnAddBook.setFont(new Font("Tahoma", Font.BOLD, 8));
		btnAddBook.setBounds(10, 327, 86, 23);
		btnAddBook.addActionListener(this);
		getContentPane().add(btnAddBook);
		
		JButton btnModifyBook = new JButton("Modify");
		btnModifyBook.setFont(new Font("Tahoma", Font.BOLD, 8));
		btnModifyBook.setBounds(94, 327, 94, 23);
		getContentPane().add(btnModifyBook);
		
		JButton btnListAll = new JButton("List ");
		btnListAll.setFont(new Font("Tahoma", Font.BOLD, 8));
		btnListAll.setBounds(185, 327, 89, 23);
		getContentPane().add(btnListAll);
		
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Scanner scanner = null;
				try {
					scanner = new Scanner(new File ("database.dat"));
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}	
					// Open the file database.dat as a buffered reader
					try {
						BufferedReader bf = new BufferedReader(new FileReader("database.dat"));
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
					
					// Start a line count and declare a string to hold our current line.
					int linecount = 0;
					String line;
					
					// Let the user know what we are searching for
					
					 // Loop through each line, storing the line into our line variable.
					 List<String> list=new ArrayList<>();
					 StringBuilder buffer = new StringBuilder();
					 while(scanner.hasNextLine()){
					     list.add(scanner.nextLine());
					     buffer.append(list);
				         buffer.append('\n');
					     String Buffer = buffer.toString(); 
				    	 String[] splitArray = Buffer.split("\\s+");
				    	 String search = txtSearchBy.getText();
				    	 //TODO: cant seem to figure out why only 3 values are being found at the moment instead of 4
					    	 for(int i = 0; i < splitArray.length; i++) {
					    		 if(search.equals(splitArray[i])){
							         System.out.println(buffer);
					    		 }
					    	 }
					 }
			}});
		
	}

	public static void main(String[] args) {
		LibraryDatabase app = new LibraryDatabase();
		app.setSize(300,400);
		app.setVisible(true);
		app.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	class ChildWindowAdd extends JFrame implements ActionListener {
		LibraryDatabase parent;
		Container c;
		JLabel lblTitle, lblaName, lblISBN, lblDate,lbl1,lbl5,lbl10;
		JTextField txtTitle, txtaName, txtISBN, txtDate;
		JButton btnSave;
		JSlider sRating;
		JCheckBox chkSci, chkFant, chkRomance, chkAction, chkThriller, chkHorror;
		
		
		public ChildWindowAdd(LibraryDatabase parent){
			this.parent = parent;
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
			
			final JCheckBox chkSci = new JCheckBox("Sci - Fi");
			chkSci.setBounds(23, 22, 97, 23);
			genreP.add(chkSci);
			
			final JCheckBox chkFant = new JCheckBox("Fantasy");
			chkFant.setBounds(23, 48, 97, 23);
			genreP.add(chkFant);
			
			final JCheckBox chkRomance = new JCheckBox("Romance");
			chkRomance.setBounds(23, 74, 97, 23);
			genreP.add(chkRomance);
			
			final JCheckBox chkAction = new JCheckBox("Action");
			chkAction.setBounds(23, 100, 97, 23);
			genreP.add(chkAction);
			
			final JCheckBox chkThriller = new JCheckBox("Thriller");
			chkThriller.setBounds(23, 126, 97, 23);
			genreP.add(chkThriller);
			
			final JCheckBox chkHorror = new JCheckBox("Horror");
			chkHorror.setBounds(23, 152, 97, 23);
			genreP.add(chkHorror);
			
			final JSlider sRating = new JSlider();
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
			btnSave.addActionListener(this);
			btnSave.setBounds(164, 317, 110, 23);
			getContentPane().add(btnSave);
			
			JLabel lblRating = new JLabel("Rate the book");
			lblRating.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblRating.setBounds(118, 226, 95, 20);
			getContentPane().add(lblRating);
			
			btnSave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					PrintWriter fileWriter = null;
					try {
						fileWriter = new PrintWriter(new BufferedWriter(new FileWriter("database.dat", true)));
					} catch (IOException e) {
						e.printStackTrace();
					}
					fileWriter.println( txtTitle.getText()+" , "+txtaName.getText()+" , "+txtISBN.getText()+" , "+txtDate.getText()+" , "+String.valueOf(chkSci.isSelected())+" , "+String.valueOf(chkFant.isSelected())+" , "+String.valueOf(chkRomance.isSelected())+" , "+String.valueOf(chkAction.isSelected())+" , "+String.valueOf(chkThriller.isSelected())+" , "+String.valueOf(chkHorror.isSelected())+" , "+sRating.getValue());
					fileWriter.close();
				}
			});
		}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			parent.setVisible(true);
			this.dispose();
		}
	}

	public void actionPerformed(ActionEvent e) {
		ChildWindowAdd child = new ChildWindowAdd(this);
		this.setVisible(true);
		child.setVisible(true);
		child.setSize(450,400);		
		child.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}
}
