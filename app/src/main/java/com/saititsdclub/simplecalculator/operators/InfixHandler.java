package com.saititsdclub.simplecalculator.operators;

import android.provider.Settings;
import android.util.Log;

import java.util.ArrayList;
import java.util.Queue;

/**
 * Created by Tien on 2017-02-19.
 */

public class InfixHandler {

    private String infix;
    private ArrayList<String> postfix;
    private ArrayList<Character> stack;


    public InfixHandler(String infix){
        this.infix=infix;
        postfix=new ArrayList<>();
        stack=new ArrayList<>();
    }

    public ArrayList<String> getPostfix(){
        String infix=this.infix;

        //While there's still something left infix
        while (infix.length()>0){

            if (isNumberNext(infix)){

                //if it's a number, get the number
                int number=getFirstNumber(infix);
                infix=trimFirstNumber(infix);

                postfix.add(Integer.toString(number));
            }else{

                //if it's a sign, get the sign
                char sign=infix.charAt(0);
                infix=infix.substring(1);

                if (sign=='('){
                    stack.add(sign);
                }else if(stack.isEmpty()){
                    stack.add(sign);
                }else if (sign=='+' || sign =='-'){

                    while ((!stack.isEmpty()) && ((stack.get(stack.size()-1)=='/') || (stack.get(stack.size()-1)=='*') || (stack.get(stack.size()-1))=='+' || (stack.get(stack.size()-1)=='-')) && (stack.get(stack.size()-1)!='(')){
                        postfix.add(Character.toString(stack.remove(stack.size()-1)));
                    }

                    stack.add(sign);
                }else if (sign=='*' || sign =='/'){

                    while ((stack.get(stack.size()-1)=='/' || stack.get(stack.size()-1)=='*') && stack.get(stack.size()-1)!='('){
                        postfix.add(Character.toString(stack.remove(stack.size()-1)));
                    }

                    stack.add(sign);
                }else if (sign==')'){
                    while (stack.get(stack.size()-1)!='('){
                        postfix.add(Character.toString(stack.remove(stack.size()-1)));
                    }
                    if (stack.get(stack.size()-1)=='('){
                        stack.remove(stack.size()-1);
                    }
                }
            }
        }


        if (!stack.isEmpty()){
            while(!stack.isEmpty()){
                postfix.add(Character.toString(stack.remove(stack.size()-1)));
            }
        }

        for (String string:postfix) {
            System.out.print(string+" ");
        }

        return postfix;
    }

    private boolean isNumberNext(String string){
        if (Character.isDigit(string.charAt(0))) return true;
        else return false;
    }

    private int getFirstNumber(String string){

        int i=0;
        while (i<string.length() && Character.isDigit(string.charAt(i))){
            i++;
        }

        String numberString = string.substring(0, i);
        return Integer.parseInt(numberString);
    }

    private String trimFirstNumber(String string){

        int i=0;
        while (i<string.length() && Character.isDigit(string.charAt(i))){
            i++;
        }

        return string.substring(i);
    }


    public static void main(String[] args){
        InfixHandler ih=new InfixHandler("25-(4+2*3)/2");
        ih.getPostfix();
    }

}
