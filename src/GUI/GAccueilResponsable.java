package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Classe.CBalade;
import Classe.CCalendrier;
import Classe.CResponsable;
import DAO.DAO;
import DAO.DBalade;
import DAO.DCalendrier;

@SuppressWarnings("serial")
public class GAccueilResponsable extends JFrame {

	private JPanel contentPane;
	private CResponsable cr;
	private JTextField txtRue;
	private JTextField txtNum;
	private JTextField txtCp;
	private JTextField txtLocalite;
	private JTextField txtDateJ;
	private JTextField txtForfait;
	private JComboBox<CBalade> cmbBalade;
	private CCalendrier cc;
	private JTextField txtDateM;
	private JTextField txtDateA;
	private JLabel lblErr;
	

	/**
	 * Create the frame.
	 */
	public GAccueilResponsable(Rectangle rectangle, CResponsable cr) {
		this.cr = cr;
		DAO<CCalendrier> dc = new DCalendrier();
		this.cc = dc.find(cr.getCat().getNom());
		initialize(rectangle);
	}
	
	private void initialize(Rectangle rectangle) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds((int)rectangle.getX(), (int)rectangle.getY(), 350, 459);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(10, 42, 314, 366);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Balades pr\u00E9vues :");
		lblNewLabel_1.setBounds(10, 11, 139, 22);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		cmbBalade = new JComboBox<CBalade>();
		cmbBalade.setBounds(10, 44, 294, 20);
		panel_1.add(cmbBalade);
		initcmbBalade();
		
		JLabel lblNouvelleBalade = new JLabel("Nouvelle Balade :");
		lblNouvelleBalade.setBounds(10, 75, 139, 22);
		panel_1.add(lblNouvelleBalade);
		lblNouvelleBalade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblRue = new JLabel("Rue");
		lblRue.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRue.setBounds(10, 108, 64, 22);
		panel_1.add(lblRue);
		
		JLabel lblNumero = new JLabel("Num\u00E9ro");
		lblNumero.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNumero.setBounds(10, 135, 64, 22);
		panel_1.add(lblNumero);
		
		JLabel lblCodePostal = new JLabel("Code postal");
		lblCodePostal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCodePostal.setBounds(10, 168, 64, 22);
		panel_1.add(lblCodePostal);
		
		JLabel lblLocalite = new JLabel("Localite");
		lblLocalite.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLocalite.setBounds(10, 201, 64, 22);
		panel_1.add(lblLocalite);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDate.setBounds(10, 234, 64, 22);
		panel_1.add(lblDate);
		
		JLabel lblForfait = new JLabel("Forfait");
		lblForfait.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblForfait.setBounds(10, 267, 64, 22);
		panel_1.add(lblForfait);
		
		JLabel label = new JLabel(":");
		label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label.setBounds(84, 108, 16, 22);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel(":");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_1.setBounds(84, 135, 16, 22);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel(":");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_2.setBounds(84, 168, 16, 22);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel(":");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_3.setBounds(84, 201, 16, 22);
		panel_1.add(label_3);
		
		JLabel label_4 = new JLabel(":");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_4.setBounds(84, 234, 16, 22);
		panel_1.add(label_4);
		
		JLabel label_5 = new JLabel(":");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_5.setBounds(84, 267, 16, 22);
		panel_1.add(label_5);
		
		txtRue = new JTextField();
		txtRue.setBounds(110, 110, 194, 20);
		panel_1.add(txtRue);
		txtRue.setColumns(10);
		
		txtNum = new JTextField();
		txtNum.setColumns(10);
		txtNum.setBounds(110, 137, 194, 20);
		panel_1.add(txtNum);
		
		txtCp = new JTextField();
		txtCp.setColumns(10);
		txtCp.setBounds(110, 170, 194, 20);
		panel_1.add(txtCp);
		
		txtLocalite = new JTextField();
		txtLocalite.setColumns(10);
		txtLocalite.setBounds(110, 203, 194, 20);
		panel_1.add(txtLocalite);
		
