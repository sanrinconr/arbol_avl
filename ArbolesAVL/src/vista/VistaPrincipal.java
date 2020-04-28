package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.*;

public class VistaPrincipal extends JFrame{
	
	private JPanel laminaPrincipal;
	private JLabel lblTitulo;
	private JTextField txtInsc;
	private JTextField txtRet;
	private JButton btnIns;
	private JButton btnRet;
	private JButton btnDibujar;
	
	public VistaPrincipal() {
		
		this.setTitle("Arboles AVL");
		
		Toolkit miPantalla=Toolkit.getDefaultToolkit();
		Dimension tamanioPantalla=miPantalla.getScreenSize();
		int alturaPantalla = tamanioPantalla.height;
		int anchoPantalla = tamanioPantalla.width;
		this.setBounds(anchoPantalla/10, alturaPantalla/8, anchoPantalla-2*(anchoPantalla/10), alturaPantalla-2*(alturaPantalla/8));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Lamina principal
		laminaPrincipal = new JPanel();
		laminaPrincipal.setLayout(new BorderLayout());
		
		JPanel laminaNorte = new JPanel();
		laminaNorte.setLayout(new BorderLayout());
		JPanel laminaN = new JPanel();
		lblTitulo = new JLabel("Arboles AVL");
		laminaN.add(lblTitulo);
		laminaNorte.add(laminaN, BorderLayout.NORTH);
		
		JPanel laminaW = new JPanel();
		JLabel lblIns = new JLabel("Digite numeros a insertar: ");
		laminaW.add(lblIns);
		txtInsc = new JTextField(10);
		laminaW.add(txtInsc);
		btnIns = new JButton("Insertar");
		laminaW.add(btnIns);
		laminaNorte.add(laminaW, BorderLayout.WEST);
		
		JPanel laminaE = new JPanel();
		JLabel lblRet = new JLabel("Digite un numero a retirar: ");
		laminaE.add(lblRet);
		txtRet = new JTextField(10);
		laminaE.add(txtRet);
		btnRet = new JButton("Retirar");
		laminaE.add(btnRet);
		laminaNorte.add(laminaE, BorderLayout.EAST);
		
		JPanel laminaC = new JPanel();
		btnDibujar = new JButton("Dibujar arbol");
		laminaC.add(btnDibujar);
		laminaNorte.add(laminaC, BorderLayout.CENTER);
		
		laminaPrincipal.add(laminaNorte, BorderLayout.NORTH);
		this.add(laminaPrincipal);
	}
	
	public void iniciar() {
		this.setVisible(true);
	}
}
