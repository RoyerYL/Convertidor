package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JComboBox;



import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;

import javax.swing.SwingConstants;

import Enums.Cotizaciones;
import Enums.Distancias;
import Enums.Temperaturas_Magnitudes;
import Procesos.Procesos;

import javax.swing.JSeparator;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import java.awt.SystemColor;

import javax.swing.UIManager;
import javax.swing.SpringLayout;
import java.awt.CardLayout;

public class VentanaPrincipal extends JFrame implements ActionListener{
	private Cotizaciones cotizacion;
	private JPanel panelTiposDeConvertidores;
	private JButton btnArgTo;
	private JButton btnKgToLibra;
	private JButton btnCToK;
	private JButton btnMetroToPies;
	private JPanel borderPanel;
	
	private CardLayout cardLayout;
	private JPanel cardPanel;
	private JPanel panelConvertidorMoneda;
	private JLabel lblTituloConvertidor;
	private JLabel lblMontoArg;
	private JTextField textMontoArg;
	private JButton btnConvertirMoneda;
	private JTextField textMonedaExtranjera;
	private JComboBox boxCotizaciones;
	private JLabel lblMoneda;
	private JLabel lblMontoExtranjero;
	private JPanel panelConvertidorTemperatura;
	private JPanel panelConvertirPeso;
	private JPanel panelConvertidorDistancia;
	private JTextField textTemp_1;
	private JTextField textTemp_2;
	private JTextField textKg;
	private JTextField textLibra;
	private JLabel lblConvertidorDeDistancia;
	private JLabel lblDistancia1;
	private JTextField textDistancia_1;
	private JSeparator separator_13;
	private JSeparator separator_14;
	private JButton btnConvertirDistancia;
	private JTextField textDistancia_2;
	private JComboBox boxDistancias;
	private JLabel lblMoneda_5;
	private JLabel lblDistancia2;
	private JComboBox boxTemp_2;
	private JButton btnConvertirTemperatura;
	private JComboBox boxTemp_1;
	private JButton btnConvertirPeso;
	private JLabel lblMagnitud_1;
	
	public VentanaPrincipal() {
		getContentPane().setBackground(new Color(70, 130, 180));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 300);
		setTitle("CALCULADORA");
		setResizable(false);
		
		iniciarComplementos();
	}
	
	/*//////////////////////////////////////////////////////////*/
	private void iniciarComplementos(){
		
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);

		JPanel panelBackground = new JPanel();
		panelBackground.setBackground(new Color(0, 0, 0));
		springLayout.putConstraint(SpringLayout.NORTH, panelBackground, 0, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panelBackground, 0, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panelBackground, 261, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panelBackground, 0, SpringLayout.EAST, getContentPane());
		getContentPane().add(panelBackground);
		panelBackground.setLayout(null);
		
		panelTiposDeConvertidores = new JPanel();
		panelTiposDeConvertidores.setBackground(new Color(70, 130, 180));
		panelTiposDeConvertidores.setBounds(0, 0, 106, 260);
		panelBackground.add(panelTiposDeConvertidores);
		
