package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Classe.CCategorie;
import Classe.CPersonne;
import DAO.DCategorie;
import DAO.DPersonne;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class GInscription extends JFrame {

	private JPanel contentPane;
	private JTextField txtNom;
	private JTextField txtPrenom;
	private JTextField txtDateJ;
	private JTextField txtTel;
	private JTextField txtMail;
	private JTextField txtRue;
	private JTextField txtNumRue;
	private JTextField txtLocalite;
	private JTextField txtCp;
	private JTextField txtPseudo;
	private JTextField txtPass;
	private JTextField txtDateM;
	private JTextField txtDateA;
	private JComboBox<String> cmbGenre;
	private JLabel lblErr;
	private JComboBox<CCategorie> cmbCat;

	/**
	 * Create the frame.
	 */
	public GInscription(Rectangle rectangle) {
		initialize(rectangle);
	}
	
	private void initialize(Rectangle rectangle) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds((int)rectangle.getX(), (int)rectangle.getY(), 296, 566);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Inscription");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(92, 16, 91, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nom");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(10, 47, 70, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblPrenom = new JLabel("Prenom");
		lblPrenom.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPrenom.setBounds(10, 78, 70, 20);
		contentPane.add(lblPrenom);
		
		JLabel lblDateNaissance = new JLabel("Date naissance");
		lblDateNaissance.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDateNaissance.setBounds(10, 109, 91, 20);
		contentPane.add(lblDateNaissance);
		
		JLabel lblGenre = new JLabel("Genre");
		lblGenre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblGenre.setBounds(10, 140, 70, 20);
		contentPane.add(lblGenre);
		
		JLabel lblTel = new JLabel("tel");
		lblTel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTel.setBounds(10, 171, 70, 20);
		contentPane.add(lblTel);
		
		JLabel lblMail = new JLabel("mail");
		lblMail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMail.setBounds(10, 202, 70, 20);
		contentPane.add(lblMail);
		
		JLabel lblRue = new JLabel("Rue");
		lblRue.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRue.setBounds(10, 233, 70, 20);
		contentPane.add(lblRue);
		
		JLabel lblNumro = new JLabel("Num\u00E9ro");
		lblNumro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNumro.setBounds(10, 264, 70, 20);
		contentPane.add(lblNumro);
		
		JLabel lblLocalit = new JLabel("Localit\u00E9");
		lblLocalit.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLocalit.setBounds(10, 295, 70, 20);
		contentPane.add(lblLocalit);
		
		JLabel lblCodePostal = new JLabel("Code Postal");
		lblCodePostal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCodePostal.setBounds(10, 326, 70, 20);
		contentPane.add(lblCodePostal);
		
		JLabel lblPseudo = new JLabel("Pseudo");
		lblPseudo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPseudo.setBounds(10, 357, 70, 20);
		contentPane.add(lblPseudo);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPassword.setBounds(10, 388, 70, 20);
		contentPane.add(lblPassword);
		
		JLabel label = new JLabel(":");
		label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label.setBounds(111, 109, 20, 20);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel(":");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_1.setBounds(111, 78, 20, 20);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel(":");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_2.setBounds(111, 47, 20, 20);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel(":");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_3.setBounds(111, 140, 20, 20);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel(":");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_4.setBounds(111, 171, 20, 20);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel(":");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_5.setBounds(111, 202, 20, 20);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel(":");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_6.setBounds(111, 233, 20, 20);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel(":");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_7.setBounds(111, 264, 20, 20);
		contentPane.add(label_7);
		
		JLabel label_8 = new JLabel(":");
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_8.setBounds(111, 295, 20, 20);
		contentPane.add(label_8);
		
		JLabel label_9 = new JLabel(":");
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_9.setBounds(111, 326, 20, 20);
		contentPane.add(label_9);
		
		JLabel label_10 = new JLabel(":");
		label_10.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_10.setBounds(111, 357, 20, 20);
		contentPane.add(label_10);
		
		JLabel label_11 = new JLabel(":");
		label_11.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_11.setBounds(111, 388, 20, 20);
		contentPane.add(label_11);
		
		txtNom = new JTextField();
		txtNom.setBounds(118, 48, 152, 20);
		contentPane.add(txtNom);
		txtNom.setColumns(10);
		
		txtPrenom = new JTextField();
		txtPrenom.setColumns(10);
		txtPrenom.setBounds(118, 79, 152, 20);
		contentPane.add(txtPrenom);
		
		txtDateJ = new JTextField();
		txtDateJ.setColumns(10);
		txtDateJ.setBounds(118, 110, 28, 20);
		contentPane.add(txtDateJ);
		
		txtTel = new JTextField();
		txtTel.setColumns(10);
		txtTel.setBounds(118, 172, 152, 20);
		contentPane.add(txtTel);
		
		txtMail = new JTextField();
		txtMail.setColumns(10);
		txtMail.setBounds(118, 203, 152, 20);
		contentPane.add(txtMail);
		
		txtRue = new JTextField();
		txtRue.setColumns(10);
		txtRue.setBounds(118, 234, 152, 20);
		contentPane.add(txtRue);
		
		txtNumRue = new JTextField();
		txtNumRue.setColumns(10);
		txtNumRue.setBounds(118, 265, 152, 20);
		contentPane.add(txtNumRue);
		
		txtLocalite = new JTextField();
		txtLocalite.setColumns(10);
		txtLocalite.setBounds(118, 296, 152, 20);
		contentPane.add(txtLocalite);
		
		txtCp = new JTextField();
		txtCp.setColumns(10);
		txtCp.setBounds(118, 327, 152, 20);
		contentPane.add(txtCp);
		
		txtPseudo = new JTextField();
		txtPseudo.setColumns(10);
		txtPseudo.setBounds(118, 358, 152, 20);
		contentPane.add(txtPseudo);
		
		txtPass = new JTextField();
		txtPass.setColumns(10);
		txtPass.setBounds(118, 389, 152, 20);
		contentPane.add(txtPass);
		
		lblErr = new JLabel("");
		lblErr.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblErr.setBounds(10, 462, 260, 20);
		contentPane.add(lblErr);
		
		JButton btnNewButton = new JButton("Valider");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				enregistrer();
			}
		});
		btnNewButton.setBounds(10, 493, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.setBounds(181, 493, 89, 23);
		contentPane.add(btnRetour);
		
		txtDateM = new JTextField();
		txtDateM.setColumns(10);
		txtDateM.setBounds(156, 110, 28, 20);
		contentPane.add(txtDateM);
		
		txtDateA = new JTextField();
		txtDateA.setColumns(10);
		txtDateA.setBounds(194, 110, 76, 20);
		contentPane.add(txtDateA);
		
		cmbGenre = new JComboBox<String>();
		cmbGenre.setModel(new DefaultComboBoxModel<String>(new String[] {"M", "F", "O"}));
		cmbGenre.setBounds(121, 141, 149, 20);
		contentPane.add(cmbGenre);
		
		JLabel label_12 = new JLabel("Genre");
		label_12.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_12.setBounds(10, 419, 70, 20);
		contentPane.add(label_12);
		
		JLabel label_13 = new JLabel(":");
		label_13.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_13.setBounds(111, 419, 20, 20);
		contentPane.add(label_13);
		
		cmbCat = new JComboBox<CCategorie>();
		cmbCat.setBounds(121, 419, 149, 20);
		contentPane.add(cmbCat);
		
		initCmbCat();
	}
	
	private void initCmbCat() {
		DCategorie dc = new DCategorie();
		ArrayList <CCategorie> lstCat = new ArrayList <CCategorie>();
		lstCat = dc.find();
		for(CCategorie cc : lstCat) {
			cmbCat.addItem(cc);
		}
	}
	
	private void enregistrer() {
		
		if(	!txtNom.getText().isEmpty()    && !txtPrenom.getText().isEmpty()  && !txtTel.getText().isEmpty()      && !txtMail.getText().isEmpty()  &&
			!txtRue.getText().isEmpty()    && !txtNumRue.getText().isEmpty()  && !txtLocalite.getText().isEmpty() && !txtCp.getText().isEmpty()    && 
			!txtPseudo.getText().isEmpty() && !txtPass.getText().isEmpty()    &&!txtDateM.getText().isEmpty()     && !txtDateM.getText().isEmpty() && 
			!txtDateM.getText().isEmpty()) {
			
			try {
				String date = txtDateA.getText()+"-"+txtDateM.getText()+"-"+txtDateJ.getText();
				Date dt = (new SimpleDateFormat("yyyy-MM-dd")).parse(date);
				
				CPersonne cp = new CPersonne(	txtNom.getText(), txtPrenom.getText(), dt, (cmbGenre.getSelectedItem()).toString(), txtTel.getText(),
												txtMail.getText(), txtRue.getText(), txtNumRue.getText(), txtLocalite.getText(), txtCp.getText(),
												txtPseudo.getText(), txtPass.getText());
				CCategorie cc = (CCategorie)cmbCat.getSelectedItem();
				DPersonne dp = new DPersonne();
				if(dp.find(txtPseudo.getText())==null) {
					if(dp.create(cp, cc)) {
						retour();
					}
					else {
						lblErr.setForeground(Color.RED);
						lblErr.setText("Champs Incorrectes / problème DB!");
					}
				}
				else {
					lblErr.setForeground(Color.RED);
					lblErr.setText("Pseudo non disponnible!");
				}
			}
			catch(Exception e) {
				lblErr.setForeground(Color.RED);
				lblErr.setText("Champs Incorrectes / problème DB!");
			}
			
					
			/*
			 * 	public CPersonne(String nom, String prenom, Date dateNaissance, String genre, String tel, String mail,
				String rue, String numRue, String localite, String cp, String pseudo, String pass )
			 */
		}
		else {
			lblErr.setForeground(Color.RED);
			lblErr.setText("Champs Incomplets!");
		}
	}
	
	private void retour() {
		GLogin frame = new GLogin(this.getBounds());
		frame.setVisible(true);
		this.dispose();
	}
	
}
