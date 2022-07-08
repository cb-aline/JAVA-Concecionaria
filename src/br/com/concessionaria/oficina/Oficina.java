package br.com.concessionaria.oficina;

import java.util.ArrayList;
import java.util.Random;

import br.com.concessionaria.estrutura.Peca;
import br.com.concessionaria.funcionarios.Mecanico;
import br.com.concessionaria.veiculos.Veiculo;

public class Oficina {
    //Atributos
    private String nomeOficina;
    private ArrayList<Mecanico> listaMecanico;
    private ArrayList<Peca> listaPecas;
    private ArrayList<Veiculo> listaVeiculo;
    private int pecasNecessarias;

    

    //Construtor
    public Oficina(String nomeOficina){
        this.nomeOficina = nomeOficina;
        listaVeiculo = new ArrayList<Veiculo>();
        listaMecanico = new ArrayList<Mecanico>();
        listaPecas = new ArrayList<Peca>();    
        System.out.println("=====//==========//==========//==========//==========//==========//==========//==========//==========//=====");
        System.out.println("Bem vindes a Oficina "+nomeOficina+"!");
    }

    //Métodos

    //Métodos de Adição
    //Lista de Veículos
    public void adicionarVeiculo(Veiculo nomeVeiculo){
        listaVeiculo.add(nomeVeiculo);

        //Adicionando quantidade aleatória de Peças
        Random rand = new Random();
        int numeroMaximo = 3;
        int numeroAleatorio = rand.nextInt(numeroMaximo)+1;
        
        if (numeroAleatorio == 3){
            listaPecas.add(new Peca("Peça K", 67.02f, "18/01/22"));
            listaPecas.add(new Peca("Peça L", 1.99f, "05/01/22"));
            listaPecas.add(new Peca("Peça M", 99.99f, "07/07/19"));
        }
        if (numeroAleatorio == 2){
                listaPecas.add(new Peca("Peça N", 9.13f, "08/06/21"));
                listaPecas.add(new Peca("Peça O", 82.69f, "02/06/20"));
        }
        if (numeroAleatorio == 1){
            listaPecas.add(new Peca("Peça P", 250f, "26/06/22"));
        }
        System.out.println("");
        System.out.println("Carro "+nomeVeiculo.getPlaca()+" adicionado.");  
        System.out.println("["+numeroAleatorio+" peça(s) adicionada(s) no estoque.]");
    }

    //Lista de Mecânicos
    public void adicionarMecanico(Mecanico nomeMecanico){
        listaMecanico.add(nomeMecanico);
    }
        
    //Lista de Peças
    public void adicionarPeca(Peca nomePeca){
        listaPecas.add(nomePeca);       
    }

    //Método de Exibição de Dados
    //Veículos
    public void exibirVeiculos(){
        System.out.println("");
        System.out.println("~~~~~~~ Lista de Veículos ~~~~~~~");
        System.out.println("Veículos Registrados = "+listaVeiculo.size());
        for (Veiculo veiculo : listaVeiculo){
            System.out.println("Placa: "+veiculo.getPlaca()+" - Ano: "+veiculo.getAno()+
                               " - Modelo: "+veiculo.getModelo()+" - Nº Chassi: "+veiculo.getNumeroChassi()+
                               " - Cor: "+veiculo.getCor()+" - Km: "+veiculo.getKmRodados());
        }
        System.out.println("");
        System.out.println("=====//==========//==========//==========//==========//==========//==========//==========//==========//=====");
    }

    //Mecânicos
    public void exibirMecanicos(){
        System.out.println("");
        System.out.println("~~~~~~~ Lista de Mecânicos ~~~~~~~");
        System.out.println("Mecânicos Registrados = "+listaMecanico.size());
        for (Mecanico mecanico : listaMecanico){
            System.out.println(mecanico.getNome()+" - Experiência: "+mecanico.getAnosExperiencia()+
            " anos - Carros(simultâneos): "+mecanico.getCarrosSimultaneos());
        }
        System.out.println("");
        System.out.println("=====//==========//==========//==========//==========//==========//==========//==========//==========//=====");
    }

    //Peças
    public void exibirPecas() {
        System.out.println("");
        System.out.println("~~~~~~~ Lista de Peças ~~~~~~~");
        System.out.println("Total de Peças = " + listaPecas.size());
        for (Peca peca : listaPecas) {
            System.out.println(peca.getNome()+"--> Preço Unitário: R$ "+peca.getValor()+
                                " - Adquirida em: "+peca.getDataCompra());
        }
        System.out.println("");
        System.out.println("=====//==========//==========//==========//==========//==========//==========//==========//==========//=====");
    }

    //Métodos de remoção
    //Veículo
    public void removerVeiculo(Veiculo nomeVeiculo){
        listaVeiculo.remove(nomeVeiculo);
        
        //Removendo quantidade aleatória de Peças
        Random rand = new Random();
        int numeroMaximo = 3;
        int numeroAleatorio = rand.nextInt(numeroMaximo)+1;
        
        for (int cont=1; cont<=numeroAleatorio; cont++){
            if(listaPecas.size()>0){
                int indexMaximo = listaPecas.size(); 
                int index = rand.nextInt(indexMaximo);
                listaPecas.remove(index);
            }
        }
        System.out.println("");
        System.out.println("Carro "+nomeVeiculo.getPlaca()+" removido.");  
        System.out.println("["+numeroAleatorio+" peça(s) removida(s) do estoque.]");
    
    }
    
