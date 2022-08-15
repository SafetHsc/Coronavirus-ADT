package code;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Coronavirus implements Viral{

    private char[] genome;
    private static final char[] AMINO_ACIDS = {'A', 'C', 'T', 'G'};

    public Coronavirus(){
        int numOfAminoAcids = ThreadLocalRandom.current().nextInt(25000, 30001);
        this.genome = new char[numOfAminoAcids];

        for(int i = 0; i < numOfAminoAcids; i++){
            this.genome[i] = AMINO_ACIDS[(int)(Math.random() * 3)];
        }
    }

    public Coronavirus(Coronavirus c){
        this.genome = c.genome.clone();
    }

    public void shuffle(){
        Random rnd = ThreadLocalRandom.current();

        for (int i = this.genome.length - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            char chr = this.genome[i];
            this.genome[i] = this.genome[index];
            this.genome[index] =  chr;
        }
    }

    @Override
    public void mutate() {
        int mutationIntex = (int)(Math.random() * this.genome.length + 1);
        int mutationAminoAcid;

        do {
            mutationAminoAcid = (int)(Math.random() * 4);
        }while (this.genome[mutationIntex] == AMINO_ACIDS[mutationAminoAcid]);


        this.genome[mutationIntex] = AMINO_ACIDS[mutationAminoAcid];
    }

    @Override
    public boolean same(Coronavirus c) {
        for(int i = 0; i < this.genome.length && i < c.genome.length; i++){
            if(this.genome[i] != c.genome[i]){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean functionallySimilar(Coronavirus c) {
        for(int i = 0; i < 4; i++) {
            if (aminoAcidConcentration(this.genome, AMINO_ACIDS[i]) != aminoAcidConcentration(c.genome, AMINO_ACIDS[i]))
                return false;
        }

        return true;
    }

    /**
     * @param genome
     * @param aminoAcid
     * @return int, number of specified amino acid within given genome.
     */
    private static int aminoAcidConcentration(char genome[], char aminoAcid){
        int counter = 0;

        for (char c : genome) {
            if (c == aminoAcid) {
                counter++;
            }
        }
        return counter;
    }

    @Override
    public int editDistance(Coronavirus c) {
        int distance = 0;

        for(int i = 0; i < this.genome.length && i < c.genome.length; i++){
            if (this.genome[i] != c.genome[i]){
                distance++;
            }
        }

        if (this.genome.length > c.genome.length)
            distance -= (this.genome.length - c.genome.length);
        else if(this.genome.length < c.genome.length)
            distance += (c.genome.length - this.genome.length);
        return distance;
    }
}
