package parse.response.messages.send;

import api.longpoll.bots.converters.messages.MessagesSendResponseConverterImpl;
import api.longpoll.bots.model.messages.MessagesSendResponse;
import com.google.gson.JsonObject;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import parse.response.AbstractParseTest;

import java.io.IOException;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MessagesSendParseTest extends AbstractParseTest {
	@Test
	public void test1_responses() throws IOException {
		JsonObject jsonObject = readJson("json/response/messages_send/message_send_responses_sample_5_110.json");
		MessagesSendResponse response = new MessagesSendResponseConverterImpl().convert(jsonObject);
		Assert.assertNotNull(response);
	}
}