package th.co.ais.cauldron.genesis.testsomting;

import android.os.AsyncTask;
import java.net.InetAddress;

public class CheckInternet extends AsyncTask<String, Long, Object> {
    @Override
    protected Object doInBackground(String... strings) {
        if ( "check_net".equals(strings[0]) ){
            return isSuccess();
        }
        return null;
    }

    private boolean isSuccess(){
        try {
            InetAddress ipAddr = InetAddress.getByName("google.com");
            return !ipAddr.equals("");

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
