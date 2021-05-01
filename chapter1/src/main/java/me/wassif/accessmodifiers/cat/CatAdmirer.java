package me.wassif.accessmodifiers.cat;

public class CatAdmirer {
    public static void main(String[] args) {
        BigCat cat = new BigCat();
        /*
         * we cannot access private variable, only protected and defalut can be
         * accessed.
         */
        System.out.printf("name = %s, hasFur = %b, hasPaws = %b, id = %d",
                cat.name, cat.hasFur, cat.hasPaws);
    }
}
