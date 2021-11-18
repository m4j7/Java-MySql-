package Controller;

import Dao.DaoProduto;
import Model.Produto;

import java.util.List;

public class ControllerProduto {


   public void criaTabela(){

      DaoProduto prodDao = new DaoProduto();
      prodDao.criaTabela();

   }

   public void cadastraProduto(Produto produto){

      DaoProduto prodDao = new DaoProduto();
      prodDao.gravaNoBanco(produto);

   }

   public List<Produto> mostraTabela(){

      DaoProduto prodDao = new DaoProduto();
      return prodDao.mostraLista();

   }

   public Produto seleionaById(int id){

      DaoProduto prodDao = new DaoProduto();
      return prodDao.SelecionaId(id);
   }

   public void editarProduto(Produto produto){
      DaoProduto prodDao = new DaoProduto();
      prodDao.editarProdutoDoBanco(produto);
   }

   public void deletaProduto(Produto produto){
      DaoProduto prodDao = new DaoProduto();
      prodDao.removeProdutoDoBanco(produto);
   }

}
