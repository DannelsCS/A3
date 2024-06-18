package Menu;

import Array.Inventario;
import exemplo.Array;
import item.Item;

import java.util.Arrays;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Item itemA = new Item();
        int comando = 0;
        Inventario inventario = new Inventario();
        while(comando != 5) {
            System.out.println("""
                    ~~~~~~~~~~ Gerenciamento ~~~~~~~~~~
                    [1] Adicionar item no inventário.
                    [2] Remover item do inventário.
                    [3] Acessar o inventário.
                    [4] Editar item do inventário.
                    [5] Sair.
                    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                    
                    Digite o valor para acessar a função:
                    """);
            int alternativa = teclado.nextInt();
            switch (alternativa){
                case 1:
                    System.out.println("Digite o nome do item:");
                    String nome = teclado.next();
                    System.out.println("Digite a durabilidade do item:");
                    int durabilidade = teclado.nextInt();
                    System.out.println("Digite a quantidade de itens:");
                    int qtd = teclado.nextInt();
                    System.out.println("Digite a raridade do item:");
                    String raridade = teclado.next();
                    System.out.println("Digite o peso do item:");
                    float peso = teclado.nextFloat();
                    inventario.adicionar(new Item(nome, durabilidade, qtd, raridade, peso));
                    System.out.println("Item cadastrado com sucesso!");
                    break;
                case 2:
                    for (Item item : inventario.getLista()) {
                        System.out.println(item);
                    }
                    System.out.println("Digite o id do item que você deseja remover:");
                    int id = teclado.nextInt();
                    if (inventario.pesquisar(id) != -1){
                        inventario.removerItem(id);
                        System.out.println("Item removido com sucesso!");
                    }else {
                        System.out.println("Item não encontrado!");
                    }

                    break;
                case 3:
                    for (Item item : inventario.getLista2()) {
                        System.out.println(item);
                    }
                    break;
                case 4:


                   /* Usar switch case

                   System.out.println("Digite o ID do item que deseja atualizar:");
                    int idi = teclado.nextInt();
                    System.out.println("Digite o nome do item:");
                    String name = teclado.next();
                    System.out.println("Digite a durabilidade do item:");
                    int durability = teclado.nextInt();
                    System.out.println("Digite a quantidade do item:");
                    int quant = teclado.nextInt();
                    System.out.println("Digite o peso do item:");
                    float pes = teclado.nextFloat();
                    System.out.println("Digite a raridade do item:");
                    String rar = teclado.next();


                    boolean atualizado = itemA.atualizarItem(idi, name, durability, quant, pes, rar);
*/
                    if (atualizado) {
                        System.out.println("\nItem com ID " + idi + " atualizado com sucesso.");
                    } else {
                        System.out.println("\nItem com ID " + idi + " n&atilde;o encontrado.");
                    }
                    System.out.println("Itens atualizados:");
                    // Exibe os itens novamente ap&oacute;s a atualiza&ccedil;&atilde;o
                    for (Item item : inventario.getLista2()) {
                        System.out.println(item);
                    }
                    break;
                case 5:
                System.out.println("At&eacute; mais!");
                    comando = 5;
                    break;
                default:
                System.out.println("\u001B[31m" + "\n Comando Inv&aacute;lido! \n" + "\u001B[0m");
                break;
            }

        }
        teclado.close();
    }
}
