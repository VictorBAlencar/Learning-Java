package service;

import model.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemDAO {
    //Cria a lista
    private static List<Item> listaItem = new ArrayList<>(); //Static compartilha a lista no sistema(banco de dados falso)

    //Salva na lista
    public void salvarItem(Item item){
        //JDBC para Banco de Dados(Connection, PreparedStatement, etc) ou lista estatica para testes
        listaItem.add(item);
    }

    //Mostra os itens na lista
    public static List<Item> getListaItem(){
        return listaItem;
    }
}