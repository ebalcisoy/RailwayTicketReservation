import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

public class MainPage extends JFrame{
	JLabel pic = new JLabel("");
	Timer tm;
    int x = 0;
	static MainPage window;
	DatabaseOperation database;
	String[] list = {
            "/pic1.png",
            "/pic2.png",//1
            "/pic3.png",//2
            "/pic4.png",//3
          };
	public static boolean positioning = false; 
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txtKullancAd;
	private JPasswordField passwordField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	boolean valid,valid1 = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		/*DatabaseOperation database = new DatabaseOperation();
		try {
			database.connectDb();
		} catch (Exception e1) {
			 e1.printStackTrace();
	         System.err.println(e1.getClass().getName()+": "+e1.getMessage());
	         System.exit(0);
		}*/

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new MainPage("");
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainPage(String name) {
	//	initialize(name, surname);
	//}
		
	/**
	 * Initialize the contents of the frame.
	 */
	//private void initialize(String name, String surname) {
		//frame = new JFrame();
		//frame.getContentPane().setBackground(Color.WHITE);
		//frame.getContentPane().setLayout(null);
		
		final Validator pass = new Validator();
		final DatabaseOperation database = new DatabaseOperation();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1340, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(this.getClass().getResource("/tcdd.jpg")));
		label.setBounds(50, 26, 112, 148);
		//frame.getContentPane().add(label);
		contentPane.add(label);
		
		JLabel lblTcddTamaclkA = new JLabel("TCDD TA\u015EIMACILIK A.\u015E");
		lblTcddTamaclkA.setForeground(Color.GRAY);
		lblTcddTamaclkA.setFont(new Font("Arial", Font.PLAIN, 18));
		lblTcddTamaclkA.setBounds(186, 63, 206, 29);
		//frame.getContentPane().add(lblTcddTamaclkA);
		contentPane.add(lblTcddTamaclkA);
		
		JLabel label_1 = new JLabel("GENEL M\u00DCD\u00DCRL\u00DC\u011E\u00DC");
		label_1.setForeground(Color.GRAY);
		label_1.setFont(new Font("Arial", Font.PLAIN, 18));
		label_1.setBounds(186, 91, 206, 29);
		//frame.getContentPane().add(label_1);
		contentPane.add(label_1);
		
		JLabel lblTrke = new JLabel("T\u00FCrk\u00E7e");
		lblTrke.setFont(new Font("Arial", Font.PLAIN, 14));
		lblTrke.setForeground(Color.GRAY);
		lblTrke.setBounds(1160, 63, 46, 17);
		//frame.getContentPane().add(lblTrke);
		contentPane.add(lblTrke);
		
		JLabel label_2 = new JLabel("English");
		label_2.setForeground(Color.GRAY);
		label_2.setFont(new Font("Arial", Font.PLAIN, 14));
		label_2.setBounds(1216, 63, 46, 17);
		//frame.getContentPane().add(label_2);
		contentPane.add(label_2);
		
		pic.setBounds(50, 170, 585, 500);
		//frame.getContentPane().add(pic);
		contentPane.add(pic);
		SetImageSize(0);
		
