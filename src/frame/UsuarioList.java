/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package frame;

import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import domain.Usuario;

/**
 *
 * @author lgfas
 */
public class UsuarioList extends javax.swing.JInternalFrame {

	private static final long serialVersionUID = 1L;
	private List<Usuario> usuariosList;

	/**
	 * Creates new form Usuario
	 */
	public UsuarioList() {
		initComponents();

	}

	/**
	 * Creates new form Usuario
	 */
	public UsuarioList(List<Usuario> publicacoesList) {
		initComponents();
		this.usuariosList = publicacoesList;
		updateModelList(usuariosList);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		inputBusca = new javax.swing.JTextField();
		jScrollPane1 = new javax.swing.JScrollPane();
		listaPublicacoes = new javax.swing.JList<>();
		jLabel6 = new javax.swing.JLabel();
		buscarBtn = new javax.swing.JButton();

		setClosable(true);
		setTitle("Listagem de usuarios");

		jLabel1.setText("Busca");

		listaPublicacoes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		listaPublicacoes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		listaPublicacoes.setFocusable(false);
		listaPublicacoes.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				listaPublicacoesMouseClicked(evt);
			}
		});
		jScrollPane1.setViewportView(listaPublicacoes);

		jLabel6.setText("Usuários");

		buscarBtn.setText("buscar");
		buscarBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				buscarBtnActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup().addComponent(jLabel1)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(inputBusca))
								.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)
								.addComponent(jLabel6).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
										.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE).addComponent(buscarBtn)))
						.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel1).addComponent(inputBusca, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(buscarBtn)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jLabel6)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 267,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));

		pack();
	}

	private void buscarBtnActionPerformed(java.awt.event.ActionEvent evt) {
		String busca = inputBusca.getText().toLowerCase();
		var usuarios = usuariosList.stream().filter(p -> {
			return p.getNome().toLowerCase().contains(busca) || p.getCPF().toLowerCase().contains(busca)
					|| p.getLogin().toLowerCase().contains(busca);
		}).toList();
		updateModelList(usuarios);
	}

	@SuppressWarnings("unchecked")
	private void listaPublicacoesMouseClicked(java.awt.event.MouseEvent evt) {
		if (evt.getClickCount() == 1) {
			JList<Usuario> target = (JList<Usuario>) evt.getSource();
			int index = target.locationToIndex(evt.getPoint());
			if (index >= 0) {
				Usuario usuario = target.getModel().getElementAt(index);

				Integer acao = (new AcoesUsuarioDialog(null, true,
						"Qual operação deseja realizar para o usuário (%s)".formatted(usuario))).showDialog();
				if (acao == null)
					return;
				switch (acao) {
				case 1:
					var edicaoDialog = new UsuarioDialog(null, true, usuario);
					var user = edicaoDialog.showDialog();
					usuario.clone(user);
					break;
				case 2:
					int input = JOptionPane.showConfirmDialog(null,
							"Deseja realmente exluir o usuario \"%s\"?".formatted(usuario));
					if (input == 0) {
						usuariosList.remove(usuario);
						updateModelList(usuariosList);
					}
					break;
				case 0:
					break;
				default:
					throw new AssertionError();
				}
			}
		}
	}

	private void updateModelList(List<Usuario> usuarios) {
		var listagem = new DefaultListModel<Usuario>();
		listagem.addAll(usuarios);
		listaPublicacoes.setModel(listagem);
	}

	private javax.swing.JButton buscarBtn;
	private javax.swing.JTextField inputBusca;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JList<Usuario> listaPublicacoes;

}
