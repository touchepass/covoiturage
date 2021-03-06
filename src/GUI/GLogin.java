package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;

import Classe.CMembre;
import Classe.CPersonne;
import Classe.CResponsable;
import Classe.CTresorier;
import DAO.DAO;
import DAO.DMembre;
import DAO.DPersonne;
import DAO.DResponsable;
import DAO.DTresorier;

@SuppressWarnings("serial")
public class GLogin extends JFrame {
	
	private JPanel contentPane;
	private JTextField txtPseudo;
	private JTextField txtPass;
	private JLabel txtErreur;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GLogin frame = new GLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param rectangle 
	 */
	public GLogin(Rectangle rectangle) {
		initialize();
		this.setBounds((int)rectangle.getX(),(int)rectangle.getY(),450,300);
	}
	
	public GLogin() {
		initialize();
		setBounds(100, 100, 450, 253);
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = new JPanel();
		contentPane.setBorder(new CompoundBorder());
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBienvenue = new JLabel("Bienvenue");
		lblBienvenue.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenue.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBienvenue.setBounds(163, 11, 92, 14);
		contentPane.add(lblBienvenue);
		
		JLabel lblPseudo = new JLabel("Pseudo");
		lblPseudo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPseudo.setBounds(110, 87, 51, 14);
		contentPane.add(lblPseudo);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPassword.setBounds(94, 139, 67, 14);
		contentPane.add(lblPassword);
		
		txtPseudo = new JTextField();
		txtPseudo.setBounds(208, 86, 152, 20);
		contentPane.add(txtPseudo);
		txtPseudo.setColumns(10);
		
		txtPass = new JTextField();
		txtPass.setBounds(208, 138, 152, 20);
		contentPane.add(txtPass);
		txtPass.setColumns(10);
		
		JButton btnCestParti = new JButton("C'est parti!");
		btnCestParti.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				seConnecter();
			}
		});
		btnCestParti.setBounds(155, 180, 100, 23);
		contentPane.add(btnCestParti);
		
		txtErreur = new JLabel("");
		txtErreur.setForeground(Color.RED);
		txtErreur.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtErreur.setBounds(10, 36, 414, 23);
		contentPane.add(txtErreur);
		
		JButton btnNouveau = new JButton("Nouveau?");
		btnNouveau.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				inscription();
			}
		});
		btnNouveau.setBounds(260, 180, 100, 23);
		contentPane.add(btnNouveau);
	}
	
	private void seConnecter() {
		CPersonne cp = null;
		DAO<CPersonne> dp = new DPersonne();
		
		CMembre cm = null;
		CTresorier ct= null;
		CResponsable cr = null;
		
		if(!checkInfoVide()) {
			cp = ((DPersonne)dp).find(txtPseudo.getText().toLowerCase(), txtPass.getText());
			
			if(cp != null) {
				txtErreur.setText("");
				DAO<CMembre> dm = new DMembre();
				cm = dm.find(cp);
				
				if(cm != null) {
					GAccueilMembre fenetre = new GAccueilMembre(cm,this.getBounds());
					fenetre.setVisible(true);
					this.dispose();
				}
				else {
					DAO<CTresorier> dt = new DTresorier();
					ct = dt.find(cp);
					if(ct != null) {
						GAccueilTresorier fenetre = new GAccueilTresorier(ct, this.getBounds());
						fenetre.setVisible(true);
						this.dispose();
					}
					else {
						DAO<CResponsable> dr = new DResponsable();
						cr = dr.find(cp);
						if(cr != null){
							GAccueilResponsable fenetre = new GAccueilResponsable(this.getBounds(),cr);
							fenetre.setVisible(true);
							this.dispose();
						}
					}
				}
			}
			else {
				txtErreur.setText("Erreur : Identifiants Invalides.");
			}
		}
		else {
			txtErreur.setText("Erreur : Entrez vos identifiants en premier lieu.");
		}
	}
	
	private boolean checkInfoVide() {
		
		if(txtPseudo.getText().length() < 1 || txtPass.getText().length() <1) {
			return true;
		}
	
		return false;
	}
	
	private void inscription() {
		GInscription fenetre = new GInscription(this.getBounds());
		fenetre.setVisible(true);
		this.dispose();
	}
}
