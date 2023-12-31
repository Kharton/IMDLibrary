/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package frame;

import java.awt.Dimension;

/**
 *
 * @author lgfas
 */
public class AcoesUsuarioDialog extends javax.swing.JDialog {
	private static final long serialVersionUID = 1L;
	Integer op;

	/**
	 * Creates new form PessoaDialog
	 */
	public AcoesUsuarioDialog(java.awt.Frame parent, boolean modal) {
		super(parent, modal);
		initComponents();
	}

	/**
	 * Creates new form PessoaDialog
	 */
	public AcoesUsuarioDialog(java.awt.Frame parent, boolean modal, String texto) {
		super(parent, modal);
		initComponents();
		textoAviso.setText(texto);
		textoAviso.setMaximumSize(new Dimension(130, 600));
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		textoAviso = new javax.swing.JLabel();
		editarBtn = new javax.swing.JButton();
		excluirBtn = new javax.swing.JButton();
		cancelBtn = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("Escolha de ação");
		setName("pessoaDialog");

		jPanel1.setToolTipText("");

		textoAviso.setText("Nome");

		editarBtn.setText("Editar");
		editarBtn.setToolTipText("");
		editarBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				editarBtnActionPerformed(evt);
			}
		});

		excluirBtn.setText("Excluir");
		excluirBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				excluirBtnActionPerformed(evt);
			}
		});

		cancelBtn.setText("Cancelar");
		cancelBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cancelBtnActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addGap(82, 82, 82).addComponent(editarBtn)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(excluirBtn)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(cancelBtn)
						.addContainerGap(177, Short.MAX_VALUE))
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(textoAviso,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap()));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap()
						.addComponent(textoAviso, javax.swing.GroupLayout.PREFERRED_SIZE, 33,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(editarBtn).addComponent(excluirBtn).addComponent(cancelBtn))
						.addContainerGap(14, Short.MAX_VALUE)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(jPanel1,
								javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE)));

		pack();
	}

	private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {
		op = null;
		setVisible(false);
		this.dispose();
	}

	private void editarBtnActionPerformed(java.awt.event.ActionEvent evt) {
		op = 1;
		setVisible(false);
		this.dispose();
	}

	private void excluirBtnActionPerformed(java.awt.event.ActionEvent evt) {
		op = 2;
		setVisible(false);
		this.dispose();
	}

	public Integer showDialog() {
		setVisible(true);
		return op;
	}

	private javax.swing.JButton cancelBtn;
	private javax.swing.JButton editarBtn;
	private javax.swing.JButton excluirBtn;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JLabel textoAviso;
}
