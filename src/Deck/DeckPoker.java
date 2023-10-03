package Deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeckPoker {
	
	 // Clase que contiene las Cartas
    static class Card {
        private String palo;
        private String color;
        private String valor;

        public Card(String palo, String color, String valor) {
            this.palo = palo;
            this.color = color;
            this.valor = valor;
        }

        public String getPalo() {
            return palo;
        }

        public String getColor() {
            return color;
        }

        public String getValor() {
            return valor;
        }

        
        public String toString() {
            return palo + "," + color + "," + valor;
        }
    }

    // Clase que contiene el Deck
    static class Deck {
        private List<Card> cartas;

        public Deck() {
            cartas = new ArrayList<>();

            String[] palos = {"tréboles", "corazones", "picas", "diamantes"};
            String[] colores = {"rojo", "negro"};
            String[] valores = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "A", "J", "Q", "K"};

            for (String palo : palos) {
                for (String color : colores) {
                    for (String valor : valores) {
                        cartas.add(new Card(palo, color, valor));
                    }
                }
            }
        }

        public void shuffle() {
        	//En esta parte se barajea el deck
            Collections.shuffle(cartas);
            System.out.println("Se mezcló el Deck.");
        }

        public void head() {
            if (!cartas.isEmpty()) {
                Card primeraCarta = cartas.remove(0);
                System.out.println(primeraCarta);
                System.out.println("Quedan " + cartas.size() + " cartas en deck.");
            } else {
                System.out.println("El deck está vacío.");
            }
        }

        public void pick() {
            if (!cartas.isEmpty()) {
                int indiceAleatorio = (int) (Math.random() * cartas.size());
                Card cartaSeleccionada = cartas.remove(indiceAleatorio);
                System.out.println(cartaSeleccionada);
                System.out.println("Quedan " + cartas.size() + " cartas en deck.");
            } else {
                System.out.println("El deck está vacío.");
            }
        }

        public List<Card> hand() {
            List<Card> mano = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                if (!cartas.isEmpty()) {
                    Card carta = cartas.remove(0);
                    mano.add(carta);
                }
            }

            if (!mano.isEmpty()) {
                for (Card carta : mano) {
                    System.out.println(carta);
                }
                System.out.println("Quedan " + cartas.size() + " cartas en deck.");
            } else {
                System.out.println("No hay suficientes cartas para formar una mano.");
            }

            return mano;
        }
    }
	
	public static void main (String[]args ) {
	
		Deck deck = new Deck();

        deck.shuffle();

        deck.head();
        deck.pick();

        List<Card> mano = deck.hand();
    }
}

