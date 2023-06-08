package schoolmanagement.commonlib.model.enums;


/**
 * Enumeration of language proficiency levels.
 *
 * <p>
 * This enumeration represents the different language proficiency levels according to the Common European Framework of
 * Reference for Languages (CEFR).
 * </p>
 *
 * <p>
 * The available levels are:
 * </p>
 * <ul>
 * <li>{@link #A1} - Beginner (Breakthrough or Beginner)</li>
 * <li>{@link #A2} - Elementary (Waystage or Elementary)</li>
 * <li>{@link #B1} - Intermediate (Threshold or Pre-Intermediate)</li>
 * <li>{@link #B2} - Upper Intermediate (Vantage or Intermediate)</li>
 * <li>{@link #C1} - Advanced (Effective Operational Proficiency or Upper-Intermediate)</li>
 * <li>{@link #C2} - Proficient (Mastery or Advanced)</li>
 * </ul>
 *
 * @see <a href="https://www.coe.int/en/web/common-european-framework-reference-languages">Common European Framework of Reference for Languages (CEFR)</a>
 * @since (version number or date)
 * @author Djordje Ivanovic
 */
public enum Level {
    /**
     * Beginner level (Breakthrough or Beginner).
     */
    A1,

    /**
     * Elementary level (Waystage or Elementary).
     */
    A2,

    /**
     * Intermediate level (Threshold or Pre-Intermediate).
     */
    B1,

    /**
     * Upper Intermediate level (Vantage or Intermediate).
     */
    B2,

    /**
     * Advanced level (Effective Operational Proficiency or Upper-Intermediate).
     */
    C1,

    /**
     * Proficient level (Mastery or Advanced).
     */
    C2
}
