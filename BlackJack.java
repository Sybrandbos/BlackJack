/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.blackjack;

import java.util.Scanner;

/**
 *
 * @author sybra
 */
public class BlackJack {

    public static void main(String[] args) {
        
        //Declareren van variablen
        Scanner scanner = new Scanner(System.in);

        int firstPlayerCard = randomCard();
        int secondPlayerCard = randomCard();
        int sumPlayerCards = firstPlayerCard + secondPlayerCard;
        
        int firstDealerCard = randomCard();
        int secondDealerCard = randomCard();
        int sumDealerCards = firstDealerCard + secondDealerCard;
        
        boolean morePlayerCards = true;
        boolean moreDealerCards = true;
        
        boolean playerLost = false;
        boolean dealerLost = false;
        
        //Intro tekst met speelkaarten
        System.out.println("Welkom bij uw BlackJack game");
        System.out.println("Uw eerste kaart is " + firstPlayerCard + " en uw tweede kaart is " + secondPlayerCard + " samen " + sumPlayerCards  );
        System.out.println("Dealer zijn eerste kaart is " + firstDealerCard );

        //Geven van speler kaarten
        while(morePlayerCards){
            System.out.println("Wilt u nog een kaart? Ja/Nee");
            String playerInput = scanner.nextLine().toLowerCase();
            
            if(playerInput.equals("ja")){
                int nextPlayerCard = randomCard();
                sumPlayerCards += nextPlayerCard;
                System.out.println(nextPlayerCard + ", u heeft nu in totaal " + sumPlayerCards + " kaarten");
            } else{
                morePlayerCards = false;
            }
         
            if(sumPlayerCards > 21){
                morePlayerCards = false;
                playerLost = true;
            }
        }
        
        //Aangeven wat de tweede kaart is van dealer
        System.out.println("Dealer zijn tweede kaart is " + secondDealerCard + " samen " + sumDealerCards);
        
        //Geven van dealer kaarten
        while(moreDealerCards){
            if(sumDealerCards < 17 && playerLost == false){
                int nextDealerCard = randomCard();
                sumDealerCards += nextDealerCard;
                System.out.println(nextDealerCard + ", dealer heeft nu in totaal " + sumDealerCards + " kaarten");

            } else{
                if(sumDealerCards > 21){
                    dealerLost = true;
                }
                moreDealerCards = false;
            }
        }
        
        //Kijken wie de winaar is
        if(playerLost == false && dealerLost == false){
            if(sumPlayerCards == sumDealerCards){
                System.out.println("Quitte gespeeld!");
            } else if(sumPlayerCards > sumDealerCards){
                System.out.println("Speler heeft gewonnen! Goed gedaan!");
            } else{
                System.out.println("Dealer heeft gewonnen, helaas!");
            }
        } else if(playerLost == false && dealerLost == true){
            System.out.println("Speler heeft gewonnen! Goed gedaan!");
        } else{
            System.out.println("Dealer heeft gewonnen, helaas!");
        }
    }
    
    //Methode om willekeurige nummers terug te geven
    public static int randomCard() {
        int card = (int) (Math.random() * 11) + 1;
        return card;
    }
}
