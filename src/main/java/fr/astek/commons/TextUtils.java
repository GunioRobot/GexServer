package fr.astek.commons;

import org.apache.commons.lang.StringUtils;

/**
 * @author sdaclin
 */
public class TextUtils {

    private static final String CARACTERE_ACCENTUES = "ÀÁÂÃÄÅÇÈÉÊËÌÍÎÏÒÓÔÕÖÙÚÛÜÝàáâãäåçèéêëìíîïðòóôõöùúûüýÿ";
    private static final String CARACTERE_NORMAUX   = "AAAAAACEEEEIIIIOOOOOUUUUYaaaaaaceeeeiiiioooooouuuuyy";

    /**
     * Génère une chaine de caractère en ne conservant que des caractères
     * non accentués, des chiffres et des tirets.
     * @param libelle
     * @return
     */
    public static String asUrl(String libelle) {
        if (libelle == null) {
            return "";
        }
        // échappement des caractères spéciaux
        String nouveauLibelle = StringUtils.replaceChars(libelle.trim(),
                CARACTERE_ACCENTUES,
                CARACTERE_NORMAUX).toLowerCase();
        // échappement des blancs
        return nouveauLibelle.replaceAll("\\W+", "-");
    }

    /**
     * Retourne une chaine de caractère en minuscule sans espace superflu
     * @param libelle
     * @return
     */
    public static String minimise(String libelle) {
        if (libelle == null) {
            return null;
        }
        return libelle.trim().replaceAll(" +", " ").toLowerCase();
    }

    public static boolean isNullOrEmpty(String s) {
        return s == null || s.trim().length() == 0;
    }
}
