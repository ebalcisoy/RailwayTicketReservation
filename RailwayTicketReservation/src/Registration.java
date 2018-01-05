import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.*;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JPasswordField;

public class Registration extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField txtDdmmyyyy;
	private JTextField textField_8;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	boolean valid,valid1,valid2,valid3,valid4,valid5,valid6,valid7,valid8,valid9,valid10 = false;
	String flag = "";
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration frame = new Registration();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public Registration() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1340, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u00DCyelik Bilgilerim");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(50, 200, 138, 22);
		contentPane.add(lblNewLabel);
		
		JLabel lblEposta = new JLabel("E-Posta");
		lblEposta.setForeground(Color.GRAY);
		lblEposta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEposta.setBounds(50, 250, 66, 22);
		contentPane.add(lblEposta);
		
		JLabel lblifre = new JLabel("\u015Eifre");
		lblifre.setForeground(Color.GRAY);
		lblifre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblifre.setBounds(50, 280, 46, 22);
		contentPane.add(lblifre);
		
		JLabel lblifreTekrar = new JLabel("\u015Eifre Tekrar");
		lblifreTekrar.setForeground(Color.GRAY);
		lblifreTekrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblifreTekrar.setBounds(50, 310, 81, 22);
		contentPane.add(lblifreTekrar);
		
		JLabel lblUyruk = new JLabel("Uyruk");
		lblUyruk.setForeground(Color.GRAY);
		lblUyruk.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUyruk.setBounds(50, 340, 46, 22);
		contentPane.add(lblUyruk);
		
		JLabel lblTcKimlikNo = new JLabel("TC Kimlik No");
		lblTcKimlikNo.setForeground(Color.GRAY);
		lblTcKimlikNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTcKimlikNo.setBounds(50, 370, 93, 22);
		contentPane.add(lblTcKimlikNo);
		
		JLabel lblPasaportNo = new JLabel("Pasaport No");
		lblPasaportNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPasaportNo.setForeground(Color.GRAY);
		lblPasaportNo.setBounds(50, 400, 81, 22);
		contentPane.add(lblPasaportNo);
		
		JLabel lblAdSoyad = new JLabel("Ad");
		lblAdSoyad.setForeground(Color.GRAY);
		lblAdSoyad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAdSoyad.setBounds(810, 250, 23, 22);
		contentPane.add(lblAdSoyad);
		
		JLabel lblSoyad = new JLabel("Soyad");
		lblSoyad.setForeground(Color.GRAY);
		lblSoyad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSoyad.setBounds(810, 280, 46, 22);
		contentPane.add(lblSoyad);
		
		JLabel lblDoumTarihi = new JLabel("Do\u011Fum Tarihi");
		lblDoumTarihi.setForeground(Color.GRAY);
		lblDoumTarihi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDoumTarihi.setBounds(810, 310, 93, 22);
		contentPane.add(lblDoumTarihi);
		
		JLabel lblCinsiyet = new JLabel("Cinsiyet");
		lblCinsiyet.setForeground(Color.GRAY);
		lblCinsiyet.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCinsiyet.setBounds(810, 340, 66, 22);
		contentPane.add(lblCinsiyet);
		
		JLabel lblCepTelefonu = new JLabel("Cep Telefonu");
		lblCepTelefonu.setForeground(Color.GRAY);
		lblCepTelefonu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCepTelefonu.setBounds(810, 370, 93, 22);
		contentPane.add(lblCepTelefonu);
		
		textField = new JTextField();
		textField.setBackground(Color.WHITE);
		textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				Validator pass = new Validator();
				  valid = pass.email_validate(String.valueOf(textField.getText()));
				  if(!valid)
					  JOptionPane.showMessageDialog(null,"      Geçersiz E-Posta Adresi!!\n"
					  		+ "E-Posta adresinizi kontrol ediniz.");
			}
		});
		textField.setBounds(350, 253, 160, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				valid2 = false;
				Validator pass = new Validator();
				  valid1 = pass.ssn_validate(String.valueOf(textField_3.getText()));
				  if(!valid1)
					  JOptionPane.showMessageDialog(null,"                      Geçersiz Kimlik Numarasý!!\n"
					  		+ "Kimlik numarasý sadece 11 rakamdan oluþmalýdýr.");
			}
		});
		textField_3.setBounds(350, 373, 160, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				valid1 = false;
				Validator pass = new Validator();
				  valid2 = pass.passport_validate(String.valueOf(textField_4.getText()));
				  if(!valid2)
					  JOptionPane.showMessageDialog(null,"     Geçersiz Pasaport Numarasý!!\n"
					  		+ "Pasaport numaranýzý kontrol ediniz.");
			}
		});
		textField_4.setBounds(350, 403, 160, 20);
		textField_4.setEnabled(false);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedIndex() == 0 || comboBox.getSelectedIndex() == -1){
					textField_4.setEnabled(false);
					textField_3.setEnabled(true);
				}
				else{
					textField_3.setEnabled(false);
					textField_4.setEnabled(true);
				}
			}
		});
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBox.setForeground(Color.DARK_GRAY);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"T\u00FCrkiye", "Uruguay", "\u015Eili", "Fransa", "Suriye", "Azerbaycan", "Almanya", "Bel\u00E7ika", "Brazilya", "Filistin"}));
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(350, 343, 104, 20);
		contentPane.add(comboBox);
		
		textField_5 = new JTextField();
		textField_5.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				Validator pass = new Validator();
				  valid3 = pass.name_validate(String.valueOf(textField_5.getText()));
				  if(!valid3)
					  JOptionPane.showMessageDialog(null,"              Geçersiz ad girdiniz!!\n"
					  		+ "Adýnýz sadece harflerden oluþmalýdýr.");
			}
		});
		textField_5.setBounds(1110, 250, 160, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				Validator pass = new Validator();
				  valid4 = pass.surname_validate(String.valueOf(textField_6.getText()));
				  if(!valid4)
					  JOptionPane.showMessageDialog(null,"              Geçersiz soyad girdiniz!!\n"
					  		+ "Soyadýnýz sadece harflerden oluþmalýdýr.");
			}
		});
		textField_6.setBounds(1110, 280, 160, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		txtDdmmyyyy = new JTextField();
		txtDdmmyyyy.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				Validator pass = new Validator();
				  valid5 = pass.date_validate(String.valueOf(txtDdmmyyyy.getText()));
				  if(!valid5)
					  JOptionPane.showMessageDialog(null,"      Doðum tarihinizi yanlýþ girdiniz!!\n"
					  		+ "Lütfen doðum tarihinizi kontrol ediniz.");
			}
		});
		txtDdmmyyyy.setForeground(Color.GRAY);
		txtDdmmyyyy.setText("DD.MM.YYYY");
		txtDdmmyyyy.setBounds(1110, 310, 160, 20);
		contentPane.add(txtDdmmyyyy);
		txtDdmmyyyy.setColumns(10);
		
		final JRadioButton rdbtnErkek = new JRadioButton("Kad\u0131n");
		final JRadioButton rdbtnErkek_1 = new JRadioButton("Erkek");
		rdbtnErkek.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnErkek.setSelected(true);
				rdbtnErkek_1.setSelected(false);
			}
		});
		rdbtnErkek.setBackground(Color.WHITE);
		rdbtnErkek.setForeground(Color.GRAY);
		rdbtnErkek.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnErkek.setBounds(1110, 340, 80, 22);
		contentPane.add(rdbtnErkek);
		
		rdbtnErkek_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnErkek.setSelected(false);
				rdbtnErkek_1.setSelected(true);
			}
		});
		rdbtnErkek_1.setBackground(Color.WHITE);
		rdbtnErkek_1.setForeground(Color.GRAY);
		rdbtnErkek_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnErkek_1.setBounds(1190, 340, 80, 22);
		contentPane.add(rdbtnErkek_1);
		
		textField_8 = new JTextField();
		textField_8.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				Validator pass = new Validator();
				  valid6 = pass.telephone_validate(String.valueOf(textField_8.getText()));
				  if(!valid6)
					  JOptionPane.showMessageDialog(null,"                     Geçersiz Telefon Numarasý!!\n"
					  		+ "Telefon numarasý sadece 10 rakamdan oluþmalýdýr.");
			}
		});
		textField_8.setBounds(1110, 370, 160, 20);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		final JLabel label_1 = new JLabel("");
		JButton btnTemizle = new JButton("Temizle");
		btnTemizle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				passwordField.setText("");
				passwordField_1.setText("");
				comboBox.setSelectedIndex(0);
				textField_3.setText("");
				textField_4.setText("");
				textField_4.setEnabled(false);
				label_1.setText("");
				textField_5.setText("");
				textField_6.setText("");
				txtDdmmyyyy.setText("DD.MM.YYYY");
				textField_8.setText("");
				rdbtnErkek.setSelected(false);
				rdbtnErkek_1.setSelected(false);
			}
		});
		btnTemizle.setForeground(Color.DARK_GRAY);
		btnTemizle.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTemizle.setBounds(1050, 450, 89, 23);
		contentPane.add(btnTemizle);
		
		JButton btnKaydet = new JButton("Kaydet");
		btnKaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Properties props = new Properties();
				props.put("mail.smtp.host", "smtp.gmail.com");
				props.put("mail.smtp.socketFactory.port", "465");
				props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
				props.put("mail.smtp.auth","true");
				props.put("mail.smtp.port","465");
				
				Session session = Session.getDefaultInstance(props,
						new javax.mail.Authenticator(){
							protected PasswordAuthentication getPasswordAuthentication(){
								return new PasswordAuthentication("ebalcisoy@gmail.com","34498453482");
							}
						}
						
						);
				
				try{
					if(valid && (valid1 || valid2) && valid3 && valid4 && valid5 && valid6 && valid7 && (rdbtnErkek.isSelected() || rdbtnErkek_1.isSelected()) && !flag.equals("")){
						DatabaseOperation database = new DatabaseOperation();
						if(database.validateUser(textField.getText(), "duplicate").equals("")){
							Message message = new MimeMessage(session);
							message.setFrom(new InternetAddress("ebalcisoy@gmail.com"));
							message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(textField.getText()));
							message.setSubject("TCDD Kayýt Ýþlemi");
							message.setText("Kayýt iþleminiz baþarýyla tamamlanmýþtýr.\n"
									+ "Sisteme giriþ yaparken aþaðýdaki e-posta adresi ve þifre bilgilerini kullanýnýz.\n\n"
									+ "E-Posta : " + textField.getText() + "\n"
									+ "Þifre : " + String.valueOf(passwordField.getPassword()));
							Transport.send(message);
							database.insertUser(textField.getText(),String.valueOf(passwordField.getPassword()),(String)comboBox.getSelectedItem(),
									textField_3.getText(),textField_4.getText(),textField_5.getText(),textField_6.getText(),textField_8.getText(),
									rdbtnErkek.isSelected(),rdbtnErkek_1.isSelected(),txtDdmmyyyy.getText());
							JOptionPane.showMessageDialog(null, "Girmiþ olduðunuz bilgileri kullanarak sistemde oturum açabilirsiniz.");
							setVisible(false);
							MainPage main = new MainPage("");
							main.setVisible(true);
						}
						else
							JOptionPane.showMessageDialog(null, "Bu eposta adresine ait hesap bulunmaktadýr!!");
					}
					else
						JOptionPane.showMessageDialog(null, "Eksik kýsýmlarý doldurunuz!!");
				}catch(Exception ex){
					JOptionPane.showMessageDialog(null,ex);
				}
				
			}
		});
		btnKaydet.setForeground(Color.DARK_GRAY);
		btnKaydet.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnKaydet.setBounds(1181, 450, 89, 23);
		contentPane.add(btnKaydet);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(this.getClass().getResource("/tcdd.jpg")));
		label.setBounds(50, 26, 112, 148);
		contentPane.add(label);
		
		JLabel lblNewLabel_1 = new JLabel("TCDD TA\u015EIMACILIK A.\u015E");
		lblNewLabel_1.setForeground(Color.GRAY);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(186, 63, 206, 29);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblGenelMdrl = new JLabel("GENEL M\u00DCD\u00DCRL\u00DC\u011E\u00DC");
		lblGenelMdrl.setForeground(Color.GRAY);
		lblGenelMdrl.setFont(new Font("Arial", Font.PLAIN, 18));
		lblGenelMdrl.setBounds(186, 91, 206, 29);
		contentPane.add(lblGenelMdrl);
		
		JLabel lblTrke = new JLabel("T\u00FCrk\u00E7e");
		lblTrke.setForeground(Color.GRAY);
		lblTrke.setFont(new Font("Arial", Font.PLAIN, 14));
		lblTrke.setBounds(1160, 63, 46, 17);
		contentPane.add(lblTrke);
		
		JLabel lblEnglish = new JLabel("English");
		lblEnglish.setForeground(Color.GRAY);
		lblEnglish.setFont(new Font("Arial", Font.PLAIN, 14));
		lblEnglish.setBounds(1216, 63, 46, 17);
		contentPane.add(lblEnglish);
		
		JLabel lblifrenizEnAz = new JLabel("\u015Eifreniz en az 8 karakterden olu\u015Fmal\u0131d\u0131r.");
		lblifrenizEnAz.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblifrenizEnAz.setForeground(Color.RED);
		lblifrenizEnAz.setBounds(520, 286, 197, 14);
		contentPane.add(lblifrenizEnAz);
		
		passwordField = new JPasswordField();
		passwordField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				  Validator pass = new Validator();
				  valid7 = pass.password_validate(String.valueOf(passwordField.getPassword()));
				  if(!valid7)
					  JOptionPane.showMessageDialog(null,"                                                 "
					  		+ "Geçersiz Þifre!!\n"
					  		+ "Þifreniz en az bir rakam, büyük harf, küçük harf ve özel karakter içermelidir.");
			}
		});
		passwordField.setBounds(350, 283, 160, 20);
		
		contentPane.add(passwordField);
		
		
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		label_1.setForeground(Color.RED);
		passwordField_1 = new JPasswordField();
		passwordField_1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(!(String.valueOf(passwordField_1.getPassword())).equals(String.valueOf(passwordField.getPassword()))){
					flag = "";
					label_1.setForeground(Color.RED);
					label_1.setText("Eþleþme gerçekleþmedi, þifrenizi kontrol ediniz!!");
				}
				else if((String.valueOf(passwordField_1.getPassword())).equals(String.valueOf(passwordField.getPassword()))){
					flag = String.valueOf(passwordField_1.getPassword());
					if(!flag.equals("")){
						label_1.setForeground(Color.GREEN);
						label_1.setText("Eþleþme gerçekleþti.");
					}
				}
			}
		});
		passwordField_1.setBounds(350, 313, 160, 20);
		contentPane.add(passwordField_1);
		
		label_1.setBackground(Color.WHITE);
		label_1.setBounds(520, 316, 200, 14);
		contentPane.add(label_1);
		
	}
}
