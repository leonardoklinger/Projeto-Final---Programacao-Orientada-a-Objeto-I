package teste;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;


public class tela extends JFrame{//classe para contrução de uma tela
	private JTextField inputName;//String
	private JLabel inputTextoName;
	private JTextField inputMatricula;//Inteiro
	private JLabel inputTextoMatricula;
	private JTextField inputSexo;//Char
	private JLabel inputTextoSexo;
	private JTextField inputEndereco;//String
	private JLabel inputTextoEndereco;
	private JButton botaoCadastro;
	private JButton botaoPesquisar;
	private JButton botaoAlterar;
	private JButton botaoLimpar;
	private JTable table;
	private ArrayList<Estudante> estudantes = new ArrayList<>();
	private JScrollPane scrollPane;
	private Modelos modelos;
	private ButtonGroup botaoSexo;
	
	public tela() {//construtor
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//fechar a tela e os processos
		this.setLayout(null);//trabalhar com a tela livre
		this.setBounds(10, 10, 1280, 720);//proporção da tela
		setTitle("Cadastro Aluno");
		
		inputTextoName = new JLabel("Nome");
		inputTextoName.setBounds(20, 30, 200, 10);
		this.add(inputTextoName);		
		inputName = new JTextField();
		inputName.setBounds(20, 50, 500, 30);
		this.add(inputName);//cadastro nome
		
		
		inputTextoEndereco = new JLabel("Endereço");
		inputTextoEndereco.setBounds(20, 90, 200, 30);
		this.add(inputTextoEndereco);
		inputEndereco = new JTextField();
		inputEndereco.setBounds(20, 120, 370, 30);
		this.add(inputEndereco);//cadastro endereço
		
		
		inputTextoMatricula = new JLabel("Matricula");
		inputTextoMatricula.setBounds(20, 160, 200, 30);
		this.add(inputTextoMatricula);
		inputMatricula = new JTextField();
		inputMatricula.setBounds(20, 190, 200, 30);
		this.add(inputMatricula);//cadastro matricula
		
		
		inputTextoSexo = new JLabel("Sexo");
		inputTextoSexo.setBounds(20, 230, 200, 30);
		this.add(inputTextoSexo);
		inputSexo = new JTextField();
		inputSexo.setBounds(20, 260, 100, 30);
		this.add(inputSexo);//cadastro sexo
		
		botaoCadastro = new JButton("Cadastrar");
		botaoCadastro.addActionListener(listernerOfBotaoCadastro());
		botaoCadastro.setBounds(20, 310, 100, 30);
		this.add(botaoCadastro);//botão cadastrar
		
		botaoPesquisar = new JButton("Pesquisar");
		botaoPesquisar.setBounds(140, 310, 100, 30);
		botaoPesquisar.addActionListener(listernerOfBotaoPesquisar());
		this.add(botaoPesquisar);//botão pesquisar
		
		botaoAlterar = new JButton("Editar");
		botaoAlterar.setBounds(260, 310, 100, 30);
		botaoAlterar.addActionListener(listernerOfBotaoEditar());
		this.add(botaoAlterar);//botão editar
		
		botaoLimpar = new JButton("Excluir");
		botaoLimpar.setBounds(380, 310, 100, 30);
		botaoLimpar.addActionListener(listernerOfbotaoLimpar());
		this.add(botaoLimpar);//botão excluir
		
		modelos = new Modelos(estudantes);
		table = new JTable(modelos);
			
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(540, 50, 700, 500);
		//table.setBounds(540, 50, 700, 500);
		this.add(scrollPane);
	}
	
	private ActionListener listernerOfBotaoCadastro() {//evento do botão cadastrar
		ActionListener myListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int conversor = Integer.parseInt(inputMatricula.getText());
                char conversor1 = inputSexo.getText().charAt(0);
				estudantes.add(new Estudante(inputName.getText(), inputEndereco.getText(), conversor, conversor1));
				modelos.fireTableDataChanged();
				FileReader arq;
				try {
					arq = new FileReader(inputMatricula.getText() + ".txt");
					BufferedReader myBuffer = new BufferedReader(arq);
					if(myBuffer == myBuffer) {
						JOptionPane.showMessageDialog(tela.this, "Já existe uma pessoa cadastrada com está matricula");
						return;
					}
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				sla.escreverTexto(inputMatricula.getText() + ".txt", inputName.getText() + "\n" + inputEndereco.getText () + "\n" + inputMatricula.getText() + "\n" + inputSexo.getText() + "\n");
				JOptionPane.showMessageDialog(null, "Cadastro feito com sucesso");
				inputName.setText("");
				inputEndereco.setText("");
				inputMatricula.setText("");
				inputSexo.setText("");
				
				}
		};
		return myListener;
	}
	
	private ActionListener listernerOfBotaoPesquisar() {//evento do botão pesquisar
		ActionListener myListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					// Tratamento de Erros
					try {
						// Solicita ao usuário que informe qual o arquivo deseja
						// abrir.
						String arquivo = JOptionPane.showInputDialog(null,
								"Infome a Matricula para abrir:");
	 
						// Instância de um Objeto da Class java(BufferedReader
						// "Para Leitura do Arquivo"), que Instância um Objeto da
						// Class java(FileReader) referenciando o arquivo a ser
						// aberto.
						BufferedReader br = new BufferedReader(new FileReader(
								arquivo + ".txt"));
	 
						// Ler o conteúdo do arquivo e exibe nos JTextField.
						String name = br.readLine();
						String Endereco = br.readLine();
						String Matricula = br.readLine();
						String Sexo = br.readLine();
						inputName.setText(name);
						inputEndereco.setText(Endereco);
						inputMatricula.setText(Matricula);
						inputSexo.setText(Sexo);
						} catch (IOException Erro) {
	 
					}
			}
		};
		return myListener;
	}
	
	private ActionListener listernerOfBotaoEditar() {//evento do botão Editar
		ActionListener myListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			    FileWriter arq;
				try {
					arq = new FileWriter(inputMatricula.getText() + ".txt");
				    PrintWriter gravarArq = new PrintWriter(arq);
				    gravarArq.printf("");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				CompletableFuture.delayedExecutor(2, TimeUnit.SECONDS).execute(() -> {
					int conversor = Integer.parseInt(inputMatricula.getText());
	                char conversor1 = inputSexo.getText().charAt(0);
	                
					estudantes.add(new Estudante(inputName.getText(), inputEndereco.getText(), conversor, conversor1));
					modelos.fireTableDataChanged();
					sla.escreverTexto(inputMatricula.getText() + ".txt", inputName.getText() + "\n" + inputEndereco.getText () + "\n" + inputMatricula.getText() + "\n" + inputSexo.getText() + "\n");
					JOptionPane.showMessageDialog(null, "Cadastro editado com sucesso");
				});
			}
		};
		return myListener;
	}
	private ActionListener listernerOfbotaoLimpar() {//evento do botão Excluir
		ActionListener myListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String arquivo = JOptionPane.showInputDialog(null,
						"Infome a Matricula para excluir:");
				JOptionPane.showMessageDialog(null, "Você excluiu o cadastro -> " + arquivo);
				boolean success = (new File(arquivo + ".txt")).delete();
				inputName.setText("");
				inputEndereco.setText("");
				inputMatricula.setText("");
				inputSexo.setText("");
			}
		};
		return myListener;
	}

	public static void main(String[] args) {
		tela tela = new tela();
		tela.setVisible(true);
	}
}