package tools.dataintegration.ai4enterprise.entity;

import io.jmix.core.metamodel.datatype.EnumClass;

import org.springframework.lang.Nullable;


public enum ChatItemType implements EnumClass<String> {

    LLM("LLM"),
    USER("User");

    private final String id;

    ChatItemType(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static ChatItemType fromId(String id) {
        for (ChatItemType at : ChatItemType.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}