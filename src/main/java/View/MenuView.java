package View;

import java.util.Scanner;

public class MenuView {

    public void menu(){

        Scanner leitor = new Scanner(System.in).useDelimiter("\n");
        ViewProduto pv = new ViewProduto();

        pv.criaTabela();

        System.out.println("Escolha uma opção:");

        System.out.println("  1 - Cadastrar Produto ");
        System.out.println("  2 - Mostrar Produtos  ");
        System.out.println("  3 - Editar Produto    ");
        System.out.println("  4 - Deletar Produto   ");


        switch (leitor.nextInt()){
            case 1:
                pv.cadastraProduto();
                this.menu();
                break;
            case 2:
                pv.mostraLista();
                this.menu();
                break;
            case 3:
                pv.mostraLista();
                pv.editarProduto(pv.retornaById());
                this.menu();
                break;
            case 4:
                pv.mostraLista();
                pv.deletarProduto(pv.retornaById());
                this.menu();
                break;
            default:
                System.out.println("Opção invalida");
        }
    } }
