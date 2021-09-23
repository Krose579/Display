package com.krose;

import com.krose.display.*;
import com.krose.io.Input;
import com.krose.io.Output;

public class App implements Runnable, OnNodeContainerExitListener {
    private static final App instance;

    private static final NodeContainer main;
    private static final MenuNode mainMenu;

    private static final NodeContainer babyInfo;
    private static final IntegerFieldNode babyInfoAge;
    private static final StringFieldNode babyInfoPlaceOfBirth;
    private static final StringFieldNode babyInfoHairColor;

    static {
        instance = new App();

        main = new NodeContainer("main", instance);
        mainMenu = new MenuNode("main_menu", "Main Menu", new String[] { "Enter Info", "Exit" });
        main.addNode(mainMenu);

        babyInfo = new NodeContainer("babyInfo", instance);
        babyInfoAge = new IntegerFieldNode("babyInfo_age", "Age");
        babyInfo.addNode(babyInfoAge);
        babyInfoPlaceOfBirth = new StringFieldNode("babyInfo_placeOfBirth", "Place of Birth");
        babyInfo.addNode(babyInfoPlaceOfBirth);
        babyInfoHairColor = new StringFieldNode("babyInfo_hairColor", "Hair Color");
        babyInfo.addNode(babyInfoHairColor);

        NodeManager manager = NodeManager.createNewInstance(new Input(), new Output());
        manager.addNodeContainer(main);
        manager.addNodeContainer(babyInfo);
    }

    @Override
    public void run() {
        NodeManager.getInstance().start(main);
        NodeManager.getInstance().execute();
    }

    @Override
    public void onNodeContainerExit(String id, ValueContainer values) {
        if (id.equals("main")) {
            if (values.getInteger("main_menu") == 1) {
                NodeManager.getInstance().start(babyInfo);
            }
        } else {
            NodeManager.getInstance().start(main);
        }
    }

    public static void main(String[] args) {
        if (instance != null) instance.run();
    }
}
