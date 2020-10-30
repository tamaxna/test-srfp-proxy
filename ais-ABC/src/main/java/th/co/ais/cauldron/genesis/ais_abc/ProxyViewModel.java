package th.co.ais.cauldron.genesis.ais_abc;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import th.co.ais.cauldron.genesis.ais_abc.model.ProxyModel;

public class ProxyViewModel extends ViewModel {

    private SRFPRepo srfpRepo;
    private MutableLiveData<ProxyModel> mutableLiveData;

    public ProxyViewModel(){
        srfpRepo = new SRFPRepo();
    }

    public LiveData<ProxyModel> getProxy() {
        if(mutableLiveData==null){
            mutableLiveData = srfpRepo.requestProxy();
        }
        return mutableLiveData;
    }

}
