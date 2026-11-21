import java.util.Random;
import java.util.ArrayList;

public abstract class Veiculo{
    private String marca;
    private String modelo;

    public Veiculo(String marca, String modelo){
        this.marca = marca;
        this.modelo = modelo;
    }

    public String getMarca(){
        return marca;
    }

    public String getModelo(){
        return modelo;
    }

    public abstract void acelerar();
    
    public void exibirInformacoes(){
        System.out.println("Marca: " + marca + "Modelo: " + modelo);
    }
}

class Carro extends Veiculo{
    public Carro(String marca, String modelo){
        super(marca, modelo);
    }

    @Override
    public void acelerar(){
        System.out.println("Carro esta acelerando");
    }
}

class CarroEletrico extends Carro implements Eletrico, Rastreavel{
    public CarroEletrico(String marca, String modelo){
        super(marca, modelo);
    }

    @Override
    public void carregarBateria(){
        System.out.println("Carregando bateria");
    }

    @Override  
    public void localizar(){
        System.out.println("Localizando veiculo");
    }
}

class Moto extends Veiculo implements Rastreavel{
    public Moto(String marca, String modelo){
        super(marca, modelo);
    }

    @Override
    public void acelerar(){
        System.out.println("Moto esta acelerando");
    }

    @Override 
    public void localizar(){
        System.out.println("Rastreando Moto");
    }
}

interface Eletrico{
    void carregarBateria();
}

interface Rastreavel{
    void localizar();
}

class Main{
    public static void main(String[] args){
        Random gerador = new Random();
        ArrayList<Veiculo> lista = new ArrayList<>();

        for(int i = 0; i < 10; i++){
            switch(gerador.nextInt(3)){
                case 0:
                    lista.add(new Carro("Vagem", "Fox"));
                    break;
                case 1:
                    lista.add(new Moto("Honda", "Fan"));
                    break;
                case 2:
                    lista.add(new CarroEletrico("Byd", "Nsei"));
                    break;
            }
        }
        for(Veiculo veiculo : lista){
            if(veiculo instanceof Carro){
                if(veiculo instanceof CarroEletrico){
                CarroEletrico carroEletrico = (CarroEletrico) veiculo;
                carroEletrico.exibirInformacoes();
                carroEletrico.acelerar();
                }
                else{
                    Carro carro = (Carro) veiculo;
                    carro.exibirInformacoes();
                    carro.acelerar();
                }
            }
            else if(veiculo instanceof Moto){
                Moto moto = (Moto) veiculo;
                moto.exibirInformacoes();
                moto.acelerar();
            }
        }
    }
}