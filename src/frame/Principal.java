package frame;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import domain.Library;

public class Principal extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JMenuBar menuBar;
	private javax.swing.JDesktopPane painel;
	Library biblioteca = new Library();
	domain.Funcionario funcionario;

	public Principal() {
		deafultInitialization();
	}

	public Principal(String title) {
		deafultInitialization();
		setTitle(title);
	}

	private void deafultInitialization() {
		setTitle("app");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize((int) screenSize.getWidth(), (int) screenSize.getHeight() - 60);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		// Inicializar componentes
		initComponents();

		// Adicionar menu bar à janela
		setJMenuBar(menuBar);

		funcionario = new domain.Funcionario("mestre", "123", "123", 21, "Gerente", "0001");
		var funcionarios = new ArrayList<domain.Funcionario>();
		funcionarios.add(funcionario);
		biblioteca.setFuncionarios(funcionarios);
	}

	private void initComponents() {
		menuBar = new JMenuBar();

		var menu = new JMenu("Usuários");
		menuBar.add(menu);

		var createUserItem = new JMenuItem("Criar");
		var listUserItem = new JMenuItem("Listar");

		// Adicionar ação aos itens do menu
		createUserItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				var usuario = new Usuario((obj) -> {
					if (obj != null) {
						funcionario.cadastrarUsuario(obj, biblioteca.getUsuarios());
						JOptionPane.showMessageDialog(Principal.this, "Usuário cadastrado");
					}
					return null;
				});
				painel.add(usuario);
				usuario.setVisible(true);
			}
		});

		listUserItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Ação para ler um produto
				var usuario = new UsuarioList(biblioteca.getUsuarios());
				painel.add(usuario);
				usuario.setVisible(true);
			}
		});

		menu.add(createUserItem);
		menu.add(listUserItem);

		var menuFuncionarios = new JMenu("Publicacoes");
		menuBar.add(menuFuncionarios);
		var createFuncItem = new JMenuItem("Criar");
		var listFuncItem = new JMenuItem("Listar");

		// Adicionar ação aos itens do menu
		createFuncItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				var publicacao = new Publicacao((obj) -> {
					if (obj != null) {
						funcionario.cadastrarPublicacao(obj, biblioteca.getPublicacoes());
						JOptionPane.showMessageDialog(Principal.this, "Publicação cadastrada");
					}
					;
					return null;
				});
				painel.add(publicacao);
				publicacao.setVisible(true);
			}
		});

		listFuncItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				var publicacao = new PublicacaoList(biblioteca.getPublicacoes());
				painel.add(publicacao);
				publicacao.setVisible(true);
			}
		});
		menuFuncionarios.add(createFuncItem);
		menuFuncionarios.add(listFuncItem);

		painel = new javax.swing.JDesktopPane();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		javax.swing.GroupLayout painelLayout = new javax.swing.GroupLayout(painel);
		painel.setLayout(painelLayout);
		painelLayout.setHorizontalGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 388, Short.MAX_VALUE));
		painelLayout.setVerticalGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 288, Short.MAX_VALUE));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(painel).addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(painel).addContainerGap()));

//        pack();
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Principal("IMDLibrary").setVisible(true);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}

	public Library getLibrary() {
		return biblioteca;
	}

	public domain.Funcionario getFuncionario() {
		return funcionario;
	}
}
