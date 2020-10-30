package th.co.ais.cauldron.genesis.ais_abc;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import th.co.ais.cauldron.genesis.ais_abc.commons.ApiInterface;
import th.co.ais.cauldron.genesis.ais_abc.commons.Constants;
import th.co.ais.cauldron.genesis.ais_abc.commons.MyApplication;
import th.co.ais.cauldron.genesis.ais_abc.model.InputWebModel;
import th.co.ais.cauldron.genesis.ais_abc.model.ProxyModel;


public class SRFPRepo {
    private final String TAG = getClass().getSimpleName();

    public MutableLiveData<ProxyModel> requestProxy() {
        final MutableLiveData<ProxyModel> mutableLiveData = new MutableLiveData<>();

        ApiInterface apiService =
                MyApplication.getRetrofitClient().create(ApiInterface.class);

        InputWebModel inputWebModel = new InputWebModel("battery", "get");

        apiService.sendPosts(inputWebModel, Constants.CMD_INPUT_WEB, Constants.ROBOT_ID).enqueue(new Callback<ProxyModel>() {
            @Override
            public void onResponse(Call<ProxyModel> call, Response<ProxyModel> response) {
                Log.e(TAG, "getCurrencyList response="+response );
                if (response.isSuccessful() && response.body()!=null ) {
                    mutableLiveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<ProxyModel> call, Throwable t) {
                Log.e(TAG, "getProdList onFailure" + call.toString());
            }
        });

//        apiService.getHolidays().enqueue(new Callback<List<HolidayModel>>() {
//            @Override
//            public void onResponse(Call<List<HolidayModel>> call, Response<List<HolidayModel>> response) {
//                Log.e(TAG, "getCurrencyList response="+response );
//
//                if (response.isSuccessful() && response.body()!=null ) {
//                    Log.e(TAG, "requestHolidays response.size="+response.body().size() );
//                    mutableLiveData.setValue(response.body());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<HolidayModel>> call, Throwable t) {
//                Log.e(TAG, "getProdList onFailure" + call.toString());
//            }
//        });


        return mutableLiveData;
    }
}
