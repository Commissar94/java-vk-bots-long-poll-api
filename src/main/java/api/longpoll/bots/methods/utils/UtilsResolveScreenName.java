package api.longpoll.bots.methods.utils;

import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.converters.JsonToPojoConverterFactory;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.GenericResult;
import api.longpoll.bots.model.response.utils.UtilsResolveScreenNameResponse;
import com.google.gson.reflect.TypeToken;
import org.jsoup.Connection;

import java.util.stream.Stream;

/**
 * Implements <b>utils.resolveScreenName</b> method.
 *
 * @see <a href="https://vk.com/dev/utils.resolveScreenName">https://vk.com/dev/utils.resolveScreenName</a>
 */
public class UtilsResolveScreenName extends GetMethod<GenericResult<UtilsResolveScreenNameResponse>> {
    /**
     * Screen name of the user, community (e.g., apiclub, andrew, or rules_of_war), or application.
     */
    private String screenName;

    public UtilsResolveScreenName(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().utilsResolveScreenName();
    }

    @Override
    protected JsonToPojoConverter<GenericResult<UtilsResolveScreenNameResponse>> getConverter() {
        return JsonToPojoConverterFactory.get(new TypeToken<GenericResult<UtilsResolveScreenNameResponse>>(){}.getType());
    }

    @Override
    protected Stream<Connection.KeyVal> getKeyValStream() {
        return Stream.of(keyVal("screen_name", screenName));
    }

    public String getScreenName() {
        return screenName;
    }

    public UtilsResolveScreenName setScreenName(String screenName) {
        this.screenName = screenName;
        return this;
    }
}
