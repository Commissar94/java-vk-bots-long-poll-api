package parse.response.other;

import api.longpoll.bots.converters.updates.UpdateResponseConverterImpl;
import api.longpoll.bots.model.other.Change;
import api.longpoll.bots.model.other.GroupChangeSettingsEvent;
import api.longpoll.bots.model.events.Event;
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
import java.util.Map;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GroupChangeSettingsParseTest extends AbstractParseTest {
	@Test
	public void test1_likeAdd() throws IOException {
		JsonObject jsonObject = readJson("json/response/group_change_settings/group_change_settings_sample_5_110.json");
		GetEventsResult getEventsResult = new UpdateResponseConverterImpl().convert(jsonObject);
		Assert.assertNotNull(getEventsResult);
		Assert.assertEquals(Integer.valueOf(2644), getEventsResult.getTs());

		List<Event> events = getEventsResult.getEvents();
		Assert.assertNotNull(events);
		Assert.assertEquals(1, events.size());

		Event event = events.get(0);
		Assert.assertNotNull(event);
		Assert.assertEquals("group_change_settings", event.getType());
		Assert.assertEquals(Integer.valueOf(168975658), event.getGroupId());
		Assert.assertEquals("e2a922b60f3002aa5e5098084c971107ec85e61a", event.getEventId());

		EventObject eventObject = event.getObject();
		Assert.assertNotNull(eventObject);

		Assert.assertTrue(eventObject instanceof GroupChangeSettingsEvent);
		GroupChangeSettingsEvent groupChangeSettingsUpdate = (GroupChangeSettingsEvent) eventObject;
		Assert.assertEquals(Integer.valueOf(381980625), groupChangeSettingsUpdate.getUserId());

		Map<String, Change> changes = groupChangeSettingsUpdate.getChanges();
		Assert.assertNotNull(changes);
		Assert.assertFalse(changes.isEmpty());
		Assert.assertTrue(changes.containsKey("description"));

		Change change = changes.get("description");
		Assert.assertNotNull(change);
		Assert.assertEquals("test", change.getOldValue());
		Assert.assertEquals("test1", change.getNewValue());
	}
}