package br.com.diego.estoque.view;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

public class TelaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JMenuBar menuBar;
	private JMenu menuCadastro;
	private JMenu menuConsuta;
	private JMenu menuRelatrio;
	private JMenu menuUtilitrios;
	private JMenu menuSair;
	private JPanel painelPrincipal;
	private JMenuItem menuItmCliente;
	private JMenuItem menuItmFuncionrio;
	private JMenuItem menuItmCargo;
	private JMenuItem menuItmSair;

	public TelaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		setTitle("Tela Principal - Estoque");
		setLocationRelativeTo(null);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		menuCadastro = new JMenu("Cadastros");
		menuCadastro.setMnemonic('C');
		menuBar.add(menuCadastro);
		
		menuItmCliente = new JMenuItem("Clientes");
		menuCadastro.add(menuItmCliente);
		
		menuItmFuncionrio = new JMenuItem("Funcion\u00E1rios");
		menuCadastro.add(menuItmFuncionrio);
		
		menuItmCargo = new JMenuItem("Cargo");
		menuCadastro.add(menuItmCargo);
		
		JSeparator separator_1 = new JSeparator();
		menuCadastro.add(separator_1);
		
		JMenu meneEstoque = new JMenu("Estoque");
		menuCadastro.add(meneEstoque);
		
		JSeparator separator = new JSeparator();
		menuCadastro.add(separator);
		
		menuItmSair = new JMenuItem("Sair");
		menuCadastro.add(menuItmSair);
		
		menuConsuta = new JMenu("Consutas");
		menuConsuta.setMnemonic('n');
		menuBar.add(menuConsuta);
		
		menuRelatrio = new JMenu("Relat\u00F3rios");
		menuRelatrio.setMnemonic('R');
		menuBar.add(menuRelatrio);
		
		menuUtilitrios = new JMenu("Utilit\u00E1rios");
		menuUtilitrios.setMnemonic('U');
		menuBar.add(menuUtilitrios);
		
		menuSair = new JMenu("Sair");
		menuSair.setMnemonic('S');
		menuBar.add(menuSair);
		
		painelPrincipal = new JPanel();
		getContentPane().add(painelPrincipal, BorderLayout.CENTER);
		painelPrincipal.setLayout(null);

	}
}
