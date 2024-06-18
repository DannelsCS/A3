package Menu;

import Array.Inventario;
import item.Item;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Item itemB = new Item();
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
                    inventario.adicionar(new Item(0, nome, durabilidade, qtd, raridade, peso));
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
                    System.out.println("Qual o ID do item que você deseja editar?");
                    int ide = teclado.nextInt();
                    Item itemA = inventario.getLista()[ide];
                    if (inventario.pesquisar(ide) != -1){
                        System.out.println("""
                                Qual atributo você deseja editar?
                                [1] Nome
                                [2] Durabilidade
                                [3] Quantidade
                                [4] Raridade
                                [5] Peso
                                """);
                        int alternativaEdicao = teclado.nextInt();
                        switch (alternativaEdicao){
                            case 1:
                                System.out.println("Digite o novo nome:");
                                String a = teclado.next();
                                itemA.setNome(a);
                                break;
                            case 2:
                                System.out.println("Digite a nova durabilidade:");
                                int b = teclado.nextInt();
                                itemA.setDurabilidade(b);
                                break;
                            case 3:
                                System.out.println("Digite a nova quantidade:");
                                int c = teclado.nextInt();
                                itemA.setQuantidade(c);
                                break;
                            case 4:
                                System.out.println("Digite a nova Raridade:");
                                String d = teclado.next();
                                itemA.setRaridade(d);
                                break;
                            case 5:
                                System.out.println("Digite o novo peso:");
                                float e = teclado.nextFloat();
                                itemA.setPeso(e);
                                break;
                            default:
                                System.out.println("\u001B[31m" + "\n Comando Inv&aacute;lido! \n" + "\u001B[0m");
                                break;
                        }
                    }else {
                        System.out.println("ID não encontrado!");
                    }
                    System.out.println("Lista atualizada:");
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