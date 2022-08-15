package code;

public interface Viral {

    /* Coronavirus mutates when one of its amino-acids change.
    The basic mutation picks a random amino-acid in the
    virus, and changes its letter to another amino-acid letter
    */
    public void mutate();
    /*
    @expects Coronavirus c is not null, and it contains the
    initialized genomic sequence@param Coronavirus c
    @return true if two viruses have the identical genomic
    sequence,
    and otherwise returns false
    * */
    public boolean same(Coronavirus c);
    /*
    @expects Coronavirus c is not null, and it contains the
    initialized genomic sequence
    @param Coronavirus c
    @return true if two viruses have the identical number of
    each amino-acids,
    but not necessarily in the same order, and otherwise false
    * */
    public boolean functionallySimilar(Coronavirus c);
    /*
    @expects Coronavirus c is not null, and it contains the
    initialized genomic sequence
    @param Coronavirus c
    @return the minimum number of single-character
    inserts/deletes/substitutions
    required to transform this genome into Coronavirus c genome
    for instance: actg ->atg is 1 away, cgt ->tgt is 1 away, agt
    ->actg is 1 away
    consult edit distance algorithms to develop this method
    * */
    public int editDistance(Coronavirus c);

}
