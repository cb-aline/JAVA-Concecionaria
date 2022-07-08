package br.com.concessionaria;

import br.com.concessionaria.estrutura.Peca;
import br.com.concessionaria.funcionarios.Mecanico;
import br.com.concessionaria.oficina.Oficina;
import br.com.concessionaria.veiculos.Veiculo;


public class Main {
    public static void main(String[] args) {
        Oficina oficina = new Oficina("Cars&Tools");
            
        Mecanico mecanico1 = new Mecanico("Samuel", 10, 3);
        Mecanico mecanico2 = new Mecanico("Arthur", 5, 2);
        Mecanico mecanico3 = new Mecanico("Ezequiel", 3, 1);

        Peca peca1 = new Peca("Peça A", 5.87f, "12/05/22");
        Peca peca2 = new Peca("Peça B", 56.98f, "15/05/22");
        Peca peca3 = new Peca("Peça C", 12.10f, "22/04/22");
        Peca peca4 = new Peca("Peça D", 33f, "01/01/22");
        Peca peca5 = new Peca("Peça E", 105.65f, "19/05/22");
        Peca peca6 = new Peca("Peça F", 91f, "08/05/22");
        Peca peca7 = new Peca("Peça G", 78.33f, "03/06/22");
        Peca peca8 = new Peca("Peça H", 42.5f, "30/03/22");
        Peca peca9 = new Peca("Peça I", 19.99f, "28/05/22");
        Peca peca10 = new Peca("Peça J", 13.13f, "16/01/22");
               
        Veiculo veiculo1 = new Veiculo("RTA8359",2018, 20145, "9BWZ91Z377VT183Z1", "CINZA", 4621);
        Veiculo veiculo2 = new Veiculo("HKS8780",2021, 20236, "VG54G5A54G870GY02", "VERDE", 1253);
        Veiculo veiculo3 = new Veiculo("LOT2208",2016, 2443, "L12E34G56E78N9D0S", "LARANJA", 122);
        
        
        oficina.adicionarMecanico(mecanico1);
        oficina.adicionarMecanico(mecanico2);
        oficina.adicionarMecanico(mecanico3);
        
        oficina.adicionarPeca(peca1);
        oficina.adicionarPeca(peca2);
        oficina.adicionarPeca(peca3);
        oficina.adicionarPeca(peca4);
        oficina.adicionarPeca(peca5);
        oficina.adicionarPeca(peca6);
        oficina.adicionarPeca(peca7);
        oficina.adicionarPeca(peca8);
        oficina.adicionarPeca(peca9);
        oficina.adicionarPeca(peca10);

        oficina.adicionarVeiculo(veiculo1);
        oficina.adicionarVeiculo(veiculo2);
        oficina.adicionarVeiculo(veiculo3);


        oficina.verficarPecasRevisao();
        oficina.realizarRevisaoVeiculos();

    }
}