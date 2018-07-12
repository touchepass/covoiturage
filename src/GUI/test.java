package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.border.CompoundBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class test extends JFrame {

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
					test frame = new test();
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
	public test() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
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
		btnCestParti.setBounds(271, 177, 89, 23);
		contentPane.add(btnCestParti);
		
		txtErreur = new JLabel("");
		txtErreur.setForeground(Color.RED);
		txtErreur.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtErreur.setBounds(10, 227, 414, 23);
		contentPane.add(txtErreur);
	}
	
	private void seConnecter() {
		if(!checkVide()) {
			System.out.println("pas vide");
		}
		else {
			txtErreur.setText("Erreur : Entrez vos identifiants en premier lieu.");
		}
	}
	
	private boolean checkVide() {
		
		if(txtPseudo.getText().length() < 1 || txtPass.getText().length() <1) {
			return true;
		}
	
		return false;
	}
}
