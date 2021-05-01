package me.wassif.accessmodifiers.cat;

public class BigCat {
    public String name = "cat";
    protected boolean hasFur = true;
    boolean hasPaws = true;
    private int id;

    public static void main(String[] args) {
        BigCat cat = new BigCat();
        /*
         * we can access all variables.
         */
        System.out.printf("name = %s, hasFur = %b, hasPaws = %b, id = %d",
                cat.name, cat.hasFur, cat.hasPaws, cat.id);
    }
}
