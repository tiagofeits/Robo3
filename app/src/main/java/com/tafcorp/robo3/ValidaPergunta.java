package com.tafcorp.robo3;

import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class ValidaPergunta {
    private static final int LIMITE_PACIENCIA = 3;
    private final Pattern caps = Pattern.compile(".*[A-Z].*");
    private RoboBasico marciano = new RoboBasico();
    private RoboPersonalizado chiquetoso = new RoboPersonalizado();
    private RoboMatematico skynet = new RoboMatematico();
    private BufferedReader br;
    public int robo=0;
    public int resultado=0;
    private int maleducado=0;
    private boolean continuar=false;
    private void validarResposta(int val){
        switch(val) {
            //chamar robô básico
            case -1: {
                robo=1;
                continuar=true;
                break;
            }
            //chamar robô calculadora
            case -2: {
                robo=2;
                continuar=true;
                break;
            }
            //chamar robô premium
            case -3: {
                robo=3;
                continuar=true;
                break;
            }
            case 0: {
                continuar=false;
                break;
            }
            default: {
                continuar=true;
                break;
            }
        }
    }
    public void validar(String linha, MainActivity resposta) throws IOException{

        if(caps.matcher(linha).matches()) {
            resposta.escreverTexto("Escrever com letras maiúsculas é uma forma de gritar em mensagens de texto. Por favor evite de fazer isso.");
            maleducado++;
            if(maleducado>LIMITE_PACIENCIA){
                resposta.escreverTexto("Já chega. Esgotou minha paciência.");
                System.exit(0);
            }
        }
        else{
            if(linha.isEmpty()){
                resposta.escreverTexto("Não me incomode!");
            }
        }
        linha=linha.toLowerCase();
        switch(linha){
            default:{
                switch(robo){
                    case 2:{
                        validarResposta(skynet.processarTexto(linha.toLowerCase(), resposta));
                        break;
                    }
                    case 3:{
                        validarResposta(chiquetoso.processarTexto(linha.toLowerCase(), resposta));
                        break;
                    }
                    default:{
                        validarResposta(marciano.processarTexto(linha.toLowerCase(), resposta));
                        break;
                    }
                }
                break;
            }
            case "sair":
            case "quit":
            case "exit":
            case "end":
            case "stop":
            case "fim":{
                continuar=false;
                break;
            }
        }
        if(!continuar) System.exit(0);
    }
}
