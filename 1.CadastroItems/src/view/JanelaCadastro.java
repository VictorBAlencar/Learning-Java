package view;

import model.Item;
import service.ItemDAO;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;

public class JanelaCadastro extends JFrame {

    //Propriedades

    //Nome
    private JLabel lblNome = new JLabel("Nome");
    private JTextField txtNome = new JTextField(); //limite de caracteres

    //Preco
    private JLabel lblPreco = new JLabel("Preco");
    private JTextField txtPreco = new JTextField(); //limite de caracteres

    //Botao
    private JButton btnSalvar = new JButton("Salvar");
    private JButton btnListar = new JButton("Listar");

    //Janela
    public JanelaCadastro() {
        //JFrame
        setTitle("Cadastro de Itens");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10,10));

        //Action Listeners
        btnSalvar.addActionListener(e -> botaoSalvar());
        btnListar.addActionListener(e -> botaoListar());

        //Grid Layout - Painel
        JPanel painelFormulario = new JPanel();
        painelFormulario.setLayout(new GridLayout(2,2,5,5));
        painelFormulario.setBorder(new EmptyBorder(10,10,10,10)); //Ajuda a nao colar na borda
        //Adicionar itens ao painel
        painelFormulario.add(lblNome);
        painelFormulario.add(txtNome);

        painelFormulario.add(lblPreco);
        painelFormulario.add(txtPreco);

        //Adicionar Painel a Janela
        this.add(painelFormulario, BorderLayout.NORTH); // no Topo ou no Centro

        //Painel - Botoes
        JPanel painelBotao = new JPanel(); //por padrao fica um do lado do outro em FlowLayout

        //Adicionar itens ao painel
        painelBotao.add(btnSalvar);
        painelBotao.add(btnListar);

        //Adicionar o Botao no Final da Tela
        this.add(painelBotao, BorderLayout.SOUTH);

    }

    private void botaoSalvar() {
        try {
            String nome = txtNome.getText();
            double preco = Double.parseDouble(txtPreco.getText());

            Item item = new Item(nome, preco);
            ItemDAO itemDAO = new ItemDAO();
            itemDAO.salvarItem(item);

            JOptionPane.showMessageDialog(this, "Salvo com sucesso!");

            // Limpar campos
            txtNome.setText("");
            txtPreco.setText("");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro: Erro ao salvar, possivelmente no preco!");
        }
    }

    private void botaoListar() {
        try{
            ItemDAO itemDAO = new ItemDAO();

            java.util.List<Item> listaItem = itemDAO.getListaItem();

            if(listaItem.isEmpty()){
                JOptionPane.showMessageDialog(this, "Nenhum item encontrado!");
            }else {
                for (Item i : listaItem) {
                    System.out.println("Produto: " + i.getNome() + " | R$: " + i.getPreco());
                }
            }
        } catch(Exception e){
            JOptionPane.showMessageDialog(this, "Erro: Erro ao listar!");
        }
    }
}