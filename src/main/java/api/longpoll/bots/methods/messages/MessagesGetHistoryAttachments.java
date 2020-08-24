package api.longpoll.bots.methods.messages;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.converters.events.messages.MessagesGetHistoryAttachmentsResultConverterImpl;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.messages.MessagesGetHistoryAttachmentsResult;
import org.jsoup.Connection;

import java.util.List;
import java.util.stream.Stream;

public class MessagesGetHistoryAttachments extends GetMethod<MessagesGetHistoryAttachmentsResult> {
    private Integer peerId;
    private String mediaType;
    private String startFrom;
    private Integer count;
    private Boolean photoSizes;
    private List<String> fields;
    private Integer groupId;
    private Boolean preserveOrder;
    private Integer maxForwardsLevel;

    public MessagesGetHistoryAttachments(LongPollBot bot) {
        super(bot);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().messagesGetHistoryAttachments();
    }

    @Override
    protected JsonToPojoConverter<MessagesGetHistoryAttachmentsResult> getConverter() {
        return new MessagesGetHistoryAttachmentsResultConverterImpl();
    }

    @Override
    protected Stream<Connection.KeyVal> getKeyValStream() {
        return Stream.of(
                keyVal("peer_id", peerId),
                keyVal("media_type", mediaType),
                keyVal("start_from", startFrom),
                keyVal("count", count),
                keyVal("photo_sizes", photoSizes, true),
                keyVal("fields", fields),
                keyVal("group_id", groupId),
                keyVal("preserve_order", preserveOrder, true),
                keyVal("max_forwards_level", maxForwardsLevel)
        );
    }

    public Integer getPeerId() {
        return peerId;
    }

    public MessagesGetHistoryAttachments setPeerId(Integer peerId) {
        this.peerId = peerId;
        return this;
    }

    public String getMediaType() {
        return mediaType;
    }

    public MessagesGetHistoryAttachments setMediaType(String mediaType) {
        this.mediaType = mediaType;
        return this;
    }

    public String getStartFrom() {
        return startFrom;
    }

    public MessagesGetHistoryAttachments setStartFrom(String startFrom) {
        this.startFrom = startFrom;
        return this;
    }

    public Integer getCount() {
        return count;
    }

    public MessagesGetHistoryAttachments setCount(Integer count) {
        this.count = count;
        return this;
    }

    public Boolean getPhotoSizes() {
        return photoSizes;
    }

    public MessagesGetHistoryAttachments setPhotoSizes(Boolean photoSizes) {
        this.photoSizes = photoSizes;
        return this;
    }

    public List<String> getFields() {
        return fields;
    }

    public MessagesGetHistoryAttachments setFields(List<String> fields) {
        this.fields = fields;
        return this;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public MessagesGetHistoryAttachments setGroupId(Integer groupId) {
        this.groupId = groupId;
        return this;
    }

    public Boolean getPreserveOrder() {
        return preserveOrder;
    }

    public MessagesGetHistoryAttachments setPreserveOrder(Boolean preserveOrder) {
        this.preserveOrder = preserveOrder;
        return this;
    }

    public Integer getMaxForwardsLevel() {
        return maxForwardsLevel;
    }

    public MessagesGetHistoryAttachments setMaxForwardsLevel(Integer maxForwardsLevel) {
        this.maxForwardsLevel = maxForwardsLevel;
        return this;
    }
}
