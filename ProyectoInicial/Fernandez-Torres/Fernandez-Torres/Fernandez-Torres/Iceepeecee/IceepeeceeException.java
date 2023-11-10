/**
 * Write a description of class IceepeeceeException here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class IceepeeceeException extends Exception{
    public static final String ISLANDS_OUT_OF_RANGE = "La isla que ingresaste esta fuera de los limites";
    public static final String FLIGTHS_OUT_OF_RANGE = "El vuelo que ingresaste esta fuera de los limites";
    public static final String ISLAND_VALUES_INVALID = "Los valores de isla que ingresaste no fueron validos";
    public static final String FLIGTH_VALUES_INVALID = "Los valores de vuelo que ingresaste no fueron validos";
    public static final String NO_ISLAND_TYPE_FOUND = "No se encontro el tipo de isla que desea crear";
    public static final String NO_FLIGTH_TYPE_FOUND = "No se encontro el tipo de vuelo que desea crear";
    public static final String ISLANDS_INCOMPLETE = "La isla no tiene suficientes vertices";
    /**
     * Constructor for objects of class IceepeeceeException
     */
    public IceepeeceeException(String message)
    {
        super(message);
    }
}