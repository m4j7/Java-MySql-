package View;

import Controller.ControllerProduto;
import Model.Produto;

import java.util.Locale;
import java.util.*;

public class ViewProduto {

    Scanner leitor = new Scanner(System.in).useDelimiter("\n").useLocale(Locale.US);


    public void criaTabela(){

        ControllerProduto produtoController = new ControllerProduto ();
        produtoController.criaTabela();

    }

    public void cadastraProduto(){

        System.out.println("Digite o nome do produto");
        String prod = leitor.next();

        System.out.println("digite a quantidade");
        int quant = leitor.nextInt();

        Produto produto = new Produto(prod,quant);

        ControllerProduto produtoController = new ControllerProduto ();
        produtoController.cadastraProduto(produto);

    }

    public void mostraLista(){

        ControllerProduto pc = new ControllerProduto();
        List<Produto> listaDeProdutos = pc.mostraTabela();
        for(int i = 0; i < listaDeProdutos.size(); i++) {
            System.out.println(listaDeProdutos.get(i));
        }

    }

    public Produto retornaById(){

        Scanner entrada = new Scanner(System.in).useDelimiter("\n");
        Produto prod = new Produto();
        ControllerProduto pc = new ControllerProduto();

        System.out.println("Qual o id você quer selecionar:");

        prod = pc.seleionaById(entrada.nextInt());

        System.out.println("O produto selecionado foi:");
        System.out.println(prod);

        return prod;
    }



    public void editarProduto(Produto prod){

        Scanner entrada = new Scanner(System.in).useDelimiter("\n");
        ControllerProduto pc = new ControllerProduto();


        System.out.println("Escolha o que você quer editar: ");

        System.out.println("1-Nome-----2-Valor-----Quantidade;");

        switch (entrada.nextInt()){
            case 1:
                prod.setNome(entrada.next());
                break;
            case 3:
                prod.setQuantidade(entrada.nextInt());
                break;
            default:
                System.out.println("error");
        }

        pc.editarProduto(prod);

        System.out.println("Produto Editado!");
        System.out.println("Deseja Continuar?");
        System.out.println("1-Sim;2-Não;");

        switch (entrada.nextInt()){
            case 1:
                this.editarProduto(prod);
                break;
            case 2:
                System.out.println("Retornando ao Menu");
                break;
            default:
                System.out.println("Opção invalida");
        }
    }

    public void deletarProduto(Produto produto){

        ControllerProduto pc = new ControllerProduto();
        Scanner entrada = new Scanner(System.in).useDelimiter("\n");

        System.out.println("Tem certeza que deseja deletar o produto?");
        System.out.println("1-Sim;2-Não;");

        switch (entrada.nextInt()){
            case 1:
                pc.deletaProduto(produto);
                break;
            case 2:
                System.out.println("Operação cancelada");
                break;
            default:
                System.out.println("Opção invalida");
        }

    }




}



