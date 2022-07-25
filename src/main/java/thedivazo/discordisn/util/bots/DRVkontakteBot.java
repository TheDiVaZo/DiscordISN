package thedivazo.discordisn.util.bots;

import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.httpclient.HttpTransportClient;

import javax.security.auth.login.LoginException;
import java.util.Objects;

public class DRVkontakteBot extends DRBot{
    private GroupActor groupActor;
    private static TransportClient transportClient = new HttpTransportClient();
    private static VkApiClient vk = new VkApiClient(transportClient);

    public DRVkontakteBot(String groupToken, String groupId) throws LoginException {
        super(Objects.requireNonNull(groupToken));
        groupActor = new GroupActor(Integer.parseInt(groupId), groupToken);
        try {
            vk.groups().getMembers(groupActor).count(1).groupId(groupId).execute();
        } catch (ApiException | ClientException e) {
            throw new LoginException("Failed to connect to vk api. Please check the validity of the token and group id. Integration with VK api is disabled");
        }
    }

    public void sendMessage(String chatId,String text) {
        try {
            vk.messages().send(groupActor).chatId(Integer.parseInt(chatId)).message(text).randomId(0).execute();
        } catch (ApiException | ClientException e) {
            e.printStackTrace();
        }
    }
}