/* **PANELES** */
		borderPanel = new JPanel();
		borderPanel.setLayout(cardLayout);
		
		borderPanel.setBounds(109, 0, 173, 260);
		panelBackground.add(borderPanel);
		borderPanel.setLayout(new CardLayout(0, 0));
		borderPanel.setLayout(new BorderLayout(0, 0));
		
			cardPanel = new JPanel();
			cardPanel.setBackground(new Color(0, 128, 128));
			cardPanel.setLayout(new CardLayout(0, 0));
		
		borderPanel.add(cardPanel);
		
	/* PANEL CONVERTIDOR DE MONEDA */
		panelConvertidorMoneda = new JPanel();
		panelConvertidorMoneda.setLayout(null);
		panelConvertidorMoneda.setBackground(new Color(0, 128, 128));
		panelConvertidorMoneda.setOpaque(true);
		cardPanel.add(panelConvertidorMoneda, "Panel Convertidor de Monedas");
		
		separadores(panelConvertidorMoneda);
		
		lblTituloConvertidor = new JLabel("CONVERTIDOR DE MONEDA");
		lblTituloConvertidor.setOpaque(true);
		lblTituloConvertidor.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloConvertidor.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTituloConvertidor.setBackground(new Color(0, 128, 128));
		lblTituloConvertidor.setBounds(0, 0, 173, 22);
		panelConvertidorMoneda.add(lblTituloConvertidor);
		
		lblMontoArg = new JLabel("Monto ARG:");
		lblMontoArg.setBounds(10, 58, 77, 14);
		panelConvertidorMoneda.add(lblMontoArg);
		
		textMontoArg = new JTextField();
		textMontoArg.setHorizontalAlignment(SwingConstants.RIGHT);
		textMontoArg.setColumns(10);
		textMontoArg.setBounds(79, 58, 84, 20);
		panelConvertidorMoneda.add(textMontoArg);
		
		
		btnConvertirMoneda = new JButton("Convertir");
		btnConvertirMoneda.setBounds(12, 153, 149, 23);
		panelConvertidorMoneda.add(btnConvertirMoneda);
		
		btnConvertirMoneda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnConvertirMoneda) 
				{
					Boolean argTo=true;
					double montoDouble;
					String monto=textMontoArg.getText();
					
					try {
						montoDouble=Double.parseDouble(monto);	
					} catch (Exception ex) {
						monto=textMonedaExtranjera.getText();					
						montoDouble=Double.parseDouble(monto);
						argTo=false;
					}

					double conversion=Procesos.convertir(montoDouble,(Cotizaciones) boxCotizaciones.getSelectedItem(),argTo);
					
					if(argTo) 
					{
					textMonedaExtranjera.setText(conversion+"$");
					textMonedaExtranjera.setForeground(new Color(0, 128, 0));
					textMontoArg.setText("");
					}else 
					{
					textMontoArg.setText(conversion+"$");
					textMontoArg.setForeground(new Color(0, 128, 0));
					textMonedaExtranjera.setText("");

					}
					

				}
			}
		});
		
		
		textMonedaExtranjera = new JTextField();
		textMonedaExtranjera.setHorizontalAlignment(SwingConstants.RIGHT);
		textMonedaExtranjera.setBounds(79, 122, 84, 20);
		textMonedaExtranjera.setForeground(new Color(0, 128, 0));
		textMonedaExtranjera.setColumns(10);
		panelConvertidorMoneda.add(textMonedaExtranjera);
		
		boxCotizaciones = new JComboBox();
		boxCotizaciones.setModel(new DefaultComboBoxModel(new Cotizaciones[] {cotizacion.Dolar,cotizacion.Euro, cotizacion.Yenes,cotizacion.Real,cotizacion.PesoMx}));
		boxCotizaciones.setSelectedIndex(0);
		boxCotizaciones.setFont(new Font("Tahoma", Font.PLAIN, 15));
		boxCotizaciones.setBounds(79, 89, 84, 22);
		
		boxCotizaciones.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==boxCotizaciones) 
				{
					lblMontoExtranjero.setText(boxCotizaciones.getSelectedItem()+":");
				}
			}
		});
		
		panelConvertidorMoneda.add(boxCotizaciones);
		
		lblMoneda = new JLabel("Moneda:");
		lblMoneda.setBounds(10, 95, 60, 14);
		panelConvertidorMoneda.add(lblMoneda);
		
		lblMontoExtranjero = new JLabel(boxCotizaciones.getSelectedItem()+":");
		lblMontoExtranjero.setBounds(10, 125, 77, 14);
		panelConvertidorMoneda.add(lblMontoExtranjero);
		
	/* PANEL CONVERTIDOR DE TEMPERATURA */
		panelConvertidorTemperatura = new JPanel();
		panelConvertidorTemperatura.setBackground(new Color(135, 206, 250));
		cardPanel.add(panelConvertidorTemperatura, "Panel Convertidor de Temperatura");
		panelConvertidorTemperatura.setLayout(null);
		
		JLabel lblConvertidorDeTemperatura = new JLabel("CONVERTIDOR DE TEMPERATURA\r\n");
		lblConvertidorDeTemperatura.setOpaque(true);
		lblConvertidorDeTemperatura.setHorizontalAlignment(SwingConstants.CENTER);
		lblConvertidorDeTemperatura.setFont(new Font("Tahoma", Font.BOLD, 8));
		lblConvertidorDeTemperatura.setBackground(new Color(135, 206, 250));
		lblConvertidorDeTemperatura.setBounds(0, 0, 173, 22);
		panelConvertidorTemperatura.add(lblConvertidorDeTemperatura);
		
		textTemp_1 = new JTextField();
		textTemp_1.setHorizontalAlignment(SwingConstants.RIGHT);
		textTemp_1.setColumns(10);
		textTemp_1.setBounds(79, 58, 84, 20);
		panelConvertidorTemperatura.add(textTemp_1);
		
		separadores(panelConvertidorTemperatura);
		
		btnConvertirTemperatura = new JButton("Convertir");
		btnConvertirTemperatura.setBounds(12, 153, 149, 23);
		btnConvertirTemperatura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnConvertirTemperatura) 
				{
					String temperatura=textTemp_1.getText();
					double conversion;
					double temperaturaDouble;
					textTemp_1.setText("");
					
					try {
						temperaturaDouble=Double.parseDouble(temperatura);
						temperaturaDouble=Double.parseDouble(temperatura);						
						conversion=Procesos.convertirTemperatura(temperaturaDouble,(Temperaturas_Magnitudes) boxTemp_1.getSelectedItem(),(Temperaturas_Magnitudes) boxTemp_2.getSelectedItem());
						
						textTemp_2.setText(conversion+"°");
						textTemp_2.setForeground(new Color(0, 128, 0));
						textTemp_1.setText("");
					} catch (NumberFormatException ex2) {
						temperatura=textTemp_2.getText();
						temperaturaDouble=Double.parseDouble(temperatura);
						conversion=Procesos.convertirTemperatura(temperaturaDouble,(Temperaturas_Magnitudes) boxTemp_2.getSelectedItem(),(Temperaturas_Magnitudes) boxTemp_1.getSelectedItem());
						
						textTemp_1.setText(conversion+"°");
						textTemp_1.setForeground(new Color(0, 128, 0));
						textTemp_2.setText("");
					}
					

	
					
						
				}
			}
		});
		panelConvertidorTemperatura.add(btnConvertirTemperatura);
		
		
		textTemp_2 = new JTextField();
		textTemp_2.setHorizontalAlignment(SwingConstants.RIGHT);
		textTemp_2.setForeground(new Color(0, 128, 0));
		textTemp_2.setColumns(10);
		textTemp_2.setBounds(79, 122, 84, 20);
		panelConvertidorTemperatura.add(textTemp_2);
		
		boxTemp_1 = new JComboBox();
		boxTemp_1.setModel(new DefaultComboBoxModel(new Temperaturas_Magnitudes[] {Temperaturas_Magnitudes.C, Temperaturas_Magnitudes.K, Temperaturas_Magnitudes.F}));
		boxTemp_1.setSelectedIndex(0);
		boxTemp_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		boxTemp_1.setBounds(15, 55, 54, 22);
		panelConvertidorTemperatura.add(boxTemp_1);
		
		JLabel lblMagnitud = new JLabel("↕");
		lblMagnitud.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblMagnitud.setHorizontalAlignment(SwingConstants.CENTER);
		lblMagnitud.setBounds(104, 78, 35, 43);
		panelConvertidorTemperatura.add(lblMagnitud);
		
		boxTemp_2 = new JComboBox();
		boxTemp_2.setModel(new DefaultComboBoxModel(new Temperaturas_Magnitudes[] {Temperaturas_Magnitudes.F, Temperaturas_Magnitudes.K, Temperaturas_Magnitudes.C}));
		boxTemp_2.setSelectedIndex(0);
		boxTemp_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		boxTemp_2.setBounds(15, 121, 54, 22);
		panelConvertidorTemperatura.add(boxTemp_2);
		
	/* Panel Convertidor de Peso */
		
		panelConvertirPeso = new JPanel();
		cardPanel.add(panelConvertirPeso, "name_193248187610800");
		panelConvertirPeso.setLayout(null);
		
		JLabel lblConvertidorDePeso = new JLabel("CONVERTIDOR DE PESO");
		lblConvertidorDePeso.setOpaque(true);
		lblConvertidorDePeso.setHorizontalAlignment(SwingConstants.CENTER);
		lblConvertidorDePeso.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblConvertidorDePeso.setBackground(UIManager.getColor("Button.background"));
		lblConvertidorDePeso.setBounds(0, 0, 173, 22);
		panelConvertirPeso.add(lblConvertidorDePeso);
		
		JLabel lblKg = new JLabel("KG:");
		lblKg.setBounds(10, 58, 77, 14);
		panelConvertirPeso.add(lblKg);
		
		textKg = new JTextField();
		textKg.setHorizontalAlignment(SwingConstants.RIGHT);
		textKg.setColumns(10);
		textKg.setBounds(79, 58, 84, 20);
		panelConvertirPeso.add(textKg);
		
		separadores(panelConvertirPeso);

		btnConvertirPeso = new JButton("Convertir");
		btnConvertirPeso.setBounds(12, 153, 149, 23);
		
		btnConvertirPeso.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource()==btnConvertirPeso) 
				{
					String peso;
					Double pesoDouble;
					try {
						peso=textKg.getText();
						pesoDouble=Double.parseDouble(peso);
						
						textLibra.setText(Procesos.convertirPeso(pesoDouble,true)+"");
						textKg.setText("");
					} catch (NumberFormatException e2) {
						peso=textLibra.getText();
						pesoDouble=Double.parseDouble(peso);
						
						textKg.setText(Procesos.convertirPeso(pesoDouble,false)+"");
						textLibra.setText("");
					}
				}
			}
		});
		
		panelConvertirPeso.add(btnConvertirPeso);
		
		textLibra = new JTextField();
		textLibra.setHorizontalAlignment(SwingConstants.RIGHT);
		textLibra.setForeground(new Color(0, 128, 0));
		textLibra.setColumns(10);
		textLibra.setBounds(79, 122, 84, 20);
		panelConvertirPeso.add(textLibra);
		
		JLabel lblLibra = new JLabel("LIBRA:");
		lblLibra.setBounds(10, 125, 77, 14);
		panelConvertirPeso.add(lblLibra);
		
		lblMagnitud_1 = new JLabel("↕");
		lblMagnitud_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblMagnitud_1.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblMagnitud_1.setBounds(103, 78, 35, 43);
		panelConvertirPeso.add(lblMagnitud_1);

	/* Panel Convertidor de Distancia */
		panelConvertidorDistancia = new JPanel();
		cardPanel.add(panelConvertidorDistancia, "name_193249832940700");
		panelConvertidorDistancia.setLayout(null);
		
		lblConvertidorDeDistancia = new JLabel("CONVERTIDOR DE DISTANCIA\r\n");
		lblConvertidorDeDistancia.setOpaque(true);
		lblConvertidorDeDistancia.setHorizontalAlignment(SwingConstants.CENTER);
		lblConvertidorDeDistancia.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblConvertidorDeDistancia.setBackground(UIManager.getColor("Button.background"));
		lblConvertidorDeDistancia.setBounds(0, 0, 173, 22);
		panelConvertidorDistancia.add(lblConvertidorDeDistancia);
		
		lblDistancia1 = new JLabel("Distancia Km\r\n:");
		lblDistancia1.setBounds(10, 58, 77, 14);
		panelConvertidorDistancia.add(lblDistancia1);
		
		textDistancia_1 = new JTextField();
		textDistancia_1.setHorizontalAlignment(SwingConstants.RIGHT);
		textDistancia_1.setColumns(10);
		textDistancia_1.setBounds(79, 58, 84, 20);
		panelConvertidorDistancia.add(textDistancia_1);
		
		separadores(panelConvertidorDistancia);
		
		btnConvertirDistancia = new JButton("Convertir");
		btnConvertirDistancia.setBounds(12, 153, 149, 23);
		
		btnConvertirDistancia.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnConvertirDistancia) 
				{
					Boolean argTo=true;
					double distanciaDouble;
					String distancia;
					
					try {
						distancia=textDistancia_1.getText();
						distanciaDouble=Double.parseDouble(distancia);

						
						textDistancia_2.setText(Procesos.convertirDistancia(distanciaDouble,(Distancias) boxDistancias.getSelectedItem())+"");
						textDistancia_2.setForeground(new Color(0, 128, 0));
						textDistancia_1.setText("");
					} catch (Exception ex) {
						distancia=textDistancia_2.getText();					
						distanciaDouble=Double.parseDouble(distancia);

						textDistancia_1.setText(Procesos.convertirDistancia(distanciaDouble,(Distancias) boxDistancias.getSelectedItem())+"");
						textDistancia_1.setForeground(new Color(0, 128, 0));
						textDistancia_2.setText("");
					}
				}
			}
		});
		
		panelConvertidorDistancia.add(btnConvertirDistancia);
		
		textDistancia_2 = new JTextField();
		textDistancia_2.setHorizontalAlignment(SwingConstants.RIGHT);
		textDistancia_2.setForeground(new Color(0, 128, 0));
		textDistancia_2.setColumns(10);
		textDistancia_2.setBounds(79, 122, 84, 20);
		panelConvertidorDistancia.add(textDistancia_2);
		
		boxDistancias = new JComboBox();
		boxDistancias.setModel(new DefaultComboBoxModel(new Distancias[] {Distancias.M, Distancias.Pies,Distancias.Yardas, Distancias.Hectareas}));
		boxDistancias.setSelectedIndex(0);
		boxDistancias.setFont(new Font("Tahoma", Font.PLAIN, 15));
		boxDistancias.setBounds(79, 89, 84, 22);
		panelConvertidorDistancia.add(boxDistancias);
		
		lblMoneda_5 = new JLabel("Moneda:");
		lblMoneda_5.setBounds(10, 95, 60, 14);
		panelConvertidorDistancia.add(lblMoneda_5);
		
		lblDistancia2 = new JLabel("Distancia 2:");
		lblDistancia2.setBounds(10, 125, 77, 14);
		panelConvertidorDistancia.add(lblDistancia2);

		botones();
	}
	