		txtDateJ = new JTextField();
		txtDateJ.setText("JJ");
		txtDateJ.setColumns(10);
		txtDateJ.setBounds(110, 236, 44, 20);
		panel_1.add(txtDateJ);
		
		txtForfait = new JTextField();
		txtForfait.setColumns(10);
		txtForfait.setBounds(110, 269, 194, 20);
		panel_1.add(txtForfait);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ajouterBalade();
			}
		});
		btnAjouter.setBounds(10, 331, 89, 23);
		panel_1.add(btnAjouter);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				supprimerBalade();
			}
		});
		btnSupprimer.setBounds(203, 13, 101, 23);
		panel_1.add(btnSupprimer);
		
		JButton btnDeconnecter = new JButton("Deconnecter");
		btnDeconnecter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				deconnection();
			}
		});
		btnDeconnecter.setBounds(164, 331, 140, 23);
		panel_1.add(btnDeconnecter);
		
		txtDateM = new JTextField();
		txtDateM.setText("MM");
		txtDateM.setColumns(10);
		txtDateM.setBounds(164, 236, 44, 20);
		panel_1.add(txtDateM);
		
		txtDateA = new JTextField();
		txtDateA.setText("AAAA");
		txtDateA.setColumns(10);
		txtDateA.setBounds(218, 236, 86, 20);
		panel_1.add(txtDateA);
		
		lblErr = new JLabel("");
		lblErr.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblErr.setBounds(10, 300, 294, 20);
		panel_1.add(lblErr);
		
		JLabel lblNewLabel = new JLabel("Responsable");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 11, 97, 20);
		getContentPane().add(lblNewLabel);
		
		JLabel lblCatResp = new JLabel(cr.getCat().getNom());
		lblCatResp.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCatResp.setBounds(105, 11, 219, 20);
		contentPane.add(lblCatResp);
		
		
	}
	
	private void initcmbBalade() {
		ArrayList <CBalade> lstBalade = cc.getLstBalade();
		for(CBalade cb : lstBalade) {
			cmbBalade.addItem(cb);
		}
	}
	
	private void supprimerBalade() {
		if(cmbBalade.getItemCount()>0) {
			DAO<CBalade> db = new DBalade();
			CBalade cb = (CBalade)cmbBalade.getSelectedItem();
			if(db.delete(cb)) {
				cmbBalade.removeItem(cb);
				cc.supprimerBalade(cb);
			}
		}
	}
	
	
	private void ajouterBalade() {
		DAO<CBalade> db = new DBalade();
		DAO<CCalendrier> dc = new DCalendrier();
		
		
		if(	!txtRue.getText().isEmpty() && !txtNum.getText().isEmpty() && !txtCp.getText().isEmpty() && !txtLocalite.getText().isEmpty() && 
			!txtForfait.getText().isEmpty() && !txtDateJ.getText().isEmpty() && !txtDateM.getText().isEmpty() && !txtDateA.getText().isEmpty()) {
			
			try {
				 
				String date = txtDateA.getText()+"-"+txtDateM.getText()+"-"+txtDateJ.getText();
				Date dt = (new SimpleDateFormat("yyyy-MM-dd")).parse(date);
	
				CBalade cb = new CBalade(txtRue.getText(),txtNum.getText(),txtLocalite.getText(),Integer.parseInt(txtCp.getText()),dt,Integer.parseInt(txtForfait.getText()));
				
				if( db.create(cb) ) {
					cc.ajouterBalade(cb);
					dc.update(cc);
					
					cmbBalade.addItem(cb);
					lblErr.setForeground(Color.BLACK);
					lblErr.setText("Enregistrement effectué!");
				}
			}
			catch(Exception e) {
				lblErr.setForeground(Color.RED);
				lblErr.setText("Erreur dans l'enregistrement! vérifiez les champs");
			}	
		}
		else {
			lblErr.setForeground(Color.RED);
			lblErr.setText("Champs incomplets!");
		}
	}
	
	private void deconnection() {
		GLogin frame = new GLogin(this.getBounds());
		frame.setVisible(true);
		this.dispose();
	}
}
