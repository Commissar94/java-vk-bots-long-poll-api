package api.longpoll.bots.executors.docs;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.converters.doc.DocsSaveResponseConverterImpl;
import api.longpoll.bots.model.document.DocsSaveResponse;
import api.longpoll.bots.executors.GetExecutor;
import api.longpoll.bots.executors.VkApi;

public class DocsSave extends GetExecutor<DocsSaveResponse> {
	private static final String FILE = "file";
	private static final String TITLE = "title";
	private static final String TAGS = "tags";
	private static final String RETURN_TAGS = "return_tags";

	public DocsSave(LongPollBot bot) {
		super(bot);
	}

	public DocsSave setFile(String file) {
		params.put(FILE, file);
		return this;
	}

	public String getFile(String file) {
		return (String) params.get(FILE);
	}

	public DocsSave setTitle(String title) {
		params.put(TITLE, title);
		return this;
	}

	public String getTitle(String title) {
		return (String) params.get(TITLE);
	}

	public DocsSave setTags(String tags) {
		params.put(TAGS, tags);
		return this;
	}

	public String getTags(String tags) {
		return (String) params.get(TAGS);
	}

	public DocsSave setReturnTags(boolean returnTags) {
		params.put(RETURN_TAGS, returnTags ? 1 : 0);
		return this;
	}

	public boolean getReturnTags(boolean returnTags) {
		return (int) params.get(RETURN_TAGS) == 1;
	}

	@Override
	protected String getApi() {
		return VkApi.Docs.SAVE;
	}

	@Override
	protected JsonToPojoConverter<DocsSaveResponse> getConverter() {
		return new DocsSaveResponseConverterImpl();
	}
}