////////////////////////////////////////////////////////////////////////////////////

	private void separadores(JPanel panel) {
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 128, 128));
		separator.setForeground(SystemColor.desktop);
		separator.setBounds(0, 23, 173, 2);
		panel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(new Color(0, 128, 128));
		separator_1.setForeground(SystemColor.desktop);
		separator_1.setBounds(0, 187, 173, 2);
		panel.add(separator_1);

		
	}
	
	private void botones() 
	{
	
/*******/
		
		btnArgTo = new JButton("ARG$ a $");
		btnArgTo.setBackground(new Color(100, 149, 237));
		btnArgTo.setBounds(7, 30, 91, 23);
		btnArgTo.setOpaque(true);
		btnArgTo.setBorder(new BevelBorder(BevelBorder.RAISED));

		btnArgTo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnArgTo) 
				{	
					btnArgTo.setBorder(new BevelBorder(BevelBorder.RAISED));
					btnCToK.setBorder(new BevelBorder(BevelBorder.LOWERED));
					btnKgToLibra.setBorder(new BevelBorder(BevelBorder.LOWERED));
					btnMetroToPies.setBorder(new BevelBorder(BevelBorder.LOWERED));

					panelConvertidorMoneda.show(true);
					panelConvertidorTemperatura.show(false);
					panelConvertirPeso.show(false);
					panelConvertidorDistancia.show(false);
				}
			}
		});
		panelTiposDeConvertidores.setLayout(null);
		panelTiposDeConvertidores.add(btnArgTo);
		
