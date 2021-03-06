package com.moggz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.JTableHeader;

import com.moggz.WebSSoapProxy;

public class GUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}
	
	public static WebSSoapProxy proxy = new WebSSoapProxy();
	private JTextField fileName_textField;
	DefaultTableModel dtmWeb = new DefaultTableModel();
	DefaultTableModel dtmERP = new DefaultTableModel();
	private JTable moviesTable;
	private JTable erpTable;
	private JTextField textField_empNbr;
	private JTextField textField_lineNbr;
	private JTextField textField_relCode;
	private JTextField textField_fName;
	private JTextField textField_lName;

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 813, 620);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 795, 573);
		frame.getContentPane().add(tabbedPane);
		
		JPanel webService_panel = new JPanel();
		tabbedPane.addTab("Web Service", null, webService_panel, null);
		webService_panel.setLayout(null);
		
		JTabbedPane webService_tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		webService_tabbedPane.setBorder(null);
		webService_tabbedPane.setBounds(0, 0, 790, 543);
		webService_panel.add(webService_tabbedPane);
		
		final JPanel file_panel = new JPanel();
		webService_tabbedPane.addTab("Filechooser", null, file_panel, null);
		file_panel.setLayout(null);
		
		final JTextPane fileDisplayTxtPane = new JTextPane();
		fileDisplayTxtPane.setBounds(56, 139, 667, 333);
		file_panel.add(fileDisplayTxtPane);
		fileDisplayTxtPane.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		final JLabel lblFeedBack = new JLabel();
		lblFeedBack.setBounds(441, 84, 108, 31);
		file_panel.add(lblFeedBack);
		
		fileName_textField = new JTextField();
		fileName_textField.setBounds(96, 93, 116, 22);
		file_panel.add(fileName_textField);
		fileName_textField.setColumns(10);
		
		JButton openFileBtn = new JButton("Open File");
		openFileBtn.setBounds(271, 93, 97, 22);
		file_panel.add(openFileBtn);
		openFileBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {			
				fileDisplayTxtPane.setText("");																
				
				String fileName = fileName_textField.getText();	
				if(fileName.isEmpty()) { 
					lblFeedBack.setText("");
					lblFeedBack.setText("Enter a filename");					 
				}
				else {
					lblFeedBack.setText("");
					lblFeedBack.setText("Success!");			
				try {					
					fileDisplayTxtPane.setText(proxy.open(fileName));
					 fileName_textField.setText("");

				} catch (Exception e) {
					e.printStackTrace();
				}				
				} 						
			}
		});		
		
		JLabel lblInfo = new JLabel("Enter name of a .txt file");
		lblInfo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblInfo.setBounds(149, 58, 219, 31);
		file_panel.add(lblInfo);
		
		JLabel txtlbl = new JLabel(".txt");
		txtlbl.setHorizontalAlignment(SwingConstants.TRAILING);
		txtlbl.setBounds(198, 99, 32, 16);
		file_panel.add(txtlbl);
		
		JLabel fileChooserLbl = new JLabel("Filechooser");
		fileChooserLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		fileChooserLbl.setBounds(333, 29, 152, 16);
		file_panel.add(fileChooserLbl);
		
		JPanel movies_panel = new JPanel();
		webService_tabbedPane.addTab("Movies", null, movies_panel, null);
		movies_panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(89, 174, 600, 299);
		movies_panel.add(scrollPane);
		
		moviesTable = new JTable();
		scrollPane.setViewportView(moviesTable);
		moviesTable.setModel(dtmWeb);
		moviesTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
		JPanel ERP_tabbedPane = new JPanel();
		tabbedPane.addTab("ERP", null, ERP_tabbedPane, null);
		ERP_tabbedPane.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(48, 246, 697, 284);
		ERP_tabbedPane.add(scrollPane_1);
		
		erpTable = new JTable();
		scrollPane_1.setViewportView(erpTable);
		erpTable.setModel(dtmERP);
		moviesTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
		JLabel empNbrLbl = new JLabel("Employee Number");
		empNbrLbl.setBounds(44, 42, 125, 16);
		ERP_tabbedPane.add(empNbrLbl);
		
		JLabel lineNbrLbl = new JLabel("Line Number");
		lineNbrLbl.setBounds(170, 42, 96, 16);
		ERP_tabbedPane.add(lineNbrLbl);
		
		JLabel relCodeLbl = new JLabel("Relative Code");
		relCodeLbl.setBounds(278, 42, 96, 16);
		ERP_tabbedPane.add(relCodeLbl);
		
		JLabel fNameLbl = new JLabel("First Name");
		fNameLbl.setBounds(386, 42, 90, 16);
		ERP_tabbedPane.add(fNameLbl);
		
		JLabel lNameLbl = new JLabel("Last Name");
		lNameLbl.setBounds(494, 42, 96, 16);
		ERP_tabbedPane.add(lNameLbl);
		
		textField_empNbr = new JTextField();
		textField_empNbr.setBounds(58, 71, 96, 22);
		ERP_tabbedPane.add(textField_empNbr);
		textField_empNbr.setColumns(10);
		
		textField_lineNbr = new JTextField();
		textField_lineNbr.setColumns(10);
		textField_lineNbr.setBounds(170, 71, 96, 22);
		ERP_tabbedPane.add(textField_lineNbr);
		
		textField_relCode = new JTextField();
		textField_relCode.setColumns(10);
		textField_relCode.setBounds(278, 71, 96, 22);
		ERP_tabbedPane.add(textField_relCode);
		
		textField_fName = new JTextField();
		textField_fName.setColumns(10);
		textField_fName.setBounds(386, 71, 96, 22);
		ERP_tabbedPane.add(textField_fName);
		
		textField_lName = new JTextField();
		textField_lName.setColumns(10);
		textField_lName.setBounds(494, 71, 96, 22);
		ERP_tabbedPane.add(textField_lName);
		
		final JLabel erpFeedBackLbl = new JLabel("");
		erpFeedBackLbl.setBounds(249, 194, 468, 16);
		ERP_tabbedPane.add(erpFeedBackLbl);
		
		JButton updBtn = new JButton("Update");
		updBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				try {
					int lineNbr = Integer.parseInt(textField_lineNbr.getText());
					proxy.updateEmpRelative(textField_empNbr.getText(), lineNbr, textField_relCode.getText(), textField_fName.getText(), textField_lName.getText());
					erpFeedBackLbl.setText("");
					erpFeedBackLbl.setText("Update Complete");
					textField_empNbr.setText(null);
					textField_lineNbr.setText(null);
					textField_relCode.setText(null);
					textField_fName.setText(null);
					textField_lName.setText(null);
				}
				catch (Exception e) {					
					// TODO Auto-generated catch block
					erpFeedBackLbl.setText("");
					erpFeedBackLbl.setText("Could not update, check all field to make sure you have entered the correct inputs");
				}
			}
		});
		updBtn.setBounds(648, 38, 97, 25);
		ERP_tabbedPane.add(updBtn);
		
		JButton delBtn = new JButton("Delete");
		delBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {			
				try {
					int lineNbr = Integer.parseInt(textField_lineNbr.getText());
					proxy.removeEmpRelative(textField_empNbr.getText(), lineNbr);
					erpFeedBackLbl.setText("");
					erpFeedBackLbl.setText("Deletion Complete");
					textField_empNbr.setText(null);
					textField_lineNbr.setText(null);
					textField_relCode.setText(null);
					textField_fName.setText(null);
					textField_lName.setText(null);
				}
				catch (Exception e) {
					// TODO Auto-generated catch block
					erpFeedBackLbl.setText("");
					erpFeedBackLbl.setText("Could not delete, check all field to make sure you have entered the correct inputs");
				}
			}
		});
		delBtn.setBounds(648, 76, 97, 25);
		ERP_tabbedPane.add(delBtn);
		
		JButton createBtn = new JButton("Create");
		createBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int lineNbr = Integer.parseInt(textField_lineNbr.getText());
					proxy.createEmpRelative(textField_empNbr.getText(), lineNbr, textField_relCode.getText(), textField_fName.getText(), textField_lName.getText());
					erpFeedBackLbl.setText("");
					erpFeedBackLbl.setText("Creation Complete");
					textField_empNbr.setText(null);
					textField_lineNbr.setText(null);
					textField_relCode.setText(null);
					textField_fName.setText(null);
					textField_lName.setText(null);
				}
				catch (Exception e) {
					// TODO Auto-generated catch block
					erpFeedBackLbl.setText("");
					erpFeedBackLbl.setText("Could not create, check all field to make sure you have entered the correct inputs");
				}
			}
		});
		createBtn.setBounds(648, 114, 97, 25);
		ERP_tabbedPane.add(createBtn);
		
		JButton clearBtn = new JButton("Clear");
		clearBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dtmERP.getDataVector().removeAllElements();	
				erpTable.repaint();
			}
		});
		clearBtn.setBounds(506, 147, 97, 25);
		ERP_tabbedPane.add(clearBtn);
		
		final JComboBox erpCbox = new JComboBox();
		erpCbox.setModel(new DefaultComboBoxModel(new String[] {"All Employees", "Employee Absences", "Employee Relatives", "Indexes", "Portal", "Sick Employees", "Qualification", "Contracts", "Most Sick Employees", "Statistics", "All Keys", "All Constraints", "All Tables 1", "All Tables 2", "All Employee Tables 1", "All Employee Tables 2", "EmpRel-table" }));
		erpCbox.setBounds(48, 148, 121, 22);
		ERP_tabbedPane.add(erpCbox);
		
		JButton showBtn = new JButton("Show");
		showBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dtmERP.getDataVector().removeAllElements();	
				erpTable.repaint();
				try {
					erpCbox.getSelectedIndex();
					if (erpCbox.getSelectedIndex() == 0)
					{
						String[][] list = proxy.getEmployees();
						dtmERP.setColumnCount(5);
						Vector<String> headers=new Vector<String>(5,0);
						String h1 = "No_";
						String h2 = "First Name";
						String h3 = "Last Name";
						String h4 = "Phone No_";
						String h5 = "Job Title";
						headers.add(h1);
						headers.add(h2);
						headers.add(h3);
						headers.add(h4);
						headers.add(h5);
						dtmERP.setColumnIdentifiers(headers);
						for (String[] str : list) {
							dtmERP.addRow(str);
						}
					}
					else if (erpCbox.getSelectedIndex() == 1)
					{
						String[][] list = proxy.getEmpAbsence();
						dtmERP.setColumnCount(5);
						Vector<String> headers=new Vector<String>(5,0);
						String h1 = "Employee No_";
						String h2 = "Entry No_";
						String h3 = "From Date";
						String h4 = "To Date";
						String h5 = "Cause of Absence Code";
						headers.add(h1);
						headers.add(h2);
						headers.add(h3);
						headers.add(h4);
						headers.add(h5);
						dtmERP.setColumnIdentifiers(headers);		
						for (String[] str : list) {
							dtmERP.addRow(str);
						}
					}
					else if (erpCbox.getSelectedIndex() == 2)
					{
						String[][] list = proxy.getEmpRelative();
						dtmERP.setColumnCount(5);
						Vector<String> headers=new Vector<String>(5,0);
						String h1 = "Employee No_";
						String h2 = "Line No_";
						String h3 = "Relative Code";
						String h4 = "First Name";
						String h5 = "Last Name";
						headers.add(h1);
						headers.add(h2);
						headers.add(h3);
						headers.add(h4);
						headers.add(h5);
						dtmERP.setColumnIdentifiers(headers);
						for (String[] str : list) {
							dtmERP.addRow(str);
						}
					}
					else if (erpCbox.getSelectedIndex() == 3)
					{
						String[][] list = proxy.getIndexes();
						dtmERP.setColumnCount(5);
						Vector<String> headers=new Vector<String>(5,0);
						String h1 = "object_id";
						String h2 = "name";
						String h3 = "index_id";
						String h4 = "type";
						String h5 = "type_desc";
						headers.add(h1);
						headers.add(h2);
						headers.add(h3);
						headers.add(h4);
						headers.add(h5);
						dtmERP.setColumnIdentifiers(headers);
						for (String[] str : list) {
							dtmERP.addRow(str);
						}
					}
					else if (erpCbox.getSelectedIndex() == 4)
					{
						String[][] list = proxy.getPortal();
						dtmERP.setColumnCount(5);
						Vector<String> headers=new Vector<String>(5,0);
						String h1 = "Primary Key";
						String h2 = "Search Limit";
						String h3 = "Back End Primary Key";
						String h4 = "Back End Public Key";
						String h5 = "Search TP All Tables Caption";
						headers.add(h1);
						headers.add(h2);
						headers.add(h3);
						headers.add(h4);
						headers.add(h5);
						dtmERP.setColumnIdentifiers(headers);
						for (String[] str : list) {
							dtmERP.addRow(str);
						}
					}
					else if (erpCbox.getSelectedIndex() == 5)
					{
						String[][] list = proxy.getSick();
						dtmERP.setColumnCount(5);
						Vector<String> headers=new Vector<String>(5,0);
						String h1 = "Employee No_";
						String h2 = "Entry No_";
						String h3 = "From Date";
						String h4 = "To Date";
						String h5 = "Cause of Absence Code";
						headers.add(h1);
						headers.add(h2);
						headers.add(h3);
						headers.add(h4);
						headers.add(h5);
						dtmERP.setColumnIdentifiers(headers);
						for (String[] str : list) {
							dtmERP.addRow(str);
						}
					}
					else if (erpCbox.getSelectedIndex() == 6)
					{
						String[][] list = proxy.getQualification();
						dtmERP.setColumnCount(5);
						Vector<String> headers=new Vector<String>(5,0);
						String h1 = "No_";
						String h2 = "First Name";
						String h3 = "Last Name";
						String h4 = "Phone No_";
						String h5 = "Job Title";
						headers.add(h1);
						headers.add(h2);
						headers.add(h3);
						headers.add(h4);
						headers.add(h5);
						dtmERP.setColumnIdentifiers(headers);
						for (String[] str : list) {
							dtmERP.addRow(str);
						}
					}
					else if (erpCbox.getSelectedIndex() == 7)
					{
						String[][] list = proxy.getContract();
						dtmERP.setColumnCount(2);
						Vector<String> headers=new Vector<String>(2,0);
						String h1 = "Code";
						String h2 = "Description";
						headers.add(h1);
						headers.add(h2);
						dtmERP.setColumnIdentifiers(headers);
						for (String[] str : list) {
							dtmERP.addRow(str);
						}
					}
					else if (erpCbox.getSelectedIndex() == 8)
					{
						String[][] list = proxy.getMostSick();
						dtmERP.setColumnCount(2);
						Vector<String> headers=new Vector<String>(2,0);
						String h1 = "First Name";
						String h2 = "Number of occations sick";
						headers.add(h1);
						headers.add(h2);
						dtmERP.setColumnIdentifiers(headers);
						for (String[] str : list) {
							dtmERP.addRow(str);
						}
					}
					else if (erpCbox.getSelectedIndex() == 9)
					{
						String[][] list = proxy.getStats();
						dtmERP.setColumnCount(2);
						Vector<String> headers=new Vector<String>(2,0);
						String h1 = "Code";
						String h2 = "Description";
						headers.add(h1);
						headers.add(h2);
						dtmERP.setColumnIdentifiers(headers);
						for (String[] str : list) {
							dtmERP.addRow(str);
						}
					}
					else if (erpCbox.getSelectedIndex() == 10)
					{
						String[][] list = proxy.getKeys();
						dtmERP.setColumnCount(2);
						Vector<String> headers=new Vector<String>(2,0);
						String h1 = "constraint_name";
						String h2 = "CONSTRAINT_TYPE";
						headers.add(h1);
						headers.add(h2);
						dtmERP.setColumnIdentifiers(headers);
						for (String[] str : list) {
							dtmERP.addRow(str);
						}
					}
					else if (erpCbox.getSelectedIndex() == 11)
					{
						String[][] list = proxy.getConstraints();
						dtmERP.setColumnCount(2);
						Vector<String> headers=new Vector<String>(2,0);
						String h1 = "table_name";
						String h2 = "constraint_name";
						headers.add(h1);
						headers.add(h2);
						dtmERP.setColumnIdentifiers(headers);
						for (String[] str : list) {
							dtmERP.addRow(str);
						}
					}
					else if (erpCbox.getSelectedIndex() == 12)
					{
						String[][] list = proxy.getAllTables1();
						dtmERP.setColumnCount(1);
						Vector<String> headers=new Vector<String>(1,0);
						String h1 = "name";						
						headers.add(h1);
						dtmERP.setColumnIdentifiers(headers);
						for (String[] str : list) {
							dtmERP.addRow(str);
						}
					}
					else if (erpCbox.getSelectedIndex() == 13)
					{
						String[][] list = proxy.getAllTables2();
						dtmERP.setColumnCount(1);
						Vector<String> headers=new Vector<String>(1,0);
						String h1 = "name";
						headers.add(h1);
						dtmERP.setColumnIdentifiers(headers);
						for (String[] str : list) {
							dtmERP.addRow(str);
						}
					}
					else if (erpCbox.getSelectedIndex() == 14)
					{
						String[][] list = proxy.getAllEmpTables1();
						dtmERP.setColumnCount(1);
						Vector<String> headers=new Vector<String>(1,0);
						String h1 = "name";
						headers.add(h1);
						dtmERP.setColumnIdentifiers(headers);
						for (String[] str : list) {
							dtmERP.addRow(str);
						}
					}
					else if (erpCbox.getSelectedIndex() == 15)
					{
						String[][] list = proxy.getAllEmpTables2();
						dtmERP.setColumnCount(1);
						Vector<String> headers=new Vector<String>(1,0);
						String h1 = "column_name";
						headers.add(h1);
						dtmERP.setColumnIdentifiers(headers);
						for (String[] str : list) {
							dtmERP.addRow(str);
						}
					}
					else if (erpCbox.getSelectedIndex() == 16)
					{
						String[][] list = proxy.getEmpRel();
						dtmERP.setColumnCount(5);
						Vector<String> headers=new Vector<String>(5,0);
						String h1 = "Employee No_";
						String h2 = "LineNo_";
						String h3 = "RelativeCode";
						String h4 = "First Name";
						String h5 = "Last Name";
						headers.add(h1);
						headers.add(h2);
						headers.add(h3);
						headers.add(h4);
						headers.add(h5);
						dtmERP.setColumnIdentifiers(headers);		
						for (String[] str : list) {
							dtmERP.addRow(str);
						}
					}
				}
				catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		showBtn.setBounds(181, 147, 97, 25);
		ERP_tabbedPane.add(showBtn);
		
		final JLabel feedBackMoviesLbl = new JLabel("");
		feedBackMoviesLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		feedBackMoviesLbl.setBounds(287, 134, 202, 27);
		movies_panel.add(feedBackMoviesLbl);
		
		JButton showMoviesBtn = new JButton("Show all movies");
		showMoviesBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		showMoviesBtn.setBounds(266, 67, 240, 43);
		showMoviesBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				dtmWeb.getDataVector().removeAllElements();	
				moviesTable.repaint();
				feedBackMoviesLbl.setText("");
			try {
				String[][] list = proxy.getMovies();
				dtmWeb.setColumnCount(4);
				Vector<String> headers=new Vector<String>(1,0);
				String h1 = "MovieName";
				String h2 = "ReleaseYear";
				String h3 = "Genre";
				String h4 = "Rating";
				headers.add(h1);
				headers.add(h2);
				headers.add(h3);
				headers.add(h4);
				dtmWeb.setColumnIdentifiers(headers);
				for(String[] str : list) {
					dtmWeb.addRow(str);
					feedBackMoviesLbl.setText("Success");
				}
				
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				feedBackMoviesLbl.setText("Failed to retrieve table");
			}
			}
		});
		movies_panel.add(showMoviesBtn); 
		
		JLabel lblDisplayAllMovies = new JLabel("Display all movies in database ");
		lblDisplayAllMovies.setHorizontalAlignment(SwingConstants.CENTER);
		lblDisplayAllMovies.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDisplayAllMovies.setBounds(246, 13, 277, 41);
		movies_panel.add(lblDisplayAllMovies);
	}
}
