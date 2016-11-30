package com.makarevich.command;

import com.makarevich.beans.User;
import com.makarevich.managers.PathManager;

import javax.servlet.http.HttpServletRequest;

public abstract class ActionCommand {

    protected static final PathManager pathManager = PathManager.INSTANCE;

    public abstract boolean checkAccess(User user);

    public abstract String execute(HttpServletRequest request);
}