/*******/
		btnCToK = new JButton("C° a K°");
		btnCToK.setBackground(new Color(100, 149, 237));
		btnCToK.setBounds(7, 64, 91, 23);
		btnCToK.setBorder(new BevelBorder(BevelBorder.LOWERED));

		btnCToK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnCToK) { 
					
					btnArgTo.setBorder(new BevelBorder(BevelBorder.LOWERED));
					btnCToK.setBorder(new BevelBorder(BevelBorder.RAISED));
					btnKgToLibra.setBorder(new BevelBorder(BevelBorder.LOWERED));
					btnMetroToPies.setBorder(new BevelBorder(BevelBorder.LOWERED));
					
					panelConvertidorMoneda.show(false);
					panelConvertidorTemperatura.show(true);
					panelConvertirPeso.show(false);
					panelConvertidorDistancia.show(false);

				}
			}
		});
		
/*******/
		panelTiposDeConvertidores.add(btnCToK);
		
		btnKgToLibra = new JButton("Kg a Libra");
		btnKgToLibra.setBackground(new Color(100, 149, 237));
		btnKgToLibra.setBounds(7, 98, 91, 23);
		btnKgToLibra.setBorder(new BevelBorder(BevelBorder.LOWERED));

		btnKgToLibra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnKgToLibra) { 
					
					btnArgTo.setBorder(new BevelBorder(BevelBorder.LOWERED));
					btnCToK.setBorder(new BevelBorder(BevelBorder.LOWERED));
					btnKgToLibra.setBorder(new BevelBorder(BevelBorder.RAISED));
					btnMetroToPies.setBorder(new BevelBorder(BevelBorder.LOWERED));
					
					panelConvertidorMoneda.show(false);
					panelConvertidorTemperatura.show(false);
					panelConvertirPeso.show(true);
					panelConvertidorDistancia.show(false);
				}
			}
		});
		
		
		panelTiposDeConvertidores.add(btnKgToLibra);
		
/*******/
		btnMetroToPies = new JButton("Metro a Pies");
		btnMetroToPies.setBackground(new Color(100, 149, 237));
		btnMetroToPies.setBounds(7, 132, 91, 23);
		btnMetroToPies.setBorder(new BevelBorder(BevelBorder.LOWERED));
	
		panelTiposDeConvertidores.add(btnMetroToPies);
		
		btnMetroToPies.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnMetroToPies) { 
					
					btnArgTo.setBorder(new BevelBorder(BevelBorder.LOWERED));
					btnCToK.setBorder(new BevelBorder(BevelBorder.LOWERED));
					btnKgToLibra.setBorder(new BevelBorder(BevelBorder.LOWERED));
					btnMetroToPies.setBorder(new BevelBorder(BevelBorder.RAISED));
				
			

					panelConvertidorMoneda.show(false);
					panelConvertidorTemperatura.show(false);
					panelConvertirPeso.show(false);
					panelConvertidorDistancia.show(true);
				}
			}
		});

	}
	
////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public void actionPerformed(ActionEvent e) {
	
		
	}
}
