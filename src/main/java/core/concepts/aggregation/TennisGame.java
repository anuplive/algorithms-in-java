/**
 * Association has two levels
 * Simple Association: Bi-Directional , Objects can exist without each other eg Person and Address
 *  Aggregation -> Uni-directional Two Objects can have their own lifecycle.
 *  Composition -> Uni-directional and the composed object cannot exist in its own.
 */


package main.java.core.concepts.aggregation;

public class TennisGame {

    public static void main(String[] args){
        TennisPlayer playerOne = new TennisPlayer("Roger", new Racket("COSCO"));
        TennisPlayer playerTwo = new TennisPlayer("Nadal", new Racket("PUMA"));

        System.out.println("Match Summary");
        System.out.println(playerOne.name + " will use "+ playerOne.racket.brand );
        System.out.println(playerTwo.name + " will use " + playerTwo.racket.brand);

    }
}
