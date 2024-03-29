package api.longpoll.bots.methods.messages;

import api.longpoll.bots.methods.VkApiGetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.IntegerResult;
import org.jsoup.Connection;

import java.util.stream.Stream;

/**
 * Implements <b>messages.markAsRead</b> method.
 *
 * Marks messages as read.
 *
 * @see <a href="https://vk.com/dev/messages.markAsRead">https://vk.com/dev/messages.markAsRead</a>
 */
public class MessagesMarkAsRead extends VkApiGetMethod<IntegerResult> {
    /**
     * Destination ID.
     */
    private Integer peerId;

    /**
     * Message ID to start from.
     */
    private Integer startMessageId;

    /**
     * Group ID.
     */
    private Integer groupId;

    /**
     * <b>true</b> to mark as read.
     */
    private Boolean markConversationAsRead;

    public MessagesMarkAsRead(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().messagesMarkAsRead();
    }

    @Override
    protected Stream<Connection.KeyVal> getParamsStream() {
        return Stream.of(
                keyVal("peer_id", peerId),
                keyVal("start_message_id", startMessageId),
                keyVal("group_id", groupId),
                keyVal("mark_conversation_as_read", markConversationAsRead, true)
        );
    }

    @Override
    protected Class<? extends IntegerResult> getResultType() {
        return IntegerResult.class;
    }

    public MessagesMarkAsRead setPeerId(Integer peerId) {
        this.peerId = peerId;
        return this;
    }

    public MessagesMarkAsRead setStartMessageId(Integer startMessageId) {
        this.startMessageId = startMessageId;
        return this;
    }

    public MessagesMarkAsRead setGroupId(Integer groupId) {
        this.groupId = groupId;
        return this;
    }

    public MessagesMarkAsRead setMarkConversationAsRead(Boolean markConversationAsRead) {
        this.markConversationAsRead = markConversationAsRead;
        return this;
    }
}
