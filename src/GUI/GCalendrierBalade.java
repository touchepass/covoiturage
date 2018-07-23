package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import Classe.CBalade;
import Classe.CCalendrier;
import Classe.CCategorie;
import Classe.CMembre;
import Classe.CVehicule;
import DAO.DBalade;
import DAO.DCalendrier;
import DAO.DVehicule;

import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GCalendrierBalade extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private CMembre cm;
	private CCategorie ca;
	private CCalendrier cl;
	private GAccueilMembre ga;
	
	private DCalendrier dc = new DCalendrier();
	
	private JTextField txt_place_assise;
	private JTextField txt_place_velo;
	private JTextField txt_imma;
	
	private JLabel lbl_tarif;
	private JLabel lbl_localite;
	private JLabel lbl_numRue;
	private JLabel lbl_rue;
	private JLabel lbl_cp;
	private JLabel lbl_date;
	private JLabel lbl_err;
	
	private JComboBox<CBalade> cmb_balade;
	private JComboBox<CVehicule> cmb_voiture ;
	

	/**
	 * Create the frame.
	 */
	public GCalendrierBalade(Rectangle rectangle, CMembre cm, CCategorie ca, GAccueilMembre ga) {
		this.ga = ga;
		this.ca = ca;
		this.cm = cm;
		this.cl = dc.find(ca.getNom());
		initialize(rectangle);
	}
	
	private void initialize(Rectangle rectangle) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds((int)rectangle.getX(), (int)rectangle.getY(), 600, 374);
		JPanel btn_retour = new JPanel();
		btn_retour.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(btn_retour);
		btn_retour.setLayout(null);
		
		JLabel lbl_nom = new JLabel(ca.getNom());
		lbl_nom.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_nom.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_nom.setBounds(211, 20, 200, 22);
		btn_retour.add(lbl_nom);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(281, 53, 293, 197);
		btn_retour.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Balades pr\u00E9vues");
		lblNewLabel.setBounds(90, 5, 113, 20);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		cmb_balade = new JComboBox<CBalade>();
		cmb_balade.setBounds(10, 36, 273, 20);
		panel.add(cmb_balade);
		cmbBaladeInit();
		
		JLabel lblNewLabel_1 = new JLabel("Adresse");
		lblNewLabel_1.setBounds(10, 67, 58, 23);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel label = new JLabel(":");
		label.setBounds(78, 67, 18, 23);
		panel.add(label);
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		lbl_numRue = new JLabel("");
		lbl_numRue.setBounds(90, 67, 41, 23);
		panel.add(lbl_numRue);
		lbl_numRue.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel label_3 = new JLabel(",");
		label_3.setBounds(133, 67, 18, 23);
		panel.add(label_3);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		lbl_rue = new JLabel("");
		lbl_rue.setBounds(141, 67, 142, 23);
		panel.add(lbl_rue);
		lbl_rue.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		lbl_cp = new JLabel("");
		lbl_cp.setBounds(90, 101, 41, 23);
		panel.add(lbl_cp);
		lbl_cp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel label_5 = new JLabel(",");
		label_5.setBounds(133, 101, 18, 23);
		panel.add(label_5);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		lbl_localite = new JLabel("");
		lbl_localite.setBounds(143, 101, 140, 23);
		panel.add(lbl_localite);
		lbl_localite.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblosef = new JLabel("Date");
		lblosef.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblosef.setBounds(10, 131, 58, 23);
		panel.add(lblosef);
		
		JLabel label_1 = new JLabel(":");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_1.setBounds(78, 131, 18, 23);
		panel.add(label_1);
		
		lbl_date = new JLabel("");
		lbl_date.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_date.setBounds(90, 131, 142, 23);
		panel.add(lbl_date);
		
		JLabel lblcpa = new JLabel("Tarif");
		lblcpa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblcpa.setBounds(10, 165, 58, 23);
		panel.add(lblcpa);
		
		JLabel label_4 = new JLabel(":");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_4.setBounds(78, 165, 18, 23);
		panel.add(label_4);
		
		lbl_tarif = new JLabel("");
		lbl_tarif.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_tarif.setBounds(90, 165, 142, 23);
		panel.add(lbl_tarif);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(10, 53, 261, 247);
		btn_retour.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblVhiculesDisponnibles = new JLabel("V\u00E9hicules disponnibles");
		lblVhiculesDisponnibles.setBounds(51, 5, 159, 20);
		panel_1.add(lblVhiculesDisponnibles);
		lblVhiculesDisponnibles.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		cmb_voiture = new JComboBox<CVehicule>();
		cmb_voiture.setBounds(10, 34, 241, 20);
		panel_1.add(cmb_voiture);
		cmbVoitureInit();
		
		JButton btn_inscription = new JButton("\u00EAtre passager");
		btn_inscription.setBounds(10, 65, 127, 23);
		panel_1.add(btn_inscription);
		
		JButton btn_proposer = new JButton("Se proposer");
		btn_proposer.setBounds(138, 213, 113, 23);
		panel_1.add(btn_proposer);
		
		JLabel lbl_place_assise = new JLabel("Place assise");
		lbl_place_assise.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_place_assise.setBounds(10, 99, 75, 23);
		panel_1.add(lbl_place_assise);
		
		JLabel label_7 = new JLabel(":");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_7.setBounds(111, 99, 18, 23);
		panel_1.add(label_7);
		
		JLabel lbl_place_velo = new JLabel("Place v\u00E9lo");
		lbl_place_velo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_place_velo.setBounds(10, 129, 75, 23);
		panel_1.add(lbl_place_velo);
		
		JLabel label_8 = new JLabel(":");
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_8.setBounds(111, 129, 18, 23);
		panel_1.add(label_8);
		
		JLabel lbl_imma = new JLabel("Immatriculation");
		lbl_imma.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_imma.setBounds(10, 163, 100, 23);
		panel_1.add(lbl_imma);
		
		JLabel label_9 = new JLabel(":");
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_9.setBounds(111, 163, 18, 23);
		panel_1.add(label_9);
		
		txt_place_assise = new JTextField();
		txt_place_assise.setBounds(124, 102, 127, 20);
		panel_1.add(txt_place_assise);
		txt_place_assise.setColumns(10);
		
		txt_place_velo = new JTextField();
		txt_place_velo.setColumns(10);
		txt_place_velo.setBounds(124, 133, 127, 20);
		panel_1.add(txt_place_velo);
		
		txt_imma = new JTextField();
		txt_imma.setColumns(10);
		txt_imma.setBounds(124, 166, 127, 20);
		panel_1.add(txt_imma);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				retour();
			}
		});
		btnRetour.setBounds(474, 301, 100, 23);
		btn_retour.add(btnRetour);
		
		lbl_err = new JLabel("");
		lbl_err.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbl_err.setForeground(Color.RED);
		lbl_err.setBounds(281, 263, 293, 27);
		btn_retour.add(lbl_err);
		
		affichageTxt();
	}
	
	private void cmbBaladeInit() {
		DBalade db = new DBalade();
		ArrayList<CBalade> lst_ba = db.find(cl.getIDCalendrier());
		
		for(CBalade cb : lst_ba) {
			cmb_balade.addItem(cb);
		}
	}
	
	private void cmbVoitureInit() {
		DVehicule dv = new DVehicule();
		if(cmb_balade.getItemCount()>0) {
			CBalade cb = (CBalade) cmb_balade.getSelectedItem();
			ArrayList<CVehicule> lst_cv =dv.find(cb.getIDBalade());
			
			for(CVehicule cv : lst_cv) {
				cmb_voiture.addItem(cv);
			}
		}
	}
	
	public void affichageTxt(){
		
		if(cmb_balade.getItemCount()>0) {
			CBalade cb = (CBalade) cmb_balade.getSelectedItem();
			
			lbl_tarif.setText(Integer.toString(cb.getForfait()));
			lbl_localite.setText(cb.getLocalite());
			lbl_numRue.setText(cb.getNumRue());
			lbl_rue.setText(cb.getRue());
			lbl_cp.setText(Integer.toString(cb.getCp()));
			lbl_date.setText(cb.getDateD().toString());
		}
		else {
			lbl_err.setText("Aucune balade de prévue!");
		}
		
	}
	
	private void retour() {
		ga.retourVersGAccueilMembre(this.getBounds());
		this.dispose();
	}
}
