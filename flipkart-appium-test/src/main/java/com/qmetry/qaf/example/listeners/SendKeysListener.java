package com.qmetry.qaf.example.listeners;

import org.openqa.selenium.remote.DriverCommand;

import com.qmetry.qaf.automation.ui.webdriver.CommandTracker;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElementCommandAdapter;

public class SendKeysListener extends QAFWebElementCommandAdapter {
    @Override
    public void beforeCommand(QAFExtendedWebElement element, CommandTracker commandTracker) {
        if (commandTracker.getCommand().equalsIgnoreCase(DriverCommand.SEND_KEYS_TO_ELEMENT)) {
            element.clear();
        }
    }
}
