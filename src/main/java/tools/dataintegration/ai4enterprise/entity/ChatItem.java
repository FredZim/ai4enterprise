package tools.dataintegration.ai4enterprise.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.JmixId;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import io.jmix.core.metamodel.annotation.JmixProperty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@JmixEntity(name = "ai4e_ChatItem")
public class ChatItem {
    @InstanceName
    @JmixGeneratedValue
    @JmixId
    private Integer id;

    @JmixProperty(mandatory = true)
    @NotNull
    private String chatItemType;

    @JmixProperty(mandatory = true)
    @NotNull
    private String text;

    @JmixProperty(mandatory = true)
    @NotNull
    private LocalDateTime dateTime;

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ChatItemType getChatItemType() {
        return chatItemType == null ? null : ChatItemType.fromId(chatItemType);
    }

    public void setChatItemType(ChatItemType chatItemType) {
        this.chatItemType = chatItemType == null ? null : chatItemType.getId();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}