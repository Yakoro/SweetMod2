package net.yakoro.sweetmod.screen;

import net.minecraft.screen.ScreenHandlerType;

public class ModScreenHandlers {
    public static ScreenHandlerType<CrusherScreenHandler> CRUSHER_SCREEN_HANDLER;
    public static ScreenHandlerType<CreamerScreenHandler> CREAMER_SCREEN_HANDLER;

    public static void registerAllScreenHandlers() {
        CRUSHER_SCREEN_HANDLER = new ScreenHandlerType<>(CrusherScreenHandler::new);
        CREAMER_SCREEN_HANDLER = new ScreenHandlerType<>(CreamerScreenHandler::new);
    }
}
