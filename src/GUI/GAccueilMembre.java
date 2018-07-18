package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JComboBox;

public class GAccueilMembre extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GAccueilMembre frame = new GAccueilMembre();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GAccueilMembre() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 541, 310);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label.setBounds(94, 11, 151, 14);
		contentPane.add(label);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 11, 237, 249);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnMofifierInfo = new JButton("Modifier");
		btnMofifierInfo.setBounds(138, 215, 89, 23);
		panel.add(btnMofifierInfo);
		
		JLabel lbl_add2 = new JLabel("");
		lbl_add2.setBounds(86, 186, 141, 14);
		panel.add(lbl_add2);
		lbl_add2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lbl_add1 = new JLabel("");
		lbl_add1.setBounds(86, 161, 141, 14);
		panel.add(lbl_add1);
		lbl_add1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
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
		
		JLabel lblAge = new JLabel("Age");
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
		
		JLabel lbl_mail = new JLabel("");
		lbl_mail.setBounds(86, 136, 141, 14);
		panel.add(lbl_mail);
		lbl_mail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lbl_tel = new JLabel("");
		lbl_tel.setBounds(86, 107, 141, 14);
		panel.add(lbl_tel);
		lbl_tel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lbl_age = new JLabel("");
		lbl_age.setBounds(86, 86, 141, 14);
		panel.add(lbl_age);
		lbl_age.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lbl_prenom = new JLabel("");
		lbl_prenom.setBounds(86, 60, 141, 14);
		panel.add(lbl_prenom);
		lbl_prenom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lbl_nom = new JLabel("");
		lbl_nom.setBounds(86, 35, 141, 14);
		panel.add(lbl_nom);
		lbl_nom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(255, 11, 258, 162);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblMesCatgories = new JLabel("Mes Cat\u00E9gories");
		lblMesCatgories.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMesCatgories.setBounds(10, 11, 119, 22);
		panel_1.add(lblMesCatgories);
		
		JComboBox cmb_lstCat = new JComboBox();
		cmb_lstCat.setBounds(10, 44, 238, 20);
		panel_1.add(cmb_lstCat);
		
		JButton btnAjouterCat = new JButton("Ajouter");
		btnAjouterCat.setBounds(10, 128, 89, 23);
		panel_1.add(btnAjouterCat);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBackground(Color.RED);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(10, 79, 238, 22);
		panel_1.add(lblNewLabel_2);
		
		JButton btnConsulterCalendrier = new JButton("Consulter");
		btnConsulterCalendrier.setBounds(159, 128, 89, 23);
		panel_1.add(btnConsulterCalendrier);
		
		JButton btnDeconnecter = new JButton("Deconnecter");
		btnDeconnecter.setBounds(420, 237, 93, 23);
		contentPane.add(btnDeconnecter);
		
		JLabel lbl_cotisation = new JLabel("");
		lbl_cotisation.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_cotisation.setBounds(257, 198, 256, 23);
		contentPane.add(lbl_cotisation);
	}
}
