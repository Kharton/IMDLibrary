/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package frame;

import javax.swing.JOptionPane;

/**
 *
 * @author lgfas
 */
public class PessoaDialog extends javax.swing.JDialog {
	private static final long serialVersionUID = 1L;
	domain.Pessoa pessoa;

	/**
	 * Creates new form PessoaDialog
	 */
	public PessoaDialog(java.awt.Frame parent, boolean modal) {
		super(parent, modal);
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	private void initComponents() {

		nome = new javax.swing.JLabel();
		RG = new javax.swing.JLabel();
		CPF = new javax.swing.JLabel();
		Idade = new javax.swing.JLabel();
		inputNome = new javax.swing.JTextField();
		inputRG = new javax.swing.JTextField();
		inputCPF = new javax.swing.JTextField();
		inputIdade = new javax.swing.JTextField();
		cadastrarBtn = new javax.swing.JButton();
		cancelBtn = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("Adicionar pessoa");
		setName("pessoaDialog"); // NOI18N

		nome.setText("Nome");

		RG.setText("RG");

		CPF.setText("CPF");

		Idade.setText("Idade");

		cadastrarBtn.setText("Cadastrar");
		cadastrarBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cadastrarBtnActionPerformed(evt);
			}
		});

		cancelBtn.setText("Cancelar");
		cancelBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cancelBtnActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addGap(20, 20, 20)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addGroup(layout
						.createSequentialGroup()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addGroup(javax.swing.GroupLayout.Alignment.LEADING,
										layout.createSequentialGroup().addComponent(CPF)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(inputCPF))
								.addGroup(layout.createSequentialGroup().addComponent(RG)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(inputRG)))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(Idade)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(inputIdade,
								javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
										.addGroup(layout.createSequentialGroup().addComponent(nome)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(inputNome, javax.swing.GroupLayout.PREFERRED_SIZE, 287,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGroup(layout.createSequentialGroup().addComponent(cadastrarBtn)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(cancelBtn)))))
				.addGap(20, 20, 20)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(40, 40, 40)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(nome).addComponent(inputNome, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(RG).addComponent(Idade)
								.addComponent(inputRG, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(inputIdade, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(CPF).addComponent(inputCPF, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(cadastrarBtn).addComponent(cancelBtn))
						.addContainerGap(23, Short.MAX_VALUE)));

		pack();
	}

	private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {
		pessoa = null;
		this.dispose();
	}

	private void cadastrarBtnActionPerformed(java.awt.event.ActionEvent evt) {
		try {
			pessoa = new domain.Pessoa(inputNome.getText(), inputRG.getText(), inputCPF.getText(),
					Integer.parseInt(inputIdade.getText()));
			setVisible(false);
			this.dispose();
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(PessoaDialog.this, "Erro ao tentar converter a idade para um número.");
		}
	}

	public domain.Pessoa showDialog() {
		setVisible(true);
		return pessoa;
	}

	private javax.swing.JLabel CPF;
	private javax.swing.JLabel Idade;
	private javax.swing.JLabel RG;
	private javax.swing.JButton cadastrarBtn;
	private javax.swing.JButton cancelBtn;
	private javax.swing.JTextField inputCPF;
	private javax.swing.JTextField inputIdade;
	private javax.swing.JTextField inputNome;
	private javax.swing.JTextField inputRG;
	private javax.swing.JLabel nome;
}
