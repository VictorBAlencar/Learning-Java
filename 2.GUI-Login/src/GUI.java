import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class GUI extends JFrame {

    public GUI() {
        //Atributos da Janela
        setTitle("Login");
        setSize(350, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10,10));

        //Login e Senha
        JPanel formPanel = new JPanel(new GridLayout(2,2,10,10));
        formPanel.setBorder(new EmptyBorder(20,20,20,20));

        // Layout do Grid

        //  //
        //  //
        //  //

        //Preencher o Grid seguindo a ordem esquerda -> direita / cima -> baixo
        formPanel.add(new JLabel("Username:"));
        formPanel.add(new JTextField());

        formPanel.add(new JLabel("Password:"));
        formPanel.add(new JPasswordField());

        //Botoes
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBorder(new EmptyBorder(0,0,10,0));
        //Colocar os botoes
        JButton btnLogin = new JButton("Login");
        btnLogin.setPreferredSize(new Dimension(100,30));
        buttonPanel.add(btnLogin);

        //Colocar paineis no frame
        add(formPanel,BorderLayout.CENTER);
        add(buttonPanel,BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        new GUI();
    }
}