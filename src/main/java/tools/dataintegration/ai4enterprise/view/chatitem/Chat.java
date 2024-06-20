package tools.dataintegration.ai4enterprise.view.chatitem;

import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.H5;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.data.renderer.Renderer;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;
import io.jmix.core.LoadContext;
import io.jmix.core.MetadataTools;
import io.jmix.flowui.UiComponents;
import io.jmix.flowui.view.*;
import org.springframework.beans.factory.annotation.Autowired;
import tools.dataintegration.ai4enterprise.entity.ChatItem;
import tools.dataintegration.ai4enterprise.view.main.MainView;

import java.util.Collection;
import java.util.List;

@Route(value = "chat", layout = MainView.class)
@ViewController("ai4e_Chat")
@ViewDescriptor("chat.xml")
@LookupComponent("chatItemsDataGrid")
@DialogMode(width = "50em")
public class Chat extends StandardListView<ChatItem> {

    @Install(to = "chatItemsDl", target = Target.DATA_LOADER)
    protected List<ChatItem> chatItemsDlLoadDelegate(LoadContext<ChatItem> loadContext) {
        // Here you can load entities from an external storage.
        // Set the loaded entities to the not-new state using EntityStates.setNew(entity, false).
        return List.of();
    }

    @Install(to = "chatItemsDataGrid.remove", subject = "delegate")
    private void chatItemsDataGridRemoveDelegate(final Collection<ChatItem> collection) {
        for (ChatItem entity : collection) {
            // Here you can remove entities from an external storage
        }
    }

    @Autowired
    protected UiComponents uiComponents;
    @Autowired
    protected MetadataTools metadataTools;

    @Supply(to = "chatList", subject = "renderer")
    protected Renderer<ChatItem> virtualListRenderer() {
        return new ComponentRenderer<>(chatItem -> {
            VerticalLayout infoLayout = createVerticalLayout();
            infoLayout.addClassNames(LumoUtility.Padding.Vertical.SMALL, LumoUtility.Gap.SMALL);

            H4 customerName = new H4(chatItem.getChatItemType().name());
            Span gradeSpan = createGradeSpan(customer.getGrade());
            infoLayout.add(customerName, gradeSpan);

            HorizontalLayout infoLine = createHorizontalLayout();
            infoLine.addClassName(LumoUtility.AlignItems.CENTER);

            H5 emailLabel = new H5("Email:");
            Span email = new Span(customer.getEmail());
            infoLine.add(emailLabel, email);

            HorizontalLayout infoLine2 = createHorizontalLayout();

            H5 ageLabel = new H5("Age:");
            Span age = new Span(String.valueOf(customer.getAge()));

            infoLine2.add(ageLabel, age);

            VerticalLayout additionalInfoLayout = createVerticalLayout();
            additionalInfoLayout.add(infoLine, infoLine2);

            JmixDetails infoDetails = uiComponents.create(JmixDetails.class);
            infoDetails.setSummaryText("Additional information");
            infoDetails.setContent(additionalInfoLayout);

            infoLayout.add(infoDetails, new Hr());
            return infoLayout;
        });
    }

    protected VerticalLayout createVerticalLayout() {
        VerticalLayout layout = uiComponents.create(VerticalLayout.class);
        layout.setSpacing(false);
        layout.setPadding(false);
        return layout;
    }

    protected HorizontalLayout createHorizontalLayout() {
        HorizontalLayout layout = uiComponents.create(HorizontalLayout.class);
        layout.setPadding(false);
        return layout;
    }

}
