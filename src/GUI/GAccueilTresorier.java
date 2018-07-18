package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.border.LineBorder;

import Classe.CMembre;
import Classe.CTresorier;
import DAO.DMembre;

import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GAccueilTresorier extends JFrame {
	
	private CTresorier ct;
	private JPanel contentPane;
	private JPanel panel;
	private JComboBox<CMembre> comboBox;
	private JButton btnValider;
	private JLabel lbl_err;
	
	
	public GAccueilTresorier(CTresorier ct, Rectangle rectangle) {
		
		this.ct = ct;
		initialize(rectangle);
		this.setVisible(true);
	}
	
	private void initialize(Rectangle rectangle) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(rectangle);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 65, 414, 116);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblCotisationsImpayes = new JLabel("Cotisations impay\u00E9es");
		lblCotisationsImpayes.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCotisationsImpayes.setBounds(10, 24, 171, 22);
		panel.add(lblCotisationsImpayes);
		
		comboBox = new JComboBox<CMembre>();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox.setBounds(191, 22, 213, 29);
		panel.add(comboBox);
		initCombo();
		
		JButton btnValider = new JButton("Valider");
		btnValider.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				validerPayement();
			}
		});
		btnValider.setBounds(315, 82, 89, 23);
		panel.add(btnValider);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(10, 11, 414, 43);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel = new JLabel("Tresorier");
		lblNewLabel.setBounds(10, 15, 89, 14);
		panel_1.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblGgg = new JLabel(ct.getPseudo());
		lblGgg.setBounds(85, 11, 319, 22);
		panel_1.add(lblGgg);
		lblGgg.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btnDeconnecter = new JButton("Deconnecter");
		btnDeconnecter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				deconnection();
			}
		});
		btnDeconnecter.setBounds(329, 227, 95, 23);
		contentPane.add(btnDeconnecter);
		
		lbl_err = new JLabel("");
		lbl_err.setForeground(Color.RED);
		lbl_err.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_err.setBounds(10, 192, 414, 14);
		contentPane.add(lbl_err);
	}
	
	private void initCombo() {
		DMembre dm = new DMembre();
		ArrayList <CMembre> lstCotImpaye = new ArrayList <CMembre>();
		lstCotImpaye = dm.findCotisationImpaye();
		for(CMembre cm : lstCotImpaye) {
			comboBox.addItem(cm);
		}
	}
	
	private void validerPayement() {
		if(this.comboBox.getSelectedItem()!= null){
			DMembre dm = new DMembre();
			CMembre cm = (CMembre)this.comboBox.getSelectedItem();
			
			boolean maj = dm.updateCotisation(cm);
			if(maj) {
				comboBox.removeItem(cm);
			}
			else {
				lbl_err.setText("Erreur dans la mise à jour de la cotisation.");
			}
		}
		else {
			lbl_err.setText("Erreur! Choisissez dabord un membre.");
		}
	}
	
	private void deconnection() {
		GLogin frame = new GLogin(this.getBounds());
		frame.setVisible(true);
		this.dispose();
	}
}
