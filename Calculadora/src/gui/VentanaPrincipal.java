package gui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import java.awt.GridLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import Enums.Cotizaciones;
import Procesos.Procesos;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JSeparator;
import javax.swing.JToggleButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JEditorPane;
import javax.swing.UIManager;
import javax.swing.SpringLayout;

public class VentanaPrincipal extends JFrame implements ActionListener{
	private JTextField textField_2;
	private JTextField textMonto;
	private AbstractButton btnNewButton;
	private JLabel lblResultado;
	private Cotizaciones cotizacion;
	private JComboBox boxCotizaciones;

	public VentanaPrincipal() {
		getContentPane().setBackground(UIManager.getColor("Button.disabledForeground"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 350);
		setTitle("CALCULADORA");
		setResizable(false);
		iniciarComplementos();
	}
	private void iniciarComplementos(){
		
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		JPanel panel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel, 24, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel, 56, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel, 0, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, -61, SpringLayout.EAST, getContentPane());
		panel.setBackground(SystemColor.info);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CONVERTIDOR DE MONEDA");
		lblNewLabel.setBackground(SystemColor.info);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(0, 0, 167, 22);
		lblNewLabel.setOpaque(true);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1_1 = new JLabel("Monto:");
		lblNewLabel_1_1.setBounds(10, 36, 49, 14);
		panel.add(lblNewLabel_1_1);
		
		textMonto = new JTextField();
		textMonto.setHorizontalAlignment(SwingConstants.RIGHT);
		textMonto.setColumns(10);
		textMonto.setBounds(69, 36, 86, 20);
		panel.add(textMonto);
		
		boxCotizaciones = new JComboBox();
		boxCotizaciones.setModel(new DefaultComboBoxModel(new String[] {"Dolar", "Euro", "Real", "Yen", "PesoMX"}));
		boxCotizaciones.setFont(new Font("Tahoma", Font.PLAIN, 15));
		boxCotizaciones.setBounds(69, 67, 86, 22);
		panel.add(boxCotizaciones);
		
		JLabel lblNewLabel_1 = new JLabel("Moneda:");
		lblNewLabel_1.setBounds(10, 73, 60, 14);
		panel.add(lblNewLabel_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(69, 100, 86, 20);
		panel.add(textField_2);
		textField_2.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_1_2 = new JLabel("Cotización:");
		lblNewLabel_1_2.setBounds(10, 103, 77, 14);
		panel.add(lblNewLabel_1_2);

		/* Botón */	
		btnNewButton = new JButton("Convertir");
		btnNewButton.setBounds(10, 131, 149, 23);
		btnNewButton.addActionListener(this);
		
		panel.add(btnNewButton);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(SystemColor.desktop);
		separator.setBounds(0, 165, 167, 2);
		panel.add(separator);
		
		lblResultado = new JLabel("");
		lblResultado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblResultado.setForeground(new Color(0, 128, 0));
		lblResultado.setHorizontalAlignment(SwingConstants.RIGHT);
		lblResultado.setBounds(10, 178, 147, 14);
		panel.add(lblResultado);
		getContentPane().add(panel);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(SystemColor.desktop);
		separator_1.setBounds(0, 23, 167, 2);
		panel.add(separator_1);
	}
	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==btnNewButton) 
		{
			String monto=textMonto.getText();
			double montoDouble=Double.parseDouble(monto);
			
			double conversion=Procesos.convertir(montoDouble,(String) boxCotizaciones.getSelectedItem());
			lblResultado.setText(conversion+"$");
			
			
			
		}
	}
}
