package api.longpoll.bots.methods.market;

import api.longpoll.bots.methods.VkApiGetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.market.MarketGetGroupOrdersResult;
import org.jsoup.Connection;

import java.util.stream.Stream;

/**
 * Implements <b>market.getGroupOrders</b> method.
 *
 * Returns community's orders.
 *
 * @see <a href="https://vk.com/dev/market.getGroupOrders">https://vk.com/dev/market.getGroupOrders</a>
 */
public class MarketGetGroupOrders extends VkApiGetMethod<MarketGetGroupOrdersResult> {
    /**
     * ID of the community that owns the items market.
     */
    private Integer groupId;

    /**
     * Offset needed to return a specific subset of orders.
     */
    private Integer offset;

    /**
     * Number of orders to return.
     */
    private Integer count;

    public MarketGetGroupOrders(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().marketGetGroupOrders();
    }

    @Override
    protected Stream<Connection.KeyVal> getParamsStream() {
        return Stream.of(
                keyVal("group_id", groupId),
                keyVal("offset", offset),
                keyVal("count", count)
        );
    }

    @Override
    protected Class<? extends MarketGetGroupOrdersResult> getResultType() {
        return MarketGetGroupOrdersResult.class;
    }

    public MarketGetGroupOrders setGroupId(Integer groupId) {
        this.groupId = groupId;
        return this;
    }

    public MarketGetGroupOrders setOffset(Integer offset) {
        this.offset = offset;
        return this;
    }

    public MarketGetGroupOrders setCount(Integer count) {
        this.count = count;
        return this;
    }
}
