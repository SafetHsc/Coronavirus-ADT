package code;

public class CoronavirusTest {

    public static void main(String[] args) {

        Coronavirus covid = new Coronavirus();
        Coronavirus covid19 = new Coronavirus();
        Coronavirus SARS_CoV_2 = new Coronavirus(covid19);

        System.out.println(covid.same(covid19));
        System.out.println(covid.functionallySimilar(covid19));
        System.out.println(covid.editDistance(covid19));
        covid.mutate();
        System.out.println(covid.editDistance(covid19));
        System.out.println(covid.functionallySimilar(covid19));
        System.out.println();

        System.out.println(covid19.same(SARS_CoV_2));
        System.out.println(covid19.editDistance(SARS_CoV_2));
        covid19.shuffle();
        System.out.println(covid19.same(SARS_CoV_2));
        System.out.println(covid19.functionallySimilar(SARS_CoV_2));
        covid19.mutate();
        System.out.println(covid19.functionallySimilar(SARS_CoV_2));
    }
}
