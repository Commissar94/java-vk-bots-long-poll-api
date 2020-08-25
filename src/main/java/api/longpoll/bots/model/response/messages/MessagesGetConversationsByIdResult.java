package api.longpoll.bots.model.response.messages;

import api.longpoll.bots.model.objects.additional.VkList;
import api.longpoll.bots.model.objects.basic.Conversation;
import api.longpoll.bots.model.objects.basic.User;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MessagesGetConversationsByIdResult {
    @SerializedName("response")
    private VkList<Item> response;

    public static class Item extends Conversation {
        @SerializedName("profiles")
        private List<User> profiles;

        public List<User> getProfiles() {
            return profiles;
        }

        public void setProfiles(List<User> profiles) {
            this.profiles = profiles;
        }
    }

    public VkList<Item> getResponse() {
        return response;
    }

    public void setResponse(VkList<Item> response) {
        this.response = response;
    }
}
