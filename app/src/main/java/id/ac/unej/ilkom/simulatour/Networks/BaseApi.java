package id.ac.unej.ilkom.simulatour.Networks;

/**
 * Created by eldi on 13/06/2018.
 */

public class BaseApi {
    /**
     *
     * http://192.168.43.241 wifi
     *
     * http://192.168.101.18 wifi hares
     *
     * http://10.132.0.159 hotspot unej
     *
     * http://192.168.137.1 LAN
     *
     * http://209.97.170.199:8000/api/sinergiin/ => sofyan
     */



    public static final String BaseURL = "http://helloworlds.me/simulatour/";


    public static final String getAllWisata=BaseURL+"paket.php?fun=get_all_wisata";
    public static final String getAllPenginapan=BaseURL+"paket.php?fun=get_all_penginapan";
    public static final String getAllMakanan=BaseURL+"paket.php?fun=get_all_makanan";
    public static final String getAllSewa=BaseURL+"paket.php?fun=get_all_sewa";
    public static final String getAllTransportasi=BaseURL+"paket.php?fun=get_all_transportasi";
    public static final String getSimulasi=BaseURL+"paket.php?fun=get_simulation";

    public static final String getPaket=BaseURL+"paket.php?fun=get_paket";




    public static final String imageURL=BaseURL+"img/";


}
