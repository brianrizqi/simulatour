package id.ac.unej.ilkom.simulatour.Networks;

/**
 * Created by eldi on 13/06/2018.
 */

public class BaseApi {
    /**
     *
     * http://192.168.43.241 wifi
     *
     * http://192.168.137.1 LAN
     *
     * http://209.97.170.199:8000/api/sinergiin/ => sofyan
     */



    public static final String BaseURL = "http://192.168.43.241/simulatour/";


    public static final String getAllWisata=BaseURL+"paket.php?fun=get_all_wisata";



    public static final String imageURL=BaseURL+"img/";


}
