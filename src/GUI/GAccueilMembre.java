package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.border.LineBorder;

import Classe.CCategorie;
import Classe.CMembre;
import Classe.CPersonne;
import DAO.DCategorie;
import DAO.DMembre;
import DAO.DPersonne;

import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;

public class GAccueilMembre extends JFrame {
	
	private CMembre cm;
	private JPanel contentPane;
	private JComboBox<CCategorie> cmb_lstCat;
	private JComboBox<CCategorie> cmb_lstAutreCat;
	private JLabel lbl_err;
	private JTextField txt_tel;
	private JTextField txt_mail;
	private JTextField txt_rue;
	private JTextField txt_num;
	private JTextField txt_cp;
	private JTextField txt_ville;
	private JLabel lbl_ok;
	
	/**
	 * Create the frame.
	 */
	
	public GAccueilMembre(CMembre cm, Rectangle rectangle) {
		this.cm = cm;
		initialize(rectangle);
	}
	
	private void initialize(Rectangle rectangle) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds((int)rectangle.getX(),(int)rectangle.getY(),541,310);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 11, 250, 249);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnMofifierInfo = new JButton("Modifier");
		btnMofifierInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				modifierDonnees(txt_tel.getText(),txt_mail.getText(),txt_rue.getText(),txt_num.getText(),txt_cp.getText(),txt_ville.getText());
			}
		});
		btnMofifierInfo.setBounds(146, 215, 94, 23);
		panel.add(btnMofifierInfo);
		
		JLabel lblAdresse = new JLabel("Adresse");
		lblAdresse.setBounds(12, 161, 64, 14);
		panel.add(lblAdresse);
		lblAdresse.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblMail = new JLabel("Mail");
		lblMail.setBounds(12, 136, 64, 14);
		panel.add(lblMail);
		lblMail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblTel = new JLabel("Tel");
		lblTel.setBounds(12, 107, 64, 14);
		panel.add(lblTel);
		lblTel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblAge = new JLabel("Naissance");
		lblAge.setBounds(12, 83, 64, 17);
		panel.add(lblAge);
		lblAge.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblPrenom = new JLabel("Prenom");
		lblPrenom.setBounds(12, 60, 64, 14);
		panel.add(lblPrenom);
		lblPrenom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1 = new JLabel("Nom");
		lblNewLabel_1.setBounds(12, 35, 64, 14);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel = new JLabel("Membre");
		lblNewLabel.setBounds(12, 10, 64, 14);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel label_1 = new JLabel(" :");
		label_1.setBounds(69, 35, 15, 14);
		panel.add(label_1);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel label_2 = new JLabel(" :");
		label_2.setBounds(69, 60, 15, 14);
		panel.add(label_2);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel label_3 = new JLabel(" :");
		label_3.setBounds(69, 84, 15, 14);
		panel.add(label_3);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel label_4 = new JLabel(" :");
		label_4.setBounds(69, 107, 15, 14);
		panel.add(label_4);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel label_5 = new JLabel(" :");
		label_5.setBounds(69, 136, 15, 14);
		panel.add(label_5);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel label_6 = new JLabel(" :");
		label_6.setBounds(69, 161, 15, 14);
		panel.add(label_6);
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lbl_age = new JLabel(cm.getDateNaissance().toString());
		lbl_age.setBounds(86, 80, 141, 23);
		panel.add(lbl_age);
		lbl_age.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lbl_prenom = new JLabel(cm.getPrenom());
		lbl_prenom.setBounds(86, 56, 141, 23);
		panel.add(lbl_prenom);
		lbl_prenom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lbl_nom = new JLabel(cm.getNom());
		lbl_nom.setBounds(86, 31, 141, 23);
		panel.add(lbl_nom);
		lbl_nom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel label = new JLabel(cm.getPseudo());
		label.setBounds(86, 6, 141, 23);
		panel.add(label);
		label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		txt_tel = new JTextField(cm.getTel());
		txt_tel.setBounds(86, 106, 154, 20);
		panel.add(txt_tel);
		txt_tel.setColumns(10);
		
		txt_mail = new JTextField(cm.getMail());
		txt_mail.setColumns(10);
		txt_mail.setBounds(86, 135, 154, 20);
		panel.add(txt_mail);
		
		txt_rue = new JTextField(cm.getRue());
		txt_rue.setColumns(10);
		txt_rue.setBounds(86, 160, 109, 20);
		panel.add(txt_rue);
		
		txt_num = new JTextField(cm.getNumRue());
		txt_num.setColumns(10);
		txt_num.setBounds(205, 160, 35, 20);
		panel.add(txt_num);
		
		txt_cp = new JTextField(cm.getCp());
		txt_cp.setColumns(10);
		txt_cp.setBounds(86, 184, 57, 20);
		panel.add(txt_cp);
		
		txt_ville = new JTextField(cm.getLocalite());
		txt_ville.setColumns(10);
		txt_ville.setBounds(153, 184, 89, 20);
		panel.add(txt_ville);
		
		JLabel lblNewLabel_2 = new JLabel(",");
		lblNewLabel_2.setBounds(146, 190, 15, 14);
		panel.add(lblNewLabel_2);
		
		JLabel label_7 = new JLabel(",");
		label_7.setBounds(200, 166, 15, 14);
		panel.add(label_7);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(270, 11, 245, 168);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblMesCatgories = new JLabel("Mes Cat\u00E9gories");
		lblMesCatgories.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMesCatgories.setBounds(10, 11, 119, 22);
		panel_1.add(lblMesCatgories);
		
		cmb_lstCat = new JComboBox<CCategorie>();
		cmb_lstCat.setForeground(new Color(0, 128, 0));
		cmb_lstCat.setBounds(10, 44, 225, 20);
		panel_1.add(cmb_lstCat);
		initCmbLstCat();
		
		JButton btnAjouterCat = new JButton("Ajouter");
		btnAjouterCat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ajouterCategorie((CCategorie)cmb_lstAutreCat.getSelectedItem());
			}
		});
		btnAjouterCat.setBounds(146, 100, 89, 23);
		panel_1.add(btnAjouterCat);
		
		JButton btnConsulterCalendrier = new JButton("Consulter");
		btnConsulterCalendrier.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				consulterCalendrier(cm, (CCategorie)cmb_lstCat.getSelectedItem());
			}
		});
		btnConsulterCalendrier.setBounds(146, 14, 89, 23);
		panel_1.add(btnConsulterCalendrier);
		
		JLabel lblAutreCats = new JLabel("Autre Cat\u00E9gories");
		lblAutreCats.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAutreCats.setBounds(10, 97, 138, 22);
		panel_1.add(lblAutreCats);
		
		cmb_lstAutreCat = new JComboBox<CCategorie>();
		cmb_lstAutreCat.setForeground(Color.RED);
		cmb_lstAutreCat.setBounds(10, 130, 225, 20);
		panel_1.add(cmb_lstAutreCat);
		initCmbLstAutreCat();
		
		JButton btnDeconnecter = new JButton("Deconnecter");
		btnDeconnecter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				deconnection();
			}
		});
		btnDeconnecter.setBounds(407, 225, 108, 23);
		contentPane.add(btnDeconnecter);
		
		lbl_err = new JLabel("");
		lbl_err.setForeground(Color.RED);
		lbl_err.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_err.setBounds(270, 190, 243, 24);
		contentPane.add(lbl_err);
		
		lbl_ok = new JLabel("");
		lbl_ok.setForeground(new Color(0, 128, 0));
		lbl_ok.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_ok.setBounds(270, 190, 243, 24);
		contentPane.add(lbl_ok);
	}
	
	private void initCmbLstCat() {
		DCategorie dc = new DCategorie();
		ArrayList <CCategorie> lstCatInscrit = new ArrayList <CCategorie>();
		lstCatInscrit = dc.find(cm);
		for(CCategorie cc : lstCatInscrit) {
			cmb_lstCat.addItem(cc);
		}
	}
	
	private void initCmbLstAutreCat() {
		DCategorie dc = new DCategorie();
		ArrayList <CCategorie> lstAutreCat = new ArrayList <CCategorie>();
		lstAutreCat = dc.notFind(cm);
		for(CCategorie cc : lstAutreCat) {
			cmb_lstAutreCat.addItem(cc);
		}
	}
	
	private void deconnection() {
		GLogin frame = new GLogin(this.getBounds());
		frame.setVisible(true);
		this.dispose();
	}
	
	private void ajouterCategorie(CCategorie ca) {
		DMembre dm = new DMembre();
		if(ca != null && dm != null && dm.create(ca, cm)) {
			cm.ajouterCategorie(ca);
			cmb_lstAutreCat.removeItem(ca);
			cmb_lstCat.addItem(ca);
			if(dm.updateCotisation(cm,false)) {
				cm.setPayementCotistion(false);
			}
		}
		else {
			lbl_err.setText("Erreur : Rien à ajouter");
			lbl_ok.setText("");
		}
		
	}
	
	private void modifierDonnees(String tel,String mail,String rue,String numRue,String cp,String ville) {
		
		if(!tel.isEmpty() && !mail.isEmpty() && !rue.isEmpty() && !numRue.isEmpty() && !cp.isEmpty() && !ville.isEmpty() ) {
			DPersonne dp = new DPersonne();
			if(dp.update((CPersonne)cm,tel,mail,rue,numRue,cp,ville)) {
				cm.setTel(tel);
				cm.setMail(mail);
				cm.setRue(rue);
				cm.setNumRue(numRue);
				cm.setCp(cp);
				cm.setLocalite(ville);
				lbl_err.setText("");
				lbl_ok.setText("Modifications validées!");
			}
			else {
				lbl_err.setText("Erreur : MAJ données perso");
				lbl_ok.setText("");
			}
		}
		else {
			lbl_err.setText("Erreur : Completez tout les champs!");
			lbl_ok.setText("");
		}
	}
	
	private void consulterCalendrier(CMembre cm, CCategorie ca){
		if(cm.getPayementCotistion()) {
			GCalendrierBalade win = new GCalendrierBalade(this.getBounds(),cm,ca, this);
			win.setVisible(true);
			this.setVisible(false);
		}
		else {
			lbl_err.setText("Faut d'abord payer!");
			lbl_ok.setText("");
		}
		
	}
	
	public void retourVersGAccueilMembre(Rectangle r) {
		this.setBounds((int)r.getX(),(int)r.getY(),541,310);
		this.setVisible(true);
	}
}
