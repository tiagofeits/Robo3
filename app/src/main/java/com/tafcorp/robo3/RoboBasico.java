package com.tafcorp.robo3;

public class RoboBasico implements InterfaceRoboPobre{
    private int caminho=1;
    public int processarTexto(String val, MainActivity resposta){

        switch(caminho){
            case 1:{
                return fluxo1(val, resposta);
            }
            case 2:{
                return 0;
            }
            default:{
                resposta.escreverTexto("Ainda não sei responder essa pergunta. Vou ter que desconectar. Até breve!");
                return 0;
            }
        }
    }

    public int fluxo1(String val, MainActivity resposta){
        if(val.contains("eu")){
            resposta.escreverTexto("A responsabilidade é sua. Se vira!");
            return 1;
        }
        if(val.contains("você") || val.contains("voce")){
            resposta.escreverTexto("Eu não tenho nada a ver com isso.");
            return 1;
        }
        if(val.contains("matematica") || val.contains("matemática") || val.contains("conta")){
            resposta.escreverTexto("Vou chamar o robô matemático para te ajudar!");
            resposta.escreverTexto("Olá, sou o robô matemático! Escreva sua equação e eu tentarei resolver.");
            resposta.escreverTexto("No momento sei resolver operações de: ");
            resposta.escreverTexto("soma, subtração, multiplicação e divisão de dois números.");
            resposta.escreverTexto("Para voltar para o menu principal digite 'voltar'");
            return -2;
        }
        if(val.contains("voltar")){
            resposta.escreverTexto("De volta ao robô alienígena!");
            return -1;
        }
        if(val.contains("sou chique")){
            resposta.escreverTexto("Vou chamar o robô premium.");
            return -3;
        }
        else{
            resposta.escreverTexto("Tudo bem. Como quiser.");
            return 1;
        }
    }
}
