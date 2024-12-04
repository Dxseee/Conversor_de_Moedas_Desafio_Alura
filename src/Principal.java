import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        String menu = """
                ****************************************************
                Seja bem vindo ao convertor de Moedas =]
                
                1) Dolar =>> Peso Argentino
                2) Peso Argentino =>> Dolar
                3) Dolar =>> Real Brasileiro
                4) Real Brasileiro =>> Dolar
                5) Dolar =>> Peso Comlobiano
                6) Peso Colombiano =>> Dolar
                7) Sair
                Escolha uma opção valida: 
                ****************************************************               
                """;
        Scanner leitura = new Scanner(System.in);
        RequestExchangeRate exchangeRate = new RequestExchangeRate();
        int escolha = 0;

        while(escolha != 7){
            System.out.println(menu);
            escolha = leitura.nextInt();
            if (escolha <= 0 || escolha >= 7) {
                if (escolha == 7){
                    break;
                }else {
                    System.out.println("Escolha invalida!!!!!!");
                }
            } else{
                System.out.println("Digite o valor para fazer a conversão: ");
                double ammountConvert = leitura.nextDouble();
                RequestsData.setAmmount(ammountConvert);

                try {
                    switch (escolha){
                        case 1:
                            RequestsData exchangeRateEscolhido = exchangeRate.requisitarMoedaCambio("USD/ARS/",RequestsData.getAmmount());
                            System.out.println(exchangeRateEscolhido);
                            break;
                        case 2:
                            exchangeRateEscolhido = exchangeRate.requisitarMoedaCambio("ARS/USD/",RequestsData.getAmmount());
                            System.out.println(exchangeRateEscolhido);
                            break;
                        case 3:
                            exchangeRateEscolhido = exchangeRate.requisitarMoedaCambio("USD/BRL/",RequestsData.getAmmount());
                            System.out.println(exchangeRateEscolhido);
                            break;
                        case 4:
                            exchangeRateEscolhido = exchangeRate.requisitarMoedaCambio("BRL/USD/",RequestsData.getAmmount());
                            System.out.println(exchangeRateEscolhido);
                            break;
                        case 5:
                            exchangeRateEscolhido = exchangeRate.requisitarMoedaCambio("USD/COP/",RequestsData.getAmmount());
                            System.out.println(exchangeRateEscolhido);
                            break;
                        case 6:
                            exchangeRateEscolhido = exchangeRate.requisitarMoedaCambio("COP/USD/",RequestsData.getAmmount());
                            System.out.println(exchangeRateEscolhido);
                            break;
                        case 7:
                            System.out.println("Aplicação Finalizado");
                            break;

                    }



                } catch (RuntimeException | IOException | InterruptedException e) {
                    System.out.println(e.getMessage());
                    System.out.println("Finalizando a aplicação");
                }
            }
        }

    }
}