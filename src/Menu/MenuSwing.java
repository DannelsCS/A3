package Menu;

import Array.Inventario;
import item.Item;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuSwing {
    private JFrame frame;
    private JTextField nomeField;
    private JTextField durabilidadeField;
    private JTextField quantidadeField;
    private JTextField raridadeField;
    private JTextField pesoField;
    private JTextField idField;
    private JTextArea displayArea;
    private Inventario inventario;

    public MenuSwing() {
        inventario = new Inventario();
        frame = new JFrame("Gerenciamento de Inventário");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));

        panel.add(new JLabel("Nome:"));
        nomeField = new JTextField();
        panel.add(nomeField);

        panel.add(new JLabel("Durabilidade:"));
        durabilidadeField = new JTextField();
        panel.add(durabilidadeField);

        panel.add(new JLabel("Quantidade:"));
        quantidadeField = new JTextField();
        panel.add(quantidadeField);

        panel.add(new JLabel("Raridade:"));
        raridadeField = new JTextField();
        panel.add(raridadeField);

        panel.add(new JLabel("Peso:"));
        pesoField = new JTextField();
        panel.add(pesoField);

        panel.add(new JLabel("ID (para remover/editar):"));
        idField = new JTextField();
        panel.add(idField);

        frame.add(panel, BorderLayout.NORTH);

        displayArea = new JTextArea();
        frame.add(new JScrollPane(displayArea), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();

        JButton addButton = new JButton("Adicionar Item");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarItem();
            }
        });
        buttonPanel.add(addButton);

        JButton removeButton = new JButton("Remover Item");
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removerItem();
            }
        });
        buttonPanel.add(removeButton);

        JButton viewButton = new JButton("Acessar Inventário");
        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                acessarInventario();
            }
        });
        buttonPanel.add(viewButton);

        JButton editButton = new JButton("Editar Item");
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editarItem();
            }
        });
        buttonPanel.add(editButton);

        JButton exitButton = new JButton("Sair");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        buttonPanel.add(exitButton);

        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    private void adicionarItem() {
        String nome = nomeField.getText();
        int durabilidade = Integer.parseInt(durabilidadeField.getText());
        int quantidade = Integer.parseInt(quantidadeField.getText());
        String raridade = raridadeField.getText();
        float peso = Float.parseFloat(pesoField.getText());
        Item item = new Item(nome, durabilidade, quantidade, raridade, peso);
        inventario.adicionar(item);
        displayArea.setText("Item cadastrado com sucesso!\n");
        clearFields();
    }

    private void removerItem() {
        int id = Integer.parseInt(idField.getText());
        if (inventario.pesquisar(id) != -1) {
            inventario.removerItem(id);
            displayArea.setText("Item removido com sucesso!\n");
        } else {
            displayArea.setText("Item não encontrado!\n");
        }
        clearFields();
    }

    private void acessarInventario() {
        displayArea.setText("");
        for (Item item : inventario.getLista()) {
            displayArea.append(item.toString() + "\n");
        }
    }

    private void editarItem() {
        int id = Integer.parseInt(idField.getText());
        int index = inventario.pesquisar(id);
        if (index != -1) {
            Item item = inventario.pesquisarItem(id);
            String[] options = {"Nome", "Durabilidade", "Quantidade", "Raridade", "Peso"};
            String input = (String) JOptionPane.showInputDialog(frame,
                    "Qual atributo você deseja editar?",
                    "Editar Item",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]);

            switch (input) {
                case "Nome":
                    String nome = JOptionPane.showInputDialog("Digite o novo nome:");
                    item.setNome(nome);
                    break;
                case "Durabilidade":
                    int durabilidade = Integer.parseInt(JOptionPane.showInputDialog("Digite a nova durabilidade:"));
                    item.setDurabilidade(durabilidade);
                    break;
                case "Quantidade":
                    int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Digite a nova quantidade:"));
                    item.setQuantidade(quantidade);
                    break;
                case "Raridade":
                    String raridade = JOptionPane.showInputDialog("Digite a nova raridade:");
                    item.setRaridade(raridade);
                    break;
                case "Peso":
                    float peso = Float.parseFloat(JOptionPane.showInputDialog("Digite o novo peso:"));
                    item.setPeso(peso);
                    break;
                default:
                    break;
            }
            displayArea.setText("Item editado com sucesso!\n");
        } else {
            displayArea.setText("ID não encontrado!\n");
        }
        clearFields();
    }

    private void clearFields() {
        nomeField.setText("");
        durabilidadeField.setText("");
        quantidadeField.setText("");
        raridadeField.setText("");
        pesoField.setText("");
        idField.setText("");
    }

    public static void main(String[] args) {
        new MenuSwing();
    }
}
