package th.co.ais.cauldron.genesis.testsomting;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.net.InetAddress;
import java.util.concurrent.ExecutionException;

import th.co.ais.cauldron.genesis.ais_abc.ProxyViewModel;
import th.co.ais.cauldron.genesis.ais_abc.commons.MyApplication;
import th.co.ais.cauldron.genesis.ais_abc.model.ProxyModel;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        if(MyApplication.getInstance().isNetworkAvailable()) {
            ProxyViewModel proxyViewModel = new ProxyViewModel();
            proxyViewModel.getProxy().observe(this, new Observer<ProxyModel>() {
                @Override
                public void onChanged(ProxyModel currencyPojos) {
                    if (currencyPojos != null) {
                        Log.e(TAG, "observe onChanged()=" + currencyPojos.getDeveloperMessage());
                    }
                }
            });
//        } else {
//            Toast.makeText(this, "No Network Available", Toast.LENGTH_LONG).show();
//        }

    }

    public boolean isInternetAvailable() {
        try {
            return (boolean) new CheckInternet().execute("check_net").get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }
}