package net.blay09.mods.trashslot.compat;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.gui.handlers.IGlobalGuiHandler;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import net.blay09.mods.trashslot.TrashSlot;
import net.blay09.mods.trashslot.client.TrashSlotGuiHandler;
import net.blay09.mods.trashslot.client.gui.GuiTrashSlot;
import net.minecraft.client.renderer.Rectangle2d;
import net.minecraft.util.ResourceLocation;

import java.util.Collection;
import java.util.Collections;

@JeiPlugin
public class JEIAddon implements IModPlugin {

    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation("trashslot", "trashslot");
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addGlobalGuiHandler(new IGlobalGuiHandler() {
            @Override
            public Collection<Rectangle2d> getGuiExtraAreas() {
                GuiTrashSlot slot = TrashSlot.trashSlotGui.map(TrashSlotGuiHandler::getGuiTrashSlot).orElse(null);
                return slot != null && slot.isVisible() ? Collections.singletonList(slot.getRectangle()) : Collections.emptyList();
            }
        });
    }

}
