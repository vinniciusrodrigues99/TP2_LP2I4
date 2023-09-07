//Vinnicius O. Rodrigues

import javax.swing.*;
import java.util.UUID;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;

public class CadastrosAlunosForm extends JFrame {
    private List<Aluno> listaAlunos = new ArrayList<>();
    private JTextField nomeField, idadeField, enderecoField;
    private JLabel resultadoLabel;

    public CadastrosAlunosForm() {

        //definições padrões da box.
        setTitle("Cadastro de Alunos");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 10, 10)); // 3 rows, 2 columns, hgap=10, vgap=10

        //definição das variáveis 
        JLabel credito = new JLabel("Desenvolvedor: ");
        JLabel autores = new JLabel("Vinnicius O. Rodrigues");
        JLabel nomeLabel = new JLabel("nome:");
        nomeField = new JTextField();
        JLabel idadeLabel = new JLabel("idade:");
        idadeField = new JTextField();
        JLabel enderecoLabel = new JLabel("endereço:");
        enderecoField = new JTextField();

        //adicionando as variáveis na box
        inputPanel.add(credito);
        inputPanel.add(autores);
        inputPanel.add(nomeLabel);
        inputPanel.add(nomeField);
        inputPanel.add(idadeLabel);
        inputPanel.add(idadeField);
        inputPanel.add(enderecoLabel);
        inputPanel.add(enderecoField);

        //botões
        JPanel buttonPanel = new JPanel(new GridLayout(1, 5));
        JButton okButton = new JButton("Ok");
        JButton mostrarButton = new JButton("Mostrar");
        JButton limparButton = new JButton("Limpar");
        JButton sairButton = new JButton("Sair");
        resultadoLabel = new JLabel("");

        //inclusão dos botões na box
        buttonPanel.add(okButton);
        buttonPanel.add(mostrarButton);
        buttonPanel.add(limparButton);
        buttonPanel.add(sairButton);

        //funções
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                 //verificação do preenchimento
                if (nomeField.getText().isEmpty() || idadeField.getText().isEmpty()
                        || enderecoField.getText().isEmpty()) {
                    resultadoLabel.setText("Preencha todos os campos.");
                    return;
                } else {
                String nome = nomeField.getText();
                int idade = Integer.parseInt(idadeField.getText());
                String endereco = enderecoField.getText();
                UUID uuid = UUID.randomUUID();

                Aluno aluno = new Aluno(uuid, nome, idade, endereco);
                listaAlunos.add(aluno);

                //reset dos campos
                nomeField.setText("");
                idadeField.setText("");
                enderecoField.setText("");

                resultadoLabel.setText("Aluno cadastrado com sucesso.");
                }
            }
        });

        //função do botão de reset
        limparButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                nomeField.setText("");
                idadeField.setText("");
                enderecoField.setText("");
                resultadoLabel.setText("");
            }
        });

        //botão de exibição
        mostrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!listaAlunos.isEmpty()) {
                    StringBuilder message = new StringBuilder("Lista de Alunos:\n");
                    for (Aluno aluno : listaAlunos) {
                        message.append("UUID: ").append(aluno.getUuid()).append(", ");
                        message.append("Nome: ").append(aluno.getNome()).append(", ");
                        message.append("Idade: ").append(aluno.getIdade()).append(", ");
                        message.append("Endereço: ").append(aluno.getEndereco()).append("\n");
                    }
                    JOptionPane.showMessageDialog(null, message.toString(), "Lista de Alunos",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "A lista de alunos está vazia.", "Lista de Alunos",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        //botão de sair
        sairButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(inputPanel);
        mainPanel.add(buttonPanel);
        mainPanel.add(resultadoLabel);
        add(mainPanel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new CadastrosAlunosForm();
    }
}
