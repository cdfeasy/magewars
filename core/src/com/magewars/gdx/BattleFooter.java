package com.magewars.gdx;

import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Container;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.WidgetGroup;

public class BattleFooter extends Table {
    Container<WidgetGroup> centralPanel;

    public BattleFooter(Button button, Button button2) {
        add(button);
        add(button2);

    }
}
