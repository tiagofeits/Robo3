package com.tafcorp.robo3;

public class RoboMatematico extends RoboBasico{
    private int caminho=2;
    public int processarTexto(String val, MainActivity resposta){
        if(val.equals("voltar")) caminho=1;
        switch(caminho){
            case 1:{
                return fluxo1(val, resposta);
            }
            case 2:{
                return fluxoMat(val, resposta);
            }
            default:{
                resposta.escreverTexto("Ainda não sei responder essa pergunta. Vou ter que desconectar. Até breve!");
                return caminho;
            }
        }
    }

    public int validarEquacao(String val, MainActivity resposta){
        String[] numeros=null;
        int val1 = 0;
        int val2 = 0;
        int operacao =0;
        StringBuilder s=new StringBuilder();
        try {
            if(val.contains("+")){
                numeros = val.split("\\+");
                operacao=1;
            }
            if(val.contains("-")){
                numeros = val.split("-");
                operacao=2;
            }
            if(val.contains("*")){
                numeros = val.split("\\*");
                operacao=3;
            }
            if(val.contains("/")){
                numeros = val.split("/");
                operacao=4;
            }
            if(numeros.length == 2){
                val1 = Integer.parseInt(numeros[0]);
                val2 = Integer.parseInt(numeros[1]);
                switch (operacao){
                    case 1:{
                        return val1 + val2;
                    }
                    case 2:{
                        return val1 - val2;
                    }
                    case 3:{
                        return val1 * val2;
                    }
                    case 4:{
                        return val1 / val2;
                    }
                }
            }
            s.append("Equação inválida. Tente novamente! " +
                    "No momento suportamos operações de: ");
            s.append("soma, subtração, multiplicação e divisão de dois números.");
            resposta.escreverTexto(s.toString());
            return 0;
        } catch (Exception e) {
            throw new ArithmeticException();
        }
    }

    public int fluxoMat(String val, MainActivity resposta){
        Object resultado;
        StringBuilder s=new StringBuilder();
        try {
            resultado=validarEquacao(val, resposta);
            resposta.escreverTexto("A resposta para sua equação é: " + resultado.toString());
            caminho=2;
            return 1;
        } catch (Exception e) {
            s.append("Equação inválida. Tente novamente! " +
                    "No momento suportamos operações de: ");
            s.append("soma, subtração, multiplicação e divisão de dois números.");
            resposta.escreverTexto(s.toString());
            caminho=1;
            return 1;
        }
    }
}