		tm = new Timer(2500,new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                SetImageSize(x);
                x += 1;
                if(x >= list.length )
                    x = 0; 
            }
        });
        tm.start();
        //frame.getContentPane().setLayout(null);
        contentPane.setLayout(null);
        
        final Panel panel = new Panel();
        panel.setBounds(635, 230, 626, 420);
        //frame.getContentPane().add(panel);
        contentPane.add(panel);
        panel.setLayout(new CardLayout(0, 0));
        
        final Panel panel_1 = new Panel();
        panel.add(panel_1, "name_370060034928581");
        panel_1.setLayout(null);
        
        final JRadioButton rdbtnRezervasyon = new JRadioButton("Rezervasyon");
        final JRadioButton rdbtnSat = new JRadioButton("Sat\u0131\u015F");
        rdbtnSat.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		rdbtnSat.setSelected(true);
        		rdbtnRezervasyon.setSelected(false);
        	}
        });
        rdbtnSat.setForeground(Color.GRAY);
        rdbtnSat.setFont(new Font("Tahoma", Font.PLAIN, 14));
        rdbtnSat.setBackground(Color.WHITE);
        rdbtnSat.setSelected(true);
        rdbtnSat.setBounds(30, 25, 109, 23);
        panel_1.add(rdbtnSat);
        
        
        rdbtnRezervasyon.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		rdbtnSat.setSelected(false);
        		rdbtnRezervasyon.setSelected(true);
        	}
        });
        rdbtnRezervasyon.setForeground(Color.GRAY);
        rdbtnRezervasyon.setFont(new Font("Tahoma", Font.PLAIN, 14));
        rdbtnRezervasyon.setBackground(Color.WHITE);
        rdbtnRezervasyon.setBounds(140, 25, 109, 23);
        panel_1.add(rdbtnRezervasyon);
        
        final JRadioButton rdbtnGididn = new JRadioButton("Gidi\u015F-D\u00F6n\u00FC\u015F");
        final JRadioButton rdbtnTekYn = new JRadioButton("Tek Y\u00F6n");
        rdbtnTekYn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		rdbtnGididn.setSelected(false);
        		rdbtnTekYn.setSelected(true);
        	}
        });
        rdbtnTekYn.setForeground(Color.GRAY);
        rdbtnTekYn.setFont(new Font("Tahoma", Font.PLAIN, 14));
        rdbtnTekYn.setBackground(Color.WHITE);
        rdbtnTekYn.setSelected(true);
        rdbtnTekYn.setBounds(355, 25, 109, 23);
        panel_1.add(rdbtnTekYn);
        
        rdbtnGididn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		rdbtnGididn.setSelected(true);
        		rdbtnTekYn.setSelected(false);
        	}
        });
        rdbtnGididn.setForeground(Color.GRAY);
        rdbtnGididn.setFont(new Font("Tahoma", Font.PLAIN, 14));
        rdbtnGididn.setBackground(Color.WHITE);
        rdbtnGididn.setBounds(490, 25, 109, 23);
        panel_1.add(rdbtnGididn);
        
        JLabel lblNereden = new JLabel("Nereden");
        lblNereden.setForeground(Color.GRAY);
        lblNereden.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNereden.setBounds(35, 75, 68, 25);
        panel_1.add(lblNereden);
        
        JLabel lblNereye = new JLabel("Nereye");
        lblNereye.setForeground(Color.GRAY);
        lblNereye.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNereye.setBounds(360, 75, 68, 23);
        panel_1.add(lblNereye);
        
        textField = new JTextField();
        textField.setBounds(35, 125, 86, 20);
        panel_1.add(textField);
        textField.setColumns(10);
        
        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(360, 125, 86, 20);
        panel_1.add(textField_1);
        
        JLabel lblGidiTarihi = new JLabel("Gidi\u015F Tarihi");
        lblGidiTarihi.setForeground(Color.GRAY);
        lblGidiTarihi.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblGidiTarihi.setBounds(35, 175, 86, 23);
        panel_1.add(lblGidiTarihi);
        
        JLabel lblDnTarihi = new JLabel("D\u00F6n\u00FC\u015F Tarihi");
        lblDnTarihi.setForeground(Color.GRAY);
        lblDnTarihi.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblDnTarihi.setBounds(360, 175, 86, 23);
        panel_1.add(lblDnTarihi);
        
        JFormattedTextField frmtdtxtfldDdmmyyyy = new JFormattedTextField();
        frmtdtxtfldDdmmyyyy.setForeground(Color.GRAY);
        frmtdtxtfldDdmmyyyy.setText("DD.MM.YYYY");
        frmtdtxtfldDdmmyyyy.setBounds(35, 225, 86, 20);
        panel_1.add(frmtdtxtfldDdmmyyyy);
        
        JFormattedTextField formattedTextField = new JFormattedTextField();
        formattedTextField.setForeground(Color.GRAY);
        formattedTextField.setText("DD.MM.YYYY");
        formattedTextField.setBounds(360, 225, 86, 20);
        panel_1.add(formattedTextField);
        
        JLabel lblYolcuSays = new JLabel("Yolcu Say\u0131s\u0131");
        lblYolcuSays.setForeground(Color.GRAY);
        lblYolcuSays.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblYolcuSays.setBounds(35, 275, 86, 23);
        panel_1.add(lblYolcuSays);
        
        JButton btnAra = new JButton("Ara");
        btnAra.setForeground(Color.GRAY);
        btnAra.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnAra.setBounds(35, 375, 58, 23);
        panel_1.add(btnAra);
        
        JComboBox comboBox = new JComboBox();
        comboBox.setForeground(Color.GRAY);
        comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"}));
        comboBox.setToolTipText("");
        comboBox.setBounds(35, 325, 45, 20);
        panel_1.add(comboBox);
        
        final Panel panel_2 = new Panel();
        panel.add(panel_2, "name_370526809521630");
        panel_2.setLayout(null);
        
        JLabel lblEposta = new JLabel("E-Posta");
        lblEposta.setForeground(Color.GRAY);
        lblEposta.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblEposta.setBounds(50, 30, 55, 22);
        panel_2.add(lblEposta);
        
        JLabel lblifre = new JLabel("\u015Eifre");
        lblifre.setForeground(Color.GRAY);
        lblifre.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblifre.setBounds(270, 30, 55, 22);
        panel_2.add(lblifre);
        
        txtKullancAd = new JTextField();
        txtKullancAd.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusLost(FocusEvent e) {
				  valid = pass.email_validate(String.valueOf(txtKullancAd.getText()));
				  if(!valid){
					  JOptionPane.showMessageDialog(null,"      Geçersiz E-Posta Adresi!!\n"
						  		+ "E-Posta adresinizi kontrol ediniz.");
				  }
        	}
        });
        
        txtKullancAd.setBackground(Color.WHITE);
        txtKullancAd.setForeground(Color.GRAY);
        txtKullancAd.setFont(new Font("Tahoma", Font.PLAIN, 14));
        txtKullancAd.setBounds(50, 70, 160, 20);
        panel_2.add(txtKullancAd);
        txtKullancAd.setColumns(10);
        
        passwordField_2 = new JPasswordField();
        passwordField_2.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusLost(FocusEvent e) {
				  valid1 = pass.password_validate(String.valueOf(passwordField_2.getPassword()));
				  if(!valid1)
					  JOptionPane.showMessageDialog(null,"                                                 "
					  		+ "Geçersiz Þifre!!\n"
					  		+ "Þifreniz en az bir rakam, büyük harf, küçük harf ve özel karakter içermelidir.");
        	}
        });
        passwordField_2.setBackground(Color.WHITE);
        passwordField_2.setForeground(Color.GRAY);
        passwordField_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        passwordField_2.setColumns(10);
        passwordField_2.setBounds(270, 70, 160, 20);
        panel_2.add(passwordField_2);
        
        JLabel lblyelik = new JLabel("\u00DCyelik");
        lblyelik.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		window.setVisible(false);
        		Registration reg = new Registration();
        		reg.setVisible(true);
        	}
        });
        lblyelik.setForeground(Color.GRAY);
        lblyelik.setFont(new Font("Tahoma", Font.PLAIN, 11));
        lblyelik.setBounds(50, 110, 46, 14);
        panel_2.add(lblyelik);
        
        JLabel lblParolamUnuttum = new JLabel("Parolam\u0131 Unuttum?");
        lblParolamUnuttum.setForeground(Color.GRAY);
        lblParolamUnuttum.setFont(new Font("Tahoma", Font.PLAIN, 11));
        lblParolamUnuttum.setBounds(115, 110, 100, 14);
        panel_2.add(lblParolamUnuttum);
        
        JButton btnyeGirii = new JButton("\u00DCye Giri\u015Fi");
        btnyeGirii.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(valid && valid1){
        			String user_control = database.validateUser(txtKullancAd.getText(),String.valueOf(passwordField_2.getPassword()));
        			if(!user_control.equals("")){
        				positioning = true;
        				setVisible(false);
        				MainPage mn = new MainPage("SAYIN " + user_control);
        				mn.setVisible(true);
        			}
        			else if(user_control.equals(""))
        				JOptionPane.showMessageDialog(null,"Giriþ Bilgilerinizi Kontrol Ediniz!!");
        		}
        	}
        });
        btnyeGirii.setForeground(Color.GRAY);
        btnyeGirii.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        btnyeGirii.setBounds(50, 142, 100, 23);
        panel_2.add(btnyeGirii);
        
        final Panel panel_3 = new Panel();
        panel.add(panel_3, "name_370535290377620");
        panel_3.setLayout(null);
        
        JLabel lblIstasyon = new JLabel("\u0130stasyon");
        lblIstasyon.setForeground(Color.GRAY);
        lblIstasyon.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblIstasyon.setBounds(50, 25, 64, 22);
        panel_3.add(lblIstasyon);
        
        textField_3 = new JTextField();
        textField_3.setBounds(50, 62, 86, 20);
        panel_3.add(textField_3);
        textField_3.setColumns(10);
        
        JLabel lblTarih = new JLabel("Tarih");
        lblTarih.setForeground(Color.GRAY);
        lblTarih.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblTarih.setBounds(50, 97, 46, 14);
        panel_3.add(lblTarih);
        
        textField_4 = new JTextField();
        textField_4.setBounds(50, 132, 86, 20);
        panel_3.add(textField_4);
        textField_4.setColumns(10);
        
        JButton btnIstasyontrenBilgileri = new JButton("\u0130stasyon-Tren Bilgileri");
        btnIstasyontrenBilgileri.setForeground(Color.GRAY);
        btnIstasyontrenBilgileri.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnIstasyontrenBilgileri.setBounds(50, 177, 169, 23);
        panel_3.add(btnIstasyontrenBilgileri);
        
        Panel panel_4 = new Panel();
        panel_4.setBounds(635, 170, 627, 61);
        //frame.getContentPane().add(panel_4);
        contentPane.add(panel_4);
        panel_4.setLayout(null);
        
        final JLabel lblIstasyontrenBilgileri = new JLabel("\u0130stasyon-Tren Bilgileri");
        final JLabel lblyeGirii = new JLabel("\u00DCye Giri\u015Fi");
        final JLabel lblBilet = new JLabel("Bilet");
        lblBilet.setForeground(Color.BLUE);
        lblBilet.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		lblBilet.setForeground(Color.BLUE);
        		lblyeGirii.setForeground(Color.GRAY);
        		lblIstasyontrenBilgileri.setForeground(Color.GRAY);
        		panel.removeAll();
        		panel.repaint();;
        		panel.revalidate();
        		
        		panel.add(panel_1);
        		panel.repaint();
        		panel.revalidate();
        	}
        });
        lblBilet.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblBilet.setBounds(59, 24, 46, 26);
        panel_4.add(lblBilet);
        
        
        lblyeGirii.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		lblyeGirii.setForeground(Color.BLUE);
        		lblBilet.setForeground(Color.GRAY);
        		lblIstasyontrenBilgileri.setForeground(Color.GRAY);
        		panel.removeAll();
        		panel.repaint();;
        		panel.revalidate();
        		
        		panel.add(panel_2);
        		panel.repaint();
        		panel.revalidate();
        	}
        });
        lblyeGirii.setForeground(Color.GRAY);
        lblyeGirii.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblyeGirii.setBounds(131, 24, 73, 26);
        panel_4.add(lblyeGirii);
        
        
        lblIstasyontrenBilgileri.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		lblIstasyontrenBilgileri.setForeground(Color.BLUE);
        		lblBilet.setForeground(Color.GRAY);
        		lblyeGirii.setForeground(Color.GRAY);
        		panel.removeAll();
        		panel.repaint();;
        		panel.revalidate();
        		
        		panel.add(panel_3);
        		panel.repaint();
        		panel.revalidate();
        	}
        });
        lblIstasyontrenBilgileri.setForeground(Color.GRAY);
        lblIstasyontrenBilgileri.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblIstasyontrenBilgileri.setBounds(227, 24, 140, 26);
        panel_4.add(lblIstasyontrenBilgileri);
        
        final JLabel lblBiletlerim = new JLabel("Biletlerim");
        lblBiletlerim.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblBiletlerim.setForeground(Color.GRAY);
        //lblBiletlerim.setBounds(994, 83, 60, 20);
        //frame.getContentPane().add(lblBiletlerim);
        contentPane.add(lblBiletlerim);
        
        final JLabel lblRezervasyonlarm = new JLabel("Rezervasyonlar\u0131m");
        lblRezervasyonlarm.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblRezervasyonlarm.setForeground(Color.GRAY);
        //lblRezervasyonlarm.setBounds(1064, 83, 114, 20);
        //frame.getContentPane().add(lblRezervasyonlarm);
        contentPane.add(lblRezervasyonlarm);
        
        final JLabel lblAkBiletlerim = new JLabel("A\u00E7\u0131k Biletlerim");
        lblAkBiletlerim.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblAkBiletlerim.setForeground(Color.GRAY);
        //lblAkBiletlerim.setBounds(1183, 83, 87, 20);
        //frame.getContentPane().add(lblAkBiletlerim);
        contentPane.add(lblAkBiletlerim);
        
        final JLabel lblAaaa = new JLabel("");
        lblAaaa.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblAaaa.setForeground(Color.BLUE);
        //lblAaaa.setBounds(803, 83, 170, 20);
        lblAaaa.setText(name.toUpperCase());
        //frame.getContentPane().add(lblAaaa);
        contentPane.add(lblAaaa);
        
        final JLabel lblk = new JLabel("");
        lblk.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		positioning = false;
        		lblAaaa.setBounds(803, 83, 170, 20);
    			lblAaaa.setText("");
    			lblBiletlerim.setBounds(994, 83, 60, 20);
    			lblRezervasyonlarm.setBounds(1064, 83, 114, 20);
    			lblAkBiletlerim.setBounds(1183, 83, 87, 20);
    			lblk.setBounds(1268, 83, 35, 20);
    			lblk.setText("");
        	}
        });
        lblk.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblk.setForeground(Color.GRAY);
        //lblk.setBounds(1268, 83, 35, 20);
        contentPane.add(lblk);
        
        if(!positioning){
			lblAaaa.setBounds(803, 83, 170, 20);
			lblAaaa.setText("");
			lblBiletlerim.setBounds(994, 83, 60, 20);
			lblRezervasyonlarm.setBounds(1064, 83, 114, 20);
			lblAkBiletlerim.setBounds(1183, 83, 87, 20);
			lblk.setBounds(1268, 83, 35, 20);
			lblk.setText("");
		}
		else if(positioning){
			lblAaaa.setBounds(764, 83, 170, 20);
			lblBiletlerim.setBounds(955, 83, 60, 20);
			lblRezervasyonlarm.setBounds(1025, 83, 114, 20);
			lblAkBiletlerim.setBounds(1144, 83, 87, 20);
			lblk.setBounds(1236, 83, 35, 20);
			lblk.setText("Çýkýþ");
		}
        
		//frame.setBounds(100, 100, 1340, 720);
		//frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public void SetImageSize(int i){
        ImageIcon icon = new ImageIcon(this.getClass().getResource(list[i]));
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(pic.getWidth(), pic.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon newImc = new ImageIcon(newImg);
        pic.setIcon(newImc);
    }
}
