package com.tafcorp.robo3;

public class RoboPersonalizado
        extends RoboMatematico
        implements InterfaceRoboPremium {
    private int caminho=2;
    public int processarTexto(String val, MainActivity resposta){

        switch(caminho){
            case 1:{
                return fluxo1(val, resposta);
            }
            case 2:{
                return fluxo2(val, resposta);
            }
            default:{
                resposta.escreverTexto("Ainda não sei responder essa pergunta. Vou ter que desconectar. Até breve!");
                return 0;
            }
        }
    }
    public int fluxo2(String val, MainActivity resposta){
        StringBuilder s = new StringBuilder();
        if(val.contains("piada")){
            resposta.escreverTexto("Escolha o tema da sua piada!");
            return 1;
        }
        if(val.contains("galinha")){
            resposta.escreverTexto("A galinha faz cocó, e o frango faz cocô.");
            return 1;
        }
        if(val.contains("matematica") || val.contains("matemática") || val.contains("conta")){
            s.append("Vou chamar o robô matemático para te ajudar!");
            s.append("Olá, sou o robô matemático! Escreva sua equação e eu tentarei resolver.");
            s.append("No momento sei resolver operações de: ");
            s.append("soma, subtração, multiplicação e divisão de dois números.");
            s.append("Para voltar para o menu principal digite 'voltar'");
            resposta.escreverTexto(s.toString());
            return -2;
        }
        if(val.contains("voltar")){
            resposta.escreverTexto("De volta ao robô alienígena!");
            return -1;
        }
        if(val.contains("ganso")){
            resposta.escreverTexto("O ganso comeu uma maçã e se engasgou.");
            return 1;
        }
        if(val.contains("bode")){
            resposta.escreverTexto("Nunca coloque um bode na sala. Ele vai comer o sofá.");
            return 1;
        }
        if(val.contains("et")){
            resposta.escreverTexto("Não acredito em alienígenas. Eles são muito mentirosos.");
            return 1;
        }
        else{
            resposta.escreverTexto("Só sei contar piadas...");
            return 1;
        }
    }
}
