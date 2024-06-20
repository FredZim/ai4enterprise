package tools.dataintegration.ai4enterprise.view.chatitem;

import com.vaadin.flow.router.Route;
import io.jmix.core.LoadContext;
import io.jmix.core.SaveContext;
import io.jmix.flowui.view.*;
import tools.dataintegration.ai4enterprise.entity.ChatItem;
import tools.dataintegration.ai4enterprise.view.main.MainView;

import java.util.Set;

@Route(value = "chatItems/:id", layout = MainView.class)
@ViewController("ai4e_ChatItem.detail")
@ViewDescriptor("chat-item-detail-view.xml")
@EditedEntityContainer("chatItemDc")
public class ChatItemDetailView extends StandardDetailView<ChatItem> {

    @Install(to = "chatItemDl", target = Target.DATA_LOADER)
    private ChatItem customerDlLoadDelegate(final LoadContext<ChatItem> loadContext) {
        Object id = loadContext.getId();
        // Here you can load the entity by id from an external storage.
        // Set the loaded entity to the not-new state using EntityStates.setNew(entity, false).
        return null;
    }

    @Install(target = Target.DATA_CONTEXT)
    private Set<Object> saveDelegate(final SaveContext saveContext) {
        ChatItem entity = getEditedEntity();
        // Here you can save the entity to an external storage and return the saved instance.
        // Set the returned entity to the not-new state using EntityStates.setNew(entity, false).
        // If the new entity ID is assigned by the storage, set the ID to the original instance too 
        // to let the framework match the saved instance with the original one.
        ChatItem saved = entity;
        return Set.of(saved);
    }
}
