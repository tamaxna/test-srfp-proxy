package th.co.ais.cauldron.genesis.ais_abc.commons;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import th.co.ais.cauldron.genesis.ais_abc.model.InputWebModel;
import th.co.ais.cauldron.genesis.ais_abc.model.ProxyModel;

/**
 * Created by Kashif on 9/27/2019.
 */
public interface ApiInterface {

    String API_ROUTE = "/srfp/v2/proxy/{command}/{robotId}";

    @POST(API_ROUTE)
    @Headers({
            "Content-type: application/json"
    })
    Call<ProxyModel> sendPosts(@Body InputWebModel inputWebModel,
                               @Path(value = "command") String command,
                               @Path(value = "robotId") String robotId);

}
