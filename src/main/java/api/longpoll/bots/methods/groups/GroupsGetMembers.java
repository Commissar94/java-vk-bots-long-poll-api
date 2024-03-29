package api.longpoll.bots.methods.groups;

import api.longpoll.bots.methods.VkApiGetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.groups.GroupsGetMembersResult;
import org.jsoup.Connection;

import java.util.List;
import java.util.stream.Stream;

/**
 * Implements <b>groups.getMembers</b> method.
 *
 * Returns a list of community members.
 *
 * @see <a href="https://vk.com/dev/groups.getMembers">https://vk.com/dev/groups.getMembers</a>
 */
public class GroupsGetMembers extends VkApiGetMethod<GroupsGetMembersResult> {
    /**
     * ID or screen name of the community.
     */
    private String groupId;

    /**
     * Sort order. Available values: id_asc, id_desc, time_asc, time_desc.
     */
    private String sort;

    /**
     * Offset needed to return a specific subset of community members.
     */
    private Integer offset;

    /**
     * Number of community members to return.
     */
    private Integer count;

    /**
     * List of additional fields to be returned.
     */
    private List<String> fields;

    /**
     * User filter.
     */
    private String filter;

    public GroupsGetMembers(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().groupsGetMembers();
    }

    @Override
    protected Stream<Connection.KeyVal> getParamsStream() {
        return Stream.of(
                keyVal("group_id", groupId),
                keyVal("sort", sort),
                keyVal("offset", offset),
                keyVal("count", count),
                keyVal("fields", fields),
                keyVal("filter", filter)
        );
    }

    @Override
    protected Class<? extends GroupsGetMembersResult> getResultType() {
        return GroupsGetMembersResult.class;
    }

    public GroupsGetMembers setGroupId(String groupId) {
        this.groupId = groupId;
        return this;
    }

    public GroupsGetMembers setSort(String sort) {
        this.sort = sort;
        return this;
    }

    public GroupsGetMembers setOffset(Integer offset) {
        this.offset = offset;
        return this;
    }

    public GroupsGetMembers setCount(Integer count) {
        this.count = count;
        return this;
    }

    public GroupsGetMembers setFields(List<String> fields) {
        this.fields = fields;
        return this;
    }

    public GroupsGetMembers setFilter(String filter) {
        this.filter = filter;
        return this;
    }
}
