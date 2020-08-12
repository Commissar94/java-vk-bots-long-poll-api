package parse.response.video;

import api.longpoll.bots.converters.updates.UpdateResponseConverterImpl;
import api.longpoll.bots.model.events.Event;
import api.longpoll.bots.model.events.EventObject;
import api.longpoll.bots.model.response.events.GetEventsResult;
import api.longpoll.bots.model.video.Video;
import com.google.gson.JsonObject;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import parse.response.AbstractParseTest;

import java.io.IOException;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class VideoNewParseTest extends AbstractParseTest {
	@Test
	public void test1_videoNew() throws IOException {
		JsonObject jsonObject = readJson("json/response/video_new/video_new_sample_5_110.json");
		GetEventsResult getEventsResult = new UpdateResponseConverterImpl().convert(jsonObject);
		Assert.assertNotNull(getEventsResult);
		Assert.assertEquals(Integer.valueOf(2617), getEventsResult.getTs());

		List<Event> events = getEventsResult.getEvents();
		Assert.assertNotNull(events);
		Assert.assertEquals(1, events.size());

		Event event = events.get(0);
		Assert.assertNotNull(event);
		Assert.assertEquals("video_new", event.getType());
		Assert.assertEquals(Integer.valueOf(168975658), event.getGroupId());
		Assert.assertEquals("4955483c90a79925320074e95d37f296bfc70cb4", event.getEventId());

		EventObject eventObject = event.getObject();
		Assert.assertNotNull(eventObject);

		Assert.assertTrue(eventObject instanceof Video);
		Video video = (Video) eventObject;
		Assert.assertTrue(video.isCanEdit());
		Assert.assertTrue(video.isCanAdd());
		Assert.assertEquals(Integer.valueOf(0), video.getCommentsAmount());
		Assert.assertEquals(Integer.valueOf(1594821406), video.getDate());
		Assert.assertFalse(video.getDescription().isEmpty());
		Assert.assertEquals(Integer.valueOf(314), video.getDuration());
		Assert.assertEquals(Integer.valueOf(456239017), video.getId());
		Assert.assertEquals(Integer.valueOf(-168975658), video.getOwnerId());
		Assert.assertFalse(video.getTitle().isEmpty());
		Assert.assertFalse(video.isFavourite());
		Assert.assertEquals("video", video.getType());
		Assert.assertEquals(Integer.valueOf(1), video.getViews());
		Assert.assertEquals(Integer.valueOf(0), video.getLocalViews());
		Assert.assertEquals("YouTube", video.getPlatform());
	}
}