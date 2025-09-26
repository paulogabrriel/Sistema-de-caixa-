import javax.swing.JOptionPane;

public class SistemaDeCaixa {
    public static void main(String[] args) {

        double soma = 0;
        boolean rodando = true;

        while (rodando) {
            String opcao = JOptionPane.showInputDialog(
                    "MENU\n" + "1 - Registrar produto\n" + "2 - Finalizar compra\n" + "3 - Sair"
            );

            if (opcao == null) {
                continue;
            }

            if (opcao.equals("1")) {
                String valorDigitado = JOptionPane.showInputDialog("Digite o valor do produto:");

                try {
                    double valor = Double.parseDouble(valorDigitado);

                    if (valor < 0) {
                        JOptionPane.showMessageDialog(null, "Invalido!");
                    } else {
                        soma = soma + valor; // soma o produto no total
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Você precisa digitar um número.");
                }
            }

            else if (opcao.equals("2")) {
                double total = soma;


                if (total > 100) {
                    total = total * 0.9;
                }

                JOptionPane.showMessageDialog(null, "Total a pagar: R$ " + total);

                int nova = JOptionPane.showConfirmDialog(null, "Quer começar outra compra?");
                if (nova == JOptionPane.YES_OPTION) {
                    soma = 0;
                } else {
                    rodando = false;
                }
            }


            else if (opcao.equals("3")) {
                rodando = false;
            }


            else {
                JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        }
    }
}
