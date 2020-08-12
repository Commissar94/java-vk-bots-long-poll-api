package parse.response.photo;

import api.longpoll.bots.converters.updates.UpdateResponseConverterImpl;
import api.longpoll.bots.model.events.Event;
import api.longpoll.bots.model.wall.reply.Thread;
import api.longpoll.bots.model.photos.PhotoCommentEvent;
import api.longpoll.bots.model.events.EventObject;
import api.longpoll.bots.model.response.events.GetEventsResult;
import com.google.gson.JsonObject;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import parse.response.AbstractParseTest;

import java.io.IOException;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PhotoCommentNewParseTest extends AbstractParseTest {
	@Test
	public void test1_messageEdit() throws IOException {
		JsonObject jsonObject = readJson("json/response/photo_comment_new/photo_comment_new_sample_5_110.json");
		GetEventsResult getEventsResult = new UpdateResponseConverterImpl().convert(jsonObject);
		Assert.assertNotNull(getEventsResult);
		Assert.assertEquals(Integer.valueOf(2613), getEventsResult.getTs());

		List<Event> events = getEventsResult.getEvents();
		Assert.assertNotNull(events);
		Assert.assertEquals(1, events.size());

		Event event = events.get(0);
		Assert.assertNotNull(event);
		Assert.assertEquals("photo_comment_new", event.getType());
		Assert.assertEquals(Integer.valueOf(168975658), event.getGroupId());
		Assert.assertEquals("ca8ad9aa67d5e898a512df3952e653c4e2ad8e3d", event.getEventId());

		EventObject eventObject = event.getObject();
		Assert.assertNotNull(eventObject);

		Assert.assertTrue(eventObject instanceof PhotoCommentEvent);
		PhotoCommentEvent photoCommentUpdate = (PhotoCommentEvent) eventObject;
		Assert.assertNotNull(photoCommentUpdate);
		Assert.assertEquals(Integer.valueOf(3), photoCommentUpdate.getId());
		Assert.assertEquals(Integer.valueOf(381980625), photoCommentUpdate.getFromId());
		Assert.assertEquals(Integer.valueOf(1594285508), photoCommentUpdate.getDate());
		Assert.assertEquals("t", photoCommentUpdate.getText());
		Assert.assertEquals(Integer.valueOf(-168975658), photoCommentUpdate.getPhotoOwnerId());
		Assert.assertEquals(Integer.valueOf(457239017), photoCommentUpdate.getPhotoId());

		Thread thread = photoCommentUpdate.getThread();
		Assert.assertNotNull(thread);
		Assert.assertEquals(Integer.valueOf(0), thread.getCount());
	}
}