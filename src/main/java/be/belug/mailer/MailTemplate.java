package be.belug.mailer;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.List;

import static java.util.Collections.singletonList;

public class MailTemplate {

    @JsonProperty("sender")
    private final Sender sender;

    @JsonProperty("replyTo")
    private final Sender replyTo;

    @JsonProperty("to")
    private final List<Receiver> to;

    @JsonProperty("templateId")
    private final int templateId;

    @JsonProperty("tags")
    private final List<String> tags = singletonList("bevestigingsmail");

    @JsonProperty("params")
    private final HashMap<String, Object> params;

    public MailTemplate(Sender sender, Receiver receiver, int templateId, HashMap<String, Object> params) {
        this.sender = sender;
        this.replyTo = sender;
        this.to = singletonList(receiver);
        this.params = params;
        this.templateId = templateId;
    }
}