    //Mecânico
    public void removerMecanico(Mecanico nomeMecanico){
        listaMecanico.remove(nomeMecanico);
        System.out.println("");
        System.out.println("~~~ REMOVENDO MECÂNICO ~~~");
        System.out.println("Mecânico ("+nomeMecanico.getNome()+") removido.");
    }

    //Peça
    public void removerPeca(Peca nomePeca){
        listaPecas.remove(nomePeca);
        System.out.println("");
        System.out.println("~~~ REMOVENDO PEÇA ~~~");
        System.out.println("Peça ("+nomePeca.getNome()+") removida.");
    }

    //Método de Revisão de Veículos
    public boolean realizarRevisaoVeiculos(){
        System.out.println("");
        System.out.println("~~~ REVISAR CARROS ~~~");
        if (listaVeiculo.size() == 0){
            System.out.println("Não há carros para revisar.");
            return false;
        }
        else if (getPecasNecessarias() > listaPecas.size()){
            int faltamPeca = getPecasNecessarias() - listaPecas.size();
            System.out.println("Não há peças suficientes para a revisão de todos os carros.");
            System.out.println("Por favor adicione "+faltamPeca+" peça(s).");
            return false;
        }
        else{
            // Manipular o atributo CarrosSimultaneos
            int totalCarrosSimultaneos = 0;
            for (Mecanico mecanico : listaMecanico) {
                totalCarrosSimultaneos = totalCarrosSimultaneos + mecanico.getCarrosSimultaneos();
            }
            if(totalCarrosSimultaneos < listaVeiculo.size()){
                System.out.println("Não há mecânicos suficientes para revisar "+listaVeiculo.size()+" carros simultaneamente.");
                return false;
            }
            else{
                System.out.println("Os carros estão sendo preparados para a revisão, aguarde...");
                System.out.println("");
                for (Veiculo veiculo : listaVeiculo) {
                    System.out.println("Carro de placa "+veiculo.getPlaca()+" será revisado.");
                }
                System.out.println("");
                for (Mecanico mecanico : listaMecanico) {
                    System.out.println("Mecânico "+mecanico.getNome()+" está diponível para revisão");
                }
                System.out.println("");
                System.out.println("Peças em estoque na Oficina: "+listaPecas.size());
                for (Peca peca : listaPecas) {
                    System.out.println(peca.getNome()+" - Preço: R$ "+peca.getValor()+
                                        " - Data da Compra: "+peca.getDataCompra());
                                    }
                 System.out.println("");
                System.out.println("=====//==========//==========//==========//==========//==========//==========//==========//==========//=====");
                return true;
            }    
        }
    }

    //Método de Revisão de Peças
    public int verficarPecasRevisao(){
        System.out.println("");
        System.out.println("~~~ VERIFICAR PEÇAS DE REVISÃO ~~~");
        pecasNecessarias = 0;
        if (listaVeiculo.size() == 0){
            System.out.println("Não há carros a serem revisados.");
        }
        else{
            for (int cont=1; cont<=listaVeiculo.size(); cont++){
                Random rand = new Random();
                int numeroMaximo = 3;
                int numeroAleatorio = rand.nextInt(numeroMaximo)+1;
                pecasNecessarias = pecasNecessarias + numeroAleatorio;
            }
            System.out.println("Para revisar "+listaVeiculo.size()+
            " veículo(s) serão necessárias "+pecasNecessarias+" peças.");
        }
        return pecasNecessarias;
    }

    //Método Valor das Peças (Total)
    public float valorTotalPecas(){
        System.out.println("");
        System.out.println(" ~~~ TABELA DE PREÇO DAS PEÇAS ~~~");
        float valorTotalPecas = 0;
        for (Peca peca : listaPecas) {
            System.out.println(peca.getNome()+" - R$ "+peca.getValor());
            valorTotalPecas = valorTotalPecas + peca.getValor();
        }
        System.out.println("");
        System.out.println("Valor total das Peças = "+valorTotalPecas);
        return valorTotalPecas;
    }
    
    //Getters & Setters
    public String getNomeOficina() {
        return nomeOficina;
    }
    public void setNomeOficina(String nomeOficina) {
        this.nomeOficina = nomeOficina;
    }
    public ArrayList<Mecanico> getListaMecanico() {
        return listaMecanico;
    }
    public void setListaMecanico(ArrayList<Mecanico> listaMecanico) {
        this.listaMecanico = listaMecanico;
    }
    public ArrayList<Peca> getListaPecas() {
        return listaPecas;
    }
    public void setListaPecas(ArrayList<Peca> listaPecas) {
        this.listaPecas = listaPecas;
    }
    public ArrayList<Veiculo> getListaVeiculo() {
        return listaVeiculo;
    }
    public void setListaVeiculo(ArrayList<Veiculo> listaVeiculo) {
        this.listaVeiculo = listaVeiculo;
    }
    public int getPecasNecessarias() {
        return pecasNecessarias;
    }
    public void setPecasNecessarias(int pecasNecessarias) {
        this.pecasNecessarias = pecasNecessarias;
    }  
}